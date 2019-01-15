@file:Suppress("UNUSED")

package com.heinrichreimer.elasticsearch.kotlin.dsl.rest

import org.apache.http.HttpHost
import org.elasticsearch.action.ActionListener
import org.elasticsearch.action.admin.cluster.node.tasks.list.ListTasksResponse
import org.elasticsearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest
import org.elasticsearch.action.admin.cluster.storedscripts.GetStoredScriptRequest
import org.elasticsearch.action.admin.cluster.storedscripts.GetStoredScriptResponse
import org.elasticsearch.action.admin.cluster.storedscripts.PutStoredScriptRequest
import org.elasticsearch.action.bulk.BulkRequest
import org.elasticsearch.action.bulk.BulkResponse
import org.elasticsearch.action.delete.DeleteRequest
import org.elasticsearch.action.delete.DeleteResponse
import org.elasticsearch.action.explain.ExplainRequest
import org.elasticsearch.action.explain.ExplainResponse
import org.elasticsearch.action.fieldcaps.FieldCapabilitiesRequest
import org.elasticsearch.action.fieldcaps.FieldCapabilitiesResponse
import org.elasticsearch.action.get.GetRequest
import org.elasticsearch.action.get.GetResponse
import org.elasticsearch.action.get.MultiGetRequest
import org.elasticsearch.action.get.MultiGetResponse
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.action.index.IndexResponse
import org.elasticsearch.action.main.MainResponse
import org.elasticsearch.action.search.*
import org.elasticsearch.action.support.master.AcknowledgedResponse
import org.elasticsearch.action.update.UpdateRequest
import org.elasticsearch.action.update.UpdateResponse
import org.elasticsearch.client.*
import org.elasticsearch.index.rankeval.RankEvalRequest
import org.elasticsearch.index.rankeval.RankEvalResponse
import org.elasticsearch.index.rankeval.RankEvalSpec
import org.elasticsearch.index.reindex.BulkByScrollResponse
import org.elasticsearch.index.reindex.DeleteByQueryRequest
import org.elasticsearch.index.reindex.ReindexRequest
import org.elasticsearch.index.reindex.UpdateByQueryRequest
import org.elasticsearch.script.ScriptType
import org.elasticsearch.script.mustache.MultiSearchTemplateRequest
import org.elasticsearch.script.mustache.MultiSearchTemplateResponse
import org.elasticsearch.script.mustache.SearchTemplateRequest
import org.elasticsearch.script.mustache.SearchTemplateResponse
import org.elasticsearch.tasks.TaskId
import java.io.IOException

inline fun restHighLevelClientOf(vararg nodes: Node, block: RestClientBuilder.() -> Unit = {}) =
        RestHighLevelClient(RestClient.builder(*nodes).apply(block))

inline fun restHighLevelClientOf(vararg hosts: HttpHost, block: RestClientBuilder.() -> Unit = {}) =
        RestHighLevelClient(RestClient.builder(*hosts).apply(block))

fun RestHighLevelClient.lowLevel(): RestClient = lowLevelClient
inline val RestHighLevelClient.indicesClient: IndicesClient get() = indices()
inline val RestHighLevelClient.clusterClient: ClusterClient get() = cluster()
inline val RestHighLevelClient.ingestClient: IngestClient get() = ingest()
inline val RestHighLevelClient.snapshotClient: SnapshotClient get() = snapshot()
inline val RestHighLevelClient.tasksClient: TasksClient get() = tasks()
fun RestHighLevelClient.xPack(): XPackClient = xpack()
inline val RestHighLevelClient.xPackClient: XPackClient get() = xPack()
inline val RestHighLevelClient.watcherClient: WatcherClient get() = watcher()
inline val RestHighLevelClient.graphClient: GraphClient get() = graph()
inline val RestHighLevelClient.licenseClient: LicenseClient get() = license()
inline val RestHighLevelClient.migrationClient: MigrationClient get() = migration()
inline val RestHighLevelClient.machineLearningClient: MachineLearningClient get() = machineLearning()
inline val RestHighLevelClient.securityClient: SecurityClient get() = security()
inline val RestHighLevelClient.rollupClient: RollupClient get() = rollup()

inline fun <R> RestHighLevelClient.lowLevel(block: RestClient.() -> R) = lowLevelClient.run(block)
inline fun <R> RestHighLevelClient.indices(block: IndicesClient.() -> R) = indicesClient.run(block)
inline fun <R> RestHighLevelClient.cluster(block: ClusterClient.() -> R) = clusterClient.run(block)
inline fun <R> RestHighLevelClient.ingest(block: IngestClient.() -> R) = ingestClient.run(block)
inline fun <R> RestHighLevelClient.snapshot(block: SnapshotClient.() -> R) = snapshotClient.run(block)
inline fun <R> RestHighLevelClient.tasks(block: TasksClient.() -> R) = tasksClient.run(block)
inline fun <R> RestHighLevelClient.xPack(block: XPackClient.() -> R) = xPackClient.run(block)
inline fun <R> RestHighLevelClient.watcher(block: WatcherClient.() -> R) = watcherClient.run(block)
inline fun <R> RestHighLevelClient.graph(block: GraphClient.() -> R) = graphClient.run(block)
inline fun <R> RestHighLevelClient.license(block: LicenseClient.() -> R) = licenseClient.run(block)
inline fun <R> RestHighLevelClient.migration(block: MigrationClient.() -> R) = migrationClient.run(block)
inline fun <R> RestHighLevelClient.machineLearning(block: MachineLearningClient.() -> R) = machineLearningClient.run(block)
inline fun <R> RestHighLevelClient.security(block: SecurityClient.() -> R) = securityClient.run(block)
inline fun <R> RestHighLevelClient.rollup(block: RollupClient.() -> R) = rollupClient.run(block)

@Throws(IOException::class)
fun RestHighLevelClient.ping(): Boolean = ping(RequestOptions.DEFAULT)

@Throws(IOException::class)
fun RestHighLevelClient.info(): MainResponse = info(RequestOptions.DEFAULT)

@Throws(IOException::class)
inline fun RestHighLevelClient.bulk(options: RequestOptions = RequestOptions.DEFAULT, block: BulkRequest.() -> Unit = {}): BulkResponse =
        bulk(BulkRequest().apply(block), options)

inline fun RestHighLevelClient.bulkAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<BulkResponse>, block: BulkRequest.() -> Unit = {}) =
        bulkAsync(BulkRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.reindex(options: RequestOptions = RequestOptions.DEFAULT, block: ReindexRequest.() -> Unit = {}): BulkByScrollResponse =
        reindex(ReindexRequest().apply(block), options)

inline fun RestHighLevelClient.reindexAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<BulkByScrollResponse>, block: ReindexRequest.() -> Unit = {}) =
        reindexAsync(ReindexRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.updateByQuery(options: RequestOptions = RequestOptions.DEFAULT, block: UpdateByQueryRequest.() -> Unit = {}): BulkByScrollResponse =
        updateByQuery(UpdateByQueryRequest().apply(block), options)

inline fun RestHighLevelClient.updateByQueryAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<BulkByScrollResponse>, block: UpdateByQueryRequest.() -> Unit = {}) =
        updateByQueryAsync(UpdateByQueryRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.deleteByQuery(options: RequestOptions = RequestOptions.DEFAULT, block: DeleteByQueryRequest.() -> Unit = {}): BulkByScrollResponse =
        deleteByQuery(DeleteByQueryRequest().apply(block), options)

inline fun RestHighLevelClient.deleteByQueryAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<BulkByScrollResponse>, block: DeleteByQueryRequest.() -> Unit = {}) =
        deleteByQueryAsync(DeleteByQueryRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.deleteByQueryRethrottle(taskId: TaskId, requestsPerSecond: Float = Float.POSITIVE_INFINITY, options: RequestOptions = RequestOptions.DEFAULT, block: RethrottleRequest.() -> Unit = {}): ListTasksResponse =
        deleteByQueryRethrottle(RethrottleRequest(taskId, requestsPerSecond).apply(block), options)

inline fun RestHighLevelClient.deleteByQueryRethrottleAsync(taskId: TaskId, requestsPerSecond: Float = Float.POSITIVE_INFINITY, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<ListTasksResponse>, block: RethrottleRequest.() -> Unit = {}) =
        deleteByQueryRethrottleAsync(RethrottleRequest(taskId, requestsPerSecond).apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.updateByQueryRethrottle(taskId: TaskId, requestsPerSecond: Float = Float.POSITIVE_INFINITY, options: RequestOptions = RequestOptions.DEFAULT, block: RethrottleRequest.() -> Unit = {}): ListTasksResponse =
        updateByQueryRethrottle(RethrottleRequest(taskId, requestsPerSecond).apply(block), options)

inline fun RestHighLevelClient.updateByQueryRethrottleAsync(taskId: TaskId, requestsPerSecond: Float = Float.POSITIVE_INFINITY, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<ListTasksResponse>, block: RethrottleRequest.() -> Unit = {}) =
        updateByQueryRethrottleAsync(RethrottleRequest(taskId, requestsPerSecond).apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.reindexRethrottle(taskId: TaskId, requestsPerSecond: Float = Float.POSITIVE_INFINITY, options: RequestOptions = RequestOptions.DEFAULT, block: RethrottleRequest.() -> Unit = {}): ListTasksResponse =
        reindexRethrottle(RethrottleRequest(taskId, requestsPerSecond).apply(block), options)

inline fun RestHighLevelClient.reindexRethrottleAsync(taskId: TaskId, requestsPerSecond: Float = Float.POSITIVE_INFINITY, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<ListTasksResponse>, block: RethrottleRequest.() -> Unit = {}) =
        reindexRethrottleAsync(RethrottleRequest(taskId, requestsPerSecond).apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.get(options: RequestOptions = RequestOptions.DEFAULT, block: GetRequest.() -> Unit = {}): GetResponse =
        get(GetRequest().apply(block), options)

inline fun RestHighLevelClient.getAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetResponse>, block: GetRequest.() -> Unit = {}) =
        getAsync(GetRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.mget(options: RequestOptions = RequestOptions.DEFAULT, block: MultiGetRequest.() -> Unit = {}): MultiGetResponse =
        mget(MultiGetRequest().apply(block), options)

inline fun RestHighLevelClient.mgetAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<MultiGetResponse>, block: MultiGetRequest.() -> Unit = {}) =
        mgetAsync(MultiGetRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.exists(options: RequestOptions = RequestOptions.DEFAULT, block: GetRequest.() -> Unit = {}): Boolean =
        exists(GetRequest().apply(block), options)

inline fun RestHighLevelClient.existsAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<Boolean>, block: GetRequest.() -> Unit = {}) =
        existsAsync(GetRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.index(options: RequestOptions = RequestOptions.DEFAULT, block: IndexRequest.() -> Unit = {}): IndexResponse =
        index(IndexRequest().apply(block), options)

inline fun RestHighLevelClient.indexAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<IndexResponse>, block: IndexRequest.() -> Unit = {}) =
        indexAsync(IndexRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.update(options: RequestOptions = RequestOptions.DEFAULT, block: UpdateRequest.() -> Unit = {}): UpdateResponse =
        update(UpdateRequest().apply(block), options)

inline fun RestHighLevelClient.updateAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<UpdateResponse>, block: UpdateRequest.() -> Unit = {}) =
        updateAsync(UpdateRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.delete(options: RequestOptions = RequestOptions.DEFAULT, block: DeleteRequest.() -> Unit = {}): DeleteResponse =
        delete(DeleteRequest().apply(block), options)

inline fun RestHighLevelClient.deleteAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<DeleteResponse>, block: DeleteRequest.() -> Unit = {}) =
        deleteAsync(DeleteRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.search(options: RequestOptions = RequestOptions.DEFAULT, block: SearchRequest.() -> Unit = {}): SearchResponse =
        search(SearchRequest().apply(block), options)

inline fun RestHighLevelClient.searchAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<SearchResponse>, block: SearchRequest.() -> Unit = {}) =
        searchAsync(SearchRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.msearch(options: RequestOptions = RequestOptions.DEFAULT, block: MultiSearchRequest.() -> Unit = {}): MultiSearchResponse =
        msearch(MultiSearchRequest().apply(block), options)

inline fun RestHighLevelClient.msearchAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<MultiSearchResponse>, block: MultiSearchRequest.() -> Unit = {}) =
        msearchAsync(MultiSearchRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.scroll(options: RequestOptions = RequestOptions.DEFAULT, block: SearchScrollRequest.() -> Unit = {}): SearchResponse =
        scroll(SearchScrollRequest().apply(block), options)

inline fun RestHighLevelClient.scrollAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<SearchResponse>, block: SearchScrollRequest.() -> Unit = {}) =
        scrollAsync(SearchScrollRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.clearScroll(options: RequestOptions = RequestOptions.DEFAULT, block: ClearScrollRequest.() -> Unit = {}): ClearScrollResponse =
        clearScroll(ClearScrollRequest().apply(block), options)

inline fun RestHighLevelClient.clearScrollAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<ClearScrollResponse>, block: ClearScrollRequest.() -> Unit = {}) =
        clearScrollAsync(ClearScrollRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.searchTemplate(script: String, scriptType: ScriptType, options: RequestOptions = RequestOptions.DEFAULT, block: SearchTemplateRequest.() -> Unit = {}): SearchTemplateResponse =
        searchTemplate(SearchTemplateRequest().apply { setScript(script); setScriptType(scriptType) }.apply(block), options)

inline fun RestHighLevelClient.searchTemplateAsync(script: String, scriptType: ScriptType, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<SearchTemplateResponse>, block: SearchTemplateRequest.() -> Unit = {}) =
        searchTemplateAsync(SearchTemplateRequest().apply { setScript(script); setScriptType(scriptType) }.apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.explain(options: RequestOptions = RequestOptions.DEFAULT, block: ExplainRequest.() -> Unit = {}): ExplainResponse =
        explain(ExplainRequest().apply(block), options)

inline fun RestHighLevelClient.explainAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<ExplainResponse>, block: ExplainRequest.() -> Unit = {}) =
        explainAsync(ExplainRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.rankEval(rankingEvaluationSpec: RankEvalSpec, indices: Array<String>, options: RequestOptions = RequestOptions.DEFAULT, block: RankEvalRequest.() -> Unit = {}): RankEvalResponse =
        rankEval(RankEvalRequest(rankingEvaluationSpec, indices).apply(block), options)

inline fun RestHighLevelClient.rankEvalAsync(rankingEvaluationSpec: RankEvalSpec, indices: Array<String>, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<RankEvalResponse>, block: RankEvalRequest.() -> Unit = {}) =
        rankEvalAsync(RankEvalRequest(rankingEvaluationSpec, indices).apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.msearchTemplate(options: RequestOptions = RequestOptions.DEFAULT, block: MultiSearchTemplateRequest.() -> Unit = {}): MultiSearchTemplateResponse =
        msearchTemplate(MultiSearchTemplateRequest().apply(block), options)

inline fun RestHighLevelClient.msearchTemplateAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<MultiSearchTemplateResponse>, block: MultiSearchTemplateRequest.() -> Unit = {}) =
        msearchTemplateAsync(MultiSearchTemplateRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.fieldCaps(options: RequestOptions = RequestOptions.DEFAULT, block: FieldCapabilitiesRequest.() -> Unit = {}): FieldCapabilitiesResponse =
        fieldCaps(FieldCapabilitiesRequest().apply(block), options)

inline fun RestHighLevelClient.fieldCapsAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<FieldCapabilitiesResponse>, block: FieldCapabilitiesRequest.() -> Unit = {}) =
        fieldCapsAsync(FieldCapabilitiesRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.getScript(id: String, options: RequestOptions = RequestOptions.DEFAULT, block: GetStoredScriptRequest.() -> Unit = {}): GetStoredScriptResponse =
        getScript(GetStoredScriptRequest(id).apply(block), options)

inline fun RestHighLevelClient.getScriptAsync(id: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetStoredScriptResponse>, block: GetStoredScriptRequest.() -> Unit = {}) =
        getScriptAsync(GetStoredScriptRequest(id).apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.deleteScript(id: String, options: RequestOptions = RequestOptions.DEFAULT, block: DeleteStoredScriptRequest.() -> Unit = {}): AcknowledgedResponse =
        deleteScript(DeleteStoredScriptRequest(id).apply(block), options)

inline fun RestHighLevelClient.deleteScriptAsync(id: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: DeleteStoredScriptRequest.() -> Unit = {}) =
        deleteScriptAsync(DeleteStoredScriptRequest(id).apply(block), options, listener)

@Throws(IOException::class)
inline fun RestHighLevelClient.putScript(options: RequestOptions = RequestOptions.DEFAULT, block: PutStoredScriptRequest.() -> Unit = {}): AcknowledgedResponse =
        putScript(PutStoredScriptRequest().apply(block), options)

inline fun RestHighLevelClient.putScriptAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: PutStoredScriptRequest.() -> Unit = {}) =
        putScriptAsync(PutStoredScriptRequest().apply(block), options, listener)
