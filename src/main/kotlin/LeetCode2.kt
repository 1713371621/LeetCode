/**
 *
 * @author shijiayao
 * @date 2020/9/10 19:35
 */
class LeetCode2 {
  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val leetCode2 = LeetCode2()
      leetCode2.addTwoNumbers(null, null)
    }
  }

  class ListNode(var data: Int) {
    var nextNode: ListNode? = null
  }

  fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var l1Node = l1
    var l2Node = l2
    val rootNode = ListNode(0)
    var temp: ListNode? = rootNode
    var carry = 0

    while (l1Node != null || l2Node != null) {
      val data1 = l1Node?.data ?: 0
      val data2 = l2Node?.data ?: 0

      var sum: Int = data1 + data2 + carry
      carry = sum / 10
      sum %= 10
      temp?.nextNode = ListNode(sum)

      temp = temp?.nextNode
      if (l1Node != null) {
        l1Node = l1Node.nextNode
      }

      if (l2Node != null) {
        l2Node = l2Node.nextNode
      }
    }
    if (carry == 1) {
      temp?.nextNode = ListNode(carry)
    }
    return rootNode.nextNode
  }
}