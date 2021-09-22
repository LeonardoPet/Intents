package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.intents.databinding.ActivityOutraBinding

class OutraActivity : AppCompatActivity() {
    private val activityOutraBinding: ActivityOutraBinding by lazy{
        ActivityOutraBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityOutraBinding.root)

        supportActionBar?.title = "Outra Activity"
        supportActionBar?.subtitle = "Recebe e retorna valor"

        /* val parametrosBundle = intent.extras
        if(parametrosBundle !== null){
            val recebido = parametrosBundle.getString(MainActivity.PARAMETRO, "")
            activityOutraBinding.recebidoTv.text = recebido
        }*/
        intent.extras?.getString(MainActivity.PARAMETRO, "").let {
            activityOutraBinding.recebidoTv.text = it
        }

        intent.getStringExtra(MainActivity.PARAMETRO)?.let {
            activityOutraBinding.recebidoTv.text = it
        }


        activityOutraBinding.retornaBt.setOnClickListener{
                val retornoIntent: Intent = Intent()
                retornoIntent.putExtra(MainActivity.PARAMETRO,activityOutraBinding.retornoEt.text.toString())
                setResult(RESULT_OK, retornoIntent)
                finish()
            }

        Log.v("${getString(R.string.app_name)}/${localClassName}", "onCreate: Início CC")
    }
    override fun onStart(){
        super.onStart()
        Log.v("${getString(R.string.app_name)}/${localClassName}", "onCreate: Início CV")
    }
    override fun onResume(){
        super.onResume()
        Log.v("${getString(R.string.app_name)}/${localClassName}", "onCreate: Início CPP")
    }
    override fun onPause(){
        super.onPause()
        Log.v("${getString(R.string.app_name)}/${localClassName}", "onCreate: Fim CPP")
    }
    override fun onStop(){
        super.onStop()
        Log.v("${getString(R.string.app_name)}/${localClassName}", "onCreate: Fim CV")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.v("${getString(R.string.app_name)}/${localClassName}", "onCreate: Fim CC")
    }
}