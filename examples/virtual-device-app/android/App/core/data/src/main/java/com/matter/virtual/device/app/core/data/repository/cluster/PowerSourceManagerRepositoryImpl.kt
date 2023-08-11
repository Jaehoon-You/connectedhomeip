package com.matter.virtual.device.app.core.data.repository.cluster

import com.matter.virtual.device.app.core.matter.manager.PowerSourceManagerStub
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

internal class PowerSourceManagerRepositoryImpl
@Inject
constructor(private val powerSourceManagerStub: PowerSourceManagerStub) : PowerSourceManagerRepository {

  override fun getBatPercent(): StateFlow<Int> {
    return powerSourceManagerStub.batPercent
  }

  override suspend fun setBatPercentRemaining(batteryPercentRemaining: Int) {
    powerSourceManagerStub.setBatPercentRemaining(batteryPercentRemaining)
  }
}
