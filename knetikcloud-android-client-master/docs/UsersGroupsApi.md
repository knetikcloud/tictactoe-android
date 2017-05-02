# UsersGroupsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addMemberToGroup**](UsersGroupsApi.md#addMemberToGroup) | **POST** /users/groups/{unique_name}/members | Adds a new member to the group
[**createGroup**](UsersGroupsApi.md#createGroup) | **POST** /users/groups | Create a group
[**createGroupTemplate**](UsersGroupsApi.md#createGroupTemplate) | **POST** /users/groups/templates | Create a group template
[**deleteGroup**](UsersGroupsApi.md#deleteGroup) | **DELETE** /users/groups/{unique_name} | Removes a group from the system IF no resources are attached to it
[**deleteGroupTemplate**](UsersGroupsApi.md#deleteGroupTemplate) | **DELETE** /users/groups/templates/{id} | Delete a group template
[**getGroup**](UsersGroupsApi.md#getGroup) | **GET** /users/groups/{unique_name} | Loads a specific group&#39;s details
[**getGroupMember**](UsersGroupsApi.md#getGroupMember) | **GET** /users/groups/{unique_name}/members/{user_id} | Get a user from a group
[**getGroupMembers**](UsersGroupsApi.md#getGroupMembers) | **GET** /users/groups/{unique_name}/members | Lists members of the group
[**getGroupTemplate**](UsersGroupsApi.md#getGroupTemplate) | **GET** /users/groups/templates/{id} | Get a single group template
[**getGroupTemplates**](UsersGroupsApi.md#getGroupTemplates) | **GET** /users/groups/templates | List and search group templates
[**getGroupsForUser**](UsersGroupsApi.md#getGroupsForUser) | **GET** /users/{user_id}/groups | List groups a user is in
[**removeGroupMember**](UsersGroupsApi.md#removeGroupMember) | **DELETE** /users/groups/{unique_name}/members/{user_id} | Removes a user from a group
[**updateGroup**](UsersGroupsApi.md#updateGroup) | **PUT** /users/groups/{unique_name} | Update a group
[**updateGroupMemberStatus**](UsersGroupsApi.md#updateGroupMemberStatus) | **PUT** /users/groups/{unique_name}/members/{user_id}/status | Change a user&#39;s status
[**updateGroupTemplate**](UsersGroupsApi.md#updateGroupTemplate) | **PUT** /users/groups/templates/{id} | Update a group template
[**updateGroups**](UsersGroupsApi.md#updateGroups) | **GET** /users/groups | List and search groups


<a name="addMemberToGroup"></a>
# **addMemberToGroup**
> GroupMemberResource addMemberToGroup(uniqueName, username)

Adds a new member to the group

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersGroupsApi;

UsersGroupsApi apiInstance = new UsersGroupsApi();
String uniqueName = "uniqueName_example"; // String | The group unique name
GroupMemberResource username = new GroupMemberResource(); // GroupMemberResource | The username of a user to add to the group
try {
    GroupMemberResource result = apiInstance.addMemberToGroup(uniqueName, username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersGroupsApi#addMemberToGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uniqueName** | **String**| The group unique name |
 **username** | [**GroupMemberResource**](GroupMemberResource.md)| The username of a user to add to the group |

### Return type

[**GroupMemberResource**](GroupMemberResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGroup"></a>
# **createGroup**
> GroupResource createGroup(groupResource)

Create a group

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersGroupsApi;

UsersGroupsApi apiInstance = new UsersGroupsApi();
GroupResource groupResource = new GroupResource(); // GroupResource | The new group
try {
    GroupResource result = apiInstance.createGroup(groupResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersGroupsApi#createGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupResource** | [**GroupResource**](GroupResource.md)| The new group | [optional]

### Return type

[**GroupResource**](GroupResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGroupTemplate"></a>
# **createGroupTemplate**
> TemplateResource createGroupTemplate(groupTemplateResource)

Create a group template

Group Templates define a type of group and the properties they have

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersGroupsApi;

UsersGroupsApi apiInstance = new UsersGroupsApi();
TemplateResource groupTemplateResource = new TemplateResource(); // TemplateResource | The group template resource object
try {
    TemplateResource result = apiInstance.createGroupTemplate(groupTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersGroupsApi#createGroupTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupTemplateResource** | [**TemplateResource**](TemplateResource.md)| The group template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteGroup"></a>
# **deleteGroup**
> deleteGroup(uniqueName)

Removes a group from the system IF no resources are attached to it

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersGroupsApi;

UsersGroupsApi apiInstance = new UsersGroupsApi();
String uniqueName = "uniqueName_example"; // String | The group unique name
try {
    apiInstance.deleteGroup(uniqueName);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersGroupsApi#deleteGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uniqueName** | **String**| The group unique name |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteGroupTemplate"></a>
# **deleteGroupTemplate**
> deleteGroupTemplate(id, cascade)

Delete a group template

If cascade &#x3D; &#39;detach&#39;, it will force delete the template even if it&#39;s attached to other objects

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersGroupsApi;

UsersGroupsApi apiInstance = new UsersGroupsApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | The value needed to delete used templates
try {
    apiInstance.deleteGroupTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersGroupsApi#deleteGroupTemplate");
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

<a name="getGroup"></a>
# **getGroup**
> GroupResource getGroup(uniqueName)

Loads a specific group&#39;s details

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersGroupsApi;

UsersGroupsApi apiInstance = new UsersGroupsApi();
String uniqueName = "uniqueName_example"; // String | The group unique name
try {
    GroupResource result = apiInstance.getGroup(uniqueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersGroupsApi#getGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uniqueName** | **String**| The group unique name |

### Return type

[**GroupResource**](GroupResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getGroupMember"></a>
# **getGroupMember**
> GroupMemberResource getGroupMember(uniqueName, userId)

Get a user from a group

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersGroupsApi;

UsersGroupsApi apiInstance = new UsersGroupsApi();
String uniqueName = "uniqueName_example"; // String | The group unique name
Integer userId = 56; // Integer | The id of the user
try {
    GroupMemberResource result = apiInstance.getGroupMember(uniqueName, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersGroupsApi#getGroupMember");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uniqueName** | **String**| The group unique name |
 **userId** | **Integer**| The id of the user |

### Return type

[**GroupMemberResource**](GroupMemberResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getGroupMembers"></a>
# **getGroupMembers**
> PageResourceGroupMemberResource getGroupMembers(uniqueName, size, page, order)

Lists members of the group

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersGroupsApi;

UsersGroupsApi apiInstance = new UsersGroupsApi();
String uniqueName = "uniqueName_example"; // String | The group unique name
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceGroupMemberResource result = apiInstance.getGroupMembers(uniqueName, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersGroupsApi#getGroupMembers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uniqueName** | **String**| The group unique name |
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceGroupMemberResource**](PageResourceGroupMemberResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getGroupTemplate"></a>
# **getGroupTemplate**
> TemplateResource getGroupTemplate(id)

Get a single group template

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersGroupsApi;

UsersGroupsApi apiInstance = new UsersGroupsApi();
String id = "id_example"; // String | The id of the template
try {
    TemplateResource result = apiInstance.getGroupTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersGroupsApi#getGroupTemplate");
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

<a name="getGroupTemplates"></a>
# **getGroupTemplates**
> PageResourceTemplateResource getGroupTemplates(size, page, order)

List and search group templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersGroupsApi;

UsersGroupsApi apiInstance = new UsersGroupsApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | a comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceTemplateResource result = apiInstance.getGroupTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersGroupsApi#getGroupTemplates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| a comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceTemplateResource**](PageResourceTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getGroupsForUser"></a>
# **getGroupsForUser**
> List&lt;String&gt; getGroupsForUser(userId)

List groups a user is in

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersGroupsApi;

UsersGroupsApi apiInstance = new UsersGroupsApi();
Integer userId = 56; // Integer | The id of the user
try {
    List<String> result = apiInstance.getGroupsForUser(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersGroupsApi#getGroupsForUser");
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

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeGroupMember"></a>
# **removeGroupMember**
> removeGroupMember(uniqueName, userId)

Removes a user from a group

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersGroupsApi;

UsersGroupsApi apiInstance = new UsersGroupsApi();
String uniqueName = "uniqueName_example"; // String | The group unique name
Integer userId = 56; // Integer | The id of the user to remove
try {
    apiInstance.removeGroupMember(uniqueName, userId);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersGroupsApi#removeGroupMember");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uniqueName** | **String**| The group unique name |
 **userId** | **Integer**| The id of the user to remove |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateGroup"></a>
# **updateGroup**
> updateGroup(uniqueName, groupResource)

Update a group

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersGroupsApi;

UsersGroupsApi apiInstance = new UsersGroupsApi();
String uniqueName = "uniqueName_example"; // String | The group unique name
GroupResource groupResource = new GroupResource(); // GroupResource | The updated group
try {
    apiInstance.updateGroup(uniqueName, groupResource);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersGroupsApi#updateGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uniqueName** | **String**| The group unique name |
 **groupResource** | [**GroupResource**](GroupResource.md)| The updated group | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateGroupMemberStatus"></a>
# **updateGroupMemberStatus**
> updateGroupMemberStatus(uniqueName, userId, status)

Change a user&#39;s status

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersGroupsApi;

UsersGroupsApi apiInstance = new UsersGroupsApi();
String uniqueName = "uniqueName_example"; // String | The group unique name
Integer userId = 56; // Integer | The user id of the member to modify
String status = "status_example"; // String | The new status for the user
try {
    apiInstance.updateGroupMemberStatus(uniqueName, userId, status);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersGroupsApi#updateGroupMemberStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uniqueName** | **String**| The group unique name |
 **userId** | **Integer**| The user id of the member to modify |
 **status** | **String**| The new status for the user |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateGroupTemplate"></a>
# **updateGroupTemplate**
> TemplateResource updateGroupTemplate(id, groupTemplateResource)

Update a group template

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersGroupsApi;

UsersGroupsApi apiInstance = new UsersGroupsApi();
String id = "id_example"; // String | The id of the template
TemplateResource groupTemplateResource = new TemplateResource(); // TemplateResource | The group template resource object
try {
    TemplateResource result = apiInstance.updateGroupTemplate(id, groupTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersGroupsApi#updateGroupTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **groupTemplateResource** | [**TemplateResource**](TemplateResource.md)| The group template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateGroups"></a>
# **updateGroups**
> PageResourceGroupResource updateGroups(filterTemplate, filterMemberCount, filterName, filterUniqueName, filterParent, filterStatus, size, page, order)

List and search groups

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersGroupsApi;

UsersGroupsApi apiInstance = new UsersGroupsApi();
String filterTemplate = "filterTemplate_example"; // String | Filter for groups using a specific template, by id
String filterMemberCount = "filterMemberCount_example"; // String | Filters groups by member count. Multiple values possible for range search. Format: filter_member_count=OP,ts&... where OP in (GT, LT, GOE, LOE, EQ). Ex: filter_member_count=GT,14,LT,17
String filterName = "filterName_example"; // String | Filter for groups with names starting with the given string
String filterUniqueName = "filterUniqueName_example"; // String | Filter for groups whose unique_name starts with provided string
String filterParent = "filterParent_example"; // String | Filter for groups with a specific parent, by unique name
String filterStatus = "filterStatus_example"; // String | Filter for groups with a certain status
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "name:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceGroupResource result = apiInstance.updateGroups(filterTemplate, filterMemberCount, filterName, filterUniqueName, filterParent, filterStatus, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersGroupsApi#updateGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterTemplate** | **String**| Filter for groups using a specific template, by id | [optional]
 **filterMemberCount** | **String**| Filters groups by member count. Multiple values possible for range search. Format: filter_member_count&#x3D;OP,ts&amp;... where OP in (GT, LT, GOE, LOE, EQ). Ex: filter_member_count&#x3D;GT,14,LT,17 | [optional]
 **filterName** | **String**| Filter for groups with names starting with the given string | [optional]
 **filterUniqueName** | **String**| Filter for groups whose unique_name starts with provided string | [optional]
 **filterParent** | **String**| Filter for groups with a specific parent, by unique name | [optional]
 **filterStatus** | **String**| Filter for groups with a certain status | [optional] [enum: open, closed]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to name:ASC]

### Return type

[**PageResourceGroupResource**](PageResourceGroupResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

