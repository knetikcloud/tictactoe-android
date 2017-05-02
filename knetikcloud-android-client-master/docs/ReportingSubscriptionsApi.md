# ReportingSubscriptionsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getSubscriptionReports**](ReportingSubscriptionsApi.md#getSubscriptionReports) | **GET** /reporting/subscription | Get a list of available subscription reports in most recent first order


<a name="getSubscriptionReports"></a>
# **getSubscriptionReports**
> PageResourceBillingReport getSubscriptionReports(size, page)

Get a list of available subscription reports in most recent first order

### Example
```java
// Import classes:
//import com.knetikcloud.api.ReportingSubscriptionsApi;

ReportingSubscriptionsApi apiInstance = new ReportingSubscriptionsApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceBillingReport result = apiInstance.getSubscriptionReports(size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingSubscriptionsApi#getSubscriptionReports");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceBillingReport**](PageResourceBillingReport.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

