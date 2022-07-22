package com.kyared.listapersonas.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepositoryImpl: PersonRepository {
    private var persons = MutableLiveData<List<Person>>()

    override fun getPersons(): MutableLiveData<List<Person>> {
        return persons
    }

    override fun callPersonsAPI() {
        var personsList: ArrayList<Person>? = ArrayList<Person>()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getPersons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("FailCall ", t.message ?: "Error")
                Log.e("call", call.request().toString())
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("results")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Person(jsonObject)
                    personsList?.add(coupon)
                }
                persons.value = personsList
            }
        })
    }
}