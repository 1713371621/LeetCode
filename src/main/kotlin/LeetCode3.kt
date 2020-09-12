/**
 *
 * @author shijiayao
 * @date 2020/9/11 19:16
 */
class LeetCode3 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val leetCode3 = LeetCode3()
            val result = leetCode3.lengthOfLongestSubstring2("\\ss\\vv \\sdfg ")
            println("result = $result")
        }
    }

    fun lengthOfLongestSubstring2(s: String): Int {
        var start = 0
        var end = 0
        var length = 0
        var result = 0

        val hashMap: MutableMap<Char, Int> = HashMap()
        while (end < s.length) {
            val tmp = s[end]
            hashMap[tmp]?.let {
                if (it > start) {
                    start = it + 1
                    length = end - start
                }
            }
            hashMap[tmp] = end

            length++
            end++

            result = if (result > length) {
                result
            } else {
                length
            }
        }
        return result
    }

    fun lengthOfLongestSubstring1(s: String): Int {
        var start = 0
        var end = 0
        var length = 0
        var result = 0

        while (end < s.length) {
            val tmp = s[end]
            for (index: Int in start until end) {
                if (tmp == s[index]) {
                    start = index + 1
                    length = end - start
                    break
                }
            }
            end++
            length++
            result = if (length > result) {
                length
            } else {
                result
            }
        }

        return result
    }

    fun lengthOfLongestSubstring(s: String): Int {
        var i = 0
        var flag = 0
        var length = 0
        var result = 0
        while (i < s.length) {
            val pos = s.indexOf(s[i], flag)
            if (pos < i) {
                if (length > result) {
                    result = length
                }
                if (result >= s.length - pos - 1) {
                    return result
                }
                length = i - pos - 1
                flag = pos + 1
            }
            length++
            i++
        }
        return length
    }
}