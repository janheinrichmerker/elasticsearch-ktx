@file:Suppress("UNUSED")

package com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.rest

import com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.awaitAction
import com.heinrichreimer.elasticsearch.kotlin.dsl.rest.*
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.SecurityClient
import org.elasticsearch.client.security.*
import org.elasticsearch.client.security.support.expressiondsl.RoleMapperExpression
import org.elasticsearch.client.security.user.User

suspend inline fun SecurityClient.putUserAsync(
    user: User,
    password: CharArray,
    enabled: Boolean,
    refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(),
    options: RequestOptions = RequestOptions.DEFAULT,
    block: PutUserRequest.() -> Unit = {}
): PutUserResponse =
    awaitAction { putUserAsync(user, password, enabled, refreshPolicy, options, it, block) }

suspend inline fun SecurityClient.putRoleMappingAsync(name: String, enabled: Boolean, roles: List<String>, rules: RoleMapperExpression, metadata: Map<String, Any> = emptyMap(), refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(), options: RequestOptions = RequestOptions.DEFAULT, block: PutRoleMappingRequest.() -> Unit = {}): PutRoleMappingResponse =
        awaitAction { putRoleMappingAsync(name, enabled, roles, rules, metadata, refreshPolicy, options, it, block) }

suspend inline fun SecurityClient.enableUserAsync(
    username: String,
    refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(),
    options: RequestOptions = RequestOptions.DEFAULT,
    block: EnableUserRequest.() -> Unit = {}
): Boolean =
    awaitAction { enableUserAsync(username, refreshPolicy, options, it, block) }

suspend inline fun SecurityClient.disableUserAsync(
    username: String,
    refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(),
    options: RequestOptions = RequestOptions.DEFAULT,
    block: DisableUserRequest.() -> Unit = {}
): Boolean =
    awaitAction { disableUserAsync(username, refreshPolicy, options, it, block) }

suspend inline fun SecurityClient.getSslCertificatesAsync(options: RequestOptions = RequestOptions.DEFAULT): GetSslCertificatesResponse =
        awaitAction { getSslCertificatesAsync(options, it) }

suspend inline fun SecurityClient.changePasswordAsync(
    username: String,
    password: CharArray,
    refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(),
    options: RequestOptions = RequestOptions.DEFAULT,
    block: ChangePasswordRequest.() -> Unit = {}
): Boolean =
    awaitAction { changePasswordAsync(username, password, refreshPolicy, options, it, block) }

suspend inline fun SecurityClient.deleteRoleMappingAsync(name: String, refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(), options: RequestOptions = RequestOptions.DEFAULT, block: DeleteRoleMappingRequest.() -> Unit = {}): DeleteRoleMappingResponse =
        awaitAction { deleteRoleMappingAsync(name, refreshPolicy, options, it, block) }

suspend inline fun SecurityClient.deleteRoleAsync(name: String, refreshPolicy: RefreshPolicy = RefreshPolicy.IMMEDIATE, options: RequestOptions = RequestOptions.DEFAULT, block: DeleteRoleRequest.() -> Unit = {}): DeleteRoleResponse =
        awaitAction { deleteRoleAsync(name, refreshPolicy, options, it, block) }
