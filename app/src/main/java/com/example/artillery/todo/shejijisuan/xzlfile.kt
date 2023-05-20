package main.kotlin
import android.content.res.AssetManager
import main.kotlin.SlRound
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import kotlin.math.*



fun zhuangyao(a: Int): String {
    val numberList = arrayOf("/0haozhuangyao", "/1haozhuangyao", "/2haozhuangyao", "/3haozhuangyao", "/4haozhuangyao")

    val numberLink = "mm "
    val numberNewLink = numberLink.trim() + numberList[a]
    return numberNewLink
}


///------------------qi wen xzl---------------------------------- ///



data class QiwenResult(val xiuzhengLiang: Double)

    fun qiwen(a: Number, T: Number, Dm: Number,assetManager: AssetManager): QiwenResult {
        val a = a.toInt()
        val T = T.toInt()
        val Dm = Dm.toInt()
        val T_chabiao = floor(Dm / 1000.0).toInt()
        val T_pcl = if (T > 50) 50 - T else T
        val T_pianchaliang = abs(T_pcl)
        var xiuzhengLiang = 0.0

        val T_link = "${zhuangyao(a)}/qiwenxiuzhengliang.txt"
        try {
            val inputStream = assetManager.open(T_link)
            val T_file = BufferedReader(InputStreamReader(inputStream))


//        val T_file = File(T_link).bufferedReader()


            var n_lines = 0
            var varList: List<Double>? = null
            T_file.forEachLine {
                n_lines++
                if (T_chabiao == n_lines) {
                    varList = it.split(",").map { str ->
                        str.toDouble()
                    }
                }
            }
            val T_xiuzhengliang = when {
                T_pianchaliang == 0 -> 0
                T_pianchaliang <= 10 -> (varList?.get(T_pianchaliang - 1) ?: 0).toDouble()
                T_pianchaliang <= 20 -> ((varList?.get(9) ?: 0).toDouble() + (((varList?.get(10)
                    ?: 0).toDouble() - ((varList?.get(9)
                    ?: 0).toDouble())) / 10) * (T_pianchaliang - 10))

                T_pianchaliang <= 30 -> ((varList?.get(10) ?: 0).toDouble() + (((varList?.get(11)
                    ?: 0).toDouble() - ((varList?.get(10)
                    ?: 0).toDouble())) / 10) * (T_pianchaliang - 20))

                else -> (varList?.get(1) ?: 0).toDouble() * T_pianchaliang
            }
            var xzl = if (T_pcl >= 0) -T_xiuzhengliang.toDouble() else T_xiuzhengliang.toDouble()
            var xzlfloat = xzl.toDouble()
            xiuzhengLiang = SlRound(xzlfloat)
            T_file.close()
            println("qiwen: $xiuzhengLiang")
            println(varList)

            }catch (e: Exception){
                e.printStackTrace()}
        return QiwenResult(xiuzhengLiang)
    }
fun qiwenjyf(a: Number, T: Number, Dm: Number,assetManager: AssetManager): QiwenResult {
    val a = a.toInt()
    val T = T.toInt()
    val Dm = Dm.toInt()
    val T_chabiao = floor(Dm / 1000.0).toInt()
    val T_pcl = abs(T-15)
    val T_pianchaliang = abs(T_pcl)
    var xiuzhengLiang = 0.0

    val T_link = "${zhuangyao(a)}/qiwenxiuzhengliang.txt"
    try{
        val inputStream = assetManager.open(T_link)
        val T_file = BufferedReader(InputStreamReader(inputStream))

    //    val T_file = File(T_link).bufferedReader()
        var n_lines = 0
        var varList: List<Double>? = null
        T_file.forEachLine {
            n_lines++
            if (T_chabiao == n_lines) {
                varList = it.split(",").map { str -> str.toDouble() }
            }
        }
        val T_xiuzhengliang = when {
            T_pianchaliang == 0 -> 0
            T_pianchaliang <= 10 -> varList?.get(T_pianchaliang - 1) ?: 0
            T_pianchaliang <= 20 -> ((varList?.get(9) ?: 0).toDouble()  + (((varList?.get(10) ?: 0).toDouble() - ((varList?.get(9) ?: 0).toDouble())) / 10) * (T_pianchaliang - 10))
            T_pianchaliang <= 30 -> ((varList?.get(10) ?: 0).toDouble() + (((varList?.get(11) ?: 0).toDouble() - ((varList?.get(10) ?: 0).toDouble())) / 10) * (T_pianchaliang - 20))
            else -> (varList?.get(1) ?: 0).toDouble() * T_pianchaliang
        }
        var xzl = if (T -15 >= 0) -T_xiuzhengliang.toDouble() else T_xiuzhengliang.toDouble()
        var xzlfloat = xzl.toDouble()
        xiuzhengLiang = SlRound(xzlfloat)
        T_file.close()
        println("qiwen: $xiuzhengLiang")
        println(varList)}
    catch (e:Exception){
        e.printStackTrace()
    }
    return QiwenResult(xiuzhengLiang)
}

///-------------------------chusu xiuzhengliang-----------------------------------///


data class Chusu(val xiuzhengLiang: Double )

fun chusu(a:Number,V0:Number,Dm: Number,assetManager: AssetManager ): Chusu{
    val a=a.toInt()
    val V0=V0.toDouble()
    val Dm=Dm.toDouble()
    val Dm_chabiao = floor(Dm / 1000).toInt()
    val V0_pianchaliang = (abs(V0) * 10)

    var xiuzhengLiang =0.0
    zhuangyao(a)
    val V0_link = "${zhuangyao(a)}/chusupiancha.txt"
//    val V0_file = File(V0_link).bufferedReader()
    try {
        val inputStream = assetManager.open(V0_link)
        val V0_file = BufferedReader(InputStreamReader(inputStream))
        var n_lines = 0
        var varList: List<Double>? = null
        V0_file.forEachLine {
            n_lines++
            if (Dm_chabiao == n_lines) {
                varList = it.split(",").map { str -> str.toDouble() }
            }
        }
        var V0_xiuzhengliang = when {
            V0_pianchaliang.toInt() == 0 -> 0
            V0_pianchaliang.toInt() <= 10 -> varList?.get(V0_pianchaliang.toInt() - 1) ?: 0
            V0_pianchaliang.toInt() <= 20 -> ((varList?.get(9)
                ?: 0).toDouble() + (((varList?.get(10) ?: 0).toDouble() - ((varList?.get(9)
                ?: 0).toDouble())) / 10) * (V0_pianchaliang - 10))

            V0_pianchaliang.toInt() <= 30 -> ((varList?.get(10) ?: 0).toDouble() + (((varList?.get(
                11
            ) ?: 0).toDouble() - ((varList?.get(10)
                ?: 0).toDouble())) / 10) * (V0_pianchaliang - 20))

            else -> {
                (varList?.get(1) ?: 0).toDouble() * V0_pianchaliang
            }
        }
        var xzl = if (V0 >= 0) -V0_xiuzhengliang.toDouble() else V0_xiuzhengliang.toDouble()
        xiuzhengLiang = SlRound(xzl)
        V0_file.close()
        print(xiuzhengLiang)
    }catch (e:Exception){
        e.printStackTrace()
    }
    return Chusu(xiuzhengLiang)
}



///--------------------- HAI BA GAO---------------------------///


data class Haibagao( val haibagao_number : Double)

fun haibagao(a: Number,Dm: Number, Hp: Number,assetManager: AssetManager ): Haibagao {
    val a = a.toInt()
    val Dm = Dm.toDouble()
    val Hp = Hp.toInt()
    val Dm_chabiao = (Math.floor(Dm / 1000) - 1) * 5 + 1
    var haibagao_number = 0.0
    zhuangyao(a)
    val haibagao_link = "${zhuangyao(a)}/zongheshuju.txt"
//    val haibagao_file = File(haibagao_link).bufferedReader()

    try {
        val inputStream = assetManager.open(haibagao_link)
        val haibagao_file = BufferedReader(InputStreamReader(inputStream))
    var n_lines = 0
    var varList: List<Double>? = null
    haibagao_file.forEachLine {
        n_lines++
        if (Dm_chabiao.toInt() == n_lines) {
            varList = it.split(",").map { str -> str.toDouble() }
        }
    }
    val haibagao_xzl = (((((varList!![1]).toDouble() - (varList!![2]).toDouble()) / 500) * Hp) * (varList!![4])).toDouble()
    haibagao_number= -SlRound(haibagao_xzl)
    haibagao_file.close()
    println("haibagao $haibagao_number")
    println(varList)}
    catch (e:Exception){
        e.printStackTrace()
    }
    return Haibagao(haibagao_number)
}



///------------------------------heng feng ---------------------///




fun hengfeng(a: Number, Dm: Number, J: Number, Ff: Number, Vf: Number,assetManager: AssetManager ): Double {
    val a= a.toInt()
    val Dm = Dm.toDouble()
    var J = J.toDouble()*0.06
    var Ff = Ff.toDouble()*0.06
    var Vf = Vf.toDouble()


    var F = if (J >= Ff) J - Ff else J + 360 - Ff
    var Hf = SlRound(Vf * Math.sin(Math.toRadians(F)))
//    if (F <= 90) {
//        Hf = -Vf * Math.sin(Math.toRadians(F))
//    } else if (F <= 180) {
//        Hf = -Vf * Math.sin(Math.toRadians(180 - F))
//    } else if (F <= 270) {
//        Hf = Vf * Math.sin(Math.toRadians(F - 270))
//    } else if (F <= 360) {
//        Hf = Vf * Math.sin(Math.toRadians(360 - F))
//    }
//    Hf = SlRound(Hf)

    val Hf_chabiao = Math.floor(Dm / 1000.0)
    val Hf_pianchaliang = Math.abs(Hf)
    zhuangyao(a)
    var Hf_xiuzhengliang: Double = 0.0
    val Hf_link = zhuangyao(a) + "/hengfengxiuzhengliang.txt"
//    val Hf_file = File(Hf_link).bufferedReader()
    try {
        val inputStream = assetManager.open(Hf_link)
        val Hf_file = BufferedReader(InputStreamReader(inputStream))
    var n_lines = 0
    var varList: List<Double>? = null
    Hf_file.forEachLine { line ->
        n_lines++
        if (Hf_chabiao.toInt() == n_lines) {
            varList = line.trim().split(",").map { it.toDouble() }
        }
    }

    if (Hf_pianchaliang == 0.0) {
        Hf_xiuzhengliang = 0.0
    } else if (Hf_pianchaliang > 0 && Hf_pianchaliang <= 10) {
        Hf_xiuzhengliang = varList?.get(Hf_pianchaliang.toInt() - 1) ?: 0.0
    } else if (Hf_pianchaliang <= 20) {
        Hf_xiuzhengliang =
            SlRound((varList?.get(9)!!).toDouble() + (((varList?.get(10)!!).toDouble() - (varList?.get(9)!!).toDouble()) / 10) * (Hf_pianchaliang.toDouble() - 10))
    } else if (Hf_pianchaliang <= 30) {
        Hf_xiuzhengliang =
            SlRound((varList?.get(10)!!).toDouble() + (((varList?.get(11)!!).toDouble() - (varList?.get(10)!!).toDouble()) / 10) * (Hf_pianchaliang.toDouble() - 20))
    } else {
        Hf_xiuzhengliang = (varList?.get(1)!!).toDouble() * Hf_pianchaliang
    }
    Hf_file.close()
    Hf_xiuzhengliang = if (180>=F && F >= 0) -Hf_xiuzhengliang else Hf_xiuzhengliang
    println("hengfeng: $Hf_xiuzhengliang")
    println(varList)}
    catch (e:java.lang.Exception){
        e.printStackTrace()
    }
    return Hf_xiuzhengliang
}


///------------------------zong feng ----------///



fun zongfeng(a: Number, Dm: Number, J: Number, Ff: Number, Vf: Number,assetManager: AssetManager ): Double {
    val a = a.toInt()
    val Dm = Dm.toDouble()
    var J = J.toDouble() * 0.06
    var Ff = Ff.toDouble() * 0.06
    var Vf = Vf.toDouble()
    var F = if (J > Ff) J - Ff else J + 360 - Ff
    var Zf= Vf * Math.cos(Math.toRadians(F))
//    if (F <= 90) {
//        Zf = Vf * Math.cos(Math.toRadians(F))
//    } else if (F <= 180) {
//        Zf = -Vf * Math.cos(Math.toRadians(180 - F))
//    } else if (F <= 270) {
//        Zf = -Vf * Math.cos(Math.toRadians(F - 270))
//    } else if (F <= 360) {
//        Zf = Vf * Math.cos(Math.toRadians(360 - F))
//    }
    val delta_Zf = Math.abs(Zf - Zf.toInt())
    if (0 <= delta_Zf && delta_Zf < 0.25) {
        Zf = Zf.toInt().toDouble()
    } else if (0.25 < delta_Zf && delta_Zf < 1) {
        Zf = if (Zf >= 0) (Zf.toInt() + 1).toDouble() else (Zf.toInt() - 1).toDouble()
    }

    val Zf_chabiao = Math.floor(Dm / 1000.0)
    val Zf_pianchaliang = Math.abs(Zf)
    var Zf_xiuzhengliang: Double = 0.0
    zhuangyao(a)
    val Zf_link = zhuangyao(a) + "/zongfengxiuzhengliang.txt"
    try {
        val inputStream = assetManager.open(Zf_link)
        val Zf_file = BufferedReader(InputStreamReader(inputStream))
//    val Zf_file = File(Zf_link).bufferedReader()
    var n_lines = 0
    var varList: List<Int>? = null
    Zf_file.forEachLine { line ->
        n_lines++
        if (Zf_chabiao.toInt() == n_lines) {
            varList = line.trim().split(",").map { it.toInt() }
        }
    }

    if (Zf_pianchaliang == 0.0) {
        Zf_xiuzhengliang = 0.0
    } else if (Zf_pianchaliang.toInt() in 1..10) {
        Zf_xiuzhengliang = varList?.get(Zf_pianchaliang.toInt() - 1)?.toDouble() ?: 0.0
    } else if (Zf_pianchaliang <= 20) {
        Zf_xiuzhengliang =
            round((varList?.get(9)!!).toDouble() + (((varList?.get(10)!!).toDouble() - (varList?.get(9)!!).toDouble()) / 10) * (Zf_pianchaliang.toDouble() - 10))
    } else if (Zf_pianchaliang <= 30) {
        Zf_xiuzhengliang =
            round((varList?.get(10)!!).toDouble() + (((varList?.get(11)!!).toDouble() - (varList?.get(10)!!).toDouble()) / 10) * (Zf_pianchaliang.toDouble() - 20))
    } else {
        Zf_xiuzhengliang = (varList?.get(1)!!).toDouble() * Zf_pianchaliang
    }
    Zf_file.close()

    Zf_xiuzhengliang = if (Zf >= 0) SlRound(Zf_xiuzhengliang) else SlRound(-Zf_xiuzhengliang)
    println(Zf_xiuzhengliang)
    println(varList )}
    catch (e:Exception){
        e.printStackTrace()
    }

    return Zf_xiuzhengliang
}



///-------------------------------pian liu--------------------////


fun pianliuxiuzhengliang(a: Number, Dm: Number,assetManager: AssetManager ): Double {
    val a= a.toInt()
    val Dm = Dm.toDouble()
    val Dm_chabiao = (Math.floor(Dm / 1000) - 1) * 5 + 1
    zhuangyao(a)
    var pianliu_xiuzhengliang = 0.0
    val pianliu_link = zhuangyao(a) + "/zongheshuju.txt"
    try {
        val inputStream = assetManager.open(pianliu_link)
        val pianliu_file = BufferedReader(InputStreamReader(inputStream))
//    val pianliu_file = File(pianliu_link).bufferedReader()
    var n_lines = 0
    var varList: List<Double>? = null
    pianliu_file.forEachLine { line ->
        n_lines++
        if (Dm_chabiao.toInt() == n_lines) {
            varList = line.trim().split(",").map { it.toDouble() }
        }
    }
    pianliu_xiuzhengliang = -(varList?.last() ?: 0).toDouble()
    println("pianliu: $pianliu_xiuzhengliang")
    println(varList)
    pianliu_file.close()}
    catch (e:Exception){
        e.printStackTrace()
    }
    return pianliu_xiuzhengliang
}


///------------------------qi ya--------------------------///

fun qiya(a: Number, Delta_H: Number, Dm: Number,assetManager: AssetManager ): Double {

    val a = a.toInt()
    val Delta_H=Delta_H.toDouble()
    val Dm = Dm.toDouble()
    val H_chabiao = Math.floor(Dm / 1000)
    val H_pianchaliang = abs(Delta_H)
    zhuangyao(a)
    var H_xiuzhengliangFinal = 0.0
    val H_link = zhuangyao(a) + "/qiyaxiuzhengliang.txt"
    try {
        val inputStream = assetManager.open(H_link)
        val H_file = BufferedReader(InputStreamReader(inputStream))
//    val H_file = File(H_link).bufferedReader()
    var n_lines = 0
    var varList: List<Int>? = null
    H_file.forEachLine { line ->
        n_lines++
        if (H_chabiao.toInt() == n_lines) {
            varList = line.trim().split(",").map { it.toInt() }
        }
    }
    val H_xiuzhengliang = when {
        H_pianchaliang == 0.0 -> 0.0
        H_pianchaliang <= 10 -> varList?.get(H_pianchaliang.toInt() - 1)?.toDouble() ?: 0.0
        H_pianchaliang <= 20 -> (varList?.get(9) ?: 0).toDouble() + ((varList?.get(10) ?: 0).toDouble() - (varList?.get(9) ?: 0).toDouble()) / 10 * (H_pianchaliang.toDouble() - 10)
        H_pianchaliang <= 30 -> (varList?.get(10) ?: 0).toDouble() + ((varList?.get(11) ?: 0).toDouble() - (varList?.get(10) ?: 0).toDouble()) / 10 * (H_pianchaliang.toDouble() - 20)
        else -> (varList?.get(1) ?: 0).toDouble() * H_pianchaliang
    }
    val H_xzl = if (Delta_H >= 0) H_xiuzhengliang else -H_xiuzhengliang
    H_xiuzhengliangFinal = SlRound(H_xzl)
    H_file.close()
    println("qiya: $H_xiuzhengliangFinal")
    println(varList)}
    catch (e:Exception){
        e.printStackTrace()
    }
    return H_xiuzhengliangFinal
}


fun qiyajyf(a: Number, H: Number, Dm: Number,assetManager: AssetManager ): Double {

    val a = a.toInt()
    val Delta_H=(H.toDouble()-750)
    val Dm = Dm.toDouble()
    val H_chabiao = Math.floor(Dm / 1000)
    val H_pianchaliang = abs(Delta_H)
    zhuangyao(a)
    var H_xiuzhengliangFinal = 0.0
    val H_link = zhuangyao(a) + "/qiyaxiuzhengliang.txt"
    try {
        val inputStream = assetManager.open(H_link)
        val H_file = BufferedReader(InputStreamReader(inputStream))
//    val H_file = File(H_link).bufferedReader()
    var n_lines = 0
    var varList: List<Int>? = null
    H_file.forEachLine { line ->
        n_lines++
        if (H_chabiao.toInt() == n_lines) {
            varList = line.trim().split(",").map { it.toInt() }
        }
    }
    val H_xiuzhengliang = when {
        H_pianchaliang == 0.0 -> 0.0
        H_pianchaliang <= 10 -> varList?.get(H_pianchaliang.toInt() - 1)?.toDouble() ?: 0.0
        H_pianchaliang <= 20 -> (varList?.get(9) ?: 0).toDouble() + ((varList?.get(10) ?: 0).toDouble() - (varList?.get(9) ?: 0).toDouble()) / 10 * (H_pianchaliang.toDouble() - 10)
        H_pianchaliang <= 30 -> (varList?.get(10) ?: 0).toDouble() + ((varList?.get(11) ?: 0).toDouble() - (varList?.get(10) ?: 0).toDouble()) / 10 * (H_pianchaliang.toDouble() - 20)
        else -> (varList?.get(1) ?: 0).toDouble() * H_pianchaliang
    }
    val H_xzl = if (Delta_H >= 0) H_xiuzhengliang else -H_xiuzhengliang
        H_xiuzhengliangFinal = SlRound(H_xzl)
    H_file.close()
    println("qiya: $H_xiuzhengliangFinal")
    println(varList)}
    catch (e:Exception){
        e.printStackTrace()
    }
    return H_xiuzhengliangFinal
}


///--------------------------yao wen ----------------///


fun yaowen(a: Number, TY: Number, Dm: Number,assetManager: AssetManager ): Double {
    val a= a.toInt()
    val TY = TY.toDouble()
    val Dm = Dm.toDouble()
    val H_chabiao = Math.floor(Dm / 1000)
    val TY_pianchaliang = abs(TY - 15)
    zhuangyao(a)
    var TY_xiuzhengliangFinal=0.0
    val TY_link = zhuangyao(a) + "/yaowenxiuzhengliang.txt"
    try {
        val inputStream = assetManager.open(TY_link)
        val TY_file = BufferedReader(InputStreamReader(inputStream))
//    val TY_file = File(TY_link).bufferedReader()
    var n_lines = 0
    var varList: List<Int>? = null
    TY_file.forEachLine { line ->
        n_lines++
        if (H_chabiao.toInt() == n_lines) {
            varList = line.trim().split(",").map { it.toInt() }
        }
    }
    val TY_xiuzhengliang = when {
        TY_pianchaliang == 0.0 -> 0.0
        TY_pianchaliang <= 10 -> varList?.get(TY_pianchaliang.toInt() - 1)?.toDouble() ?: 0.0
        TY_pianchaliang <= 20 -> (varList?.get(9) ?: 0).toDouble() + ((varList?.get(10) ?: 0).toDouble() - (varList?.get(9) ?: 0).toDouble()) / 10 * (TY_pianchaliang.toDouble() - 10)
        TY_pianchaliang <= 30 -> (varList?.get(10) ?: 0).toDouble() + ((varList?.get(11) ?: 0).toDouble() - (varList?.get(10) ?: 0).toDouble()) / 10 * (TY_pianchaliang.toDouble() - 20)
        else -> (varList?.get(1) ?: 0).toDouble() * TY_pianchaliang
    }
    TY_xiuzhengliangFinal = if (TY - 15 >= 0) -SlRound(TY_xiuzhengliang) else SlRound(TY_xiuzhengliang)
    TY_file.close()
    println("yaowen: $TY_xiuzhengliangFinal")
    println(varList)}
    catch (e:Exception){
        e.printStackTrace()
    }
    return TY_xiuzhengliangFinal
}


///-----------------------zui da dan dao gao------------------------///



fun zuidadandaogao(a: Number, Dm: Number,assetManager: AssetManager ): Double {
    val a = a.toInt()
    val Dm = Dm.toDouble()
    val Dm_chabiao = (Math.floor(Dm / 1000) - 1) * 5 + 1
    zhuangyao(a)
    var zuidadandaogao_number =0.0
    val zuidadandaogao_link = zhuangyao(a) + "/zongheshuju.txt"
    try {
        val inputStream = assetManager.open(zuidadandaogao_link)
        val zuidadandaogao_file = BufferedReader(InputStreamReader(inputStream))
//    val zuidadandaogao_file = File(zuidadandaogao_link).bufferedReader()
    var n_lines = 0
    var varList: List<Double>? = null
    zuidadandaogao_file.forEachLine { line ->
        n_lines++
        if (Dm_chabiao.toInt() == n_lines) {
            varList = line.trim().split(",").map { it.toDouble() }
        }
    }
     zuidadandaogao_number = SlRound((varList?.get(12) ?: 0).toDouble())
    zuidadandaogao_file.close()
    println("zuidadandaogao: $zuidadandaogao_number")
    println(varList)}
    catch (e:java.lang.Exception){
        e.printStackTrace()
    }
    return zuidadandaogao_number
}



///-------------------------cha biaochi -------------------///
data class ChaBC(val BC:Double,val Delta_M:Double)
fun chaBC(a: Number, D1: Number, D2: Number, Dm: Number, Delta_D1: Number, Delta_D2: Number,assetManager: AssetManager ): ChaBC {
    val a= a.toInt()
    val D1 = D1.toDouble()
    val D2 = D2.toDouble()
    val Dm = Dm.toDouble()
    val Delta_D1= Delta_D1.toDouble()
    val Delta_D2= Delta_D2.toDouble()
    var BC = 0.0

    val Delta_M = (Dm - D1) * (Delta_D2 - Delta_D1) / (D2 - D1) + Delta_D1
    val Dxiuzheng = Dm + Delta_M
    val jiedian_1 = (Dxiuzheng / 200).toInt() * 200

    val D_chabiao1 = Math.floor(jiedian_1 / 200.0) - 4
    val D_chabiao2 = D_chabiao1 + 1
    zhuangyao(a)
    val july_link = zhuangyao(a) + "/zongheshuju.txt"
//    val july_file = File(july_link).bufferedReader()

    try {
        val inputStream = assetManager.open(july_link)
        val july_file = BufferedReader(InputStreamReader(inputStream))
    var n_lines = 0
    var var1: List<Double>? = null
    var var2: List<Double>? = null
    july_file.forEachLine { line ->
        n_lines++
        if (D_chabiao1.toInt() == n_lines) {
            var1 = line.trim().split(",").map { it.toDouble() }
        }

        if (D_chabiao2.toInt() == n_lines) {
            var2 = line.trim().split(",").map { it.toDouble() }

        }
    }
    BC =SlRound((Dxiuzheng - var1!![0]) * (var2!![1] - var1!![1]) / (var2!![0] - var1!![0]) + var1!![1], 2)
    july_file.close()
    println("$Delta_M, $D_chabiao1, $D_chabiao2, $var1, $var2, $BC")}
    catch (e:Exception){
        e.printStackTrace()
    }
    return ChaBC(BC,Delta_M)
}




///---------------------------qi xiang tong bao----------------------------////


data class QixiangResult(val deltaT0: Double, val ff: Double, val vf: Double)

fun qixiangtongbao( bulletHmax: Number,x0:Number=0,x1:Number=0,x2:Number=0,x3:Number=0,x4:Number=0,x5:Number=0,x6:Number=0,x7:Number=0,x8:Number=0,x9:Number=0): QixiangResult {
//    val x0 = x0.toChar()
//    val x1 = x1.toChar()
//    val x2 = x2.toChar()
//    val x3 = x3.toChar()
//    val x4 = x4.toChar()
//    val x5 = x5.toChar()
//    val x6 = x6.toChar()
//    val x7 = x7.toChar()
//    val x8 = x8.toChar()
//    val x9 = x9.toChar()
    var qixiangList = mutableListOf<Number>()
    if (x0!=0){ qixiangList.add(x0)}
    if (x1!=0){ qixiangList.add(x1)}
    if (x2!=0){ qixiangList.add(x2)}
    if (x3!=0){ qixiangList.add(x3)}
    if (x4!=0){ qixiangList.add(x4)}
    if (x5!=0){ qixiangList.add(x5)}
    if (x6!=0){ qixiangList.add(x6)}
    if (x7!=0){ qixiangList.add(x7)}
    if (x8!=0){ qixiangList.add(x8)}
    if (x9!=0){ qixiangList.add(x9)}

    val bulletHmax = bulletHmax.toDouble()


    var deltaT0:Double = 0.0
    var ff:Double =0.0
    var vf:Double = 0.0
    var H1:Double = 0.0
    var H2:Double = 0.0
    var T1:Double = 0.0
    var T2:Double = 0.0
    var Ff1:Double = 0.0
    var Ff2:Double = 0.0
    var Vf1:Double = 0.0
    var Vf2:Double = 0.0
    

    for (i in 0..(qixiangList.size - 1)) {
        val value = qixiangList[i].toDouble()
        if ((value / 1000000).toInt() * 100 >= bulletHmax) {
            val a22 = value
            val a11 = qixiangList[i - 1].toDouble()
            H1= (a11/1000000).toInt().toDouble()
            H2= (a22/1000000).toInt().toDouble()
            T1= ((a11-H1*1000000)/10000).toInt().toDouble()
            T2= ((a22-H2*1000000)/10000).toInt().toDouble()
            Ff1=((a11%10000)/100).toInt().toDouble()
            Ff2=((a22%10000)/100).toInt().toDouble()
            Vf1=(a11%100).toDouble()
            Vf2=(a22%100).toDouble()
            println("$a22,$a11")
            break
        }


    }
    deltaT0 = SlRound((bulletHmax / 100 - H1) * (T2 - T1) / (H2 - H1) + T1)
    ff = SlRound((bulletHmax / 100 - H1) * (Ff2 - Ff1) / (H2 - H1) + Ff1)*100
    vf = SlRound((bulletHmax / 100 - H1) * (Vf2 - Vf1) / (H2 - H1) + Vf1)
    println("$deltaT0,$ff,$vf,$H1,$H2,$T1,$T2")
    return QixiangResult(deltaT0,ff,vf)
}



///-----------------------------------jichushuju---------------------------///

data class Jichushuju(
    val delta_x: Double,
    val bd: Double,
    val delta_GD: Double,
    val t_fly: Double,
    val bc_GD: Double
)

fun jichushuju(a: Number, Dm: Number,assetManager: AssetManager,delta_PM: Number=0): Jichushuju {
    val a= a.toInt()
    val Dm=Dm.toDouble()
    val delta_PM = delta_PM.toDouble()

    var delta_x =0.0
    var bd =0.0
    var delta_GD= 0.0
    var t_fly = 0.0
    var bc_GD = 0.0

    val jiedian_1 = (Dm / 200).toInt() * 200
    val D_chabiao1 = floor(jiedian_1 / 200.0) - 4
    val D_chabiao2 = D_chabiao1 + 1

    val july_link = zhuangyao(a) + "/zongheshuju.txt"
    try {
        val inputStream = assetManager.open(july_link)
        val july_file = BufferedReader(InputStreamReader(inputStream))
//    val july_file = File(july_link).bufferedReader()
    var n_lines = 0
    var var1: List<Double>? = null
    var var2: List<Double>? = null

    july_file.forEachLine { line ->
        n_lines++
        if (D_chabiao1.toInt() == n_lines) {
            var1 = line.split(",").map { it.toDouble() }

        }
        if (D_chabiao2.toInt() == n_lines) {
            var2 = line.split(",").map { it.toDouble() }

        }
    }


    delta_x = SlRound((Dm - var1!![0]) * (var2!![4] - var1!![4]) / (var2!![0] - var1!![0]) + var1!![4], 2)
    bd = SlRound((Dm - var1!![0]) * (var2!![9] - var1!![9]) / (var2!![0] - var1!![0]) + var1!![9], 2)
    delta_GD = SlRound((Dm - var1!![0]) * (var2!![5] - var1!![5]) / (var2!![0] - var1!![0]) + var1!![5], 2)
    bc_GD = SlRound((delta_PM / 10) * delta_GD, 2)
    t_fly = SlRound((Dm - var1!![0]) * (var2!![6] - var1!![6]) / (var2!![0] - var1!![0]) + var1!![6], 2)

    println(Jichushuju(delta_x,bd,delta_GD,t_fly,bc_GD))}
    catch (e:java.lang.Exception){
        e.printStackTrace()
    }
    return Jichushuju(delta_x, bd, delta_GD, t_fly, bc_GD)
}