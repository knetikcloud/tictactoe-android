# ConfigsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createConfig**](ConfigsApi.md#createConfig) | **POST** /configs | Create a new config
[**deleteConfig**](ConfigsApi.md#deleteConfig) | **DELETE** /configs/{name} | Delete an existing config
[**getConfig**](ConfigsApi.md#getConfig) | **GET** /configs/{name} | Get a single config
[**getConfigs**](ConfigsApi.md#getConfigs) | **GET** /configs | List and search configs
[**updateConfig**](ConfigsApi.md#updateConfig) | **PUT** /configs/{name} | Update an existing config


<a name="createConfig"></a>
# **createConfig**
> Config createConfig(config)

Create a new config

### Example
```java
// Import classes:
//import com.knetikcloud.api.ConfigsApi;

ConfigsApi apiInstance = new ConfigsApi();
Config config = new Config(); // Config | The config object
try {
    Config result = apiInstance.createConfig(config);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConfigsApi#createConfig");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **config** | [**Config**](Config.md)| The config object | [optional]

### Return type

[**Config**](Config.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteConfig"></a>
# **deleteConfig**
> deleteConfig(name)

Delete an existing config

### Example
```java
// Import classes:
//import com.knetikcloud.api.ConfigsApi;

ConfigsApi apiInstance = new ConfigsApi();
String name = "name_example"; // String | The config name
try {
    apiInstance.deleteConfig(name);
} catch (ApiException e) {
    System.err.println("Exception when calling ConfigsApi#deleteConfig");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The config name |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConfig"></a>
# **getConfig**
> Config getConfig(name)

Get a single config

Only configs that are public readable will be shown without admin access

### Example
```java
// Import classes:
//import com.knetikcloud.api.ConfigsApi;

ConfigsApi apiInstance = new ConfigsApi();
String name = "name_example"; // String | The config name
try {
    Config result = apiInstance.getConfig(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConfigsApi#getConfig");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The config name |

### Return type

[**Config**](Config.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConfigs"></a>
# **getConfigs**
> PageResourceConfig getConfigs(filterSearch, size, page, order)

List and search configs

### Example
```java
// Import classes:
//import com.knetikcloud.api.ConfigsApi;

ConfigsApi apiInstance = new ConfigsApi();
String filterSearch = "filterSearch_example"; // String | Filter for configs whose name contains the given string
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned
String order = "1"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceConfig result = apiInstance.getConfigs(filterSearch, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConfigsApi#getConfigs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterSearch** | **String**| Filter for configs whose name contains the given string | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to 1]

### Return type

[**PageResourceConfig**](PageResourceConfig.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateConfig"></a>
# **updateConfig**
> updateConfig(name, config)

Update an existing config

### Example
```java
// Import classes:
//import com.knetikcloud.api.ConfigsApi;

ConfigsApi apiInstance = new ConfigsApi();
String name = "name_example"; // String | The config name
Config config = new Config(); // Config | The config object
try {
    apiInstance.updateConfig(name, config);
} catch (ApiException e) {
    System.err.println("Exception when calling ConfigsApi#updateConfig");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The config name |
 **config** | [**Config**](Config.md)| The config object | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

