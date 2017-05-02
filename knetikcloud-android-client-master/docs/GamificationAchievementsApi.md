# GamificationAchievementsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAchievement**](GamificationAchievementsApi.md#createAchievement) | **POST** /achievements | Create a new achievement definition
[**createAchievementTemplate**](GamificationAchievementsApi.md#createAchievementTemplate) | **POST** /achievements/templates | Create an achievement template
[**deleteAchievement**](GamificationAchievementsApi.md#deleteAchievement) | **DELETE** /achievements/{name} | Delete an achievement definition
[**deleteAchievementTemplate**](GamificationAchievementsApi.md#deleteAchievementTemplate) | **DELETE** /achievements/templates/{id} | Delete an achievement template
[**getAchievement**](GamificationAchievementsApi.md#getAchievement) | **GET** /achievements/{name} | Get a single achievement definition
[**getAchievementTemplate**](GamificationAchievementsApi.md#getAchievementTemplate) | **GET** /achievements/templates/{id} | Get a single achievement template
[**getAchievementTemplates**](GamificationAchievementsApi.md#getAchievementTemplates) | **GET** /achievements/templates | List and search achievement templates
[**getAchievementTriggers**](GamificationAchievementsApi.md#getAchievementTriggers) | **GET** /achievements/triggers | Get the list of triggers that can be used to trigger an achievement progress update
[**getAchievements**](GamificationAchievementsApi.md#getAchievements) | **GET** /achievements | Get all achievement definitions in the system
[**getDerivedAchievements**](GamificationAchievementsApi.md#getDerivedAchievements) | **GET** /achievements/derived/{name} | Get a list of derived achievements
[**getUserAchievementProgress**](GamificationAchievementsApi.md#getUserAchievementProgress) | **GET** /users/{user_id}/achievements/{achievement_name} | Retrieve progress on a given achievement for a given user
[**getUserAchievementsProgress**](GamificationAchievementsApi.md#getUserAchievementsProgress) | **GET** /users/{user_id}/achievements | Retrieve progress on achievements for a given user
[**getUsersAchievementProgress**](GamificationAchievementsApi.md#getUsersAchievementProgress) | **GET** /users/achievements/{achievement_name} | Retrieve progress on a given achievement for all users
[**getUsersAchievementsProgress**](GamificationAchievementsApi.md#getUsersAchievementsProgress) | **GET** /users/achievements | Retrieve progress on achievements for all users
[**incrementAchievementProgress**](GamificationAchievementsApi.md#incrementAchievementProgress) | **POST** /users/{user_id}/achievements/{achievement_name}/progress | Increment an achievement progress record for a user
[**setAchievementProgress**](GamificationAchievementsApi.md#setAchievementProgress) | **PUT** /users/{user_id}/achievements/{achievement_name}/progress | Set an achievement progress record for a user
[**updateAchievement**](GamificationAchievementsApi.md#updateAchievement) | **PUT** /achievements/{name} | Update an achievement definition
[**updateAchievementTemplate**](GamificationAchievementsApi.md#updateAchievementTemplate) | **PUT** /achievements/templates/{id} | Update an achievement template


<a name="createAchievement"></a>
# **createAchievement**
> AchievementDefinitionResource createAchievement(achievement)

Create a new achievement definition

If the definition contains a trigger event name, a BRE rule is created, so that tracking logic is executed when the triggering event occurs. If no trigger event name is specified, the user&#39;s achievement status must manually be updated via the API.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
AchievementDefinitionResource achievement = new AchievementDefinitionResource(); // AchievementDefinitionResource | The achievement definition
try {
    AchievementDefinitionResource result = apiInstance.createAchievement(achievement);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#createAchievement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **achievement** | [**AchievementDefinitionResource**](AchievementDefinitionResource.md)| The achievement definition | [optional]

### Return type

[**AchievementDefinitionResource**](AchievementDefinitionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createAchievementTemplate"></a>
# **createAchievementTemplate**
> TemplateResource createAchievementTemplate(template)

Create an achievement template

Achievement templates define a type of achievement and the properties they have

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
TemplateResource template = new TemplateResource(); // TemplateResource | The achievement template to be created
try {
    TemplateResource result = apiInstance.createAchievementTemplate(template);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#createAchievementTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **template** | [**TemplateResource**](TemplateResource.md)| The achievement template to be created | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAchievement"></a>
# **deleteAchievement**
> deleteAchievement(name)

Delete an achievement definition

Will also disable the associated generated rule, if any.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
String name = "name_example"; // String | The name of the achievement
try {
    apiInstance.deleteAchievement(name);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#deleteAchievement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The name of the achievement |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAchievementTemplate"></a>
# **deleteAchievementTemplate**
> deleteAchievementTemplate(id, cascade)

Delete an achievement template

If cascade &#x3D; &#39;detach&#39;, it will force delete the template even if it&#39;s attached to other objects

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | The value needed to delete used templates
try {
    apiInstance.deleteAchievementTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#deleteAchievementTemplate");
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

<a name="getAchievement"></a>
# **getAchievement**
> AchievementDefinitionResource getAchievement(name)

Get a single achievement definition

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
String name = "name_example"; // String | The name of the achievement
try {
    AchievementDefinitionResource result = apiInstance.getAchievement(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#getAchievement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The name of the achievement |

### Return type

[**AchievementDefinitionResource**](AchievementDefinitionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAchievementTemplate"></a>
# **getAchievementTemplate**
> TemplateResource getAchievementTemplate(id)

Get a single achievement template

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
String id = "id_example"; // String | The id of the template
try {
    TemplateResource result = apiInstance.getAchievementTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#getAchievementTemplate");
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

<a name="getAchievementTemplates"></a>
# **getAchievementTemplates**
> PageResourceTemplateResource getAchievementTemplates(size, page, order)

List and search achievement templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceTemplateResource result = apiInstance.getAchievementTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#getAchievementTemplates");
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

<a name="getAchievementTriggers"></a>
# **getAchievementTriggers**
> List&lt;BreTriggerResource&gt; getAchievementTriggers()

Get the list of triggers that can be used to trigger an achievement progress update

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
try {
    List<BreTriggerResource> result = apiInstance.getAchievementTriggers();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#getAchievementTriggers");
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

<a name="getAchievements"></a>
# **getAchievements**
> PageResourceAchievementDefinitionResource getAchievements(filterTagset, filterName, filterHidden, filterDerived, size, page, order)

Get all achievement definitions in the system

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
String filterTagset = "filterTagset_example"; // String | Filter for achievements with specified tags (separated by comma)
String filterName = "filterName_example"; // String | Filter for achievements whose name contains a string
Boolean filterHidden = true; // Boolean | Filter for achievements that are hidden or not
Boolean filterDerived = true; // Boolean | Filter for achievements that are derived from other services
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "name:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceAchievementDefinitionResource result = apiInstance.getAchievements(filterTagset, filterName, filterHidden, filterDerived, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#getAchievements");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterTagset** | **String**| Filter for achievements with specified tags (separated by comma) | [optional]
 **filterName** | **String**| Filter for achievements whose name contains a string | [optional]
 **filterHidden** | **Boolean**| Filter for achievements that are hidden or not | [optional]
 **filterDerived** | **Boolean**| Filter for achievements that are derived from other services | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to name:ASC]

### Return type

[**PageResourceAchievementDefinitionResource**](PageResourceAchievementDefinitionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getDerivedAchievements"></a>
# **getDerivedAchievements**
> List&lt;AchievementDefinitionResource&gt; getDerivedAchievements(name)

Get a list of derived achievements

Used by other services that depend on achievements

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
String name = "name_example"; // String | The name of the derived achievement
try {
    List<AchievementDefinitionResource> result = apiInstance.getDerivedAchievements(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#getDerivedAchievements");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The name of the derived achievement |

### Return type

[**List&lt;AchievementDefinitionResource&gt;**](AchievementDefinitionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserAchievementProgress"></a>
# **getUserAchievementProgress**
> UserAchievementGroupResource getUserAchievementProgress(userId, achievementName)

Retrieve progress on a given achievement for a given user

Assets will not be filled in on the resources returned. Use &#39;Get a single poll&#39; to retrieve the full resource with assets for a given item as needed.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
Integer userId = 56; // Integer | The user's id
String achievementName = "achievementName_example"; // String | The achievement's name
try {
    UserAchievementGroupResource result = apiInstance.getUserAchievementProgress(userId, achievementName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#getUserAchievementProgress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The user&#39;s id |
 **achievementName** | **String**| The achievement&#39;s name |

### Return type

[**UserAchievementGroupResource**](UserAchievementGroupResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserAchievementsProgress"></a>
# **getUserAchievementsProgress**
> PageResourceUserAchievementGroupResource getUserAchievementsProgress(userId, filterAchievementDerived, filterAchievementTagset, filterAchievementName, size, page)

Retrieve progress on achievements for a given user

Assets will not be filled in on the resources returned. Use &#39;Get a single poll&#39; to retrieve the full resource with assets for a given item as needed.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
Integer userId = 56; // Integer | The user's id
Boolean filterAchievementDerived = true; // Boolean | Filter for achievements that are derived from other services
String filterAchievementTagset = "filterAchievementTagset_example"; // String | Filter for achievements with specified tags (separated by comma)
String filterAchievementName = "filterAchievementName_example"; // String | Filter for achievements whose name contains a string
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceUserAchievementGroupResource result = apiInstance.getUserAchievementsProgress(userId, filterAchievementDerived, filterAchievementTagset, filterAchievementName, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#getUserAchievementsProgress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The user&#39;s id |
 **filterAchievementDerived** | **Boolean**| Filter for achievements that are derived from other services | [optional]
 **filterAchievementTagset** | **String**| Filter for achievements with specified tags (separated by comma) | [optional]
 **filterAchievementName** | **String**| Filter for achievements whose name contains a string | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceUserAchievementGroupResource**](PageResourceUserAchievementGroupResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUsersAchievementProgress"></a>
# **getUsersAchievementProgress**
> PageResourceUserAchievementGroupResource getUsersAchievementProgress(achievementName, filterAchievementDerived, filterAchievementTagset, filterAchievementName, size, page)

Retrieve progress on a given achievement for all users

Assets will not be filled in on the resources returned. Use &#39;Get single achievement progress for user&#39; to retrieve the full resource with assets for a given user as needed.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
String achievementName = "achievementName_example"; // String | The achievement's name
Boolean filterAchievementDerived = true; // Boolean | Filter for achievements that are derived from other services
String filterAchievementTagset = "filterAchievementTagset_example"; // String | Filter for achievements with specified tags (separated by comma)
String filterAchievementName = "filterAchievementName_example"; // String | Filter for achievements whose name contains a string
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceUserAchievementGroupResource result = apiInstance.getUsersAchievementProgress(achievementName, filterAchievementDerived, filterAchievementTagset, filterAchievementName, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#getUsersAchievementProgress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **achievementName** | **String**| The achievement&#39;s name |
 **filterAchievementDerived** | **Boolean**| Filter for achievements that are derived from other services | [optional]
 **filterAchievementTagset** | **String**| Filter for achievements with specified tags (separated by comma) | [optional]
 **filterAchievementName** | **String**| Filter for achievements whose name contains a string | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceUserAchievementGroupResource**](PageResourceUserAchievementGroupResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUsersAchievementsProgress"></a>
# **getUsersAchievementsProgress**
> PageResourceUserAchievementGroupResource getUsersAchievementsProgress(filterAchievementDerived, filterAchievementTagset, filterAchievementName, size, page)

Retrieve progress on achievements for all users

Assets will not be filled in on the resources returned. Use &#39;Get single achievement progress for user&#39; to retrieve the full resource with assets for a given user as needed.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
Boolean filterAchievementDerived = true; // Boolean | Filter for achievements that are derived from other services
String filterAchievementTagset = "filterAchievementTagset_example"; // String | Filter for achievements with specified tags (separated by comma)
String filterAchievementName = "filterAchievementName_example"; // String | Filter for achievements whose name contains a string
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceUserAchievementGroupResource result = apiInstance.getUsersAchievementsProgress(filterAchievementDerived, filterAchievementTagset, filterAchievementName, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#getUsersAchievementsProgress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterAchievementDerived** | **Boolean**| Filter for achievements that are derived from other services | [optional]
 **filterAchievementTagset** | **String**| Filter for achievements with specified tags (separated by comma) | [optional]
 **filterAchievementName** | **String**| Filter for achievements whose name contains a string | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceUserAchievementGroupResource**](PageResourceUserAchievementGroupResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="incrementAchievementProgress"></a>
# **incrementAchievementProgress**
> UserAchievementGroupResource incrementAchievementProgress(userId, achievementName, progress)

Increment an achievement progress record for a user

If no progress record yet exists for the user, it will be created. Otherwise it will be updated and the provided value added to the existing progress. May be negative. If progress meets or exceeds the achievement&#39;s max_value it will be marked as earned and a BRE event will be triggered for the &lt;code&gt;BreAchievementEarnedTrigger&lt;/code&gt;.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
Integer userId = 56; // Integer | The user's id
String achievementName = "achievementName_example"; // String | The achievement's name
Integer progress = 56; // Integer | The amount to add to the progress value
try {
    UserAchievementGroupResource result = apiInstance.incrementAchievementProgress(userId, achievementName, progress);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#incrementAchievementProgress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The user&#39;s id |
 **achievementName** | **String**| The achievement&#39;s name |
 **progress** | **Integer**| The amount to add to the progress value | [optional]

### Return type

[**UserAchievementGroupResource**](UserAchievementGroupResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setAchievementProgress"></a>
# **setAchievementProgress**
> UserAchievementGroupResource setAchievementProgress(userId, achievementName, progress)

Set an achievement progress record for a user

If no progress record yet exists for the user, it will be created. Otherwise it will be updated and progress set to the provided value. If progress meets or exceeds the achievement&#39;s max_value it will be marked as earned and a BRE event will be triggered for the &lt;code&gt;BreAchievementEarnedTrigger&lt;/code&gt;.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
Integer userId = 56; // Integer | The user's id
String achievementName = "achievementName_example"; // String | The achievement's name
Integer progress = 56; // Integer | The new progress value
try {
    UserAchievementGroupResource result = apiInstance.setAchievementProgress(userId, achievementName, progress);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#setAchievementProgress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The user&#39;s id |
 **achievementName** | **String**| The achievement&#39;s name |
 **progress** | **Integer**| The new progress value | [optional]

### Return type

[**UserAchievementGroupResource**](UserAchievementGroupResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAchievement"></a>
# **updateAchievement**
> AchievementDefinitionResource updateAchievement(name, achievement)

Update an achievement definition

The existing generated rule, if any, will be deleted. A new rule will be created if a trigger event name is specified in the new version.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
String name = "name_example"; // String | The name of the achievement
AchievementDefinitionResource achievement = new AchievementDefinitionResource(); // AchievementDefinitionResource | The achievement definition
try {
    AchievementDefinitionResource result = apiInstance.updateAchievement(name, achievement);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#updateAchievement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The name of the achievement |
 **achievement** | [**AchievementDefinitionResource**](AchievementDefinitionResource.md)| The achievement definition | [optional]

### Return type

[**AchievementDefinitionResource**](AchievementDefinitionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAchievementTemplate"></a>
# **updateAchievementTemplate**
> TemplateResource updateAchievementTemplate(id, template)

Update an achievement template

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationAchievementsApi;

GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
String id = "id_example"; // String | The id of the template
TemplateResource template = new TemplateResource(); // TemplateResource | The updated template
try {
    TemplateResource result = apiInstance.updateAchievementTemplate(id, template);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationAchievementsApi#updateAchievementTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **template** | [**TemplateResource**](TemplateResource.md)| The updated template | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

