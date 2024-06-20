package com.example.room_database.fragment.add

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.room_database.R
import com.example.room_database.data.User
import com.example.room_database.data.UserViewModel
import com.example.room_database.databinding.FragmentAddBinding


class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.button.setOnClickListener {
            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase() {
        val name = binding.editTextTextPersonName.text.toString()
        val email = binding.editTextTextPersonName3.text.toString()

        if (inputCheck(name, email)) {
            val user = User(0, name, email)
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Done Added", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all field", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(name: String, email: String): Boolean {
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(email))
    }
}