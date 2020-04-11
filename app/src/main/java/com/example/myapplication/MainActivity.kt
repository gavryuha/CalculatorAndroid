package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var dotPressed = false
    var operandPressed = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_ac.setOnClickListener {
            math_operation.text = ""
            result_text.text = ""
            dotPressed = false
            operandPressed = false
        }
        btn_closeParents.setOnClickListener { setTextFields("(") }
        btn_openParents.setOnClickListener { setTextFields(")") }
        btn_add.setOnClickListener {
            if (!operandPressed) {
                dotPressed = false
                setTextFields("+")
                operandPressed = true
            } else Toast.makeText(
                this,
                "ERROR! Operand pressed! Please input numbers",
                Toast.LENGTH_SHORT
            ).show();
        }
        btn_divided.setOnClickListener {
            if (!operandPressed) {
                setTextFields("/")
                dotPressed = false
                operandPressed = true
            } else Toast.makeText(
                this,
                "ERROR! Operand pressed! Please input numbers",
                Toast.LENGTH_SHORT
            ).show();
        }
        btn_multiply.setOnClickListener {
            if (!operandPressed) {
                setTextFields("*")
                dotPressed = false
                operandPressed = true
            } else Toast.makeText(
                this,
                "ERROR! Operand pressed! Please input numbers",
                Toast.LENGTH_SHORT
            ).show();
        }
        btn_del.setOnClickListener {
            val str = math_operation.text.toString()
            if (str.isNotEmpty()) {
                math_operation.text = str.substring(0, str.length - 1)
            }
            result_text.text = ""
        }
        btn_subtraction.setOnClickListener {
            if (!operandPressed) {
                setTextFields("-")
                dotPressed = false
                operandPressed = true
            } else Toast.makeText(
                this,
                "ERROR! Operand pressed! Please input numbers",
                Toast.LENGTH_SHORT
            ).show();
        }

        btn_one.setOnClickListener {
            setTextFields("1")
            operandPressed = false
        }
        btn_two.setOnClickListener {
            setTextFields("2")
            operandPressed = false
        }
        btn_three.setOnClickListener {
            setTextFields("3")
            operandPressed = false
        }
        btn_four.setOnClickListener {
            setTextFields("4")
            operandPressed = false
        }
        btn_five.setOnClickListener {
            setTextFields("5")
            operandPressed = false
        }
        btn_six.setOnClickListener {
            setTextFields("6")
            operandPressed = false
        }
        btn_seven.setOnClickListener {
            setTextFields("7")
            operandPressed = false
        }
        btn_eight.setOnClickListener {
            setTextFields("8")
            operandPressed = false
        }
        btn_nine.setOnClickListener {
            setTextFields("9")
            operandPressed = false
        }
        btn_zero.setOnClickListener {
            setTextFields("0")
            operandPressed = false
        }


        btn_dot.setOnClickListener {
            if (!dotPressed) {
                setTextFields(".")
                dotPressed = true
            } else {
                Toast.makeText(this, "ERROR! Dot included", Toast.LENGTH_SHORT).show();
            }
        }

        btn_equals.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble()) {
                    result_text.text = longRes.toString()
                } else {
                    result_text.text = result.toString()
                }

            } catch (e: Exception) {
                Toast.makeText(this, "ERROR! Not Allowed", Toast.LENGTH_SHORT).show();
            }

        }


    }

    fun setTextFields(str: String) {
        if (result_text.text != "") {
            math_operation.text = result_text.text
            result_text.text = ""
        }

        math_operation.append(str)
    }
}
