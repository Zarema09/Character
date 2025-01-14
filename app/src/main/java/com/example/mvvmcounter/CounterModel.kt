package com.example.mvvmcounter

class CounterModel {

    var count = 0

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }

    fun getResult() {
        count
    }
}