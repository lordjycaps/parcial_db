package com.example.parcial_bd.Repository

import com.example.parcial_bd.DAO.AutorDAO
import com.example.parcial_bd.Model.Autor

class AutorRepository(private val autorDao: AutorDAO) {
    suspend fun insert(autor: Autor) {
        autorDao.insert(autor)
    }

    suspend fun getAllAutores(): List<Autor> {
        return autorDao.getAllAutores()
    }

    suspend fun deleteById(autorId: Int): Int {
        return autorDao.deleteById(autorId)
    }

    suspend fun update(autor: Autor): Int {
        return autorDao.update(autor)
    }
}