package api

interface DrawingApi {
    fun getDrawingAreaWidth(): Int
    fun getDrawingAreaHeight(): Int

    fun addCircle(center: Pair<Double, Double>, radius: Double)
    fun addLine(start: Pair<Double, Double>, end: Pair<Double, Double>)

    fun render()
}