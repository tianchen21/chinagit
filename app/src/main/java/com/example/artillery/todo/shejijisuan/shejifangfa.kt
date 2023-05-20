package main.kotlin

import android.content.res.AssetManager
import main.kotlin.SlRound
import java.io.File
import kotlin.math.*

import kotlin.math.*

/////-----------------------------------jing mi fa--------------------------------------///

data class Jmfclass(
    val deltaF: Double,
    val deltaD: Double,
    val cs: Double,
    val hbg: Double,
    val qw: Double,
    val qy: Double,
    val yw: Double,
    val zf: Double,
    val pl: Double,
    val hf: Double)

fun Jmf(
    a: Number, J: Number, Dm: Number,  V0: Number, Ty: Number, H: Number, Hp: Number,assetManager: AssetManager, w: Number = 0.0,x1:Number,x2:Number,x3:Number,x0:Number,x4:Number,x5:Number,x6:Number,x7:Number,x8:Number,x9:Number):Jmfclass {
    val a =a.toInt()
    val J = J.toDouble()

    val V0 = V0.toDouble()
    val Ty =Ty.toDouble()
    val H = H.toDouble()
    val Hp = Hp.toDouble()
    val w = w.toDouble()

    val bulletHmax = zuidadandaogao(a, Dm,assetManager)
    val (deltaT0, Ff, Vf) = qixiangtongbao(bulletHmax,x0, x1, x2, x3, x4, x5, x6, x7, x8, x9)
    val zy = zhuangyao(a)
    val (cs) = chusu(a, V0, Dm,assetManager)
    val (hbg) = haibagao(a, Dm, Hp,assetManager)
    val (qw) = qiwen(a, deltaT0, Dm,assetManager)
    val qy = qiya(a,H, Dm,assetManager)
    val yw = yaowen(a, Ty, Dm,assetManager)
    val zf = zongfeng(a, Dm, J, Ff, Vf,assetManager)

    val pl = pianliuxiuzhengliang(a, Dm,assetManager)
    val hf = hengfeng(a, Dm, J, Ff, Vf,assetManager)

    val deltaD = cs + hbg + qw + qy + yw + zf
    val deltaF = pl + hf

    return Jmfclass(deltaF, deltaD, cs, hbg, qw, qy, yw, zf, pl, hf)
}



///-------------------------------jian yi fa--------------------------------------///

data class jyfclass(val delta_F:Double,val delta_D:Double,val chusuxzl:Double,val qiwenxzl:Double,val qiyaxzl:Double,val yaowenxzl:Double,val zongfengxzl:Double,val pianliuxzl:Double,val hengfengxzl:Double)
fun jyf(a:Number,J:Number,Ff:Number,Vf:Number,T:Number,Dm:Number,V0:Number,Ty:Number,H:Number,assetManager: AssetManager): jyfclass{



    val (chusuxzl) = chusu(a, V0, Dm, assetManager)

    val (qiwenxzl) = qiwenjyf(a, T, Dm,assetManager)
    val qiyaxzl = qiyajyf(a, H, Dm,assetManager)
    val yaowenxzl = yaowen(a, Ty, Dm,assetManager)
    val zongfengxzl = zongfeng(a, Dm, J, Ff, Vf,assetManager)

    var pianliuxzl = pianliuxiuzhengliang(a, Dm,assetManager)
    var hengfengxzl = hengfeng(a, Dm, J, Ff, Vf,assetManager)

    val delta_D = chusuxzl + qiyaxzl + qiwenxzl + yaowenxzl + zongfengxzl
    val delta_F = pianliuxzl + hengfengxzl
    println("$delta_F, $delta_D")
    return jyfclass(delta_F, delta_D, chusuxzl, qiwenxzl, qiyaxzl, yaowenxzl, zongfengxzl, pianliuxzl, hengfengxzl)
}

