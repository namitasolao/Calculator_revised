package com.example.calculator_revised

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.system.exitProcess

class MainViewModel :ViewModel(){
    var result = 0.0
    var num1  = ""
    var num2  = ""
    var operator = ""
    var data =""

    fun calculations(value : String) : String {
        try {

            if (value == "c") {
                num1 = ""
                num2 = ""
                result = 0.0
                //str = ""
                operator = ""
                return ""
            }

            //if input is an oprator
            else if (value == "+" || value == "-" || value == "*" || value == "/" || value== "%"||value=="=") {
                if (num1 != "" && num2 == "" && value != "=") {
                    operator = value
                    return (value)
                } else if (num1 != "" && num2 != "") {

                    when (operator) {
                        "+" -> {
                            result = num1.toDouble() + num2.toDouble()
                        }
                        "-" -> {
                            result = num1.toDouble() - num2.toDouble()
                        }
                        "*" -> {
                            result = num1.toDouble() * num2.toDouble()
                        }
                        "/" -> {
                            result = num1.toDouble() / num2.toDouble()
                        }
                        "%" -> {
                            result = (num1.toDouble() * num2.toDouble()) / 100
                        }
                    }

                    num1 = result.toString()
                    num2 = ""
                    operator = value
                    return (result.toString())
                } else {
                    num1 = value
                    return (value)
                }
            }

            //if input is a digit
            else {
                if(operator == ""){
                    num1 = num1.plus(value)
                    return num1
                }
                else {
                    num2 = num2.plus(value)
                    return num2
                }
            }
    }              //end try block
        catch(exception: Exception){
            return ("Incorrect command")
        }

        return value
    }

    fun holdData(str : String) {
        data = str
    }

    fun getheldData():String {
        return data
    }

}