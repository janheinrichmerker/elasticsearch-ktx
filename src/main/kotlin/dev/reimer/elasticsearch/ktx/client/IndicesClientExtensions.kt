@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.client

import org.elasticsearch.action.ActionListener
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest
import org.elasticsearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest
import org.elasticsearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse
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
import java.io.IOException

// See [Indices API on elastic.co](https://www.elastic.co/guide/en/elasticsearch/reference/current/indices.html).

@Throws(IOException::class)
inline fun IndicesClient.delete(options: RequestOptions = RequestOptions.DEFAULT, block: DeleteIndexRequest.() -> Unit = {}): AcknowledgedResponse =
        delete(DeleteIndexRequest().apply(block), options)

inline fun IndicesClient.deleteAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: DeleteIndexRequest.() -> Unit = {}) =
        deleteAsync(DeleteIndexRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.create(options: RequestOptions = RequestOptions.DEFAULT, block: CreateIndexRequest.() -> Unit = {}): CreateIndexResponse =
        create(CreateIndexRequest().apply(block), options)

inline fun IndicesClient.createAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<CreateIndexResponse>, block: CreateIndexRequest.() -> Unit = {}) =
        createAsync(CreateIndexRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.putMapping(options: RequestOptions = RequestOptions.DEFAULT, block: PutMappingRequest.() -> Unit = {}): AcknowledgedResponse =
        putMapping(PutMappingRequest().apply(block), options)

inline fun IndicesClient.putMappingAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: PutMappingRequest.() -> Unit = {}) =
        putMappingAsync(PutMappingRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.getMapping(options: RequestOptions = RequestOptions.DEFAULT, block: GetMappingsRequest.() -> Unit = {}): GetMappingsResponse =
        getMapping(GetMappingsRequest().apply(block), options)

inline fun IndicesClient.getMappingAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetMappingsResponse>, block: GetMappingsRequest.() -> Unit = {}) =
        getMappingAsync(GetMappingsRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.getFieldMapping(options: RequestOptions = RequestOptions.DEFAULT, block: GetFieldMappingsRequest.() -> Unit = {}): GetFieldMappingsResponse =
        getFieldMapping(GetFieldMappingsRequest().apply(block), options)

inline fun IndicesClient.getFieldMappingAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetFieldMappingsResponse>, block: GetFieldMappingsRequest.() -> Unit = {}) =
        getFieldMappingAsync(GetFieldMappingsRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.updateAliases(options: RequestOptions = RequestOptions.DEFAULT, block: IndicesAliasesRequest.() -> Unit = {}): AcknowledgedResponse =
        updateAliases(IndicesAliasesRequest().apply(block), options)

inline fun IndicesClient.updateAliasesAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: IndicesAliasesRequest.() -> Unit = {}) =
        updateAliasesAsync(IndicesAliasesRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.open(options: RequestOptions = RequestOptions.DEFAULT, block: OpenIndexRequest.() -> Unit = {}): OpenIndexResponse =
        open(OpenIndexRequest().apply(block), options)

inline fun IndicesClient.openAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<OpenIndexResponse>, block: OpenIndexRequest.() -> Unit = {}) =
        openAsync(OpenIndexRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.close(options: RequestOptions = RequestOptions.DEFAULT, block: CloseIndexRequest.() -> Unit = {}): AcknowledgedResponse =
        close(CloseIndexRequest().apply(block), options)

inline fun IndicesClient.closeAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<CloseIndexResponse>, block: CloseIndexRequest.() -> Unit = {}) =
        closeAsync(CloseIndexRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.existsAlias(options: RequestOptions = RequestOptions.DEFAULT, block: GetAliasesRequest.() -> Unit = {}): Boolean =
        existsAlias(GetAliasesRequest().apply(block), options)

inline fun IndicesClient.existsAliasAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<Boolean>, block: GetAliasesRequest.() -> Unit = {}) =
        existsAliasAsync(GetAliasesRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.refresh(options: RequestOptions = RequestOptions.DEFAULT, block: RefreshRequest.() -> Unit = {}): RefreshResponse =
        refresh(RefreshRequest().apply(block), options)

inline fun IndicesClient.refreshAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<RefreshResponse>, block: RefreshRequest.() -> Unit = {}) =
        refreshAsync(RefreshRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.flush(options: RequestOptions = RequestOptions.DEFAULT, block: FlushRequest.() -> Unit = {}): FlushResponse =
        flush(FlushRequest().apply(block), options)

inline fun IndicesClient.flushAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<FlushResponse>, block: FlushRequest.() -> Unit = {}) =
        flushAsync(FlushRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.flushSynced(options: RequestOptions = RequestOptions.DEFAULT, block: SyncedFlushRequest.() -> Unit = {}): SyncedFlushResponse =
        flushSynced(SyncedFlushRequest().apply(block), options)

inline fun IndicesClient.flushSyncedAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<SyncedFlushResponse>, block: SyncedFlushRequest.() -> Unit = {}) =
        flushSyncedAsync(SyncedFlushRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.getSettings(options: RequestOptions = RequestOptions.DEFAULT, block: GetSettingsRequest.() -> Unit = {}): GetSettingsResponse =
        getSettings(GetSettingsRequest().apply(block), options)

inline fun IndicesClient.getSettingsAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetSettingsResponse>, block: GetSettingsRequest.() -> Unit = {}) =
        getSettingsAsync(GetSettingsRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.get(options: RequestOptions = RequestOptions.DEFAULT, block: GetIndexRequest.() -> Unit = {}): GetIndexResponse =
        get(GetIndexRequest().apply(block), options)

inline fun IndicesClient.getAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetIndexResponse>, block: GetIndexRequest.() -> Unit = {}) =
        getAsync(GetIndexRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.forcemerge(options: RequestOptions = RequestOptions.DEFAULT, block: ForceMergeRequest.() -> Unit = {}): ForceMergeResponse =
        forcemerge(ForceMergeRequest().apply(block), options)

inline fun IndicesClient.forcemergeAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<ForceMergeResponse>, block: ForceMergeRequest.() -> Unit = {}) =
        forcemergeAsync(ForceMergeRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.clearCache(options: RequestOptions = RequestOptions.DEFAULT, block: ClearIndicesCacheRequest.() -> Unit = {}): ClearIndicesCacheResponse =
        clearCache(ClearIndicesCacheRequest().apply(block), options)

inline fun IndicesClient.clearCacheAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<ClearIndicesCacheResponse>, block: ClearIndicesCacheRequest.() -> Unit = {}) =
        clearCacheAsync(ClearIndicesCacheRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.exists(options: RequestOptions = RequestOptions.DEFAULT, block: GetIndexRequest.() -> Unit = {}): Boolean =
        exists(GetIndexRequest().apply(block), options)

inline fun IndicesClient.existsAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<Boolean>, block: GetIndexRequest.() -> Unit = {}) =
        existsAsync(GetIndexRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.shrink(targetIndex: String, sourceIndex: String, options: RequestOptions = RequestOptions.DEFAULT, block: ResizeRequest.() -> Unit = {}): ResizeResponse =
        shrink(ResizeRequest(targetIndex, sourceIndex).apply(block), options)

inline fun IndicesClient.shrinkAsync(targetIndex: String, sourceIndex: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<ResizeResponse>, block: ResizeRequest.() -> Unit = {}) =
        shrinkAsync(ResizeRequest(targetIndex, sourceIndex).apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.split(targetIndex: String, sourceIndex: String, options: RequestOptions = RequestOptions.DEFAULT, block: ResizeRequest.() -> Unit = {}): ResizeResponse =
        split(ResizeRequest(targetIndex, sourceIndex).apply(block), options)

inline fun IndicesClient.splitAsync(targetIndex: String, sourceIndex: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<ResizeResponse>, block: ResizeRequest.() -> Unit = {}) =
        splitAsync(ResizeRequest(targetIndex, sourceIndex).apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.rollover(alias: String, newIndexName: String, options: RequestOptions = RequestOptions.DEFAULT, block: RolloverRequest.() -> Unit = {}): RolloverResponse =
        rollover(RolloverRequest(alias, newIndexName).apply(block), options)

inline fun IndicesClient.rolloverAsync(alias: String, newIndexName: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<RolloverResponse>, block: RolloverRequest.() -> Unit = {}) =
        rolloverAsync(RolloverRequest(alias, newIndexName).apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.getAlias(options: RequestOptions = RequestOptions.DEFAULT, block: GetAliasesRequest.() -> Unit = {}): GetAliasesResponse =
        getAlias(GetAliasesRequest().apply(block), options)

inline fun IndicesClient.getAliasAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetAliasesResponse>, block: GetAliasesRequest.() -> Unit = {}) =
        getAliasAsync(GetAliasesRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.putSettings(options: RequestOptions = RequestOptions.DEFAULT, block: UpdateSettingsRequest.() -> Unit = {}): AcknowledgedResponse =
        putSettings(UpdateSettingsRequest().apply(block), options)

inline fun IndicesClient.putSettingsAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: UpdateSettingsRequest.() -> Unit = {}) =
        putSettingsAsync(UpdateSettingsRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.putTemplate(options: RequestOptions = RequestOptions.DEFAULT, block: PutIndexTemplateRequest.() -> Unit = {}): AcknowledgedResponse =
        putTemplate(PutIndexTemplateRequest().apply(block), options)

inline fun IndicesClient.putTemplateAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: PutIndexTemplateRequest.() -> Unit = {}) =
        putTemplateAsync(PutIndexTemplateRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.validateQuery(options: RequestOptions = RequestOptions.DEFAULT, block: ValidateQueryRequest.() -> Unit = {}): ValidateQueryResponse =
        validateQuery(ValidateQueryRequest().apply(block), options)

inline fun IndicesClient.validateQueryAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<ValidateQueryResponse>, block: ValidateQueryRequest.() -> Unit = {}) =
        validateQueryAsync(ValidateQueryRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.getTemplate(options: RequestOptions = RequestOptions.DEFAULT, block: GetIndexTemplatesRequest.() -> Unit = {}): GetIndexTemplatesResponse? =
        getTemplate(GetIndexTemplatesRequest().apply(block), options)

inline fun IndicesClient.getTemplateAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetIndexTemplatesResponse>, block: GetIndexTemplatesRequest.() -> Unit = {}) =
        getTemplateAsync(GetIndexTemplatesRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun IndicesClient.analyze(index: String, field: String, vararg text: String, options: RequestOptions = RequestOptions.DEFAULT, block: AnalyzeRequest.() -> Unit = {}): AnalyzeResponse =
        analyze(AnalyzeRequest.withField(index, field, *text).apply(block), options)

inline fun IndicesClient.analyzeAsync(index: String, field: String, vararg text: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AnalyzeResponse>, block: AnalyzeRequest.() -> Unit = {}) =
        analyzeAsync(AnalyzeRequest.withField(index, field, *text).apply(block), options, listener)
