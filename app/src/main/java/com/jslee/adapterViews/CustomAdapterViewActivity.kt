package com.jslee.adapterViews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_custom_adapter_view.*
import kotlinx.android.synthetic.main.row_custom_adapter.view.*

class CustomAdapterViewActivity : AppCompatActivity() {

    val data1 = arrayOf("데이터1", "데이터2", "데이터3", "데이터4", "데이터5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_adapter_view)

        val myAdapter = myBaseAdapter()
        customAdapter.adapter = myAdapter

    }
    /**
    * "BaseAdapter"클래스 상속받아서 adapter1를 구현함
    **/
    inner class myBaseAdapter : BaseAdapter(){
        // 항목의 개수를 반환한다.
        override fun getCount(): Int {
            return data1.size
        }
        override fun getItem(position: Int): Any? {
            return null
        }
        override fun getItemId(position: Int): Long {
            return 0
        }

        // 항목 하나를 구성하기 위해 호출되는 메서드
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            // 재사용 가능한 View를 변수에 담는다.
            var rowView = convertView

            if(rowView == null){
                rowView = layoutInflater.inflate(R.layout.row_custom_adapter, null)
            }

            // 원하는 기능 구현
            rowView?.run{
                rowTextView.text = data1[position]

                rowButton1.tag = position
                rowButton2.tag = position

                rowButton1.setOnClickListener { textView.text = "첫 번째 버튼을 눌렀습니다 : ${it.tag}" }
                rowButton2.setOnClickListener { textView.text = "두 번째 버튼을 눌렀습니다 : ${it.tag}" }
            }

            return rowView!!
        }
    }
}