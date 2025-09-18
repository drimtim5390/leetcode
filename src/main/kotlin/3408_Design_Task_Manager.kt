import java.util.PriorityQueue

class TaskManager(tasks: List<List<Int>>) {

    private data class Task(
        val userId: Int,
        val taskId: Int,
        val priority: Int,
        var active: Boolean = true
    )

    private val pq = PriorityQueue(
        compareByDescending<Task> { it.priority }
            .thenByDescending { it.taskId }
    )

    private val idToTask = mutableMapOf<Int, Task>()

    init {
        tasks.forEach { (userId, taskId, priority) ->
            add(userId, taskId, priority)
        }
    }

    fun add(userId: Int, taskId: Int, priority: Int) {
        idToTask.remove(taskId)?.let { it.active = false }

        val task = Task(userId, taskId, priority)
        idToTask[taskId] = task
        pq.add(task)
    }

    fun edit(taskId: Int, newPriority: Int) {
        val old = idToTask[taskId] ?: return
        old.active = false
        val updated = Task(old.userId, taskId, newPriority)
        idToTask[taskId] = updated
        pq.add(updated)
    }

    fun rmv(taskId: Int) {
        idToTask.remove(taskId)?.active = false
    }

    fun execTop(): Int {
        while (true) {
            val top = pq.poll() ?: return -1
            if (top.active) {
                top.active = false
                idToTask.remove(top.taskId)
                return top.userId
            }
        }
    }
}