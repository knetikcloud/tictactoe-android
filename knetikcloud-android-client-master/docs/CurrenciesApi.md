# CurrenciesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCurrency**](CurrenciesApi.md#createCurrency) | **POST** /currencies | Create a currency
[**deleteCurrency**](CurrenciesApi.md#deleteCurrency) | **DELETE** /currencies/{code} | Delete a currency
[**getCurrencies**](CurrenciesApi.md#getCurrencies) | **GET** /currencies | List and search currencies
[**getCurrency**](CurrenciesApi.md#getCurrency) | **GET** /currencies/{code} | Get a single currency
[**updateCurrency**](CurrenciesApi.md#updateCurrency) | **PUT** /currencies/{code} | Update a currency


<a name="createCurrency"></a>
# **createCurrency**
> CurrencyResource createCurrency(currency)

Create a currency

### Example
```java
// Import classes:
//import com.knetikcloud.api.CurrenciesApi;

CurrenciesApi apiInstance = new CurrenciesApi();
CurrencyResource currency = new CurrencyResource(); // CurrencyResource | The currency object
try {
    CurrencyResource result = apiInstance.createCurrency(currency);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CurrenciesApi#createCurrency");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **currency** | [**CurrencyResource**](CurrencyResource.md)| The currency object | [optional]

### Return type

[**CurrencyResource**](CurrencyResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteCurrency"></a>
# **deleteCurrency**
> deleteCurrency(code)

Delete a currency

### Example
```java
// Import classes:
//import com.knetikcloud.api.CurrenciesApi;

CurrenciesApi apiInstance = new CurrenciesApi();
String code = "code_example"; // String | The currency code
try {
    apiInstance.deleteCurrency(code);
} catch (ApiException e) {
    System.err.println("Exception when calling CurrenciesApi#deleteCurrency");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **code** | **String**| The currency code |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCurrencies"></a>
# **getCurrencies**
> PageResourceCurrencyResource getCurrencies(filterEnabledCurrencies, filterType, size, page, order)

List and search currencies

### Example
```java
// Import classes:
//import com.knetikcloud.api.CurrenciesApi;

CurrenciesApi apiInstance = new CurrenciesApi();
Boolean filterEnabledCurrencies = true; // Boolean | Filter for alternate currencies setup explicitely in system config
String filterType = "filterType_example"; // String | Filter currencies by type.  Allowable values: ('virtual', 'real')
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "name:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceCurrencyResource result = apiInstance.getCurrencies(filterEnabledCurrencies, filterType, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CurrenciesApi#getCurrencies");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterEnabledCurrencies** | **Boolean**| Filter for alternate currencies setup explicitely in system config | [optional]
 **filterType** | **String**| Filter currencies by type.  Allowable values: (&#39;virtual&#39;, &#39;real&#39;) | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to name:ASC]

### Return type

[**PageResourceCurrencyResource**](PageResourceCurrencyResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCurrency"></a>
# **getCurrency**
> CurrencyResource getCurrency(code)

Get a single currency

### Example
```java
// Import classes:
//import com.knetikcloud.api.CurrenciesApi;

CurrenciesApi apiInstance = new CurrenciesApi();
String code = "code_example"; // String | The currency code
try {
    CurrencyResource result = apiInstance.getCurrency(code);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CurrenciesApi#getCurrency");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **code** | **String**| The currency code |

### Return type

[**CurrencyResource**](CurrencyResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateCurrency"></a>
# **updateCurrency**
> updateCurrency(code, currency)

Update a currency

### Example
```java
// Import classes:
//import com.knetikcloud.api.CurrenciesApi;

CurrenciesApi apiInstance = new CurrenciesApi();
String code = "code_example"; // String | The currency code
CurrencyResource currency = new CurrencyResource(); // CurrencyResource | The currency object
try {
    apiInstance.updateCurrency(code, currency);
} catch (ApiException e) {
    System.err.println("Exception when calling CurrenciesApi#updateCurrency");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **code** | **String**| The currency code |
 **currency** | [**CurrencyResource**](CurrencyResource.md)| The currency object | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

