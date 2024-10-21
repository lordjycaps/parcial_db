package com.example.parcial_bd.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "libros",
    foreignKeys = [
        ForeignKey(
            entity = Autor::class,
            parentColumns = ["id"],
            childColumns = ["autor_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["autor_id"])]
)
data class Libro(
    @PrimaryKey(autoGenerate = true)
    val libros_id: Int = 0,
    val autor_id: Int = 0,
    val genero: String = "",
    val fecha_devolucion: String
)
