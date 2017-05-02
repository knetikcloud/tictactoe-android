# GamificationLevelingApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createLevel**](GamificationLevelingApi.md#createLevel) | **POST** /leveling | Create a level schema
[**deleteLevel**](GamificationLevelingApi.md#deleteLevel) | **DELETE** /leveling/{name} | Delete a level
[**getLevel**](GamificationLevelingApi.md#getLevel) | **GET** /leveling/{name} | Retrieve a level
[**getLevelTriggers**](GamificationLevelingApi.md#getLevelTriggers) | **GET** /leveling/triggers | Get the list of triggers that can be used to trigger a leveling progress update
[**getLevels**](GamificationLevelingApi.md#getLevels) | **GET** /leveling | List and search levels
[**getUserLevel**](GamificationLevelingApi.md#getUserLevel) | **GET** /users/{user_id}/leveling/{name} | Get a user&#39;s progress for a given level schema
[**getUserLevels**](GamificationLevelingApi.md#getUserLevels) | **GET** /users/{user_id}/leveling | Get a user&#39;s progress for all level schemas
[**incrementProgress**](GamificationLevelingApi.md#incrementProgress) | **POST** /users/{user_id}/leveling/{name}/progress | Update or create a leveling progress record for a user
[**setProgress**](GamificationLevelingApi.md#setProgress) | **PUT** /users/{user_id}/leveling/{name}/progress | Set leveling progress for a user
[**updateLevel**](GamificationLevelingApi.md#updateLevel) | **PUT** /leveling/{name} | Update a level


<a name="createLevel"></a>
# **createLevel**
> LevelingResource createLevel(level)

Create a level schema

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationLevelingApi;

GamificationLevelingApi apiInstance = new GamificationLevelingApi();
LevelingResource level = new LevelingResource(); // LevelingResource | The level schema definition
try {
    LevelingResource result = apiInstance.createLevel(level);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationLevelingApi#createLevel");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **level** | [**LevelingResource**](LevelingResource.md)| The level schema definition | [optional]

### Return type

[**LevelingResource**](LevelingResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteLevel"></a>
# **deleteLevel**
> deleteLevel(name)

Delete a level

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationLevelingApi;

GamificationLevelingApi apiInstance = new GamificationLevelingApi();
String name = "name_example"; // String | The level schema name
try {
    apiInstance.deleteLevel(name);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationLevelingApi#deleteLevel");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The level schema name |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getLevel"></a>
# **getLevel**
> LevelingResource getLevel(name)

Retrieve a level

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationLevelingApi;

GamificationLevelingApi apiInstance = new GamificationLevelingApi();
String name = "name_example"; // String | The level schema name
try {
    LevelingResource result = apiInstance.getLevel(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationLevelingApi#getLevel");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The level schema name |

### Return type

[**LevelingResource**](LevelingResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getLevelTriggers"></a>
# **getLevelTriggers**
> List&lt;BreTriggerResource&gt; getLevelTriggers()

Get the list of triggers that can be used to trigger a leveling progress update

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationLevelingApi;

GamificationLevelingApi apiInstance = new GamificationLevelingApi();
try {
    List<BreTriggerResource> result = apiInstance.getLevelTriggers();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationLevelingApi#getLevelTriggers");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;BreTriggerResource&gt;**](BreTriggerResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getLevels"></a>
# **getLevels**
> PageResourceLevelingResource getLevels(filterName, size, page, order)

List and search levels

Get a list of levels schemas with optional filtering

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationLevelingApi;

GamificationLevelingApi apiInstance = new GamificationLevelingApi();
String filterName = "filterName_example"; // String | Filter for level schemas whose name contains a given string
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "name:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceLevelingResource result = apiInstance.getLevels(filterName, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationLevelingApi#getLevels");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterName** | **String**| Filter for level schemas whose name contains a given string | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to name:ASC]

### Return type

[**PageResourceLevelingResource**](PageResourceLevelingResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserLevel"></a>
# **getUserLevel**
> UserLevelingResource getUserLevel(userId, name)

Get a user&#39;s progress for a given level schema

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationLevelingApi;

GamificationLevelingApi apiInstance = new GamificationLevelingApi();
Integer userId = 56; // Integer | The id of the user
String name = "name_example"; // String | The level schema name
try {
    UserLevelingResource result = apiInstance.getUserLevel(userId, name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationLevelingApi#getUserLevel");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |
 **name** | **String**| The level schema name |

### Return type

[**UserLevelingResource**](UserLevelingResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserLevels"></a>
# **getUserLevels**
> PageResourceUserLevelingResource getUserLevels(userId)

Get a user&#39;s progress for all level schemas

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationLevelingApi;

GamificationLevelingApi apiInstance = new GamificationLevelingApi();
Integer userId = 56; // Integer | The id of the user
try {
    PageResourceUserLevelingResource result = apiInstance.getUserLevels(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationLevelingApi#getUserLevels");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |

### Return type

[**PageResourceUserLevelingResource**](PageResourceUserLevelingResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="incrementProgress"></a>
# **incrementProgress**
> incrementProgress(userId, name, progress)

Update or create a leveling progress record for a user

If no progress record yet exists for the user, it will be created. Otherwise the provided value will be added to it. May be negative. If progress meets or exceeds the level&#39;s max_value it will be marked as earned and a BRE event will be triggered for the &lt;code&gt;BreAchievementEarnedTrigger&lt;/code&gt;.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationLevelingApi;

GamificationLevelingApi apiInstance = new GamificationLevelingApi();
Integer userId = 56; // Integer | The id of the user
String name = "name_example"; // String | The level schema name
Integer progress = 56; // Integer | The amount of progress to add
try {
    apiInstance.incrementProgress(userId, name, progress);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationLevelingApi#incrementProgress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |
 **name** | **String**| The level schema name |
 **progress** | **Integer**| The amount of progress to add | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setProgress"></a>
# **setProgress**
> setProgress(userId, name, progress)

Set leveling progress for a user

If no progress record yet exists for the user, it will be created. Otherwise it will be updated to the provided value. If progress meets or exceeds the level&#39;s max_value it will be marked as earned and a BRE event will be triggered for the &lt;code&gt;BreAchievementEarnedTrigger&lt;/code&gt;.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationLevelingApi;

GamificationLevelingApi apiInstance = new GamificationLevelingApi();
Integer userId = 56; // Integer | The id of the user
String name = "name_example"; // String | The level schema name
Integer progress = 56; // Integer | The new progress amount
try {
    apiInstance.setProgress(userId, name, progress);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationLevelingApi#setProgress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |
 **name** | **String**| The level schema name |
 **progress** | **Integer**| The new progress amount | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateLevel"></a>
# **updateLevel**
> LevelingResource updateLevel(name, newLevel)

Update a level

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationLevelingApi;

GamificationLevelingApi apiInstance = new GamificationLevelingApi();
String name = "name_example"; // String | The level schema name
LevelingResource newLevel = new LevelingResource(); // LevelingResource | The level schema definition
try {
    LevelingResource result = apiInstance.updateLevel(name, newLevel);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationLevelingApi#updateLevel");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The level schema name |
 **newLevel** | [**LevelingResource**](LevelingResource.md)| The level schema definition | [optional]

### Return type

[**LevelingResource**](LevelingResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

