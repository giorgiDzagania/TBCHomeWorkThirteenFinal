package com.exercise.tbchomeworkthirteenfinal.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.exercise.tbchomeworkthirteenfinal.UserData
import com.exercise.tbchomeworkthirteenfinal.databinding.ItemRecyclerviewBinding
import com.exercise.tbchomeworkthirteenfinal.databinding.ItemRecyclerviewDetailsBinding

class RegisterAdapter() :
    ListAdapter<List<UserData>, ViewHolder>(DiffUtilCallBack()) {

    class DiffUtilCallBack : DiffUtil.ItemCallback<List<UserData>>() {
        override fun areItemsTheSame(oldItem: List<UserData>, newItem: List<UserData>): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: List<UserData>, newItem: List<UserData>): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerviewBinding.inflate(inflater, parent, false)
        return RegisterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is RegisterViewHolder -> holder.bind(item)
        }
    }

    inner class RegisterViewHolder(private val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val linearLayout = binding.linerLayout

        fun bind(userDataList: List<UserData>) {
            linearLayout.removeAllViews()
            val context = binding.root.context

            for (userData in userDataList) {
                val itemRecyclerviewDetailsBinding =
                    ItemRecyclerviewDetailsBinding.inflate(
                        LayoutInflater.from(context),
                        linearLayout,
                        true
                    )

                itemRecyclerviewDetailsBinding.editText.hint = userData.hint
                itemRecyclerviewDetailsBinding.editText.setText(userData.userInput)

                itemRecyclerviewDetailsBinding.editText.addTextChangedListener(object :
                    TextWatcher {
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    }
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        userData.userInput = s?.toString() ?: ""
                    }

                    override fun afterTextChanged(s: Editable?) {
                        // Do nothing
                    }
                })
            }
        }
    }
}