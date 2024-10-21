package com.example.parcial_bd.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial_bd.DAO.UserDAO
import com.example.parcial_bd.Database.UserDatabase
import com.example.parcial_bd.Model.User
import com.example.parcial_bd.Repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userRepository: UserRepository
    private val userDAO: UserDAO

    init {
        val db = UserDatabase.getDatabase(application)
        userDAO = db.userDao()
        userRepository = UserRepository(userDAO)
    }

    // Función para insertar un usuario, por ejemplo
    fun insertUser(user: User) {
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }

    // Otras funciones relacionadas con usuarios
}
