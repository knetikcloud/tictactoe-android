# ReportingOrdersApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getInvoiceReports**](ReportingOrdersApi.md#getInvoiceReports) | **GET** /reporting/orders/count/{currency_code} | Retrieve invoice counts aggregated by time ranges


<a name="getInvoiceReports"></a>
# **getInvoiceReports**
> PageResourceAggregateInvoiceReportResource getInvoiceReports(currencyCode, granularity, filterPaymentStatus, filterFulfillmentStatus, startDate, endDate)

Retrieve invoice counts aggregated by time ranges

### Example
```java
// Import classes:
//import com.knetikcloud.api.ReportingOrdersApi;

ReportingOrdersApi apiInstance = new ReportingOrdersApi();
String currencyCode = "currencyCode_example"; // String | The code for a currency to get sales data for
String granularity = "day"; // String | The time duration to aggregate by
String filterPaymentStatus = "filterPaymentStatus_example"; // String | A payment status to filter results by, can be a comma separated list
String filterFulfillmentStatus = "filterFulfillmentStatus_example"; // String | An invoice fulfillment status to filter results by, can be a comma separated list
Long startDate = 789L; // Long | The start of the time range to return, unix timestamp in seconds. Default is beginning of time
Long endDate = 789L; // Long | The end of the time range to return, unix timestamp in seconds. Default is end of time
try {
    PageResourceAggregateInvoiceReportResource result = apiInstance.getInvoiceReports(currencyCode, granularity, filterPaymentStatus, filterFulfillmentStatus, startDate, endDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingOrdersApi#getInvoiceReports");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **currencyCode** | **String**| The code for a currency to get sales data for |
 **granularity** | **String**| The time duration to aggregate by | [optional] [default to day] [enum: millisecond, second, minute, hour, day, week, month, year]
 **filterPaymentStatus** | **String**| A payment status to filter results by, can be a comma separated list | [optional]
 **filterFulfillmentStatus** | **String**| An invoice fulfillment status to filter results by, can be a comma separated list | [optional]
 **startDate** | **Long**| The start of the time range to return, unix timestamp in seconds. Default is beginning of time | [optional]
 **endDate** | **Long**| The end of the time range to return, unix timestamp in seconds. Default is end of time | [optional]

### Return type

[**PageResourceAggregateInvoiceReportResource**](PageResourceAggregateInvoiceReportResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

