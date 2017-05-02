# UsersInventoryApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addItemToUserInventory**](UsersInventoryApi.md#addItemToUserInventory) | **POST** /users/{id}/inventory | Adds an item to the user inventory
[**checkUserEntitlementItem**](UsersInventoryApi.md#checkUserEntitlementItem) | **GET** /users/{user_id}/entitlements/{item_id}/check | Check for access to an item without consuming
[**createEntitlementItem**](UsersInventoryApi.md#createEntitlementItem) | **POST** /entitlements | Create an entitlement item
[**createEntitlementTemplate**](UsersInventoryApi.md#createEntitlementTemplate) | **POST** /entitlements/templates | Create an entitlement template
[**deleteEntitlementItem**](UsersInventoryApi.md#deleteEntitlementItem) | **DELETE** /entitlements/{entitlement_id} | Delete an entitlement item
[**deleteEntitlementTemplate**](UsersInventoryApi.md#deleteEntitlementTemplate) | **DELETE** /entitlements/templates/{id} | Delete an entitlement template
[**getEntitlementItem**](UsersInventoryApi.md#getEntitlementItem) | **GET** /entitlements/{entitlement_id} | Get a single entitlement item
[**getEntitlementItems**](UsersInventoryApi.md#getEntitlementItems) | **GET** /entitlements | List and search entitlement items
[**getEntitlementTemplate**](UsersInventoryApi.md#getEntitlementTemplate) | **GET** /entitlements/templates/{id} | Get a single entitlement template
[**getEntitlementTemplates**](UsersInventoryApi.md#getEntitlementTemplates) | **GET** /entitlements/templates | List and search entitlement templates
[**getUserInventories**](UsersInventoryApi.md#getUserInventories) | **GET** /users/{id}/inventory | List the user inventory entries for a given user
[**getUserInventory**](UsersInventoryApi.md#getUserInventory) | **GET** /users/{user_id}/inventory/{id} | Get an inventory entry
[**getUserInventoryLog**](UsersInventoryApi.md#getUserInventoryLog) | **GET** /users/{user_id}/inventory/{id}/log | List the log entries for this inventory entry
[**getUsersInventory**](UsersInventoryApi.md#getUsersInventory) | **GET** /inventories | List the user inventory entries for all users
[**grantUserEntitlement**](UsersInventoryApi.md#grantUserEntitlement) | **POST** /users/{user_id}/entitlements | Grant an entitlement
[**updateEntitlementItem**](UsersInventoryApi.md#updateEntitlementItem) | **PUT** /entitlements/{entitlement_id} | Update an entitlement item
[**updateEntitlementTemplate**](UsersInventoryApi.md#updateEntitlementTemplate) | **PUT** /entitlements/templates/{id} | Update an entitlement template
[**updateUserInventoryBehaviorData**](UsersInventoryApi.md#updateUserInventoryBehaviorData) | **PUT** /users/{user_id}/inventory/{id}/behavior-data | Set the behavior data for an inventory entry
[**updateUserInventoryExpires**](UsersInventoryApi.md#updateUserInventoryExpires) | **PUT** /users/{user_id}/inventory/{id}/expires | Set the expiration date
[**updateUserInventoryStatus**](UsersInventoryApi.md#updateUserInventoryStatus) | **PUT** /users/{user_id}/inventory/{id}/status | Set the status for an inventory entry
[**useUserEntitlementItem**](UsersInventoryApi.md#useUserEntitlementItem) | **POST** /users/{user_id}/entitlements/{item_id}/use | Use an item


<a name="addItemToUserInventory"></a>
# **addItemToUserInventory**
> InvoiceResource addItemToUserInventory(id, userInventoryAddRequest)

Adds an item to the user inventory

The inventory is fulfilled asynchronously UNLESS the invoice is explicitely skipped. Depending on the use case, it might require the client to verify that the entitlement was added after the fact or configure a BRE rule to get a notification in real time

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
Integer id = 56; // Integer | The id of the user
UserInventoryAddRequest userInventoryAddRequest = new UserInventoryAddRequest(); // UserInventoryAddRequest | The user inventory add request object
try {
    InvoiceResource result = apiInstance.addItemToUserInventory(id, userInventoryAddRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#addItemToUserInventory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the user |
 **userInventoryAddRequest** | [**UserInventoryAddRequest**](UserInventoryAddRequest.md)| The user inventory add request object | [optional]

### Return type

[**InvoiceResource**](InvoiceResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="checkUserEntitlementItem"></a>
# **checkUserEntitlementItem**
> checkUserEntitlementItem(userId, itemId, sku)

Check for access to an item without consuming

Useful for pre-check and accounts for all various buisness rules

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
String userId = "userId_example"; // String | The id of the user to check for or 'me' for logged in user
Integer itemId = 56; // Integer | The id of the item
String sku = "sku_example"; // String | The specific sku of an entitlement list addition to check entitlement for. This is of very limited and specific use and should generally be left out
try {
    apiInstance.checkUserEntitlementItem(userId, itemId, sku);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#checkUserEntitlementItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The id of the user to check for or &#39;me&#39; for logged in user |
 **itemId** | **Integer**| The id of the item |
 **sku** | **String**| The specific sku of an entitlement list addition to check entitlement for. This is of very limited and specific use and should generally be left out | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createEntitlementItem"></a>
# **createEntitlementItem**
> EntitlementItem createEntitlementItem(cascade, entitlementItem)

Create an entitlement item

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
Boolean cascade = false; // Boolean | Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values.
EntitlementItem entitlementItem = new EntitlementItem(); // EntitlementItem | The entitlement item object
try {
    EntitlementItem result = apiInstance.createEntitlementItem(cascade, entitlementItem);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#createEntitlementItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cascade** | **Boolean**| Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values. | [optional] [default to false]
 **entitlementItem** | [**EntitlementItem**](EntitlementItem.md)| The entitlement item object | [optional]

### Return type

[**EntitlementItem**](EntitlementItem.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createEntitlementTemplate"></a>
# **createEntitlementTemplate**
> ItemTemplateResource createEntitlementTemplate(template)

Create an entitlement template

Entitlement templates define a type of entitlement and the properties they have

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
ItemTemplateResource template = new ItemTemplateResource(); // ItemTemplateResource | The entitlement template to be created
try {
    ItemTemplateResource result = apiInstance.createEntitlementTemplate(template);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#createEntitlementTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **template** | [**ItemTemplateResource**](ItemTemplateResource.md)| The entitlement template to be created | [optional]

### Return type

[**ItemTemplateResource**](ItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteEntitlementItem"></a>
# **deleteEntitlementItem**
> deleteEntitlementItem(entitlementId)

Delete an entitlement item

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
Integer entitlementId = 56; // Integer | The id of the entitlement
try {
    apiInstance.deleteEntitlementItem(entitlementId);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#deleteEntitlementItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entitlementId** | **Integer**| The id of the entitlement |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteEntitlementTemplate"></a>
# **deleteEntitlementTemplate**
> deleteEntitlementTemplate(id, cascade)

Delete an entitlement template

If cascade &#x3D; &#39;detach&#39;, it will force delete the template even if it&#39;s attached to other objects

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | The value needed to delete used templates
try {
    apiInstance.deleteEntitlementTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#deleteEntitlementTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **cascade** | **String**| The value needed to delete used templates | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getEntitlementItem"></a>
# **getEntitlementItem**
> EntitlementItem getEntitlementItem(entitlementId)

Get a single entitlement item

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
Integer entitlementId = 56; // Integer | The id of the entitlement
try {
    EntitlementItem result = apiInstance.getEntitlementItem(entitlementId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#getEntitlementItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entitlementId** | **Integer**| The id of the entitlement |

### Return type

[**EntitlementItem**](EntitlementItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getEntitlementItems"></a>
# **getEntitlementItems**
> PageResourceEntitlementItem getEntitlementItems(size, page, order)

List and search entitlement items

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceEntitlementItem result = apiInstance.getEntitlementItems(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#getEntitlementItems");
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

[**PageResourceEntitlementItem**](PageResourceEntitlementItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getEntitlementTemplate"></a>
# **getEntitlementTemplate**
> ItemTemplateResource getEntitlementTemplate(id)

Get a single entitlement template

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
String id = "id_example"; // String | The id of the template
try {
    ItemTemplateResource result = apiInstance.getEntitlementTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#getEntitlementTemplate");
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

<a name="getEntitlementTemplates"></a>
# **getEntitlementTemplates**
> PageResourceItemTemplateResource getEntitlementTemplates(size, page, order)

List and search entitlement templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceItemTemplateResource result = apiInstance.getEntitlementTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#getEntitlementTemplates");
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

<a name="getUserInventories"></a>
# **getUserInventories**
> PageResourceUserInventoryResource getUserInventories(id, inactive, size, page, filterItemName, filterItemId, filterUsername, filterGroup, filterDate)

List the user inventory entries for a given user

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
Integer id = 56; // Integer | The id of the user
Boolean inactive = false; // Boolean | If true, accepts inactive user inventories
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String filterItemName = "filterItemName_example"; // String | Filter by items whose name starts with a string
Integer filterItemId = 56; // Integer | Filter by item id
String filterUsername = "filterUsername_example"; // String | Filter by entries owned by the user with the specified username
String filterGroup = "filterGroup_example"; // String | Filter by entries owned by the users in a given group, by unique name
String filterDate = "filterDate_example"; // String | A comma separated string without spaces.  First value is the operator to search on, second value is the log start date, a unix timestamp in seconds. Can be repeated for a range, eg: GT,123,LT,456  Allowed operators: (GT, LT, EQ, GOE, LOE).
try {
    PageResourceUserInventoryResource result = apiInstance.getUserInventories(id, inactive, size, page, filterItemName, filterItemId, filterUsername, filterGroup, filterDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#getUserInventories");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the user |
 **inactive** | **Boolean**| If true, accepts inactive user inventories | [optional] [default to false]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **filterItemName** | **String**| Filter by items whose name starts with a string | [optional]
 **filterItemId** | **Integer**| Filter by item id | [optional]
 **filterUsername** | **String**| Filter by entries owned by the user with the specified username | [optional]
 **filterGroup** | **String**| Filter by entries owned by the users in a given group, by unique name | [optional]
 **filterDate** | **String**| A comma separated string without spaces.  First value is the operator to search on, second value is the log start date, a unix timestamp in seconds. Can be repeated for a range, eg: GT,123,LT,456  Allowed operators: (GT, LT, EQ, GOE, LOE). | [optional]

### Return type

[**PageResourceUserInventoryResource**](PageResourceUserInventoryResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserInventory"></a>
# **getUserInventory**
> UserInventoryResource getUserInventory(userId, id)

Get an inventory entry

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
Integer userId = 56; // Integer | The id of the inventory owner or 'me' for the logged in user
Integer id = 56; // Integer | The id of the user inventory
try {
    UserInventoryResource result = apiInstance.getUserInventory(userId, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#getUserInventory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the inventory owner or &#39;me&#39; for the logged in user |
 **id** | **Integer**| The id of the user inventory |

### Return type

[**UserInventoryResource**](UserInventoryResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserInventoryLog"></a>
# **getUserInventoryLog**
> PageResourceUserItemLogResource getUserInventoryLog(userId, id, size, page)

List the log entries for this inventory entry

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
String userId = "userId_example"; // String | The id of the inventory owner or 'me' for the logged in user
Integer id = 56; // Integer | The id of the user inventory
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceUserItemLogResource result = apiInstance.getUserInventoryLog(userId, id, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#getUserInventoryLog");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The id of the inventory owner or &#39;me&#39; for the logged in user |
 **id** | **Integer**| The id of the user inventory |
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceUserItemLogResource**](PageResourceUserItemLogResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUsersInventory"></a>
# **getUsersInventory**
> PageResourceUserInventoryResource getUsersInventory(inactive, size, page, filterItemName, filterItemId, filterUsername, filterGroup, filterDate)

List the user inventory entries for all users

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
Boolean inactive = false; // Boolean | If true, accepts inactive user inventories
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String filterItemName = "filterItemName_example"; // String | Filter by items whose name starts with a string
Integer filterItemId = 56; // Integer | Filter by item id
String filterUsername = "filterUsername_example"; // String | Filter by entries owned by the user with the specified username
String filterGroup = "filterGroup_example"; // String | Filter by entries owned by the users in a given group, by unique name
String filterDate = "filterDate_example"; // String | A comma separated string without spaces.  First value is the operator to search on, second value is the log start date, a unix timestamp in seconds. Can be repeated for a range, eg: GT,123,LT,456  Allowed operators: (GT, LT, EQ, GOE, LOE).
try {
    PageResourceUserInventoryResource result = apiInstance.getUsersInventory(inactive, size, page, filterItemName, filterItemId, filterUsername, filterGroup, filterDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#getUsersInventory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **inactive** | **Boolean**| If true, accepts inactive user inventories | [optional] [default to false]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **filterItemName** | **String**| Filter by items whose name starts with a string | [optional]
 **filterItemId** | **Integer**| Filter by item id | [optional]
 **filterUsername** | **String**| Filter by entries owned by the user with the specified username | [optional]
 **filterGroup** | **String**| Filter by entries owned by the users in a given group, by unique name | [optional]
 **filterDate** | **String**| A comma separated string without spaces.  First value is the operator to search on, second value is the log start date, a unix timestamp in seconds. Can be repeated for a range, eg: GT,123,LT,456  Allowed operators: (GT, LT, EQ, GOE, LOE). | [optional]

### Return type

[**PageResourceUserInventoryResource**](PageResourceUserInventoryResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="grantUserEntitlement"></a>
# **grantUserEntitlement**
> grantUserEntitlement(userId, grantRequest)

Grant an entitlement

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
Integer userId = 56; // Integer | The id of the user to grant the entitlement to
EntitlementGrantRequest grantRequest = new EntitlementGrantRequest(); // EntitlementGrantRequest | grantRequest
try {
    apiInstance.grantUserEntitlement(userId, grantRequest);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#grantUserEntitlement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user to grant the entitlement to |
 **grantRequest** | [**EntitlementGrantRequest**](EntitlementGrantRequest.md)| grantRequest |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateEntitlementItem"></a>
# **updateEntitlementItem**
> updateEntitlementItem(entitlementId, cascade, entitlementItem)

Update an entitlement item

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
Integer entitlementId = 56; // Integer | The id of the entitlement
Boolean cascade = false; // Boolean | Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values.
EntitlementItem entitlementItem = new EntitlementItem(); // EntitlementItem | The entitlement item object
try {
    apiInstance.updateEntitlementItem(entitlementId, cascade, entitlementItem);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#updateEntitlementItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entitlementId** | **Integer**| The id of the entitlement |
 **cascade** | **Boolean**| Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values. | [optional] [default to false]
 **entitlementItem** | [**EntitlementItem**](EntitlementItem.md)| The entitlement item object | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateEntitlementTemplate"></a>
# **updateEntitlementTemplate**
> ItemTemplateResource updateEntitlementTemplate(id, template)

Update an entitlement template

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
String id = "id_example"; // String | The id of the template
ItemTemplateResource template = new ItemTemplateResource(); // ItemTemplateResource | The updated template
try {
    ItemTemplateResource result = apiInstance.updateEntitlementTemplate(id, template);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#updateEntitlementTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **template** | [**ItemTemplateResource**](ItemTemplateResource.md)| The updated template | [optional]

### Return type

[**ItemTemplateResource**](ItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateUserInventoryBehaviorData"></a>
# **updateUserInventoryBehaviorData**
> updateUserInventoryBehaviorData(userId, id, data)

Set the behavior data for an inventory entry

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
Integer userId = 56; // Integer | The id of the user
Integer id = 56; // Integer | The id of the user inventory
Object data = null; // Object | The data map
try {
    apiInstance.updateUserInventoryBehaviorData(userId, id, data);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#updateUserInventoryBehaviorData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |
 **id** | **Integer**| The id of the user inventory |
 **data** | **Object**| The data map | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateUserInventoryExpires"></a>
# **updateUserInventoryExpires**
> updateUserInventoryExpires(userId, id, timestamp)

Set the expiration date

Will change the current grace period for a subscription but not the bill date (possibly even ending before having the chance to re-bill)

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
Integer userId = 56; // Integer | user_id
Integer id = 56; // Integer | The id of the user inventory
Long timestamp = 789L; // Long | The new expiration date as a unix timestamp in seconds. May be null (no body).
try {
    apiInstance.updateUserInventoryExpires(userId, id, timestamp);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#updateUserInventoryExpires");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| user_id |
 **id** | **Integer**| The id of the user inventory |
 **timestamp** | **Long**| The new expiration date as a unix timestamp in seconds. May be null (no body). | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateUserInventoryStatus"></a>
# **updateUserInventoryStatus**
> updateUserInventoryStatus(userId, id, inventoryStatus)

Set the status for an inventory entry

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
Integer userId = 56; // Integer | The id of the user
Integer id = 56; // Integer | The id of the user inventory
String inventoryStatus = "inventoryStatus_example"; // String | The inventory status object
try {
    apiInstance.updateUserInventoryStatus(userId, id, inventoryStatus);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#updateUserInventoryStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |
 **id** | **Integer**| The id of the user inventory |
 **inventoryStatus** | **String**| The inventory status object | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="useUserEntitlementItem"></a>
# **useUserEntitlementItem**
> useUserEntitlementItem(userId, itemId, sku, info)

Use an item

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersInventoryApi;

UsersInventoryApi apiInstance = new UsersInventoryApi();
String userId = "userId_example"; // String | The id of the user to check for or 'me' for logged in user
Integer itemId = 56; // Integer | The id of the item
String sku = "sku_example"; // String | The specific sku of an entitlement_list addition to check entitlement for. This is of very limited and specific use and should generally be left out
String info = "info_example"; // String | Any additional info to add to the log about this use
try {
    apiInstance.useUserEntitlementItem(userId, itemId, sku, info);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersInventoryApi#useUserEntitlementItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The id of the user to check for or &#39;me&#39; for logged in user |
 **itemId** | **Integer**| The id of the item |
 **sku** | **String**| The specific sku of an entitlement_list addition to check entitlement for. This is of very limited and specific use and should generally be left out | [optional]
 **info** | **String**| Any additional info to add to the log about this use | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

