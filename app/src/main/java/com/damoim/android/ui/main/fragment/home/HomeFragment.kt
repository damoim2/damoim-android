package com.damoim.android.ui.main.fragment.home

import android.os.Bundle
import android.system.Os.bind
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.RadioButton
import androidx.core.view.children
import androidx.core.widget.PopupWindowCompat.showAsDropDown
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.damoim.android.R
import com.damoim.android.base.BaseFragment
import com.damoim.android.data.Group
import com.damoim.android.data.Schedule
import com.damoim.android.databinding.FragmentHomeBinding
import com.damoim.android.databinding.PopupWindowBinding
import com.damoim.android.ui.main.fragment.chat.ChatContract
import com.damoim.android.ui.main.fragment.home.adapter.GroupScheduleAdapter
import com.damoim.android.ui.main.fragment.home.adapter.HomeGroupAdapter
import com.damoim.android.ui.main.fragment.home.customview.SchedulePopupWindow
import com.damoim.android.ui.main.fragment.home.customview.SelectorButton
import timber.log.Timber

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind,
    R.layout.fragment_home), HomeContract.View {
    private val groupAdapter by lazy { HomeGroupAdapter() }
    private val scheduleAdapter by lazy { GroupScheduleAdapter() }
    private var popupWindow: SchedulePopupWindow? = null

    private val testItems = arrayListOf(
        Group("", "테스트1"),
        Group("", "테스트2"),
        Group("", "테스트3"),
        Group("", "테스트4"),
        Group("", "테스트5"),
        Group("", "테스트6"),
        Group("", "테스트7")
    )

    private val testItems2 = arrayListOf(
        Schedule("모임01", "10월 10일 월요일", "오후 05:30"),
        Schedule("모임02", "10월 10일 월요일", "오후 06:30")
    )

    private val testItems3 = arrayListOf(
        Schedule("모임01", "10월 11일 화요일", "오후 05:30"),
        Schedule("모임02", "10월 11일 화요일", "오후 06:30"),
        Schedule("모임03", "10월 11일 화요일", "오후 07:30"),
        Schedule("모임03", "10월 11일 화요일", "오후 07:30")
    )

    private val testItems4 = arrayListOf(
        Schedule("모임01", "10월 12일 수요일", "오후 05:30"),
        Schedule("모임02", "10월 12일 수요일", "오후 06:30"),
        Schedule("모임03", "10월 12일 수요일", "오후 07:30"),
        Schedule("모임03", "10월 12일 수요일", "오후 07:30"),
        Schedule("모임03", "10월 12일 수요일", "오후 07:30"),
        Schedule("모임03", "10월 12일 수요일", "오후 07:30"),
        Schedule("모임03", "10월 12일 수요일", "오후 07:30")
    )

    private val testItems5 = arrayListOf(
        Schedule("모임01", "10월 13일 목요일", "오후 05:30"),
        Schedule("모임02", "10월 13일 목요일", "오후 06:30"),
        Schedule("모임03", "10월 13일 목요일", "오후 07:30"),
        Schedule("모임03", "10월 13일 목요일", "오후 07:30"),
        Schedule("모임03", "10월 13일 목요일", "오후 07:30")
    )

    private val testItems6 = arrayListOf(
        Schedule("모임01", "10월 14일 금요일", "오후 05:30"),
        Schedule("모임02", "10월 14일 금요일", "오후 06:30"),
        Schedule("모임03", "10월 14일 금요일", "오후 07:30")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        Timber.tag("lifecycle").d("onViewCreated")

    }

    private fun initView() {
        with(binding) {
            homeRecyclerview.adapter = groupAdapter
            groupAdapter.setClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_groupFragment)
            }
            groupAdapter.setItemList(testItems)

            homeRecyclerviewSchedule.adapter = scheduleAdapter
            scheduleAdapter.setItemList(testItems2.subList(0, 1))

            homeRadioBtn1.setOnClickListener {
                onRadioButtonClicked(it)
            }

            homeRadioBtn2.setOnClickListener {
                onRadioButtonClicked(it)
            }

            homeImgDropBtn.setOnClickListener {
                showPopUpWindow(::onPopUpWindowDismiss)
            }

            homeSelectorBtnDate1.text1?.text = "월"
            homeSelectorBtnDate1.text2?.text = "10"
            homeSelectorBtnDate1.setOnClickListener {
                selectedDateButton(it as SelectorButton)
                scheduleAdapter.setItemList(testItems2.subList(0, 1))
                popupWindow?.adapter?.setItemList(testItems2.subList(1, testItems2.size))
            }

            homeSelectorBtnDate2.text1?.text = "화"
            homeSelectorBtnDate2.text2?.text = "11"
            homeSelectorBtnDate2.setOnClickListener {
                selectedDateButton(it as SelectorButton)
                scheduleAdapter.setItemList(testItems3.subList(0, 1))
                popupWindow?.adapter?.setItemList(testItems3.subList(1, testItems3.size))
            }

            homeSelectorBtnDate3.text1?.text = "수"
            homeSelectorBtnDate3.text2?.text = "12"
            homeSelectorBtnDate3.setOnClickListener {
                selectedDateButton(it as SelectorButton)
                scheduleAdapter.setItemList(testItems4.subList(0, 1))
                popupWindow?.adapter?.setItemList(testItems4.subList(1, testItems4.size))
            }

            homeSelectorBtnDate4.text1?.text = "목"
            homeSelectorBtnDate4.text2?.text = "13"
            homeSelectorBtnDate4.setOnClickListener {
                selectedDateButton(it as SelectorButton)
                scheduleAdapter.setItemList(testItems5.subList(0, 1))
                popupWindow?.adapter?.setItemList(testItems5.subList(1, testItems5.size))
            }

            homeSelectorBtnDate5.text1?.text = "금"
            homeSelectorBtnDate5.text2?.text = "14"
            homeSelectorBtnDate5.setOnClickListener {
                selectedDateButton(it as SelectorButton)
                scheduleAdapter.setItemList(testItems6.subList(0, 1))
                popupWindow?.adapter?.setItemList(testItems6.subList(1, testItems6.size))
            }
        }
    }

    private fun selectedDateButton(view: SelectorButton) {
        val isChecked = view.isChecked ?: false
        if (isChecked) return

        for (i in binding.linearLayout.children) {
            if (i.id == view.id) {
                view.setChecked(true)
            } else {
                if (i is SelectorButton) {
                    i.setChecked(false)
                }
            }
        }
    }

    private fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            when (view.getId()) {
                R.id.home_radio_btn1 -> {
                    val layoutManager = GridLayoutManager(context, 2)
                    binding.homeRecyclerview.layoutManager = layoutManager
                    binding.homeRadioBtn2.isChecked = false
                }
                R.id.home_radio_btn2 -> {
                    val layoutManager = GridLayoutManager(context, 3)
                    binding.homeRecyclerview.layoutManager = layoutManager
                    binding.homeRadioBtn1.isChecked = false
                }
            }
        }
    }

    private fun showPopUpWindow(onDismiss: () -> Unit) {
        popupWindow = drawPopUpWindow()
        popupWindow?.apply {
            showDarkView()
            showAsDropDown(binding.homeViewPopupWindowTop)
            setOnDismissListener { onDismiss() }
        }
    }

    private fun onPopUpWindowDismiss() {
        hideDarkView()
    }

    private fun drawPopUpWindow(): SchedulePopupWindow {
        val popUpView = PopupWindowBinding.inflate(layoutInflater)

        return SchedulePopupWindow(
            popUpView,
            GroupScheduleAdapter(),
            testItems2.subList(1, testItems2.size))
    }

    private fun showDarkView() {
        binding.homeViewDark.apply {
            visibility = View.VISIBLE
            animation = AlphaAnimation(0f, 1f).apply {
                duration = 300
            }
        }
    }

    private fun hideDarkView() {
        binding.homeViewDark.apply {
            visibility = View.GONE
            animation = AlphaAnimation(1f, 0f).apply {
                duration = 100
            }
        }
    }

    override fun onStop() {
        super.onStop()
        popupWindow?.dismiss()
        binding.homeRadioBtn2.isChecked = false
        binding.homeRadioBtn1.isChecked = true
    }

}