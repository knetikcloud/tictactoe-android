# UsersFriendshipsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addFriend**](UsersFriendshipsApi.md#addFriend) | **POST** /users/{user_id}/friends/{id} | Add a friend
[**getFriends**](UsersFriendshipsApi.md#getFriends) | **GET** /users/{user_id}/friends | Get friends list
[**getInviteToken**](UsersFriendshipsApi.md#getInviteToken) | **GET** /users/{user_id}/invite-token | Returns the invite token
[**getInvites**](UsersFriendshipsApi.md#getInvites) | **GET** /users/{user_id}/invites | Get pending invites
[**redeemFriendshipToken**](UsersFriendshipsApi.md#redeemFriendshipToken) | **POST** /users/{user_id}/friends/tokens | Redeem friendship token
[**removeOrDeclineFriend**](UsersFriendshipsApi.md#removeOrDeclineFriend) | **DELETE** /users/{user_id}/friends/{id} | Remove or decline a friend


<a name="addFriend"></a>
# **addFriend**
> addFriend(userId, id)

Add a friend

As a user, either creates or confirm a pending request. As an admin, call this endpoint twice while inverting the IDs to create a confirmed friendship.

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersFriendshipsApi;

UsersFriendshipsApi apiInstance = new UsersFriendshipsApi();
String userId = "userId_example"; // String | The id of the user or 'me' if logged in
Integer id = 56; // Integer | The id of the user to befriend
try {
    apiInstance.addFriend(userId, id);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersFriendshipsApi#addFriend");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The id of the user or &#39;me&#39; if logged in |
 **id** | **Integer**| The id of the user to befriend |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFriends"></a>
# **getFriends**
> PageResourceSimpleUserResource getFriends(userId, size, page, order)

Get friends list

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersFriendshipsApi;

UsersFriendshipsApi apiInstance = new UsersFriendshipsApi();
String userId = "userId_example"; // String | The id of the user or 'me'
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceSimpleUserResource result = apiInstance.getFriends(userId, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersFriendshipsApi#getFriends");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The id of the user or &#39;me&#39; |
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceSimpleUserResource**](PageResourceSimpleUserResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getInviteToken"></a>
# **getInviteToken**
> String getInviteToken(userId)

Returns the invite token

This is a unique invite token that allows direct connection to the request user.  Exposing that token presents privacy issues if the token is leaked. Use friend request flow instead if confirmation is required

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersFriendshipsApi;

UsersFriendshipsApi apiInstance = new UsersFriendshipsApi();
String userId = "userId_example"; // String | The id of the user or 'me' if logged in
try {
    String result = apiInstance.getInviteToken(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersFriendshipsApi#getInviteToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The id of the user or &#39;me&#39; if logged in |

### Return type

**String**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getInvites"></a>
# **getInvites**
> PageResourceSimpleUserResource getInvites(userId, size, page, order)

Get pending invites

Invites that the specified user received

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersFriendshipsApi;

UsersFriendshipsApi apiInstance = new UsersFriendshipsApi();
String userId = "userId_example"; // String | The id of the user or 'me'
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceSimpleUserResource result = apiInstance.getInvites(userId, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersFriendshipsApi#getInvites");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The id of the user or &#39;me&#39; |
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceSimpleUserResource**](PageResourceSimpleUserResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="redeemFriendshipToken"></a>
# **redeemFriendshipToken**
> redeemFriendshipToken(userId, token)

Redeem friendship token

Immediately connects the requested user with the user mapped by the provided invite token

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersFriendshipsApi;

UsersFriendshipsApi apiInstance = new UsersFriendshipsApi();
String userId = "userId_example"; // String | The id of the user or 'me' if logged in
String token = "token_example"; // String | The invite token
try {
    apiInstance.redeemFriendshipToken(userId, token);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersFriendshipsApi#redeemFriendshipToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The id of the user or &#39;me&#39; if logged in |
 **token** | **String**| The invite token | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeOrDeclineFriend"></a>
# **removeOrDeclineFriend**
> removeOrDeclineFriend(userId, id)

Remove or decline a friend

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersFriendshipsApi;

UsersFriendshipsApi apiInstance = new UsersFriendshipsApi();
String userId = "userId_example"; // String | The id of the user or 'me' if logged in
Integer id = 56; // Integer | The id of the user to befriend
try {
    apiInstance.removeOrDeclineFriend(userId, id);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersFriendshipsApi#removeOrDeclineFriend");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The id of the user or &#39;me&#39; if logged in |
 **id** | **Integer**| The id of the user to befriend |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

