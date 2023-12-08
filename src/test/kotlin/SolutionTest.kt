import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {
    private val solution = Solution()

    private fun toList(array: IntArray): ListNode {
        val root = ListNode(array[0])
        var list = root
        for (i in 1..<array.size) {
            list.next = ListNode(array[i])
            list = list.next!!
        }
        return root
    }

    private fun length(root: ListNode?): Int {
        var size = 0
        var node = root
        while (node != null) {
            node = node.next
            size++
        }
        return size
    }
    private fun toArray(root: ListNode?): IntArray {
        val arr = IntArray(length(root))
        var node = root
        var i = 0
        while (node != null) {
            arr[i++] = node.`val`
            node = node.next
        }
        return arr
    }

    @Test
    fun partition1() {
        val list = toList(intArrayOf(1,4,3,2,5,2))
        val result = toArray(solution.partition(list, 3))
        assertArrayEquals(intArrayOf(1,2,2,4,3,5), result)
    }

    @Test
    fun partition2() {
        val list = toList(intArrayOf(2,1))
        val result = toArray(solution.partition(list, 2))
        assertArrayEquals(intArrayOf(1,2), result)
    }

    @Test
    fun partition3() {
        val list = toList(intArrayOf(1,4,3,2,1,2))
        val result = toArray(solution.partition(list, 3))
        assertArrayEquals(intArrayOf(1,2,1,2,4,3), result)
    }
    @Test
    fun partition4() {
        val list = toList(intArrayOf(4,3,2,5,2))
        val result = toArray(solution.partition(list, 3))
        assertArrayEquals(intArrayOf(2,2,4,3,5), result)
    }

    @Test
    fun partition5() {
        val list = toList(intArrayOf(1))
        val result = toArray(solution.partition(list, 3))
        assertArrayEquals(intArrayOf(1), result)
    }
}