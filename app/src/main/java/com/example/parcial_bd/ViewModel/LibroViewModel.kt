package com.example.parcial_bd.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial_bd.Model.Libro
import com.example.parcial_bd.Model.Autor
import com.example.parcial_bd.Repository.LibroRepository
import kotlinx.coroutines.launch

class LibroViewModel(private val libroRepository: LibroRepository) : ViewModel() {

    fun insertLibro(libro: Libro) {
        viewModelScope.launch {
            libroRepository.insert(libro)
        }
    }

    fun insertAutor(autor: Autor) {
        viewModelScope.launch {
            libroRepository.insertAutor(autor)
        }
    }
}
