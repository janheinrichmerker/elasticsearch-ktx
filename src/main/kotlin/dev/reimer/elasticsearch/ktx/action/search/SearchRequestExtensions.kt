package dev.reimer.elasticsearch.ktx.action.search

import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.action.search.SearchType
import org.elasticsearch.action.support.IndicesOptions
import org.elasticsearch.search.Scroll
import org.elasticsearch.search.builder.SearchSourceBuilder

inline var SearchRequest.allowPartialSearchResults: Boolean?
    get() = allowPartialSearchResults()
    set(value) {
        value?.let { allowPartialSearchResults(it) }
    }

inline var SearchRequest.indices: Array<String>
    get() = indices()
    set(value) {
        indices(*value)
    }

inline var SearchRequest.indicesOptions: IndicesOptions
    get() = indicesOptions()
    set(value) {
        indicesOptions(value)
    }

inline var SearchRequest.preference: String?
    get() = preference()
    set(value) {
        preference(value)
    }

inline var SearchRequest.requestCache: Boolean?
    get() = requestCache()
    set(value) {
        requestCache(value)
    }

inline var SearchRequest.routing: String?
    get() = routing()
    set(value) {
        routing(value)
    }

inline var SearchRequest.scroll: Scroll?
    get() = scroll()
    set(value) {
        scroll(value)
    }

inline var SearchRequest.searchType: SearchType
    get() = searchType()
    set(value) {
        searchType(value)
    }

inline var SearchRequest.source: SearchSourceBuilder?
    get() = source()
    set(value) {
        source(value)
    }

inline fun SearchRequest.source(block: SearchSourceBuilder.() -> Unit = {}): SearchRequest =
    source(SearchSourceBuilder().apply(block))
