package dev.reimer.elasticsearch.ktx.action.search

import org.elasticsearch.action.search.MultiSearchRequest
import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.action.support.IndicesOptions

inline fun MultiSearchRequest.add(block: SearchRequest.() -> Unit = {}): MultiSearchRequest =
    add(SearchRequest().apply(block))

inline var MultiSearchRequest.indicesOptions: IndicesOptions
    get() = indicesOptions()
    set(value) {
        indicesOptions(value)
    }

inline var MultiSearchRequest.maxConcurrentSearchRequests: Int
    get() = maxConcurrentSearchRequests()
    set(value) {
        maxConcurrentSearchRequests(value)
    }

inline val MultiSearchRequest.requests: List<SearchRequest>
    get() = requests()
