package com.matter.virtual.device.app.core.domain.usecase.matter.cluster.doorlock

import com.matter.virtual.device.app.core.common.di.IoDispatcher
import com.matter.virtual.device.app.core.data.repository.cluster.DoorLockManagerRepository
import com.matter.virtual.device.app.core.domain.NonParamCoroutineUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SendLockAlarmEventUseCase
@Inject
constructor(
    private val doorLockManagerRepository: DoorLockManagerRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : NonParamCoroutineUseCase<Unit>(dispatcher) {

    override suspend fun execute() {
        return doorLockManagerRepository.sendLockAlarmEvent()
    }
}
