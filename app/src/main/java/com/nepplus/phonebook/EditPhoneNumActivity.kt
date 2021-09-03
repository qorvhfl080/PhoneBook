package com.nepplus.phonebook

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.DatePicker
import android.widget.Toast
import com.nepplus.phonebook.data.PhoneNumData
import kotlinx.android.synthetic.main.activity_edit_phone_num.*
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.*

class EditPhoneNumActivity : BaseActivity() {

    val mSelectedDate = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_phone_num)
        setupEvents()
        setValues()
        
    }

    override fun setupEvents() {

        okBtn.setOnClickListener {

            val inputName = nameEdt.text.toString()
            val inputPhoneNum = phoneNumEdt.text.toString()

            val sdf = SimpleDateFormat("yyyy-MM-dd")

            //val birthDayStr = sdf.format(mSelectedDate.time)

            val savePhoneNumData = PhoneNumData(inputName, inputPhoneNum)
            savePhoneNumData.birthDay.time = mSelectedDate.time

            val saveStr = savePhoneNumData.getFileFormatData()

            savePhoneNumToFile(saveStr)

            Toast.makeText(mContext, "전화번호 추가됨", Toast.LENGTH_SHORT).show()
            finish()
        }

        selectBirthDayBtn.setOnClickListener {

            val dataSetListener = object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {

                    mSelectedDate.set(year, month, day)

                    val sdf = SimpleDateFormat("yyyy. MM. dd.")

                    birthDayTxt.text = sdf.format(mSelectedDate.time)

                }
            }

            val datePickerDialog = DatePickerDialog(mContext, dataSetListener,
                mSelectedDate.get(Calendar.YEAR), mSelectedDate.get(Calendar.MONTH), mSelectedDate.get(Calendar.DAY_OF_MONTH))
            datePickerDialog.show()


        }

    }

    override fun setValues() {

    }

    fun savePhoneNumToFile(content: String) {

        val myFile = File(filesDir, "phoneBook.txt")

        val fw = FileWriter(myFile, true)
        val bw = BufferedWriter(fw)

        bw.append(content)
        bw.newLine()

        bw.close()
        fw.close()

    }

}