@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.rest

import org.elasticsearch.action.ActionListener
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RollupClient
import org.elasticsearch.client.core.AcknowledgedResponse
import org.elasticsearch.client.rollup.*
import org.elasticsearch.client.rollup.job.config.RollupJobConfig
import java.io.IOException

@Throws(IOException::class)
inline fun RollupClient.putRollupJob(
        config: RollupJobConfig,
        options: RequestOptions = RequestOptions.DEFAULT,
        block: PutRollupJobRequest.() -> Unit = {}
): AcknowledgedResponse =
        putRollupJob(PutRollupJobRequest(config).apply(block), options)

inline fun RollupClient.putRollupJobAsync(
        config: RollupJobConfig,
        options: RequestOptions = RequestOptions.DEFAULT,
        listener: ActionListener<AcknowledgedResponse>,
        block: PutRollupJobRequest.() -> Unit = {}
) =
        putRollupJobAsync(PutRollupJobRequest(config).apply(block), options, listener)

@Throws(IOException::class)
inline fun RollupClient.getRollupJob(options: RequestOptions = RequestOptions.DEFAULT, block: GetRollupJobRequest.() -> Unit = {}): GetRollupJobResponse =
        getRollupJob(GetRollupJobRequest().apply(block), options)

inline fun RollupClient.getRollupJobAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetRollupJobResponse>, block: GetRollupJobRequest.() -> Unit = {}) =
        getRollupJobAsync(GetRollupJobRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RollupClient.getRollupCapabilities(indexPattern: String, options: RequestOptions = RequestOptions.DEFAULT, block: GetRollupCapsRequest.() -> Unit = {}): GetRollupCapsResponse =
        getRollupCapabilities(GetRollupCapsRequest(indexPattern).apply(block), options)

inline fun RollupClient.getRollupCapabilitiesAsync(indexPattern: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetRollupCapsResponse>, block: GetRollupCapsRequest.() -> Unit = {}) =
        getRollupCapabilitiesAsync(GetRollupCapsRequest(indexPattern).apply(block), options, listener)
