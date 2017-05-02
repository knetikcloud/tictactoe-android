# BRERuleEngineGlobalsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createBREGlobal**](BRERuleEngineGlobalsApi.md#createBREGlobal) | **POST** /bre/globals/definitions | Create a global definition
[**deleteBREGlobal**](BRERuleEngineGlobalsApi.md#deleteBREGlobal) | **DELETE** /bre/globals/definitions/{id} | Delete a global
[**getBREGlobal**](BRERuleEngineGlobalsApi.md#getBREGlobal) | **GET** /bre/globals/definitions/{id} | Get a single global definition
[**getBREGlobals**](BRERuleEngineGlobalsApi.md#getBREGlobals) | **GET** /bre/globals/definitions | List global definitions
[**updateBREGlobal**](BRERuleEngineGlobalsApi.md#updateBREGlobal) | **PUT** /bre/globals/definitions/{id} | Update a global definition


<a name="createBREGlobal"></a>
# **createBREGlobal**
> BreGlobalResource createBREGlobal(breGlobalResource)

Create a global definition

Once created you can then use in a custom rule. Note that global definitions cannot be modified or deleted if in use.

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineGlobalsApi;

BRERuleEngineGlobalsApi apiInstance = new BRERuleEngineGlobalsApi();
BreGlobalResource breGlobalResource = new BreGlobalResource(); // BreGlobalResource | The BRE global resource object
try {
    BreGlobalResource result = apiInstance.createBREGlobal(breGlobalResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineGlobalsApi#createBREGlobal");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **breGlobalResource** | [**BreGlobalResource**](BreGlobalResource.md)| The BRE global resource object | [optional]

### Return type

[**BreGlobalResource**](BreGlobalResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteBREGlobal"></a>
# **deleteBREGlobal**
> deleteBREGlobal(id)

Delete a global

May fail if there are existing rules against it. Cannot delete core globals

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineGlobalsApi;

BRERuleEngineGlobalsApi apiInstance = new BRERuleEngineGlobalsApi();
String id = "id_example"; // String | The id of the global definition
try {
    apiInstance.deleteBREGlobal(id);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineGlobalsApi#deleteBREGlobal");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the global definition |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getBREGlobal"></a>
# **getBREGlobal**
> BreGlobalResource getBREGlobal(id)

Get a single global definition

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineGlobalsApi;

BRERuleEngineGlobalsApi apiInstance = new BRERuleEngineGlobalsApi();
String id = "id_example"; // String | The id of the global definition
try {
    BreGlobalResource result = apiInstance.getBREGlobal(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineGlobalsApi#getBREGlobal");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the global definition |

### Return type

[**BreGlobalResource**](BreGlobalResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getBREGlobals"></a>
# **getBREGlobals**
> PageResourceBreGlobalResource getBREGlobals(filterSystem, size, page)

List global definitions

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineGlobalsApi;

BRERuleEngineGlobalsApi apiInstance = new BRERuleEngineGlobalsApi();
Boolean filterSystem = true; // Boolean | Filter for globals that are system globals when true, or not when false. Leave off for both mixed
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceBreGlobalResource result = apiInstance.getBREGlobals(filterSystem, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineGlobalsApi#getBREGlobals");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterSystem** | **Boolean**| Filter for globals that are system globals when true, or not when false. Leave off for both mixed | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceBreGlobalResource**](PageResourceBreGlobalResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateBREGlobal"></a>
# **updateBREGlobal**
> BreGlobalResource updateBREGlobal(id, breGlobalResource)

Update a global definition

May fail if new parameters mismatch requirements of existing rules. Cannot update core globals

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineGlobalsApi;

BRERuleEngineGlobalsApi apiInstance = new BRERuleEngineGlobalsApi();
String id = "id_example"; // String | The id of the global definition
BreGlobalResource breGlobalResource = new BreGlobalResource(); // BreGlobalResource | The BRE global resource object
try {
    BreGlobalResource result = apiInstance.updateBREGlobal(id, breGlobalResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineGlobalsApi#updateBREGlobal");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the global definition |
 **breGlobalResource** | [**BreGlobalResource**](BreGlobalResource.md)| The BRE global resource object | [optional]

### Return type

[**BreGlobalResource**](BreGlobalResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

