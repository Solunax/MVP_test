package com.example.mvp_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mvp_test.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity(), Contract.View {
    private lateinit var presenter: Presenter
    private lateinit var repository: Repository
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = Repository(this)
        presenter = Presenter(this, repository)

        val button = binding.button
        val name = binding.name
        val email = binding.email

        presenter.init()

        button.setOnClickListener {
            if(name.text.toString().isEmpty())
                Toast.makeText(this, "이름을 입력하세요", Toast.LENGTH_SHORT).show()
            else if(email.text.toString().isEmpty())
                Toast.makeText(this, "이메일을 입력하세요", Toast.LENGTH_SHORT).show()
            else{
                val data = JSONObject()

                data.put("name", name.text.toString())
                data.put("email", email.text.toString())

                name.text.clear()
                email.text.clear()

                presenter.setData(data)
                presenter.saveData(data)
            }
        }
    }

    override fun showData(data: JSONObject) {
        binding.saveName.text = data.getString("name")
        binding.saveEmail.text = data.getString("email")
    }
}