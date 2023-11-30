package com.exercise.tbchomeworkthirteenfinal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.exercise.tbchomeworkthirteenfinal.UserData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RegisterViewModel : ViewModel() {
    private val _itemsList = MutableLiveData<List<List<UserData>>>()
    val itemsList: LiveData<List<List<UserData>>> get() = _itemsList

    init {
        getUserData()
    }

    private fun getUserData() {
        val jsonString = loadJsonFromAsset("Users.json")
        if (jsonString != null) {
            val userListType = object : TypeToken<List<List<UserData>>>() {}.type
            val userDataList = Gson().fromJson<List<List<UserData>>>(jsonString, userListType)
            _itemsList.value = userDataList
        }
    }

    private fun loadJsonFromAsset(fileName: String): String? {
        var json: String? = "[\n" +
                "  [\n" +
                "    {\n" +
                "      \"field_id\":1,\n" +
                "      \"hint\":\"UserName\",\n" +
                "      \"field_type\":\"input\",\n" +
                "      \"keyboard\":\"text\",\n" +
                "      \"required\":false,\n" +
                "      \"is_active\":true,\n" +
                "      \"icon\":\"https://jemala.png\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"field_id\":2,\n" +
                "      \"hint\":\"Email\",\n" +
                "      \"field_type\":\"input\",\n" +
                "      \"required\":true,\n" +
                "      \"keyboard\":\"text\",\n" +
                "      \"is_active\":true,\n" +
                "      \"icon\":\"https://jemala.png\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"field_id\":3,\n" +
                "      \"hint\":\"phone\",\n" +
                "      \"field_type\":\"input\",\n" +
                "      \"required\":true,\n" +
                "      \"keyboard\":\"number\",\n" +
                "      \"is_active\":true,\n" +
                "      \"icon\":\"https://jemala.png\"\n" +
                "    }\n" +
                "  ],\n" +
                "  [\n" +
                "    {\n" +
                "      \"field_id\":4,\n" +
                "      \"hint\":\"FullName\",\n" +
                "      \"field_type\":\"input\",\n" +
                "      \"keyboard\":\"text\",\n" +
                "      \"required\":true,\n" +
                "      \"is_active\":true,\n" +
                "      \"icon\":\"https://jemala.png\" },\n" +
                "    {\n" +
                "      \"field_id\":14,\n" +
                "      \"hint\":\"Jemali\",\n" +
                "      \"field_type\":\"input\",\n" +
                "      \"keyboard\":\"text\",\n" +
                "      \"required\":false,\n" +
                "      \"is_active\":true,\n" +
                "      \"icon\":\"https://jemala.png\" },\n" +
                "    {\n" +
                "      \"field_id\":89,\n" +
                "      \"hint\":\"Birthday\",\n" +
                "      \"field_type\":\"chooser\",\n" +
                "      \"required\":false,\n" +
                "      \"is_active\":true,\n" +
                "      \"icon\":\"https://jemala.png\" },\n" +
                "    {\n" +
                "      \"field_id\":898,\n" +
                "      \"hint\":\"Gender\",\n" +
                "      \"field_type\":\"chooser\",\n" +
                "      \"required\":false,\n" +
                "      \"is_active\":true,\n" +
                "      \"icon\":\"https://jemala.png\" }\n" +
                "  ]\n" +
                "]"
        return json
    }

}