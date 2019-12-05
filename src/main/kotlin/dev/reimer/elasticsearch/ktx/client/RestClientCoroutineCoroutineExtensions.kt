@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.client

import dev.reimer.elasticsearch.ktx.util.awaitResponse
import org.elasticsearch.client.Request
import org.elasticsearch.client.Response
import org.elasticsearch.client.RestClient

suspend inline fun RestClient.performRequestAsync(
    method: String,
    endpoint: String,
    block: Request.() -> Unit = {}
): Response =
    awaitResponse {
        performRequestAsync(
            method,
            endpoint,
            it,
            block
        )
    }
