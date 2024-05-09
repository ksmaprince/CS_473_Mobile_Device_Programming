package com.khun.animalkingdomexplorer.ui.animaldetails

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khun.animalkingdomexplorer.data.database.AnimalKingdomDatabase
import com.khun.animalkingdomexplorer.data.model.Animal
import com.khun.animalkingdomexplorer.data.repository.AnimalRepository
import kotlinx.coroutines.launch

class AnimalViewModel(context: Context) : ViewModel() {
    val allAnimals: LiveData<List<Animal>>
    private val repository: AnimalRepository

    init {
        val dao = AnimalKingdomDatabase.invoke(context).getAnimalDao()
        repository = AnimalRepository(dao)
        allAnimals = repository.allAnimals
    }

    fun saveAnimal(animal: Animal) {
        viewModelScope.launch {
            repository.saveAnimal(animal)
        }
    }
}