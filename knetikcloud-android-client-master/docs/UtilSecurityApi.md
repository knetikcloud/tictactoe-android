# UtilSecurityApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getUserLocationLog**](UtilSecurityApi.md#getUserLocationLog) | **GET** /security/country-log | Returns the authentication log for a user
[**getUserTokenDetails**](UtilSecurityApi.md#getUserTokenDetails) | **GET** /me | Returns the authentication token details. Use /users endpoint for detailed user&#39;s info


<a name="getUserLocationLog"></a>
# **getUserLocationLog**
> PageResourceLocationLogResource getUserLocationLog(userId)

Returns the authentication log for a user

A log entry is recorded everytime a user requests a new token. Standard pagination available

### Example
```java
// Import classes:
//import com.knetikcloud.api.UtilSecurityApi;

UtilSecurityApi apiInstance = new UtilSecurityApi();
Integer userId = 56; // Integer | The user id
try {
    PageResourceLocationLogResource result = apiInstance.getUserLocationLog(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilSecurityApi#getUserLocationLog");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The user id | [optional]

### Return type

[**PageResourceLocationLogResource**](PageResourceLocationLogResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserTokenDetails"></a>
# **getUserTokenDetails**
> TokenDetailsResource getUserTokenDetails()

Returns the authentication token details. Use /users endpoint for detailed user&#39;s info

### Example
```java
// Import classes:
//import com.knetikcloud.api.UtilSecurityApi;

UtilSecurityApi apiInstance = new UtilSecurityApi();
try {
    TokenDetailsResource result = apiInstance.getUserTokenDetails();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilSecurityApi#getUserTokenDetails");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**TokenDetailsResource**](TokenDetailsResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

