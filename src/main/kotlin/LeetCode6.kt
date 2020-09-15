/**
 *
 * @author shijiayao
 * @date 2020/9/15 20:05
 */
class LeetCode6 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val leetCode6 = LeetCode6()
            println(leetCode6.convert("PAYPALISHIRING", 3))
        }
    }

    fun convert(s: String, numRows: Int): String {
        if (numRows < 2) {
            return s
        }
        val z: Array<StringBuffer> = Array(numRows) { StringBuffer() }
        for (i in 0 until numRows) {
            z[i] = StringBuffer()
        }

        val charArray: CharArray = s.toCharArray()
        var index = 0
        var flag = -1
        for (i in s.indices) {
            z[index].append(charArray[i])
            if (index == 0 || index == numRows - 1) {
                flag = -flag
            }
            index += flag
        }

        val stringBuffer = StringBuffer()
        for (row in z) {
            stringBuffer.append(row)
        }
        return stringBuffer.toString()
    }
}