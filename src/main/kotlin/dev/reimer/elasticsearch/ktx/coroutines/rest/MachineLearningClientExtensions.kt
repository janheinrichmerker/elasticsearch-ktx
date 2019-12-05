@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.coroutines.rest

import dev.reimer.elasticsearch.ktx.coroutines.awaitAction
import dev.reimer.elasticsearch.ktx.rest.*
import org.elasticsearch.action.support.master.AcknowledgedResponse
import org.elasticsearch.client.MachineLearningClient
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.ml.*
import org.elasticsearch.client.ml.calendars.Calendar
import org.elasticsearch.client.ml.datafeed.DatafeedConfig
import org.elasticsearch.client.ml.job.config.Job
import org.elasticsearch.client.ml.job.config.JobUpdate
import org.elasticsearch.common.bytes.BytesReference
import org.elasticsearch.common.xcontent.XContentType

suspend inline fun MachineLearningClient.putJobAsync(job: Job, options: RequestOptions = RequestOptions.DEFAULT, block: PutJobRequest.() -> Unit = {}): PutJobResponse =
        awaitAction { putJobAsync(job, options, it, block) }

suspend inline fun MachineLearningClient.getJobAsync(options: RequestOptions = RequestOptions.DEFAULT, block: GetJobRequest.() -> Unit = {}): GetJobResponse =
        awaitAction { getJobAsync(options, it, block) }

suspend inline fun MachineLearningClient.getJobStatsAsync(options: RequestOptions = RequestOptions.DEFAULT, block: GetJobStatsRequest.() -> Unit = {}): GetJobStatsResponse =
        awaitAction { getJobStatsAsync(options, it, block) }

suspend inline fun MachineLearningClient.deleteJobAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: DeleteJobRequest.() -> Unit = {}): DeleteJobResponse =
        awaitAction { deleteJobAsync(jobId, options, it, block) }

suspend inline fun MachineLearningClient.openJobAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: OpenJobRequest.() -> Unit = {}): OpenJobResponse =
        awaitAction { openJobAsync(jobId, options, it, block) }

suspend inline fun MachineLearningClient.closeJobAsync(options: RequestOptions = RequestOptions.DEFAULT, block: CloseJobRequest.() -> Unit = {}): CloseJobResponse =
        awaitAction { closeJobAsync(options, it, block) }

suspend inline fun MachineLearningClient.flushJobAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: FlushJobRequest.() -> Unit = {}): FlushJobResponse =
        awaitAction { flushJobAsync(jobId, options, it, block) }

suspend inline fun MachineLearningClient.forecastJobAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: ForecastJobRequest.() -> Unit = {}): ForecastJobResponse =
        awaitAction { forecastJobAsync(jobId, options, it, block) }

suspend inline fun MachineLearningClient.deleteForecastAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: DeleteForecastRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { deleteForecastAsync(jobId, options, it, block) }

suspend inline fun MachineLearningClient.putDatafeedAsync(datafeed: DatafeedConfig, options: RequestOptions = RequestOptions.DEFAULT, block: PutDatafeedRequest.() -> Unit = {}): PutDatafeedResponse =
        awaitAction { putDatafeedAsync(datafeed, options, it, block) }

suspend inline fun MachineLearningClient.getDatafeedAsync(options: RequestOptions = RequestOptions.DEFAULT, block: GetDatafeedRequest.() -> Unit = {}): GetDatafeedResponse =
        awaitAction { getDatafeedAsync(options, it, block) }

suspend inline fun MachineLearningClient.deleteDatafeedAsync(datafeedId: String, options: RequestOptions = RequestOptions.DEFAULT, block: DeleteDatafeedRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { deleteDatafeedAsync(datafeedId, options, it, block) }

suspend inline fun MachineLearningClient.startDatafeedAsync(datafeedId: String, options: RequestOptions = RequestOptions.DEFAULT, block: StartDatafeedRequest.() -> Unit = {}): StartDatafeedResponse =
        awaitAction { startDatafeedAsync(datafeedId, options, it, block) }

suspend inline fun MachineLearningClient.stopDatafeedAsync(options: RequestOptions = RequestOptions.DEFAULT, block: StopDatafeedRequest.() -> Unit = {}): StopDatafeedResponse =
        awaitAction { stopDatafeedAsync(options, it, block) }

suspend inline fun MachineLearningClient.getDatafeedStatsAsync(options: RequestOptions = RequestOptions.DEFAULT, block: GetDatafeedStatsRequest.() -> Unit = {}): GetDatafeedStatsResponse =
        awaitAction { getDatafeedStatsAsync(options, it, block) }

suspend inline fun MachineLearningClient.previewDatafeedAsync(datafeedId: String, options: RequestOptions = RequestOptions.DEFAULT, block: PreviewDatafeedRequest.() -> Unit = {}): PreviewDatafeedResponse =
        awaitAction { previewDatafeedAsync(datafeedId, options, it, block) }

suspend inline fun MachineLearningClient.updateJobAsync(update: JobUpdate, options: RequestOptions = RequestOptions.DEFAULT, block: UpdateJobRequest.() -> Unit = {}): PutJobResponse =
        awaitAction { updateJobAsync(update, options, it, block) }

suspend inline fun MachineLearningClient.getBucketsAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: GetBucketsRequest.() -> Unit = {}): GetBucketsResponse =
        awaitAction { getBucketsAsync(jobId, options, it, block) }

suspend inline fun MachineLearningClient.getCategoriesAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: GetCategoriesRequest.() -> Unit = {}): GetCategoriesResponse =
        awaitAction { getCategoriesAsync(jobId, options, it, block) }

suspend inline fun MachineLearningClient.getOverallBucketsAsync(options: RequestOptions = RequestOptions.DEFAULT, block: GetOverallBucketsRequest.() -> Unit = {}): GetOverallBucketsResponse =
        awaitAction { getOverallBucketsAsync(options, it, block) }

suspend inline fun MachineLearningClient.getRecordsAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: GetRecordsRequest.() -> Unit = {}): GetRecordsResponse =
        awaitAction { getRecordsAsync(jobId, options, it, block) }

suspend inline fun MachineLearningClient.postDataAsync(jobId: String, xContentType: XContentType, content: BytesReference, options: RequestOptions = RequestOptions.DEFAULT, block: PostDataRequest.() -> Unit = {}): PostDataResponse =
        awaitAction { postDataAsync(jobId, xContentType, content, options, it, block) }

suspend inline fun MachineLearningClient.postDataAsync(jobId: String, builder: PostDataRequest.JsonBuilder, options: RequestOptions = RequestOptions.DEFAULT, block: PostDataRequest.() -> Unit = {}): PostDataResponse =
        awaitAction { postDataAsync(jobId, builder, options, it, block) }

suspend inline fun MachineLearningClient.getCalendarsAsync(options: RequestOptions = RequestOptions.DEFAULT, block: GetCalendarsRequest.() -> Unit = {}): GetCalendarsResponse =
        awaitAction { getCalendarsAsync(options, it, block) }

suspend inline fun MachineLearningClient.getInfluencersAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: GetInfluencersRequest.() -> Unit = {}): GetInfluencersResponse =
        awaitAction { getInfluencersAsync(jobId, options, it, block) }

suspend inline fun MachineLearningClient.putCalendarAsync(calendar: Calendar, options: RequestOptions = RequestOptions.DEFAULT, block: PutCalendarRequest.() -> Unit = {}): PutCalendarResponse =
        awaitAction { putCalendarAsync(calendar, options, it, block) }

suspend inline fun MachineLearningClient.deleteCalendarAsync(calendarId: String, options: RequestOptions = RequestOptions.DEFAULT, block: DeleteCalendarRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { deleteCalendarAsync(calendarId, options, it, block) }
