
package com.example.api_bc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import com.example.api_bc.models.User
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.api_bc.services.BusinessCaseUserService
import com.example.api_bc.services.UserService
import com.example.api_bc.ui.theme.API_BCTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            API_BCTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val userService: UserService = BusinessCaseUserService()
                    val coroutineScope = rememberCoroutineScope()
                    var repos by remember {
                        mutableStateOf<List<User>>(emptyList())
                    }
                    if (repos.isEmpty()) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(onClick = {
                                coroutineScope.launch {
                                    repos = userService.fetchUsers()
                                }
                            }) {
                                Text(text = "Fetch repositories")
                            }
                        }
                    } else {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(repos) { user ->
                                Text(text = user.email)
                            }
                        }
                    }
                }
            }
        }
    }
}
