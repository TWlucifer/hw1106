package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tv_meal : TextView
    private lateinit var btn_select : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_meal = findViewById(R.id.tv_meal)
        btn_select = findViewById(R.id.btn_choice)
        btn_select.setOnClickListener(View.OnClickListener { view: View? ->
            mStartForResult.launch(
                Intent(this, MainActivity2::class.java)
            )
        })
    }

    private val mStartForResult = registerForActivityResult<Intent, ActivityResult>(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val intent = result.data
            if (intent != null && intent.extras != null) {
                val b = intent.extras
                val str1 = b!!.getString("drink")
                val str2 = b.getString("suger")
                val str3 = b.getString("ice")
                tv_meal!!.text = String.format(
                    "飲料 %s\n\n甜度: %s\n\n冰塊: %s\n\n",
                    str1,
                    str2,
                    str3
                )
            }
        }
    }
}