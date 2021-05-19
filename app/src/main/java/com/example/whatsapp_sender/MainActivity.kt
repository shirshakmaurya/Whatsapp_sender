package com.example.whatsapp_sender

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var etPhone = findViewById<EditText>(R.id.etPhone)
        var btnSend = findViewById<Button>(R.id.btnSend)

        var phone = etPhone.text.toString()
        btnSend.setOnClickListener {

            val num = etPhone.text.toString()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setPackage("com.whatsapp")
            val numData = if (num[0] == '+') {
                num.substring(1)
            } else if (num.length == 10) {
                "91" + num
            } else {
                num
            }
            intent.data = Uri.parse("https://wa.me/$numData")
            // to check whatsapp is installed or not
            if (packageManager.resolveActivity(intent, 0) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, " please install whatsapp ", Toast.LENGTH_LONG).show()
            }
        }
    }
}