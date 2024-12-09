package com.example.jonathan.testroomdb.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jonathan.testroomdb.model.User
import com.example.jonathan.testroomdb.viewmodel.UserViewModel

@Composable
fun UserScreen(viewModel: UserViewModel) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var users by remember { mutableStateOf(emptyList<User>()) }

    Column(Modifier.padding(16.dp)) {
        BasicTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            singleLine = true
        )
        BasicTextField(
            value = age,
            onValueChange = { age = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            singleLine = true
        )
        Button(onClick = {
            viewModel.addUser(name, age.toIntOrNull() ?: 0)
        }) {
            Text("Add User")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            //users = viewModel.fetchUsers()
        }) {
            Text("Load Users")
        }
        Spacer(modifier = Modifier.height(16.dp))
        users.forEach {
            Text("${it.name}, ${it.age}")
        }
    }
}
