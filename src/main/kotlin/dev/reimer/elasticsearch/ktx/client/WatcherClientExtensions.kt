@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.client

import org.elasticsearch.action.ActionListener
import org.elasticsearch.action.support.master.AcknowledgedResponse
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.WatcherClient
import org.elasticsearch.client.watcher.*
import org.elasticsearch.common.bytes.BytesReference
import org.elasticsearch.common.xcontent.XContentType
import java.io.IOException

@Throws(IOException::class)
inline fun WatcherClient.startWatchService(options: RequestOptions = RequestOptions.DEFAULT, block: StartWatchServiceRequest.() -> Unit = {}): AcknowledgedResponse =
        startWatchService(StartWatchServiceRequest().apply(block), options)

inline fun WatcherClient.startWatchServiceAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: StartWatchServiceRequest.() -> Unit = {}) =
        startWatchServiceAsync(StartWatchServiceRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun WatcherClient.stopWatchService(options: RequestOptions = RequestOptions.DEFAULT, block: StopWatchServiceRequest.() -> Unit = {}): AcknowledgedResponse =
        stopWatchService(StopWatchServiceRequest().apply(block), options)

inline fun WatcherClient.stopWatchServiceAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: StopWatchServiceRequest.() -> Unit = {}) =
        stopWatchServiceAsync(StopWatchServiceRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun WatcherClient.putWatch(
        id: String,
        source: BytesReference,
        xContentType: XContentType,
        options: RequestOptions = RequestOptions.DEFAULT,
        block: PutWatchRequest.() -> Unit = {}
) =
        putWatch(PutWatchRequest(id, source, xContentType).apply(block), options)

inline fun WatcherClient.putWatchAsync(
        id: String,
        source: BytesReference,
        xContentType: XContentType,
        options: RequestOptions = RequestOptions.DEFAULT,
        listener: ActionListener<PutWatchResponse>,
        block: PutWatchRequest.() -> Unit = {}
) =
        putWatchAsync(PutWatchRequest(id, source, xContentType).apply(block), options, listener)

@Throws(IOException::class)
inline fun WatcherClient.deleteWatch(
        id: String,
        options: RequestOptions = RequestOptions.DEFAULT,
        block: DeleteWatchRequest.() -> Unit = {}
): DeleteWatchResponse =
        deleteWatch(DeleteWatchRequest(id).apply(block), options)

inline fun WatcherClient.deleteWatchAsync(
        id: String,
        options: RequestOptions = RequestOptions.DEFAULT,
        listener: ActionListener<DeleteWatchResponse>,
        block: DeleteWatchRequest.() -> Unit = {}
) =
        deleteWatchAsync(DeleteWatchRequest(id).apply(block), options, listener)

@Throws(IOException::class)
inline fun WatcherClient.ackWatch(watchId: String, vararg actionIds: String, options: RequestOptions = RequestOptions.DEFAULT, block: AckWatchRequest.() -> Unit = {}): AckWatchResponse =
        ackWatch(AckWatchRequest(watchId, *actionIds).apply(block), options)

inline fun WatcherClient.ackWatchAsync(watchId: String, vararg actionIds: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AckWatchResponse>, block: AckWatchRequest.() -> Unit = {}) =
        ackWatchAsync(AckWatchRequest(watchId, *actionIds).apply(block), options, listener)

@Throws(IOException::class)
inline fun WatcherClient.activateWatch(watchId: String, options: RequestOptions = RequestOptions.DEFAULT, block: ActivateWatchRequest.() -> Unit = {}): ActivateWatchResponse =
        activateWatch(ActivateWatchRequest(watchId).apply(block), options)

inline fun WatcherClient.activateWatchAsync(watchId: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<ActivateWatchResponse>, block: ActivateWatchRequest.() -> Unit = {}) =
        activateWatchAsync(ActivateWatchRequest(watchId).apply(block), options, listener)
