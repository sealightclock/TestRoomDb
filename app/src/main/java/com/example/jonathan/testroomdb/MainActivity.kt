package com.example.jonathan.testroomdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.jonathan.testroomdb.ui.theme.TestRoomDbTheme
import com.example.jonathan.testroomdb.view.UserScreen
import com.example.jonathan.testroomdb.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TestRoomDbTheme {
                UserScreen(
                    viewModel = viewModel
                )
            }
        }

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        viewModel.fetchUsers()
    }
}
