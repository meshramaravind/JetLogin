package com.arvind.jetlogin.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor():
ViewModel(){
    private val _useremaiormobileText = mutableStateOf("")
    val useremailormobileText: State<String> = _useremaiormobileText

    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText

    private val _confirmpasswordText = mutableStateOf("")
    val confirmpasswordText: State<String> = _confirmpasswordText

    fun setUsernameText(username: String) {
        _useremaiormobileText.value = username
    }

    fun setPasswordText(password: String) {
        _passwordText.value = password
    }

    fun setConfirmPasswordText(confirmpassword: String) {
        _confirmpasswordText.value = confirmpassword
    }
}