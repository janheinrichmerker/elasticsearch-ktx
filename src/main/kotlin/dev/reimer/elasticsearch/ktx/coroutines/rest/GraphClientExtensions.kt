@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.coroutines.rest

import dev.reimer.elasticsearch.ktx.coroutines.awaitAction
import dev.reimer.elasticsearch.ktx.rest.exploreAsync
import org.elasticsearch.client.GraphClient
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.graph.GraphExploreRequest
import org.elasticsearch.client.graph.GraphExploreResponse

suspend inline fun GraphClient.exploreAsync(options: RequestOptions = RequestOptions.DEFAULT, block: GraphExploreRequest.() -> Unit = {}): GraphExploreResponse =
        awaitAction { exploreAsync(options, it, block) }
