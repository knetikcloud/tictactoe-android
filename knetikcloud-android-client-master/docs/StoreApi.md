# StoreApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createItemTemplate**](StoreApi.md#createItemTemplate) | **POST** /store/items/templates | Create an item template
[**createStoreItem**](StoreApi.md#createStoreItem) | **POST** /store/items | Create a store item
[**deleteItemTemplate**](StoreApi.md#deleteItemTemplate) | **DELETE** /store/items/templates/{id} | Delete an item template
[**deleteStoreItem**](StoreApi.md#deleteStoreItem) | **DELETE** /store/items/{id} | Delete a store item
[**getBehaviors**](StoreApi.md#getBehaviors) | **GET** /store/items/behaviors | List available item behaviors
[**getItemTemplate**](StoreApi.md#getItemTemplate) | **GET** /store/items/templates/{id} | Get a single item template
[**getItemTemplates**](StoreApi.md#getItemTemplates) | **GET** /store/items/templates | List and search item templates
[**getStore**](StoreApi.md#getStore) | **GET** /store | Get a listing of store items
[**getStoreItem**](StoreApi.md#getStoreItem) | **GET** /store/items/{id} | Get a single store item
[**getStoreItems**](StoreApi.md#getStoreItems) | **GET** /store/items | List and search store items
[**updateItemTemplate**](StoreApi.md#updateItemTemplate) | **PUT** /store/items/templates/{id} | Update an item template
[**updateStoreItem**](StoreApi.md#updateStoreItem) | **PUT** /store/items/{id} | Update a store item


<a name="createItemTemplate"></a>
# **createItemTemplate**
> StoreItemTemplateResource createItemTemplate(itemTemplateResource)

Create an item template

Item Templates define a type of item and the properties they have.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreApi;

StoreApi apiInstance = new StoreApi();
StoreItemTemplateResource itemTemplateResource = new StoreItemTemplateResource(); // StoreItemTemplateResource | The new item template
try {
    StoreItemTemplateResource result = apiInstance.createItemTemplate(itemTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreApi#createItemTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **itemTemplateResource** | [**StoreItemTemplateResource**](StoreItemTemplateResource.md)| The new item template | [optional]

### Return type

[**StoreItemTemplateResource**](StoreItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createStoreItem"></a>
# **createStoreItem**
> StoreItem createStoreItem(cascade, storeItem)

Create a store item

SKUs have to be unique in the entire store. If a duplicate SKU is found, a 400 error is generated and the response will have a \&quot;parameters\&quot; field that is a list of duplicates. A duplicate is an object like {item_id, offending_sku_list}. Ex:&lt;br /&gt; {..., parameters: [[{item: 1, skus: [\&quot;SKU-1\&quot;]}]]}&lt;br /&gt; If an item is brand new and has duplicate SKUs within itself, the item ID will be 0.  Item subclasses are not allowed here, you will have to use their respective endpoints.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreApi;

StoreApi apiInstance = new StoreApi();
Boolean cascade = false; // Boolean | Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values.
StoreItem storeItem = new StoreItem(); // StoreItem | The store item object
try {
    StoreItem result = apiInstance.createStoreItem(cascade, storeItem);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreApi#createStoreItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cascade** | **Boolean**| Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values. | [optional] [default to false]
 **storeItem** | [**StoreItem**](StoreItem.md)| The store item object | [optional]

### Return type

[**StoreItem**](StoreItem.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteItemTemplate"></a>
# **deleteItemTemplate**
> deleteItemTemplate(id, cascade)

Delete an item template

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreApi;

StoreApi apiInstance = new StoreApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | force deleting the template if it's attached to other objects, cascade = detach
try {
    apiInstance.deleteItemTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreApi#deleteItemTemplate");
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

<a name="deleteStoreItem"></a>
# **deleteStoreItem**
> deleteStoreItem(id)

Delete a store item

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreApi;

StoreApi apiInstance = new StoreApi();
Integer id = 56; // Integer | The id of the item
try {
    apiInstance.deleteStoreItem(id);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreApi#deleteStoreItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the item |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getBehaviors"></a>
# **getBehaviors**
> List&lt;BehaviorDefinitionResource&gt; getBehaviors()

List available item behaviors

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreApi;

StoreApi apiInstance = new StoreApi();
try {
    List<BehaviorDefinitionResource> result = apiInstance.getBehaviors();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreApi#getBehaviors");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;BehaviorDefinitionResource&gt;**](BehaviorDefinitionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getItemTemplate"></a>
# **getItemTemplate**
> StoreItemTemplateResource getItemTemplate(id)

Get a single item template

Item Templates define a type of item and the properties they have.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreApi;

StoreApi apiInstance = new StoreApi();
String id = "id_example"; // String | The id of the template
try {
    StoreItemTemplateResource result = apiInstance.getItemTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreApi#getItemTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |

### Return type

[**StoreItemTemplateResource**](StoreItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getItemTemplates"></a>
# **getItemTemplates**
> PageResourceStoreItemTemplateResource getItemTemplates(size, page, order)

List and search item templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreApi;

StoreApi apiInstance = new StoreApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceStoreItemTemplateResource result = apiInstance.getItemTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreApi#getItemTemplates");
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

[**PageResourceStoreItemTemplateResource**](PageResourceStoreItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getStore"></a>
# **getStore**
> PageResourceStoreItem getStore(limit, page, useCatalog, ignoreLocation, inStockOnly)

Get a listing of store items

The exact structure of each items may differ to include fields specific to the type. The same is true for behaviors.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreApi;

StoreApi apiInstance = new StoreApi();
Integer limit = 56; // Integer | The amount of items returned
Integer page = 56; // Integer | The page of the request
Boolean useCatalog = true; // Boolean | Whether to remove items that are not intended for display or not in date
Boolean ignoreLocation = true; // Boolean | Whether to ignore country restrictions based on the caller's location
Boolean inStockOnly = false; // Boolean | Whether only in-stock items should be returned.  Default value is false
try {
    PageResourceStoreItem result = apiInstance.getStore(limit, page, useCatalog, ignoreLocation, inStockOnly);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreApi#getStore");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| The amount of items returned | [optional]
 **page** | **Integer**| The page of the request | [optional]
 **useCatalog** | **Boolean**| Whether to remove items that are not intended for display or not in date | [optional]
 **ignoreLocation** | **Boolean**| Whether to ignore country restrictions based on the caller&#39;s location | [optional]
 **inStockOnly** | **Boolean**| Whether only in-stock items should be returned.  Default value is false | [optional] [default to false]

### Return type

[**PageResourceStoreItem**](PageResourceStoreItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getStoreItem"></a>
# **getStoreItem**
> StoreItem getStoreItem(id)

Get a single store item

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreApi;

StoreApi apiInstance = new StoreApi();
Integer id = 56; // Integer | The id of the item
try {
    StoreItem result = apiInstance.getStoreItem(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreApi#getStoreItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the item |

### Return type

[**StoreItem**](StoreItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getStoreItems"></a>
# **getStoreItems**
> PageResourceStoreItem getStoreItems(filterNameSearch, filterUniqueKey, filterPublished, filterDisplayable, filterStart, filterEnd, filterStartDate, filterStopDate, filterSku, filterPrice, filterTag, filterItemsByType, filterBundledSkus, filterVendor, size, page, order)

List and search store items

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreApi;

StoreApi apiInstance = new StoreApi();
String filterNameSearch = "filterNameSearch_example"; // String | Filter for items whose name starts with a given string.
String filterUniqueKey = "filterUniqueKey_example"; // String | Filter for items whose unique_key is a given string.
Boolean filterPublished = true; // Boolean | Filter for skus that have been published.
Boolean filterDisplayable = true; // Boolean | Filter for items that are displayable.
String filterStart = "filterStart_example"; // String | A comma separated string without spaces.  First value is the operator to search on, second value is the store start date, a unix timestamp in seconds.  Allowed operators: (LT, GT, LTE, GTE, EQ).
String filterEnd = "filterEnd_example"; // String | A comma separated string without spaces.  First value is the operator to search on, second value is the store end date, a unix timestamp in seconds.  Allowed operators: (LT, GT, LTE, GTE, EQ).
String filterStartDate = "filterStartDate_example"; // String | A comma separated string without spaces.  First value is the operator to search on, second value is the sku start date, a unix timestamp in seconds.  Allowed operators: (LT, GT, LTE, GTE, EQ).
String filterStopDate = "filterStopDate_example"; // String | A comma separated string without spaces.  First value is the operator to search on, second value is the sku end date, a unix timestamp in seconds.  Allowed operators: (LT, GT, LTE, GTE, EQ).
String filterSku = "filterSku_example"; // String | Filter for skus whose name starts with a given string.
String filterPrice = "filterPrice_example"; // String | A colon separated string without spaces.  First value is the operator to search on, second value is the price of a sku.  Allowed operators: (LT, GT, LTE, GTE, EQ).
String filterTag = "filterTag_example"; // String | A comma separated list without spaces of the names of tags. Will only return items with at least one of the tags.
String filterItemsByType = "filterItemsByType_example"; // String | Filter for item type based on its type hint.
String filterBundledSkus = "filterBundledSkus_example"; // String | Filter for skus inside bundles whose name starts with a given string.  Used only when type hint is 'bundle_item'
Integer filterVendor = 56; // Integer | Filter for items from a given vendor, by id.
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceStoreItem result = apiInstance.getStoreItems(filterNameSearch, filterUniqueKey, filterPublished, filterDisplayable, filterStart, filterEnd, filterStartDate, filterStopDate, filterSku, filterPrice, filterTag, filterItemsByType, filterBundledSkus, filterVendor, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreApi#getStoreItems");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterNameSearch** | **String**| Filter for items whose name starts with a given string. | [optional]
 **filterUniqueKey** | **String**| Filter for items whose unique_key is a given string. | [optional]
 **filterPublished** | **Boolean**| Filter for skus that have been published. | [optional]
 **filterDisplayable** | **Boolean**| Filter for items that are displayable. | [optional]
 **filterStart** | **String**| A comma separated string without spaces.  First value is the operator to search on, second value is the store start date, a unix timestamp in seconds.  Allowed operators: (LT, GT, LTE, GTE, EQ). | [optional]
 **filterEnd** | **String**| A comma separated string without spaces.  First value is the operator to search on, second value is the store end date, a unix timestamp in seconds.  Allowed operators: (LT, GT, LTE, GTE, EQ). | [optional]
 **filterStartDate** | **String**| A comma separated string without spaces.  First value is the operator to search on, second value is the sku start date, a unix timestamp in seconds.  Allowed operators: (LT, GT, LTE, GTE, EQ). | [optional]
 **filterStopDate** | **String**| A comma separated string without spaces.  First value is the operator to search on, second value is the sku end date, a unix timestamp in seconds.  Allowed operators: (LT, GT, LTE, GTE, EQ). | [optional]
 **filterSku** | **String**| Filter for skus whose name starts with a given string. | [optional]
 **filterPrice** | **String**| A colon separated string without spaces.  First value is the operator to search on, second value is the price of a sku.  Allowed operators: (LT, GT, LTE, GTE, EQ). | [optional]
 **filterTag** | **String**| A comma separated list without spaces of the names of tags. Will only return items with at least one of the tags. | [optional]
 **filterItemsByType** | **String**| Filter for item type based on its type hint. | [optional]
 **filterBundledSkus** | **String**| Filter for skus inside bundles whose name starts with a given string.  Used only when type hint is &#39;bundle_item&#39; | [optional]
 **filterVendor** | **Integer**| Filter for items from a given vendor, by id. | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceStoreItem**](PageResourceStoreItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateItemTemplate"></a>
# **updateItemTemplate**
> StoreItemTemplateResource updateItemTemplate(id, itemTemplateResource)

Update an item template

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreApi;

StoreApi apiInstance = new StoreApi();
String id = "id_example"; // String | The id of the template
StoreItemTemplateResource itemTemplateResource = new StoreItemTemplateResource(); // StoreItemTemplateResource | The item template resource object
try {
    StoreItemTemplateResource result = apiInstance.updateItemTemplate(id, itemTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreApi#updateItemTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **itemTemplateResource** | [**StoreItemTemplateResource**](StoreItemTemplateResource.md)| The item template resource object | [optional]

### Return type

[**StoreItemTemplateResource**](StoreItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateStoreItem"></a>
# **updateStoreItem**
> StoreItem updateStoreItem(id, cascade, storeItem)

Update a store item

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreApi;

StoreApi apiInstance = new StoreApi();
Integer id = 56; // Integer | The id of the item
Boolean cascade = false; // Boolean | Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values.
StoreItem storeItem = new StoreItem(); // StoreItem | The store item object
try {
    StoreItem result = apiInstance.updateStoreItem(id, cascade, storeItem);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreApi#updateStoreItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the item |
 **cascade** | **Boolean**| Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values. | [optional] [default to false]
 **storeItem** | [**StoreItem**](StoreItem.md)| The store item object | [optional]

### Return type

[**StoreItem**](StoreItem.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

