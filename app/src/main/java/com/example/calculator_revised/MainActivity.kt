package com.example.calculator_revised

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel :MainViewModel
    lateinit var textId :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        textId = findViewById(R.id.resultText)

        //textId.setText( viewModel.result.toString())

        textId.text = viewModel.result.toString()

        val plus: Button = findViewById(R.id.plusButton)
        val minus: Button = findViewById(R.id.minusButton)
        val multiply: Button = findViewById(R.id.multiplyButton)
        val divide: Button = findViewById(R.id.divideButton)
        val percent: Button = findViewById(R.id.percentButton)

        val dot: Button = findViewById(R.id.dotButton)
        val equal: Button = findViewById(R.id.equalButton)
        val clear: Button = findViewById(R.id.clearButton)

        val zero: Button = findViewById(R.id.zeroButton)
        val one: Button = findViewById(R.id.oneButton)
        val two: Button = findViewById(R.id.twoButton)
        val three: Button = findViewById(R.id.threeButton)
        val four: Button = findViewById(R.id.fourButton)
        val five: Button = findViewById(R.id.fiveButton)
        val six: Button = findViewById(R.id.sixButton)
        val seven: Button = findViewById(R.id.sevenButton)
        val eight: Button = findViewById(R.id.eightButton)
        val nine: Button = findViewById(R.id.nineButton)


        plus.setOnClickListener { textId.text = viewModel.calculations("+") }
        minus.setOnClickListener { textId.text  = viewModel.calculations("-") }
        multiply.setOnClickListener { textId.text  = viewModel.calculations("*") }
        divide.setOnClickListener { textId.text  = viewModel.calculations("/") }
        percent.setOnClickListener { textId.text  = viewModel.calculations("%") }

        dot.setOnClickListener { textId.text = viewModel.calculations(".") }
        equal.setOnClickListener { textId.text = viewModel.calculations("=") }
        clear.setOnClickListener { textId.text = viewModel.calculations("c") }

        zero.setOnClickListener {textId.text = viewModel.calculations("0") }
        one.setOnClickListener { textId.text = viewModel.calculations("1") }
        two.setOnClickListener { textId.text = viewModel.calculations("2") }
        three.setOnClickListener { textId.text = viewModel.calculations("3") }
        four.setOnClickListener { textId.text = viewModel.calculations("4") }
        five.setOnClickListener { textId.text = viewModel.calculations("5") }
        six.setOnClickListener { textId.text = viewModel.calculations("6") }
        seven.setOnClickListener { textId.text = viewModel.calculations("7") }
        eight.setOnClickListener { textId.text = viewModel.calculations("8") }
        nine.setOnClickListener { textId.text = viewModel.calculations("9") }

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

}