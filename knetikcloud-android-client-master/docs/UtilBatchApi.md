# UtilBatchApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendBatch**](UtilBatchApi.md#sendBatch) | **POST** /batch | Request to run API call given the method, content type, path url, and body of request


<a name="sendBatch"></a>
# **sendBatch**
> List&lt;BatchReturn&gt; sendBatch(batch)

Request to run API call given the method, content type, path url, and body of request

### Example
```java
// Import classes:
//import com.knetikcloud.api.UtilBatchApi;

UtilBatchApi apiInstance = new UtilBatchApi();
Batch batch = new Batch(); // Batch | The batch object
try {
    List<BatchReturn> result = apiInstance.sendBatch(batch);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilBatchApi#sendBatch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **batch** | [**Batch**](Batch.md)| The batch object | [optional]

### Return type

[**List&lt;BatchReturn&gt;**](BatchReturn.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

