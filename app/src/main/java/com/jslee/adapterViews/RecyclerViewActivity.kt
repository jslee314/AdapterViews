package com.jslee.adapterViews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.row_recycler_view.view.*

class RecyclerViewActivity : AppCompatActivity() {
    val imgRes = arrayOf(R.drawable.food_icon_barbecue, R.drawable.food_icon_beer,
            R.drawable.food_icon_bobatea, R.drawable.food_icon_burger, R.drawable.food_icon_coffee,
            R.drawable.food_icon_cupcake, R.drawable.food_icon_donut, R.drawable.food_icon_noodle,
            R.drawable.food_icon_pizza, R.drawable.food_icon_steak)

    val dataKR = arrayOf("바베큐", "맥주", "버블티", "버거", "커피",
            "컵케이크", "도넛", "국수", "피자", "스테이크")

    val dataENText = arrayOf("barbecue is delicious", "beer is delicious", "bobatea is delicious",
            "burger is delicious", "coffee is delicious", "cupcake is delicious",
            "donut is delicious", "noodle is delicious", "pizza is delicious", "steak is delicious")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)


        val myAdapter = MyRecyclerAdapter()
        //
        recycler_view.adapter = myAdapter

//         recycler_view.layoutManager = LinearLayoutManager(this)
//        recycler_view.layoutManager = GridLayoutManager(this, 2)
        recycler_view.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//         recycler_view.layoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL)



    }


    /**
    * @내용 : 
    * @수정 :
    * @버젼 : 0.0.0
    * @최초작성일 : 2021-05-02 오후 6:10
    * @작성자 : 이재선
    **/

    // 부모 클래스인 RecyclerView.Adapter 클래스를 만들때 자료형을 결정하지 않았는데(제네릭)
    // 자식클래스로 상속하면서 MyRecyclerAdapter.ViewHolderClass 자료형(->자식클래스에서 구현한 자료형)으로 결정하면서 상속함
    inner class MyRecyclerAdapter : RecyclerView.Adapter<MyRecyclerAdapter.ViewHolderClass>(){

        // 항목 구성을 위해 사용할 ViewHolder 객체가 필요할 때 호출되는 메서드
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerAdapter.ViewHolderClass {
            // 항목으로 사용할 View 객체를 생성한다.
            val itemView = layoutInflater.inflate(R.layout.row_recycler_view, null)
            val holder = ViewHolderClass(itemView)
            itemView.setOnClickListener(holder)

            return holder
        }

        override fun getItemCount(): Int {
            return imgRes.size
        }

        override fun onBindViewHolder(holder: MyRecyclerAdapter.ViewHolderClass, position: Int) {
            holder.rowImageView.setImageResource(imgRes[position])
            holder.rowTextView1.text = dataKR[position]
            holder.rowTextView2.text = dataENText[position]
        }

        /**
        * @내용 : ViewHolder 클래스
        * @수정 :
        * @버젼 : 0.0.0
        * @최초작성일 : 2021-05-02 오후 7:02
        * @작성자 : 이재선
        **/
        inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
            // 항목 View 내부의 View 객체의 주소값을 담는다.
            val rowImageView = itemView.rowImageView
            val rowTextView1 = itemView.rowTextView1
            val rowTextView2 = itemView.rowTextView2

            override fun onClick(v: View?) {
                textView1.text = dataKR[adapterPosition]
            }
        }


    }
}
