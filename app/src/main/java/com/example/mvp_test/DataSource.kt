package com.example.mvp_test

import org.json.JSONObject

interface DataSource {
    interface LoadInfoCallBack{
        fun onSuccess(data : JSONObject)
        fun onFailed()
    }

    fun getData(callback : LoadInfoCallBack)
    fun saveData(data : JSONObject)
}