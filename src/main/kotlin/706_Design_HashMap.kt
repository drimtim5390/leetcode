import java.util.Random

fun main() {
    val key = Random().nextInt()
    val value = Random().nextInt()

    var obj = MyHashMap()
    obj.put(key, value)
    var param_2 = obj.get(key)
    obj.remove(key)
}

private class MyHashMap() {
    class LinkedNode(val key: Int, var value: Int) {
        var next: LinkedNode? = null
    }

    val bucketsSize = 2048

    val buckets = Array(bucketsSize) { LinkedNode(0, 0) }

    fun put(key: Int, value: Int) {
        val index = calcIndex(key)
        var bucket = buckets[index]
        while (bucket.next != null) {
            if (bucket.next!!.key == key) {
                bucket.next!!.value = value
                return
            }
            bucket = bucket.next!!
        }
        bucket.next = LinkedNode(key, value)
    }

    fun get(key: Int): Int {
        val index = calcIndex(key)
        var bucket = buckets[index]
        while (bucket.next != null) {
            if (bucket.next!!.key == key) {
                return bucket.next!!.value
            }
            bucket = bucket.next!!
        }
        return -1
    }

    fun remove(key: Int) {
        val index = calcIndex(key)
        var bucket = buckets[index]
        while (bucket.next != null) {
            if (bucket.next!!.key == key) {
                bucket.next = bucket.next!!.next
                return
            }
            bucket = bucket.next!!
        }
    }

    private fun calcIndex(key: Int): Int {
        return key % bucketsSize
    }
}
