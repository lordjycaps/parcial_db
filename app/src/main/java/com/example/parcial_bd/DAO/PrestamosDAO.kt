package com.example.parcial_bd.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.parcial_bd.Model.Prestamo


@Dao

interface PrestamoDAO {

    // Insertar un nuevo préstamo
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPrestamo(prestamo: Prestamo)

    // Obtener todos los préstamos
    @Query("SELECT * FROM prestamos")
    suspend fun getAllPrestamos(): List<Prestamo>

    // Obtener préstamos por miembro
    @Query("SELECT * FROM prestamos WHERE miembro_id = :miembroId")
    suspend fun getPrestamosByMiembro(miembroId: Int): List<Prestamo>

    // Obtener préstamos por libro
    @Query("SELECT * FROM prestamos WHERE libro_id = :libroId")
    suspend fun getPrestamosByLibro(libroId: Int): List<Prestamo>

    // Eliminar un préstamo
    @Delete
    suspend fun deletePrestamo(prestamo: Prestamo)
}