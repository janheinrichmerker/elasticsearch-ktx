package dev.reimer.elasticsearch.ktx.action.search

import org.apache.lucene.search.TotalHits
import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.search.SearchHits

inline val SearchResponse.totalHits: TotalHits? get() = hits.totalHits

fun SearchHits.isEmpty() = hits.isEmpty()

fun SearchResponse.isEmpty() = hits.isEmpty()
