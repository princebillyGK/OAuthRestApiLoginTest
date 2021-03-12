package com.princebillygk.oauthrestapilogintest.fragments.newaccountfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.princebillygk.oauthrestapilogintest.R
import com.princebillygk.oauthrestapilogintest.databinding.NewAccountFragmentBinding

class NewAccountFragment : Fragment() {


    companion object {
        fun newInstance() = NewAccountFragment()
    }

    private lateinit var binding: NewAccountFragmentBinding
    private lateinit var viewModel: NewAccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.new_account_fragment,
            container,
            false
        )
        binding.submitButton.setOnClickListener { submitButtonHandler() }
        return binding.root
    }

    private fun submitButtonHandler() {
        findNavController().navigate(R.id.action_newAccountFragment_to_secretFragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewAccountViewModel::class.java)
        // TODO: Use the ViewModel
    }

}