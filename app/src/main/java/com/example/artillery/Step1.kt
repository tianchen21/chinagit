package com.example.artillery

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.artillery.todo.jichuyunsuan.Niyunsuan
import com.example.artillery.todo.jichuyunsuan.calculateNiyunsuan
import com.example.artillery.todo.jichuyunsuan.calculateZhengyunsuan

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Step1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Step1 : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_jyfstep1, container, false)


        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonAdd1 = view.findViewById<Button>(R.id.results1)
        val buttonAdd2 = view.findViewById<Button>(R.id.results2)
        val xp = view.findViewById<EditText>(R.id.xp)
        val yp = view.findViewById<EditText>(R.id.yp)
        val hp = view.findViewById<EditText>(R.id.hp)
        var xm = view.findViewById<EditText>(R.id.xm)
        var ym = view.findViewById<EditText>(R.id.ym)
        var hm = view.findViewById<EditText>(R.id.hm)
        val xg = view.findViewById<EditText>(R.id.xg)
        val yg = view.findViewById<EditText>(R.id.yg)
        val hg = view.findViewById<EditText>(R.id.hg)

        buttonAdd1.setOnClickListener {
            val XP =xp.text.toString().toDouble()
            val YP =yp.text.toString().toDouble()
            val HP = hp.text.toString().toDouble()
            var XM = xm.text.toString().toDouble()
            var YM = ym.text.toString().toDouble()
            var HM = hm.text.toString().toDouble()
            val XG = xg.text.toString().toDouble()
            val YG = yg.text.toString().toDouble()
            val HG = hg.text.toString().toDouble()

            var (Dpm, e, apm, Dpm_n) = calculateNiyunsuan(XP, YP, XM, YM,HP, HM)
            view.findViewById<TextView>(R.id.dkm).text = Dpm.toString()
            view.findViewById<TextView>(R.id.ekm).text = e.toString()
            view.findViewById<TextView>(R.id.fkm).text = apm.toString()
            var (Dgm, egm, agm, Dgm_n) = calculateNiyunsuan(XG, YG, XM, YM,HG, HM)
            view.findViewById<TextView>(R.id.dgm).text = Dgm.toString()
            view.findViewById<TextView>(R.id.egm).text = egm.toString()
            view.findViewById<TextView>(R.id.fgm).text = agm.toString()
            val bundle = Bundle()
            bundle.putString("key",Dpm.toString())

        }
        buttonAdd2.setOnClickListener {

            var dgm =view.findViewById<EditText>(R.id.dgm)
            var fgm =view.findViewById<EditText>(R.id.fgm)
            var egm =view.findViewById<EditText>(R.id.egm)
            val XG = xg.text.toString().toDouble()
            val YG = yg.text.toString().toDouble()
            val HG = hg.text.toString().toDouble()

            var DGM = dgm.text.toString().toDouble()
            var FGM = fgm.text.toString().toDouble()
            var EGM = egm.text.toString().toDouble()

            var (xm1,ym1,hm1) = calculateZhengyunsuan(XG,YG,DGM,FGM,EGM,HG)
            view.findViewById<TextView>(R.id.xm).text = xm1.toString()
            view.findViewById<TextView>(R.id.ym).text = ym1.toString()
            view.findViewById<TextView>(R.id.hm).text = hm1.toString()
            val XP =xp.text.toString().toDouble()
            val YP =yp.text.toString().toDouble()
            val HP = hp.text.toString().toDouble()
            var (Dkm, ekm, fkm, Dpm_n) = calculateNiyunsuan(XP, YP, xm1, ym1,HP, hm1)
            view.findViewById<TextView>(R.id.dkm).text = Dkm.toString()
            view.findViewById<TextView>(R.id.ekm).text = ekm.toString()
            view.findViewById<TextView>(R.id.fkm).text = fkm.toString()


        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Step1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Step1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }




//
}
//
