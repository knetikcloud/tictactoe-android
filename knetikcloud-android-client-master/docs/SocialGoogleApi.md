# SocialGoogleApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**linkAccounts1**](SocialGoogleApi.md#linkAccounts1) | **POST** /social/google/users | Link facebook account


<a name="linkAccounts1"></a>
# **linkAccounts1**
> linkAccounts1(facebookToken)

Link facebook account

Links the current user account to a facebook account, using the acccess token from facebook. Can also be used to update the access token after it has expired.

### Example
```java
// Import classes:
//import com.knetikcloud.api.SocialGoogleApi;

SocialGoogleApi apiInstance = new SocialGoogleApi();
GoogleToken facebookToken = new GoogleToken(); // GoogleToken | The token from facebook
try {
    apiInstance.linkAccounts1(facebookToken);
} catch (ApiException e) {
    System.err.println("Exception when calling SocialGoogleApi#linkAccounts1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **facebookToken** | [**GoogleToken**](GoogleToken.md)| The token from facebook | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

