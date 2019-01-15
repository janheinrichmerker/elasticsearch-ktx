@file:Suppress("UNUSED")

package com.heinrichreimer.elasticsearch.kotlin.dsl.rest

import org.elasticsearch.action.ActionListener
import org.elasticsearch.client.GraphClient
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.protocol.xpack.graph.GraphExploreRequest
import org.elasticsearch.protocol.xpack.graph.GraphExploreResponse
import java.io.IOException

@Throws(IOException::class)
inline fun GraphClient.explore(options: RequestOptions = RequestOptions.DEFAULT, block: GraphExploreRequest.() -> Unit = {}): GraphExploreResponse =
        explore(GraphExploreRequest().apply(block), options)

inline fun GraphClient.exploreAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GraphExploreResponse>, block: GraphExploreRequest.() -> Unit = {}) =
        exploreAsync(GraphExploreRequest().apply(block), options, listener)
