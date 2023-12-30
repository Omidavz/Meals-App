package com.example.mealsapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealsapp.model.MealsRepository
import com.example.mealsapp.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository.getInstance()) :
    ViewModel() {



        init {

            viewModelScope.launch(Dispatchers.IO) {
                val meals = getMeals()
                mealsState.value = meals

            }

        }
    val mealsState : MutableState<List<MealResponse>> =
        mutableStateOf(emptyList<MealResponse>())




    suspend fun getMeals() : List<MealResponse>{
        return repository.getMeals().categories
    }
}