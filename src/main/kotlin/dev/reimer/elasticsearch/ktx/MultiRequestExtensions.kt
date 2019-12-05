@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx

import org.elasticsearch.action.bulk.BulkRequest
import org.elasticsearch.action.delete.DeleteRequest
import org.elasticsearch.action.get.MultiGetRequest
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.action.search.MultiSearchRequest
import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.action.termvectors.MultiTermVectorsRequest
import org.elasticsearch.action.termvectors.TermVectorsRequest
import org.elasticsearch.action.update.UpdateRequest
import org.elasticsearch.script.mustache.MultiSearchTemplateRequest
import org.elasticsearch.script.mustache.SearchTemplateRequest

operator fun MultiGetRequest.plusAssign(item: MultiGetRequest.Item) {
    add(item)
}

inline fun MultiGetRequest.get(block: MultiGetRequest.Item.() -> Unit = {}): MultiGetRequest =
        add(MultiGetRequest.Item().apply(block))

operator fun MultiTermVectorsRequest.plusAssign(request: TermVectorsRequest) {
    add(request)
}

inline fun MultiTermVectorsRequest.termVectors(block: TermVectorsRequest.() -> Unit = {}): MultiTermVectorsRequest =
        add(TermVectorsRequest().apply(block))

operator fun MultiSearchRequest.plusAssign(request: SearchRequest) {
    add(request)
}

inline fun MultiSearchRequest.search(block: SearchRequest.() -> Unit = {}): MultiSearchRequest =
        add(SearchRequest().apply(block))

operator fun MultiSearchTemplateRequest.plusAssign(request: SearchTemplateRequest) {
    add(request)
}

inline fun MultiSearchTemplateRequest.searchTemplate(block: SearchTemplateRequest.() -> Unit = {}): MultiSearchTemplateRequest =
        add(SearchTemplateRequest().apply(block))

operator fun BulkRequest.plusAssign(request: IndexRequest) {
    add(request)
}

fun BulkRequest.index(request: IndexRequest): BulkRequest = add(request)
inline fun BulkRequest.index(block: IndexRequest.() -> Unit = {}): BulkRequest =
        add(IndexRequest().apply(block))

operator fun BulkRequest.plusAssign(request: UpdateRequest) {
    add(request)
}

fun BulkRequest.update(request: UpdateRequest): BulkRequest = add(request)
inline fun BulkRequest.update(block: UpdateRequest.() -> Unit = {}): BulkRequest =
        add(UpdateRequest().apply(block))

operator fun BulkRequest.plusAssign(request: DeleteRequest) {
    add(request)
}

fun BulkRequest.delete(request: DeleteRequest): BulkRequest = add(request)
inline fun BulkRequest.delete(block: DeleteRequest.() -> Unit = {}): BulkRequest =
        add(DeleteRequest().apply(block))
