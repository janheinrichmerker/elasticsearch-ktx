@file:Suppress("UNUSED")

package com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.rest

import com.heinrichreimer.elasticsearch.kotlin.dsl.rest.*
import com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.awaitAction
import de.unihalle.informatik.bigdata.knjigica.indexer.util.elasticsearch.rest.*
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.SecurityClient
import org.elasticsearch.client.security.*
import org.elasticsearch.client.security.support.expressiondsl.RoleMapperExpression

suspend inline fun SecurityClient.putUserAsync(username: String, password: CharArray, roles: List<String>, fullName: String, email: String, enabled: Boolean, metadata: Map<String, Any> = emptyMap(), refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(), options: RequestOptions = RequestOptions.DEFAULT, block: PutUserRequest.() -> Unit = {}): PutUserResponse =
        awaitAction { putUserAsync(username, password, roles, fullName, email, enabled, metadata, refreshPolicy, options, it, block) }

suspend inline fun SecurityClient.putRoleMappingAsync(name: String, enabled: Boolean, roles: List<String>, rules: RoleMapperExpression, metadata: Map<String, Any> = emptyMap(), refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(), options: RequestOptions = RequestOptions.DEFAULT, block: PutRoleMappingRequest.() -> Unit = {}): PutRoleMappingResponse =
        awaitAction { putRoleMappingAsync(name, enabled, roles, rules, metadata, refreshPolicy, options, it, block) }

suspend inline fun SecurityClient.enableUserAsync(username: String, refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(), options: RequestOptions = RequestOptions.DEFAULT, block: EnableUserRequest.() -> Unit = {}): EmptyResponse =
        awaitAction { enableUserAsync(username, refreshPolicy, options, it, block) }

suspend inline fun SecurityClient.disableUserAsync(username: String, refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(), options: RequestOptions = RequestOptions.DEFAULT, block: DisableUserRequest.() -> Unit = {}): EmptyResponse =
        awaitAction { disableUserAsync(username, refreshPolicy, options, it, block) }

suspend inline fun SecurityClient.getSslCertificatesAsync(options: RequestOptions = RequestOptions.DEFAULT): GetSslCertificatesResponse =
        awaitAction { getSslCertificatesAsync(options, it) }

suspend inline fun SecurityClient.changePasswordAsync(username: String, password: CharArray, refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(), options: RequestOptions = RequestOptions.DEFAULT, block: ChangePasswordRequest.() -> Unit = {}): EmptyResponse =
        awaitAction { changePasswordAsync(username, password, refreshPolicy, options, it, block) }

suspend inline fun SecurityClient.deleteRoleMappingAsync(name: String, refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(), options: RequestOptions = RequestOptions.DEFAULT, block: DeleteRoleMappingRequest.() -> Unit = {}): DeleteRoleMappingResponse =
        awaitAction { deleteRoleMappingAsync(name, refreshPolicy, options, it, block) }

suspend inline fun SecurityClient.deleteRoleAsync(name: String, refreshPolicy: RefreshPolicy = RefreshPolicy.IMMEDIATE, options: RequestOptions = RequestOptions.DEFAULT, block: DeleteRoleRequest.() -> Unit = {}): DeleteRoleResponse =
        awaitAction { deleteRoleAsync(name, refreshPolicy, options, it, block) }
