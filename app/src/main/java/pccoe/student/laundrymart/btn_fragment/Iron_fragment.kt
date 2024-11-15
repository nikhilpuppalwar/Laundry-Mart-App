package pccoe.student.laundrymart.btn_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import pccoe.student.laundrymart.R
import pccoe.student.laundrymart.databinding.FragmentIronFragmentBinding

class Iron_fragment : Fragment() {
private  lateinit var binding:FragmentIronFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIronFragmentBinding.inflate(inflater,container,false)

        val clothTypes = arrayOf("Cotton", "Silk", "Wool", "Synthetic")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, clothTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerClothType.adapter = adapter


        return binding.root
    }

    companion object {

    }
}