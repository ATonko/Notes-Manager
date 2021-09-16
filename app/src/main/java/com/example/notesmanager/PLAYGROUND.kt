package com.example.notesmanager

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

suspend fun main(){
    myFun()
}

suspend fun myFun(){
    val job = CoroutineScope(Dispatchers.Main).launch {
        val foo1 = suspendFoo1()
        val foo2 = suspendFoo2()

        doSomething(foo1, foo2)
    }

    job.join()
}

fun suspendFoo1():String="foo1"

fun suspendFoo2():String="foo2"

fun doSomething(foo1:String, foo2:String){
    println("doSomething: $foo1, $foo2")
}