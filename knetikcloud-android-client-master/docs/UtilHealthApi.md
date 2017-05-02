# UtilHealthApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getHealth**](UtilHealthApi.md#getHealth) | **GET** /health | Get health info


<a name="getHealth"></a>
# **getHealth**
> Object getHealth()

Get health info

### Example
```java
// Import classes:
//import com.knetikcloud.api.UtilHealthApi;

UtilHealthApi apiInstance = new UtilHealthApi();
try {
    Object result = apiInstance.getHealth();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilHealthApi#getHealth");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

