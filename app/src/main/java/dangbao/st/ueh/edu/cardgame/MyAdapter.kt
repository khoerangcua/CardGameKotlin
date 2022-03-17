package dangbao.st.ueh.edu.cardgame

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(var context: Context, var ds: ArrayList<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return ds.size
    }

    override fun getItem(p0: Int): Any {
        return ds.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var layoutInflater: LayoutInflater = LayoutInflater.from(context)
        var view : View = layoutInflater.inflate(R.layout.item_layout, null)
        var textView : TextView = view.findViewById<TextView>(R.id.card)
        textView.setText(ds.get(p0))
        return view
    }
}