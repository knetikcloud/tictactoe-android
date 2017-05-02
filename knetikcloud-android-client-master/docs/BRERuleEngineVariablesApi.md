# BRERuleEngineVariablesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getBREVariableTypes**](BRERuleEngineVariablesApi.md#getBREVariableTypes) | **GET** /bre/variable-types | Get a list of variable types available


<a name="getBREVariableTypes"></a>
# **getBREVariableTypes**
> List&lt;VariableTypeResource&gt; getBREVariableTypes()

Get a list of variable types available

Types include integer, string, user and invoice. These are used to qualify trigger parameters and action variables with strong typing.

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineVariablesApi;

BRERuleEngineVariablesApi apiInstance = new BRERuleEngineVariablesApi();
try {
    List<VariableTypeResource> result = apiInstance.getBREVariableTypes();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineVariablesApi#getBREVariableTypes");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;VariableTypeResource&gt;**](VariableTypeResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

