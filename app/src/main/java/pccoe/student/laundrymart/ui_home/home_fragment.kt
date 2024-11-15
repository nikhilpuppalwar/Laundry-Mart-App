package pccoe.student.laundrymart.ui_home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import pccoe.student.laundrymart.R
import pccoe.student.laundrymart.databinding.FragmentHomeFragmentBinding
import pccoe.student.laundrymart.service_laundry_iron
import pccoe.student.laundrymart.services_iron
import pccoe.student.laundrymart.services_laundry
import java.util.zip.Inflater

class home_fragment : Fragment() {
private lateinit var binding:FragmentHomeFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentHomeFragmentBinding.inflate(inflater,container,false)


        binding.btnIronLaundry.setOnClickListener{
            Toast.makeText(context, "Iron and Laundry", Toast.LENGTH_SHORT).show()
            startActivity(Intent(activity,service_laundry_iron::class.java))
        }
        binding.btnIron.setOnClickListener{
            Toast.makeText(context, "Iron", Toast.LENGTH_SHORT).show()
            startActivity(Intent(activity,services_iron::class.java))
        }
        binding.btnLaundry.setOnClickListener{
            Toast.makeText(context, " Laundry", Toast.LENGTH_SHORT).show()
            startActivity(Intent(activity, services_laundry::class.java))
        }
        return binding.root
    }
    
}