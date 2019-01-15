@file:Suppress("UNUSED")

package com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.rest

import com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.awaitAction
import com.heinrichreimer.elasticsearch.kotlin.dsl.rest.exploreAsync
import org.elasticsearch.client.GraphClient
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.protocol.xpack.graph.GraphExploreRequest
import org.elasticsearch.protocol.xpack.graph.GraphExploreResponse

suspend inline fun GraphClient.exploreAsync(options: RequestOptions = RequestOptions.DEFAULT, block: GraphExploreRequest.() -> Unit = {}): GraphExploreResponse =
        awaitAction { exploreAsync(options, it, block) }
