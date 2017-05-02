# UsersApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addUserTag**](UsersApi.md#addUserTag) | **POST** /users/{user_id}/tags | Add a tag to a user
[**createUserTemplate**](UsersApi.md#createUserTemplate) | **POST** /users/templates | Create a user template
[**deleteUserTemplate**](UsersApi.md#deleteUserTemplate) | **DELETE** /users/templates/{id} | Delete a user template
[**getUser**](UsersApi.md#getUser) | **GET** /users/{id} | Get a single user
[**getUserTags**](UsersApi.md#getUserTags) | **GET** /users/{user_id}/tags | List tags for a user
[**getUserTemplate**](UsersApi.md#getUserTemplate) | **GET** /users/templates/{id} | Get a single user template
[**getUserTemplates**](UsersApi.md#getUserTemplates) | **GET** /users/templates | List and search user templates
[**getUsers**](UsersApi.md#getUsers) | **GET** /users | List and search users
[**passwordReset**](UsersApi.md#passwordReset) | **PUT** /users/{id}/password-reset | Choose a new password after a reset
[**registerUser**](UsersApi.md#registerUser) | **POST** /users | Register a new user
[**removeUserTag**](UsersApi.md#removeUserTag) | **DELETE** /users/{user_id}/tags/{tag} | Remove a tag from a user
[**setPassword**](UsersApi.md#setPassword) | **PUT** /users/{id}/password | Set a user&#39;s password
[**startPasswordReset**](UsersApi.md#startPasswordReset) | **POST** /users/{id}/password-reset | Reset a user&#39;s password
[**updateUser**](UsersApi.md#updateUser) | **PUT** /users/{id} | Update a user
[**updateUserTemplate**](UsersApi.md#updateUserTemplate) | **PUT** /users/templates/{id} | Update a user template


<a name="addUserTag"></a>
# **addUserTag**
> addUserTag(userId, tag)

Add a tag to a user

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersApi;

UsersApi apiInstance = new UsersApi();
Integer userId = 56; // Integer | The id of the user
String tag = "tag_example"; // String | tag
try {
    apiInstance.addUserTag(userId, tag);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#addUserTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |
 **tag** | **String**| tag |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createUserTemplate"></a>
# **createUserTemplate**
> TemplateResource createUserTemplate(userTemplateResource)

Create a user template

User Templates define a type of user and the properties they have

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersApi;

UsersApi apiInstance = new UsersApi();
TemplateResource userTemplateResource = new TemplateResource(); // TemplateResource | The user template resource object
try {
    TemplateResource result = apiInstance.createUserTemplate(userTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#createUserTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userTemplateResource** | [**TemplateResource**](TemplateResource.md)| The user template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteUserTemplate"></a>
# **deleteUserTemplate**
> deleteUserTemplate(id, cascade)

Delete a user template

If cascade &#x3D; &#39;detach&#39;, it will force delete the template even if it&#39;s attached to other objects

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersApi;

UsersApi apiInstance = new UsersApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | The value needed to delete used templates
try {
    apiInstance.deleteUserTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#deleteUserTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **cascade** | **String**| The value needed to delete used templates | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUser"></a>
# **getUser**
> UserResource getUser(id)

Get a single user

Additional private info is included as USERS_ADMIN

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersApi;

UsersApi apiInstance = new UsersApi();
String id = "id_example"; // String | The id of the user or 'me'
try {
    UserResource result = apiInstance.getUser(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#getUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the user or &#39;me&#39; |

### Return type

[**UserResource**](UserResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserTags"></a>
# **getUserTags**
> List&lt;String&gt; getUserTags(userId)

List tags for a user

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersApi;

UsersApi apiInstance = new UsersApi();
Integer userId = 56; // Integer | The id of the user
try {
    List<String> result = apiInstance.getUserTags(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#getUserTags");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |

### Return type

**List&lt;String&gt;**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserTemplate"></a>
# **getUserTemplate**
> TemplateResource getUserTemplate(id)

Get a single user template

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersApi;

UsersApi apiInstance = new UsersApi();
String id = "id_example"; // String | The id of the template
try {
    TemplateResource result = apiInstance.getUserTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#getUserTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserTemplates"></a>
# **getUserTemplates**
> PageResourceTemplateResource getUserTemplates(size, page, order)

List and search user templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersApi;

UsersApi apiInstance = new UsersApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceTemplateResource result = apiInstance.getUserTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#getUserTemplates");
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

[**PageResourceTemplateResource**](PageResourceTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUsers"></a>
# **getUsers**
> PageResourceUserBaseResource getUsers(filterDisplayname, filterEmail, filterFirstname, filterFullname, filterLastname, filterUsername, filterTag, filterGroup, filterRole, filterSearch, size, page, order)

List and search users

Additional private info is included as USERS_ADMIN

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersApi;

UsersApi apiInstance = new UsersApi();
String filterDisplayname = "filterDisplayname_example"; // String | Filter for users whose display name starts with provided string.
String filterEmail = "filterEmail_example"; // String | Filter for users whose email starts with provided string. Requires USERS_ADMIN permission
String filterFirstname = "filterFirstname_example"; // String | Filter for users whose first name starts with provided string. Requires USERS_ADMIN permission
String filterFullname = "filterFullname_example"; // String | Filter for users whose full name starts with provided string. Requires USERS_ADMIN permission
String filterLastname = "filterLastname_example"; // String | Filter for users whose last name starts with provided string. Requires USERS_ADMIN permission
String filterUsername = "filterUsername_example"; // String | Filter for users whose username starts with the provided string. Requires USERS_ADMIN permission
String filterTag = "filterTag_example"; // String | Filter for users who have a given tag
String filterGroup = "filterGroup_example"; // String | Filter for users in a given group, by unique name
String filterRole = "filterRole_example"; // String | Filter for users with a given role
String filterSearch = "filterSearch_example"; // String | Filter for users whose display_name starts with the provided string, or username if display_name is null
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceUserBaseResource result = apiInstance.getUsers(filterDisplayname, filterEmail, filterFirstname, filterFullname, filterLastname, filterUsername, filterTag, filterGroup, filterRole, filterSearch, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#getUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterDisplayname** | **String**| Filter for users whose display name starts with provided string. | [optional]
 **filterEmail** | **String**| Filter for users whose email starts with provided string. Requires USERS_ADMIN permission | [optional]
 **filterFirstname** | **String**| Filter for users whose first name starts with provided string. Requires USERS_ADMIN permission | [optional]
 **filterFullname** | **String**| Filter for users whose full name starts with provided string. Requires USERS_ADMIN permission | [optional]
 **filterLastname** | **String**| Filter for users whose last name starts with provided string. Requires USERS_ADMIN permission | [optional]
 **filterUsername** | **String**| Filter for users whose username starts with the provided string. Requires USERS_ADMIN permission | [optional]
 **filterTag** | **String**| Filter for users who have a given tag | [optional]
 **filterGroup** | **String**| Filter for users in a given group, by unique name | [optional]
 **filterRole** | **String**| Filter for users with a given role | [optional]
 **filterSearch** | **String**| Filter for users whose display_name starts with the provided string, or username if display_name is null | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceUserBaseResource**](PageResourceUserBaseResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="passwordReset"></a>
# **passwordReset**
> passwordReset(id, newPasswordRequest)

Choose a new password after a reset

Finish resetting a user&#39;s password using the secret provided from the password-reset endpoint.  Password should be in plain text and will be encrypted on receipt. Use SSL for security.

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersApi;

UsersApi apiInstance = new UsersApi();
Integer id = 56; // Integer | The id of the user
NewPasswordRequest newPasswordRequest = new NewPasswordRequest(); // NewPasswordRequest | The new password request object
try {
    apiInstance.passwordReset(id, newPasswordRequest);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#passwordReset");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the user |
 **newPasswordRequest** | [**NewPasswordRequest**](NewPasswordRequest.md)| The new password request object | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="registerUser"></a>
# **registerUser**
> UserResource registerUser(userResource)

Register a new user

Password should be in plain text and will be encrypted on receipt. Use SSL for security

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersApi;

UsersApi apiInstance = new UsersApi();
UserResource userResource = new UserResource(); // UserResource | The user resource object
try {
    UserResource result = apiInstance.registerUser(userResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#registerUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userResource** | [**UserResource**](UserResource.md)| The user resource object | [optional]

### Return type

[**UserResource**](UserResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeUserTag"></a>
# **removeUserTag**
> removeUserTag(userId, tag)

Remove a tag from a user

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersApi;

UsersApi apiInstance = new UsersApi();
Integer userId = 56; // Integer | The id of the user
String tag = "tag_example"; // String | The tag to remove
try {
    apiInstance.removeUserTag(userId, tag);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#removeUserTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |
 **tag** | **String**| The tag to remove |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setPassword"></a>
# **setPassword**
> setPassword(id, password)

Set a user&#39;s password

Password should be in plain text and will be encrypted on receipt. Use SSL for security.

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersApi;

UsersApi apiInstance = new UsersApi();
Integer id = 56; // Integer | The id of the user
String password = "password_example"; // String | The new plain text password
try {
    apiInstance.setPassword(id, password);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#setPassword");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the user |
 **password** | **String**| The new plain text password | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="startPasswordReset"></a>
# **startPasswordReset**
> startPasswordReset(id)

Reset a user&#39;s password

A reset code will be generated and a &#39;forgot_password&#39; BRE event will be fired with that code; this can be routed to the user as needed and submitted to the &#39;choose a new password&#39; endpoint.

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersApi;

UsersApi apiInstance = new UsersApi();
Integer id = 56; // Integer | The id of the user
try {
    apiInstance.startPasswordReset(id);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#startPasswordReset");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the user |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateUser"></a>
# **updateUser**
> updateUser(id, userResource)

Update a user

Password will not be edited on this endpoint, use password specific endpoints.

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersApi;

UsersApi apiInstance = new UsersApi();
String id = "id_example"; // String | The id of the user or 'me'
UserResource userResource = new UserResource(); // UserResource | The user resource object
try {
    apiInstance.updateUser(id, userResource);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#updateUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the user or &#39;me&#39; |
 **userResource** | [**UserResource**](UserResource.md)| The user resource object | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateUserTemplate"></a>
# **updateUserTemplate**
> TemplateResource updateUserTemplate(id, userTemplateResource)

Update a user template

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersApi;

UsersApi apiInstance = new UsersApi();
String id = "id_example"; // String | The id of the template
TemplateResource userTemplateResource = new TemplateResource(); // TemplateResource | The user template resource object
try {
    TemplateResource result = apiInstance.updateUserTemplate(id, userTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#updateUserTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **userTemplateResource** | [**TemplateResource**](TemplateResource.md)| The user template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

