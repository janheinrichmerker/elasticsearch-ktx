package dev.reimer.elasticsearch.ktx.common.xcontent

import org.elasticsearch.common.xcontent.StatusToXContentObject
import org.elasticsearch.rest.RestStatus

inline val StatusToXContentObject.status: RestStatus get() = status()
