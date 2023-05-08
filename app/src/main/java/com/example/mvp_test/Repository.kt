package com.example.mvp_test

import android.content.Context
import org.json.JSONObject

class Repository(context: Context) : DataSource {
    private val dataSource = LocalData(context)

    override fun getData(callback: DataSource.LoadInfoCallBack) {
        dataSource.getData(callback)
    }

    override fun saveData(data: JSONObject) {
        dataSource.saveData(data)
    }
}