package com.example.todo_p1_p2.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo_p1_p2.ui.theme.ToDo_p1_p2Theme
import com.example.todo_p1_p2.viewmodel.Todo
import com.example.todo_p1_p2.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDo_p1_p2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Todoscreen()
                }
            }
        }
    }
}


@Composable
fun Todoscreen(todoViewModel: TodoViewModel = viewModel()) {
    val todos by todoViewModel.todos.observeAsState(emptyList())

        TodoList(todos)

}



@Composable
fun TodoList(todos: List<Todo>) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(todos) {todo ->
            Text(text = todo.title, modifier = Modifier.padding(top = 4.dp, bottom = 4.dp))
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }


}
