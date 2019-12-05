@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.rest

import org.elasticsearch.action.ActionListener
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.XPackClient
import org.elasticsearch.client.xpack.XPackInfoRequest
import org.elasticsearch.client.xpack.XPackInfoResponse
import org.elasticsearch.client.xpack.XPackUsageRequest
import org.elasticsearch.client.xpack.XPackUsageResponse
import java.io.IOException

@Throws(IOException::class)
inline fun XPackClient.info(options: RequestOptions = RequestOptions.DEFAULT, block: XPackInfoRequest.() -> Unit = {}): XPackInfoResponse =
        info(XPackInfoRequest().apply(block), options)

inline fun XPackClient.infoAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<XPackInfoResponse>, block: XPackInfoRequest.() -> Unit = {}) =
        infoAsync(XPackInfoRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun XPackClient.usage(options: RequestOptions = RequestOptions.DEFAULT, block: XPackUsageRequest.() -> Unit = {}): XPackUsageResponse =
        usage(XPackUsageRequest().apply(block), options)

inline fun XPackClient.usageAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<XPackUsageResponse>, block: XPackUsageRequest.() -> Unit = {}) =
        usageAsync(XPackUsageRequest().apply(block), options, listener)
