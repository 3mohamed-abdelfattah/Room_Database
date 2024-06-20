package com.example.room_database.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(applicaton: Application) : AndroidViewModel(applicaton) {
    private val readAllData: LiveData<List<User>>
    private val repository: UserRepository


    init {
        val userDAO = UserDatabase.getDatabase(applicaton).userDao()
        repository = UserRepository(userDAO)
        readAllData = repository.readAll
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}


