package com.princebillygk.oauthrestapilogintest.fragments.signupfragement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.princebillygk.oauthrestapilogintest.R
import com.princebillygk.oauthrestapilogintest.databinding.SignUpFragmentBinding

class SignUpFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var binding: SignUpFragmentBinding
    private lateinit var viewModel: SignUpViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        navController = findNavController()
        binding = DataBindingUtil.inflate(inflater, R.layout.sign_up_fragment, container, false)
        binding.otpSignUpButton.setOnClickListener { signUpSuccessHandler() }
        binding.signUpWithGoogleButton.setOnClickListener { signUpSuccessHandler() }
        binding.signUpWithFacebookButton.setOnClickListener { signUpSuccessHandler() }
        binding.signInSwitchButton.setOnClickListener{ navController.navigate(R.id.action_signUpFragment_to_signInFragment)}
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
    }

    private fun signUpSuccessHandler() {
        findNavController().navigate(R.id.action_signUpFragment_to_newAccountFragment)
    }
}