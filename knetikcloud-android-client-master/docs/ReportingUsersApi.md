# ReportingUsersApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getUserRegistrations**](ReportingUsersApi.md#getUserRegistrations) | **GET** /reporting/users/registrations | Get user registration info


<a name="getUserRegistrations"></a>
# **getUserRegistrations**
> PageResourceAggregateCountResource getUserRegistrations(granularity, startDate, endDate)

Get user registration info

Get user registration counts grouped by time range

### Example
```java
// Import classes:
//import com.knetikcloud.api.ReportingUsersApi;

ReportingUsersApi apiInstance = new ReportingUsersApi();
String granularity = "day"; // String | The time duration to aggregate by
Long startDate = 789L; // Long | The start of the time range to aggregate, unix timestamp in seconds. Default is beginning of time
Long endDate = 789L; // Long | The end of the time range to aggregate, unix timestamp in seconds. Default is end of time
try {
    PageResourceAggregateCountResource result = apiInstance.getUserRegistrations(granularity, startDate, endDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingUsersApi#getUserRegistrations");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **granularity** | **String**| The time duration to aggregate by | [optional] [default to day] [enum: millisecond, second, minute, hour, day, week, month, year]
 **startDate** | **Long**| The start of the time range to aggregate, unix timestamp in seconds. Default is beginning of time | [optional]
 **endDate** | **Long**| The end of the time range to aggregate, unix timestamp in seconds. Default is end of time | [optional]

### Return type

[**PageResourceAggregateCountResource**](PageResourceAggregateCountResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

