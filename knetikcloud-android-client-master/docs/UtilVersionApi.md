# UtilVersionApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getVersion**](UtilVersionApi.md#getVersion) | **GET** /version | Get current version info


<a name="getVersion"></a>
# **getVersion**
> Version getVersion()

Get current version info

### Example
```java
// Import classes:
//import com.knetikcloud.api.UtilVersionApi;

UtilVersionApi apiInstance = new UtilVersionApi();
try {
    Version result = apiInstance.getVersion();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilVersionApi#getVersion");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Version**](Version.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

