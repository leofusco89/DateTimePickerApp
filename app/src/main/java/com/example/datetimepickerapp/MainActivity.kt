package com.example.datetimepickerapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var ivDate: ImageView
    lateinit var ivTime: ImageView
    private lateinit var tietDate: TextInputEditText
    private lateinit var tietTime: TextInputEditText

    private var mYear: Int = 0
    private var mMonth: Int = 0
    private var mDay: Int = 0
    private var mHour: Int = 0
    private var mMinute: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ivDate = findViewById(R.id.iv_date)
        ivTime = findViewById(R.id.iv_time)
        tietDate = findViewById(R.id.tiet_date)
        tietTime = findViewById(R.id.tiet_time)

        ivDate.setOnClickListener(this)
        ivTime.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            ivDate -> {
                // Get Current Date
                val c: Calendar = Calendar.getInstance()
                mYear = c.get(Calendar.YEAR)
                mMonth = c.get(Calendar.MONTH)
                mDay = c.get(Calendar.DAY_OF_MONTH)
                val datePickerDialog = DatePickerDialog(
                    this,
                    { view, year, monthOfYear, dayOfMonth -> tietDate.setText("${checkDigit(dayOfMonth)}-${checkDigit(monthOfYear + 1)}-$year")},
                    mYear,
                    mMonth,
                    mDay
                )
                datePickerDialog.show()
            }

            ivTime -> {
                // Get Current Time
                val c: Calendar = Calendar.getInstance()
                mHour = c.get(Calendar.HOUR_OF_DAY)
                mMinute = c.get(Calendar.MINUTE)

                // Launch Time Picker Dialog
                val timePickerDialog = TimePickerDialog(
                    this,
                    { view, hourOfDay, minute ->tietTime.setText("${checkDigit(hourOfDay)}:${checkDigit(minute)}")},
                    mHour,
                    mMinute,
                    true
                )
                timePickerDialog.show()
            }
        }
    }

    fun checkDigit(number: Int): String? {
        return if (number <= 9) "0$number" else number.toString()
    }
}