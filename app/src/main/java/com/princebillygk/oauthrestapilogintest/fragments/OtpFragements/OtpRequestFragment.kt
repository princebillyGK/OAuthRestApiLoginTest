package com.princebillygk.oauthrestapilogintest.fragments.OtpFragements

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.princebillygk.oauthrestapilogintest.R
import com.princebillygk.oauthrestapilogintest.api.ApiClient
import com.princebillygk.oauthrestapilogintest.api.requests.otp.OtpRequest
import com.princebillygk.oauthrestapilogintest.databinding.OtpRequestFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class OtpRequestFragment : Fragment() {

    companion object {
        fun newInstance() = OtpRequestFragment()
    }

    private lateinit var viewModel: OtpRequestViewModel
    private lateinit var binding: OtpRequestFragmentBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.otp_request_fragment, container, false)
        navController = findNavController()
        binding.verifyButton.setOnClickListener { handleVerificationClick() }
        binding.phoneInput.setOnValidityChange { _, isValid ->
            binding.verifyButton.isEnabled = isValid
        }
        return binding.root
    }

    private fun handleVerificationClick() {
        val anondoBazarService = ApiClient.getAnondoBazarService()
        CoroutineScope(Dispatchers.IO).launch {
            val response =
                anondoBazarService.requestOtp(OtpRequest(phone = binding.phoneInput.number))
            try {
                if (response.isSuccessful) {
                    response.body()?.let { responseBody ->
                        responseBody.userMessage?.let { message ->
                            withContext(Dispatchers.Main) {
                                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, response.body()?.userMessage?: "Something went wrong", Toast.LENGTH_SHORT).show()
                    }
                    Log.w("OtpRequestFragment", response.body()?.developerMessage?: response.message())
                }
            } catch (e: Throwable) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
                Log.e("OtpRequestFragment", e.message, e)
            }
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OtpRequestViewModel::class.java)
    }

}