@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.client

import dev.reimer.elasticsearch.ktx.util.awaitAction
import org.elasticsearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest
import org.elasticsearch.action.admin.cluster.repositories.get.GetRepositoriesRequest
import org.elasticsearch.action.admin.cluster.repositories.get.GetRepositoriesResponse
import org.elasticsearch.action.admin.cluster.repositories.put.PutRepositoryRequest
import org.elasticsearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest
import org.elasticsearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse
import org.elasticsearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest
import org.elasticsearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse
import org.elasticsearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest
import org.elasticsearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest
import org.elasticsearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse
import org.elasticsearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest
import org.elasticsearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse
import org.elasticsearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest
import org.elasticsearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse
import org.elasticsearch.action.support.master.AcknowledgedResponse
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.SnapshotClient

// See [Snapshot API on elastic.co](https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html).

// TODO cleanupRepository

suspend inline fun SnapshotClient.createAsync(options: RequestOptions = RequestOptions.DEFAULT, block: CreateSnapshotRequest.() -> Unit = {}): CreateSnapshotResponse =
        awaitAction { createAsync(options, it, block) }

suspend inline fun SnapshotClient.createRepositoryAsync(options: RequestOptions = RequestOptions.DEFAULT, block: PutRepositoryRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { createRepositoryAsync(options, it, block) }

suspend inline fun SnapshotClient.deleteAsync(options: RequestOptions = RequestOptions.DEFAULT, block: DeleteSnapshotRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { deleteAsync(options, it, block) }

suspend inline fun SnapshotClient.deleteRepositoryAsync(options: RequestOptions = RequestOptions.DEFAULT, block: DeleteRepositoryRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { deleteRepositoryAsync(options, it, block) }

suspend inline fun SnapshotClient.getAsync(options: RequestOptions = RequestOptions.DEFAULT, block: GetSnapshotsRequest.() -> Unit = {}): GetSnapshotsResponse =
        awaitAction { getAsync(options, it, block) }

suspend inline fun SnapshotClient.getRepositoryAsync(options: RequestOptions = RequestOptions.DEFAULT, block: GetRepositoriesRequest.() -> Unit = {}): GetRepositoriesResponse =
        awaitAction { getRepositoryAsync(options, it, block) }

suspend inline fun SnapshotClient.restoreAsync(options: RequestOptions = RequestOptions.DEFAULT, block: RestoreSnapshotRequest.() -> Unit = {}): RestoreSnapshotResponse =
        awaitAction { restoreAsync(options, it, block) }

suspend inline fun SnapshotClient.statusAsync(options: RequestOptions = RequestOptions.DEFAULT, block: SnapshotsStatusRequest.() -> Unit = {}): SnapshotsStatusResponse =
        awaitAction { statusAsync(options, it, block) }

suspend inline fun SnapshotClient.verifyRepositoryAsync(options: RequestOptions = RequestOptions.DEFAULT, block: VerifyRepositoryRequest.() -> Unit = {}): VerifyRepositoryResponse =
        awaitAction { verifyRepositoryAsync(options, it, block) }
