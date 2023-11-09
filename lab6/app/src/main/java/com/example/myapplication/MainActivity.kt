package com.example.myapplication

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("請選擇功能")
            dialog.setMessage("根據下方按鈕選擇顯示物件")
            dialog.setNeutralButton(
                "cancel"
            ) { dialogInterface, i ->
                Toast.makeText(
                    this@MainActivity,
                    "dialog關閉",
                    Toast.LENGTH_SHORT
                ).show()
            }
            dialog.setNegativeButton(
                "自定義Toast"
            ) { dialogInterface, i -> showToast() }
            dialog.setPositiveButton(
                "顯示list"
            ) { dialogInterface, i -> showListDialog() }
            dialog.show()
        }
    }

    private fun showToast() {
        val toast = Toast(this@MainActivity)
        toast.setGravity(Gravity.TOP, 0, 50)
        toast.duration = Toast.LENGTH_SHORT
        val inflater = layoutInflater
        val layout: View = inflater.inflate(
            R.layout.coustom_toast,
            findViewById<View>(R.id.custom_toast_root) as ViewGroup
        )
        toast.setView(layout)
        toast.show()
    }

    private fun showListDialog() {
        val list = arrayOf("message1", "message2", "message3", "message4", "message5")
        val dialog_list = AlertDialog.Builder(this@MainActivity)
        dialog_list.setTitle("使用LIST呈現")
        dialog_list.setItems(
            list
        ) { dialogInterface, i ->
            Toast.makeText(
                this@MainActivity,
                "你選的是" + list[i],
                Toast.LENGTH_SHORT
            ).show()
        }
        dialog_list.show()
    }
}