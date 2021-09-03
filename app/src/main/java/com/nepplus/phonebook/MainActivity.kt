package com.nepplus.phonebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nepplus.phonebook.adapter.PhoneNumAdapter
import com.nepplus.phonebook.data.PhoneNumData
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : BaseActivity() {

    val mPhoneNumList = ArrayList<PhoneNumData>()

    lateinit var mAdapter: PhoneNumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()


    }

    override fun onResume() {
        super.onResume()

        //readPhoneBookFromFile()
    }

    override fun setupEvents() {

        addPhoneNumBtn.setOnClickListener {

            val myIntent = Intent(mContext, EditPhoneNumActivity::class.java)
            startActivity(myIntent)

        }

    }

    override fun setValues() {

        mPhoneNumList.add(PhoneNumData("이재환", "010-1234--5678"))

        mAdapter = PhoneNumAdapter(mContext, R.layout.phone_num_list_item, mPhoneNumList)
        phoneNumListView.adapter = mAdapter

        readPhoneBookFromFile()
    }

    fun readPhoneBookFromFile() {

        val myFile = File(filesDir, "phoneBook.txt")

        val fr = FileReader(myFile)
        val br = BufferedReader(fr)

        val sdf = SimpleDateFormat("yyyy-MM-dd")

        while (true) {
            val line = br.readLine()

            if (line == null)
                break

            val infos = line.split(",")

            val phoneNumData = PhoneNumData(infos[0], infos[1])

            phoneNumData.birthDay.time = sdf.parse(infos[2])

            mPhoneNumList.add(phoneNumData)

        }

        br.close()
        fr.close()

        mAdapter.notifyDataSetChanged()

    }

}