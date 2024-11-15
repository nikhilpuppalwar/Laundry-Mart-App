package pccoe.student.laundrymart.ui_home

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import pccoe.student.laundrymart.R
import pccoe.student.laundrymart.databinding.FragmentIronFragmentBinding
import pccoe.student.laundrymart.databinding.FragmentSchedulePickupFragmentBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Schedule_pickup_fragment : Fragment() {
private  lateinit var binding: FragmentSchedulePickupFragmentBinding
    private val calendar = Calendar.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      binding = FragmentSchedulePickupFragmentBinding.inflate(inflater, container, false)

        // Set up date picker for the pickup date button
        binding.pickupDateButton.setOnClickListener {
            showDatePickerDialog()
        }

        // Set up time picker for the pickup time button
        binding.pickupTimeButton.setOnClickListener {
            showTimePickerDialog()
        }

        // Handle confirm pickup button click
        binding.confirmPickupButton.setOnClickListener {
            confirmPickup()
        }
        return binding.root


    }

    private fun showDatePickerDialog() {
        DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->
                calendar.set(year, month, dayOfMonth)
                val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                binding.pickupDateButton.text = dateFormat.format(calendar.time)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun showTimePickerDialog() {
        TimePickerDialog(
            requireContext(),
            { _, hourOfDay, minute ->
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                calendar.set(Calendar.MINUTE, minute)
                val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
                binding.pickupTimeButton.text = timeFormat.format(calendar.time)
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        ).show()
    }

    private fun confirmPickup() {
        val date = binding.pickupDateButton.text.toString()
        val time = binding.pickupTimeButton.text.toString()
        val address = binding.pickupAddressInput.text.toString()
        val notes = binding.notesInput.text.toString()

        if (date == "Choose Date" || time == "Choose Time" || address.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill all required fields", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Pickup Confirmed!", Toast.LENGTH_SHORT).show()
        }
    }
}