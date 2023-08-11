package com.matter.virtual.device.app.feature.closure

import android.text.Html
import android.widget.SeekBar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.matter.virtual.device.app.core.model.databinding.ButtonData
import com.matter.virtual.device.app.core.model.databinding.SeekbarData
import com.matter.virtual.device.app.core.ui.BaseFragment
import com.matter.virtual.device.app.core.ui.databinding.LayoutAppbarBinding
import com.matter.virtual.device.app.feature.closure.databinding.FragmentDoorLockBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import timber.log.Timber

@AndroidEntryPoint
class DoorLockFragment :
    BaseFragment<FragmentDoorLockBinding, DoorLockViewModel>(R.layout.fragment_door_lock) {

    override val viewModel: DoorLockViewModel by viewModels()

    @OptIn(ExperimentalSerializationApi::class)
    override fun setupNavArgs() {
        val args: DoorLockFragmentArgs by navArgs()
        matterSettings = Json.decodeFromString(args.setting)
    }

    override fun setupAppbar(): LayoutAppbarBinding = binding.appbar

    override fun setupUi() {
        /** title icon */
        binding.doorLockTitleLayout.titleIcon.setImageResource(matterSettings.device.deviceIconResId)

        /** title text */
        binding.doorLockTitleLayout.titleText.text =
            getString(matterSettings.device.deviceNameResId)


        /** OnOff layout */
        binding.doorLockOnOffLayout.buttonData =
            ButtonData(
                onOff = viewModel.lockState,
                onText = R.string.door_lock_unlocked,
                offText = R.string.door_lock_locked
            )

        binding.doorLockOnOffLayout.button.setOnClickListener { viewModel.onClickButton() }

        /** Send alarm layout */
        binding.doorLockSendAlarmLayout.valueText.text =
            getString(R.string.door_lock_send_lock_alarm_event)
        binding.doorLockSendAlarmLayout.button.setOnClickListener {
            viewModel.onClickSendLockAlarmEventButton()
        }

        /** Battery layout */
        binding.doorLockBatteryLayout.titleText.text = getString(R.string.battery)
        binding.doorLockBatteryLayout.seekbarData = SeekbarData(progress = viewModel.batteryStatus)
        binding.doorLockBatteryLayout.seekbar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    viewModel.updateBatterySeekbarProgress(progress)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    viewModel.updateBatteryStatusToCluster(seekBar?.progress)
                }
            }
        )
    }

    override fun setupObservers() {
        viewModel.batteryStatus.observe(viewLifecycleOwner) {
            val text: String = getString(R.string.battery_format, it)
            binding.doorLockBatteryLayout.valueText.text =
                Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY)
        }
    }

    override fun onResume() {
        Timber.d("onResume()")
        super.onResume()
    }

    override fun onDestroy() {
        Timber.d("onDestroy()")
        super.onDestroy()
    }
}
