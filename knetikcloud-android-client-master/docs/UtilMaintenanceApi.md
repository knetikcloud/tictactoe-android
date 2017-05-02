# UtilMaintenanceApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteMaintenance**](UtilMaintenanceApi.md#deleteMaintenance) | **DELETE** /maintenance | Delete maintenance info
[**getMaintenance**](UtilMaintenanceApi.md#getMaintenance) | **GET** /maintenance | Get current maintenance info
[**setMaintenance**](UtilMaintenanceApi.md#setMaintenance) | **POST** /maintenance | Set current maintenance info
[**updateMaintenance**](UtilMaintenanceApi.md#updateMaintenance) | **PUT** /maintenance | Update current maintenance info


<a name="deleteMaintenance"></a>
# **deleteMaintenance**
> deleteMaintenance()

Delete maintenance info

### Example
```java
// Import classes:
//import com.knetikcloud.api.UtilMaintenanceApi;

UtilMaintenanceApi apiInstance = new UtilMaintenanceApi();
try {
    apiInstance.deleteMaintenance();
} catch (ApiException e) {
    System.err.println("Exception when calling UtilMaintenanceApi#deleteMaintenance");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getMaintenance"></a>
# **getMaintenance**
> Maintenance getMaintenance()

Get current maintenance info

Get current maintenance info. 404 if no maintenance.

### Example
```java
// Import classes:
//import com.knetikcloud.api.UtilMaintenanceApi;

UtilMaintenanceApi apiInstance = new UtilMaintenanceApi();
try {
    Maintenance result = apiInstance.getMaintenance();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilMaintenanceApi#getMaintenance");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Maintenance**](Maintenance.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setMaintenance"></a>
# **setMaintenance**
> setMaintenance(maintenance)

Set current maintenance info

### Example
```java
// Import classes:
//import com.knetikcloud.api.UtilMaintenanceApi;

UtilMaintenanceApi apiInstance = new UtilMaintenanceApi();
Maintenance maintenance = new Maintenance(); // Maintenance | The maintenance object
try {
    apiInstance.setMaintenance(maintenance);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilMaintenanceApi#setMaintenance");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **maintenance** | [**Maintenance**](Maintenance.md)| The maintenance object | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateMaintenance"></a>
# **updateMaintenance**
> updateMaintenance(maintenance)

Update current maintenance info

### Example
```java
// Import classes:
//import com.knetikcloud.api.UtilMaintenanceApi;

UtilMaintenanceApi apiInstance = new UtilMaintenanceApi();
Maintenance maintenance = new Maintenance(); // Maintenance | The maintenance object
try {
    apiInstance.updateMaintenance(maintenance);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilMaintenanceApi#updateMaintenance");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **maintenance** | [**Maintenance**](Maintenance.md)| The maintenance object | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

