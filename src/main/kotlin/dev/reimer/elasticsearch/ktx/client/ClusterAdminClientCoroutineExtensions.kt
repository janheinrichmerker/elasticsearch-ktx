@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.client

import dev.reimer.elasticsearch.ktx.util.awaitAction
import org.elasticsearch.action.admin.cluster.allocation.ClusterAllocationExplainRequest
import org.elasticsearch.action.admin.cluster.allocation.ClusterAllocationExplainResponse
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse
import org.elasticsearch.action.admin.cluster.node.hotthreads.NodesHotThreadsRequest
import org.elasticsearch.action.admin.cluster.node.hotthreads.NodesHotThreadsResponse
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoRequest
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoResponse
import org.elasticsearch.action.admin.cluster.node.stats.NodesStatsRequest
import org.elasticsearch.action.admin.cluster.node.stats.NodesStatsResponse
import org.elasticsearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest
import org.elasticsearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse
import org.elasticsearch.action.admin.cluster.node.tasks.get.GetTaskRequest
import org.elasticsearch.action.admin.cluster.node.tasks.get.GetTaskResponse
import org.elasticsearch.action.admin.cluster.node.tasks.list.ListTasksRequest
import org.elasticsearch.action.admin.cluster.node.tasks.list.ListTasksResponse
import org.elasticsearch.action.admin.cluster.node.usage.NodesUsageRequest
import org.elasticsearch.action.admin.cluster.node.usage.NodesUsageResponse
import org.elasticsearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest
import org.elasticsearch.action.admin.cluster.repositories.get.GetRepositoriesRequest
import org.elasticsearch.action.admin.cluster.repositories.get.GetRepositoriesResponse
import org.elasticsearch.action.admin.cluster.repositories.put.PutRepositoryRequest
import org.elasticsearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest
import org.elasticsearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse
import org.elasticsearch.action.admin.cluster.reroute.ClusterRerouteRequest
import org.elasticsearch.action.admin.cluster.reroute.ClusterRerouteResponse
import org.elasticsearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest
import org.elasticsearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse
import org.elasticsearch.action.admin.cluster.shards.ClusterSearchShardsRequest
import org.elasticsearch.action.admin.cluster.shards.ClusterSearchShardsResponse
import org.elasticsearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest
import org.elasticsearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse
import org.elasticsearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest
import org.elasticsearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest
import org.elasticsearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse
import org.elasticsearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest
import org.elasticsearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse
import org.elasticsearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest
import org.elasticsearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse
import org.elasticsearch.action.admin.cluster.state.ClusterStateRequest
import org.elasticsearch.action.admin.cluster.state.ClusterStateResponse
import org.elasticsearch.action.admin.cluster.stats.ClusterStatsRequest
import org.elasticsearch.action.admin.cluster.stats.ClusterStatsResponse
import org.elasticsearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest
import org.elasticsearch.action.admin.cluster.storedscripts.GetStoredScriptRequest
import org.elasticsearch.action.admin.cluster.storedscripts.GetStoredScriptResponse
import org.elasticsearch.action.admin.cluster.storedscripts.PutStoredScriptRequest
import org.elasticsearch.action.admin.cluster.tasks.PendingClusterTasksRequest
import org.elasticsearch.action.admin.cluster.tasks.PendingClusterTasksResponse
import org.elasticsearch.action.ingest.*
import org.elasticsearch.action.support.master.AcknowledgedResponse
import org.elasticsearch.client.ClusterAdminClient
import org.elasticsearch.common.bytes.BytesReference
import org.elasticsearch.common.xcontent.XContentType

suspend inline fun ClusterAdminClient.healthAsync(block: ClusterHealthRequest.() -> Unit = {}): ClusterHealthResponse =
        awaitAction { healthAsync(it, block) }

suspend inline fun ClusterAdminClient.stateAsync(block: ClusterStateRequest.() -> Unit = {}): ClusterStateResponse =
        awaitAction { stateAsync(it, block) }

suspend inline fun ClusterAdminClient.updateSettingsAsync(block: ClusterUpdateSettingsRequest.() -> Unit = {}): ClusterUpdateSettingsResponse =
        awaitAction { updateSettingsAsync(it, block) }

suspend inline fun ClusterAdminClient.rerouteAsync(block: ClusterRerouteRequest.() -> Unit = {}): ClusterRerouteResponse =
        awaitAction { rerouteAsync(it, block) }

suspend inline fun ClusterAdminClient.nodesInfoAsync(block: NodesInfoRequest.() -> Unit = {}): NodesInfoResponse =
        awaitAction { nodesInfoAsync(it, block) }

suspend inline fun ClusterAdminClient.clusterStatsAsync(block: ClusterStatsRequest.() -> Unit = {}): ClusterStatsResponse =
        awaitAction { clusterStatsAsync(it, block) }

suspend inline fun ClusterAdminClient.nodesStatsAsync(block: NodesStatsRequest.() -> Unit = {}): NodesStatsResponse =
        awaitAction { nodesStatsAsync(it, block) }

suspend inline fun ClusterAdminClient.nodesUsageAsync(block: NodesUsageRequest.() -> Unit = {}): NodesUsageResponse =
        awaitAction { nodesUsageAsync(it, block) }

suspend inline fun ClusterAdminClient.nodesHotThreadsAsync(block: NodesHotThreadsRequest.() -> Unit = {}): NodesHotThreadsResponse =
        awaitAction { nodesHotThreadsAsync(it, block) }

suspend inline fun ClusterAdminClient.listTasksAsync(block: ListTasksRequest.() -> Unit = {}): ListTasksResponse =
        awaitAction { listTasksAsync(it, block) }

suspend inline fun ClusterAdminClient.getTaskAsync(block: GetTaskRequest.() -> Unit = {}): GetTaskResponse =
        awaitAction { getTaskAsync(it, block) }

suspend inline fun ClusterAdminClient.cancelTasksAsync(block: CancelTasksRequest.() -> Unit = {}): CancelTasksResponse =
        awaitAction { cancelTasksAsync(it, block) }

suspend inline fun ClusterAdminClient.searchShardsAsync(block: ClusterSearchShardsRequest.() -> Unit = {}): ClusterSearchShardsResponse =
        awaitAction { searchShardsAsync(it, block) }

suspend inline fun ClusterAdminClient.putRepositoryAsync(block: PutRepositoryRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { putRepositoryAsync(it, block) }

suspend inline fun ClusterAdminClient.deleteRepositoryAsync(block: DeleteRepositoryRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { deleteRepositoryAsync(it, block) }

suspend inline fun ClusterAdminClient.getRepositoriesAsync(block: GetRepositoriesRequest.() -> Unit = {}): GetRepositoriesResponse =
        awaitAction { getRepositoriesAsync(it, block) }

suspend inline fun ClusterAdminClient.verifyRepositoryAsync(block: VerifyRepositoryRequest.() -> Unit = {}): VerifyRepositoryResponse =
        awaitAction { verifyRepositoryAsync(it, block) }

suspend inline fun ClusterAdminClient.createSnapshotAsync(block: CreateSnapshotRequest.() -> Unit = {}): CreateSnapshotResponse =
        awaitAction { createSnapshotAsync(it, block) }

suspend inline fun ClusterAdminClient.getSnapshotsAsync(block: GetSnapshotsRequest.() -> Unit = {}): GetSnapshotsResponse =
        awaitAction { getSnapshotsAsync(it, block) }

suspend inline fun ClusterAdminClient.deleteSnapshotAsync(block: DeleteSnapshotRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { deleteSnapshotAsync(it, block) }

suspend inline fun ClusterAdminClient.restoreSnapshotAsync(block: RestoreSnapshotRequest.() -> Unit = {}): RestoreSnapshotResponse =
        awaitAction { restoreSnapshotAsync(it, block) }

suspend inline fun ClusterAdminClient.pendingClusterTasksAsync(block: PendingClusterTasksRequest.() -> Unit = {}): PendingClusterTasksResponse =
        awaitAction { pendingClusterTasksAsync(it, block) }

suspend inline fun ClusterAdminClient.snapshotsStatusAsync(block: SnapshotsStatusRequest.() -> Unit = {}): SnapshotsStatusResponse =
        awaitAction { snapshotsStatusAsync(it, block) }

suspend inline fun ClusterAdminClient.putPipelineAsync(
        id: String,
        source: BytesReference,
        xContentType: XContentType,
        block: PutPipelineRequest.() -> Unit = {}
): AcknowledgedResponse =
        awaitAction {
                putPipelineAsync(
                        id,
                        source,
                        xContentType,
                        it,
                        block
                )
        }

suspend inline fun ClusterAdminClient.deletePipelineAsync(id: String, block: DeletePipelineRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { deletePipelineAsync(id, it, block) }

suspend inline fun ClusterAdminClient.getPipelineAsync(block: GetPipelineRequest.() -> Unit = {}): GetPipelineResponse =
        awaitAction { getPipelineAsync(it, block) }

suspend inline fun ClusterAdminClient.simulatePipelineAsync(
        source: BytesReference,
        xContentType: XContentType,
        block: SimulatePipelineRequest.() -> Unit = {}
): SimulatePipelineResponse =
        awaitAction {
                simulatePipelineAsync(
                        source,
                        xContentType,
                        it,
                        block
                )
        }

suspend inline fun ClusterAdminClient.allocationExplainAsync(block: ClusterAllocationExplainRequest.() -> Unit = {}): ClusterAllocationExplainResponse =
        awaitAction { allocationExplainAsync(it, block) }

suspend inline fun ClusterAdminClient.deleteStoredScriptAsync(id: String, block: DeleteStoredScriptRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { deleteStoredScriptAsync(id, it, block) }

suspend inline fun ClusterAdminClient.putStoredScriptAsync(block: PutStoredScriptRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { putStoredScriptAsync(it, block) }

suspend inline fun ClusterAdminClient.getStoredScriptAsync(id: String, block: GetStoredScriptRequest.() -> Unit = {}): GetStoredScriptResponse =
        awaitAction { getStoredScriptAsync(id, it, block) }
