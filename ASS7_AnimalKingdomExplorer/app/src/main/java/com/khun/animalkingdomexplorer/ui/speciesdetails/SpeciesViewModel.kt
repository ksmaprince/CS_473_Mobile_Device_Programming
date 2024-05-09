package com.khun.animalkingdomexplorer.ui.speciesdetails

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khun.animalkingdomexplorer.data.database.AnimalKingdomDatabase
import com.khun.animalkingdomexplorer.data.model.Species
import com.khun.animalkingdomexplorer.data.repository.SpeciesRepository
import kotlinx.coroutines.launch

class SpeciesViewModel(context: Context) : ViewModel() {

    val allSpecies: LiveData<List<Species>>
    private val repository: SpeciesRepository

    init {
        val dao = AnimalKingdomDatabase.invoke(context).getSpeciesDao()
        repository = SpeciesRepository(dao)
        allSpecies = repository.allSpicies
    }

    fun saveSpecies(species: Species) {
        viewModelScope.launch {
            repository.saveSpecies(species)
        }
    }

}