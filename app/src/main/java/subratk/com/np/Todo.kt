package subratk.com.np

data class Todo(
    val id: Int,
    val title: String,
    val description: String = "",
    val isDone: Boolean = false
)