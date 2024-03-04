package com.example.todo_p1_p2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class TodoViewModel: ViewModel() {
    /*var todos = mutableListOf<Todo>()
        private set */
    private val _todos = MutableLiveData<List<Todo>>()
    val todos: LiveData<List<Todo>> get() = _todos

    init {
        getTodosList()
    }

    /*private fun getTodosList() {
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi!!.getInstance()
                todos.clear()
                todos.addAll(todosApi.getTodos())
                Log.d("TODOVIEWMODEL", "$todos")
            } catch (e: Exception) {
                Log.d("TODOVIEWMODEL", e.message.toString())
            }
        }
    }*/

    private fun getTodosList() {
        viewModelScope.launch {
            try {
                val todosApi = TodosApi.getInstance()
                _todos.value = todosApi.getTodos()
            } catch (e: Exception) {
                Log.e("TODOVIEWMODEL", "Error fetching todos: ${e.message}", e)
            }
        }
    }

}