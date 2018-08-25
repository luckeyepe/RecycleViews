package abellanosa.com.recycleviews.data

import abellanosa.com.recycleviews.R
import abellanosa.com.recycleviews.model.Person
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

//this custom class extends from the RecylerView.adapter class, the RecylerView.adapter is a ViewHolder (since it holds the views)
class PersonListAdapter(private val list: ArrayList<Person>, private val context: Context) : RecyclerView.Adapter<PersonListAdapter.ViewHolder>(){
    //the following 3 methods are just implemented members (just use alt+enter when you see an error on the PersonListAdapter)

    //this method gets the number of items in the recylerView
    override fun getItemCount(): Int {
        return list.size
    }

    //this binds the layout we chose as an item in the recyler view to the recyler view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        //create view from xml file
        val view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false)
        return ViewHolder(view)
    }

    //this is another class. This is responsible with binding the data we want to fill each item in the recycler view
    //this class extends from the RecylerView.ViewHolder class
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(person: Person){
            var name: TextView = itemView.findViewById(R.id.tv_name) as TextView
            var age: TextView = itemView.findViewById(R.id.tv_age) as TextView

            name.text = person.name
            age.text = person.age.toString()

            itemView.setOnClickListener{
                //to start activities by pressing button
//                context.startActivities(this, SecondActivity::java.class)
                Toast.makeText(context, "My name is ${name.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

}