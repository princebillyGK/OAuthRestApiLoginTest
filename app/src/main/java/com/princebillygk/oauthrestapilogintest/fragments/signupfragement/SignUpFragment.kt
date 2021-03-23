package com.princebillygk.oauthrestapilogintest.fragments.signupfragement

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.princebillygk.oauthrestapilogintest.R
import com.princebillygk.oauthrestapilogintest.databinding.SignUpFragmentBinding

class SignUpFragment : Fragment() {
    private val RC_GOOGLE_SIGN_IN = 1

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var binding: SignUpFragmentBinding
    private lateinit var viewModel: SignUpViewModel
    private lateinit var navController: NavController


    //Google Sign in Variables
    private lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        navController = findNavController()
        binding = DataBindingUtil.inflate(inflater, R.layout.sign_up_fragment, container, false)
        binding.signUpWithGoogleButton.setOnClickListener { handleGoogleSignIn() }
        binding.signUpWithFacebookButton.setOnClickListener { signUpSuccessHandler() }
        binding.signInSwitchButton.setOnClickListener { navController.navigate(R.id.action_signUpFragment_to_signInFragment) }
        binding.mobileSignUpButton.setOnClickListener { navController.navigate(R.id.action_signUpFragment_to_otpRequestFragment) }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //Google Sign In Client
        mGoogleSignInClient = GoogleSignIn.getClient(
            requireActivity(),
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestIdToken(getString(R.string.google_sso_server_client_id)).build()
        )
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
    }


    private fun signUpSuccessHandler() {
        findNavController().navigate(R.id.action_signUpFragment_to_newAccountFragment)
    }

    private fun handleGoogleSignIn() {
        startActivityForResult(mGoogleSignInClient.signInIntent, RC_GOOGLE_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.w("SignUpFragment","Activity Result recieved of code $resultCode")
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            RC_GOOGLE_SIGN_IN -> handleGoogleSignInResult(
                GoogleSignIn.getSignedInAccountFromIntent(data)
            )
        }
    }

    private fun handleGoogleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount? = completedTask.getResult(ApiException::class.java)
            if (account != null) {
                Log.w("GoogleSignIn", "Display Name: ${account.displayName}" )
                Log.w("GoogleSignIn", "Email: ${account.email}" )
                Log.w("GoogleSignIn", "Given Name (First Name):${account.givenName}" )
                Log.w("GoogleSignIn", "Family Name (Last Name): ${account.familyName}" )
                Log.w("GoogleSignIn", "Granted Scopes: ${account.grantedScopes}" )
                Log.w("GoogleSignIn", "Id: ${account.id}" )
                Log.w("GoogleSignIn", "Photo URL: ${account.photoUrl}" )
                Log.w("GoogleSignIn", "Id Token: ${account.idToken}" ) //send it to server to authenticate
                Log.w("GoogleSignIn", "Is Expired: ${account.isExpired}" )
                Log.w("GoogleSignIn", "Requested Scopes: ${account.requestedScopes}" )
                Log.w("GoogleSignIn", "ServerAuthCode: ${account.serverAuthCode}" )
            } else {
                Log.w("GoogleSignIn", "Signed in But account is null")
            }
        } catch (e: ApiException) {
            Log.e("GoogleSignIn", "Failed to login to google ${e.statusCode} ${e.localizedMessage} ${e.message}")

        }
    }
}