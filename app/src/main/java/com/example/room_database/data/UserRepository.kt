package com.example.room_database.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDAO) {
    val readAll: LiveData<List<User>> = userDao.readAllData()
    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}