package com.kyared.listapersonas.model

import androidx.lifecycle.MutableLiveData

interface PersonRepository {
    fun getPersons(): MutableLiveData<List<Person>>
    fun callPersonsAPI()
}