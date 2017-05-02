# LogsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addUserLog**](LogsApi.md#addUserLog) | **POST** /audit/logs | Add a user log entry
[**getBREEventLog**](LogsApi.md#getBREEventLog) | **GET** /bre/logs/event-log/{id} | Get an existing BRE event log entry by id
[**getBREEventLogs**](LogsApi.md#getBREEventLogs) | **GET** /bre/logs/event-log | Returns a list of BRE event log entries
[**getBREForwardLog**](LogsApi.md#getBREForwardLog) | **GET** /bre/logs/forward-log/{id} | Get an existing forward log entry by id
[**getBREForwardLogs**](LogsApi.md#getBREForwardLogs) | **GET** /bre/logs/forward-log | Returns a list of forward log entries
[**getUserLog**](LogsApi.md#getUserLog) | **GET** /audit/logs/{id} | Returns a user log entry by id
[**getUserLogs**](LogsApi.md#getUserLogs) | **GET** /audit/logs | Returns a page of user logs entries


<a name="addUserLog"></a>
# **addUserLog**
> addUserLog(logEntry)

Add a user log entry

### Example
```java
// Import classes:
//import com.knetikcloud.api.LogsApi;

LogsApi apiInstance = new LogsApi();
UserActionLog logEntry = new UserActionLog(); // UserActionLog | The user log entry to be added
try {
    apiInstance.addUserLog(logEntry);
} catch (ApiException e) {
    System.err.println("Exception when calling LogsApi#addUserLog");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **logEntry** | [**UserActionLog**](UserActionLog.md)| The user log entry to be added | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getBREEventLog"></a>
# **getBREEventLog**
> BreEventLog getBREEventLog(id)

Get an existing BRE event log entry by id

### Example
```java
// Import classes:
//import com.knetikcloud.api.LogsApi;

LogsApi apiInstance = new LogsApi();
String id = "id_example"; // String | The BRE event log entry id
try {
    BreEventLog result = apiInstance.getBREEventLog(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LogsApi#getBREEventLog");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The BRE event log entry id |

### Return type

[**BreEventLog**](BreEventLog.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getBREEventLogs"></a>
# **getBREEventLogs**
> PageResourceBreEventLog getBREEventLogs(filterStartDate, filterEventName, size, page, order)

Returns a list of BRE event log entries

### Example
```java
// Import classes:
//import com.knetikcloud.api.LogsApi;

LogsApi apiInstance = new LogsApi();
String filterStartDate = "filterStartDate_example"; // String | A comma separated string without spaces.  First value is the operator to search on, second value is the event log start date, a unix timestamp in seconds.  Allowed operators: (GT, LT, EQ, GOE, LOE).
String filterEventName = "filterEventName_example"; // String | Filter event logs by event name
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:DESC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceBreEventLog result = apiInstance.getBREEventLogs(filterStartDate, filterEventName, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LogsApi#getBREEventLogs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterStartDate** | **String**| A comma separated string without spaces.  First value is the operator to search on, second value is the event log start date, a unix timestamp in seconds.  Allowed operators: (GT, LT, EQ, GOE, LOE). | [optional]
 **filterEventName** | **String**| Filter event logs by event name | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:DESC]

### Return type

[**PageResourceBreEventLog**](PageResourceBreEventLog.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getBREForwardLog"></a>
# **getBREForwardLog**
> ForwardLog getBREForwardLog(id)

Get an existing forward log entry by id

### Example
```java
// Import classes:
//import com.knetikcloud.api.LogsApi;

LogsApi apiInstance = new LogsApi();
String id = "id_example"; // String | The forward log entry id
try {
    ForwardLog result = apiInstance.getBREForwardLog(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LogsApi#getBREForwardLog");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The forward log entry id |

### Return type

[**ForwardLog**](ForwardLog.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getBREForwardLogs"></a>
# **getBREForwardLogs**
> PageResourceForwardLog getBREForwardLogs(filterStartDate, filterEndDate, filterStatusCode, size, page, order)

Returns a list of forward log entries

### Example
```java
// Import classes:
//import com.knetikcloud.api.LogsApi;

LogsApi apiInstance = new LogsApi();
String filterStartDate = "filterStartDate_example"; // String | A comma separated string without spaces.  First value is the operator to search on, second value is the log start date, a unix timestamp in seconds.  Allowed operators: (GT, LT, EQ, GOE, LOE).
String filterEndDate = "filterEndDate_example"; // String | A comma separated string without spaces.  First value is the operator to search on, second value is the log end date, a unix timestamp in seconds.  Allowed operators: (GT, LT, EQ, GOE, LOE).
Integer filterStatusCode = 56; // Integer | Filter forward logs by http status code
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:DESC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceForwardLog result = apiInstance.getBREForwardLogs(filterStartDate, filterEndDate, filterStatusCode, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LogsApi#getBREForwardLogs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterStartDate** | **String**| A comma separated string without spaces.  First value is the operator to search on, second value is the log start date, a unix timestamp in seconds.  Allowed operators: (GT, LT, EQ, GOE, LOE). | [optional]
 **filterEndDate** | **String**| A comma separated string without spaces.  First value is the operator to search on, second value is the log end date, a unix timestamp in seconds.  Allowed operators: (GT, LT, EQ, GOE, LOE). | [optional]
 **filterStatusCode** | **Integer**| Filter forward logs by http status code | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:DESC]

### Return type

[**PageResourceForwardLog**](PageResourceForwardLog.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserLog"></a>
# **getUserLog**
> UserActionLog getUserLog(id)

Returns a user log entry by id

### Example
```java
// Import classes:
//import com.knetikcloud.api.LogsApi;

LogsApi apiInstance = new LogsApi();
String id = "id_example"; // String | The user log entry id
try {
    UserActionLog result = apiInstance.getUserLog(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LogsApi#getUserLog");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The user log entry id |

### Return type

[**UserActionLog**](UserActionLog.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserLogs"></a>
# **getUserLogs**
> PageResourceUserActionLog getUserLogs(filterUser, filterActionName, size, page)

Returns a page of user logs entries

### Example
```java
// Import classes:
//import com.knetikcloud.api.LogsApi;

LogsApi apiInstance = new LogsApi();
Integer filterUser = 56; // Integer | Filter for actions taken by a specific user by id
String filterActionName = "filterActionName_example"; // String | Filter for actions of a specific name
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceUserActionLog result = apiInstance.getUserLogs(filterUser, filterActionName, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LogsApi#getUserLogs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterUser** | **Integer**| Filter for actions taken by a specific user by id | [optional]
 **filterActionName** | **String**| Filter for actions of a specific name | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceUserActionLog**](PageResourceUserActionLog.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

