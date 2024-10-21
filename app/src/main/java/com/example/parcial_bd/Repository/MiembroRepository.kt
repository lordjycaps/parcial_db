package com.example.parcial_bd.Repository

import com.example.parcial_bd.DAO.MiembroDAO
import com.example.parcial_bd.Model.Miembro

class MiembroRepository(private val miembroDao: MiembroDAO) {
    suspend fun insert(miembro: Miembro) {
        miembroDao.insert(miembro)
    }

    suspend fun getAllMiembros(): List<Miembro> {
        return miembroDao.getAllMiembros()
    }

    suspend fun deleteById(miembroId: Int): Int {
        return miembroDao.deleteById(miembroId)
    }

    suspend fun update(miembro: Miembro): Int {
        return miembroDao.update(miembro)
    }
}
