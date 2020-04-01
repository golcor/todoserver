package todoappbackend.todoserver.todolist

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ToDoListCrudServiceTest {
    @Test
    fun shouldGetToDoListFromRepo() {
        val expectedToDoLists = listOf(ToDoList("some name"))
        val repo: ToDoListRepo = mockk()
        val toDoListService = ToDoListCrudService(repo)
        every { repo.findAll() } returns expectedToDoLists

        val toDoLists = toDoListService.getToDoLists()

        assertThat(toDoLists).isEqualTo(expectedToDoLists)
    }
}
