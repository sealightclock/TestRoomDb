package com.example.jonathan.testroomdb.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jonathan.testroomdb.model.AppDatabase
import com.example.jonathan.testroomdb.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "TRDB: UserViewModel"

class UserViewModel(private val database: AppDatabase) : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    fun addUser(name: String, age: Int) {
        if (name.isBlank()) {
            Log.e(TAG, "Name is blank. Please correct this !")
            return
        }
        if (age <= 0) {
            Log.e(TAG, "Age is smaller than 1. Please correct this !")
            return
        }

        viewModelScope.launch (Dispatchers.IO) {
            database.userDao().insertUser(User(name = name, age = age))
        }
    }

    fun fetchUsers() {
        viewModelScope.launch (Dispatchers.IO) {
            // Do not user setValue() here.
            _users.postValue(database.userDao().getAllUsers())
        }
    }
}
