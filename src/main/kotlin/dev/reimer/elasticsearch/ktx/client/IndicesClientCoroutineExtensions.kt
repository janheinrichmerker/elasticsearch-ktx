@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.client

import dev.reimer.elasticsearch.ktx.util.awaitAction
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest
import org.elasticsearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest
import org.elasticsearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest
import org.elasticsearch.action.admin.indices.flush.FlushRequest
import org.elasticsearch.action.admin.indices.flush.FlushResponse
import org.elasticsearch.action.admin.indices.flush.SyncedFlushRequest
import org.elasticsearch.action.admin.indices.forcemerge.ForceMergeRequest
import org.elasticsearch.action.admin.indices.forcemerge.ForceMergeResponse
import org.elasticsearch.action.admin.indices.get.GetIndexRequest
import org.elasticsearch.action.admin.indices.get.GetIndexResponse
import org.elasticsearch.action.admin.indices.mapping.get.GetFieldMappingsRequest
import org.elasticsearch.action.admin.indices.mapping.get.GetFieldMappingsResponse
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsRequest
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsResponse
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest
import org.elasticsearch.action.admin.indices.open.OpenIndexRequest
import org.elasticsearch.action.admin.indices.open.OpenIndexResponse
import org.elasticsearch.action.admin.indices.refresh.RefreshRequest
import org.elasticsearch.action.admin.indices.refresh.RefreshResponse
import org.elasticsearch.action.admin.indices.rollover.RolloverRequest
import org.elasticsearch.action.admin.indices.rollover.RolloverResponse
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsRequest
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsResponse
import org.elasticsearch.action.admin.indices.settings.put.UpdateSettingsRequest
import org.elasticsearch.action.admin.indices.shrink.ResizeRequest
import org.elasticsearch.action.admin.indices.shrink.ResizeResponse
import org.elasticsearch.action.admin.indices.template.get.GetIndexTemplatesResponse
import org.elasticsearch.action.admin.indices.template.put.PutIndexTemplateRequest
import org.elasticsearch.action.admin.indices.validate.query.ValidateQueryRequest
import org.elasticsearch.action.admin.indices.validate.query.ValidateQueryResponse
import org.elasticsearch.action.support.master.AcknowledgedResponse
import org.elasticsearch.client.GetAliasesResponse
import org.elasticsearch.client.IndicesClient
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.SyncedFlushResponse
import org.elasticsearch.client.indices.*

// See [Indices API on elastic.co](https://www.elastic.co/guide/en/elasticsearch/reference/current/indices.html).

suspend inline fun IndicesClient.analyzeAsync(index: String, field: String, vararg text: String, options: RequestOptions = RequestOptions.DEFAULT, crossinline block: AnalyzeRequest.() -> Unit = {}): AnalyzeResponse =
    awaitAction { analyzeAsync(index, field, *text, options = options, listener = it, block = block) }

suspend inline fun IndicesClient.clearCacheAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: ClearIndicesCacheRequest.() -> Unit = {}): ClearIndicesCacheResponse =
    awaitAction { clearCacheAsync(options, it, block) }

// TODO clone

suspend inline fun IndicesClient.closeAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: CloseIndexRequest.() -> Unit = {}): CloseIndexResponse =
    awaitAction { closeAsync(options, it, block) }

suspend inline fun IndicesClient.createAsync(index: String, options: RequestOptions = RequestOptions.DEFAULT, crossinline block: CreateIndexRequest.() -> Unit = {}): CreateIndexResponse =
    awaitAction { createAsync(index, options, it, block) }

suspend inline fun IndicesClient.deleteAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: DeleteIndexRequest.() -> Unit = {}): AcknowledgedResponse =
    awaitAction { deleteAsync(options, it, block) }

// TODO deleteTemplate

@Deprecated(message = "Deprecated in Java")
@Suppress("DEPRECATION")
suspend inline fun IndicesClient.existsAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: GetIndexRequest.() -> Unit = {}): Boolean =
    awaitAction { existsAsync(options, it, block) }

suspend inline fun IndicesClient.existsAliasAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: GetAliasesRequest.() -> Unit = {}): Boolean =
    awaitAction { existsAliasAsync(options, it, block) }

// TODO existsTemplate

suspend inline fun IndicesClient.flushAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: FlushRequest.() -> Unit = {}): FlushResponse =
    awaitAction { flushAsync(options, it, block) }

suspend inline fun IndicesClient.flushSyncedAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: SyncedFlushRequest.() -> Unit = {}): SyncedFlushResponse =
    awaitAction { flushSyncedAsync(options, it, block) }

suspend inline fun IndicesClient.forcemergeAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: ForceMergeRequest.() -> Unit = {}): ForceMergeResponse =
    awaitAction { forcemergeAsync(options, it, block) }

// TODO freeze

@Deprecated(message = "Deprecated in Java")
@Suppress("DEPRECATION")
suspend inline fun IndicesClient.getAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: GetIndexRequest.() -> Unit = {}): GetIndexResponse =
    awaitAction { getAsync(options, it, block) }

suspend inline fun IndicesClient.getAliasAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: GetAliasesRequest.() -> Unit = {}): GetAliasesResponse =
    awaitAction { getAliasAsync(options, it, block) }

@Deprecated(message = "Deprecated in Java")
@Suppress("DEPRECATION")
suspend inline fun IndicesClient.getFieldMappingAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: GetFieldMappingsRequest.() -> Unit = {}): GetFieldMappingsResponse =
    awaitAction { getFieldMappingAsync(options, it, block) }

// TODO getIndexTemplate

@Deprecated(message = "Deprecated in Java")
@Suppress("DEPRECATION")
suspend inline fun IndicesClient.getMappingAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: GetMappingsRequest.() -> Unit = {}): GetMappingsResponse =
    awaitAction { getMappingAsync(options, it, block) }

suspend inline fun IndicesClient.getSettingsAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: GetSettingsRequest.() -> Unit = {}): GetSettingsResponse =
    awaitAction { getSettingsAsync(options, it, block) }

@Deprecated(message = "Deprecated in Java")
@Suppress("DEPRECATION")
suspend inline fun IndicesClient.getTemplateAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: org.elasticsearch.client.indices.GetIndexTemplatesRequest.() -> Unit = {}): GetIndexTemplatesResponse =
    awaitAction { getTemplateAsync(options, it, block) }

suspend inline fun IndicesClient.openAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: OpenIndexRequest.() -> Unit = {}): OpenIndexResponse =
    awaitAction { openAsync(options, it, block) }

@Deprecated(message = "Deprecated in Java")
@Suppress("DEPRECATION")
suspend inline fun IndicesClient.putMappingAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: PutMappingRequest.() -> Unit = {}): AcknowledgedResponse =
    awaitAction { putMappingAsync(options, it, block) }

suspend inline fun IndicesClient.putSettingsAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: UpdateSettingsRequest.() -> Unit = {}): AcknowledgedResponse =
    awaitAction { putSettingsAsync(options, it, block) }

@Deprecated(message = "Deprecated in Java")
@Suppress("DEPRECATION")
suspend inline fun IndicesClient.putTemplateAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: PutIndexTemplateRequest.() -> Unit = {}): AcknowledgedResponse =
    awaitAction { putTemplateAsync(options, it, block) }

suspend inline fun IndicesClient.refreshAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: RefreshRequest.() -> Unit = {}): RefreshResponse =
    awaitAction { refreshAsync(options, it, block) }

// TODO reloadAnalyzers

@Deprecated(message = "Deprecated in Java")
@Suppress("DEPRECATION")
suspend inline fun IndicesClient.rolloverAsync(alias: String, newIndexName: String, options: RequestOptions = RequestOptions.DEFAULT, crossinline block: RolloverRequest.() -> Unit = {}): RolloverResponse =
    awaitAction { rolloverAsync(alias, newIndexName, options, it, block) }

suspend inline fun IndicesClient.shrinkAsync(targetIndex: String, sourceIndex: String, options: RequestOptions = RequestOptions.DEFAULT, crossinline block: ResizeRequest.() -> Unit = {}): ResizeResponse =
    awaitAction { shrinkAsync(targetIndex, sourceIndex, options, it, block) }

suspend inline fun IndicesClient.splitAsync(targetIndex: String, sourceIndex: String, options: RequestOptions = RequestOptions.DEFAULT, crossinline block: ResizeRequest.() -> Unit = {}): ResizeResponse =
    awaitAction { splitAsync(targetIndex, sourceIndex, options, it, block) }

// TODO unfreeze

suspend inline fun IndicesClient.updateAliasesAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: IndicesAliasesRequest.() -> Unit = {}): AcknowledgedResponse =
    awaitAction { updateAliasesAsync(options, it, block) }

suspend inline fun IndicesClient.validateQueryAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: ValidateQueryRequest.() -> Unit = {}): ValidateQueryResponse =
    awaitAction { validateQueryAsync(options, it, block) }
