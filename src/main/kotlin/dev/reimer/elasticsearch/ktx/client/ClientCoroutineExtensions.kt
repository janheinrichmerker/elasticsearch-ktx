@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.client

import dev.reimer.elasticsearch.ktx.util.awaitAction
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
import org.elasticsearch.client.Client

suspend inline fun Client.indexAsync(block: IndexRequest.() -> Unit = {}): IndexResponse =
        awaitAction { indexAsync(it, block) }

suspend inline fun Client.updateAsync(block: UpdateRequest.() -> Unit = {}): UpdateResponse =
        awaitAction { updateAsync(it, block) }

suspend inline fun Client.deleteAsync(block: DeleteRequest.() -> Unit = {}): DeleteResponse =
        awaitAction { deleteAsync(it, block) }

suspend inline fun Client.bulkAsync(block: BulkRequest.() -> Unit = {}): BulkResponse =
        awaitAction { bulkAsync(it, block) }

suspend inline fun Client.getAsync(block: GetRequest.() -> Unit = {}): GetResponse =
        awaitAction { getAsync(it, block) }

suspend inline fun Client.multiGetAsync(block: MultiGetRequest.() -> Unit = {}): MultiGetResponse =
        awaitAction { multiGetAsync(it, block) }

suspend inline fun Client.searchAsync(block: SearchRequest.() -> Unit = {}): SearchResponse =
        awaitAction { searchAsync(it, block) }

suspend inline fun Client.searchScrollAsync(block: SearchScrollRequest.() -> Unit = {}): SearchResponse =
        awaitAction { searchScrollAsync(it, block) }

suspend inline fun Client.multiSearchAsync(block: MultiSearchRequest.() -> Unit = {}): MultiSearchResponse =
        awaitAction { multiSearchAsync(it, block) }

suspend inline fun Client.termVectorsAsync(block: TermVectorsRequest.() -> Unit = {}): TermVectorsResponse =
        awaitAction { termVectorsAsync(it, block) }

suspend inline fun Client.multiTermVectorsAsync(block: MultiTermVectorsRequest.() -> Unit = {}): MultiTermVectorsResponse =
        awaitAction { multiTermVectorsAsync(it, block) }

suspend inline fun Client.explainAsync(block: ExplainRequest.() -> Unit = {}): ExplainResponse =
        awaitAction { explainAsync(it, block) }

suspend inline fun Client.clearScrollAsync(block: ClearScrollRequest.() -> Unit = {}): ClearScrollResponse =
        awaitAction { clearScrollAsync(it, block) }

suspend inline fun Client.fieldCapsAsync(block: FieldCapabilitiesRequest.() -> Unit = {}): FieldCapabilitiesResponse =
        awaitAction { fieldCapsAsync(it, block) }
