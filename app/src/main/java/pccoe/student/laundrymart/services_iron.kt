package pccoe.student.laundrymart

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import pccoe.student.laundrymart.databinding.ActivityServicesIronBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class services_iron : AppCompatActivity() {
    private lateinit var binding:ActivityServicesIronBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityServicesIronBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val clothTypes = arrayOf("Cotton", "Silk", "Wool", "Synthetic")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, clothTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerClothType.adapter = adapter
        binding.btnPickupDate.setOnClickListener {
            showDatePickerDialog(binding.btnPickupDate)
        }

        // Set up DatePickerDialog for Delivery Date Button
        binding.btnDeliveryDate.setOnClickListener {
            showDatePickerDialog(binding.btnDeliveryDate)
        }
        binding.btnSubmit.setOnClickListener {
            Toast.makeText(this, "Order Confirmed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showDatePickerDialog(button: Button) {
        val calendar = Calendar.getInstance()

        // Use the custom theme for DatePickerDialog
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)
                val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                button.text = dateFormat.format(selectedDate.time)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.show()
    }
}