package dangbao.st.ueh.edu.cardgame

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    var bien1: TextView? = null
    var bien2:TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emoji: Array<Int> = arrayOf(
            8986,9973,9940,9924,9973,8986,8987,9917,9940,8987,9917,9924,9925,9970,9925,9970
        )
        val myList: ArrayList<String> = ArrayList<String>()
        for (i in emoji) {
            myList.add(i.toChar().toString())
        }

        val myadapter: MyAdapter = MyAdapter(applicationContext, myList)
        mygrid.adapter = myadapter

        mygrid.setOnItemClickListener(OnItemClickListener { adapterView, view, i, l ->
            val textview = view.findViewById<View>(R.id.card) as TextView
            if (bien1 == null) {
                bien1 = textview
            } else {
                bien2 = textview
            }
            if (bien1 != null && bien2 != null) {
                if (bien1!!.text.toString().compareTo(bien2!!.getText().toString()) == 0) {
                    Toast.makeText(this@MainActivity, "Bang nhau", Toast.LENGTH_SHORT).show()
                    bien1!!.visibility = View.INVISIBLE
                    bien2!!.setVisibility(View.INVISIBLE)
                } else {
                    Toast.makeText(this@MainActivity, "Khong bang", Toast.LENGTH_SHORT).show()
                }
                bien1 = null
                bien2 = null
            }
        })
    }
}