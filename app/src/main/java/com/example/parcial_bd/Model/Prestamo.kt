package com.example.parcial_bd.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "prestamos",
    foreignKeys = [
        ForeignKey(
            entity = Miembro::class,
            parentColumns = ["id"],  // Asegúrate de que la entidad Miembro tiene una columna 'id'
            childColumns = ["miembro_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Libro::class,
            parentColumns = ["libros_id"], // Cambiado de 'id' a 'libros_id'
            childColumns = ["libro_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["miembro_id"]),
        Index(value = ["libro_id"])
    ]
)
data class Prestamo(
    @PrimaryKey(autoGenerate = true) val prestamo_id: Int = 0,
    val libro_id: Int,
    val miembro_id: Int,
    val fecha_prestamo: String,
    val fecha_devolucion: String,
)