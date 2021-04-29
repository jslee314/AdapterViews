package com.jslee.adapterViews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_custom_list_view.*

class CustomListViewActivity : AppCompatActivity() {
    val titleData = arrayOf("문자열1", "문자열2", "문자열3", "문자열4", "문자열5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view)

        val adapter1 = ArrayAdapter(this, R.layout.row_custom_list, R.id.rowTextView, titleData)
        customList.adapter = adapter1

        customList.setOnItemClickListener { parent, view, position, id ->
            textView.text = "${titleData[position]}를 터치하였습니다"
        }

    }
}