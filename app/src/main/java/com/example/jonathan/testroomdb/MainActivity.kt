package com.example.jonathan.testroomdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jonathan.testroomdb.model.DatabaseBuilder
import com.example.jonathan.testroomdb.ui.theme.TestRoomDbTheme
import com.example.jonathan.testroomdb.view.UserScreen
import com.example.jonathan.testroomdb.viewmodel.UserViewModel
import com.example.jonathan.testroomdb.viewmodel.UserViewModelFactory

class MainActivity : ComponentActivity() {
    // Specify ViewModel:
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TestRoomDbTheme {
                UserScreen(
                    viewModel = viewModel // Use ViewModel here
                )
            }
        }

        // Initialize ViewModel:
        viewModel = UserViewModelFactory(DatabaseBuilder.getInstance(this)).create(UserViewModel::class.java)
    }
}
