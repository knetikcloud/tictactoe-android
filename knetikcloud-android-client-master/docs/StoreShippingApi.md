# StoreShippingApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createShippingItem**](StoreShippingApi.md#createShippingItem) | **POST** /store/shipping | Create a shipping item
[**createShippingTemplate**](StoreShippingApi.md#createShippingTemplate) | **POST** /store/shipping/templates | Create a shipping template
[**deleteShippingItem**](StoreShippingApi.md#deleteShippingItem) | **DELETE** /store/shipping/{id} | Delete a shipping item
[**deleteShippingTemplate**](StoreShippingApi.md#deleteShippingTemplate) | **DELETE** /store/shipping/templates/{id} | Delete a shipping template
[**getShippingItem**](StoreShippingApi.md#getShippingItem) | **GET** /store/shipping/{id} | Get a single shipping item
[**getShippingTemplate**](StoreShippingApi.md#getShippingTemplate) | **GET** /store/shipping/templates/{id} | Get a single shipping template
[**getShippingTemplates**](StoreShippingApi.md#getShippingTemplates) | **GET** /store/shipping/templates | List and search shipping templates
[**updateShippingItem**](StoreShippingApi.md#updateShippingItem) | **PUT** /store/shipping/{id} | Update a shipping item
[**updateShippingTemplate**](StoreShippingApi.md#updateShippingTemplate) | **PUT** /store/shipping/templates/{id} | Update a shipping template


<a name="createShippingItem"></a>
# **createShippingItem**
> ShippingItem createShippingItem(cascade, shippingItem)

Create a shipping item

A shipping item represents a shipping option and cost. SKUs have to be unique in the entire store.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShippingApi;

StoreShippingApi apiInstance = new StoreShippingApi();
Boolean cascade = false; // Boolean | Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values.
ShippingItem shippingItem = new ShippingItem(); // ShippingItem | The shipping item object
try {
    ShippingItem result = apiInstance.createShippingItem(cascade, shippingItem);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShippingApi#createShippingItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cascade** | **Boolean**| Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values. | [optional] [default to false]
 **shippingItem** | [**ShippingItem**](ShippingItem.md)| The shipping item object | [optional]

### Return type

[**ShippingItem**](ShippingItem.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createShippingTemplate"></a>
# **createShippingTemplate**
> ItemTemplateResource createShippingTemplate(shippingTemplateResource)

Create a shipping template

Shipping Templates define a type of shipping and the properties they have.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShippingApi;

StoreShippingApi apiInstance = new StoreShippingApi();
ItemTemplateResource shippingTemplateResource = new ItemTemplateResource(); // ItemTemplateResource | The new shipping template
try {
    ItemTemplateResource result = apiInstance.createShippingTemplate(shippingTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShippingApi#createShippingTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **shippingTemplateResource** | [**ItemTemplateResource**](ItemTemplateResource.md)| The new shipping template | [optional]

### Return type

[**ItemTemplateResource**](ItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteShippingItem"></a>
# **deleteShippingItem**
> deleteShippingItem(id)

Delete a shipping item

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShippingApi;

StoreShippingApi apiInstance = new StoreShippingApi();
Integer id = 56; // Integer | The id of the shipping item
try {
    apiInstance.deleteShippingItem(id);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShippingApi#deleteShippingItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the shipping item |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteShippingTemplate"></a>
# **deleteShippingTemplate**
> deleteShippingTemplate(id, cascade)

Delete a shipping template

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShippingApi;

StoreShippingApi apiInstance = new StoreShippingApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | force deleting the template if it's attached to other objects, cascade = detach
try {
    apiInstance.deleteShippingTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShippingApi#deleteShippingTemplate");
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

<a name="getShippingItem"></a>
# **getShippingItem**
> ShippingItem getShippingItem(id)

Get a single shipping item

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShippingApi;

StoreShippingApi apiInstance = new StoreShippingApi();
Integer id = 56; // Integer | The id of the shipping item
try {
    ShippingItem result = apiInstance.getShippingItem(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShippingApi#getShippingItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the shipping item |

### Return type

[**ShippingItem**](ShippingItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getShippingTemplate"></a>
# **getShippingTemplate**
> ItemTemplateResource getShippingTemplate(id)

Get a single shipping template

Shipping Templates define a type of shipping and the properties they have.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShippingApi;

StoreShippingApi apiInstance = new StoreShippingApi();
String id = "id_example"; // String | The id of the template
try {
    ItemTemplateResource result = apiInstance.getShippingTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShippingApi#getShippingTemplate");
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

<a name="getShippingTemplates"></a>
# **getShippingTemplates**
> PageResourceItemTemplateResource getShippingTemplates(size, page, order)

List and search shipping templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShippingApi;

StoreShippingApi apiInstance = new StoreShippingApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceItemTemplateResource result = apiInstance.getShippingTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShippingApi#getShippingTemplates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceItemTemplateResource**](PageResourceItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateShippingItem"></a>
# **updateShippingItem**
> ShippingItem updateShippingItem(id, cascade, shippingItem)

Update a shipping item

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShippingApi;

StoreShippingApi apiInstance = new StoreShippingApi();
Integer id = 56; // Integer | The id of the shipping item
Boolean cascade = false; // Boolean | Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values.
ShippingItem shippingItem = new ShippingItem(); // ShippingItem | The shipping item object
try {
    ShippingItem result = apiInstance.updateShippingItem(id, cascade, shippingItem);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShippingApi#updateShippingItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the shipping item |
 **cascade** | **Boolean**| Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values. | [optional] [default to false]
 **shippingItem** | [**ShippingItem**](ShippingItem.md)| The shipping item object | [optional]

### Return type

[**ShippingItem**](ShippingItem.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateShippingTemplate"></a>
# **updateShippingTemplate**
> ItemTemplateResource updateShippingTemplate(id, shippingTemplateResource)

Update a shipping template

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShippingApi;

StoreShippingApi apiInstance = new StoreShippingApi();
String id = "id_example"; // String | The id of the template
ItemTemplateResource shippingTemplateResource = new ItemTemplateResource(); // ItemTemplateResource | The shipping template resource object
try {
    ItemTemplateResource result = apiInstance.updateShippingTemplate(id, shippingTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShippingApi#updateShippingTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **shippingTemplateResource** | [**ItemTemplateResource**](ItemTemplateResource.md)| The shipping template resource object | [optional]

### Return type

[**ItemTemplateResource**](ItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

