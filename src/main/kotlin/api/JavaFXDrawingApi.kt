package api

import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import javafx.stage.Stage

class JavaFXDrawingApi: DrawingApi, Application() {
    private companion object {
        const val width = 1000
        const val height = 1000
        var circles: MutableList<Pair<Pair<Double, Double>, Double>> = mutableListOf()
        var lines: MutableList<Pair<Pair<Double, Double>, Pair<Double, Double>>> = mutableListOf()
    }

    private var graphicsContext: GraphicsContext? = null

    override fun start(primaryStage: Stage) {
        val root = Group()
        val canvas = Canvas(width.toDouble(), height.toDouble())

        graphicsContext = canvas.graphicsContext2D
        root.children.add(canvas)

        circles.forEach { drawCircle(it.first, it.second) }
        lines.forEach { drawLine(it.first, it.second) }

        primaryStage.scene = Scene(root)
        primaryStage.show()
    }

    override fun getDrawingAreaWidth(): Int {
        return width
    }

    override fun getDrawingAreaHeight(): Int {
        return height
    }

    override fun addCircle(center: Pair<Double, Double>, radius: Double) {
        circles.add(Pair(center, radius))
    }

    override fun addLine(start: Pair<Double, Double>, end: Pair<Double, Double>) {
        lines.add(Pair(start, end))
    }

    override fun render() {
        launch(JavaFXDrawingApi::class.java)
    }

    private fun drawCircle(center: Pair<Double, Double>, radius: Double) {
        graphicsContext?.fill = Color.RED
        graphicsContext?.fillOval(center.first, center.second, 2 * radius, 2 * radius)
    }

    private fun drawLine(start: Pair<Double, Double>, end: Pair<Double, Double>) {
        graphicsContext?.strokeLine(start.first, start.second, end.first, end.second)
    }
}