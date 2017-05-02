# LocationsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCountries**](LocationsApi.md#getCountries) | **GET** /location/countries | Get a list of countries
[**getCountryByGeoLocation**](LocationsApi.md#getCountryByGeoLocation) | **GET** /location/geolocation/country | Get the iso3 code of your country
[**getCountryStates**](LocationsApi.md#getCountryStates) | **GET** /location/countries/{country_code_iso3}/states | Get a list of a country&#39;s states
[**getCurrencyByGeoLocation**](LocationsApi.md#getCurrencyByGeoLocation) | **GET** /location/geolocation/currency | Get the currency information of your country


<a name="getCountries"></a>
# **getCountries**
> List&lt;CountryResource&gt; getCountries()

Get a list of countries

### Example
```java
// Import classes:
//import com.knetikcloud.api.LocationsApi;

LocationsApi apiInstance = new LocationsApi();
try {
    List<CountryResource> result = apiInstance.getCountries();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LocationsApi#getCountries");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;CountryResource&gt;**](CountryResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCountryByGeoLocation"></a>
# **getCountryByGeoLocation**
> String getCountryByGeoLocation()

Get the iso3 code of your country

Determined by geo ip location

### Example
```java
// Import classes:
//import com.knetikcloud.api.LocationsApi;

LocationsApi apiInstance = new LocationsApi();
try {
    String result = apiInstance.getCountryByGeoLocation();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LocationsApi#getCountryByGeoLocation");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCountryStates"></a>
# **getCountryStates**
> List&lt;StateResource&gt; getCountryStates(countryCodeIso3)

Get a list of a country&#39;s states

### Example
```java
// Import classes:
//import com.knetikcloud.api.LocationsApi;

LocationsApi apiInstance = new LocationsApi();
String countryCodeIso3 = "countryCodeIso3_example"; // String | The iso3 code of the country
try {
    List<StateResource> result = apiInstance.getCountryStates(countryCodeIso3);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LocationsApi#getCountryStates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **countryCodeIso3** | **String**| The iso3 code of the country |

### Return type

[**List&lt;StateResource&gt;**](StateResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCurrencyByGeoLocation"></a>
# **getCurrencyByGeoLocation**
> CurrencyResource getCurrencyByGeoLocation()

Get the currency information of your country

Determined by geo ip location, currency to country mapping and a fallback setting

### Example
```java
// Import classes:
//import com.knetikcloud.api.LocationsApi;

LocationsApi apiInstance = new LocationsApi();
try {
    CurrencyResource result = apiInstance.getCurrencyByGeoLocation();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LocationsApi#getCurrencyByGeoLocation");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**CurrencyResource**](CurrencyResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

