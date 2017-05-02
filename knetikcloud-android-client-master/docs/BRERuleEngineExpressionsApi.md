# BRERuleEngineExpressionsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getBREExpressions**](BRERuleEngineExpressionsApi.md#getBREExpressions) | **GET** /bre/expressions/lookup | Get a list of &#39;lookup&#39; type expressions


<a name="getBREExpressions"></a>
# **getBREExpressions**
> List&lt;LookupTypeResource&gt; getBREExpressions()

Get a list of &#39;lookup&#39; type expressions

These are expression types that take a second expression as input and produce a value. These can be used in addition to the standard types, like parameter, global and constant (see BRE documentation for details).

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineExpressionsApi;

BRERuleEngineExpressionsApi apiInstance = new BRERuleEngineExpressionsApi();
try {
    List<LookupTypeResource> result = apiInstance.getBREExpressions();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineExpressionsApi#getBREExpressions");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;LookupTypeResource&gt;**](LookupTypeResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

