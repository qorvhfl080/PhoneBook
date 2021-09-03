package com.nepplus.phonebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nepplus.phonebook.adapter.PhoneNumAdapter
import com.nepplus.phonebook.data.PhoneNumData
import kotlinx.android.synthetic.main.activity_main.*
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

    override fun setupEvents() {

        addPhoneNumBtn.setOnClickListener {

            val myIntent = Intent(mContext, EditPhoneNumActivity::class.java)
            startActivity(myIntent)

        }

    }

    override fun setValues() {

        mPhoneNumList.add(PhoneNumData("이재환", "010-1234--5678", null))

        mAdapter = PhoneNumAdapter(mContext, R.layout.phone_num_list_item, mPhoneNumList)\
        phoneNumListView.adapter = mAdapter
    }
}