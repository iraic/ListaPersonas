package com.kyared.listapersonas.viewmodel

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.kyared.listapersonas.view.MainActivity

class PersonDetailViewModel: ViewModel() {
    fun onBackPressed(context: Context) {
        context.startActivity(Intent(context, MainActivity::class.java))
    }

}