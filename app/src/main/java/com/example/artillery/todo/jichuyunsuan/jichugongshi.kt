package com.example.artillery.todo.jichuyunsuan
import kotlin.math.*
import main.kotlin.SlRound

fun Gaocheng1 (Ha: Number, D: Number , e:Number,i:Number,L:Number): Double {
    //zhan zai yizhidian
    var Ha = Ha.toDouble()
    var D = D.toDouble()
    var e = e.toDouble()
    var i = i.toDouble()
    var L = L.toDouble()


    val Hb1 = Ha + (D*Math.tan(Math.toRadians(e*0.06))+i - L )
    print(Math.round(Hb1))

    return Hb1
}
fun Gaocheng2 (Ha: Number, D: Number , e:Number,i:Number,L:Number): Double {
    //zhanzai weizhidian
    var Ha = Ha.toDouble()
    var D = D.toDouble()
    var e = e.toDouble()
    var i = i.toDouble()
    var L = L.toDouble()


    val Hb2 = Ha - (D*Math.tan(Math.toRadians(e*0.06))+i - L )
    print(Math.round(Hb2))

    return Hb2
}
data class SanjiaoxingClass(val dac: Double,val dab: Double)

    fun sanjiaoxingdu(A: Number, B: Number, Dab: Number): SanjiaoxingClass {
        var a = A.toDouble()
        var b = B.toDouble()
        val dab = Dab.toDouble()
        a = a/ 0.06
        b = b/ 0.06
        val c = 3000 - a - b
        val dac = (sin((b * PI) / 3000) * dab) / (sin((c * PI / 3000)))
        // dac = dac.roundToInt().toDouble()
        // dac = dac.roundToInt().toDouble()
        val dbc = sin((a * PI) / 3000) * dab / (sin((c * PI / 3000)))
        // dbc = dbc.roundToInt().toDouble()
        // dbc = dbc.roundToInt().toDouble()

        return SanjiaoxingClass(dac, dbc)
    }

        fun sanjiaoxingmw(A: Number, B: Number, Dab: Number): SanjiaoxingClass {
            val a = A.toDouble()
            val b = B.toDouble()
            val dab = Dab.toDouble()
            val c = 3000 - a - b
            val dac = (sin((b * PI) / 3000) * dab) / (sin((c * PI / 3000)))
            // dac = dac.roundToInt().toDouble()
            // dac = dac.roundToInt().toDouble()
            val dbc = sin((a * PI) / 3000) * dab / (sin((c * PI / 3000)))
            // dbc = dbc.roundToInt().toDouble()
            // dbc = dbc.roundToInt().toDouble()

            return SanjiaoxingClass(dac,dbc)
}


///---------ni yun suan-----------///
data class Niyunsuan(val Dab: Double, val e: Double, val aab: Double, val Dab_n: Double)

fun calculateNiyunsuan(Xa: Number, Ya: Number, Xb: Number, Yb: Number, Ha: Number = 0.0, Hb: Number = 0.0): Niyunsuan {
    val Xa = Xa.toDouble()
    val Xb = Xb.toDouble()
    val Ya = Ya.toDouble()
    val Yb = Yb.toDouble()
    val Ha = Ha.toDouble()
    val Hb = Hb.toDouble()
    val result1 = sqrt((Xb - Xa).pow(2) + (Yb - Ya).pow(2))
    val Dab = SlRound(result1, 2)
    val result2 = atan((Hb - Ha) / result1) * 3000 / PI
    val e = SlRound(result2, 2)
    val result3 = result1 / cos(result2 * PI / 3000)
    val Dab_n = SlRound(result3, 2)
    val result4: Double = when {
        Xb - Xa > 0 && Yb - Ya > 0 -> atan((Yb - Ya) / (Xb - Xa)) * 3000 / PI
        Xb - Xa < 0 && Yb - Ya > 0 -> atan((Yb - Ya) / (Xb - Xa)) * (3000 / PI) + 3000
        Xb - Xa < 0 && Yb - Ya < 0 -> atan((Yb - Ya) / (Xb - Xa)) * (3000 / PI) + 3000
        Xb - Xa > 0 && Yb - Ya < 0 -> atan((Yb - Ya) / (Xb - Xa)) * (3000 / PI) + 6000
        else -> 0.0
    }
    val aab = SlRound(result4, 2)
    return Niyunsuan(Dab, e, aab, Dab_n)
}



///----------------------------zheng yun suan ----------------------///


data class Zhengyunsuan(val Xb: Double, val Yb: Double, val Hb: Double)

fun calculateZhengyunsuan(Xa: Number, Ya: Number, Dab: Number, aab: Number, e: Number = 0.0, Ha: Number = 0.0): Zhengyunsuan {
    val Xa = Xa.toDouble()
    val Ya = Ya.toDouble()
    val Dab = Dab.toDouble()
    var aab = aab.toDouble()
    var e = e.toDouble()
    val Ha = Ha.toDouble()
    aab =aab*0.06
    e = e*0.06
    val A = Dab * cos(((aab * PI) / 180))
    val result1 = Xa + A
    val Xb = SlRound(result1, 2)

    val B = Dab * sin(((aab * PI) / 180))
    val result2 = Ya + B
    val Yb = SlRound(result2, 2)

    val result3 = Ha + Dab * tan(((e * PI) / 180))
    val Hb = SlRound(result3, 2)

    return Zhengyunsuan(Xb, Yb, Hb)
}