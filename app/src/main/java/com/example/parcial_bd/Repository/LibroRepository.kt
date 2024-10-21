package com.example.parcial_bd.Repository

import com.example.parcial_bd.DAO.LibroDAO
import com.example.parcial_bd.Model.Libro


class LibroRepository(private val libroDao: LibroDAO) {
    suspend fun insert(libro: Libro) {
        libroDao.insertLibro(libro)
    }

    suspend fun getAllLibros(): List<Libro> {
        return libroDao.getAllLibrosConAutores()
    }

    suspend fun deleteById(libroId: Int): Int {
        return libroDao.deleteById(libroId)
    }

    suspend fun update(libro: Libro): Int {
        return libroDao.update(libro)
    }
}
