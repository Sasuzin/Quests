package com.intents.aula07

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.intents.aula07.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, QuestActivity::class.java)
            intent.putExtra("pergunta", 1)

            //INICIAR UMA ATIVIDADE
            //startActivity(intent)

            //INICIAR UMA ATIVIDADE ESPERANDO UMA RESPOSTA
            startActivityForResult(intent, 1)
        }

        binding.button2.setOnClickListener {
            val intent = Intent(this, QuestActivity::class.java)
            intent.putExtra("pergunta", 2)

            startActivityForResult(intent, 1)
        }
        binding.button3.setOnClickListener {
            val intent = Intent(this, QuestActivity::class.java)
            intent.putExtra("pergunta", 3)

            startActivityForResult(intent, 1)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            val acertou = data.getBooleanExtra("acertou", false)
            val idPergunta = data.getIntExtra("idPergunta", -1)

            tratarResposta(idPergunta,acertou)
        }
    }

    private fun tratarResposta(idPergunta: Int, acertou: Boolean) {
        when(idPergunta) {
            1 -> {
                if (acertou) {
                    binding.button.setBackgroundColor(Color.GREEN)
                } else {
                    binding.button.setBackgroundColor(Color.RED)
                }
            }
            2 -> {
                if (acertou) {
                    binding.button2.setBackgroundColor(Color.GREEN)
                } else {
                    binding.button2.setBackgroundColor(Color.RED)
                }
            }
            3 -> {
                if (acertou) {
                    binding.button3.setBackgroundColor(Color.GREEN)
                } else {
                    binding.button3.setBackgroundColor(Color.RED)
                }
            }
        }
    }
}