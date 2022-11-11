package com.example.ex05_arcore

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.ar.core.ArCoreApk
import com.google.ar.core.Session
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {


	var mSession: Session? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		requestPermission()
	}


	fun requestPermission(){
		ActivityCompat.requestPermissions(
			this,
			arrayOf(android.Manifest.permission.CAMERA),
			1234
		)
	}

	override fun onResume() {
		super.onResume()

		var tt = ArCoreApk.getInstance().requestInstall(this, true).toString()
		Log.d("install 여", tt)

		mSession = Session(this)

		Log.d("mSession 여", "${mSession}")

		mSession!!.resume()


//		if(ArCoreApk.getInstance().requestInstall(this, true) ==
//				ArCoreApk.InstallStatus.INSTALLED){
//
//			mSession!!.resume()
//
//			Log.d("mSession 여", "${mSession}")
//		}
	}

	override fun onPause() {
		super.onPause()
		mSession!!.pause()
	}
}