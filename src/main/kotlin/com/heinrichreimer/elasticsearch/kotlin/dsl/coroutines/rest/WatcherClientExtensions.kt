@file:Suppress("UNUSED")

package com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.rest

import com.heinrichreimer.elasticsearch.kotlin.dsl.rest.*
import com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.awaitAction
import org.elasticsearch.action.support.master.AcknowledgedResponse
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.WatcherClient
import org.elasticsearch.client.watcher.*
import org.elasticsearch.protocol.xpack.watcher.DeleteWatchRequest
import org.elasticsearch.protocol.xpack.watcher.DeleteWatchResponse
import org.elasticsearch.protocol.xpack.watcher.PutWatchRequest
import org.elasticsearch.protocol.xpack.watcher.PutWatchResponse

suspend inline fun WatcherClient.startWatchServiceAsync(options: RequestOptions = RequestOptions.DEFAULT, block: StartWatchServiceRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { startWatchServiceAsync(options, it, block) }

suspend inline fun WatcherClient.stopWatchServiceAsync(options: RequestOptions = RequestOptions.DEFAULT, block: StopWatchServiceRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { stopWatchServiceAsync(options, it, block) }

suspend inline fun WatcherClient.putWatchAsync(options: RequestOptions = RequestOptions.DEFAULT, block: PutWatchRequest.() -> Unit = {}): PutWatchResponse =
        awaitAction { putWatchAsync(options, it, block) }

suspend inline fun WatcherClient.deleteWatchAsync(options: RequestOptions = RequestOptions.DEFAULT, block: DeleteWatchRequest.() -> Unit = {}): DeleteWatchResponse =
        awaitAction { deleteWatchAsync(options, it, block) }

suspend inline fun WatcherClient.ackWatchAsync(watchId: String, vararg actionIds: String, options: RequestOptions = RequestOptions.DEFAULT, block: AckWatchRequest.() -> Unit = {}): AckWatchResponse =
        awaitAction { ackWatchAsync(watchId = watchId, actionIds = *actionIds, options = options, listener = it, block = block) }

suspend inline fun WatcherClient.activateWatchAsync(watchId: String, options: RequestOptions = RequestOptions.DEFAULT, block: ActivateWatchRequest.() -> Unit = {}): ActivateWatchResponse =
        awaitAction { activateWatchAsync(watchId, options, it, block) }
