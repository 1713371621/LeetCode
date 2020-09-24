/**
 *
 * @author shijiayao
 * @date 2020/9/17 20:53
 */
class LeetCode8 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // TODO: 2020/9/24 有限状态机
            val leetCode8 = LeetCode8()
            println(leetCode8.myAtoi("   -42"))
        }
    }

    fun myAtoi(str: String): Int {
        val numMap: Map<Char, Int> = mapOf(
            Pair('0', 0),
            Pair('1', 1),
            Pair('2', 2),
            Pair('3', 3),
            Pair('4', 4),
            Pair('5', 5),
            Pair('6', 6),
            Pair('7', 7),
            Pair('8', 8),
            Pair('9', 9)
        )
        var blank = false
        val charArray: CharArray = str.toCharArray()
        var num = 0
        var flag = 1
        for (char: Char in charArray) {
            println("num: ${num}, char: $char")
            if (char == ' ') {
                if (blank) {
                    if (flag < 0) {
                        num *= -1
                    }
                    return num
                }
            } else {
                if (numMap.containsKey(char)) {
                    if (flag > 0) {
                        if (num > Int.MAX_VALUE / 10) {
                            return Int.MAX_VALUE
                        } else if (num == Int.MAX_VALUE / 10 && numMap[char] ?: error("") <= 7|| num < Int.MAX_VALUE / 10) {
                            num = num * 10 + numMap[char]!!
                        } else {
                            return Int.MAX_VALUE
                        }
                    } else {
                        if (num > Int.MAX_VALUE / 10) {
                            return Int.MIN_VALUE
                        } else if (num == Int.MAX_VALUE / 10 && numMap[char] ?: error("") <= 7 || num < Int.MAX_VALUE / 10) {
                            num = num * 10 + numMap[char]!!
                        } else {
                            return Int.MIN_VALUE
                        }
                    }
                } else {
                    if (char == '-' && !blank) {
                        flag = -1
                    } else if (char == '+' && !blank) {
                        flag = 1
                    } else {
                        if (flag < 0) {
                            num *= -1
                        }
                        return num
                    }
                }
                blank = true
            }
        }
        println("finish: $num")
        if (flag < 0) {
            num *= -1
        }
        return num
    }
}