package com.aptivist.clashapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun inRageIsTrue(){
        assertEquals(verifyRage(3),true)
    }
    @Test
    fun inRageIsFalse(){
    assertEquals(verifyRage(15), false)
    }

    fun verifyRage(value: Int): Boolean{
        var result = false
        when (value){
            in 0..10 ->{
                result = true
            }
            in 11..Int.MAX_VALUE->{
                result = false
            }
        }
        return result
    }
}