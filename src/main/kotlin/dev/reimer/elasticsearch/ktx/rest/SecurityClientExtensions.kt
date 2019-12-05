@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.rest

import org.elasticsearch.action.ActionListener
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.SecurityClient
import org.elasticsearch.client.security.*
import org.elasticsearch.client.security.support.expressiondsl.RoleMapperExpression
import org.elasticsearch.client.security.user.User
import java.io.IOException

@Throws(IOException::class)
inline fun SecurityClient.putUser(
        user: User,
        password: CharArray,
        enabled: Boolean,
        refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(),
        options: RequestOptions = RequestOptions.DEFAULT,
        block: PutUserRequest.() -> Unit = {}
): PutUserResponse =
        putUser(PutUserRequest(user, password, enabled, refreshPolicy).apply(block), options)

inline fun SecurityClient.putUserAsync(
        user: User,
        password: CharArray,
        enabled: Boolean,
        refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(),
        options: RequestOptions = RequestOptions.DEFAULT,
        listener: ActionListener<PutUserResponse>,
        block: PutUserRequest.() -> Unit = {}
) =
        putUserAsync(PutUserRequest(user, password, enabled, refreshPolicy).apply(block), options, listener)

@Throws(IOException::class)
inline fun SecurityClient.putRoleMapping(name: String, enabled: Boolean, roles: List<String>, rules: RoleMapperExpression, metadata: Map<String, Any> = emptyMap(), refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(), options: RequestOptions = RequestOptions.DEFAULT, block: PutRoleMappingRequest.() -> Unit = {}): PutRoleMappingResponse =
        putRoleMapping(PutRoleMappingRequest(name, enabled, roles, rules, metadata, refreshPolicy).apply(block), options)

inline fun SecurityClient.putRoleMappingAsync(name: String, enabled: Boolean, roles: List<String>, rules: RoleMapperExpression, metadata: Map<String, Any> = emptyMap(), refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(), options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<PutRoleMappingResponse>, block: PutRoleMappingRequest.() -> Unit = {}) =
        putRoleMappingAsync(PutRoleMappingRequest(name, enabled, roles, rules, metadata, refreshPolicy).apply(block), options, listener)

@Throws(IOException::class)
inline fun SecurityClient.enableUser(
        username: String,
        refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(),
        options: RequestOptions = RequestOptions.DEFAULT,
        block: EnableUserRequest.() -> Unit = {}
): Boolean =
        enableUser(EnableUserRequest(username, refreshPolicy).apply(block), options)

inline fun SecurityClient.enableUserAsync(
        username: String,
        refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(),
        options: RequestOptions = RequestOptions.DEFAULT,
        listener: ActionListener<Boolean>,
        block: EnableUserRequest.() -> Unit = {}
) =
        enableUserAsync(EnableUserRequest(username, refreshPolicy).apply(block), options, listener)

@Throws(IOException::class)
inline fun SecurityClient.disableUser(
        username: String,
        refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(),
        options: RequestOptions = RequestOptions.DEFAULT,
        block: DisableUserRequest.() -> Unit = {}
): Boolean =
        disableUser(DisableUserRequest(username, refreshPolicy).apply(block), options)

inline fun SecurityClient.disableUserAsync(
        username: String,
        refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(),
        options: RequestOptions = RequestOptions.DEFAULT,
        listener: ActionListener<Boolean>,
        block: DisableUserRequest.() -> Unit = {}
) =
        disableUserAsync(DisableUserRequest(username, refreshPolicy).apply(block), options, listener)

@Throws(IOException::class)
fun SecurityClient.getSslCertificates(options: RequestOptions = RequestOptions.DEFAULT): GetSslCertificatesResponse =
        getSslCertificates(options)

fun SecurityClient.getSslCertificatesAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetSslCertificatesResponse>) =
        getSslCertificatesAsync(options, listener)

@Throws(IOException::class)
inline fun SecurityClient.changePassword(
        username: String,
        password: CharArray,
        refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(),
        options: RequestOptions = RequestOptions.DEFAULT,
        block: ChangePasswordRequest.() -> Unit = {}
): Boolean =
        changePassword(ChangePasswordRequest(username, password, refreshPolicy).apply(block), options)

inline fun SecurityClient.changePasswordAsync(
        username: String,
        password: CharArray,
        refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(),
        options: RequestOptions = RequestOptions.DEFAULT,
        listener: ActionListener<Boolean>,
        block: ChangePasswordRequest.() -> Unit = {}
) =
        changePasswordAsync(ChangePasswordRequest(username, password, refreshPolicy).apply(block), options, listener)

@Throws(IOException::class)
inline fun SecurityClient.deleteRoleMapping(name: String, refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(), options: RequestOptions = RequestOptions.DEFAULT, block: DeleteRoleMappingRequest.() -> Unit = {}): DeleteRoleMappingResponse =
        deleteRoleMapping(DeleteRoleMappingRequest(name, refreshPolicy).apply(block), options)

inline fun SecurityClient.deleteRoleMappingAsync(name: String, refreshPolicy: RefreshPolicy = RefreshPolicy.getDefault(), options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<DeleteRoleMappingResponse>, block: DeleteRoleMappingRequest.() -> Unit = {}) =
        deleteRoleMappingAsync(DeleteRoleMappingRequest(name, refreshPolicy).apply(block), options, listener)

@Throws(IOException::class)
inline fun SecurityClient.deleteRole(name: String, refreshPolicy: RefreshPolicy = RefreshPolicy.IMMEDIATE, options: RequestOptions = RequestOptions.DEFAULT, block: DeleteRoleRequest.() -> Unit = {}): DeleteRoleResponse =
        deleteRole(DeleteRoleRequest(name, refreshPolicy).apply(block), options)

inline fun SecurityClient.deleteRoleAsync(name: String, refreshPolicy: RefreshPolicy = RefreshPolicy.IMMEDIATE, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<DeleteRoleResponse>, block: DeleteRoleRequest.() -> Unit = {}) =
        deleteRoleAsync(DeleteRoleRequest(name, refreshPolicy).apply(block), options, listener)
