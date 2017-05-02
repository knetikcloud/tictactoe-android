# StoreSalesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCatalogSale**](StoreSalesApi.md#createCatalogSale) | **POST** /store/sales | Create a sale
[**deleteCatalogSale**](StoreSalesApi.md#deleteCatalogSale) | **DELETE** /store/sales/{id} | Delete a sale
[**getCatalogSale**](StoreSalesApi.md#getCatalogSale) | **GET** /store/sales/{id} | Get a single sale
[**getCatalogSales**](StoreSalesApi.md#getCatalogSales) | **GET** /store/sales | List and search sales
[**updateCatalogSale**](StoreSalesApi.md#updateCatalogSale) | **PUT** /store/sales/{id} | Update a sale


<a name="createCatalogSale"></a>
# **createCatalogSale**
> CatalogSale createCatalogSale(catalogSale)

Create a sale

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreSalesApi;

StoreSalesApi apiInstance = new StoreSalesApi();
CatalogSale catalogSale = new CatalogSale(); // CatalogSale | The catalog sale object
try {
    CatalogSale result = apiInstance.createCatalogSale(catalogSale);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreSalesApi#createCatalogSale");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **catalogSale** | [**CatalogSale**](CatalogSale.md)| The catalog sale object | [optional]

### Return type

[**CatalogSale**](CatalogSale.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteCatalogSale"></a>
# **deleteCatalogSale**
> deleteCatalogSale(id)

Delete a sale

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreSalesApi;

StoreSalesApi apiInstance = new StoreSalesApi();
Integer id = 56; // Integer | The id of the sale
try {
    apiInstance.deleteCatalogSale(id);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreSalesApi#deleteCatalogSale");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the sale |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCatalogSale"></a>
# **getCatalogSale**
> CatalogSale getCatalogSale(id)

Get a single sale

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreSalesApi;

StoreSalesApi apiInstance = new StoreSalesApi();
Integer id = 56; // Integer | The id of the sale
try {
    CatalogSale result = apiInstance.getCatalogSale(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreSalesApi#getCatalogSale");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the sale |

### Return type

[**CatalogSale**](CatalogSale.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCatalogSales"></a>
# **getCatalogSales**
> PageResourceCatalogSale getCatalogSales(size, page, order)

List and search sales

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreSalesApi;

StoreSalesApi apiInstance = new StoreSalesApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceCatalogSale result = apiInstance.getCatalogSales(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreSalesApi#getCatalogSales");
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

[**PageResourceCatalogSale**](PageResourceCatalogSale.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateCatalogSale"></a>
# **updateCatalogSale**
> CatalogSale updateCatalogSale(id, catalogSale)

Update a sale

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreSalesApi;

StoreSalesApi apiInstance = new StoreSalesApi();
Integer id = 56; // Integer | The id of the sale
CatalogSale catalogSale = new CatalogSale(); // CatalogSale | The catalog sale object
try {
    CatalogSale result = apiInstance.updateCatalogSale(id, catalogSale);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreSalesApi#updateCatalogSale");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the sale |
 **catalogSale** | [**CatalogSale**](CatalogSale.md)| The catalog sale object | [optional]

### Return type

[**CatalogSale**](CatalogSale.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

