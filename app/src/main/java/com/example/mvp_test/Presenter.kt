package com.example.mvp_test

import org.json.JSONObject

class Presenter(val view : Contract.View, val repository: Repository) : Contract.Presenter {
    override fun init() {
        repository.getData(object : DataSource.LoadInfoCallBack{
            override fun onSuccess(data: JSONObject) {
                view.showData(data)
            }

            override fun onFailed() {

            }
        })
    }

    override fun setData(data : JSONObject) {
        view.showData(data)
    }

    override fun saveData(data : JSONObject) {
        repository.saveData(data)
    }
}