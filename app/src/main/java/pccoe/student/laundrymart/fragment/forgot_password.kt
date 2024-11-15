package pccoe.student.laundrymart.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import pccoe.student.laundrymart.R
import pccoe.student.laundrymart.databinding.FragmentForgotPasswordBinding

class forgot_password : Fragment() {
    private lateinit var binding: FragmentForgotPasswordBinding
    private lateinit var navController: NavController
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        firebaseAuth = FirebaseAuth.getInstance()
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)

        // Reset Password Button Click Listener
        binding.resetPasswordButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            if (email.isNotEmpty()) {
                resetPassword(email)
            } else {
                Toast.makeText(context, "Please enter your email address", Toast.LENGTH_SHORT).show()
            }
        }

        // Back to Login Text Click Listener
        binding.backToLoginText.setOnClickListener {
            navController.navigate(R.id.action_forgot_password_to_login)
        }

        return binding.root
    }

    private fun resetPassword(email: String) {
        firebaseAuth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Password reset email sent. Please check your inbox.", Toast.LENGTH_LONG).show()
                    navController.navigate(R.id.action_forgot_password_to_login)
                } else {
                    Toast.makeText(context, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}