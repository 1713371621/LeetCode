import com.sun.xml.internal.fastinfoset.util.StringArray

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
        val z: Array<CharArray> = Array(s.length) { CharArray(numRows) }
        for (i: Int in s.indices) {
            for (j: Int in 0 until numRows) {
                z[i][j] = ' '
            }
        }
        val charArray: CharArray = s.toCharArray()
        var j = 0
        for (i: Int in s.indices) {
            if (j >= numRows) {
                j = 0
            }
            z[(i - j) / 2][j] = charArray[i]
            j++
        }
        val stringBuffer = StringBuffer()
            for (i: Int in s.indices) {
                for (k: Int in 0 until numRows) {

                    print(z[i][k])
                if (z[i][k] != ' ') {
                    stringBuffer.append(z[i][k])
                }
            }
            println()
        }
        return stringBuffer.toString()
    }
}