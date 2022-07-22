package com.kyared.listapersonas.viewmodel

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kyared.listapersonas.R
import com.kyared.listapersonas.model.Person
import com.kyared.listapersonas.model.PersonObservable
import com.kyared.listapersonas.view.RecyclerPersonsAdapter
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class PersonViewModel: ViewModel() {
    private var personObservable: PersonObservable = PersonObservable()
    private var recyclerPersonsAdapter: RecyclerPersonsAdapter? = null

    fun callPersons(){
        personObservable.callCoupons()
    }

    fun getPersons() : MutableLiveData<List<Person>> {
        return personObservable.getPersons()
    }

    fun setPersonsInRecyclerAdapter(coupons: List<Person>){
        recyclerPersonsAdapter?.setPersonsList(coupons)
        recyclerPersonsAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerPersonsAdapter(): RecyclerPersonsAdapter?{
        recyclerPersonsAdapter = RecyclerPersonsAdapter(this, R.layout.card_person)
        return recyclerPersonsAdapter
    }

    fun getPersonAt(position: Int): Person?{
        var persons: List<Person>? = personObservable.getPersons().value
        return persons?.get(position)
    }

    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: CircleImageView, imageUrl: String?){
            imageUrl?.let {
                if (it.isNotEmpty())
                    Picasso.get().load(it).into(imageView)
            }
        }
    }
}