# DispositionsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addDisposition**](DispositionsApi.md#addDisposition) | **POST** /dispositions | Add a new disposition
[**deleteDisposition**](DispositionsApi.md#deleteDisposition) | **DELETE** /dispositions/{id} | Delete a disposition
[**getDisposition**](DispositionsApi.md#getDisposition) | **GET** /dispositions/{id} | Returns a disposition
[**getDispositionCounts**](DispositionsApi.md#getDispositionCounts) | **GET** /dispositions/count | Returns a list of disposition counts
[**getDispositions**](DispositionsApi.md#getDispositions) | **GET** /dispositions | Returns a page of dispositions


<a name="addDisposition"></a>
# **addDisposition**
> DispositionResource addDisposition(disposition)

Add a new disposition

### Example
```java
// Import classes:
//import com.knetikcloud.api.DispositionsApi;

DispositionsApi apiInstance = new DispositionsApi();
DispositionResource disposition = new DispositionResource(); // DispositionResource | The new disposition record
try {
    DispositionResource result = apiInstance.addDisposition(disposition);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DispositionsApi#addDisposition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **disposition** | [**DispositionResource**](DispositionResource.md)| The new disposition record | [optional]

### Return type

[**DispositionResource**](DispositionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteDisposition"></a>
# **deleteDisposition**
> deleteDisposition(id)

Delete a disposition

### Example
```java
// Import classes:
//import com.knetikcloud.api.DispositionsApi;

DispositionsApi apiInstance = new DispositionsApi();
Long id = 789L; // Long | The id of the disposition record
try {
    apiInstance.deleteDisposition(id);
} catch (ApiException e) {
    System.err.println("Exception when calling DispositionsApi#deleteDisposition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The id of the disposition record |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getDisposition"></a>
# **getDisposition**
> DispositionResource getDisposition(id)

Returns a disposition

### Example
```java
// Import classes:
//import com.knetikcloud.api.DispositionsApi;

DispositionsApi apiInstance = new DispositionsApi();
Long id = 789L; // Long | The id of the disposition record
try {
    DispositionResource result = apiInstance.getDisposition(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DispositionsApi#getDisposition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The id of the disposition record |

### Return type

[**DispositionResource**](DispositionResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getDispositionCounts"></a>
# **getDispositionCounts**
> List&lt;DispositionCount&gt; getDispositionCounts(filterContext, filterOwner)

Returns a list of disposition counts

### Example
```java
// Import classes:
//import com.knetikcloud.api.DispositionsApi;

DispositionsApi apiInstance = new DispositionsApi();
String filterContext = "filterContext_example"; // String | Filter for dispositions within a context type (games, articles, polls, etc). Optionally with a specific id like filter_context=video:47
String filterOwner = "filterOwner_example"; // String | Filter for dispositions from a specific user by id or 'me'
try {
    List<DispositionCount> result = apiInstance.getDispositionCounts(filterContext, filterOwner);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DispositionsApi#getDispositionCounts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterContext** | **String**| Filter for dispositions within a context type (games, articles, polls, etc). Optionally with a specific id like filter_context&#x3D;video:47 | [optional]
 **filterOwner** | **String**| Filter for dispositions from a specific user by id or &#39;me&#39; | [optional]

### Return type

[**List&lt;DispositionCount&gt;**](DispositionCount.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getDispositions"></a>
# **getDispositions**
> PageResourceDispositionResource getDispositions(filterContext, filterOwner, size, page, order)

Returns a page of dispositions

### Example
```java
// Import classes:
//import com.knetikcloud.api.DispositionsApi;

DispositionsApi apiInstance = new DispositionsApi();
String filterContext = "filterContext_example"; // String | Filter for dispositions within a context type (games, articles, polls, etc). Optionally with a specific id like filter_context=video:47
String filterOwner = "filterOwner_example"; // String | Filter for dispositions from a specific user by id or 'me'
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceDispositionResource result = apiInstance.getDispositions(filterContext, filterOwner, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DispositionsApi#getDispositions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterContext** | **String**| Filter for dispositions within a context type (games, articles, polls, etc). Optionally with a specific id like filter_context&#x3D;video:47 | [optional]
 **filterOwner** | **String**| Filter for dispositions from a specific user by id or &#39;me&#39; | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceDispositionResource**](PageResourceDispositionResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

