package com.example.mvp_test

import org.json.JSONObject

interface Contract {
    interface View{
        fun showData(data : JSONObject)
    }

    interface Presenter{
        fun init()
        fun setData(data : JSONObject)
        fun saveData(data : JSONObject)
    }
}