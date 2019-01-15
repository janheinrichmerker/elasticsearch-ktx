@file:Suppress("UNUSED")

package com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.rest

import com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.awaitResponse
import com.heinrichreimer.elasticsearch.kotlin.dsl.rest.performRequestAsync
import org.elasticsearch.client.Request
import org.elasticsearch.client.Response
import org.elasticsearch.client.RestClient

suspend inline fun RestClient.performRequestAsync(method: String, endpoint: String, block: Request.() -> Unit = {}): Response =
        awaitResponse { performRequestAsync(method, endpoint, it, block) }
