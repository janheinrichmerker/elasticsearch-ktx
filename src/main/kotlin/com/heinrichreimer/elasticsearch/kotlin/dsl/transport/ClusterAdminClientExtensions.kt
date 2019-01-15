@file:Suppress("UNUSED")

package com.heinrichreimer.elasticsearch.kotlin.dsl.transport

import org.elasticsearch.action.ActionFuture
import org.elasticsearch.action.ActionListener
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

inline fun ClusterAdminClient.health(block: ClusterHealthRequest.() -> Unit = {}): ActionFuture<ClusterHealthResponse> =
        health(ClusterHealthRequest().apply(block))

inline fun ClusterAdminClient.healthAsync(listener: ActionListener<ClusterHealthResponse>, block: ClusterHealthRequest.() -> Unit = {}) =
        health(ClusterHealthRequest().apply(block), listener)

inline fun ClusterAdminClient.state(block: ClusterStateRequest.() -> Unit = {}): ActionFuture<ClusterStateResponse> =
        state(ClusterStateRequest().apply(block))

inline fun ClusterAdminClient.stateAsync(listener: ActionListener<ClusterStateResponse>, block: ClusterStateRequest.() -> Unit = {}) =
        state(ClusterStateRequest().apply(block), listener)

inline fun ClusterAdminClient.updateSettings(block: ClusterUpdateSettingsRequest.() -> Unit = {}): ActionFuture<ClusterUpdateSettingsResponse> =
        updateSettings(ClusterUpdateSettingsRequest().apply(block))

inline fun ClusterAdminClient.updateSettingsAsync(listener: ActionListener<ClusterUpdateSettingsResponse>, block: ClusterUpdateSettingsRequest.() -> Unit = {}) =
        updateSettings(ClusterUpdateSettingsRequest().apply(block), listener)

inline fun ClusterAdminClient.reroute(block: ClusterRerouteRequest.() -> Unit = {}): ActionFuture<ClusterRerouteResponse> =
        reroute(ClusterRerouteRequest().apply(block))

inline fun ClusterAdminClient.rerouteAsync(listener: ActionListener<ClusterRerouteResponse>, block: ClusterRerouteRequest.() -> Unit = {}) =
        reroute(ClusterRerouteRequest().apply(block), listener)

inline fun ClusterAdminClient.nodesInfo(block: NodesInfoRequest.() -> Unit = {}): ActionFuture<NodesInfoResponse> =
        nodesInfo(NodesInfoRequest().apply(block))

inline fun ClusterAdminClient.nodesInfoAsync(listener: ActionListener<NodesInfoResponse>, block: NodesInfoRequest.() -> Unit = {}) =
        nodesInfo(NodesInfoRequest().apply(block), listener)

inline fun ClusterAdminClient.clusterStats(block: ClusterStatsRequest.() -> Unit = {}): ActionFuture<ClusterStatsResponse> =
        clusterStats(ClusterStatsRequest().apply(block))

inline fun ClusterAdminClient.clusterStatsAsync(listener: ActionListener<ClusterStatsResponse>, block: ClusterStatsRequest.() -> Unit = {}) =
        clusterStats(ClusterStatsRequest().apply(block), listener)

inline fun ClusterAdminClient.nodesStats(block: NodesStatsRequest.() -> Unit = {}): ActionFuture<NodesStatsResponse> =
        nodesStats(NodesStatsRequest().apply(block))

inline fun ClusterAdminClient.nodesStatsAsync(listener: ActionListener<NodesStatsResponse>, block: NodesStatsRequest.() -> Unit = {}) =
        nodesStats(NodesStatsRequest().apply(block), listener)

inline fun ClusterAdminClient.nodesUsage(block: NodesUsageRequest.() -> Unit = {}): ActionFuture<NodesUsageResponse> =
        nodesUsage(NodesUsageRequest().apply(block))

inline fun ClusterAdminClient.nodesUsageAsync(listener: ActionListener<NodesUsageResponse>, block: NodesUsageRequest.() -> Unit = {}) =
        nodesUsage(NodesUsageRequest().apply(block), listener)

inline fun ClusterAdminClient.nodesHotThreads(block: NodesHotThreadsRequest.() -> Unit = {}): ActionFuture<NodesHotThreadsResponse> =
        nodesHotThreads(NodesHotThreadsRequest().apply(block))

inline fun ClusterAdminClient.nodesHotThreadsAsync(listener: ActionListener<NodesHotThreadsResponse>, block: NodesHotThreadsRequest.() -> Unit = {}) =
        nodesHotThreads(NodesHotThreadsRequest().apply(block), listener)

inline fun ClusterAdminClient.listTasks(block: ListTasksRequest.() -> Unit = {}): ActionFuture<ListTasksResponse> =
        listTasks(ListTasksRequest().apply(block))

inline fun ClusterAdminClient.listTasksAsync(listener: ActionListener<ListTasksResponse>, block: ListTasksRequest.() -> Unit = {}) =
        listTasks(ListTasksRequest().apply(block), listener)

inline fun ClusterAdminClient.getTask(block: GetTaskRequest.() -> Unit = {}): ActionFuture<GetTaskResponse> =
        getTask(GetTaskRequest().apply(block))

inline fun ClusterAdminClient.getTaskAsync(listener: ActionListener<GetTaskResponse>, block: GetTaskRequest.() -> Unit = {}) =
        getTask(GetTaskRequest().apply(block), listener)

inline fun ClusterAdminClient.cancelTasks(block: CancelTasksRequest.() -> Unit = {}): ActionFuture<CancelTasksResponse> =
        cancelTasks(CancelTasksRequest().apply(block))

inline fun ClusterAdminClient.cancelTasksAsync(listener: ActionListener<CancelTasksResponse>, block: CancelTasksRequest.() -> Unit = {}) =
        cancelTasks(CancelTasksRequest().apply(block), listener)

inline fun ClusterAdminClient.searchShards(block: ClusterSearchShardsRequest.() -> Unit = {}): ActionFuture<ClusterSearchShardsResponse> =
        searchShards(ClusterSearchShardsRequest().apply(block))

inline fun ClusterAdminClient.searchShardsAsync(listener: ActionListener<ClusterSearchShardsResponse>, block: ClusterSearchShardsRequest.() -> Unit = {}) =
        searchShards(ClusterSearchShardsRequest().apply(block), listener)

inline fun ClusterAdminClient.putRepository(block: PutRepositoryRequest.() -> Unit = {}): ActionFuture<AcknowledgedResponse> =
        putRepository(PutRepositoryRequest().apply(block))

inline fun ClusterAdminClient.putRepositoryAsync(listener: ActionListener<AcknowledgedResponse>, block: PutRepositoryRequest.() -> Unit = {}) =
        putRepository(PutRepositoryRequest().apply(block), listener)

inline fun ClusterAdminClient.deleteRepository(block: DeleteRepositoryRequest.() -> Unit = {}): ActionFuture<AcknowledgedResponse> =
        deleteRepository(DeleteRepositoryRequest().apply(block))

inline fun ClusterAdminClient.deleteRepositoryAsync(listener: ActionListener<AcknowledgedResponse>, block: DeleteRepositoryRequest.() -> Unit = {}) =
        deleteRepository(DeleteRepositoryRequest().apply(block), listener)

inline fun ClusterAdminClient.getRepositories(block: GetRepositoriesRequest.() -> Unit = {}): ActionFuture<GetRepositoriesResponse> =
        getRepositories(GetRepositoriesRequest().apply(block))

inline fun ClusterAdminClient.getRepositoriesAsync(listener: ActionListener<GetRepositoriesResponse>, block: GetRepositoriesRequest.() -> Unit = {}) =
        getRepositories(GetRepositoriesRequest().apply(block), listener)

inline fun ClusterAdminClient.verifyRepository(block: VerifyRepositoryRequest.() -> Unit = {}): ActionFuture<VerifyRepositoryResponse> =
        verifyRepository(VerifyRepositoryRequest().apply(block))

inline fun ClusterAdminClient.verifyRepositoryAsync(listener: ActionListener<VerifyRepositoryResponse>, block: VerifyRepositoryRequest.() -> Unit = {}) =
        verifyRepository(VerifyRepositoryRequest().apply(block), listener)

inline fun ClusterAdminClient.createSnapshot(block: CreateSnapshotRequest.() -> Unit = {}): ActionFuture<CreateSnapshotResponse> =
        createSnapshot(CreateSnapshotRequest().apply(block))

inline fun ClusterAdminClient.createSnapshotAsync(listener: ActionListener<CreateSnapshotResponse>, block: CreateSnapshotRequest.() -> Unit = {}) =
        createSnapshot(CreateSnapshotRequest().apply(block), listener)

inline fun ClusterAdminClient.getSnapshots(block: GetSnapshotsRequest.() -> Unit = {}): ActionFuture<GetSnapshotsResponse> =
        getSnapshots(GetSnapshotsRequest().apply(block))

inline fun ClusterAdminClient.getSnapshotsAsync(listener: ActionListener<GetSnapshotsResponse>, block: GetSnapshotsRequest.() -> Unit = {}) =
        getSnapshots(GetSnapshotsRequest().apply(block), listener)

inline fun ClusterAdminClient.deleteSnapshot(block: DeleteSnapshotRequest.() -> Unit = {}): ActionFuture<AcknowledgedResponse> =
        deleteSnapshot(DeleteSnapshotRequest().apply(block))

inline fun ClusterAdminClient.deleteSnapshotAsync(listener: ActionListener<AcknowledgedResponse>, block: DeleteSnapshotRequest.() -> Unit = {}) =
        deleteSnapshot(DeleteSnapshotRequest().apply(block), listener)

inline fun ClusterAdminClient.restoreSnapshot(block: RestoreSnapshotRequest.() -> Unit = {}): ActionFuture<RestoreSnapshotResponse> =
        restoreSnapshot(RestoreSnapshotRequest().apply(block))

inline fun ClusterAdminClient.restoreSnapshotAsync(listener: ActionListener<RestoreSnapshotResponse>, block: RestoreSnapshotRequest.() -> Unit = {}) =
        restoreSnapshot(RestoreSnapshotRequest().apply(block), listener)

inline fun ClusterAdminClient.pendingClusterTasks(block: PendingClusterTasksRequest.() -> Unit = {}): ActionFuture<PendingClusterTasksResponse> =
        pendingClusterTasks(PendingClusterTasksRequest().apply(block))

inline fun ClusterAdminClient.pendingClusterTasksAsync(listener: ActionListener<PendingClusterTasksResponse>, block: PendingClusterTasksRequest.() -> Unit = {}) =
        pendingClusterTasks(PendingClusterTasksRequest().apply(block), listener)

inline fun ClusterAdminClient.snapshotsStatus(block: SnapshotsStatusRequest.() -> Unit = {}): ActionFuture<SnapshotsStatusResponse> =
        snapshotsStatus(SnapshotsStatusRequest().apply(block))

inline fun ClusterAdminClient.snapshotsStatusAsync(listener: ActionListener<SnapshotsStatusResponse>, block: SnapshotsStatusRequest.() -> Unit = {}) =
        snapshotsStatus(SnapshotsStatusRequest().apply(block), listener)

inline fun ClusterAdminClient.putPipeline(id: String, source: BytesReference, xContentType: XContentType, block: PutPipelineRequest.() -> Unit = {}): ActionFuture<AcknowledgedResponse> =
        putPipeline(PutPipelineRequest(id, source, xContentType).apply(block))

inline fun ClusterAdminClient.putPipelineAsync(id: String, source: BytesReference, xContentType: XContentType, listener: ActionListener<AcknowledgedResponse>, block: PutPipelineRequest.() -> Unit = {}) =
        putPipeline(PutPipelineRequest(id, source, xContentType).apply(block), listener)

inline fun ClusterAdminClient.deletePipeline(id: String, block: DeletePipelineRequest.() -> Unit = {}): ActionFuture<AcknowledgedResponse> =
        deletePipeline(DeletePipelineRequest(id).apply(block))

inline fun ClusterAdminClient.deletePipelineAsync(id: String, listener: ActionListener<AcknowledgedResponse>, block: DeletePipelineRequest.() -> Unit = {}) =
        deletePipeline(DeletePipelineRequest(id).apply(block), listener)

inline fun ClusterAdminClient.getPipeline(block: GetPipelineRequest.() -> Unit = {}): ActionFuture<GetPipelineResponse> =
        getPipeline(GetPipelineRequest().apply(block))

inline fun ClusterAdminClient.getPipelineAsync(listener: ActionListener<GetPipelineResponse>, block: GetPipelineRequest.() -> Unit = {}) =
        getPipeline(GetPipelineRequest().apply(block), listener)

inline fun ClusterAdminClient.simulatePipeline(source: BytesReference, xContentType: XContentType, block: SimulatePipelineRequest.() -> Unit = {}): ActionFuture<SimulatePipelineResponse> =
        simulatePipeline(SimulatePipelineRequest(source, xContentType).apply(block))

inline fun ClusterAdminClient.simulatePipelineAsync(source: BytesReference, xContentType: XContentType, listener: ActionListener<SimulatePipelineResponse>, block: SimulatePipelineRequest.() -> Unit = {}) =
        simulatePipeline(SimulatePipelineRequest(source, xContentType).apply(block), listener)

inline fun ClusterAdminClient.allocationExplain(block: ClusterAllocationExplainRequest.() -> Unit = {}): ActionFuture<ClusterAllocationExplainResponse> =
        allocationExplain(ClusterAllocationExplainRequest().apply(block))

inline fun ClusterAdminClient.allocationExplainAsync(listener: ActionListener<ClusterAllocationExplainResponse>, block: ClusterAllocationExplainRequest.() -> Unit = {}) =
        allocationExplain(ClusterAllocationExplainRequest().apply(block), listener)

inline fun ClusterAdminClient.deleteStoredScript(id: String, block: DeleteStoredScriptRequest.() -> Unit = {}): ActionFuture<AcknowledgedResponse> =
        deleteStoredScript(DeleteStoredScriptRequest(id).apply(block))

inline fun ClusterAdminClient.deleteStoredScriptAsync(id: String, listener: ActionListener<AcknowledgedResponse>, block: DeleteStoredScriptRequest.() -> Unit = {}) =
        deleteStoredScript(DeleteStoredScriptRequest(id).apply(block), listener)

inline fun ClusterAdminClient.putStoredScript(block: PutStoredScriptRequest.() -> Unit = {}): ActionFuture<AcknowledgedResponse> =
        putStoredScript(PutStoredScriptRequest().apply(block))

inline fun ClusterAdminClient.putStoredScriptAsync(listener: ActionListener<AcknowledgedResponse>, block: PutStoredScriptRequest.() -> Unit = {}) =
        putStoredScript(PutStoredScriptRequest().apply(block), listener)

inline fun ClusterAdminClient.getStoredScript(id: String, block: GetStoredScriptRequest.() -> Unit = {}): ActionFuture<GetStoredScriptResponse> =
        getStoredScript(GetStoredScriptRequest(id).apply(block))

inline fun ClusterAdminClient.getStoredScriptAsync(id: String, listener: ActionListener<GetStoredScriptResponse>, block: GetStoredScriptRequest.() -> Unit = {}) =
        getStoredScript(GetStoredScriptRequest(id).apply(block), listener)
