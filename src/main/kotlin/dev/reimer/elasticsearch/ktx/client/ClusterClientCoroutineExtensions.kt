@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.client

import dev.reimer.elasticsearch.ktx.util.awaitAction
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse
import org.elasticsearch.action.admin.cluster.settings.ClusterGetSettingsRequest
import org.elasticsearch.action.admin.cluster.settings.ClusterGetSettingsResponse
import org.elasticsearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest
import org.elasticsearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse
import org.elasticsearch.client.ClusterClient
import org.elasticsearch.client.RequestOptions

// See [Cluster API on elastic.co](https://www.elastic.co/guide/en/elasticsearch/reference/current/cluster.html).

suspend inline fun ClusterClient.getSettingsAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: ClusterGetSettingsRequest.() -> Unit = {}): ClusterGetSettingsResponse =
    awaitAction { getSettingsAsync(options, it, block) }

suspend inline fun ClusterClient.healthAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: ClusterHealthRequest.() -> Unit = {}): ClusterHealthResponse =
    awaitAction { healthAsync(options, it, block) }

suspend inline fun ClusterClient.putSettingsAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: ClusterUpdateSettingsRequest.() -> Unit = {}): ClusterUpdateSettingsResponse =
    awaitAction { putSettingsAsync(options, it, block) }
