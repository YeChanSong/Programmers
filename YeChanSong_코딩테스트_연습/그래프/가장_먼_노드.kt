import java.util.*
import kotlin.collections.ArrayList

class Solution {

    lateinit var adj: ArrayList<ArrayList<Int>>
    lateinit var dist: IntArray

    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0
        adj = ArrayList()
        repeat(n+1) {
            adj.add(ArrayList())
        }
        dist = IntArray(n+1)
        dist.fill(Int.MAX_VALUE)
        edge.forEach { e ->
            adj.get(e[0]).add(e[1])
            adj.get(e[1]).add(e[0])
        }
        bfs(1)
        val maxValue = dist.filter {d -> d < Int.MAX_VALUE}.maxOrNull()
        answer = dist.filter{it -> it == maxValue}.count()

        return answer
    }

    fun bfs(startVertex: Int) {
        val queue = ArrayDeque<Int>()
        queue.offerLast(startVertex)
        dist[startVertex] = 0
        while (queue.isNotEmpty()) {
            val currentVertex = queue.pollFirst()
            adj.get(currentVertex).forEach { next ->
                if (dist[next] == Int.MAX_VALUE) {
                    dist[next] = dist[currentVertex] +1
                    queue.offerLast(next)
                }
            }
        }


    }
}