import api.DrawingApi
import api.JavaAWTDrawingApi
import api.JavaFXDrawingApi
import graph.Graph
import graph.ListGraph
import graph.MatrixGraph
import java.util.*

fun main(args: Array<String>) {
    if (args.size != 2) {
        throw IllegalArgumentException("Please specify input type and drawing method")
    }

    val drawer: DrawingApi = when (args[0]) {
        "jfx" -> JavaFXDrawingApi()
        "awt" -> JavaAWTDrawingApi()
        else -> throw IllegalArgumentException("Invalid drawer provided")
    }

    val graph: Graph = when (args[1]) {
        "list" -> ListGraph(drawer)
        "matrix" -> MatrixGraph(drawer)
        else -> throw IllegalArgumentException("Invalid graph type provided")
    }

    graph.readGraph(Scanner(System.`in`))
    graph.drawGraph()
}