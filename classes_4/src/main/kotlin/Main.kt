import kotlin.math.pow
import kotlin.math.sqrt

// Класс, преставляющий точку в двумерном пространстве
class Point(val x: Double, val y: Double)

// Класс, представляющий треугольник
class Triangle(val vertex1: Point, val vertex2: Point, val vertex3: Point) {

    //Функция для вычисления координат центра описанной окружности
    fun circumcenter(): Point {
        val a = vertex2.x - vertex1.x
        val b = vertex2.y - vertex1.y
        val c = vertex3.x - vertex1.x
        val d = vertex3.y - vertex1.y
        val e = a * (vertex1.x + vertex2.x) + b * (vertex1.y + vertex2.y)
        val f = c * (vertex1.x + vertex3.x) + d * (vertex1.y + vertex3.y)
        val g = 2 * (a * (vertex3.y - vertex2.y) - b * (vertex3.x - vertex2.x))

        //вычисление координат центра
        val centerX = (d * e - b * f) / g
        val centerY = (a * f - c * e) / g

        return Point(centerX, centerY)
    }

    //Функция для вычисления радиуса описанной окружности
    fun circumradius(center: Point): Double {
        return sqrt((center.x - vertex1.x).pow(2) + (center.y - vertex1.y).pow(2))
    }
}

fun main() {
    println("Введите координаты вершин треугольника:")
    val vertex1 = readPoint("Вершина 1")
    val vertex2 = readPoint("Вершина 2")
    val vertex3 = readPoint("Вершина 3")

    val triangle = Triangle(vertex1, vertex2, vertex3)
    val center = triangle.circumcenter()
    val radius = triangle.circumradius(center)

    println("Координаты центра описанной окружности: (${center.x}, ${center.y})")
    println("Радиус описанной окружности: $radius")
}

fun readPoint(prompt: String): Point {
    print("$prompt (x y): ")
    val input = readLine() ?: ""
    val (x, y) = input.split("").map { it.toDouble() }
    return Point(x, y)
}