package com.khun.animalkingdomexplorer.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.khun.animalkingdomexplorer.data.model.Species

@Dao
interface SpeciesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSpecies(species: Species)

    @Query("SELECT * FROM species")
    fun getAllSpecies(): LiveData<List<Species>>

    @Query("SELECT * FROM species WHERE id =:speciesId")
    fun getSpeciesById(speciesId: Int): LiveData<Species>

}