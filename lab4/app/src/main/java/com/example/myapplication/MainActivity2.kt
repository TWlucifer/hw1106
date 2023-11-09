package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private lateinit var set_drink : EditText
    private lateinit var rg1 : RadioGroup
    private lateinit var rg2 : RadioGroup
    private lateinit var btn_send : Button
    private var suger = "無糖"
    private val ice_opt = "去冰"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        rg1 = findViewById(R.id.rGroup)
        rg1.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { rGroup: RadioGroup?, i: Int ->
            if (i == R.id.rButton1) {
                suger = "無糖"
            } else if (i == R.id.rButton2) {
                suger = "少糖"
            } else if (i == R.id.rButton3) {
                suger = "半糖"
            } else if (i == R.id.rButton4) {
                suger = "全糖"
            }
        })
        rg2 = findViewById(R.id.rGroup2)
        rg2.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { rGroup: RadioGroup?, i: Int ->
            if (i == R.id.rButton5) {
                suger = "去冰"
            } else if (i == R.id.rButton6) {
                suger = "微冰"
            } else if (i == R.id.rButton7) {
                suger = "少冰"
            } else if (i == R.id.rButton8) {
                suger = "全冰"
            }
        })
        btn_send = findViewById(R.id.btn_send)
        btn_send.setOnClickListener(View.OnClickListener { view: View? ->
            set_drink = findViewById(R.id.ed_drink)
            val drink = set_drink.getText().toString()
            val i = Intent()
            val b = Bundle()
            b.putString("drink", drink)
            b.putString("suger", suger)
            b.putString("ice", ice_opt)
            i.putExtras(b)
            setResult(RESULT_OK, i)
            finish()
        })
    }
}