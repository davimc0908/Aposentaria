package com.davi.aposenadoria

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.davi.aposenadoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val items = listOf("Masculino", "Feminino")

        val adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, items)

        binding.spinner.adapter = adapter

        binding.button.setOnClickListener{
            val sexoselecionado = binding.spinner.selectedItem as String
            var idade = binding.edittext.text.toString().toLongOrNull()
            var  resultado: Long
            if (idade!= null) {
                if (sexoselecionado.trim() == "Masculino") {
                    resultado = 65 - idade
                }else{
                    resultado = 62-idade
                }

                binding.resultado.text = "Faltam $resultado anos para voce se aposentar"
            }else{
                binding.resultado.text="Informe sua idade"
            }




        }

    }
}