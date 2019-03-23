package com.example.eventmanagement19

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast

class QrCodeCheckInActivity : AppCompatActivity() {
    private val PERMISSION_CAMERA = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_code_check_in)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                MutableList(1) { android.Manifest.permission.CAMERA }.toTypedArray(),
                PERMISSION_CAMERA
            )

        }
        Toast.makeText(this, "Permission granted",Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CAMERA -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    return
                }
                intent = Intent(this, OrganizeEventActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
