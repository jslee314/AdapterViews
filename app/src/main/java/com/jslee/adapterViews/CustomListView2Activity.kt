package com.jslee.adapterViews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_custom_list_view2.*

class CustomListView2Activity : AppCompatActivity() {

    val imgRes = arrayOf(R.drawable.food_icon_barbecue, R.drawable.food_icon_beer,
        R.drawable.food_icon_bobatea, R.drawable.food_icon_burger, R.drawable.food_icon_coffee,
        R.drawable.food_icon_cupcake, R.drawable.food_icon_donut, R.drawable.food_icon_noodle,
        R.drawable.food_icon_pizza, R.drawable.food_icon_steak)

    val dataKR = arrayOf("바베큐", "맥주", "버블티", "버거", "커피",
        "컵케이크", "도넛", "국수", "피자", "스테이크")

    val dataEN = arrayOf("barbecue", "beer", "bobatea", "burger", "coffee",
        "cupcake", "donut", "noodle", "pizza", "steak")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view2)

        // simple adapter에 셋팅할 데이터를 가지고 있을 ArrayList
        val dataList = ArrayList<HashMap<String, Any>>()

        for(i in imgRes.indices){
            // 항목 하나를 구성하기 위해 필요한 데이터를 담고 있는 HashMap
            val map = HashMap<String, Any>()
            map["img"] = imgRes[i]
            map["data_kr"] = dataKR[i]
            map["data_en"] = dataEN[i]
            dataList.add(map)
        }

        // HashMap에 데이터를 저장했을 때 사용했던 이름 배열
        val keys = arrayOf("img", "data_kr", "data_en")

        // 데이터를 셋팅할 View의 id 배열
        val ids = intArrayOf(R.id.rowImageView, R.id.rowKRTextView, R.id.rowENTextView)


        val adapter1 = SimpleAdapter(this, dataList, R.layout.row_custom_list2, keys, ids)
        listView.adapter = adapter1


        listView.setOnItemClickListener { parent, view, position, id ->
            textView.text = "${dataKR[position]}항목을 터치하였습니다"
        }

    }
}