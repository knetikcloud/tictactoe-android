# AuthRolesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createRole**](AuthRolesApi.md#createRole) | **POST** /auth/roles | Create a new role
[**deleteRole**](AuthRolesApi.md#deleteRole) | **DELETE** /auth/roles/{role} | Delete a role
[**getClientRoles**](AuthRolesApi.md#getClientRoles) | **GET** /auth/clients/{client_key}/roles | Get roles for a client
[**getRole**](AuthRolesApi.md#getRole) | **GET** /auth/roles/{role} | Get a single role
[**getRoles**](AuthRolesApi.md#getRoles) | **GET** /auth/roles | List and search roles
[**getUserRoles**](AuthRolesApi.md#getUserRoles) | **GET** /auth/users/{user_id}/roles | Get roles for a user
[**setClientRoles**](AuthRolesApi.md#setClientRoles) | **PUT** /auth/clients/{client_key}/roles | Set roles for a client
[**setPermissionsForRole**](AuthRolesApi.md#setPermissionsForRole) | **PUT** /auth/roles/{role}/permissions | Set permissions for a role
[**setUserRoles**](AuthRolesApi.md#setUserRoles) | **PUT** /auth/users/{user_id}/roles | Set roles for a user
[**updateRole**](AuthRolesApi.md#updateRole) | **PUT** /auth/roles/{role} | Update a role


<a name="createRole"></a>
# **createRole**
> RoleResource createRole(roleResource)

Create a new role

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthRolesApi;

AuthRolesApi apiInstance = new AuthRolesApi();
RoleResource roleResource = new RoleResource(); // RoleResource | The role resource object
try {
    RoleResource result = apiInstance.createRole(roleResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthRolesApi#createRole");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **roleResource** | [**RoleResource**](RoleResource.md)| The role resource object | [optional]

### Return type

[**RoleResource**](RoleResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteRole"></a>
# **deleteRole**
> deleteRole(role, force)

Delete a role

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthRolesApi;

AuthRolesApi apiInstance = new AuthRolesApi();
String role = "role_example"; // String | The role value
Boolean force = true; // Boolean | If true, removes role from users/clients
try {
    apiInstance.deleteRole(role, force);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthRolesApi#deleteRole");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **role** | **String**| The role value |
 **force** | **Boolean**| If true, removes role from users/clients | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getClientRoles"></a>
# **getClientRoles**
> List&lt;RoleResource&gt; getClientRoles(clientKey)

Get roles for a client

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthRolesApi;

AuthRolesApi apiInstance = new AuthRolesApi();
String clientKey = "clientKey_example"; // String | The client key
try {
    List<RoleResource> result = apiInstance.getClientRoles(clientKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthRolesApi#getClientRoles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientKey** | **String**| The client key |

### Return type

[**List&lt;RoleResource&gt;**](RoleResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getRole"></a>
# **getRole**
> RoleResource getRole(role)

Get a single role

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthRolesApi;

AuthRolesApi apiInstance = new AuthRolesApi();
String role = "role_example"; // String | The role value
try {
    RoleResource result = apiInstance.getRole(role);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthRolesApi#getRole");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **role** | **String**| The role value |

### Return type

[**RoleResource**](RoleResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getRoles"></a>
# **getRoles**
> PageResourceRoleResource getRoles(size, page, order)

List and search roles

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthRolesApi;

AuthRolesApi apiInstance = new AuthRolesApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "name:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceRoleResource result = apiInstance.getRoles(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthRolesApi#getRoles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to name:ASC]

### Return type

[**PageResourceRoleResource**](PageResourceRoleResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserRoles"></a>
# **getUserRoles**
> List&lt;RoleResource&gt; getUserRoles(userId)

Get roles for a user

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthRolesApi;

AuthRolesApi apiInstance = new AuthRolesApi();
Integer userId = 56; // Integer | The user's id
try {
    List<RoleResource> result = apiInstance.getUserRoles(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthRolesApi#getUserRoles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The user&#39;s id |

### Return type

[**List&lt;RoleResource&gt;**](RoleResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setClientRoles"></a>
# **setClientRoles**
> ClientResource setClientRoles(clientKey, rolesList)

Set roles for a client

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthRolesApi;

AuthRolesApi apiInstance = new AuthRolesApi();
String clientKey = "clientKey_example"; // String | The client key
List<String> rolesList = Arrays.asList(new List<String>()); // List<String> | The list of unique roles
try {
    ClientResource result = apiInstance.setClientRoles(clientKey, rolesList);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthRolesApi#setClientRoles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientKey** | **String**| The client key |
 **rolesList** | **List&lt;String&gt;**| The list of unique roles | [optional]

### Return type

[**ClientResource**](ClientResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setPermissionsForRole"></a>
# **setPermissionsForRole**
> RoleResource setPermissionsForRole(role, permissionsList)

Set permissions for a role

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthRolesApi;

AuthRolesApi apiInstance = new AuthRolesApi();
String role = "role_example"; // String | The role value
List<String> permissionsList = Arrays.asList(new List<String>()); // List<String> | The list of unique permissions
try {
    RoleResource result = apiInstance.setPermissionsForRole(role, permissionsList);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthRolesApi#setPermissionsForRole");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **role** | **String**| The role value |
 **permissionsList** | **List&lt;String&gt;**| The list of unique permissions | [optional]

### Return type

[**RoleResource**](RoleResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setUserRoles"></a>
# **setUserRoles**
> UserResource setUserRoles(userId, rolesList)

Set roles for a user

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthRolesApi;

AuthRolesApi apiInstance = new AuthRolesApi();
Integer userId = 56; // Integer | The user's id
List<String> rolesList = Arrays.asList(new List<String>()); // List<String> | The list of unique roles
try {
    UserResource result = apiInstance.setUserRoles(userId, rolesList);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthRolesApi#setUserRoles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The user&#39;s id |
 **rolesList** | **List&lt;String&gt;**| The list of unique roles | [optional]

### Return type

[**UserResource**](UserResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateRole"></a>
# **updateRole**
> RoleResource updateRole(role, roleResource)

Update a role

### Example
```java
// Import classes:
//import com.knetikcloud.api.AuthRolesApi;

AuthRolesApi apiInstance = new AuthRolesApi();
String role = "role_example"; // String | The role value
RoleResource roleResource = new RoleResource(); // RoleResource | The role resource object
try {
    RoleResource result = apiInstance.updateRole(role, roleResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthRolesApi#updateRole");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **role** | **String**| The role value |
 **roleResource** | [**RoleResource**](RoleResource.md)| The role resource object | [optional]

### Return type

[**RoleResource**](RoleResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

