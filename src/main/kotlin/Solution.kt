class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        if (head == null) return null

        var prePart = head
        if (prePart.`val` < x) {
            while (prePart?.next != null && prePart.next?.`val`!! < x) {
                prePart = prePart.next
            }
        }
        if (prePart != null && (prePart.`val` >= x || (prePart.next != null && prePart.next!!.`val` >= x))) {
            var node = prePart
            while (node != null) {
                if (node.next != null && node.next?.`val`!! < x) {
                    when {
                        (prePart?.`val`!! >= x) -> {
                            val tmpNode = node.next
                            node.next = tmpNode?.next
                            tmpNode?.next = prePart.next
                            prePart.next = tmpNode

                            val tmpInt = prePart.`val`
                            prePart.`val` = tmpNode?.`val`!!
                            tmpNode.`val` = tmpInt
                        }
                        (prePart.next?.`val`!! >= x) -> {
                            val tmpNode = node.next
                            node.next = tmpNode?.next
                            tmpNode?.next = prePart.next
                            prePart.next = tmpNode

                            prePart = prePart.next
                        }
                    }
                }
                else {
                    node = node.next
                }
            }
        }
        return head
    }
}