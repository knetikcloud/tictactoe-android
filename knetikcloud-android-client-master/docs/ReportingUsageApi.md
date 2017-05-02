# ReportingUsageApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getUsageByDay**](ReportingUsageApi.md#getUsageByDay) | **GET** /reporting/usage/day | Returns aggregated endpoint usage information by day
[**getUsageByHour**](ReportingUsageApi.md#getUsageByHour) | **GET** /reporting/usage/hour | Returns aggregated endpoint usage information by hour
[**getUsageByMinute**](ReportingUsageApi.md#getUsageByMinute) | **GET** /reporting/usage/minute | Returns aggregated endpoint usage information by minute
[**getUsageByMonth**](ReportingUsageApi.md#getUsageByMonth) | **GET** /reporting/usage/month | Returns aggregated endpoint usage information by month
[**getUsageByYear**](ReportingUsageApi.md#getUsageByYear) | **GET** /reporting/usage/year | Returns aggregated endpoint usage information by year
[**getUsageEndpoints**](ReportingUsageApi.md#getUsageEndpoints) | **GET** /reporting/usage/endpoints | Returns list of endpoints called (method and url)


<a name="getUsageByDay"></a>
# **getUsageByDay**
> PageResourceUsageInfo getUsageByDay(startDate, endDate, combineEndpoints, method, url, size, page)

Returns aggregated endpoint usage information by day

### Example
```java
// Import classes:
//import com.knetikcloud.api.ReportingUsageApi;

ReportingUsageApi apiInstance = new ReportingUsageApi();
Long startDate = 789L; // Long | The beginning of the range being requested, unix timestamp in seconds
Long endDate = 789L; // Long | The ending of the range being requested, unix timestamp in seconds
Boolean combineEndpoints = false; // Boolean | Whether to combine counts from different endpoint. Removes the url and method from the result object
String method = "method_example"; // String | Filter for a certain endpoint method.  Must include url as well to work
String url = "url_example"; // String | Filter for a certain endpoint.  Must include method as well to work
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceUsageInfo result = apiInstance.getUsageByDay(startDate, endDate, combineEndpoints, method, url, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingUsageApi#getUsageByDay");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startDate** | **Long**| The beginning of the range being requested, unix timestamp in seconds |
 **endDate** | **Long**| The ending of the range being requested, unix timestamp in seconds |
 **combineEndpoints** | **Boolean**| Whether to combine counts from different endpoint. Removes the url and method from the result object | [optional] [default to false]
 **method** | **String**| Filter for a certain endpoint method.  Must include url as well to work | [optional] [enum: GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE]
 **url** | **String**| Filter for a certain endpoint.  Must include method as well to work | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceUsageInfo**](PageResourceUsageInfo.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUsageByHour"></a>
# **getUsageByHour**
> PageResourceUsageInfo getUsageByHour(startDate, endDate, combineEndpoints, method, url, size, page)

Returns aggregated endpoint usage information by hour

### Example
```java
// Import classes:
//import com.knetikcloud.api.ReportingUsageApi;

ReportingUsageApi apiInstance = new ReportingUsageApi();
Long startDate = 789L; // Long | The beginning of the range being requested, unix timestamp in seconds
Long endDate = 789L; // Long | The ending of the range being requested, unix timestamp in seconds
Boolean combineEndpoints = false; // Boolean | Whether to combine counts from different endpoint. Removes the url and method from the result object
String method = "method_example"; // String | Filter for a certain endpoint method.  Must include url as well to work
String url = "url_example"; // String | Filter for a certain endpoint.  Must include method as well to work
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceUsageInfo result = apiInstance.getUsageByHour(startDate, endDate, combineEndpoints, method, url, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingUsageApi#getUsageByHour");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startDate** | **Long**| The beginning of the range being requested, unix timestamp in seconds |
 **endDate** | **Long**| The ending of the range being requested, unix timestamp in seconds |
 **combineEndpoints** | **Boolean**| Whether to combine counts from different endpoint. Removes the url and method from the result object | [optional] [default to false]
 **method** | **String**| Filter for a certain endpoint method.  Must include url as well to work | [optional] [enum: GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE]
 **url** | **String**| Filter for a certain endpoint.  Must include method as well to work | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceUsageInfo**](PageResourceUsageInfo.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUsageByMinute"></a>
# **getUsageByMinute**
> PageResourceUsageInfo getUsageByMinute(startDate, endDate, combineEndpoints, method, url, size, page)

Returns aggregated endpoint usage information by minute

### Example
```java
// Import classes:
//import com.knetikcloud.api.ReportingUsageApi;

ReportingUsageApi apiInstance = new ReportingUsageApi();
Long startDate = 789L; // Long | The beginning of the range being requested, unix timestamp in seconds
Long endDate = 789L; // Long | The ending of the range being requested, unix timestamp in seconds
Boolean combineEndpoints = false; // Boolean | Whether to combine counts from different endpoint. Removes the url and method from the result object
String method = "method_example"; // String | Filter for a certain endpoint method.  Must include url as well to work
String url = "url_example"; // String | Filter for a certain endpoint.  Must include method as well to work
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceUsageInfo result = apiInstance.getUsageByMinute(startDate, endDate, combineEndpoints, method, url, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingUsageApi#getUsageByMinute");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startDate** | **Long**| The beginning of the range being requested, unix timestamp in seconds |
 **endDate** | **Long**| The ending of the range being requested, unix timestamp in seconds |
 **combineEndpoints** | **Boolean**| Whether to combine counts from different endpoint. Removes the url and method from the result object | [optional] [default to false]
 **method** | **String**| Filter for a certain endpoint method.  Must include url as well to work | [optional] [enum: GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE]
 **url** | **String**| Filter for a certain endpoint.  Must include method as well to work | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceUsageInfo**](PageResourceUsageInfo.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUsageByMonth"></a>
# **getUsageByMonth**
> PageResourceUsageInfo getUsageByMonth(startDate, endDate, combineEndpoints, method, url, size, page)

Returns aggregated endpoint usage information by month

### Example
```java
// Import classes:
//import com.knetikcloud.api.ReportingUsageApi;

ReportingUsageApi apiInstance = new ReportingUsageApi();
Long startDate = 789L; // Long | The beginning of the range being requested, unix timestamp in seconds
Long endDate = 789L; // Long | The ending of the range being requested, unix timestamp in seconds
Boolean combineEndpoints = false; // Boolean | Whether to combine counts from different endpoint. Removes the url and method from the result object
String method = "method_example"; // String | Filter for a certain endpoint method.  Must include url as well to work
String url = "url_example"; // String | Filter for a certain endpoint.  Must include method as well to work
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceUsageInfo result = apiInstance.getUsageByMonth(startDate, endDate, combineEndpoints, method, url, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingUsageApi#getUsageByMonth");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startDate** | **Long**| The beginning of the range being requested, unix timestamp in seconds |
 **endDate** | **Long**| The ending of the range being requested, unix timestamp in seconds |
 **combineEndpoints** | **Boolean**| Whether to combine counts from different endpoint. Removes the url and method from the result object | [optional] [default to false]
 **method** | **String**| Filter for a certain endpoint method.  Must include url as well to work | [optional] [enum: GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE]
 **url** | **String**| Filter for a certain endpoint.  Must include method as well to work | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceUsageInfo**](PageResourceUsageInfo.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUsageByYear"></a>
# **getUsageByYear**
> PageResourceUsageInfo getUsageByYear(startDate, endDate, combineEndpoints, method, url, size, page)

Returns aggregated endpoint usage information by year

### Example
```java
// Import classes:
//import com.knetikcloud.api.ReportingUsageApi;

ReportingUsageApi apiInstance = new ReportingUsageApi();
Long startDate = 789L; // Long | The beginning of the range being requested, unix timestamp in seconds
Long endDate = 789L; // Long | The ending of the range being requested, unix timestamp in seconds
Boolean combineEndpoints = false; // Boolean | Whether to combine counts from different endpoints. Removes the url and method from the result object
String method = "method_example"; // String | Filter for a certain endpoint method.  Must include url as well to work
String url = "url_example"; // String | Filter for a certain endpoint.  Must include method as well to work
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceUsageInfo result = apiInstance.getUsageByYear(startDate, endDate, combineEndpoints, method, url, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingUsageApi#getUsageByYear");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startDate** | **Long**| The beginning of the range being requested, unix timestamp in seconds |
 **endDate** | **Long**| The ending of the range being requested, unix timestamp in seconds |
 **combineEndpoints** | **Boolean**| Whether to combine counts from different endpoints. Removes the url and method from the result object | [optional] [default to false]
 **method** | **String**| Filter for a certain endpoint method.  Must include url as well to work | [optional] [enum: GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE]
 **url** | **String**| Filter for a certain endpoint.  Must include method as well to work | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceUsageInfo**](PageResourceUsageInfo.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUsageEndpoints"></a>
# **getUsageEndpoints**
> List&lt;String&gt; getUsageEndpoints(startDate, endDate)

Returns list of endpoints called (method and url)

### Example
```java
// Import classes:
//import com.knetikcloud.api.ReportingUsageApi;

ReportingUsageApi apiInstance = new ReportingUsageApi();
Long startDate = 789L; // Long | The beginning of the range being requested, unix timestamp in seconds
Long endDate = 789L; // Long | The ending of the range being requested, unix timestamp in seconds
try {
    List<String> result = apiInstance.getUsageEndpoints(startDate, endDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingUsageApi#getUsageEndpoints");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startDate** | **Long**| The beginning of the range being requested, unix timestamp in seconds |
 **endDate** | **Long**| The ending of the range being requested, unix timestamp in seconds |

### Return type

**List&lt;String&gt;**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

