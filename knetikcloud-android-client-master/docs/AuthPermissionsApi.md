# AuthPermissionsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPermission**](AuthPermissionsApi.md#createPermission) | **POST** /auth/permissions | Create a new permission
[**deletePermission**](AuthPermissionsApi.md#deletePermission) | **DELETE** /auth/permissions/{permission} | Delete a permission
[**getPermission**](AuthPermissionsApi.md#getPermission) | **GET** /auth/permissions/{permission} | Get a single permission
[**getPermissions**](AuthPermissionsApi.md#getPermissions) | **GET** /auth/permissions | List and search permissions
[**updatePermission**](AuthPermissionsApi.md#updatePermission) | **PUT** /auth/permissions/{permission} | Update a permission


<a name="createPermission"></a>
# **createPermission**
> PermissionResource createPermission(permissionResource)

Create a new permission

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthPermissionsApi;

AuthPermissionsApi apiInstance = new AuthPermissionsApi();
PermissionResource permissionResource = new PermissionResource(); // PermissionResource | The permission resource object
try {
    PermissionResource result = apiInstance.createPermission(permissionResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthPermissionsApi#createPermission");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **permissionResource** | [**PermissionResource**](PermissionResource.md)| The permission resource object | [optional]

### Return type

[**PermissionResource**](PermissionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deletePermission"></a>
# **deletePermission**
> deletePermission(permission, force)

Delete a permission

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthPermissionsApi;

AuthPermissionsApi apiInstance = new AuthPermissionsApi();
String permission = "permission_example"; // String | The permission value
Boolean force = true; // Boolean | If true, removes permission assigned to roles
try {
    apiInstance.deletePermission(permission, force);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthPermissionsApi#deletePermission");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **permission** | **String**| The permission value |
 **force** | **Boolean**| If true, removes permission assigned to roles | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getPermission"></a>
# **getPermission**
> PermissionResource getPermission(permission)

Get a single permission

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthPermissionsApi;

AuthPermissionsApi apiInstance = new AuthPermissionsApi();
String permission = "permission_example"; // String | The permission value
try {
    PermissionResource result = apiInstance.getPermission(permission);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthPermissionsApi#getPermission");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **permission** | **String**| The permission value |

### Return type

[**PermissionResource**](PermissionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getPermissions"></a>
# **getPermissions**
> PageResourcePermissionResource getPermissions(size, page, order)

List and search permissions

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthPermissionsApi;

AuthPermissionsApi apiInstance = new AuthPermissionsApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "permission:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourcePermissionResource result = apiInstance.getPermissions(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthPermissionsApi#getPermissions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to permission:ASC]

### Return type

[**PageResourcePermissionResource**](PageResourcePermissionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updatePermission"></a>
# **updatePermission**
> PermissionResource updatePermission(permission, permissionResource)

Update a permission

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthPermissionsApi;

AuthPermissionsApi apiInstance = new AuthPermissionsApi();
String permission = "permission_example"; // String | The permission value
PermissionResource permissionResource = new PermissionResource(); // PermissionResource | The permission resource object
try {
    PermissionResource result = apiInstance.updatePermission(permission, permissionResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthPermissionsApi#updatePermission");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **permission** | **String**| The permission value |
 **permissionResource** | [**PermissionResource**](PermissionResource.md)| The permission resource object | [optional]

### Return type

[**PermissionResource**](PermissionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

