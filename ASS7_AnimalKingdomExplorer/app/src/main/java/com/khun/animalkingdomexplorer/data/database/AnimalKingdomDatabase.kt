package com.khun.animalkingdomexplorer.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.khun.animalkingdomexplorer.data.dao.AnimalDao
import com.khun.animalkingdomexplorer.data.dao.SpeciesDao
import com.khun.animalkingdomexplorer.data.model.Animal
import com.khun.animalkingdomexplorer.data.model.Species

@Database(entities = [Animal::class, Species::class], version = 1)
abstract class AnimalKingdomDatabase : RoomDatabase() {
    abstract fun getAnimalDao(): AnimalDao
    abstract fun getSpeciesDao(): SpeciesDao

    companion object {
        @Volatile
        private var instance: AnimalKingdomDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AnimalKingdomDatabase::class.java,
            "animal_kingdom_db"
        ).build()
    }
}