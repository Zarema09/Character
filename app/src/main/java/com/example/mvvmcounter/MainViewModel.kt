package com.example.mvvmcounter

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:   ViewModel() {
    private val model = CounterModel()
    val counterData  =  MutableLiveData<Int>()

    val toastMessage = MutableLiveData<String>()
    val textColor = MutableLiveData<Int>()

    private fun update(){
        counterData.value = model.count
        when(model.count){
            10-> toastMessage.value= "Поздравляем!"
            15->textColor.value = Color.GREEN
                else -> textColor.value = Color.BLACK
        }
    }
    fun onIncrement (){
        model.increment()
        counterData.value = model.count
        update()
    }

    fun onDecrement (){
        model.decrement()
        counterData.value = model.count
        update()
    }
}