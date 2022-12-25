package graph

import api.DrawingApi
import java.util.Scanner

abstract class Graph(
    /**
     * Bridge to drawing api
     */
    private val drawer: DrawingApi
) {
    abstract fun drawGraph()
    abstract fun readGraph(sc: Scanner)
}