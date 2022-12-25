package graph

import api.DrawingApi
import java.util.*

class ListGraph(private val drawer: DrawingApi): Graph(drawer) {
    private var n = 0
    private var m = 0
    private var edges: MutableList<Pair<Int, Int>> = mutableListOf()

    override fun drawGraph() {
        Helper.drawGraph(n, m, edges, drawer)
    }

    override fun readGraph(sc: Scanner) {
        n = sc.nextInt()
        m = sc.nextInt()

        for (i in 0 until m) {
            edges.add(sc.nextInt() - 1 to sc.nextInt() - 1)
        }
    }
}