@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.client

import org.elasticsearch.action.ActionListener
import org.elasticsearch.action.ingest.*
import org.elasticsearch.action.support.master.AcknowledgedResponse
import org.elasticsearch.client.Cancellable
import org.elasticsearch.client.IngestClient
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.common.bytes.BytesReference
import org.elasticsearch.common.xcontent.XContentType
import java.io.IOException

// See [Ingest API on elastic.co](https://www.elastic.co/guide/en/elasticsearch/reference/current/ingest.html).

@Throws(IOException::class)
inline fun IngestClient.deletePipeline(id: String, options: RequestOptions = RequestOptions.DEFAULT, block: DeletePipelineRequest.() -> Unit = {}): AcknowledgedResponse =
        deletePipeline(DeletePipelineRequest(id).apply(block), options)

inline fun IngestClient.deletePipelineAsync(id: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: DeletePipelineRequest.() -> Unit = {}): Cancellable =
        deletePipelineAsync(DeletePipelineRequest(id).apply(block), options, listener)

@Throws(IOException::class)
inline fun IngestClient.getPipeline(options: RequestOptions = RequestOptions.DEFAULT, block: GetPipelineRequest.() -> Unit = {}): GetPipelineResponse =
        getPipeline(GetPipelineRequest().apply(block), options)

inline fun IngestClient.getPipelineAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetPipelineResponse>, block: GetPipelineRequest.() -> Unit = {}): Cancellable =
        getPipelineAsync(GetPipelineRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IngestClient.putPipeline(id: String, source: BytesReference, xContentType: XContentType, options: RequestOptions = RequestOptions.DEFAULT, block: PutPipelineRequest.() -> Unit = {}): AcknowledgedResponse =
        putPipeline(PutPipelineRequest(id, source, xContentType).apply(block), options)

inline fun IngestClient.putPipelineAsync(id: String, source: BytesReference, xContentType: XContentType, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: PutPipelineRequest.() -> Unit = {}): Cancellable =
        putPipelineAsync(PutPipelineRequest(id, source, xContentType).apply(block), options, listener)

@Throws(IOException::class)
inline fun IngestClient.simulate(source: BytesReference, xContentType: XContentType, options: RequestOptions = RequestOptions.DEFAULT, block: SimulatePipelineRequest.() -> Unit = {}): SimulatePipelineResponse =
        simulate(SimulatePipelineRequest(source, xContentType).apply(block), options)

inline fun IngestClient.simulateAsync(source: BytesReference, xContentType: XContentType, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<SimulatePipelineResponse>, block: SimulatePipelineRequest.() -> Unit = {}): Cancellable =
        simulateAsync(SimulatePipelineRequest(source, xContentType).apply(block), options, listener)
