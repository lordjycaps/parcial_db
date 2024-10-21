package com.example.parcial_bd.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parcial_bd.DAO.LibroDAO
import com.example.parcial_bd.Model.Autor
import com.example.parcial_bd.Model.Libro

@Database(entities = [Libro::class, Autor::class], version = 1, exportSchema = false)
abstract class LibroDatabase : RoomDatabase() {

    abstract fun libroDao(): LibroDAO

    companion object {
        @Volatile
        private var INSTANCE: LibroDatabase? = null

        fun getDatabase(context: Context): LibroDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LibroDatabase::class.java,
                    "libro_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}