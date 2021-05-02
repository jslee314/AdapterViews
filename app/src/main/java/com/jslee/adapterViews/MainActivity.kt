package com.jslee.adapterViews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val adapterViewDatas = arrayOf("ListView(ArrayAdapter)", "Custom ListView1(ArrayAdapter)",
        "Custom ListView2(SimpleAdapter)", "Custom Adapter View(BaseAdapter)",
            "Spinner", "GrideView", "ViewPager",
            "AutoCompleteTextView", "Single/Multi ChoiceListView",
            "RecyclerView(RecyclerView.Adapter)")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ArrayAdapter(Context, 항목 하나를 구성하기 위해 사용할 layout 파일)
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, adapterViewDatas)
        listView.adapter = adapter1
        listView.setOnItemClickListener(listener1)

    }

    val listener1 = object : AdapterView.OnItemClickListener{

        // onItemClick (이벤트가 발생한 항목을 가지고 있는 AdapterView, 이벤트가 발생한 항목View, 이벤트가 발생한 항목의 index)
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            when(parent?.id){
                R.id.listView -> {
                    textViewTitle.text = "${adapterViewDatas[position]} \n보러가기 !! "

                    when(adapterViewDatas[position]){
                        "ListView(ArrayAdapter)" ->{

                        }
                        "Custom ListView1(ArrayAdapter)" ->{
                            val intent = Intent(this@MainActivity, CustomListViewActivity::class.java)
                            startActivity(intent)
                        }
                        "Custom ListView2(SimpleAdapter)" ->{
                            val intent = Intent(this@MainActivity, CustomListView2Activity::class.java)
                            startActivity(intent)

                        }
                        "Custom Adapter View(BaseAdapter)" ->{
                            val intent = Intent(this@MainActivity, CustomAdapterViewActivity::class.java)
                            startActivity(intent)

                        }
                        "Spinner" ->{


                        }
                        "GrideView" ->{


                        }
                        "ViewPager" ->{


                        }
                        "AutoCompleteTextView" ->{


                        }
                        "Single/Multi ChoiceListView" ->{


                        }
                        "RecyclerView(RecyclerView.Adapter)" ->{
                            val intent = Intent(this@MainActivity, RecyclerViewActivity::class.java)
                            startActivity(intent)

                        }
                    }
                }
            }
        }
    }
}




