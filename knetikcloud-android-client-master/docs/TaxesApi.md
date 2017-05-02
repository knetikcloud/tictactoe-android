# TaxesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCountryTax**](TaxesApi.md#createCountryTax) | **POST** /tax/countries | Create a country tax
[**createStateTax**](TaxesApi.md#createStateTax) | **POST** /tax/countries/{country_code_iso3}/states | Create a state tax
[**deleteCountryTax**](TaxesApi.md#deleteCountryTax) | **DELETE** /tax/countries/{country_code_iso3} | Delete an existing tax
[**deleteStateTax**](TaxesApi.md#deleteStateTax) | **DELETE** /tax/countries/{country_code_iso3}/states/{state_code} | Delete an existing state tax
[**getCountryTax**](TaxesApi.md#getCountryTax) | **GET** /tax/countries/{country_code_iso3} | Get a single tax
[**getCountryTaxes**](TaxesApi.md#getCountryTaxes) | **GET** /tax/countries | List and search taxes
[**getStateTax**](TaxesApi.md#getStateTax) | **GET** /tax/countries/{country_code_iso3}/states/{state_code} | Get a single state tax
[**getStateTaxesForCountries**](TaxesApi.md#getStateTaxesForCountries) | **GET** /tax/states | List and search taxes across all countries
[**getStateTaxesForCountry**](TaxesApi.md#getStateTaxesForCountry) | **GET** /tax/countries/{country_code_iso3}/states | List and search taxes within a country
[**updateCountryTax**](TaxesApi.md#updateCountryTax) | **PUT** /tax/countries/{country_code_iso3} | Create or update a tax
[**updateStateTax**](TaxesApi.md#updateStateTax) | **PUT** /tax/countries/{country_code_iso3}/states/{state_code} | Create or update a state tax


<a name="createCountryTax"></a>
# **createCountryTax**
> CountryTaxResource createCountryTax(taxResource)

Create a country tax

### Example
```java
// Import classes:
//import com.knetikcloud.api.TaxesApi;

TaxesApi apiInstance = new TaxesApi();
CountryTaxResource taxResource = new CountryTaxResource(); // CountryTaxResource | The tax object
try {
    CountryTaxResource result = apiInstance.createCountryTax(taxResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaxesApi#createCountryTax");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taxResource** | [**CountryTaxResource**](CountryTaxResource.md)| The tax object | [optional]

### Return type

[**CountryTaxResource**](CountryTaxResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createStateTax"></a>
# **createStateTax**
> StateTaxResource createStateTax(countryCodeIso3, taxResource)

Create a state tax

### Example
```java
// Import classes:
//import com.knetikcloud.api.TaxesApi;

TaxesApi apiInstance = new TaxesApi();
String countryCodeIso3 = "countryCodeIso3_example"; // String | The iso3 code of the country
StateTaxResource taxResource = new StateTaxResource(); // StateTaxResource | The tax object
try {
    StateTaxResource result = apiInstance.createStateTax(countryCodeIso3, taxResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaxesApi#createStateTax");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **countryCodeIso3** | **String**| The iso3 code of the country |
 **taxResource** | [**StateTaxResource**](StateTaxResource.md)| The tax object | [optional]

### Return type

[**StateTaxResource**](StateTaxResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteCountryTax"></a>
# **deleteCountryTax**
> deleteCountryTax(countryCodeIso3)

Delete an existing tax

### Example
```java
// Import classes:
//import com.knetikcloud.api.TaxesApi;

TaxesApi apiInstance = new TaxesApi();
String countryCodeIso3 = "countryCodeIso3_example"; // String | The iso3 code of the country
try {
    apiInstance.deleteCountryTax(countryCodeIso3);
} catch (ApiException e) {
    System.err.println("Exception when calling TaxesApi#deleteCountryTax");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **countryCodeIso3** | **String**| The iso3 code of the country |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteStateTax"></a>
# **deleteStateTax**
> deleteStateTax(countryCodeIso3, stateCode)

Delete an existing state tax

### Example
```java
// Import classes:
//import com.knetikcloud.api.TaxesApi;

TaxesApi apiInstance = new TaxesApi();
String countryCodeIso3 = "countryCodeIso3_example"; // String | The iso3 code of the country
String stateCode = "stateCode_example"; // String | The code of the state
try {
    apiInstance.deleteStateTax(countryCodeIso3, stateCode);
} catch (ApiException e) {
    System.err.println("Exception when calling TaxesApi#deleteStateTax");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **countryCodeIso3** | **String**| The iso3 code of the country |
 **stateCode** | **String**| The code of the state |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCountryTax"></a>
# **getCountryTax**
> CountryTaxResource getCountryTax(countryCodeIso3)

Get a single tax

### Example
```java
// Import classes:
//import com.knetikcloud.api.TaxesApi;

TaxesApi apiInstance = new TaxesApi();
String countryCodeIso3 = "countryCodeIso3_example"; // String | The iso3 code of the country
try {
    CountryTaxResource result = apiInstance.getCountryTax(countryCodeIso3);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaxesApi#getCountryTax");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **countryCodeIso3** | **String**| The iso3 code of the country |

### Return type

[**CountryTaxResource**](CountryTaxResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCountryTaxes"></a>
# **getCountryTaxes**
> PageResourceCountryTaxResource getCountryTaxes(size, page, order)

List and search taxes

Get a list of taxes

### Example
```java
// Import classes:
//import com.knetikcloud.api.TaxesApi;

TaxesApi apiInstance = new TaxesApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned
String order = "name:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceCountryTaxResource result = apiInstance.getCountryTaxes(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaxesApi#getCountryTaxes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to name:ASC]

### Return type

[**PageResourceCountryTaxResource**](PageResourceCountryTaxResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getStateTax"></a>
# **getStateTax**
> StateTaxResource getStateTax(countryCodeIso3, stateCode)

Get a single state tax

### Example
```java
// Import classes:
//import com.knetikcloud.api.TaxesApi;

TaxesApi apiInstance = new TaxesApi();
String countryCodeIso3 = "countryCodeIso3_example"; // String | The iso3 code of the country
String stateCode = "stateCode_example"; // String | The code of the state
try {
    StateTaxResource result = apiInstance.getStateTax(countryCodeIso3, stateCode);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaxesApi#getStateTax");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **countryCodeIso3** | **String**| The iso3 code of the country |
 **stateCode** | **String**| The code of the state |

### Return type

[**StateTaxResource**](StateTaxResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getStateTaxesForCountries"></a>
# **getStateTaxesForCountries**
> PageResourceStateTaxResource getStateTaxesForCountries(size, page, order)

List and search taxes across all countries

Get a list of taxes

### Example
```java
// Import classes:
//import com.knetikcloud.api.TaxesApi;

TaxesApi apiInstance = new TaxesApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned
String order = "name:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceStateTaxResource result = apiInstance.getStateTaxesForCountries(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaxesApi#getStateTaxesForCountries");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to name:ASC]

### Return type

[**PageResourceStateTaxResource**](PageResourceStateTaxResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getStateTaxesForCountry"></a>
# **getStateTaxesForCountry**
> PageResourceStateTaxResource getStateTaxesForCountry(countryCodeIso3, size, page, order)

List and search taxes within a country

Get a list of taxes

### Example
```java
// Import classes:
//import com.knetikcloud.api.TaxesApi;

TaxesApi apiInstance = new TaxesApi();
String countryCodeIso3 = "countryCodeIso3_example"; // String | The iso3 code of the country
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned
String order = "name:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceStateTaxResource result = apiInstance.getStateTaxesForCountry(countryCodeIso3, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaxesApi#getStateTaxesForCountry");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **countryCodeIso3** | **String**| The iso3 code of the country |
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to name:ASC]

### Return type

[**PageResourceStateTaxResource**](PageResourceStateTaxResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateCountryTax"></a>
# **updateCountryTax**
> CountryTaxResource updateCountryTax(countryCodeIso3, taxResource)

Create or update a tax

### Example
```java
// Import classes:
//import com.knetikcloud.api.TaxesApi;

TaxesApi apiInstance = new TaxesApi();
String countryCodeIso3 = "countryCodeIso3_example"; // String | The iso3 code of the country
CountryTaxResource taxResource = new CountryTaxResource(); // CountryTaxResource | The tax object
try {
    CountryTaxResource result = apiInstance.updateCountryTax(countryCodeIso3, taxResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaxesApi#updateCountryTax");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **countryCodeIso3** | **String**| The iso3 code of the country |
 **taxResource** | [**CountryTaxResource**](CountryTaxResource.md)| The tax object | [optional]

### Return type

[**CountryTaxResource**](CountryTaxResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateStateTax"></a>
# **updateStateTax**
> StateTaxResource updateStateTax(countryCodeIso3, stateCode, taxResource)

Create or update a state tax

### Example
```java
// Import classes:
//import com.knetikcloud.api.TaxesApi;

TaxesApi apiInstance = new TaxesApi();
String countryCodeIso3 = "countryCodeIso3_example"; // String | The iso3 code of the country
String stateCode = "stateCode_example"; // String | The code of the state
StateTaxResource taxResource = new StateTaxResource(); // StateTaxResource | The tax object
try {
    StateTaxResource result = apiInstance.updateStateTax(countryCodeIso3, stateCode, taxResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaxesApi#updateStateTax");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **countryCodeIso3** | **String**| The iso3 code of the country |
 **stateCode** | **String**| The code of the state |
 **taxResource** | [**StateTaxResource**](StateTaxResource.md)| The tax object | [optional]

### Return type

[**StateTaxResource**](StateTaxResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

