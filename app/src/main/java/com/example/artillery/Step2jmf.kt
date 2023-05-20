package com.example.artillery

import android.content.res.AssetManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import main.kotlin.Jmf
import main.kotlin.SlRound
import main.kotlin.chaBC
import main.kotlin.jichushuju
import kotlin.math.abs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Step2jmf.newInstance] factory method to
 * create an instance of this fragment.
 */
class Step2jmf : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_step2jmf, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Step2jmf.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Step2jmf().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val assetManager: AssetManager = requireActivity().assets
        val buttonAdd = view.findViewById<Button>(R.id.resultsstep2)
        val hjmf = view.findViewById<EditText>(R.id.hjmf)
        val ajmf = view.findViewById<EditText>(R.id.ajmf)
        val jjmf = view.findViewById<EditText>(R.id.jjmf)
        val weidu = view.findViewById<EditText>(R.id.weidu)
        val hp = view.findViewById<EditText>(R.id.hpjmf)
        val dgm = view.findViewById<EditText>(R.id.dgmjmf)

        val jcjmf = view.findViewById<EditText>(R.id.jcjmf)
        val tyjmf = view.findViewById<EditText>(R.id.tyjmf)
        val vojmf = view.findViewById<EditText>(R.id.vojmf)
        val dmjmf = view.findViewById<EditText>(R.id.dmjmf)
        val d1jmf = view.findViewById<EditText>(R.id.d1jmf)
        val d2jmf = view.findViewById<EditText>(R.id.d2jmf)
        val d3jmf = view.findViewById<EditText>(R.id.d3jmf)
        val fmjmf = view.findViewById<EditText>(R.id.fmjmf)
        val x0 = view.findViewById<EditText>(R.id.x0)
        val x1 = view.findViewById<EditText>(R.id.x1)
        val x2 = view.findViewById<EditText>(R.id.x2)
        val x3 = view.findViewById<EditText>(R.id.x3)
        val x4 = view.findViewById<EditText>(R.id.x4)
        val x5 = view.findViewById<EditText>(R.id.x5)
        val x6= view.findViewById<EditText>(R.id.x6)
        val x7 = view.findViewById<EditText>(R.id.x7)
        val x8 = view.findViewById<EditText>(R.id.x8)
        val x9 = view.findViewById<EditText>(R.id.x9)
        val x10 = view.findViewById<EditText>(R.id.x10)
        val x11 = view.findViewById<EditText>(R.id.x11)
        val fgm =view.findViewById<EditText>(R.id.fgmjmf)
        val hm = view.findViewById<EditText>(R.id.hmjmf)
        buttonAdd.setOnClickListener {
            val H = hjmf.text.toString().toDouble()
            val a = ajmf.text.toString().toDouble()
            val J = jjmf.text.toString().toDouble()
            val Weidu = weidu.text.toString().toDouble()
            val Hp = hp.text.toString().toDouble()
            val Hm = hm.text.toString().toDouble()
            val Jc = jcjmf.text.toString().toDouble()
            val Vo = vojmf.text.toString().toDouble()
            val Ty = tyjmf.text.toString().toDouble()

            val D1 = d1jmf.text.toString().toDouble()
            val D2 = d2jmf.text.toString().toDouble()
            val D3 = d3jmf.text.toString().toDouble()
            val Dm = dmjmf.text.toString().toDouble()
            val Fm = fmjmf.text.toString().toDouble()
            val X0 = x0.text.toString().toDouble()
            val X1 = x1.text.toString().toDouble()
            val X2 = x2.text.toString().toDouble()
            val X3 = x3.text.toString().toDouble()
            val X4 = x4.text.toString().toDouble()
            val X5 = x5.text.toString().toDouble()
            val X6 = x6.text.toString().toDouble()
            val X7 = x7.text.toString().toDouble()
            val X8 = x8.text.toString().toDouble()
            val X9 = x9.text.toString().toDouble()
            val X10 = x10.text.toString().toDouble()
            val X11 = x11.text.toString().toDouble()
            val Fgm= fgm.text.toString().toDouble()
            val Dgm = dgm.text.toString().toDouble()

            val (deltaF1, deltaD1, cs1, hbg1, qw1, qy1, yw1, zf1, pl1, hf1) = Jmf(
                a,
                Jc,
                D1,
                Vo,
                Ty,
                H,
                Hp,
                assetManager,
                Weidu,
                X1,
                X2,
                X3,
                X0,
                X4,
                X5,
                X6,
                X7,
                X8,
                X9
            )
            val (deltaF2, deltaD2, cs2, hbg2, qw2, qy2, yw2, zf2, pl2, hf2) = Jmf(
                a,
                Jc,
                D2,
                Vo,
                Ty,
                H,
                Hp,
                assetManager,
                Weidu,
                X1,
                X2,
                X3,
                X0,
                X4,
                X5,
                X6,
                X7,
                X8,
                X9
            )
            val (deltaF3, deltaD3, cs3, hbg3, qw3, qy3, yw3, zf3, pl3, hf3) = Jmf(
                a,
                Jc,
                D3,
                Vo,
                Ty,
                H,
                Hp,
                assetManager,
                Weidu,
                X1,
                X2,
                X3,
                X0,
                X4,
                X5,
                X6,
                X7,
                X8,X9
            )


            view.findViewById<TextView>(R.id.voxzl1).text = cs1.toInt().toString()
            view.findViewById<TextView>(R.id.hpxzl1).text = hbg1.toInt().toString()
            view.findViewById<TextView>(R.id.txzl1).text = qw1.toInt().toString()
            view.findViewById<TextView>(R.id.hxzl1).text = qy1.toInt().toString()
            view.findViewById<TextView>(R.id.tyxzl1).text = yw1.toInt().toString()
            view.findViewById<TextView>(R.id.zfxzl1).text = zf1.toInt().toString()
            view.findViewById<TextView>(R.id.zxzl1).text = pl1.toString()
            view.findViewById<TextView>(R.id.hfxzl1).text = hf1.toString()
            view.findViewById<TextView>(R.id.sumd1).text = deltaD1.toInt().toString()
            view.findViewById<TextView>(R.id.sumf1).text = SlRound(deltaF1,2).toString()
            view.findViewById<TextView>(R.id.voxzl2).text = cs2.toInt().toString()
            view.findViewById<TextView>(R.id.hpxzl2).text = hbg2.toInt().toString()
            view.findViewById<TextView>(R.id.txzl2).text = qw2.toInt().toString()
            view.findViewById<TextView>(R.id.hxzl2).text = qy2.toInt().toString()
            view.findViewById<TextView>(R.id.tyxzl2).text = yw2.toInt().toString()
            view.findViewById<TextView>(R.id.zfxzl2).text = zf2.toInt().toString()
            view.findViewById<TextView>(R.id.zxzl2).text = pl2.toString()
            view.findViewById<TextView>(R.id.hfxzl2).text = hf2.toString()
            view.findViewById<TextView>(R.id.sumd2).text = deltaD2.toInt().toString()
            view.findViewById<TextView>(R.id.sumf2).text = SlRound(deltaF2,2).toString()
            view.findViewById<TextView>(R.id.voxzl3).text = cs3.toInt().toString()
            view.findViewById<TextView>(R.id.hpxzl3).text = hbg3.toInt().toString()
            view.findViewById<TextView>(R.id.txzl3).text = qw3.toInt().toString()
            view.findViewById<TextView>(R.id.hxzl3).text = qy3.toInt().toString()
            view.findViewById<TextView>(R.id.tyxzl3).text = yw3.toInt().toString()
            view.findViewById<TextView>(R.id.zfxzl3).text = zf3.toInt().toString()
            view.findViewById<TextView>(R.id.zxzl3).text = pl3.toString()
            view.findViewById<TextView>(R.id.hfxzl3).text = hf3.toString()
            view.findViewById<TextView>(R.id.sumd3).text = deltaD3.toInt().toString()
            view.findViewById<TextView>(R.id.sumf3).text = SlRound(deltaF3,2).toString()

            if (D1 <= Dm && Dm < D2) {
                val (bc, Delta_M) = chaBC(a, D1, D2, Dm, deltaD1, deltaD2, assetManager)
                val deltafm = deltaF2-(D2-Dm)*(deltaF2-deltaF1)/(D2-D1)
                view.findViewById<TextView>(R.id.fmxzl).text = SlRound(deltafm,2).toString()
                view.findViewById<TextView>(R.id.akm).text = bc.toString()
                view.findViewById<TextView>(R.id.dmxzl).text = Delta_M.toInt().toString()
                val fkm= Fm+deltafm
                view.findViewById<TextView>(R.id.fkm).text = fkm.toString()
            } else {
                val (bc, Delta_M) = chaBC(a, D2, D3, Dm, deltaD2, deltaD3, assetManager)
                val deltafm = deltaF2-(D2-Dm)*(deltaF2-deltaF1)/(D2-D1)
                view.findViewById<TextView>(R.id.akm).text = bc.toString()
                view.findViewById<TextView>(R.id.dmxzl).text = Delta_M.toInt().toString()
                view.findViewById<TextView>(R.id.fmxzl).text = SlRound(deltafm,2).toString()
                val fkm= Fm+deltafm
                view.findViewById<TextView>(R.id.fkm).text = SlRound(fkm).toInt().toString()
            }


            val delta_PM = Hm - Hp
            val (delta_x, bd, delta_GD, t_fly, bc_GD) = jichushuju(
                a,
                Dm,
                assetManager,
                delta_PM
            )
            view.findViewById<TextView>(R.id.tfly).text = SlRound(delta_x,1).toString()
            view.findViewById<TextView>(R.id.bd).text = bd.toString()
            view.findViewById<TextView>(R.id.gdxzl).text = bc_GD.toString()
            val Fgmpc = Fgm-J
            val Fpmpc = Fm - J
            val j = abs(Fgmpc-Fpmpc)
            view.findViewById<TextView>(R.id.fgmxzl).text = SlRound(Fgmpc).toInt().toString()
            view.findViewById<TextView>(R.id.fpmxzl).text = SlRound(Fpmpc).toInt().toString()
            view.findViewById<TextView>(R.id.gockep).text = SlRound(j).toInt().toString()
            val B = Dgm/Dm
            val L = j/(0.01*Dm)
            view.findViewById<TextView>(R.id.fxb).text = SlRound(B,2).toString()
            view.findViewById<TextView>(R.id.xzlv).text = SlRound(L,2).toString()

        }



    }
}