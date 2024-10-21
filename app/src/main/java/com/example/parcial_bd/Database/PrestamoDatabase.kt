package com.example.parcial_bd.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parcial_bd.DAO.LibroDAO
import com.example.parcial_bd.DAO.MiembroDAO
import com.example.parcial_bd.DAO.PrestamoDAO
import com.example.parcial_bd.Model.Autor
import com.example.parcial_bd.Model.Libro
import com.example.parcial_bd.Model.Miembro
import com.example.parcial_bd.Model.Prestamo

@Database(entities = [Libro::class, Autor::class, Miembro::class, Prestamo::class], version = 1)
abstract class PrestamoDatabase : RoomDatabase() {

    abstract fun prestamoDao(): PrestamoDAO
    abstract fun miembroDao(): MiembroDAO
    abstract fun libroDao(): LibroDAO

    companion object {
        @Volatile
        private var INSTANCE: PrestamoDatabase? = null

        fun getDatabase(context: Context): PrestamoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PrestamoDatabase::class.java,
                    "prestamo_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}