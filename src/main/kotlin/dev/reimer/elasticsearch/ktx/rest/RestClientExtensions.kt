@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.rest

import org.apache.http.HttpHost
import org.elasticsearch.client.*
import java.io.IOException

inline fun restClientOf(vararg nodes: Node, block: RestClientBuilder.() -> Unit = {}): RestClient =
        RestClient.builder(*nodes).apply(block).build()

inline fun restClientOf(vararg hosts: HttpHost, block: RestClientBuilder.() -> Unit = {}): RestClient =
        RestClient.builder(*hosts).apply(block).build()

@Throws(IOException::class)
inline fun RestClient.performRequest(method: String, endpoint: String, block: Request.() -> Unit = {}): Response =
        performRequest(Request(method, endpoint).apply(block))

inline fun RestClient.performRequestAsync(method: String, endpoint: String, listener: ResponseListener, block: Request.() -> Unit = {}) =
        performRequestAsync(Request(method, endpoint).apply(block), listener)
