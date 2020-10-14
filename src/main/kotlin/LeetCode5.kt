import java.util.*

/**
 *
 * @author shijiayao
 * @date 2020/9/12 10:47
 */
class LeetCode5 {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val leetCode5 = LeetCode5()
      println(leetCode5.longestPalindrome("ababada"))
    }
  }

  fun longestPalindrome4(s: String): String {
    val length: Int = s.length
    if (length < 2) {
      return s
    }

    if (s.indexOf("@") != -1) {
      return ""
    }

    val str: String = s.toCharArray().joinToString(separator = "@", prefix = "@", postfix = "@")
    val strLength: Int = 2 * length + 1
    var maxLength = 1
    var start = 0
    for (i: Int in 0 until strLength) {
      val curLength: Int = centerSpread(str, i)
      if (curLength > maxLength) {
        maxLength = curLength
        start = (i - maxLength) / 2
      }
    }
    return s.substring(start, start + maxLength)
  }

  private fun centerSpread(str: String, index: Int): Int {
    val length = str.length
    var i: Int = index - 1
    var j: Int = index + 1
    var step = 0
    while (i >= 0 && j < length && str[i] == str[j]) {
      i--
      j++
      step++
    }
    return step
  }

  fun longestPalindrome3(s: String): String {
    val length: Int = s.length
    if (length < 2) {
      return s
    }

    var maxLength = 1;
    var res: String = s.subSequence(0, 1).toString()
    for (i: Int in 0 until length - 1) {
      val oddStr: String = centerSpread(s, i, i)
      val evenStr: String = centerSpread(s, i, i + 1)
      val maxLengthString = if (oddStr.length > evenStr.length) {
        oddStr
      } else {
        evenStr
      }
      if (maxLengthString.length > maxLength) {
        maxLength = maxLengthString.length
        res = maxLengthString
      }
    }
    return res
  }

  private fun centerSpread(s: String, left: Int, right: Int): String {
    // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
    // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
    val length: Int = s.length
    var i: Int = left
    var j: Int = right
    while (i >= 0 && j < length) {
      if (s[i] == s[j]) {
        i--
        j++
      } else {
        break
      }
    }
    // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
    return s.substring(i + 1, j)
  }

  fun longestPalindrome2(s: String): String {
    val length: Int = s.length
    if (length < 2) {
      return s
    }

    var maxLength = 1;
    var begin = 0
    val dp: Array<BooleanArray> = Array(length) { BooleanArray(length) }

    val charArray = s.toCharArray()
    for (i: Int in 0 until length) {
      Arrays.fill(dp[i], false)
    }
    for (i: Int in 0 until length) {
      dp[i][i] = true
    }

    for (j: Int in 1 until length) {
      for (i: Int in 0 until j) {
        if (charArray[i] != charArray[j]) {
          dp[i][j] = false
        } else {
          if (j - i < 3) {
            dp[i][j] = true
          } else {
            dp[i][j] = dp[i + 1][j - 1]
          }
        }

        if (dp[i][j] && j - i + 1 > maxLength) {
          maxLength = j - i + 1
          begin = i
        }
      }
    }
    return s.subSequence(begin, begin + maxLength).toString()
  }

  fun longestPalindrome(s: String): String {
    var maxLength = 0
    var begin = 0
    val stringCharArray: CharArray = s.toCharArray()
    for (i in s.indices) {
      for (j in i until s.length) {
        if (palindrome(stringCharArray, i, j)) {
          if (maxLength < j - i + 1) {
            maxLength = j - i + 1
            begin = i
          }
        }
      }
    }
    return s.substring(begin, begin + maxLength)
  }

  private fun palindrome(charArray: CharArray, left: Int, right: Int): Boolean {
    var r = right
    var l = left
    while (l < r) {
      if (charArray[l] != charArray[r]) {
        return false
      }
      l++
      r--
    }
    return true
  }
}