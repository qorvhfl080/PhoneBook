package com.nepplus.phonebook

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_edit_phone_num.*

class EditPhoneNumActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_phone_num)
    }

    override fun setupEvents() {

        selectBirthDayBtn.setOnClickListener {

            val dataSetListener = object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {

                }
            }

            val datePickerDialog = DatePickerDialog(mContext, dataSetListener, 2021, 8, 2)

            datePickerDialog.show()
        }

    }

    override fun setValues() {

    }
}