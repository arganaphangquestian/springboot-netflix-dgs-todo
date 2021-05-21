package dev.argana.todo

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument

@Suppress("unused")
@DgsComponent
class TodoFetcher constructor(val todoRepsoitory: TodoRepository) {

    @DgsQuery
    fun todos(): List<Todo> = todoRepsoitory.findAll()

    @DgsQuery
    fun todoId(@InputArgument id: Int): Todo? = todoRepsoitory.findById(id).orElse(null)

    @DgsMutation
    fun addTodo(@InputArgument todo: InputTodo): Todo {
        return todoRepsoitory.save(Todo(title = todo.title, body = todo.body, isDone = todo.isDone))
    }

    data class InputTodo(
        var title: String,
        var body: String,
        var isDone: Boolean
    )
}