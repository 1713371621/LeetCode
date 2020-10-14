/**
 *
 * @author shijiayao
 * @date 2020/9/16 18:04
 */
class LeetCode7 {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val leetCode7 = LeetCode7()
      println(leetCode7.reverse(-2147483648))
    }
  }

  fun reverse(x: Int): Int {
    var rev = 0
    var num = x
    while (num != 0) {
      val pop = num % 10
      num /= 10
      if (rev > Int.MAX_VALUE / 10 || (rev == Int.MAX_VALUE / 10 && pop > 7)) {
        return 0
      }
      if (rev < Int.MIN_VALUE / 10 || (rev == Int.MIN_VALUE / 10 && pop < -8)) {
        return 0
      }
      rev = rev * 10 + pop;
    }
    return rev
  }
}