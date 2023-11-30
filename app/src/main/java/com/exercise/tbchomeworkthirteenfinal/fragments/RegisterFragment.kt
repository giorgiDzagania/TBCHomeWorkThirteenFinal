package com.exercise.tbchomeworkthirteenfinal.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.exercise.tbchomeworkthirteenfinal.UserData
import com.exercise.tbchomeworkthirteenfinal.adapter.RegisterAdapter
import com.exercise.tbchomeworkthirteenfinal.databinding.FragmentRegisterBinding
import com.exercise.tbchomeworkthirteenfinal.viewmodel.RegisterViewModel

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    private val registerViewModel: RegisterViewModel by viewModels()
    private lateinit var registerAdapter: RegisterAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareRecyclerView()
        observeDataList()

        binding.btnRegister.setOnClickListener {
            val userDataList = mutableListOf<UserData>()

            registerAdapter.currentList.flatten().forEach { userData ->
                userDataList.add(userData)
            }

            val action = RegisterFragmentDirections.actionRegisterFragmentToOutputFragment(
                userDataList.toTypedArray()
            )
            findNavController().navigate(action)
        }
    }

    private fun observeDataList() {
        registerViewModel.itemsList.observe(viewLifecycleOwner) { userDataList ->
            registerAdapter.submitList(userDataList)
        }
    }

    private fun prepareRecyclerView() {
        registerAdapter = RegisterAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = registerAdapter
        }
    }
}