# AuthClientsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createClient**](AuthClientsApi.md#createClient) | **POST** /auth/clients | Create a new client
[**deleteClient**](AuthClientsApi.md#deleteClient) | **DELETE** /auth/clients/{client_key} | Delete a client
[**getClient**](AuthClientsApi.md#getClient) | **GET** /auth/clients/{client_key} | Get a single client
[**getClientGrantTypes**](AuthClientsApi.md#getClientGrantTypes) | **GET** /auth/clients/grant-types | List available client grant types
[**getClients**](AuthClientsApi.md#getClients) | **GET** /auth/clients | List and search clients
[**setClientGrantTypes**](AuthClientsApi.md#setClientGrantTypes) | **PUT** /auth/clients/{client_key}/grant-types | Set grant types for a client
[**setClientRedirectUris**](AuthClientsApi.md#setClientRedirectUris) | **PUT** /auth/clients/{client_key}/redirect-uris | Set redirect uris for a client
[**updateClient**](AuthClientsApi.md#updateClient) | **PUT** /auth/clients/{client_key} | Update a client


<a name="createClient"></a>
# **createClient**
> ClientResource createClient(clientResource)

Create a new client

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthClientsApi;

AuthClientsApi apiInstance = new AuthClientsApi();
ClientResource clientResource = new ClientResource(); // ClientResource | The client resource object
try {
    ClientResource result = apiInstance.createClient(clientResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthClientsApi#createClient");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientResource** | [**ClientResource**](ClientResource.md)| The client resource object | [optional]

### Return type

[**ClientResource**](ClientResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteClient"></a>
# **deleteClient**
> deleteClient(clientKey)

Delete a client

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthClientsApi;

AuthClientsApi apiInstance = new AuthClientsApi();
String clientKey = "clientKey_example"; // String | The key of the client
try {
    apiInstance.deleteClient(clientKey);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthClientsApi#deleteClient");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientKey** | **String**| The key of the client |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getClient"></a>
# **getClient**
> ClientResource getClient(clientKey)

Get a single client

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthClientsApi;

AuthClientsApi apiInstance = new AuthClientsApi();
String clientKey = "clientKey_example"; // String | The key of the client
try {
    ClientResource result = apiInstance.getClient(clientKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthClientsApi#getClient");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientKey** | **String**| The key of the client |

### Return type

[**ClientResource**](ClientResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getClientGrantTypes"></a>
# **getClientGrantTypes**
> List&lt;GrantTypeResource&gt; getClientGrantTypes()

List available client grant types

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthClientsApi;

AuthClientsApi apiInstance = new AuthClientsApi();
try {
    List<GrantTypeResource> result = apiInstance.getClientGrantTypes();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthClientsApi#getClientGrantTypes");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;GrantTypeResource&gt;**](GrantTypeResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getClients"></a>
# **getClients**
> PageResourceClientResource getClients(size, page, order)

List and search clients

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthClientsApi;

AuthClientsApi apiInstance = new AuthClientsApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceClientResource result = apiInstance.getClients(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthClientsApi#getClients");
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

[**PageResourceClientResource**](PageResourceClientResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setClientGrantTypes"></a>
# **setClientGrantTypes**
> setClientGrantTypes(clientKey, grantList)

Set grant types for a client

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthClientsApi;

AuthClientsApi apiInstance = new AuthClientsApi();
String clientKey = "clientKey_example"; // String | The key of the client
List<String> grantList = Arrays.asList(new List<String>()); // List<String> | A list of unique grant types
try {
    apiInstance.setClientGrantTypes(clientKey, grantList);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthClientsApi#setClientGrantTypes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientKey** | **String**| The key of the client |
 **grantList** | **List&lt;String&gt;**| A list of unique grant types | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setClientRedirectUris"></a>
# **setClientRedirectUris**
> setClientRedirectUris(clientKey, redirectList)

Set redirect uris for a client

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthClientsApi;

AuthClientsApi apiInstance = new AuthClientsApi();
String clientKey = "clientKey_example"; // String | The key of the client
List<String> redirectList = Arrays.asList(new List<String>()); // List<String> | A list of unique redirect uris
try {
    apiInstance.setClientRedirectUris(clientKey, redirectList);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthClientsApi#setClientRedirectUris");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientKey** | **String**| The key of the client |
 **redirectList** | **List&lt;String&gt;**| A list of unique redirect uris | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateClient"></a>
# **updateClient**
> ClientResource updateClient(clientKey, clientResource)

Update a client

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthClientsApi;

AuthClientsApi apiInstance = new AuthClientsApi();
String clientKey = "clientKey_example"; // String | The key of the client
ClientResource clientResource = new ClientResource(); // ClientResource | The client resource object
try {
    ClientResource result = apiInstance.updateClient(clientKey, clientResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthClientsApi#updateClient");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientKey** | **String**| The key of the client |
 **clientResource** | [**ClientResource**](ClientResource.md)| The client resource object | [optional]

### Return type

[**ClientResource**](ClientResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

