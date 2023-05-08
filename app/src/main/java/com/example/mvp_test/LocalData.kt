package com.example.mvp_test

import android.content.Context
import org.json.JSONObject

class LocalData(context: Context) : DataSource {
    private val sharedPreference = context.getSharedPreferences("data", Context.MODE_PRIVATE)
    private val editor = sharedPreference.edit()

    override fun getData(callback: DataSource.LoadInfoCallBack) {
        val data = sharedPreference.getString("data", null)

        if(!data.isNullOrEmpty())
            callback.onSuccess(JSONObject(data))
        else
            callback.onFailed()
    }

    override fun saveData(data: JSONObject) {
        editor.putString("data", data.toString())
        editor.commit()
    }
}