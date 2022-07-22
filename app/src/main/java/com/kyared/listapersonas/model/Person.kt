package com.kyared.listapersonas.model

import android.util.Log
import com.google.gson.JsonObject
import java.io.Serializable

class Person(personJson: JsonObject?): Serializable {
    lateinit var id: String
    lateinit var gender: String
    lateinit var name: String
    lateinit var city: String
    lateinit var email: String
    lateinit var age: String
    lateinit var picture: String

    init {
        try {
            id      = personJson!!.get("login").asJsonObject.get("uuid").asString
            gender  = personJson!!.get("gender").asString!!
            name    = personJson!!.get("name").asJsonObject.get("title").asString + " " +
                        personJson!!.get("name").asJsonObject.get("first").asString + " " +
                        personJson!!.get("name").asJsonObject.get("last").asString
            city    = personJson!!.get("location").asJsonObject.get("city").asString
            email   = personJson!!.get("email").asString
            age     = personJson!!.get("dob").asJsonObject.get("age").asString
            picture = personJson!!.get("picture").asJsonObject.get("large").asString

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
