package com.jslee.adapterViews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val adapterViews = arrayOf(
            "ListView", "CustomListView",
            "ArrayAdapter", "SimpleAdapter", "CustomAdapter",
            "Spinner", "GrideView", "ViewPager",
            "AutoCompleteTextView", "Single/Multi ChoiceListView",
            "RecyclerView")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}




