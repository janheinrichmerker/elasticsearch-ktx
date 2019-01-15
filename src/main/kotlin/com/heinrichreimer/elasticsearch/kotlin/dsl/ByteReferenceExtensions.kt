package com.heinrichreimer.elasticsearch.kotlin.dsl

import org.apache.lucene.util.BytesRef
import org.elasticsearch.common.bytes.*
import org.elasticsearch.common.lease.Releasable
import org.elasticsearch.common.util.BigArrays
import java.nio.ByteBuffer

fun ByteArray.toBytesReference(range: ClosedRange<Int> = 0..size): BytesReference =
        BytesArray(this, range.start, range.endInclusive)

fun ByteArray.toBytesReference(offset: Int, length: Int): BytesReference = toBytesReference(offset..length)
fun BytesRef.toBytesReference(deepCopy: Boolean = false): BytesReference = BytesArray(this, deepCopy)
fun String.toBytesReference(): BytesReference = BytesArray(this)

fun org.elasticsearch.common.util.ByteArray.toBytesReference(
        bigArrays: BigArrays = BigArrays.NON_RECYCLING_INSTANCE,
        range: ClosedRange<Int> = 0..(size().toInt())
): BytesReference = PagedBytesReference(bigArrays, this, range.start, range.endInclusive)

fun org.elasticsearch.common.util.ByteArray.toBytesReference(
        bigArrays: BigArrays = BigArrays.NON_RECYCLING_INSTANCE,
        offset: Int = 0,
        length: Int
): BytesReference = toBytesReference(bigArrays, offset..length)

fun org.elasticsearch.common.util.ByteArray.toBytesReference(
        bigArrays: BigArrays = BigArrays.NON_RECYCLING_INSTANCE,
        length: Int,
        releasable: Releasable
): BytesReference = ReleasablePagedBytesReference(bigArrays, this, length, releasable)

fun ByteBuffer.toBytesReference(): BytesReference = ByteBufferReference(this)

fun Array<BytesReference>.toBytesReference(): BytesReference = CompositeBytesReference(*this)
fun Collection<BytesReference>.toBytesReference(): BytesReference = toTypedArray().toBytesReference()
fun Iterable<BytesReference>.toBytesReference(): BytesReference = toList().toBytesReference()

operator fun BytesReference.plus(other: BytesReference) =
        CompositeBytesReference(this, other)