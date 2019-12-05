package dev.reimer.elasticsearch.ktx.transport

import org.elasticsearch.client.AdminClient
import org.elasticsearch.client.ClusterAdminClient
import org.elasticsearch.client.IndicesAdminClient

inline val AdminClient.clusterClient: ClusterAdminClient get() = cluster()
inline fun <R> AdminClient.cluster(block: ClusterAdminClient.() -> R) = cluster().run(block)
inline val AdminClient.indicesClient: IndicesAdminClient get() = indices()
inline fun <R> AdminClient.indices(block: IndicesAdminClient.() -> R) = indices().run(block)
