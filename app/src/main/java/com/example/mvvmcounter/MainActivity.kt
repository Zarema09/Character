package com.example.mvvmcounter

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
//git
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.counterData.observe(this) {count ->
            binding.tvCount.text = count.toString()
        }

        viewModel.textColor.observe(this){ color ->
            binding.tvCount.setTextColor(color)
        }
        viewModel.toastMessage.observe(this){ message ->
            message?.let{
                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            }
        }



        binding.btnDecrement.setOnClickListener{
            viewModel.onDecrement()
            Log.e("ololo", "decre")
        }

        binding.btnIncrement.setOnClickListener{
                viewModel.onIncrement()
            Log.e("ololo", "incr")
        }
    }
}