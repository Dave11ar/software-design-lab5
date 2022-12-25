package api

import java.awt.Color
import java.awt.Frame
import java.awt.Graphics2D
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import java.awt.geom.Ellipse2D
import kotlin.system.exitProcess

class JavaAWTDrawingApi: DrawingApi, Frame() {
    private companion object {
        const val width = 1000
        const val height = 1000
        private var circles: MutableList<Pair<Pair<Double, Double>, Double>> = mutableListOf()
        private var lines: MutableList<Pair<Pair<Double, Double>, Pair<Double, Double>>> = mutableListOf()
    }

    init {
        addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                super.windowClosing(e)
                exitProcess(0)
            }
        })
        setSize(getDrawingAreaWidth(), getDrawingAreaHeight())
        isVisible = true
    }

    override fun getDrawingAreaWidth() = JavaAWTDrawingApi.width

    override fun getDrawingAreaHeight() = JavaAWTDrawingApi.height

    override fun addCircle(center: Pair<Double, Double>, radius: Double) {
        circles.add(Pair(center, radius))
    }

    override fun addLine(start: Pair<Double, Double>, end: Pair<Double, Double>) {
        lines.add(Pair(start, end))
    }

    override fun render() {
        circles.forEach { drawCircle(it.first, it.second) }
        lines.forEach { drawLine(it.first, it.second) }
    }

    private fun drawCircle(center: Pair<Double, Double>, radius: Double) {
        val g = graphics as Graphics2D
        g.color = Color.blue
        g.fill(
            Ellipse2D.Float(
                center.first.toFloat(),
                center.second.toFloat(),
                radius.toFloat() * 2,
                radius.toFloat() * 2
            )
        )
    }

    private fun drawLine(start: Pair<Double, Double>, end: Pair<Double, Double>) {
        val g = graphics as Graphics2D
        g.drawLine(start.first.toInt(), start.second.toInt(), end.first.toInt(), end.second.toInt())
    }
}