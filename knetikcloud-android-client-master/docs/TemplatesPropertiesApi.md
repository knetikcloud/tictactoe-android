# TemplatesPropertiesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getTemplatePropertyType**](TemplatesPropertiesApi.md#getTemplatePropertyType) | **GET** /templates/properties/{type} | Get details for a template property type
[**getTemplatePropertyTypes**](TemplatesPropertiesApi.md#getTemplatePropertyTypes) | **GET** /templates/properties | List template property types


<a name="getTemplatePropertyType"></a>
# **getTemplatePropertyType**
> PropertyFieldListResource getTemplatePropertyType(type)

Get details for a template property type

### Example
```java
// Import classes:
//import com.knetikcloud.api.TemplatesPropertiesApi;

TemplatesPropertiesApi apiInstance = new TemplatesPropertiesApi();
String type = "type_example"; // String | type
try {
    PropertyFieldListResource result = apiInstance.getTemplatePropertyType(type);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TemplatesPropertiesApi#getTemplatePropertyType");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **String**| type |

### Return type

[**PropertyFieldListResource**](PropertyFieldListResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTemplatePropertyTypes"></a>
# **getTemplatePropertyTypes**
> List&lt;PropertyFieldListResource&gt; getTemplatePropertyTypes()

List template property types

### Example
```java
// Import classes:
//import com.knetikcloud.api.TemplatesPropertiesApi;

TemplatesPropertiesApi apiInstance = new TemplatesPropertiesApi();
try {
    List<PropertyFieldListResource> result = apiInstance.getTemplatePropertyTypes();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TemplatesPropertiesApi#getTemplatePropertyTypes");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;PropertyFieldListResource&gt;**](PropertyFieldListResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

