package com.namita.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.forEach
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.namita.calculator.R

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel
    lateinit var textId :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        textId = findViewById(R.id.resultText)

        //textId.text = viewModel.getheldData()

        viewModel.dataValues.observe(this, Observer {
            textId.text = it
        })

        findViewById<Button>(R.id.plusButton).setOnClickListener{ onButtonClick("+")}
        findViewById<Button>(R.id.minusButton).setOnClickListener{ onButtonClick("-")}
        findViewById<Button>(R.id.multiplyButton).setOnClickListener{ onButtonClick("*")}
        findViewById<Button>(R.id.divideButton).setOnClickListener{ onButtonClick("/")}
        findViewById<Button>(R.id.percentButton).setOnClickListener{ onButtonClick("%")}

        findViewById<Button>(R.id.dotButton).setOnClickListener{ onButtonClick(".")}
        findViewById<Button>(R.id.equalButton).setOnClickListener{ onButtonClick("=")}
        findViewById<Button>(R.id.clearButton).setOnClickListener{ onButtonClick("c")}

        findViewById<Button>(R.id.zeroButton).setOnClickListener{ onButtonClick("0")}
        findViewById<Button>(R.id.oneButton).setOnClickListener{ onButtonClick("1")}
        findViewById<Button>(R.id.twoButton).setOnClickListener{ onButtonClick("2")}
        findViewById<Button>(R.id.threeButton).setOnClickListener{ onButtonClick("3")}
        findViewById<Button>(R.id.fourButton).setOnClickListener{ onButtonClick("4")}
        findViewById<Button>(R.id.fiveButton).setOnClickListener{ onButtonClick("5")}
        findViewById<Button>(R.id.sixButton).setOnClickListener{ onButtonClick("6")}
        findViewById<Button>(R.id.sevenButton).setOnClickListener{ onButtonClick("7")}
        findViewById<Button>(R.id.eightButton).setOnClickListener{ onButtonClick("8")}
        findViewById<Button>(R.id.nineButton).setOnClickListener{ onButtonClick("9")}


//        plus.setOnClickListener { textId.text = viewModel.calculations("+") }
//        minus.setOnClickListener { textId.text  = viewModel.calculations("-") }
//        multiply.setOnClickListener { textId.text  = viewModel.calculations("*") }
//        divide.setOnClickListener { textId.text  = viewModel.calculations("/") }
//        percent.setOnClickListener { textId.text  = viewModel.calculations("%") }
//
//        dot.setOnClickListener { textId.text = viewModel.calculations(".") }
//        equal.setOnClickListener { textId.text = viewModel.calculations("=") }
//        clear.setOnClickListener { textId.text = viewModel.calculations("c") }
//
//        zero.setOnClickListener {textId.text = viewModel.calculations("0") }
//        one.setOnClickListener { textId.text = viewModel.calculations("1") }
//        two.setOnClickListener { textId.text = viewModel.calculations("2") }
//        three.setOnClickListener { textId.text = viewModel.calculations("3") }
//        four.setOnClickListener { textId.text = viewModel.calculations("4") }
//        five.setOnClickListener { textId.text = viewModel.calculations("5") }
//        six.setOnClickListener { textId.text = viewModel.calculations("6") }
//        seven.setOnClickListener { textId.text = viewModel.calculations("7") }
//        eight.setOnClickListener { textId.text = viewModel.calculations("8") }
//        nine.setOnClickListener { textId.text = viewModel.calculations("9") }


    }

    private fun onButtonClick(v: String) {
        viewModel.calculations(v)
    }

    override fun  onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
           inflater.inflate(R.menu.options,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.aboutOption -> {Toast.makeText(this,"About menu selected",Toast.LENGTH_SHORT).show()}
            else -> {Toast.makeText(this,"Close option selected",Toast.LENGTH_SHORT).show()
                     finish()}
        }
        return super.onOptionsItemSelected(item)
    }

//    override fun onDestroy() {
//        val str = viewModel.holdData((textId.text).toString())
//        super.onDestroy()
//    }

}