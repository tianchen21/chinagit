package com.example.artillery

import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import android.content.Intent.getIntentOld
import android.content.res.AssetManager

import android.view.Gravity



import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.artillery.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import main.kotlin.SlRound
import main.kotlin.chaBC
import main.kotlin.jichushuju
import main.kotlin.jyf
import kotlin.math.abs


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Step2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Step2 : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_jyfstep2, container, false)



        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Step2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Step2().apply {
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
        val hjyf = view.findViewById<EditText>(R.id.hjyf)
        val ajyf = view.findViewById<EditText>(R.id.ajyf)
        val jjyf = view.findViewById<EditText>(R.id.jjyf)
        val ffjyf = view.findViewById<EditText>(R.id.ffjyf)
        val vfjyf = view.findViewById<EditText>(R.id.vfjyf)
        val tjyf = view.findViewById<EditText>(R.id.tjyf)
        val tyjyf = view.findViewById<EditText>(R.id.tyjyf)
        val vojyf = view.findViewById<EditText>(R.id.vojyf)
        val dmjyf = view.findViewById<EditText>(R.id.dmjyf)
        val d1jyf = view.findViewById<EditText>(R.id.d1jyf)
        val d2jyf = view.findViewById<EditText>(R.id.d2jyf)
        val fm = view.findViewById<EditText>(R.id.fmjyf)
        val dgm =view.findViewById<EditText>(R.id.dgmjyf)
        val fgm =view.findViewById<EditText>(R.id.fgmjyf)
        val hp =view.findViewById<EditText>(R.id.hpjyf)
        val hm =view.findViewById<EditText>(R.id.hmjyf)
        buttonAdd.setOnClickListener {
        val H = hjyf.text.toString().toDouble()
        val a = ajyf.text.toString().toDouble()
        val Ff = ffjyf.text.toString().toDouble()
        val Vf= vfjyf.text.toString().toDouble()
        val T = tjyf.text.toString().toDouble()
        val J = jjyf.text.toString().toDouble()
        val D1 =d1jyf.text.toString().toDouble()
        val D2 =d2jyf.text.toString().toDouble()
        val Dm =dmjyf.text.toString().toDouble()
        val Vo =vojyf.text.toString().toDouble()
        val Ty =tyjyf.text.toString().toDouble()
        val Hm= hm.text.toString().toDouble()
            val Hp= hp.text.toString().toDouble()
            val Fm= fm.text.toString().toDouble()
            val Fgm= fgm.text.toString().toDouble()
            val Dgm= dgm.text.toString().toDouble()
            val (delta_F1, delta_D1, chusuxzl1, qiwenxzl1, qiyaxzl1, yaowenxzl1, zongfengxzl1, pianliuxzl1, hengfengxzl1) = jyf(
                a,
                J,
                Ff,
                Vf,
                T,
                D1,
                Vo,
                Ty,
                H,assetManager
            )

            val (delta_F2, delta_D2, chusuxzl2, qiwenxzl2, qiyaxzl2, yaowenxzl2, zongfengxzl2, pianliuxzl2, hengfengxzl2) = jyf(
                a,
                J,
                Ff,
                Vf,
                T,
                D2,
                Vo,
                Ty,
                H,assetManager
            )

//            val (delta_Fm, delta_Dm, chusuxzlm, qiwenxzlm, qiyaxzlm, yaowenxzlm, zongfengxzlm, pianliuxzlm, hengfengxzlm) = jyf(
//                a,
//                J,
//                Ff,
//                Vf,
//                T,
//                Dm,
//                Vo,
//                Ty,
//                H,assetManager
//            )



            view.findViewById<TextView>(R.id.voxzl1).text = chusuxzl1.toInt().toString()
            view.findViewById<TextView>(R.id.txzl1).text = qiwenxzl1.toInt().toString()
            view.findViewById<TextView>(R.id.hxzl1).text = qiyaxzl1.toInt().toString()
            view.findViewById<TextView>(R.id.tyxzl1).text = yaowenxzl1.toInt().toString()
            view.findViewById<TextView>(R.id.zfxzl1).text = zongfengxzl1.toInt().toString()
            view.findViewById<TextView>(R.id.zxzl1).text = pianliuxzl1.toString()
            view.findViewById<TextView>(R.id.hfxzl1).text = hengfengxzl1.toString()
            view.findViewById<TextView>(R.id.sumd1).text = delta_D1.toInt().toString()
            view.findViewById<TextView>(R.id.sumf1).text = delta_F1.toString()
            view.findViewById<TextView>(R.id.voxzl2).text = chusuxzl2.toInt().toString()
            view.findViewById<TextView>(R.id.txzl2).text = qiwenxzl2.toInt().toString()
            view.findViewById<TextView>(R.id.hxzl2).text = qiyaxzl2.toInt().toString()
            view.findViewById<TextView>(R.id.tyxzl2).text = yaowenxzl2.toInt().toString()
            view.findViewById<TextView>(R.id.zfxzl2).text = zongfengxzl2.toInt().toString()
            view.findViewById<TextView>(R.id.zxzl2).text = pianliuxzl2.toString()
            view.findViewById<TextView>(R.id.hfxzl2).text = hengfengxzl2.toString()
            view.findViewById<TextView>(R.id.sumd2).text = delta_D2.toInt().toString()
            view.findViewById<TextView>(R.id.sumf2).text = SlRound(delta_F2,1).toString()
//            view.findViewById<TextView>(R.id.voxzl3).text = chusuxzlm.toInt().toString()
//            view.findViewById<TextView>(R.id.txzl3).text = qiwenxzlm.toInt().toString()
//            view.findViewById<TextView>(R.id.hxzl3).text = qiyaxzlm.toInt().toString()
//            view.findViewById<TextView>(R.id.tyxzl3).text = yaowenxzlm.toInt().toString()
//            view.findViewById<TextView>(R.id.zfxzl3).text = zongfengxzlm.toInt().toString()
//            view.findViewById<TextView>(R.id.zxzl3).text = pianliuxzlm.toString()
//            view.findViewById<TextView>(R.id.hfxzl3).text = hengfengxzlm.toString()
//            view.findViewById<TextView>(R.id.sumd3).text = delta_Dm.toInt().toString()
//            view.findViewById<TextView>(R.id.sumf3).text = delta_Fm.toString()

            val (bc, Delta_M) = chaBC(a, D1, D2, Dm, delta_D1, delta_D2, assetManager)
            val deltafm = delta_F2-(D2-Dm)*(delta_F2-delta_F1)/(D2-D1)
            view.findViewById<TextView>(R.id.fmxzl).text = SlRound(deltafm,2).toString()
            view.findViewById<TextView>(R.id.akm).text = bc.toString()
            view.findViewById<TextView>(R.id.dmxzl).text = Delta_M.toInt().toString()
            val fkm= Fm+deltafm
            view.findViewById<TextView>(R.id.fkm).text = SlRound(fkm,1).toString()
            val delta_PM = Hm - Hp
            val (delta_x, bd, delta_GD, t_fly, bc_GD) = jichushuju(
                a,
                Dm,
                assetManager,
                delta_PM
            )
            view.findViewById<TextView>(R.id.tfly).text = delta_x.toString()
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