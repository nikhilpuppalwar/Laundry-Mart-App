package pccoe.student.laundrymart

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import pccoe.student.laundrymart.databinding.ActivityLoginSignupBinding
import pccoe.student.laundrymart.fragment.Login

class Login_Signnup : AppCompatActivity() {
    private lateinit var binding:ActivityLoginSignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityLoginSignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}