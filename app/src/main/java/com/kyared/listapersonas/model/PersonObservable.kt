package com.kyared.listapersonas.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class PersonObservable: BaseObservable() {
    private var personRepository: PersonRepository = PersonRepositoryImpl()

    fun callCoupons(){
        personRepository.callPersonsAPI()
    }

    fun getPersons() : MutableLiveData<List<Person>> {
        return personRepository.getPersons()
    }
}