package com.khun.animalkingdomexplorer.data.repository

import androidx.lifecycle.LiveData
import com.khun.animalkingdomexplorer.data.dao.AnimalDao
import com.khun.animalkingdomexplorer.data.model.Animal

class AnimalRepository(private val animalDao: AnimalDao) {

    val allAnimals: LiveData<List<Animal>> = animalDao.getAllAnimals()

    suspend fun saveAnimal(animal: Animal) {
        animalDao.saveAnimal(animal)
    }
}