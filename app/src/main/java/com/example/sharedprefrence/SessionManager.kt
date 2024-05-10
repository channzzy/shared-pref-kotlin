package com.example.sharedprefrence

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context : Context) {
    var sharedPreferences : SharedPreferences? = null
    var editor : SharedPreferences.Editor? = null

    //key shared pref
    val keyPreferences = "login"
    val namePreferences = "name"
    val passwordPreferences = "password"

    init {
        sharedPreferences = context.getSharedPreferences(keyPreferences, Context.MODE_PRIVATE)
        editor = sharedPreferences?.edit()
    }

    fun sessionLogin(name:String,password:String){
        editor?.putString(namePreferences,name)
        editor?.putString(passwordPreferences,password)
        editor?.apply()
    }

    fun sessionLogout(){
        editor?.remove(namePreferences)
        editor?.remove(passwordPreferences)
        editor?.apply()
    }

    //validation
    val name:String? get() = sharedPreferences?.getString(namePreferences,null)
    val password:String? get() = sharedPreferences?.getString(passwordPreferences,null)

    fun isLogin() : Boolean{
        if(!name.isNullOrEmpty() && !password.isNullOrEmpty()){
            return true
        }
        return false
    }
}