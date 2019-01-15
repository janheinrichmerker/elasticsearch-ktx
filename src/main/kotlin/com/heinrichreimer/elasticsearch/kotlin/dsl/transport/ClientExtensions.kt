@file:Suppress("UNUSED")

package com.heinrichreimer.elasticsearch.kotlin.dsl.transport

import org.elasticsearch.action.ActionFuture
import org.elasticsearch.action.ActionListener
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
import org.elasticsearch.action.search.*
import org.elasticsearch.action.termvectors.MultiTermVectorsRequest
import org.elasticsearch.action.termvectors.MultiTermVectorsResponse
import org.elasticsearch.action.termvectors.TermVectorsRequest
import org.elasticsearch.action.termvectors.TermVectorsResponse
import org.elasticsearch.action.update.UpdateRequest
import org.elasticsearch.action.update.UpdateResponse
import org.elasticsearch.client.AdminClient
import org.elasticsearch.client.Client
import org.elasticsearch.common.settings.Settings

inline val Client.settings: Settings
    get() = settings()

fun Client.filterWithHeader(vararg headers: Pair<String, String>): Client {
    return filterWithHeader(mapOf(*headers))
}

inline val Client.adminClient: AdminClient get() = admin()
inline fun <R> Client.admin(block: AdminClient.() -> R) = adminClient.run(block)

inline fun Client.index(block: IndexRequest.() -> Unit = {}): ActionFuture<IndexResponse> =
        index(IndexRequest().apply(block))

inline fun Client.indexAsync(listener: ActionListener<IndexResponse>, block: IndexRequest.() -> Unit = {}) =
        index(IndexRequest().apply(block), listener)

inline fun Client.update(block: UpdateRequest.() -> Unit = {}): ActionFuture<UpdateResponse> =
        update(UpdateRequest().apply(block))

inline fun Client.updateAsync(listener: ActionListener<UpdateResponse>, block: UpdateRequest.() -> Unit = {}) =
        update(UpdateRequest().apply(block), listener)

inline fun Client.delete(block: DeleteRequest.() -> Unit = {}): ActionFuture<DeleteResponse> =
        delete(DeleteRequest().apply(block))

inline fun Client.deleteAsync(listener: ActionListener<DeleteResponse>, block: DeleteRequest.() -> Unit = {}) =
        delete(DeleteRequest().apply(block), listener)

inline fun Client.bulk(block: BulkRequest.() -> Unit = {}): ActionFuture<BulkResponse> =
        bulk(BulkRequest().apply(block))

inline fun Client.bulkAsync(listener: ActionListener<BulkResponse>, block: BulkRequest.() -> Unit = {}) =
        bulk(BulkRequest().apply(block), listener)

inline fun Client.get(block: GetRequest.() -> Unit = {}): ActionFuture<GetResponse> =
        get(GetRequest().apply(block))

inline fun Client.getAsync(listener: ActionListener<GetResponse>, block: GetRequest.() -> Unit = {}) =
        get(GetRequest().apply(block), listener)

inline fun Client.multiGet(block: MultiGetRequest.() -> Unit = {}): ActionFuture<MultiGetResponse> =
        multiGet(MultiGetRequest().apply(block))

inline fun Client.multiGetAsync(listener: ActionListener<MultiGetResponse>, block: MultiGetRequest.() -> Unit = {}) =
        multiGet(MultiGetRequest().apply(block), listener)

inline fun Client.search(block: SearchRequest.() -> Unit = {}): ActionFuture<SearchResponse> =
        search(SearchRequest().apply(block))

inline fun Client.searchAsync(listener: ActionListener<SearchResponse>, block: SearchRequest.() -> Unit = {}) =
        search(SearchRequest().apply(block), listener)

inline fun Client.searchScroll(block: SearchScrollRequest.() -> Unit = {}): ActionFuture<SearchResponse> =
        searchScroll(SearchScrollRequest().apply(block))

inline fun Client.searchScrollAsync(listener: ActionListener<SearchResponse>, block: SearchScrollRequest.() -> Unit = {}) =
        searchScroll(SearchScrollRequest().apply(block), listener)

inline fun Client.multiSearch(block: MultiSearchRequest.() -> Unit = {}): ActionFuture<MultiSearchResponse> =
        multiSearch(MultiSearchRequest().apply(block))

inline fun Client.multiSearchAsync(listener: ActionListener<MultiSearchResponse>, block: MultiSearchRequest.() -> Unit = {}) =
        multiSearch(MultiSearchRequest().apply(block), listener)

inline fun Client.termVectors(block: TermVectorsRequest.() -> Unit = {}): ActionFuture<TermVectorsResponse> =
        termVectors(TermVectorsRequest().apply(block))

inline fun Client.termVectorsAsync(listener: ActionListener<TermVectorsResponse>, block: TermVectorsRequest.() -> Unit = {}) =
        termVectors(TermVectorsRequest().apply(block), listener)

inline fun Client.multiTermVectors(block: MultiTermVectorsRequest.() -> Unit = {}): ActionFuture<MultiTermVectorsResponse> =
        multiTermVectors(MultiTermVectorsRequest().apply(block))

inline fun Client.multiTermVectorsAsync(listener: ActionListener<MultiTermVectorsResponse>, block: MultiTermVectorsRequest.() -> Unit = {}) =
        multiTermVectors(MultiTermVectorsRequest().apply(block), listener)

inline fun Client.explain(block: ExplainRequest.() -> Unit = {}): ActionFuture<ExplainResponse> =
        explain(ExplainRequest().apply(block))

inline fun Client.explainAsync(listener: ActionListener<ExplainResponse>, block: ExplainRequest.() -> Unit = {}) =
        explain(ExplainRequest().apply(block), listener)

inline fun Client.clearScroll(block: ClearScrollRequest.() -> Unit = {}): ActionFuture<ClearScrollResponse> =
        clearScroll(ClearScrollRequest().apply(block))

inline fun Client.clearScrollAsync(listener: ActionListener<ClearScrollResponse>, block: ClearScrollRequest.() -> Unit = {}) =
        clearScroll(ClearScrollRequest().apply(block), listener)

inline fun Client.fieldCaps(block: FieldCapabilitiesRequest.() -> Unit = {}): ActionFuture<FieldCapabilitiesResponse> =
        fieldCaps(FieldCapabilitiesRequest().apply(block))

inline fun Client.fieldCapsAsync(listener: ActionListener<FieldCapabilitiesResponse>, block: FieldCapabilitiesRequest.() -> Unit = {}) =
        fieldCaps(FieldCapabilitiesRequest().apply(block), listener)
