# StoreVendorsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createVendor**](StoreVendorsApi.md#createVendor) | **POST** /vendors | Create a vendor
[**createVendorTemplate**](StoreVendorsApi.md#createVendorTemplate) | **POST** /vendors/templates | Create a vendor template
[**deleteVendor**](StoreVendorsApi.md#deleteVendor) | **DELETE** /vendors/{id} | Delete a vendor
[**deleteVendorTemplate**](StoreVendorsApi.md#deleteVendorTemplate) | **DELETE** /vendors/templates/{id} | Delete a vendor template
[**getVendor**](StoreVendorsApi.md#getVendor) | **GET** /vendors/{id} | Get a single vendor
[**getVendorTemplate**](StoreVendorsApi.md#getVendorTemplate) | **GET** /vendors/templates/{id} | Get a single vendor template
[**getVendorTemplates**](StoreVendorsApi.md#getVendorTemplates) | **GET** /vendors/templates | List and search vendor templates
[**getVendors**](StoreVendorsApi.md#getVendors) | **GET** /vendors | List and search vendors
[**updateVendor**](StoreVendorsApi.md#updateVendor) | **PUT** /vendors/{id} | Update a vendor
[**updateVendorTemplate**](StoreVendorsApi.md#updateVendorTemplate) | **PUT** /vendors/templates/{id} | Update a vendor template


<a name="createVendor"></a>
# **createVendor**
> VendorResource createVendor(vendor)

Create a vendor

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreVendorsApi;

StoreVendorsApi apiInstance = new StoreVendorsApi();
VendorResource vendor = new VendorResource(); // VendorResource | The vendor
try {
    VendorResource result = apiInstance.createVendor(vendor);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreVendorsApi#createVendor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vendor** | [**VendorResource**](VendorResource.md)| The vendor | [optional]

### Return type

[**VendorResource**](VendorResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createVendorTemplate"></a>
# **createVendorTemplate**
> ItemTemplateResource createVendorTemplate(vendorTemplateResource)

Create a vendor template

Vendor Templates define a type of vendor and the properties they have.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreVendorsApi;

StoreVendorsApi apiInstance = new StoreVendorsApi();
ItemTemplateResource vendorTemplateResource = new ItemTemplateResource(); // ItemTemplateResource | The new vendor template
try {
    ItemTemplateResource result = apiInstance.createVendorTemplate(vendorTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreVendorsApi#createVendorTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vendorTemplateResource** | [**ItemTemplateResource**](ItemTemplateResource.md)| The new vendor template | [optional]

### Return type

[**ItemTemplateResource**](ItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteVendor"></a>
# **deleteVendor**
> deleteVendor(id)

Delete a vendor

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreVendorsApi;

StoreVendorsApi apiInstance = new StoreVendorsApi();
Integer id = 56; // Integer | The id of the vendor
try {
    apiInstance.deleteVendor(id);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreVendorsApi#deleteVendor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the vendor |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteVendorTemplate"></a>
# **deleteVendorTemplate**
> deleteVendorTemplate(id, cascade)

Delete a vendor template

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreVendorsApi;

StoreVendorsApi apiInstance = new StoreVendorsApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | force deleting the template if it's attached to other objects, cascade = detach
try {
    apiInstance.deleteVendorTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreVendorsApi#deleteVendorTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **cascade** | **String**| force deleting the template if it&#39;s attached to other objects, cascade &#x3D; detach | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getVendor"></a>
# **getVendor**
> VendorResource getVendor(id)

Get a single vendor

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreVendorsApi;

StoreVendorsApi apiInstance = new StoreVendorsApi();
Integer id = 56; // Integer | The id of the vendor
try {
    VendorResource result = apiInstance.getVendor(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreVendorsApi#getVendor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the vendor |

### Return type

[**VendorResource**](VendorResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getVendorTemplate"></a>
# **getVendorTemplate**
> ItemTemplateResource getVendorTemplate(id)

Get a single vendor template

Vendor Templates define a type of vendor and the properties they have.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreVendorsApi;

StoreVendorsApi apiInstance = new StoreVendorsApi();
String id = "id_example"; // String | The id of the template
try {
    ItemTemplateResource result = apiInstance.getVendorTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreVendorsApi#getVendorTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |

### Return type

[**ItemTemplateResource**](ItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getVendorTemplates"></a>
# **getVendorTemplates**
> PageResourceItemTemplateResource getVendorTemplates(size, page, order)

List and search vendor templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreVendorsApi;

StoreVendorsApi apiInstance = new StoreVendorsApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "1"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceItemTemplateResource result = apiInstance.getVendorTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreVendorsApi#getVendorTemplates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to 1]

### Return type

[**PageResourceItemTemplateResource**](PageResourceItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getVendors"></a>
# **getVendors**
> PageResourceVendorResource getVendors(filterName, size, page, order)

List and search vendors

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreVendorsApi;

StoreVendorsApi apiInstance = new StoreVendorsApi();
String filterName = "filterName_example"; // String | Filters vendors by name starting with the text provided in the filter
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceVendorResource result = apiInstance.getVendors(filterName, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreVendorsApi#getVendors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterName** | **String**| Filters vendors by name starting with the text provided in the filter | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceVendorResource**](PageResourceVendorResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateVendor"></a>
# **updateVendor**
> VendorResource updateVendor(id, vendor)

Update a vendor

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreVendorsApi;

StoreVendorsApi apiInstance = new StoreVendorsApi();
Integer id = 56; // Integer | The id of the vendor
VendorResource vendor = new VendorResource(); // VendorResource | The vendor
try {
    VendorResource result = apiInstance.updateVendor(id, vendor);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreVendorsApi#updateVendor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the vendor |
 **vendor** | [**VendorResource**](VendorResource.md)| The vendor | [optional]

### Return type

[**VendorResource**](VendorResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateVendorTemplate"></a>
# **updateVendorTemplate**
> ItemTemplateResource updateVendorTemplate(id, vendorTemplateResource)

Update a vendor template

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreVendorsApi;

StoreVendorsApi apiInstance = new StoreVendorsApi();
String id = "id_example"; // String | The id of the template
ItemTemplateResource vendorTemplateResource = new ItemTemplateResource(); // ItemTemplateResource | The vendor template resource object
try {
    ItemTemplateResource result = apiInstance.updateVendorTemplate(id, vendorTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreVendorsApi#updateVendorTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **vendorTemplateResource** | [**ItemTemplateResource**](ItemTemplateResource.md)| The vendor template resource object | [optional]

### Return type

[**ItemTemplateResource**](ItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

