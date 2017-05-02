# MediaModerationApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getModerationReport**](MediaModerationApi.md#getModerationReport) | **GET** /moderation/reports/{id} | Get a flag report
[**getModerationReports**](MediaModerationApi.md#getModerationReports) | **GET** /moderation/reports | Returns a page of flag reports
[**updateModerationReport**](MediaModerationApi.md#updateModerationReport) | **PUT** /moderation/reports/{id} | Update a flag report


<a name="getModerationReport"></a>
# **getModerationReport**
> FlagReportResource getModerationReport(id)

Get a flag report

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaModerationApi;

MediaModerationApi apiInstance = new MediaModerationApi();
Long id = 789L; // Long | The flag report id
try {
    FlagReportResource result = apiInstance.getModerationReport(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaModerationApi#getModerationReport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The flag report id |

### Return type

[**FlagReportResource**](FlagReportResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getModerationReports"></a>
# **getModerationReports**
> PageResourceFlagReportResource getModerationReports(excludeResolved, filterContext, size, page)

Returns a page of flag reports

Context can be either a free-form string or a pre-defined context name

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaModerationApi;

MediaModerationApi apiInstance = new MediaModerationApi();
Boolean excludeResolved = true; // Boolean | Ignore resolved context
String filterContext = "filterContext_example"; // String | Filter by moderation context
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceFlagReportResource result = apiInstance.getModerationReports(excludeResolved, filterContext, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaModerationApi#getModerationReports");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **excludeResolved** | **Boolean**| Ignore resolved context | [optional] [default to true]
 **filterContext** | **String**| Filter by moderation context | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceFlagReportResource**](PageResourceFlagReportResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateModerationReport"></a>
# **updateModerationReport**
> updateModerationReport(id, flagReportResource)

Update a flag report

Lets you set the resolution of a report. Resolution types is {banned,ignore} in case of &#39;banned&#39; you will need to pass the reason.

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaModerationApi;

MediaModerationApi apiInstance = new MediaModerationApi();
Long id = 789L; // Long | The flag report id
FlagReportResource flagReportResource = new FlagReportResource(); // FlagReportResource | The new flag report
try {
    apiInstance.updateModerationReport(id, flagReportResource);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaModerationApi#updateModerationReport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The flag report id |
 **flagReportResource** | [**FlagReportResource**](FlagReportResource.md)| The new flag report | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

