package com.nepplus.phonebook.data

import java.text.SimpleDateFormat
import java.util.*

class PhoneNumData(var name: String, var phoneNum: String, birthDay: Calendar) {

    var name: String = ""
    var phoneNum = ""
    val birthDay = Calendar.getInstance()

    private val fileDateFormat = SimpleDateFormat("yyyy-MM-dd")



    fun getFileFormatData(): String {


        return "${this.name},${this.phoneNum},${fileDateFormat.format(this.birthDay.time)}"
    }

}