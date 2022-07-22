package com.kyared.listapersonas.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kyared.listapersonas.databinding.ActivityPersonDetailBinding
import com.kyared.listapersonas.model.Person
import com.kyared.listapersonas.viewmodel.PersonDetailViewModel
import com.squareup.picasso.Picasso

class PersonDetail : AppCompatActivity() {
    private lateinit var binding: ActivityPersonDetailBinding
    private val personDetailViewModel:PersonDetailViewModel = PersonDetailViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val bundle = intent.extras

        binding = ActivityPersonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bundle?.get("person")?.let {
            val person = it as Person
            binding.tvDetailEmail.text = person.email
            binding.tvDetailName.text = person.name
            binding.tvDetailGender.text = person.gender
            binding.tvDetailAge.text = person.age
            binding.tvDetailCity.text = person.city
            Picasso.get().load(person.picture).into(binding.imgPerson)
        }
        binding.btnBack.setOnClickListener { personDetailViewModel.onBackPressed(this) }
    }
}