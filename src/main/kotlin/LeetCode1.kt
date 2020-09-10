/**
 *
 * @author shijiayao
 * @date 2020/9/10 14:55
 */
class LeetCode1 {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val leetCode1 = LeetCode1()
            val intArray: IntArray = arrayListOf(
                0,5,0,0
            ).toIntArray()
            println(leetCode1.twoSum(intArray, 0).joinToString(separator = ", "))
        }
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashMap: MutableMap<Int, Int> = HashMap()
        for (i: Int in nums.indices) {
            val index: Int = target - nums[i]
            if (hashMap.containsKey(index)) {
                hashMap[index]?.let {
                    return arrayListOf(i, it).toIntArray()
                }
            }
            hashMap[nums[i]] = i
        }
        return IntArray(0)
    }

}