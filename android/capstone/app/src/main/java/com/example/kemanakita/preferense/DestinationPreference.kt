package com.example.kemanakita.preferense

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DestinationPreference private constructor(private val dataStore: DataStore<Preferences>){

    private val deskripsi = stringPreferencesKey("description_key")

    fun getDescription():Flow<String>{
        return dataStore.data.map { preferences ->
            preferences[deskripsi]?:""
        }
    }
    suspend fun saveDescription(description:String){
        dataStore.edit { preferences->
            preferences[deskripsi]=description
        }
    }
    suspend fun removeDescription(){
        dataStore.edit { preferences->
            preferences.clear()
        }
    }
    companion object{
        @Volatile
        private var INSTANCE: DestinationPreference?= null

        fun getInstance(dataStore: DataStore<Preferences>): DestinationPreference {
            return INSTANCE ?: synchronized(this) {
                val instance = DestinationPreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}