# AccessTokenApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getOAuthToken**](AccessTokenApi.md#getOAuthToken) | **POST** /oauth/token | Get access token


<a name="getOAuthToken"></a>
# **getOAuthToken**
> OAuth2Resource getOAuthToken(grantType, clientId, clientSecret, username, password)

Get access token

### Example
```java
// Import classes:
//import com.knetikcloud.api.AccessTokenApi;

AccessTokenApi apiInstance = new AccessTokenApi();
String grantType = "client_credentials"; // String | Grant type
String clientId = "knetik"; // String | The id of the client
String clientSecret = "clientSecret_example"; // String | The secret key of the client.  Used only with a grant_type of client_credentials
String username = "username_example"; // String | The username of the client.  Used only with a grant_type of password
String password = "password_example"; // String | The password of the client.  Used only with a grant_type of password
try {
    OAuth2Resource result = apiInstance.getOAuthToken(grantType, clientId, clientSecret, username, password);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccessTokenApi#getOAuthToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **grantType** | **String**| Grant type | [default to client_credentials] [enum: client_credentials, password]
 **clientId** | **String**| The id of the client | [default to knetik]
 **clientSecret** | **String**| The secret key of the client.  Used only with a grant_type of client_credentials | [optional]
 **username** | **String**| The username of the client.  Used only with a grant_type of password | [optional]
 **password** | **String**| The password of the client.  Used only with a grant_type of password | [optional]

### Return type

[**OAuth2Resource**](OAuth2Resource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

