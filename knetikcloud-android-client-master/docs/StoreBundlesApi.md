# StoreBundlesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createBundleItem**](StoreBundlesApi.md#createBundleItem) | **POST** /store/bundles | Create a bundle item
[**createBundleTemplate**](StoreBundlesApi.md#createBundleTemplate) | **POST** /store/bundles/templates | Create a bundle template
[**deleteBundleItem**](StoreBundlesApi.md#deleteBundleItem) | **DELETE** /store/bundles/{id} | Delete a bundle item
[**deleteBundleTemplate**](StoreBundlesApi.md#deleteBundleTemplate) | **DELETE** /store/bundles/templates/{id} | Delete a bundle template
[**getBundleItem**](StoreBundlesApi.md#getBundleItem) | **GET** /store/bundles/{id} | Get a single bundle item
[**getBundleTemplate**](StoreBundlesApi.md#getBundleTemplate) | **GET** /store/bundles/templates/{id} | Get a single bundle template
[**getBundleTemplates**](StoreBundlesApi.md#getBundleTemplates) | **GET** /store/bundles/templates | List and search bundle templates
[**updateBundleItem**](StoreBundlesApi.md#updateBundleItem) | **PUT** /store/bundles/{id} | Update a bundle item
[**updateBundleTemplate**](StoreBundlesApi.md#updateBundleTemplate) | **PUT** /store/bundles/templates/{id} | Update a bundle template


<a name="createBundleItem"></a>
# **createBundleItem**
> BundleItem createBundleItem(cascade, bundleItem)

Create a bundle item

The SKU for the bundle itself must be unique and there can only be one SKU.  Extra notes for price_override:  The price of all the items (multiplied by the quantity) must equal the price of the bundle.  With individual prices set, items will be processed individually and can be refunded as such.  However, if all prices are set to null, the price of the bundle will be used and will be treated as one item.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreBundlesApi;

StoreBundlesApi apiInstance = new StoreBundlesApi();
Boolean cascade = false; // Boolean | Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values.
BundleItem bundleItem = new BundleItem(); // BundleItem | The bundle item object
try {
    BundleItem result = apiInstance.createBundleItem(cascade, bundleItem);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreBundlesApi#createBundleItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cascade** | **Boolean**| Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values. | [optional] [default to false]
 **bundleItem** | [**BundleItem**](BundleItem.md)| The bundle item object | [optional]

### Return type

[**BundleItem**](BundleItem.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createBundleTemplate"></a>
# **createBundleTemplate**
> ItemTemplateResource createBundleTemplate(bundleTemplateResource)

Create a bundle template

Bundle Templates define a type of bundle and the properties they have.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreBundlesApi;

StoreBundlesApi apiInstance = new StoreBundlesApi();
ItemTemplateResource bundleTemplateResource = new ItemTemplateResource(); // ItemTemplateResource | The new bundle template
try {
    ItemTemplateResource result = apiInstance.createBundleTemplate(bundleTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreBundlesApi#createBundleTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bundleTemplateResource** | [**ItemTemplateResource**](ItemTemplateResource.md)| The new bundle template | [optional]

### Return type

[**ItemTemplateResource**](ItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteBundleItem"></a>
# **deleteBundleItem**
> deleteBundleItem(id)

Delete a bundle item

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreBundlesApi;

StoreBundlesApi apiInstance = new StoreBundlesApi();
Integer id = 56; // Integer | The id of the bundle
try {
    apiInstance.deleteBundleItem(id);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreBundlesApi#deleteBundleItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the bundle |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteBundleTemplate"></a>
# **deleteBundleTemplate**
> deleteBundleTemplate(id, cascade)

Delete a bundle template

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreBundlesApi;

StoreBundlesApi apiInstance = new StoreBundlesApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | force deleting the template if it's attached to other objects, cascade = detach
try {
    apiInstance.deleteBundleTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreBundlesApi#deleteBundleTemplate");
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

<a name="getBundleItem"></a>
# **getBundleItem**
> BundleItem getBundleItem(id)

Get a single bundle item

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreBundlesApi;

StoreBundlesApi apiInstance = new StoreBundlesApi();
Integer id = 56; // Integer | The id of the bundle
try {
    BundleItem result = apiInstance.getBundleItem(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreBundlesApi#getBundleItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the bundle |

### Return type

[**BundleItem**](BundleItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getBundleTemplate"></a>
# **getBundleTemplate**
> ItemTemplateResource getBundleTemplate(id)

Get a single bundle template

Bundle Templates define a type of bundle and the properties they have.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreBundlesApi;

StoreBundlesApi apiInstance = new StoreBundlesApi();
String id = "id_example"; // String | The id of the template
try {
    ItemTemplateResource result = apiInstance.getBundleTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreBundlesApi#getBundleTemplate");
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

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getBundleTemplates"></a>
# **getBundleTemplates**
> PageResourceItemTemplateResource getBundleTemplates(size, page, order)

List and search bundle templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreBundlesApi;

StoreBundlesApi apiInstance = new StoreBundlesApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceItemTemplateResource result = apiInstance.getBundleTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreBundlesApi#getBundleTemplates");
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

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateBundleItem"></a>
# **updateBundleItem**
> BundleItem updateBundleItem(id, cascade, bundleItem)

Update a bundle item

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreBundlesApi;

StoreBundlesApi apiInstance = new StoreBundlesApi();
Integer id = 56; // Integer | The id of the bundle
Boolean cascade = false; // Boolean | Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values.
BundleItem bundleItem = new BundleItem(); // BundleItem | The bundle item object
try {
    BundleItem result = apiInstance.updateBundleItem(id, cascade, bundleItem);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreBundlesApi#updateBundleItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the bundle |
 **cascade** | **Boolean**| Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values. | [optional] [default to false]
 **bundleItem** | [**BundleItem**](BundleItem.md)| The bundle item object | [optional]

### Return type

[**BundleItem**](BundleItem.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateBundleTemplate"></a>
# **updateBundleTemplate**
> ItemTemplateResource updateBundleTemplate(id, bundleTemplateResource)

Update a bundle template

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreBundlesApi;

StoreBundlesApi apiInstance = new StoreBundlesApi();
String id = "id_example"; // String | The id of the template
ItemTemplateResource bundleTemplateResource = new ItemTemplateResource(); // ItemTemplateResource | The bundle template resource object
try {
    ItemTemplateResource result = apiInstance.updateBundleTemplate(id, bundleTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreBundlesApi#updateBundleTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **bundleTemplateResource** | [**ItemTemplateResource**](ItemTemplateResource.md)| The bundle template resource object | [optional]

### Return type

[**ItemTemplateResource**](ItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

