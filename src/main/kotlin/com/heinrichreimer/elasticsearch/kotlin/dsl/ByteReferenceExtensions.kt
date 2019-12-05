package com.heinrichreimer.elasticsearch.kotlin.dsl

import org.apache.lucene.util.BytesRef
import org.elasticsearch.common.bytes.*
import org.elasticsearch.common.lease.Releasable
import java.nio.ByteBuffer

fun ByteArray.toBytesReference(range: ClosedRange<Int> = 0..size): BytesReference =
        BytesArray(this, range.start, range.endInclusive)

fun ByteArray.toBytesReference(offset: Int, length: Int): BytesReference = toBytesReference(offset..length)
fun BytesRef.toBytesReference(deepCopy: Boolean = false): BytesReference = BytesArray(this, deepCopy)
fun String.toBytesReference(): BytesReference = BytesArray(this)

fun org.elasticsearch.common.util.ByteArray.toBytesReference(
        length: Int
): BytesReference = PagedBytesReference(this, length)

fun org.elasticsearch.common.util.ByteArray.toBytesReference(
        length: Int,
        releasable: Releasable
): BytesReference = ReleasablePagedBytesReference(this, length, releasable)

fun ByteBuffer.toBytesReference(): BytesReference = BytesReference.fromByteBuffers(arrayOf(this))

fun Array<BytesReference>.toBytesReference(): BytesReference = CompositeBytesReference(*this)
fun Collection<BytesReference>.toBytesReference(): BytesReference = toTypedArray().toBytesReference()
fun Iterable<BytesReference>.toBytesReference(): BytesReference = toList().toBytesReference()

operator fun BytesReference.plus(other: BytesReference) =
        CompositeBytesReference(this, other)