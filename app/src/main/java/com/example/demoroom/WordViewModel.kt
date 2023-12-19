package com.example.demoroom

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.demoroom.data.model.Word
import com.example.demoroom.data.repository.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(private val repository:WordRepository):ViewModel() {
    val allWords:LiveData<List<Word>> =repository.allWords.asLiveData()

    fun insert(word: Word)=viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }

    class WordViewModelFactory(private val repository: WordRepository):ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(WordViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return WordViewModel(repository)as T
            }
            throw IllegalAccessException("Unknown ViewModel class")
        }
    }
}