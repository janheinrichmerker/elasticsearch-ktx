@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.client

import org.elasticsearch.action.ActionListener
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
import org.elasticsearch.client.Cancellable
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.SnapshotClient
import java.io.IOException

// See [Snapshot API on elastic.co](https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html).

@Throws(IOException::class)
inline fun SnapshotClient.getRepository(options: RequestOptions = RequestOptions.DEFAULT, block: GetRepositoriesRequest.() -> Unit = {}): GetRepositoriesResponse =
        getRepository(GetRepositoriesRequest().apply(block), options)

inline fun SnapshotClient.getRepositoryAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetRepositoriesResponse>, block: GetRepositoriesRequest.() -> Unit = {}): Cancellable =
        getRepositoryAsync(GetRepositoriesRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun SnapshotClient.createRepository(options: RequestOptions = RequestOptions.DEFAULT, block: PutRepositoryRequest.() -> Unit = {}): AcknowledgedResponse =
        createRepository(PutRepositoryRequest().apply(block), options)

inline fun SnapshotClient.createRepositoryAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: PutRepositoryRequest.() -> Unit = {}): Cancellable =
        createRepositoryAsync(PutRepositoryRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun SnapshotClient.deleteRepository(options: RequestOptions = RequestOptions.DEFAULT, block: DeleteRepositoryRequest.() -> Unit = {}): AcknowledgedResponse =
        deleteRepository(DeleteRepositoryRequest().apply(block), options)

inline fun SnapshotClient.deleteRepositoryAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: DeleteRepositoryRequest.() -> Unit = {}): Cancellable =
        deleteRepositoryAsync(DeleteRepositoryRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun SnapshotClient.verifyRepository(options: RequestOptions = RequestOptions.DEFAULT, block: VerifyRepositoryRequest.() -> Unit = {}): VerifyRepositoryResponse =
        verifyRepository(VerifyRepositoryRequest().apply(block), options)

inline fun SnapshotClient.verifyRepositoryAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<VerifyRepositoryResponse>, block: VerifyRepositoryRequest.() -> Unit = {}): Cancellable =
        verifyRepositoryAsync(VerifyRepositoryRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun SnapshotClient.create(options: RequestOptions = RequestOptions.DEFAULT, block: CreateSnapshotRequest.() -> Unit = {}): CreateSnapshotResponse =
        create(CreateSnapshotRequest().apply(block), options)

inline fun SnapshotClient.createAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<CreateSnapshotResponse>, block: CreateSnapshotRequest.() -> Unit = {}): Cancellable =
        createAsync(CreateSnapshotRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun SnapshotClient.get(options: RequestOptions = RequestOptions.DEFAULT, block: GetSnapshotsRequest.() -> Unit = {}): GetSnapshotsResponse =
        get(GetSnapshotsRequest().apply(block), options)

inline fun SnapshotClient.getAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetSnapshotsResponse>, block: GetSnapshotsRequest.() -> Unit = {}): Cancellable =
        getAsync(GetSnapshotsRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun SnapshotClient.status(options: RequestOptions = RequestOptions.DEFAULT, block: SnapshotsStatusRequest.() -> Unit = {}): SnapshotsStatusResponse =
        status(SnapshotsStatusRequest().apply(block), options)

inline fun SnapshotClient.statusAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<SnapshotsStatusResponse>, block: SnapshotsStatusRequest.() -> Unit = {}): Cancellable =
        statusAsync(SnapshotsStatusRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun SnapshotClient.restore(options: RequestOptions = RequestOptions.DEFAULT, block: RestoreSnapshotRequest.() -> Unit = {}): RestoreSnapshotResponse =
        restore(RestoreSnapshotRequest().apply(block), options)

inline fun SnapshotClient.restoreAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<RestoreSnapshotResponse>, block: RestoreSnapshotRequest.() -> Unit = {}): Cancellable =
        restoreAsync(RestoreSnapshotRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun SnapshotClient.delete(options: RequestOptions = RequestOptions.DEFAULT, block: DeleteSnapshotRequest.() -> Unit = {}): AcknowledgedResponse =
        delete(DeleteSnapshotRequest().apply(block), options)

inline fun SnapshotClient.deleteAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: DeleteSnapshotRequest.() -> Unit = {}): Cancellable =
        deleteAsync(DeleteSnapshotRequest().apply(block), options, listener)
