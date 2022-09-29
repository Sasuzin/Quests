package com.intents.aula07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.intents.aula07.databinding.ActivityQuestBinding

class QuestActivity : AppCompatActivity() {
    lateinit var binding: ActivityQuestBinding

    var idPergunta = 0
    var respCerta = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idPergunta = intent.getIntExtra("pergunta", -1)

        configurarPergunta(idPergunta)

        binding.buttonA.setOnClickListener{
            responder(1)
        }
        binding.buttonB.setOnClickListener{
            responder(2)
        }
        binding.buttonC.setOnClickListener{
            responder(3)
        }
        binding.buttonD.setOnClickListener{
            responder(4)
        }
    }

    private fun responder(selecionado: Int) {
        val intent = Intent()
        if (respCerta == selecionado) {
            intent.putExtra("acertou", true)
        } else {
            intent.putExtra("acertou", false)
        }

        intent.putExtra("idPergunta",idPergunta)

        setResult(RESULT_OK, intent)
        finish()
        //finishAffinity() *FECHA TODA A APLICACAO*
    }

    fun configurarPergunta(idPergunta: Int) {
        this.idPergunta = idPergunta

        when(idPergunta) {
            1 -> {
                binding.textNum.text = idPergunta.toString()
                binding.textPergunta.text = "Quantos estados há no Brasil?"
                binding.buttonA.text = "A, 20"
                binding.buttonB.text = "B, 23"
                binding.buttonC.text = "C, 26"
                binding.buttonD.text = "D, 30"
                respCerta = 3
            }
            2 -> {
                binding.textNum.text = idPergunta.toString()
                binding.textPergunta.text = "Qual animal é um felino?"
                binding.buttonA.text = "A, Javali"
                binding.buttonB.text = "B, Lince"
                binding.buttonC.text = "C, Girafa"
                binding.buttonD.text = "D, Tartaruga"
                respCerta = 2
            }
            3 -> {
                binding.textNum.text = idPergunta.toString()
                binding.textPergunta.text = "Qual o anime com mais episodios?"
                binding.buttonA.text = "A, One Piece"
                binding.buttonB.text = "B, Naruto"
                binding.buttonC.text = "C, Dragon Ball"
                binding.buttonD.text = "D, Hunter x Hunter"
                respCerta = 1
            }
        }
    }
}