# DevicesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createDevice**](DevicesApi.md#createDevice) | **POST** /devices | Create a device
[**deleteDevice**](DevicesApi.md#deleteDevice) | **DELETE** /devices/{id} | Delete a device
[**getDevice**](DevicesApi.md#getDevice) | **GET** /devices/{id} | Get a single device
[**getDevices**](DevicesApi.md#getDevices) | **GET** /devices | List and search devices
[**updateDevice**](DevicesApi.md#updateDevice) | **PUT** /devices/{id} | Update a device


<a name="createDevice"></a>
# **createDevice**
> DeviceResource createDevice(device)

Create a device

### Example
```java
// Import classes:
//import com.knetikcloud.api.DevicesApi;

DevicesApi apiInstance = new DevicesApi();
DeviceResource device = new DeviceResource(); // DeviceResource | device
try {
    DeviceResource result = apiInstance.createDevice(device);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DevicesApi#createDevice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **device** | [**DeviceResource**](DeviceResource.md)| device |

### Return type

[**DeviceResource**](DeviceResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteDevice"></a>
# **deleteDevice**
> deleteDevice(id)

Delete a device

### Example
```java
// Import classes:
//import com.knetikcloud.api.DevicesApi;

DevicesApi apiInstance = new DevicesApi();
Integer id = 56; // Integer | id
try {
    apiInstance.deleteDevice(id);
} catch (ApiException e) {
    System.err.println("Exception when calling DevicesApi#deleteDevice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getDevice"></a>
# **getDevice**
> DeviceResource getDevice(id)

Get a single device

### Example
```java
// Import classes:
//import com.knetikcloud.api.DevicesApi;

DevicesApi apiInstance = new DevicesApi();
Integer id = 56; // Integer | id
try {
    DeviceResource result = apiInstance.getDevice(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DevicesApi#getDevice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id |

### Return type

[**DeviceResource**](DeviceResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getDevices"></a>
# **getDevices**
> PageResourceDeviceResource getDevices(filterMake, filterModel, size, page, order)

List and search devices

Get a list of devices with optional filtering

### Example
```java
// Import classes:
//import com.knetikcloud.api.DevicesApi;

DevicesApi apiInstance = new DevicesApi();
String filterMake = "filterMake_example"; // String | Filter for devices with specified make
String filterModel = "filterModel_example"; // String | Filter for devices with specified model
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceDeviceResource result = apiInstance.getDevices(filterMake, filterModel, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DevicesApi#getDevices");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterMake** | **String**| Filter for devices with specified make | [optional]
 **filterModel** | **String**| Filter for devices with specified model | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceDeviceResource**](PageResourceDeviceResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateDevice"></a>
# **updateDevice**
> DeviceResource updateDevice(device, id)

Update a device

### Example
```java
// Import classes:
//import com.knetikcloud.api.DevicesApi;

DevicesApi apiInstance = new DevicesApi();
DeviceResource device = new DeviceResource(); // DeviceResource | device
Integer id = 56; // Integer | id
try {
    DeviceResource result = apiInstance.updateDevice(device, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DevicesApi#updateDevice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **device** | [**DeviceResource**](DeviceResource.md)| device |
 **id** | **Integer**| id |

### Return type

[**DeviceResource**](DeviceResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

