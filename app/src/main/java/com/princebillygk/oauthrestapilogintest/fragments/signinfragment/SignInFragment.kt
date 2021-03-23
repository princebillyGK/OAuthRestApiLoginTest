package com.princebillygk.oauthrestapilogintest.fragments.signinfragment

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
import com.princebillygk.oauthrestapilogintest.databinding.SignInFragmentBinding

class SignInFragment : Fragment() {

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var binding: SignInFragmentBinding
    private lateinit var viewModel: SignInViewModel
    private lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navController = findNavController()
        binding = DataBindingUtil.inflate(inflater, R.layout.sign_in_fragment, container, false)
        binding.signInWithMobileButton.setOnClickListener { otpSignInHandler() }
        binding.signInWithGoogleButton.setOnClickListener { googleSignInHandler() }
        binding.signInWithFacebookButton.setOnClickListener { facebookSignInHandler() }
        binding.signUpSwitchButton.setOnClickListener {navController.navigate(R.id.action_signInFragment_to_signUpFragment) }
        return binding.root
    }

    private fun facebookSignInHandler() {
        signInSuccessHandler()

    }

    private fun googleSignInHandler() {
        signInSuccessHandler()
    }

    private fun otpSignInHandler() {
        signInSuccessHandler()
    }

    private fun signInSuccessHandler() {
        navController.navigate(R.id.action_signInFragment_to_secretFragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
    }

}