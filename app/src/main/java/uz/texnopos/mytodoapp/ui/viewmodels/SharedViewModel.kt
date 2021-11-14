package uz.texnopos.mytodoapp.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.texnopos.mytodoapp.data.models.ToDoTask
import uz.texnopos.mytodoapp.data.repository.ToDoRepository
import uz.texnopos.mytodoapp.util.SearchAppBarState
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repo: ToDoRepository
) : ViewModel() {

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)

    val searchTextState: MutableState<String> = mutableStateOf("")


    private val _allTasks = MutableStateFlow<List<ToDoTask>>(emptyList())
    val allTasks get() = _allTasks

    fun getAllTasks() = viewModelScope.launch {
        repo.getAllTasks.collect { _allTasks.value = it }
    }
}