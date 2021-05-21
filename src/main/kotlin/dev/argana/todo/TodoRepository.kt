package dev.argana.todo

import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Int>