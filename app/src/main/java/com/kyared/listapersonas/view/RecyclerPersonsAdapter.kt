package com.kyared.listapersonas.view

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.kyared.listapersonas.BR
import com.kyared.listapersonas.model.Person
import com.kyared.listapersonas.viewmodel.PersonViewModel

class RecyclerPersonsAdapter(var personViewModel: PersonViewModel, var resource: Int) : androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerPersonsAdapter.CardPersonHolder>() {

    var persons: List<Person>? = null

    fun setPersonsList(persons: List<Person>?){
        this.persons= persons
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardPersonHolder {
        var layoutInflater: LayoutInflater = LayoutInflater.from(p0.context)
        var binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, p1, p0, false)
        return CardPersonHolder(binding)
    }

    override fun getItemCount(): Int {
        return persons?.size ?: 0
    }

    override fun onBindViewHolder(p0: CardPersonHolder, p1: Int) {
        p0.setDataCard(personViewModel, p1)
        p0.itemView.setOnClickListener{ v ->
            val context = p0.itemView.context
            val i = Intent(context, PersonDetail::class.java)
            i.putExtra("person", persons?.get(p1))
            context.startActivity(i)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    fun getLayoutIdForPosition(position: Int): Int{
        return resource
    }

    class CardPersonHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }

        fun setDataCard(personViewModel: PersonViewModel, position: Int){
            binding?.setVariable(BR.model, personViewModel)
            binding?.setVariable(BR.position, position)
            binding?.executePendingBindings()
        }


    }

}
