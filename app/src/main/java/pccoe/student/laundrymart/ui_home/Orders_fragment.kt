package pccoe.student.laundrymart.ui_home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pccoe.student.laundrymart.R
import pccoe.student.laundrymart.databinding.FragmentOrdersFragmentBinding


class Orders_fragment : Fragment() {
private lateinit var binding: FragmentOrdersFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrdersFragmentBinding.inflate(inflater,container,false)
        binding.contactSupportButton.setOnClickListener {
            val intent= Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+9518594233")
            startActivity(intent)
        }
        return binding.root
    }

    companion object {

    }
}