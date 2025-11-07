package com.pratikvelani.taskly.domain.base

import kotlin.collections.filter
import kotlin.collections.map
import kotlin.map
import kotlin.mapCatching

fun <T> Result<List<T>>.filterResultList(predicate: (T) -> Boolean) = this.map { list ->
    list.filter { predicate(it) }
}

fun <T, S> Result<List<T>>.mapResultList(transform: (T) -> S) = this.map { list ->
    list.map { transform(it) }
}

fun <T, S> Result<List<T>>.mapCatchingResultList(transform: (T) -> S) = this.mapCatching { list ->
    list.map { transform(it) }
}
