package main.kotlin
import kotlin.math.round
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.abs

fun SlRound(num: Double, i: Int = 0): Double {
    val str1 = abs(num).toString()
    val flag = str1.indexOf(".")
    if (flag + i + 1 >= str1.length) {
        return num
    }
    var result = abs(num)

    if (str1[flag + i + 1].toString().toInt() == 5) {
        var k = 0.1
        for (j in 0 until i) {
            k *= 0.1
        }
        result = BigDecimal.valueOf(result).add(BigDecimal.valueOf(k)).toDouble()
    }
    if (num>=0){
        return if (i == 0) {
            BigDecimal.valueOf(result).setScale(0, RoundingMode.HALF_UP).toDouble()
        } else {
            BigDecimal.valueOf(result).setScale(i, RoundingMode.HALF_UP).toDouble()
        }}
    else{return if (i == 0) {
        -BigDecimal.valueOf(result).setScale(0, RoundingMode.HALF_UP).toDouble()
    } else {
        -BigDecimal.valueOf(result).setScale(i, RoundingMode.HALF_UP).toDouble()
    }}
}



