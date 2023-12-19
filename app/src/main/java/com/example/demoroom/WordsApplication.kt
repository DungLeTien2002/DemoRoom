package com.example.demoroom

import android.app.Application
import com.example.demoroom.data.db.WordRoomDatabase
import com.example.demoroom.data.repository.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy {
        WordRoomDatabase.getDatabase(this, applicationScope)
    }
    val repository by lazy {
        WordRepository(database.wordDao())
    }
}