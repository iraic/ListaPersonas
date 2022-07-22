package com.kyared.listapersonas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kyared.listapersonas.R
import com.kyared.listapersonas.model.Person
import com.kyared.listapersonas.viewmodel.PersonViewModel

class MainActivity : AppCompatActivity() {
    private var personViewModel: PersonViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        var activityMainBinding: com.kyared.listapersonas.databinding.ActivityMainBinding
            = DataBindingUtil.setContentView(this, R.layout.activity_main)
        personViewModel = ViewModelProviders.of(this).get(PersonViewModel::class.java)
        activityMainBinding.setModel(personViewModel)
        personViewModel?.callPersons()
        personViewModel?.getPersons()?.observe(this, Observer {
                persons: List<Person> ->
            personViewModel?.setPersonsInRecyclerAdapter(persons)
        })

    }
}