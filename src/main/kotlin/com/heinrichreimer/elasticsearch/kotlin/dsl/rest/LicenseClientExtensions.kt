@file:Suppress("UNUSED")

package com.heinrichreimer.elasticsearch.kotlin.dsl.rest

import org.elasticsearch.action.ActionListener
import org.elasticsearch.action.support.master.AcknowledgedResponse
import org.elasticsearch.client.LicenseClient
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.license.*
import java.io.IOException

@Throws(IOException::class)
inline fun LicenseClient.putLicense(options: RequestOptions = RequestOptions.DEFAULT, block: PutLicenseRequest.() -> Unit = {}): PutLicenseResponse =
        putLicense(PutLicenseRequest().apply(block), options)

inline fun LicenseClient.putLicenseAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<PutLicenseResponse>, block: PutLicenseRequest.() -> Unit = {}) =
        putLicenseAsync(PutLicenseRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun LicenseClient.getLicense(options: RequestOptions = RequestOptions.DEFAULT, block: GetLicenseRequest.() -> Unit = {}): GetLicenseResponse =
        getLicense(GetLicenseRequest().apply(block), options)

inline fun LicenseClient.getLicenseAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetLicenseResponse>, block: GetLicenseRequest.() -> Unit = {}) =
        getLicenseAsync(GetLicenseRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun LicenseClient.deleteLicense(options: RequestOptions = RequestOptions.DEFAULT, block: DeleteLicenseRequest.() -> Unit = {}): AcknowledgedResponse =
        deleteLicense(DeleteLicenseRequest().apply(block), options)

inline fun LicenseClient.deleteLicenseAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: DeleteLicenseRequest.() -> Unit = {}) =
        deleteLicenseAsync(DeleteLicenseRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun LicenseClient.startTrial(options: RequestOptions = RequestOptions.DEFAULT, block: StartTrialRequest.() -> Unit = {}): StartTrialResponse =
        startTrial(StartTrialRequest().apply(block), options)

inline fun LicenseClient.startTrialAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<StartTrialResponse>, block: StartTrialRequest.() -> Unit = {}) =
        startTrialAsync(StartTrialRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun LicenseClient.startBasic(options: RequestOptions = RequestOptions.DEFAULT, block: StartBasicRequest.() -> Unit = {}): StartBasicResponse =
        startBasic(StartBasicRequest().apply(block), options)

inline fun LicenseClient.startBasicAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<StartBasicResponse>, block: StartBasicRequest.() -> Unit = {}) =
        startBasicAsync(StartBasicRequest().apply(block), options, listener)
