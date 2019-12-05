@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.client

import org.elasticsearch.action.ActionListener
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse
import org.elasticsearch.action.admin.cluster.settings.ClusterGetSettingsRequest
import org.elasticsearch.action.admin.cluster.settings.ClusterGetSettingsResponse
import org.elasticsearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest
import org.elasticsearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse
import org.elasticsearch.client.ClusterClient
import org.elasticsearch.client.RequestOptions
import java.io.IOException

@Throws(IOException::class)
inline fun ClusterClient.putSettings(options: RequestOptions = RequestOptions.DEFAULT, block: ClusterUpdateSettingsRequest.() -> Unit = {}): ClusterUpdateSettingsResponse =
        putSettings(ClusterUpdateSettingsRequest().apply(block), options)

inline fun ClusterClient.putSettingsAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<ClusterUpdateSettingsResponse>, block: ClusterUpdateSettingsRequest.() -> Unit = {}) =
        putSettingsAsync(ClusterUpdateSettingsRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun ClusterClient.getSettings(options: RequestOptions = RequestOptions.DEFAULT, block: ClusterGetSettingsRequest.() -> Unit = {}): ClusterGetSettingsResponse =
        getSettings(ClusterGetSettingsRequest().apply(block), options)

inline fun ClusterClient.getSettingsAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<ClusterGetSettingsResponse>, block: ClusterGetSettingsRequest.() -> Unit = {}) =
        getSettingsAsync(ClusterGetSettingsRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun ClusterClient.health(options: RequestOptions = RequestOptions.DEFAULT, block: ClusterHealthRequest.() -> Unit = {}): ClusterHealthResponse =
        health(ClusterHealthRequest().apply(block), options)

inline fun ClusterClient.healthAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<ClusterHealthResponse>, block: ClusterHealthRequest.() -> Unit = {}) =
        healthAsync(ClusterHealthRequest().apply(block), options, listener)
