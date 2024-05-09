package com.khun.animalkingdomexplorer.data.repository

import androidx.lifecycle.LiveData
import com.khun.animalkingdomexplorer.data.dao.SpeciesDao
import com.khun.animalkingdomexplorer.data.model.Species

class SpeciesRepository(private val speciesDao: SpeciesDao) {

    val allSpicies: LiveData<List<Species>> = speciesDao.getAllSpecies()

    suspend fun saveSpecies(species: Species) {
        speciesDao.insertSpecies(species)
    }

    fun getSpeciesById(speciesId: Int): LiveData<Species> = speciesDao.getSpeciesById(speciesId)

}