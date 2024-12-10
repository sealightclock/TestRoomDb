package com.example.jonathan.testroomdb.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jonathan.testroomdb.viewmodel.UserViewModel

@Composable
fun UserScreen(viewModel: UserViewModel) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    //var users by remember { mutableStateOf(emptyList<User>()) }
    val users by viewModel.users.observeAsState(emptyList())

    Column(
        Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Please enter user name:")
        BasicTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            singleLine = true
        )
        Text("Please enter user's age:")
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
            viewModel.fetchUsers()
        }) {
            Text("Load Users")
        }
        Spacer(modifier = Modifier.height(16.dp))
        users.forEach {
            Text("user_${it.id}: Name: ${it.name}, Age: ${it.age}")
        }
    }
}
