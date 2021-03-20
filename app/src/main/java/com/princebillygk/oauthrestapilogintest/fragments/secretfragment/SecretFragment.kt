package com.princebillygk.oauthrestapilogintest.fragments.secretfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.princebillygk.oauthrestapilogintest.R
import com.princebillygk.oauthrestapilogintest.databinding.SecretFragmentBinding

class SecretFragment : Fragment() {


    companion object {
        fun newInstance() = SecretFragment()
    }

    private lateinit var binding: SecretFragmentBinding
    private lateinit var viewModel: SecretViewModel
    private lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.secret_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(SecretViewModel::class.java)
        binding.viewModel = viewModel
        binding.signoutButton.setOnClickListener { handleSignOut() }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mGoogleSignInClient = GoogleSignIn.getClient(
            requireActivity(),
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
        )
    }

    private fun handleSignOut() {
        mGoogleSignInClient.signOut().addOnCompleteListener {
            findNavController().navigate(R.id.action_secretFragment_to_signInFragment)
        }
    }
}