@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.client

import dev.reimer.elasticsearch.ktx.util.awaitAction
import org.elasticsearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest
import org.elasticsearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse
import org.elasticsearch.action.admin.cluster.node.tasks.list.ListTasksRequest
import org.elasticsearch.action.admin.cluster.node.tasks.list.ListTasksResponse
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.TasksClient

suspend inline fun TasksClient.listAsync(options: RequestOptions = RequestOptions.DEFAULT, block: ListTasksRequest.() -> Unit = {}): ListTasksResponse =
        awaitAction { listAsync(options, it, block) }

suspend inline fun TasksClient.cancelAsync(options: RequestOptions = RequestOptions.DEFAULT, block: CancelTasksRequest.() -> Unit = {}): CancelTasksResponse =
        awaitAction { cancelAsync(options, it, block) }
