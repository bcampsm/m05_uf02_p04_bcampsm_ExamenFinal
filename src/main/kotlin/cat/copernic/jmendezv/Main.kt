package cat.copernic.jmendezv

import kotlin.math.floor

/**
 * Implementació i tests de tota mena
 */
fun main() {

    println(imc(90.00,1.80))


}

data class Point(val x: Double, val y: Double)

/*
* Índice de masa corporal
*
* imc = weight / height^2
* */
fun imc(weight: Double, height: Double) = weight / (height * height)//test ok

/*
* https://en.wikipedia.org/wiki/Quadratic_equation
*
* (-b ± sqrt(b^2 - 4ac)) / 2a
* */
fun secondDegreeEquation(a: Double, b: Double, c: Double): Pair<Double, Double> = TODO()


/*
* Cálculo de la distancia entre dos puntos
*
* distance = √[(x2 – x1)^2 +(y2 – y1)^2]
* */
fun distance(p1: Point, p2: Point): Double = TODO("Pending")

/*
* Cáculo de la pendiente de una recta
*
* slope = (y2 – y1) / (x2 – x1)
* */
fun slope(p1: Point, p2: Point): Double = TODO("Pending")

/*
* Cálculo del punto medio de una recta
*
* midpoint = ((x1+x2)/2, (y1+y2)/2)
* */
fun midPoint(p1: Point, p2: Point): Point = TODO("Pending")

fun displayScore(score: Double) {
    val roundedScore = floor(score * 100) / 100
    when (roundedScore) {
        in 0.0..4.99 -> println("No supera")
        in 5.0..5.99 -> println("Supera")
        in 6.0..6.99 -> println("Bien")
        in 7.0..8.99 -> println("Notable")
        in 9.0..10.0 -> println("Excel·lent")
        else -> println("Nota invalida")
    }
}

/*
* Encuentra el menor y mayor
*
* [2,3,1,4,7,6,5] = (1,7)
* [] = IllegalArgumentException
* */
fun findMinAndMax(list: List<Int>): Pair<Int, Int> = TODO("Pending")

/*
*
* Cálculo del punto más cercano a point. points es una lista de tipo Point
*
* */
fun closest(point: Point, vararg points: Point): Point = TODO("Pending")
