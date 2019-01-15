@file:Suppress("UNUSED")

package com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.transport

import com.heinrichreimer.elasticsearch.kotlin.dsl.transport.*
import com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.awaitAction
import de.unihalle.informatik.bigdata.knjigica.indexer.util.elasticsearch.transport.*
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest
import org.elasticsearch.action.admin.indices.alias.exists.AliasesExistResponse
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesResponse
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequest
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse
import org.elasticsearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest
import org.elasticsearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse
import org.elasticsearch.action.admin.indices.close.CloseIndexRequest
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

suspend inline fun IndicesAdminClient.existsAsync(block: IndicesExistsRequest.() -> Unit = {}): IndicesExistsResponse =
        awaitAction { existsAsync(it, block) }

suspend inline fun IndicesAdminClient.typesExistsAsync(block: TypesExistsRequest.() -> Unit = {}): TypesExistsResponse =
        awaitAction { typesExistsAsync(it, block) }

suspend inline fun IndicesAdminClient.statsAsync(block: IndicesStatsRequest.() -> Unit = {}): IndicesStatsResponse =
        awaitAction { statsAsync(it, block) }

suspend inline fun IndicesAdminClient.recoveriesAsync(block: RecoveryRequest.() -> Unit = {}): RecoveryResponse =
        awaitAction { recoveriesAsync(it, block) }

suspend inline fun IndicesAdminClient.segmentsAsync(block: IndicesSegmentsRequest.() -> Unit = {}): IndicesSegmentResponse =
        awaitAction { segmentsAsync(it, block) }

suspend inline fun IndicesAdminClient.shardStoresAsync(block: IndicesShardStoresRequest.() -> Unit = {}): IndicesShardStoresResponse =
        awaitAction { shardStoresAsync(it, block) }

suspend inline fun IndicesAdminClient.createAsync(block: CreateIndexRequest.() -> Unit = {}): CreateIndexResponse =
        awaitAction { createAsync(it, block) }

suspend inline fun IndicesAdminClient.deleteAsync(block: DeleteIndexRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { deleteAsync(it, block) }

suspend inline fun IndicesAdminClient.closeAsync(block: CloseIndexRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { closeAsync(it, block) }

suspend inline fun IndicesAdminClient.openAsync(block: OpenIndexRequest.() -> Unit = {}): OpenIndexResponse =
        awaitAction { openAsync(it, block) }

suspend inline fun IndicesAdminClient.refreshAsync(block: RefreshRequest.() -> Unit = {}): RefreshResponse =
        awaitAction { refreshAsync(it, block) }

suspend inline fun IndicesAdminClient.flushAsync(block: FlushRequest.() -> Unit = {}): FlushResponse =
        awaitAction { flushAsync(it, block) }

suspend inline fun IndicesAdminClient.syncedFlushAsync(block: SyncedFlushRequest.() -> Unit = {}): SyncedFlushResponse =
        awaitAction { syncedFlushAsync(it, block) }

suspend inline fun IndicesAdminClient.forceMergeAsync(block: ForceMergeRequest.() -> Unit = {}): ForceMergeResponse =
        awaitAction { forceMergeAsync(it, block) }

suspend inline fun IndicesAdminClient.upgradeAsync(block: UpgradeRequest.() -> Unit = {}): UpgradeResponse =
        awaitAction { upgradeAsync(it, block) }

suspend inline fun IndicesAdminClient.upgradeStatusAsync(block: UpgradeStatusRequest.() -> Unit = {}): UpgradeStatusResponse =
        awaitAction { upgradeStatusAsync(it, block) }

suspend inline fun IndicesAdminClient.getMappingsAsync(block: GetMappingsRequest.() -> Unit = {}): GetMappingsResponse =
        awaitAction { getMappingsAsync(it, block) }

suspend inline fun IndicesAdminClient.getFieldMappingsAsync(block: GetFieldMappingsRequest.() -> Unit = {}): GetFieldMappingsResponse =
        awaitAction { getFieldMappingsAsync(it, block) }

suspend inline fun IndicesAdminClient.putMappingAsync(block: PutMappingRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { putMappingAsync(it, block) }

suspend inline fun IndicesAdminClient.aliasesAsync(block: IndicesAliasesRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { aliasesAsync(it, block) }

suspend inline fun IndicesAdminClient.getAliasesAsync(block: GetAliasesRequest.() -> Unit = {}): GetAliasesResponse =
        awaitAction { getAliasesAsync(it, block) }

suspend inline fun IndicesAdminClient.aliasesExistAsync(block: GetAliasesRequest.() -> Unit = {}): AliasesExistResponse =
        awaitAction { aliasesExistAsync(it, block) }

suspend inline fun IndicesAdminClient.getIndexAsync(block: GetIndexRequest.() -> Unit = {}): GetIndexResponse =
        awaitAction { getIndexAsync(it, block) }

suspend inline fun IndicesAdminClient.clearCacheAsync(block: ClearIndicesCacheRequest.() -> Unit = {}): ClearIndicesCacheResponse =
        awaitAction { clearCacheAsync(it, block) }

suspend inline fun IndicesAdminClient.updateSettingsAsync(block: UpdateSettingsRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { updateSettingsAsync(it, block) }

suspend inline fun IndicesAdminClient.analyzeAsync(block: AnalyzeRequest.() -> Unit = {}): AnalyzeResponse =
        awaitAction { analyzeAsync(it, block) }

suspend inline fun IndicesAdminClient.putTemplateAsync(block: PutIndexTemplateRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { putTemplateAsync(it, block) }

suspend inline fun IndicesAdminClient.deleteTemplateAsync(block: DeleteIndexTemplateRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { deleteTemplateAsync(it, block) }

suspend inline fun IndicesAdminClient.getTemplatesAsync(block: GetIndexTemplatesRequest.() -> Unit = {}): GetIndexTemplatesResponse =
        awaitAction { getTemplatesAsync(it, block) }

suspend inline fun IndicesAdminClient.validateQueryAsync(block: ValidateQueryRequest.() -> Unit = {}): ValidateQueryResponse =
        awaitAction { validateQueryAsync(it, block) }

suspend inline fun IndicesAdminClient.getSettingsAsync(block: GetSettingsRequest.() -> Unit = {}): GetSettingsResponse =
        awaitAction { getSettingsAsync(it, block) }

suspend inline fun IndicesAdminClient.resizeIndexAsync(targetIndex: String, sourceIndex: String, block: ResizeRequest.() -> Unit = {}): ResizeResponse =
        awaitAction { resizeIndexAsync(targetIndex, sourceIndex, it, block) }

suspend inline fun IndicesAdminClient.rolloverIndexAsync(alias: String, newIndexName: String, block: RolloverRequest.() -> Unit = {}): RolloverResponse =
        awaitAction { rolloverIndexAsync(alias, newIndexName, it, block) }
