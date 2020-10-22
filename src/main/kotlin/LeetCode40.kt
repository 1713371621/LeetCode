/**
 *
 * @author shijiayao
 * @date 2020/9/10 10:57
 */
class LeetCode40 {
  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val leetCode40 = LeetCode40()
      val intArray: IntArray = arrayListOf(10, 1, 2, 7, 6, 1, 5).toIntArray()
      leetCode40.combinationSum2(intArray, 8)
    }
  }

  fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {

    val resultCandidates: MutableList<List<Int>> = ArrayList()

    val candidates2 = candidates.sortedArray()
    println(candidates2.joinToString(separator = ","))

    combination(candidates2.toMutableList(), target, resultCandidates, arrayListOf(), 0)
    resultCandidates.forEach {
      println(it.joinToString(separator = ",", prefix = "[", postfix = "]"))
    }
    return resultCandidates.toList()
  }

  private fun combination(
      candidates: MutableList<Int>,
      target: Int,
      resultCandidates: MutableList<List<Int>>,
      resultCandidate: MutableList<Int>,
      start: Int
  ) {
    if (target == 0) {
      resultCandidates.add(resultCandidate.toList())
      println("resultCandidates.add: ${resultCandidate.joinToString(separator = ",")}")
      return
    }

    for (i: Int in start until candidates.size) {
      if (i > start && candidates[i - 1] == candidates[i]) {
        println("i > start && candidates[i - 1] == candidates[i]")
        continue
      }

      if (candidates[i] <= target) {
        resultCandidate.add(candidates[i])
        combination(candidates, target - candidates[i], resultCandidates, resultCandidate, i + 1)
        println("removeAt = ${resultCandidate[resultCandidate.size - 1]}")
        resultCandidate.removeAt(resultCandidate.size - 1)
      } else {
        return
      }
    }
  }
}