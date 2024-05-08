package com.khun.animalkingdomexplorer.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.khun.animalkingdomexplorer.data.model.Animal

@Dao
interface AnimalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAnimal(animal: Animal)

    @Query("SELECT * FROM animals")
    fun getAllAnimals(): LiveData<List<Animal>>
}