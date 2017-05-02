# FulfillmentApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createFulfillmentType**](FulfillmentApi.md#createFulfillmentType) | **POST** /store/fulfillment/types | Create a fulfillment type
[**deleteFulfillmentType**](FulfillmentApi.md#deleteFulfillmentType) | **DELETE** /store/fulfillment/types/{id} | Delete a fulfillment type
[**getFulfillmentType**](FulfillmentApi.md#getFulfillmentType) | **GET** /store/fulfillment/types/{id} | Get a single fulfillment type
[**getFulfillmentTypes**](FulfillmentApi.md#getFulfillmentTypes) | **GET** /store/fulfillment/types | List and search fulfillment types
[**updateFulfillmentType**](FulfillmentApi.md#updateFulfillmentType) | **PUT** /store/fulfillment/types/{id} | Update a fulfillment type


<a name="createFulfillmentType"></a>
# **createFulfillmentType**
> FulfillmentType createFulfillmentType(type)

Create a fulfillment type

### Example
```java
// Import classes:
//import com.knetikcloud.api.FulfillmentApi;

FulfillmentApi apiInstance = new FulfillmentApi();
FulfillmentType type = new FulfillmentType(); // FulfillmentType | The fulfillment type
try {
    FulfillmentType result = apiInstance.createFulfillmentType(type);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FulfillmentApi#createFulfillmentType");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | [**FulfillmentType**](FulfillmentType.md)| The fulfillment type | [optional]

### Return type

[**FulfillmentType**](FulfillmentType.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteFulfillmentType"></a>
# **deleteFulfillmentType**
> deleteFulfillmentType(id)

Delete a fulfillment type

### Example
```java
// Import classes:
//import com.knetikcloud.api.FulfillmentApi;

FulfillmentApi apiInstance = new FulfillmentApi();
Integer id = 56; // Integer | The id
try {
    apiInstance.deleteFulfillmentType(id);
} catch (ApiException e) {
    System.err.println("Exception when calling FulfillmentApi#deleteFulfillmentType");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFulfillmentType"></a>
# **getFulfillmentType**
> FulfillmentType getFulfillmentType(id)

Get a single fulfillment type

### Example
```java
// Import classes:
//import com.knetikcloud.api.FulfillmentApi;

FulfillmentApi apiInstance = new FulfillmentApi();
Integer id = 56; // Integer | The id
try {
    FulfillmentType result = apiInstance.getFulfillmentType(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FulfillmentApi#getFulfillmentType");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id |

### Return type

[**FulfillmentType**](FulfillmentType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFulfillmentTypes"></a>
# **getFulfillmentTypes**
> PageResourceFulfillmentType getFulfillmentTypes(size, page, order)

List and search fulfillment types

### Example
```java
// Import classes:
//import com.knetikcloud.api.FulfillmentApi;

FulfillmentApi apiInstance = new FulfillmentApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceFulfillmentType result = apiInstance.getFulfillmentTypes(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FulfillmentApi#getFulfillmentTypes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceFulfillmentType**](PageResourceFulfillmentType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateFulfillmentType"></a>
# **updateFulfillmentType**
> updateFulfillmentType(id, fulfillmentType)

Update a fulfillment type

### Example
```java
// Import classes:
//import com.knetikcloud.api.FulfillmentApi;

FulfillmentApi apiInstance = new FulfillmentApi();
Integer id = 56; // Integer | The id
FulfillmentType fulfillmentType = new FulfillmentType(); // FulfillmentType | The fulfillment type
try {
    apiInstance.updateFulfillmentType(id, fulfillmentType);
} catch (ApiException e) {
    System.err.println("Exception when calling FulfillmentApi#updateFulfillmentType");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id |
 **fulfillmentType** | [**FulfillmentType**](FulfillmentType.md)| The fulfillment type | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

