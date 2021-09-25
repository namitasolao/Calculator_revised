package com.namita.calculator

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel(){
    var result = 0.0
    var num1  = ""
    var num2  = ""
    var operator = ""
    var data =""
    val dataValues = MutableLiveData<String>();

    fun calculations(input : String) {
        try {

            if (input == "c") {
                num1 = ""
                num2 = ""
                result = 0.0
                //str = ""
                operator = ""
                dataValues.value = ""
                return
            //    return ""
            }

            //if input is an oprator
            else if (input == "+" || input == "-" || input == "*" || input == "/" || input== "%"||input=="=") {
                if (num1 != "" && num2 == "" && input != "=") {
                    operator = input
                    //return (input)
                    dataValues.value = input
                    return
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
                    operator = input
                    //return (result.toString())
                    dataValues.value = (result.toString())
                    return
                } else {
                    num1 = input
                    //return (input)
                    dataValues.value = input
                    return
                }
            }

            //if input is a digit
            else {
                if(operator == ""){
                    num1 = num1.plus(input)
                   // return num1
                    dataValues.value = num1
                    return
                }
                else {
                    num2 = num2.plus(input)
                    //return num2
                    dataValues.value = num2
                    return
                }
            }
    }              //end try block
        catch(exception: Exception){
           // return ("Incorrect command")
            dataValues.value = "Incorrect command"
            return
        }

        //return input
        dataValues.value = input
    }

    fun holdData(str : String) {
        data = str
    }

    fun getheldData():String {
        return data
    }

    fun persistResultToNotifications(context: Context) {
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentText("Result is $result")
            .setContentTitle("Result is $result")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        NotificationManagerCompat.from(context).notify(notificationCount++, notification)
    }
}