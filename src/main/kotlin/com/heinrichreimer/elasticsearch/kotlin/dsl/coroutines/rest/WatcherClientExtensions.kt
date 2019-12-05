@file:Suppress("UNUSED")

package com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.rest

import com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.awaitAction
import com.heinrichreimer.elasticsearch.kotlin.dsl.rest.*
import org.elasticsearch.action.support.master.AcknowledgedResponse
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.WatcherClient
import org.elasticsearch.client.watcher.*
import org.elasticsearch.common.bytes.BytesReference
import org.elasticsearch.common.xcontent.XContentType

suspend inline fun WatcherClient.startWatchServiceAsync(options: RequestOptions = RequestOptions.DEFAULT, block: StartWatchServiceRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { startWatchServiceAsync(options, it, block) }

suspend inline fun WatcherClient.stopWatchServiceAsync(options: RequestOptions = RequestOptions.DEFAULT, block: StopWatchServiceRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { stopWatchServiceAsync(options, it, block) }

suspend inline fun WatcherClient.putWatchAsync(
        id: String,
        source: BytesReference,
        xContentType: XContentType,
        options: RequestOptions = RequestOptions.DEFAULT,
        block: PutWatchRequest.() -> Unit = {}
): PutWatchResponse =
        awaitAction { putWatchAsync(id, source, xContentType, options, it, block) }

suspend inline fun WatcherClient.deleteWatchAsync(
        id: String,
        options: RequestOptions = RequestOptions.DEFAULT,
        block: DeleteWatchRequest.() -> Unit = {}
): DeleteWatchResponse =
        awaitAction { deleteWatchAsync(id, options, it, block) }

suspend inline fun WatcherClient.ackWatchAsync(watchId: String, vararg actionIds: String, options: RequestOptions = RequestOptions.DEFAULT, block: AckWatchRequest.() -> Unit = {}): AckWatchResponse =
        awaitAction { ackWatchAsync(watchId = watchId, actionIds = *actionIds, options = options, listener = it, block = block) }

suspend inline fun WatcherClient.activateWatchAsync(watchId: String, options: RequestOptions = RequestOptions.DEFAULT, block: ActivateWatchRequest.() -> Unit = {}): ActivateWatchResponse =
        awaitAction { activateWatchAsync(watchId, options, it, block) }
