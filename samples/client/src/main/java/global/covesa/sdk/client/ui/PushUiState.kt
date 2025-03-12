package global.covesa.sdk.client.ui

import android.content.Context
import global.covesa.sdk.api.client.push.PushManager

data class PushUiState(
    val registered: Boolean = false,
    val pushDistributor: String? = null,
    val availableDistributors: List<String> = emptyList(),
    val selectedDistributor: String? = null,
    val savedDistributor: String? = null,
) {
    constructor(context: Context) : this(
        registered = PushManager.getAckDistributor(context) != null,
        pushDistributor = PushManager.getAckDistributor(context) ?: PushManager.getSavedDistributor(context),
        availableDistributors = PushManager.getDistributors(context),
        selectedDistributor = PushManager.getSavedDistributor(context),
        savedDistributor = PushManager.getSavedDistributor(context),
    )
}