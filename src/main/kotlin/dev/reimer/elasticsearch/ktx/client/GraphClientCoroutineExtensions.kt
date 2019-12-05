@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.client

import dev.reimer.elasticsearch.ktx.util.awaitAction
import org.elasticsearch.client.GraphClient
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.graph.GraphExploreRequest
import org.elasticsearch.client.graph.GraphExploreResponse

suspend inline fun GraphClient.exploreAsync(options: RequestOptions = RequestOptions.DEFAULT, block: GraphExploreRequest.() -> Unit = {}): GraphExploreResponse =
    awaitAction { exploreAsync(options, it, block) }
