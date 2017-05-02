# UsersRelationshipsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUserRelationship**](UsersRelationshipsApi.md#createUserRelationship) | **POST** /users/relationships | Create a user relationship
[**deleteUserRelationship**](UsersRelationshipsApi.md#deleteUserRelationship) | **DELETE** /users/relationships/{id} | Delete a user relationship
[**getUserRelationship**](UsersRelationshipsApi.md#getUserRelationship) | **GET** /users/relationships/{id} | Get a user relationship
[**getUserRelationships**](UsersRelationshipsApi.md#getUserRelationships) | **GET** /users/relationships | Get a list of user relationships
[**updateUserRelationship**](UsersRelationshipsApi.md#updateUserRelationship) | **PUT** /users/relationships/{id} | Update a user relationship


<a name="createUserRelationship"></a>
# **createUserRelationship**
> UserRelationshipResource createUserRelationship(relationship)

Create a user relationship

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersRelationshipsApi;

UsersRelationshipsApi apiInstance = new UsersRelationshipsApi();
UserRelationshipResource relationship = new UserRelationshipResource(); // UserRelationshipResource | The new relationship
try {
    UserRelationshipResource result = apiInstance.createUserRelationship(relationship);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersRelationshipsApi#createUserRelationship");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **relationship** | [**UserRelationshipResource**](UserRelationshipResource.md)| The new relationship | [optional]

### Return type

[**UserRelationshipResource**](UserRelationshipResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteUserRelationship"></a>
# **deleteUserRelationship**
> deleteUserRelationship(id)

Delete a user relationship

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersRelationshipsApi;

UsersRelationshipsApi apiInstance = new UsersRelationshipsApi();
Long id = 789L; // Long | The id of the relationship
try {
    apiInstance.deleteUserRelationship(id);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersRelationshipsApi#deleteUserRelationship");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The id of the relationship |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserRelationship"></a>
# **getUserRelationship**
> UserRelationshipResource getUserRelationship(id)

Get a user relationship

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersRelationshipsApi;

UsersRelationshipsApi apiInstance = new UsersRelationshipsApi();
Long id = 789L; // Long | The id of the relationship
try {
    UserRelationshipResource result = apiInstance.getUserRelationship(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersRelationshipsApi#getUserRelationship");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The id of the relationship |

### Return type

[**UserRelationshipResource**](UserRelationshipResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserRelationships"></a>
# **getUserRelationships**
> PageResourceUserRelationshipResource getUserRelationships()

Get a list of user relationships

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersRelationshipsApi;

UsersRelationshipsApi apiInstance = new UsersRelationshipsApi();
try {
    PageResourceUserRelationshipResource result = apiInstance.getUserRelationships();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersRelationshipsApi#getUserRelationships");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**PageResourceUserRelationshipResource**](PageResourceUserRelationshipResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateUserRelationship"></a>
# **updateUserRelationship**
> UserRelationshipResource updateUserRelationship(id, relationship)

Update a user relationship

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersRelationshipsApi;

UsersRelationshipsApi apiInstance = new UsersRelationshipsApi();
Long id = 789L; // Long | The id of the relationship
UserRelationshipResource relationship = new UserRelationshipResource(); // UserRelationshipResource | The new relationship
try {
    UserRelationshipResource result = apiInstance.updateUserRelationship(id, relationship);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersRelationshipsApi#updateUserRelationship");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The id of the relationship |
 **relationship** | [**UserRelationshipResource**](UserRelationshipResource.md)| The new relationship | [optional]

### Return type

[**UserRelationshipResource**](UserRelationshipResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

