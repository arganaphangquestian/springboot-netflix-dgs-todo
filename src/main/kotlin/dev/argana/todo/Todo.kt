package dev.argana.todo

import javax.persistence.*

@Entity
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0,
    @Column(name = "title")
    var title: String = "",
    @Column(name = "body")
    var body: String = "",
    @Column(name = "isDone")
    var isDone: Boolean = false
)