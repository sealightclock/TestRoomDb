package com.example.jonathan.testroomdb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jonathan.testroomdb.model.AppDatabase
import com.example.jonathan.testroomdb.model.User
import kotlinx.coroutines.launch

class UserViewModel(private val database: AppDatabase) : ViewModel() {

    fun addUser(name: String, age: Int) {
        viewModelScope.launch {
            database.userDao().insertUser(User(name = name, age = age))
        }
    }

    suspend fun fetchUsers(): List<User> {
        return database.userDao().getAllUsers()
    }
}
