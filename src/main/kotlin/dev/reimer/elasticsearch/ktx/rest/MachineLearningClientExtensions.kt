@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.rest

import org.elasticsearch.action.ActionListener
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
import java.io.IOException

@Throws(IOException::class)
inline fun MachineLearningClient.putJob(job: Job, options: RequestOptions = RequestOptions.DEFAULT, block: PutJobRequest.() -> Unit = {}): PutJobResponse =
        putJob(PutJobRequest(job).apply(block), options)

inline fun MachineLearningClient.putJobAsync(job: Job, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<PutJobResponse>, block: PutJobRequest.() -> Unit = {}) =
        putJobAsync(PutJobRequest(job).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.getJob(options: RequestOptions = RequestOptions.DEFAULT, block: GetJobRequest.() -> Unit = {}): GetJobResponse =
        getJob(GetJobRequest().apply(block), options)

inline fun MachineLearningClient.getJobAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetJobResponse>, block: GetJobRequest.() -> Unit = {}) =
        getJobAsync(GetJobRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.getJobStats(options: RequestOptions = RequestOptions.DEFAULT, block: GetJobStatsRequest.() -> Unit = {}): GetJobStatsResponse =
        getJobStats(GetJobStatsRequest().apply(block), options)

inline fun MachineLearningClient.getJobStatsAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetJobStatsResponse>, block: GetJobStatsRequest.() -> Unit = {}) =
        getJobStatsAsync(GetJobStatsRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.deleteJob(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: DeleteJobRequest.() -> Unit = {}): DeleteJobResponse =
        deleteJob(DeleteJobRequest(jobId).apply(block), options)

inline fun MachineLearningClient.deleteJobAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<DeleteJobResponse>, block: DeleteJobRequest.() -> Unit = {}) =
        deleteJobAsync(DeleteJobRequest(jobId).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.openJob(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: OpenJobRequest.() -> Unit = {}): OpenJobResponse =
        openJob(OpenJobRequest(jobId).apply(block), options)

inline fun MachineLearningClient.openJobAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<OpenJobResponse>, block: OpenJobRequest.() -> Unit = {}) =
        openJobAsync(OpenJobRequest(jobId).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.closeJob(options: RequestOptions = RequestOptions.DEFAULT, block: CloseJobRequest.() -> Unit = {}): CloseJobResponse =
        closeJob(CloseJobRequest().apply(block), options)

inline fun MachineLearningClient.closeJobAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<CloseJobResponse>, block: CloseJobRequest.() -> Unit = {}) =
        closeJobAsync(CloseJobRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.flushJob(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: FlushJobRequest.() -> Unit = {}): FlushJobResponse =
        flushJob(FlushJobRequest(jobId).apply(block), options)

inline fun MachineLearningClient.flushJobAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<FlushJobResponse>, block: FlushJobRequest.() -> Unit = {}) =
        flushJobAsync(FlushJobRequest(jobId).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.forecastJob(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: ForecastJobRequest.() -> Unit = {}): ForecastJobResponse =
        forecastJob(ForecastJobRequest(jobId).apply(block), options)

inline fun MachineLearningClient.forecastJobAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<ForecastJobResponse>, block: ForecastJobRequest.() -> Unit = {}) =
        forecastJobAsync(ForecastJobRequest(jobId).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.deleteForecast(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: DeleteForecastRequest.() -> Unit = {}): AcknowledgedResponse =
        deleteForecast(DeleteForecastRequest(jobId).apply(block), options)

inline fun MachineLearningClient.deleteForecastAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: DeleteForecastRequest.() -> Unit = {}) =
        deleteForecastAsync(DeleteForecastRequest(jobId).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.putDatafeed(datafeed: DatafeedConfig, options: RequestOptions = RequestOptions.DEFAULT, block: PutDatafeedRequest.() -> Unit = {}): PutDatafeedResponse =
        putDatafeed(PutDatafeedRequest(datafeed).apply(block), options)

inline fun MachineLearningClient.putDatafeedAsync(datafeed: DatafeedConfig, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<PutDatafeedResponse>, block: PutDatafeedRequest.() -> Unit = {}) =
        putDatafeedAsync(PutDatafeedRequest(datafeed).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.getDatafeed(options: RequestOptions = RequestOptions.DEFAULT, block: GetDatafeedRequest.() -> Unit = {}): GetDatafeedResponse =
        getDatafeed(GetDatafeedRequest().apply(block), options)

inline fun MachineLearningClient.getDatafeedAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetDatafeedResponse>, block: GetDatafeedRequest.() -> Unit = {}) =
        getDatafeedAsync(GetDatafeedRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.deleteDatafeed(datafeedId: String, options: RequestOptions = RequestOptions.DEFAULT, block: DeleteDatafeedRequest.() -> Unit = {}): AcknowledgedResponse =
        deleteDatafeed(DeleteDatafeedRequest(datafeedId).apply(block), options)

inline fun MachineLearningClient.deleteDatafeedAsync(datafeedId: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: DeleteDatafeedRequest.() -> Unit = {}) =
        deleteDatafeedAsync(DeleteDatafeedRequest(datafeedId).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.startDatafeed(datafeedId: String, options: RequestOptions = RequestOptions.DEFAULT, block: StartDatafeedRequest.() -> Unit = {}): StartDatafeedResponse =
        startDatafeed(StartDatafeedRequest(datafeedId).apply(block), options)

inline fun MachineLearningClient.startDatafeedAsync(datafeedId: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<StartDatafeedResponse>, block: StartDatafeedRequest.() -> Unit = {}) =
        startDatafeedAsync(StartDatafeedRequest(datafeedId).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.stopDatafeed(options: RequestOptions = RequestOptions.DEFAULT, block: StopDatafeedRequest.() -> Unit = {}): StopDatafeedResponse =
        stopDatafeed(StopDatafeedRequest().apply(block), options)

inline fun MachineLearningClient.stopDatafeedAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<StopDatafeedResponse>, block: StopDatafeedRequest.() -> Unit = {}) =
        stopDatafeedAsync(StopDatafeedRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.getDatafeedStats(options: RequestOptions = RequestOptions.DEFAULT, block: GetDatafeedStatsRequest.() -> Unit = {}): GetDatafeedStatsResponse =
        getDatafeedStats(GetDatafeedStatsRequest().apply(block), options)

inline fun MachineLearningClient.getDatafeedStatsAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetDatafeedStatsResponse>, block: GetDatafeedStatsRequest.() -> Unit = {}) =
        getDatafeedStatsAsync(GetDatafeedStatsRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.previewDatafeed(datafeedId: String, options: RequestOptions = RequestOptions.DEFAULT, block: PreviewDatafeedRequest.() -> Unit = {}): PreviewDatafeedResponse =
        previewDatafeed(PreviewDatafeedRequest(datafeedId).apply(block), options)

inline fun MachineLearningClient.previewDatafeedAsync(datafeedId: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<PreviewDatafeedResponse>, block: PreviewDatafeedRequest.() -> Unit = {}) =
        previewDatafeedAsync(PreviewDatafeedRequest(datafeedId).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.updateJob(update: JobUpdate, options: RequestOptions = RequestOptions.DEFAULT, block: UpdateJobRequest.() -> Unit = {}): PutJobResponse =
        updateJob(UpdateJobRequest(update).apply(block), options)

inline fun MachineLearningClient.updateJobAsync(update: JobUpdate, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<PutJobResponse>, block: UpdateJobRequest.() -> Unit = {}) =
        updateJobAsync(UpdateJobRequest(update).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.getBuckets(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: GetBucketsRequest.() -> Unit = {}): GetBucketsResponse =
        getBuckets(GetBucketsRequest(jobId).apply(block), options)

inline fun MachineLearningClient.getBucketsAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetBucketsResponse>, block: GetBucketsRequest.() -> Unit = {}) =
        getBucketsAsync(GetBucketsRequest(jobId).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.getCategories(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: GetCategoriesRequest.() -> Unit = {}): GetCategoriesResponse =
        getCategories(GetCategoriesRequest(jobId).apply(block), options)

inline fun MachineLearningClient.getCategoriesAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetCategoriesResponse>, block: GetCategoriesRequest.() -> Unit = {}) =
        getCategoriesAsync(GetCategoriesRequest(jobId).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.getOverallBuckets(options: RequestOptions = RequestOptions.DEFAULT, block: GetOverallBucketsRequest.() -> Unit = {}): GetOverallBucketsResponse =
        getOverallBuckets(GetOverallBucketsRequest().apply(block), options)

inline fun MachineLearningClient.getOverallBucketsAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetOverallBucketsResponse>, block: GetOverallBucketsRequest.() -> Unit = {}) =
        getOverallBucketsAsync(GetOverallBucketsRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.getRecords(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: GetRecordsRequest.() -> Unit = {}): GetRecordsResponse =
        getRecords(GetRecordsRequest(jobId).apply(block), options)

inline fun MachineLearningClient.getRecordsAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetRecordsResponse>, block: GetRecordsRequest.() -> Unit = {}) =
        getRecordsAsync(GetRecordsRequest(jobId).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.postData(jobId: String, xContentType: XContentType, content: BytesReference, options: RequestOptions = RequestOptions.DEFAULT, block: PostDataRequest.() -> Unit = {}): PostDataResponse =
        postData(PostDataRequest(jobId, xContentType, content).apply(block), options)

@Throws(IOException::class)
inline fun MachineLearningClient.postData(jobId: String, builder: PostDataRequest.JsonBuilder, options: RequestOptions = RequestOptions.DEFAULT, block: PostDataRequest.() -> Unit = {}): PostDataResponse =
        postData(PostDataRequest(jobId, builder).apply(block), options)

inline fun MachineLearningClient.postDataAsync(jobId: String, xContentType: XContentType, content: BytesReference, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<PostDataResponse>, block: PostDataRequest.() -> Unit = {}) =
        postDataAsync(PostDataRequest(jobId, xContentType, content).apply(block), options, listener)

inline fun MachineLearningClient.postDataAsync(jobId: String, builder: PostDataRequest.JsonBuilder, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<PostDataResponse>, block: PostDataRequest.() -> Unit = {}) =
        postDataAsync(PostDataRequest(jobId, builder).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.getCalendars(options: RequestOptions = RequestOptions.DEFAULT, block: GetCalendarsRequest.() -> Unit = {}): GetCalendarsResponse =
        getCalendars(GetCalendarsRequest().apply(block), options)

inline fun MachineLearningClient.getCalendarsAsync(options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetCalendarsResponse>, block: GetCalendarsRequest.() -> Unit = {}) =
        getCalendarsAsync(GetCalendarsRequest().apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.getInfluencers(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, block: GetInfluencersRequest.() -> Unit = {}): GetInfluencersResponse =
        getInfluencers(GetInfluencersRequest(jobId).apply(block), options)

inline fun MachineLearningClient.getInfluencersAsync(jobId: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<GetInfluencersResponse>, block: GetInfluencersRequest.() -> Unit = {}) =
        getInfluencersAsync(GetInfluencersRequest(jobId).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.putCalendar(calendar: Calendar, options: RequestOptions = RequestOptions.DEFAULT, block: PutCalendarRequest.() -> Unit = {}): PutCalendarResponse =
        putCalendar(PutCalendarRequest(calendar).apply(block), options)

inline fun MachineLearningClient.putCalendarAsync(calendar: Calendar, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<PutCalendarResponse>, block: PutCalendarRequest.() -> Unit = {}) =
        putCalendarAsync(PutCalendarRequest(calendar).apply(block), options, listener)

@Throws(IOException::class)
inline fun MachineLearningClient.deleteCalendar(calendarId: String, options: RequestOptions = RequestOptions.DEFAULT, block: DeleteCalendarRequest.() -> Unit = {}): AcknowledgedResponse =
        deleteCalendar(DeleteCalendarRequest(calendarId).apply(block), options)

inline fun MachineLearningClient.deleteCalendarAsync(calendarId: String, options: RequestOptions = RequestOptions.DEFAULT, listener: ActionListener<AcknowledgedResponse>, block: DeleteCalendarRequest.() -> Unit = {}) =
        deleteCalendarAsync(DeleteCalendarRequest(calendarId).apply(block), options, listener)
