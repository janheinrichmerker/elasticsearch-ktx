package dev.reimer.elasticsearch.ktx.action.search.builder

import org.elasticsearch.common.unit.TimeValue
import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.search.SearchExtBuilder
import org.elasticsearch.search.aggregations.AggregatorFactories
import org.elasticsearch.search.builder.SearchSourceBuilder
import org.elasticsearch.search.collapse.CollapseBuilder
import org.elasticsearch.search.fetch.StoredFieldsContext
import org.elasticsearch.search.fetch.subphase.DocValueFieldsContext
import org.elasticsearch.search.fetch.subphase.FetchSourceContext
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder
import org.elasticsearch.search.internal.SearchContext
import org.elasticsearch.search.rescore.RescorerBuilder
import org.elasticsearch.search.slice.SliceBuilder
import org.elasticsearch.search.sort.SortBuilder
import org.elasticsearch.search.suggest.SuggestBuilder

inline val SearchSourceBuilder.aggregations: AggregatorFactories.Builder?
    get() = aggregations()

inline var SearchSourceBuilder.collapse: CollapseBuilder?
    get() = collapse()
    set(value) {
        collapse(value)
    }

inline fun SearchSourceBuilder.collapse(field: String, block: CollapseBuilder.() -> Unit): SearchSourceBuilder =
    collapse(CollapseBuilder(field).apply(block))

inline fun SearchSourceBuilder.copyWithNewSlice(id: Int, max: Int, block: SliceBuilder.() -> Unit): SearchSourceBuilder =
    copyWithNewSlice(SliceBuilder(id, max).apply(block))

inline val SearchSourceBuilder.docValueFields: List<DocValueFieldsContext.FieldAndFormat>?
    get() = docValueFields()

inline var SearchSourceBuilder.explain: Boolean?
    get() = explain()
    set(value) {
        explain(value)
    }

inline var SearchSourceBuilder.ext: List<SearchExtBuilder>
    get() = ext()
    set(value) {
        ext(value)
    }

inline var SearchSourceBuilder.fetchSource: FetchSourceContext
    get() = fetchSource()
    set(value) {
        fetchSource(value)
    }

inline var SearchSourceBuilder.from: Int
    get() = from()
    set(value) {
        from(value)
    }

inline var SearchSourceBuilder.highlighter: HighlightBuilder
    get() = highlighter()
    set(value) {
        highlighter(value)
    }

inline fun SearchSourceBuilder.highlighter(block: HighlightBuilder.() -> Unit): SearchSourceBuilder =
    highlighter(HighlightBuilder().apply(block))

inline val SearchSourceBuilder.indexBoosts: List<SearchSourceBuilder.IndexBoost>
    get() = indexBoosts()

inline var SearchSourceBuilder.minScore: Float
    get() = minScore()
    set(value) {
        minScore(value)
    }

inline var SearchSourceBuilder.postFilter: QueryBuilder
    get() = postFilter()
    set(value) {
        postFilter(value)
    }

inline var SearchSourceBuilder.profile: Boolean
    get() = profile()
    set(value) {
        profile(value)
    }

inline var SearchSourceBuilder.query: QueryBuilder?
    get() = query()
    set(value) {
        query(value)
    }

inline val SearchSourceBuilder.rescores: List<RescorerBuilder<*>>
    get() = rescores()

inline val SearchSourceBuilder.scriptFields: List<SearchSourceBuilder.ScriptField>
    get() = scriptFields()

inline var SearchSourceBuilder.searchAfter: Array<Any>
    get() = searchAfter()
    set(value) {
        searchAfter(value)
    }

inline var SearchSourceBuilder.seqNoAndPrimaryTerm: Boolean?
    get() = seqNoAndPrimaryTerm()
    set(value) {
        seqNoAndPrimaryTerm(value)
    }

inline var SearchSourceBuilder.size: Int
    get() = size()
    set(value) {
        size(value)
    }

inline var SearchSourceBuilder.slice: SliceBuilder
    get() = slice()
    set(value) {
        slice(value)
    }

inline fun SearchSourceBuilder.slice(id: Int, max: Int, block: SliceBuilder.() -> Unit): SearchSourceBuilder =
    slice(SliceBuilder(id, max).apply(block))

inline val SearchSourceBuilder.sorts: MutableList<SortBuilder<*>>
    get() = sorts()

inline var SearchSourceBuilder.stats: List<String>
    get() = stats()
    set(value) {
        stats(value)
    }

inline var SearchSourceBuilder.storedFields: StoredFieldsContext
    get() = storedFields()
    set(value) {
        storedFields(value)
    }

inline var SearchSourceBuilder.suggest: SuggestBuilder
    get() = suggest()
    set(value) {
        suggest(value)
    }

inline fun SearchSourceBuilder.suggest(block: SuggestBuilder.() -> Unit): SearchSourceBuilder =
    suggest(SuggestBuilder().apply(block))

inline var SearchSourceBuilder.terminateAfter: Int
    get() = terminateAfter()
    set(value) {
        terminateAfter(value)
    }

inline var SearchSourceBuilder.timeout: TimeValue
    get() = timeout()
    set(value) {
        timeout(value)
    }

inline var SearchSourceBuilder.trackScores: Boolean
    get() = trackScores()
    set(value) {
        trackScores(value)
    }

inline var SearchSourceBuilder.trackTotalHits: Int
    get() = trackTotalHitsUpTo() ?: SearchContext.TRACK_TOTAL_HITS_DISABLED
    set(value) {
        trackTotalHitsUpTo(value)
    }

inline var SearchSourceBuilder.version: Boolean?
    get() = version()
    set(value) {
        version(value)
    }
