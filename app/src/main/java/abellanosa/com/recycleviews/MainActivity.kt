//to create a recyler view we need three things. The recyler view, an adapter for the recyler view, and the layout we want to use

package abellanosa.com.recycleviews

import abellanosa.com.recycleviews.data.PersonListAdapter
import abellanosa.com.recycleviews.model.Person
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var adapter: PersonListAdapter ?= null
    private var personList: ArrayList<Person> ?= null
    private var layoutManager: RecyclerView.LayoutManager ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personList = ArrayList<Person>()//this is the set of data you will print out or occupy the inflated layout
        layoutManager = LinearLayoutManager(this)// this is the layout manager
        adapter = PersonListAdapter(personList!!, this)//instance of the personlistadapter class

        //setup list (Recycler View)
        rv_list.layoutManager = layoutManager//assigning the layout manager of our recylerview with the layoutManager
        rv_list.adapter = adapter//assigns the adapter of our recyclerview with the personlistadapter

        //load data
        for(i in 0..16){
            //for testing purposes we use static data in our arrayList
            val person = Person()
            person.name = "Mickey $i"
            person.age = 20+i
            personList!!.add(person)
        }

        adapter!!.notifyDataSetChanged()//this refreshes the list, and shows the data we inserted
    }
}
