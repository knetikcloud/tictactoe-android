# UsersAddressesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAddress**](UsersAddressesApi.md#createAddress) | **POST** /users/{user_id}/addresses | Create a new address
[**deleteAddress**](UsersAddressesApi.md#deleteAddress) | **DELETE** /users/{user_id}/addresses/{id} | Delete an address
[**getAddress**](UsersAddressesApi.md#getAddress) | **GET** /users/{user_id}/addresses/{id} | Get a single address
[**getAddresses**](UsersAddressesApi.md#getAddresses) | **GET** /users/{user_id}/addresses | List and search addresses
[**updateAddress**](UsersAddressesApi.md#updateAddress) | **PUT** /users/{user_id}/addresses/{id} | Update an address


<a name="createAddress"></a>
# **createAddress**
> SavedAddressResource createAddress(userId, savedAddressResource)

Create a new address

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersAddressesApi;

UsersAddressesApi apiInstance = new UsersAddressesApi();
String userId = "userId_example"; // String | The id of the user
SavedAddressResource savedAddressResource = new SavedAddressResource(); // SavedAddressResource | The new address
try {
    SavedAddressResource result = apiInstance.createAddress(userId, savedAddressResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersAddressesApi#createAddress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The id of the user |
 **savedAddressResource** | [**SavedAddressResource**](SavedAddressResource.md)| The new address | [optional]

### Return type

[**SavedAddressResource**](SavedAddressResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAddress"></a>
# **deleteAddress**
> deleteAddress(userId, id)

Delete an address

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersAddressesApi;

UsersAddressesApi apiInstance = new UsersAddressesApi();
String userId = "userId_example"; // String | The id of the user
Integer id = 56; // Integer | The id of the address
try {
    apiInstance.deleteAddress(userId, id);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersAddressesApi#deleteAddress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The id of the user |
 **id** | **Integer**| The id of the address |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAddress"></a>
# **getAddress**
> SavedAddressResource getAddress(userId, id)

Get a single address

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersAddressesApi;

UsersAddressesApi apiInstance = new UsersAddressesApi();
String userId = "userId_example"; // String | The id of the user
Integer id = 56; // Integer | The id of the address
try {
    SavedAddressResource result = apiInstance.getAddress(userId, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersAddressesApi#getAddress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The id of the user |
 **id** | **Integer**| The id of the address |

### Return type

[**SavedAddressResource**](SavedAddressResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAddresses"></a>
# **getAddresses**
> PageResourceSavedAddressResource getAddresses(userId, size, page, order)

List and search addresses

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersAddressesApi;

UsersAddressesApi apiInstance = new UsersAddressesApi();
String userId = "userId_example"; // String | The id of the user
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceSavedAddressResource result = apiInstance.getAddresses(userId, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersAddressesApi#getAddresses");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The id of the user |
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceSavedAddressResource**](PageResourceSavedAddressResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAddress"></a>
# **updateAddress**
> SavedAddressResource updateAddress(userId, id, savedAddressResource)

Update an address

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersAddressesApi;

UsersAddressesApi apiInstance = new UsersAddressesApi();
String userId = "userId_example"; // String | The id of the user
Integer id = 56; // Integer | The id of the address
SavedAddressResource savedAddressResource = new SavedAddressResource(); // SavedAddressResource | The saved address resource object
try {
    SavedAddressResource result = apiInstance.updateAddress(userId, id, savedAddressResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersAddressesApi#updateAddress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The id of the user |
 **id** | **Integer**| The id of the address |
 **savedAddressResource** | [**SavedAddressResource**](SavedAddressResource.md)| The saved address resource object | [optional]

### Return type

[**SavedAddressResource**](SavedAddressResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

