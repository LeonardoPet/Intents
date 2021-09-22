package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64DataException
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var outraActivityResultLauncher: ActivityResultLauncher<Intent>

    companion object{
        val PARAMETRO = "PARAMETRO"
        //val OUTRA_ACTIVITY_REQUEST_CODE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        supportActionBar?.title = "Tratando Intents"
        supportActionBar?.subtitle = "Principais tipos"

        outraActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == RESULT_OK ){
                result.data?.getStringExtra(PARAMETRO)?.let{
                    activityMainBinding.retortoTv.text = it
                }

            }
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

    override fun OnCreateOptionsMenu(menu: Menu?): Boolean{
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.outraActivityMi -> {
                val outraActivityIntent: Intent = Intent(this, OutraActivity::class.java)
                outraActivityIntent.putExtra(PARAMETRO,activityMainBinding.parametroEt.text.toString())
            /*
                //Passando Bundle
                val parametroBundle: Bundle = Bundle()
                parametroBundle.putString(PARAMETRO,activityMainBinding.parametroEt.text.toString())

                outraActivityIntent.putExtras(parametroBundle)
            */
                //startActivity(outraActivityIntent)
                //startActivityForResult(outraActivityIntent, OUTRA_ACTIVITY_REQUEST_CODE)
                outraActivityResultLauncher.launch(outraActivityIntent)
                true
            }R.id.viewMi ->{
                true
            }R.id.callMi -> {
                true
            }R.id.dialMi ->{
                true
            }R.id.pickMi ->{
                true
            }R.id.chooserMi ->{
                true
            }else ->{
                false
            }

        }


    }

}