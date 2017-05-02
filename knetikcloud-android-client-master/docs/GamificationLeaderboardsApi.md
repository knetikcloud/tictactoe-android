# GamificationLeaderboardsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getLeaderboard**](GamificationLeaderboardsApi.md#getLeaderboard) | **GET** /leaderboards/{context_type}/{context_id} | Retrieves leaderboard details and paginated entries
[**getLeaderboardRank**](GamificationLeaderboardsApi.md#getLeaderboardRank) | **GET** /leaderboards/{context_type}/{context_id}/users/{id}/rank | Retrieves a specific user entry with rank
[**getLeaderboardStrategies**](GamificationLeaderboardsApi.md#getLeaderboardStrategies) | **GET** /leaderboards/strategies | Get a list of available leaderboard strategy names


<a name="getLeaderboard"></a>
# **getLeaderboard**
> LeaderboardResource getLeaderboard(contextType, contextId, size, page)

Retrieves leaderboard details and paginated entries

The context type identifies the type of entity (i.e., &#39;activity&#39;) being tracked on the leaderboard. The context ID is the unique ID of the actual entity tracked by the leaderboard.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationLeaderboardsApi;

GamificationLeaderboardsApi apiInstance = new GamificationLeaderboardsApi();
String contextType = "contextType_example"; // String | The context type for the leaderboard
String contextId = "contextId_example"; // String | The context id for the leaderboard
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    LeaderboardResource result = apiInstance.getLeaderboard(contextType, contextId, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationLeaderboardsApi#getLeaderboard");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contextType** | **String**| The context type for the leaderboard |
 **contextId** | **String**| The context id for the leaderboard |
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**LeaderboardResource**](LeaderboardResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getLeaderboardRank"></a>
# **getLeaderboardRank**
> LeaderboardEntryResource getLeaderboardRank(contextType, contextId, id)

Retrieves a specific user entry with rank

The context type identifies the type of entity (i.e., &#39;activity&#39;) being tracked on the leaderboard. The context ID is the unique ID of the actual entity tracked by the leaderboard

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationLeaderboardsApi;

GamificationLeaderboardsApi apiInstance = new GamificationLeaderboardsApi();
String contextType = "contextType_example"; // String | The context type for the leaderboard
String contextId = "contextId_example"; // String | The context id for the leaderboard
String id = "id_example"; // String | The id of a user
try {
    LeaderboardEntryResource result = apiInstance.getLeaderboardRank(contextType, contextId, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationLeaderboardsApi#getLeaderboardRank");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contextType** | **String**| The context type for the leaderboard |
 **contextId** | **String**| The context id for the leaderboard |
 **id** | **String**| The id of a user |

### Return type

[**LeaderboardEntryResource**](LeaderboardEntryResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getLeaderboardStrategies"></a>
# **getLeaderboardStrategies**
> List&lt;String&gt; getLeaderboardStrategies()

Get a list of available leaderboard strategy names

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationLeaderboardsApi;

GamificationLeaderboardsApi apiInstance = new GamificationLeaderboardsApi();
try {
    List<String> result = apiInstance.getLeaderboardStrategies();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationLeaderboardsApi#getLeaderboardStrategies");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

