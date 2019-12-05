@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.client

import org.elasticsearch.action.ActionFuture
import org.elasticsearch.action.ActionListener
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest
import org.elasticsearch.action.admin.indices.alias.exists.AliasesExistResponse
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesResponse
import org.elasticsearch.action.admin.indices.analyze.AnalyzeAction
import org.elasticsearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest
import org.elasticsearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse
import org.elasticsearch.action.admin.indices.close.CloseIndexRequest
import org.elasticsearch.action.admin.indices.close.CloseIndexResponse
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsRequest
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsResponse
import org.elasticsearch.action.admin.indices.flush.FlushRequest
import org.elasticsearch.action.admin.indices.flush.FlushResponse
import org.elasticsearch.action.admin.indices.flush.SyncedFlushRequest
import org.elasticsearch.action.admin.indices.flush.SyncedFlushResponse
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
import org.elasticsearch.action.admin.indices.recovery.RecoveryRequest
import org.elasticsearch.action.admin.indices.recovery.RecoveryResponse
import org.elasticsearch.action.admin.indices.refresh.RefreshRequest
import org.elasticsearch.action.admin.indices.refresh.RefreshResponse
import org.elasticsearch.action.admin.indices.rollover.RolloverRequest
import org.elasticsearch.action.admin.indices.rollover.RolloverResponse
import org.elasticsearch.action.admin.indices.segments.IndicesSegmentResponse
import org.elasticsearch.action.admin.indices.segments.IndicesSegmentsRequest
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsRequest
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsResponse
import org.elasticsearch.action.admin.indices.settings.put.UpdateSettingsRequest
import org.elasticsearch.action.admin.indices.shards.IndicesShardStoresRequest
import org.elasticsearch.action.admin.indices.shards.IndicesShardStoresResponse
import org.elasticsearch.action.admin.indices.shrink.ResizeRequest
import org.elasticsearch.action.admin.indices.shrink.ResizeResponse
import org.elasticsearch.action.admin.indices.stats.IndicesStatsRequest
import org.elasticsearch.action.admin.indices.stats.IndicesStatsResponse
import org.elasticsearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest
import org.elasticsearch.action.admin.indices.template.get.GetIndexTemplatesRequest
import org.elasticsearch.action.admin.indices.template.get.GetIndexTemplatesResponse
import org.elasticsearch.action.admin.indices.template.put.PutIndexTemplateRequest
import org.elasticsearch.action.admin.indices.upgrade.get.UpgradeStatusRequest
import org.elasticsearch.action.admin.indices.upgrade.get.UpgradeStatusResponse
import org.elasticsearch.action.admin.indices.upgrade.post.UpgradeRequest
import org.elasticsearch.action.admin.indices.upgrade.post.UpgradeResponse
import org.elasticsearch.action.admin.indices.validate.query.ValidateQueryRequest
import org.elasticsearch.action.admin.indices.validate.query.ValidateQueryResponse
import org.elasticsearch.action.support.master.AcknowledgedResponse
import org.elasticsearch.client.IndicesAdminClient

inline fun IndicesAdminClient.exists(block: IndicesExistsRequest.() -> Unit = {}): ActionFuture<IndicesExistsResponse> =
        exists(IndicesExistsRequest().apply(block))

inline fun IndicesAdminClient.existsAsync(listener: ActionListener<IndicesExistsResponse>, block: IndicesExistsRequest.() -> Unit = {}) =
        exists(IndicesExistsRequest().apply(block), listener)

inline fun IndicesAdminClient.typesExists(block: TypesExistsRequest.() -> Unit = {}): ActionFuture<TypesExistsResponse> =
        typesExists(TypesExistsRequest().apply(block))

inline fun IndicesAdminClient.typesExistsAsync(listener: ActionListener<TypesExistsResponse>, block: TypesExistsRequest.() -> Unit = {}) =
        typesExists(TypesExistsRequest().apply(block), listener)

inline fun IndicesAdminClient.stats(block: IndicesStatsRequest.() -> Unit = {}): ActionFuture<IndicesStatsResponse> =
        stats(IndicesStatsRequest().apply(block))

inline fun IndicesAdminClient.statsAsync(listener: ActionListener<IndicesStatsResponse>, block: IndicesStatsRequest.() -> Unit = {}) =
        stats(IndicesStatsRequest().apply(block), listener)

inline fun IndicesAdminClient.recoveries(block: RecoveryRequest.() -> Unit = {}): ActionFuture<RecoveryResponse> =
        recoveries(RecoveryRequest().apply(block))

inline fun IndicesAdminClient.recoveriesAsync(listener: ActionListener<RecoveryResponse>, block: RecoveryRequest.() -> Unit = {}) =
        recoveries(RecoveryRequest().apply(block), listener)

inline fun IndicesAdminClient.segments(block: IndicesSegmentsRequest.() -> Unit = {}): ActionFuture<IndicesSegmentResponse> =
        segments(IndicesSegmentsRequest().apply(block))

inline fun IndicesAdminClient.segmentsAsync(listener: ActionListener<IndicesSegmentResponse>, block: IndicesSegmentsRequest.() -> Unit = {}) =
        segments(IndicesSegmentsRequest().apply(block), listener)

inline fun IndicesAdminClient.shardStores(block: IndicesShardStoresRequest.() -> Unit = {}): ActionFuture<IndicesShardStoresResponse> =
        shardStores(IndicesShardStoresRequest().apply(block))

inline fun IndicesAdminClient.shardStoresAsync(listener: ActionListener<IndicesShardStoresResponse>, block: IndicesShardStoresRequest.() -> Unit = {}) =
        shardStores(IndicesShardStoresRequest().apply(block), listener)

inline fun IndicesAdminClient.create(block: CreateIndexRequest.() -> Unit = {}): ActionFuture<CreateIndexResponse> =
        create(CreateIndexRequest().apply(block))

inline fun IndicesAdminClient.createAsync(listener: ActionListener<CreateIndexResponse>, block: CreateIndexRequest.() -> Unit = {}) =
        create(CreateIndexRequest().apply(block), listener)

inline fun IndicesAdminClient.delete(block: DeleteIndexRequest.() -> Unit = {}): ActionFuture<AcknowledgedResponse> =
        delete(DeleteIndexRequest().apply(block))

inline fun IndicesAdminClient.deleteAsync(listener: ActionListener<AcknowledgedResponse>, block: DeleteIndexRequest.() -> Unit = {}) =
        delete(DeleteIndexRequest().apply(block), listener)

inline fun IndicesAdminClient.close(block: CloseIndexRequest.() -> Unit = {}): ActionFuture<CloseIndexResponse> =
        close(CloseIndexRequest().apply(block))

inline fun IndicesAdminClient.closeAsync(
        listener: ActionListener<CloseIndexResponse>,
        block: CloseIndexRequest.() -> Unit = {}
) =
        close(CloseIndexRequest().apply(block), listener)

inline fun IndicesAdminClient.open(block: OpenIndexRequest.() -> Unit = {}): ActionFuture<OpenIndexResponse> =
        open(OpenIndexRequest().apply(block))

inline fun IndicesAdminClient.openAsync(listener: ActionListener<OpenIndexResponse>, block: OpenIndexRequest.() -> Unit = {}) =
        open(OpenIndexRequest().apply(block), listener)

inline fun IndicesAdminClient.refresh(block: RefreshRequest.() -> Unit = {}): ActionFuture<RefreshResponse> =
        refresh(RefreshRequest().apply(block))

inline fun IndicesAdminClient.refreshAsync(listener: ActionListener<RefreshResponse>, block: RefreshRequest.() -> Unit = {}) =
        refresh(RefreshRequest().apply(block), listener)

inline fun IndicesAdminClient.flush(block: FlushRequest.() -> Unit = {}): ActionFuture<FlushResponse> =
        flush(FlushRequest().apply(block))

inline fun IndicesAdminClient.flushAsync(listener: ActionListener<FlushResponse>, block: FlushRequest.() -> Unit = {}) =
        flush(FlushRequest().apply(block), listener)

inline fun IndicesAdminClient.syncedFlush(block: SyncedFlushRequest.() -> Unit = {}): ActionFuture<SyncedFlushResponse> =
        syncedFlush(SyncedFlushRequest().apply(block))

inline fun IndicesAdminClient.syncedFlushAsync(listener: ActionListener<SyncedFlushResponse>, block: SyncedFlushRequest.() -> Unit = {}) =
        syncedFlush(SyncedFlushRequest().apply(block), listener)

inline fun IndicesAdminClient.forceMerge(block: ForceMergeRequest.() -> Unit = {}): ActionFuture<ForceMergeResponse> =
        forceMerge(ForceMergeRequest().apply(block))

inline fun IndicesAdminClient.forceMergeAsync(listener: ActionListener<ForceMergeResponse>, block: ForceMergeRequest.() -> Unit = {}) =
        forceMerge(ForceMergeRequest().apply(block), listener)

inline fun IndicesAdminClient.upgrade(block: UpgradeRequest.() -> Unit = {}): ActionFuture<UpgradeResponse> =
        upgrade(UpgradeRequest().apply(block))

inline fun IndicesAdminClient.upgradeAsync(listener: ActionListener<UpgradeResponse>, block: UpgradeRequest.() -> Unit = {}) =
        upgrade(UpgradeRequest().apply(block), listener)

inline fun IndicesAdminClient.upgradeStatus(block: UpgradeStatusRequest.() -> Unit = {}): ActionFuture<UpgradeStatusResponse> =
        upgradeStatus(UpgradeStatusRequest().apply(block))

inline fun IndicesAdminClient.upgradeStatusAsync(listener: ActionListener<UpgradeStatusResponse>, block: UpgradeStatusRequest.() -> Unit = {}) =
        upgradeStatus(UpgradeStatusRequest().apply(block), listener)

inline fun IndicesAdminClient.getMappings(block: GetMappingsRequest.() -> Unit = {}): ActionFuture<GetMappingsResponse> =
        getMappings(GetMappingsRequest().apply(block))

inline fun IndicesAdminClient.getMappingsAsync(listener: ActionListener<GetMappingsResponse>, block: GetMappingsRequest.() -> Unit = {}) =
        getMappings(GetMappingsRequest().apply(block), listener)

inline fun IndicesAdminClient.getFieldMappings(block: GetFieldMappingsRequest.() -> Unit = {}): ActionFuture<GetFieldMappingsResponse> =
        getFieldMappings(GetFieldMappingsRequest().apply(block))

inline fun IndicesAdminClient.getFieldMappingsAsync(listener: ActionListener<GetFieldMappingsResponse>, block: GetFieldMappingsRequest.() -> Unit = {}) =
        getFieldMappings(GetFieldMappingsRequest().apply(block), listener)

inline fun IndicesAdminClient.putMapping(block: PutMappingRequest.() -> Unit = {}): ActionFuture<AcknowledgedResponse> =
        putMapping(PutMappingRequest().apply(block))

inline fun IndicesAdminClient.putMappingAsync(listener: ActionListener<AcknowledgedResponse>, block: PutMappingRequest.() -> Unit = {}) =
        putMapping(PutMappingRequest().apply(block), listener)

inline fun IndicesAdminClient.aliases(block: IndicesAliasesRequest.() -> Unit = {}): ActionFuture<AcknowledgedResponse> =
        aliases(IndicesAliasesRequest().apply(block))

inline fun IndicesAdminClient.aliasesAsync(listener: ActionListener<AcknowledgedResponse>, block: IndicesAliasesRequest.() -> Unit = {}) =
        aliases(IndicesAliasesRequest().apply(block), listener)

inline fun IndicesAdminClient.getAliases(block: GetAliasesRequest.() -> Unit = {}): ActionFuture<GetAliasesResponse> =
        getAliases(GetAliasesRequest().apply(block))

inline fun IndicesAdminClient.getAliasesAsync(listener: ActionListener<GetAliasesResponse>, block: GetAliasesRequest.() -> Unit = {}) =
        getAliases(GetAliasesRequest().apply(block), listener)

inline fun IndicesAdminClient.aliasesExist(block: GetAliasesRequest.() -> Unit = {}): ActionFuture<AliasesExistResponse> =
        aliasesExist(GetAliasesRequest().apply(block))

inline fun IndicesAdminClient.aliasesExistAsync(listener: ActionListener<AliasesExistResponse>, block: GetAliasesRequest.() -> Unit = {}) =
        aliasesExist(GetAliasesRequest().apply(block), listener)

inline fun IndicesAdminClient.getIndex(block: GetIndexRequest.() -> Unit = {}): ActionFuture<GetIndexResponse> =
        getIndex(GetIndexRequest().apply(block))

inline fun IndicesAdminClient.getIndexAsync(listener: ActionListener<GetIndexResponse>, block: GetIndexRequest.() -> Unit = {}) =
        getIndex(GetIndexRequest().apply(block), listener)

inline fun IndicesAdminClient.clearCache(block: ClearIndicesCacheRequest.() -> Unit = {}): ActionFuture<ClearIndicesCacheResponse> =
        clearCache(ClearIndicesCacheRequest().apply(block))

inline fun IndicesAdminClient.clearCacheAsync(listener: ActionListener<ClearIndicesCacheResponse>, block: ClearIndicesCacheRequest.() -> Unit = {}) =
        clearCache(ClearIndicesCacheRequest().apply(block), listener)

inline fun IndicesAdminClient.updateSettings(block: UpdateSettingsRequest.() -> Unit = {}): ActionFuture<AcknowledgedResponse> =
        updateSettings(UpdateSettingsRequest().apply(block))

inline fun IndicesAdminClient.updateSettingsAsync(listener: ActionListener<AcknowledgedResponse>, block: UpdateSettingsRequest.() -> Unit = {}) =
        updateSettings(UpdateSettingsRequest().apply(block), listener)

inline fun IndicesAdminClient.analyze(block: AnalyzeAction.Request.() -> Unit = {}): ActionFuture<AnalyzeAction.Response> =
        analyze(AnalyzeAction.Request().apply(block))

inline fun IndicesAdminClient.analyzeAsync(
        listener: ActionListener<AnalyzeAction.Response>,
        block: AnalyzeAction.Request.() -> Unit = {}
) =
        analyze(AnalyzeAction.Request().apply(block), listener)

inline fun IndicesAdminClient.putTemplate(block: PutIndexTemplateRequest.() -> Unit = {}): ActionFuture<AcknowledgedResponse> =
        putTemplate(PutIndexTemplateRequest().apply(block))

inline fun IndicesAdminClient.putTemplateAsync(listener: ActionListener<AcknowledgedResponse>, block: PutIndexTemplateRequest.() -> Unit = {}) =
        putTemplate(PutIndexTemplateRequest().apply(block), listener)

inline fun IndicesAdminClient.deleteTemplate(block: DeleteIndexTemplateRequest.() -> Unit = {}): ActionFuture<AcknowledgedResponse> =
        deleteTemplate(DeleteIndexTemplateRequest().apply(block))

inline fun IndicesAdminClient.deleteTemplateAsync(listener: ActionListener<AcknowledgedResponse>, block: DeleteIndexTemplateRequest.() -> Unit = {}) =
        deleteTemplate(DeleteIndexTemplateRequest().apply(block), listener)

inline fun IndicesAdminClient.getTemplates(block: GetIndexTemplatesRequest.() -> Unit = {}): ActionFuture<GetIndexTemplatesResponse> =
        getTemplates(GetIndexTemplatesRequest().apply(block))

inline fun IndicesAdminClient.getTemplatesAsync(listener: ActionListener<GetIndexTemplatesResponse>, block: GetIndexTemplatesRequest.() -> Unit = {}) =
        getTemplates(GetIndexTemplatesRequest().apply(block), listener)

inline fun IndicesAdminClient.validateQuery(block: ValidateQueryRequest.() -> Unit = {}): ActionFuture<ValidateQueryResponse> =
        validateQuery(ValidateQueryRequest().apply(block))

inline fun IndicesAdminClient.validateQueryAsync(listener: ActionListener<ValidateQueryResponse>, block: ValidateQueryRequest.() -> Unit = {}) =
        validateQuery(ValidateQueryRequest().apply(block), listener)

inline fun IndicesAdminClient.getSettings(block: GetSettingsRequest.() -> Unit = {}): ActionFuture<GetSettingsResponse> =
        getSettings(GetSettingsRequest().apply(block))

inline fun IndicesAdminClient.getSettingsAsync(listener: ActionListener<GetSettingsResponse>, block: GetSettingsRequest.() -> Unit = {}) =
        getSettings(GetSettingsRequest().apply(block), listener)

inline fun IndicesAdminClient.resizeIndex(targetIndex: String, sourceIndex: String, block: ResizeRequest.() -> Unit = {}): ActionFuture<ResizeResponse> =
        resizeIndex(ResizeRequest(targetIndex, sourceIndex).apply(block))

inline fun IndicesAdminClient.resizeIndexAsync(targetIndex: String, sourceIndex: String, listener: ActionListener<ResizeResponse>, block: ResizeRequest.() -> Unit = {}) =
        resizeIndex(ResizeRequest(targetIndex, sourceIndex).apply(block), listener)

fun IndicesAdminClient.rolloverIndex(request: RolloverRequest): ActionFuture<RolloverResponse> = 
        rolloversIndex(request) // Fixing typo in IndicesAdminClient.

inline fun IndicesAdminClient.rolloverIndex(alias: String, newIndexName: String, block: RolloverRequest.() -> Unit = {}): ActionFuture<RolloverResponse> =
        rolloverIndex(RolloverRequest(alias, newIndexName).apply(block))

inline fun IndicesAdminClient.rolloverIndexAsync(alias: String, newIndexName: String, listener: ActionListener<RolloverResponse>, block: RolloverRequest.() -> Unit = {}) =
        rolloverIndex(RolloverRequest(alias, newIndexName).apply(block), listener)
