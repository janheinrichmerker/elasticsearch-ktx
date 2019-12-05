@file:Suppress("UNUSED")

package com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.rest

import com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.awaitAction
import com.heinrichreimer.elasticsearch.kotlin.dsl.rest.getRollupCapabilitiesAsync
import com.heinrichreimer.elasticsearch.kotlin.dsl.rest.getRollupJobAsync
import com.heinrichreimer.elasticsearch.kotlin.dsl.rest.putRollupJobAsync
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RollupClient
import org.elasticsearch.client.core.AcknowledgedResponse
import org.elasticsearch.client.rollup.*
import org.elasticsearch.client.rollup.job.config.RollupJobConfig

suspend inline fun RollupClient.putRollupJobAsync(
    config: RollupJobConfig,
    options: RequestOptions = RequestOptions.DEFAULT,
    block: PutRollupJobRequest.() -> Unit = {}
): AcknowledgedResponse =
    awaitAction { putRollupJobAsync(config, options, it, block) }

suspend inline fun RollupClient.getRollupJobAsync(options: RequestOptions = RequestOptions.DEFAULT, block: GetRollupJobRequest.() -> Unit = {}): GetRollupJobResponse =
        awaitAction { getRollupJobAsync(options, it, block) }

suspend inline fun RollupClient.getRollupCapabilitiesAsync(indexPattern: String, options: RequestOptions = RequestOptions.DEFAULT, block: GetRollupCapsRequest.() -> Unit = {}): GetRollupCapsResponse =
        awaitAction { getRollupCapabilitiesAsync(indexPattern, options, it, block) }
