# ReportingRevenueApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getItemRevenue**](ReportingRevenueApi.md#getItemRevenue) | **GET** /reporting/revenue/item-sales/{currency_code} | Get item revenue info
[**getRefundRevenue**](ReportingRevenueApi.md#getRefundRevenue) | **GET** /reporting/revenue/refunds/{currency_code} | Get refund revenue info
[**getRevenueByCountry**](ReportingRevenueApi.md#getRevenueByCountry) | **GET** /reporting/revenue/countries/{currency_code} | Get revenue info by country
[**getRevenueByItem**](ReportingRevenueApi.md#getRevenueByItem) | **GET** /reporting/revenue/products/{currency_code} | Get revenue info by item
[**getSubscriptionRevenue**](ReportingRevenueApi.md#getSubscriptionRevenue) | **GET** /reporting/revenue/subscription-sales/{currency_code} | Get subscription revenue info


<a name="getItemRevenue"></a>
# **getItemRevenue**
> RevenueReportResource getItemRevenue(currencyCode, startDate, endDate)

Get item revenue info

Get basic info about revenue from sales of items and bundles (not subscriptions, shipping, etc), summed up within a time range

### Example
```java
// Import classes:
//import com.knetikcloud.api.ReportingRevenueApi;

ReportingRevenueApi apiInstance = new ReportingRevenueApi();
String currencyCode = "currencyCode_example"; // String | The code for a currency to get sales data for
Long startDate = 789L; // Long | The start of the time range to aggregate, unix timestamp in seconds. Default is beginning of time
Long endDate = 789L; // Long | The end of the time range to aggregate, unix timestamp in seconds. Default is end of time
try {
    RevenueReportResource result = apiInstance.getItemRevenue(currencyCode, startDate, endDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingRevenueApi#getItemRevenue");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **currencyCode** | **String**| The code for a currency to get sales data for |
 **startDate** | **Long**| The start of the time range to aggregate, unix timestamp in seconds. Default is beginning of time | [optional]
 **endDate** | **Long**| The end of the time range to aggregate, unix timestamp in seconds. Default is end of time | [optional]

### Return type

[**RevenueReportResource**](RevenueReportResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getRefundRevenue"></a>
# **getRefundRevenue**
> RevenueReportResource getRefundRevenue(currencyCode, startDate, endDate)

Get refund revenue info

Get basic info about revenue loss from refunds (for all item types), summed up within a time range.

### Example
```java
// Import classes:
//import com.knetikcloud.api.ReportingRevenueApi;

ReportingRevenueApi apiInstance = new ReportingRevenueApi();
String currencyCode = "currencyCode_example"; // String | The code for a currency to get refund data for
Long startDate = 789L; // Long | The start of the time range to aggregate, unix timestamp in seconds. Default is beginning of time
Long endDate = 789L; // Long | The end of the time range to aggregate, unix timestamp in seconds. Default is end of time
try {
    RevenueReportResource result = apiInstance.getRefundRevenue(currencyCode, startDate, endDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingRevenueApi#getRefundRevenue");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **currencyCode** | **String**| The code for a currency to get refund data for |
 **startDate** | **Long**| The start of the time range to aggregate, unix timestamp in seconds. Default is beginning of time | [optional]
 **endDate** | **Long**| The end of the time range to aggregate, unix timestamp in seconds. Default is end of time | [optional]

### Return type

[**RevenueReportResource**](RevenueReportResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getRevenueByCountry"></a>
# **getRevenueByCountry**
> PageResourceRevenueCountryReportResource getRevenueByCountry(currencyCode, startDate, endDate, size, page)

Get revenue info by country

Get basic info about revenue from sales of all types, summed up within a time range and split out by country. Sorted for largest revenue at the top

### Example
```java
// Import classes:
//import com.knetikcloud.api.ReportingRevenueApi;

ReportingRevenueApi apiInstance = new ReportingRevenueApi();
String currencyCode = "currencyCode_example"; // String | The code for a currency to get sales data for
Long startDate = 789L; // Long | The start of the time range to aggregate, unix timestamp in seconds. Default is beginning of time
Long endDate = 789L; // Long | The end of the time range to aggregate, unix timestamp in seconds. Default is end of time
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceRevenueCountryReportResource result = apiInstance.getRevenueByCountry(currencyCode, startDate, endDate, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingRevenueApi#getRevenueByCountry");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **currencyCode** | **String**| The code for a currency to get sales data for |
 **startDate** | **Long**| The start of the time range to aggregate, unix timestamp in seconds. Default is beginning of time | [optional]
 **endDate** | **Long**| The end of the time range to aggregate, unix timestamp in seconds. Default is end of time | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceRevenueCountryReportResource**](PageResourceRevenueCountryReportResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getRevenueByItem"></a>
# **getRevenueByItem**
> PageResourceRevenueProductReportResource getRevenueByItem(currencyCode, startDate, endDate, size, page)

Get revenue info by item

Get basic info about revenue from sales of all types, summed up within a time range and split out by specific item. Sorted for largest revenue at the top

### Example
```java
// Import classes:
//import com.knetikcloud.api.ReportingRevenueApi;

ReportingRevenueApi apiInstance = new ReportingRevenueApi();
String currencyCode = "currencyCode_example"; // String | The code for a currency to get sales data for
Long startDate = 789L; // Long | The start of the time range to aggregate, unix timestamp in seconds. Default is beginning of time
Long endDate = 789L; // Long | The end of the time range to aggregate, unix timestamp in seconds. Default is end of time
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceRevenueProductReportResource result = apiInstance.getRevenueByItem(currencyCode, startDate, endDate, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingRevenueApi#getRevenueByItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **currencyCode** | **String**| The code for a currency to get sales data for |
 **startDate** | **Long**| The start of the time range to aggregate, unix timestamp in seconds. Default is beginning of time | [optional]
 **endDate** | **Long**| The end of the time range to aggregate, unix timestamp in seconds. Default is end of time | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceRevenueProductReportResource**](PageResourceRevenueProductReportResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSubscriptionRevenue"></a>
# **getSubscriptionRevenue**
> RevenueReportResource getSubscriptionRevenue(currencyCode, startDate, endDate)

Get subscription revenue info

Get basic info about revenue from sales of new subscriptions as well as recurring payemnts, summed up within a time range

### Example
```java
// Import classes:
//import com.knetikcloud.api.ReportingRevenueApi;

ReportingRevenueApi apiInstance = new ReportingRevenueApi();
String currencyCode = "currencyCode_example"; // String | The code for a currency to get sales data for
Long startDate = 789L; // Long | The start of the time range to aggregate, unix timestamp in seconds. Default is beginning of time
Long endDate = 789L; // Long | The end of the time range to aggregate, unix timestamp in seconds. Default is end of time
try {
    RevenueReportResource result = apiInstance.getSubscriptionRevenue(currencyCode, startDate, endDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingRevenueApi#getSubscriptionRevenue");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **currencyCode** | **String**| The code for a currency to get sales data for |
 **startDate** | **Long**| The start of the time range to aggregate, unix timestamp in seconds. Default is beginning of time | [optional]
 **endDate** | **Long**| The end of the time range to aggregate, unix timestamp in seconds. Default is end of time | [optional]

### Return type

[**RevenueReportResource**](RevenueReportResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

