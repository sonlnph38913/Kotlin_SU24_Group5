package com.example.kotlin_su24_group5.DataUser

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.kotlin_su24_group5.DataUser.AppDatabase
import com.example.kotlin_su24_group5.DataUser.User
import com.example.kotlin_su24_group5.DataUser.UserDao
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val db: AppDatabase = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "user-database"
    ).build()
    private val userDao: UserDao = db.userDao()

    fun registerUser(username: String, password: String) {
        val user = User(username = username, password = password)
        viewModelScope.launch {
            userDao.insert(user)
        }
    }

    fun loginUser(username: String, password: String, onResult: (User?) -> Unit) {
        viewModelScope.launch {
            val user = userDao.getUser(username, password)
            onResult(user)
        }
    }
}