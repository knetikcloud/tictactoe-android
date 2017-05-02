# GamificationMetricsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addMetric**](GamificationMetricsApi.md#addMetric) | **POST** /metrics | Add a metric


<a name="addMetric"></a>
# **addMetric**
> addMetric(metric)

Add a metric

Post a new score/stat for an activity occurrence without ending the occurrence itself

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationMetricsApi;

GamificationMetricsApi apiInstance = new GamificationMetricsApi();
MetricResource metric = new MetricResource(); // MetricResource | The new metric
try {
    apiInstance.addMetric(metric);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationMetricsApi#addMetric");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **metric** | [**MetricResource**](MetricResource.md)| The new metric | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

