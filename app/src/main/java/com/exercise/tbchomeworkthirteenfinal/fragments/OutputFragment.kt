package com.exercise.tbchomeworkthirteenfinal.fragments

import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.exercise.tbchomeworkthirteenfinal.UserData
import com.exercise.tbchomeworkthirteenfinal.databinding.FragmentOutputBinding

class OutputFragment : BaseFragment<FragmentOutputBinding>(FragmentOutputBinding::inflate) {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataList: Array<UserData>? =
            arguments?.getParcelableArray("sendData", UserData::class.java)?.map {
                it as UserData
            }?.toTypedArray()

        createDynamicTextViews(dataList)
    }

    private fun createDynamicTextViews(dataList: Array<UserData>?) {
        dataList?.let {
            val container = binding.textViewContainer
            for (userData in dataList) {
                val textView = TextView(requireContext())

                val text = "${userData.fieldId}: ${userData.userInput ?: ""}"
                textView.text = text
                val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                layoutParams.setMargins(0, 10, 0, 0)
                textView.layoutParams = layoutParams
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25f)
                textView.gravity = Gravity.CENTER
                container.addView(textView)
            }
        }
    }
}