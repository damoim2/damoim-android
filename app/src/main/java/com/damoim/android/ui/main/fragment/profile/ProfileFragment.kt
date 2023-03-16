package com.damoim.android.ui.main.fragment.profile

import android.os.Bundle
import android.view.View
import com.damoim.android.R
import com.damoim.android.base.BaseFragment
import com.damoim.android.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::bind,
    R.layout.fragment_profile), ProfileContract.View {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        with(binding) {
            binding.profileTxtUserName.text = "이아리"
            profileTxtUserJob.text = "직장인"
            profileTxtBank.text = "우리은행"
            profileTxtAccountNumber.text = "1002-350-123456"
        }
    }

}