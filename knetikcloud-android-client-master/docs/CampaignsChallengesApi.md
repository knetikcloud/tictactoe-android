# CampaignsChallengesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createChallenge**](CampaignsChallengesApi.md#createChallenge) | **POST** /challenges | Create a challenge
[**createChallengeActivity**](CampaignsChallengesApi.md#createChallengeActivity) | **POST** /challenges/{challenge_id}/activities | Create a challenge activity
[**createChallengeActivityTemplate**](CampaignsChallengesApi.md#createChallengeActivityTemplate) | **POST** /challenge-activities/templates | Create a challenge activity template
[**createChallengeTemplate**](CampaignsChallengesApi.md#createChallengeTemplate) | **POST** /challenges/templates | Create a challenge template
[**deleteChallenge**](CampaignsChallengesApi.md#deleteChallenge) | **DELETE** /challenges/{id} | Delete a challenge
[**deleteChallengeActivity**](CampaignsChallengesApi.md#deleteChallengeActivity) | **DELETE** /challenges/{challenge_id}/activities/{activity_id} | Delete a challenge activity
[**deleteChallengeActivityTemplate**](CampaignsChallengesApi.md#deleteChallengeActivityTemplate) | **DELETE** /challenge-activities/templates/{id} | Delete a challenge activity template
[**deleteChallengeEvent**](CampaignsChallengesApi.md#deleteChallengeEvent) | **DELETE** /challenges/events/{id} | Delete a challenge event
[**deleteChallengeTemplate**](CampaignsChallengesApi.md#deleteChallengeTemplate) | **DELETE** /challenges/templates/{id} | Delete a challenge template
[**getChallenge**](CampaignsChallengesApi.md#getChallenge) | **GET** /challenges/{id} | Retrieve a challenge
[**getChallengeActivities**](CampaignsChallengesApi.md#getChallengeActivities) | **GET** /challenges/{challenge_id}/activities | List and search challenge activities
[**getChallengeActivity**](CampaignsChallengesApi.md#getChallengeActivity) | **GET** /challenges/{challenge_id}/activities/{activity_id} | Get a single challenge activity
[**getChallengeActivityTemplate**](CampaignsChallengesApi.md#getChallengeActivityTemplate) | **GET** /challenge-activities/templates/{id} | Get a single challenge activity template
[**getChallengeActivityTemplates**](CampaignsChallengesApi.md#getChallengeActivityTemplates) | **GET** /challenge-activities/templates | List and search challenge activity templates
[**getChallengeEvent**](CampaignsChallengesApi.md#getChallengeEvent) | **GET** /challenges/events/{id} | Retrieve a single challenge event details
[**getChallengeEvents**](CampaignsChallengesApi.md#getChallengeEvents) | **GET** /challenges/events | Retrieve a list of challenge events
[**getChallengeTemplate**](CampaignsChallengesApi.md#getChallengeTemplate) | **GET** /challenges/templates/{id} | Get a single challenge template
[**getChallengeTemplates**](CampaignsChallengesApi.md#getChallengeTemplates) | **GET** /challenges/templates | List and search challenge templates
[**getChallenges**](CampaignsChallengesApi.md#getChallenges) | **GET** /challenges | Retrieve a list of challenges
[**updateChallenge**](CampaignsChallengesApi.md#updateChallenge) | **PUT** /challenges/{id} | Update a challenge
[**updateChallengeActivity**](CampaignsChallengesApi.md#updateChallengeActivity) | **PUT** /challenges/{challenge_id}/activities/{activity_id} | Update a challenge activity
[**updateChallengeActivityTemplate**](CampaignsChallengesApi.md#updateChallengeActivityTemplate) | **PUT** /challenge-activities/templates/{id} | Update an challenge activity template
[**updateChallengeTemplate**](CampaignsChallengesApi.md#updateChallengeTemplate) | **PUT** /challenges/templates/{id} | Update a challenge template


<a name="createChallenge"></a>
# **createChallenge**
> ChallengeResource createChallenge(challengeResource)

Create a challenge

Challenges do not run on their own.  They must be added to a campaign before events will spawn.

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
ChallengeResource challengeResource = new ChallengeResource(); // ChallengeResource | The challenge resource object
try {
    ChallengeResource result = apiInstance.createChallenge(challengeResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#createChallenge");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **challengeResource** | [**ChallengeResource**](ChallengeResource.md)| The challenge resource object | [optional]

### Return type

[**ChallengeResource**](ChallengeResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createChallengeActivity"></a>
# **createChallengeActivity**
> ChallengeActivityResource createChallengeActivity(challengeId, challengeActivityResource, validateSettings)

Create a challenge activity

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
Long challengeId = 789L; // Long | The challenge id
ChallengeActivityResource challengeActivityResource = new ChallengeActivityResource(); // ChallengeActivityResource | The challenge activity resource object
Boolean validateSettings = false; // Boolean | Whether to validate the settings being sent against the available settings on the base activity.
try {
    ChallengeActivityResource result = apiInstance.createChallengeActivity(challengeId, challengeActivityResource, validateSettings);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#createChallengeActivity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **challengeId** | **Long**| The challenge id |
 **challengeActivityResource** | [**ChallengeActivityResource**](ChallengeActivityResource.md)| The challenge activity resource object | [optional]
 **validateSettings** | **Boolean**| Whether to validate the settings being sent against the available settings on the base activity. | [optional] [default to false]

### Return type

[**ChallengeActivityResource**](ChallengeActivityResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createChallengeActivityTemplate"></a>
# **createChallengeActivityTemplate**
> TemplateResource createChallengeActivityTemplate(challengeActivityTemplateResource)

Create a challenge activity template

Challenge Activity Templates define a type of challenge activity and the properties they have

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
TemplateResource challengeActivityTemplateResource = new TemplateResource(); // TemplateResource | The challengeActivity template resource object
try {
    TemplateResource result = apiInstance.createChallengeActivityTemplate(challengeActivityTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#createChallengeActivityTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **challengeActivityTemplateResource** | [**TemplateResource**](TemplateResource.md)| The challengeActivity template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createChallengeTemplate"></a>
# **createChallengeTemplate**
> TemplateResource createChallengeTemplate(challengeTemplateResource)

Create a challenge template

Challenge Templates define a type of challenge and the properties they have

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
TemplateResource challengeTemplateResource = new TemplateResource(); // TemplateResource | The challenge template resource object
try {
    TemplateResource result = apiInstance.createChallengeTemplate(challengeTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#createChallengeTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **challengeTemplateResource** | [**TemplateResource**](TemplateResource.md)| The challenge template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteChallenge"></a>
# **deleteChallenge**
> deleteChallenge(id)

Delete a challenge

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
Long id = 789L; // Long | The challenge id
try {
    apiInstance.deleteChallenge(id);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#deleteChallenge");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The challenge id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteChallengeActivity"></a>
# **deleteChallengeActivity**
> deleteChallengeActivity(activityId, challengeId)

Delete a challenge activity

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
Long activityId = 789L; // Long | The activity id
Long challengeId = 789L; // Long | The challenge id
try {
    apiInstance.deleteChallengeActivity(activityId, challengeId);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#deleteChallengeActivity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activityId** | **Long**| The activity id |
 **challengeId** | **Long**| The challenge id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteChallengeActivityTemplate"></a>
# **deleteChallengeActivityTemplate**
> deleteChallengeActivityTemplate(id, cascade)

Delete a challenge activity template

If cascade &#x3D; &#39;detach&#39;, it will force delete the template even if it&#39;s attached to other objects

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | The value needed to delete used templates
try {
    apiInstance.deleteChallengeActivityTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#deleteChallengeActivityTemplate");
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

<a name="deleteChallengeEvent"></a>
# **deleteChallengeEvent**
> deleteChallengeEvent(id)

Delete a challenge event

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
Long id = 789L; // Long | The challenge event id
try {
    apiInstance.deleteChallengeEvent(id);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#deleteChallengeEvent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The challenge event id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteChallengeTemplate"></a>
# **deleteChallengeTemplate**
> deleteChallengeTemplate(id, cascade)

Delete a challenge template

If cascade &#x3D; &#39;detach&#39;, it will force delete the template even if it&#39;s attached to other objects

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | The value needed to delete used templates
try {
    apiInstance.deleteChallengeTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#deleteChallengeTemplate");
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

<a name="getChallenge"></a>
# **getChallenge**
> ChallengeResource getChallenge(id)

Retrieve a challenge

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
Long id = 789L; // Long | The challenge id
try {
    ChallengeResource result = apiInstance.getChallenge(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#getChallenge");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The challenge id |

### Return type

[**ChallengeResource**](ChallengeResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getChallengeActivities"></a>
# **getChallengeActivities**
> PageResourceBareChallengeActivityResource getChallengeActivities(challengeId, size, page, order)

List and search challenge activities

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
Long challengeId = 789L; // Long | The challenge id
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceBareChallengeActivityResource result = apiInstance.getChallengeActivities(challengeId, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#getChallengeActivities");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **challengeId** | **Long**| The challenge id |
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceBareChallengeActivityResource**](PageResourceBareChallengeActivityResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getChallengeActivity"></a>
# **getChallengeActivity**
> ChallengeActivityResource getChallengeActivity(activityId)

Get a single challenge activity

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
Long activityId = 789L; // Long | The activity id
try {
    ChallengeActivityResource result = apiInstance.getChallengeActivity(activityId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#getChallengeActivity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activityId** | **Long**| The activity id |

### Return type

[**ChallengeActivityResource**](ChallengeActivityResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getChallengeActivityTemplate"></a>
# **getChallengeActivityTemplate**
> TemplateResource getChallengeActivityTemplate(id)

Get a single challenge activity template

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
String id = "id_example"; // String | The id of the template
try {
    TemplateResource result = apiInstance.getChallengeActivityTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#getChallengeActivityTemplate");
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

<a name="getChallengeActivityTemplates"></a>
# **getChallengeActivityTemplates**
> PageResourceTemplateResource getChallengeActivityTemplates(size, page, order)

List and search challenge activity templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceTemplateResource result = apiInstance.getChallengeActivityTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#getChallengeActivityTemplates");
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

<a name="getChallengeEvent"></a>
# **getChallengeEvent**
> ChallengeEventResource getChallengeEvent(id)

Retrieve a single challenge event details

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
Long id = 789L; // Long | The challenge event id
try {
    ChallengeEventResource result = apiInstance.getChallengeEvent(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#getChallengeEvent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The challenge event id |

### Return type

[**ChallengeEventResource**](ChallengeEventResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getChallengeEvents"></a>
# **getChallengeEvents**
> PageResourceChallengeEventResource getChallengeEvents(filterStartDate, filterEndDate, filterCampaigns, filterChallenge, size, page, order)

Retrieve a list of challenge events

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
String filterStartDate = "filterStartDate_example"; // String | A comma separated string without spaces.  First value is the operator to search on, second value is the event start date, a unix timestamp in seconds.  Allowed operators: (GT, LT, EQ, GOE, LOE).
String filterEndDate = "filterEndDate_example"; // String | A comma separated string without spaces.  First value is the operator to search on, second value is the event end date, a unix timestamp in seconds.  Allowed operators: (GT, LT, EQ, GOE, LOE).
Boolean filterCampaigns = true; // Boolean | check only for events from currently running campaigns
Long filterChallenge = 789L; // Long | check only for events from the challenge specified by id
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceChallengeEventResource result = apiInstance.getChallengeEvents(filterStartDate, filterEndDate, filterCampaigns, filterChallenge, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#getChallengeEvents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterStartDate** | **String**| A comma separated string without spaces.  First value is the operator to search on, second value is the event start date, a unix timestamp in seconds.  Allowed operators: (GT, LT, EQ, GOE, LOE). | [optional]
 **filterEndDate** | **String**| A comma separated string without spaces.  First value is the operator to search on, second value is the event end date, a unix timestamp in seconds.  Allowed operators: (GT, LT, EQ, GOE, LOE). | [optional]
 **filterCampaigns** | **Boolean**| check only for events from currently running campaigns | [optional]
 **filterChallenge** | **Long**| check only for events from the challenge specified by id | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceChallengeEventResource**](PageResourceChallengeEventResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getChallengeTemplate"></a>
# **getChallengeTemplate**
> TemplateResource getChallengeTemplate(id)

Get a single challenge template

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
String id = "id_example"; // String | The id of the template
try {
    TemplateResource result = apiInstance.getChallengeTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#getChallengeTemplate");
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

<a name="getChallengeTemplates"></a>
# **getChallengeTemplates**
> PageResourceTemplateResource getChallengeTemplates(size, page, order)

List and search challenge templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceTemplateResource result = apiInstance.getChallengeTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#getChallengeTemplates");
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

<a name="getChallenges"></a>
# **getChallenges**
> PageResourceChallengeResource getChallenges(filterTemplate, filterActiveCampaign)

Retrieve a list of challenges

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
Boolean filterTemplate = true; // Boolean | Filter for challenges that are not tied to campaigns (templates)
Boolean filterActiveCampaign = true; // Boolean | Filter for challenges that are tied to active campaigns
try {
    PageResourceChallengeResource result = apiInstance.getChallenges(filterTemplate, filterActiveCampaign);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#getChallenges");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterTemplate** | **Boolean**| Filter for challenges that are not tied to campaigns (templates) | [optional]
 **filterActiveCampaign** | **Boolean**| Filter for challenges that are tied to active campaigns | [optional]

### Return type

[**PageResourceChallengeResource**](PageResourceChallengeResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateChallenge"></a>
# **updateChallenge**
> ChallengeResource updateChallenge(id, challengeResource)

Update a challenge

If the challenge is a copy, changes will propagate to all the related challenges

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
Long id = 789L; // Long | The challenge id
ChallengeResource challengeResource = new ChallengeResource(); // ChallengeResource | The challenge resource object
try {
    ChallengeResource result = apiInstance.updateChallenge(id, challengeResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#updateChallenge");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The challenge id |
 **challengeResource** | [**ChallengeResource**](ChallengeResource.md)| The challenge resource object | [optional]

### Return type

[**ChallengeResource**](ChallengeResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateChallengeActivity"></a>
# **updateChallengeActivity**
> ChallengeActivityResource updateChallengeActivity(activityId, challengeId, challengeActivityResource)

Update a challenge activity

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
Long activityId = 789L; // Long | The activity id
Long challengeId = 789L; // Long | The challenge id
ChallengeActivityResource challengeActivityResource = new ChallengeActivityResource(); // ChallengeActivityResource | The challenge activity resource object
try {
    ChallengeActivityResource result = apiInstance.updateChallengeActivity(activityId, challengeId, challengeActivityResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#updateChallengeActivity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activityId** | **Long**| The activity id |
 **challengeId** | **Long**| The challenge id |
 **challengeActivityResource** | [**ChallengeActivityResource**](ChallengeActivityResource.md)| The challenge activity resource object | [optional]

### Return type

[**ChallengeActivityResource**](ChallengeActivityResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateChallengeActivityTemplate"></a>
# **updateChallengeActivityTemplate**
> TemplateResource updateChallengeActivityTemplate(id, challengeActivityTemplateResource)

Update an challenge activity template

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
String id = "id_example"; // String | The id of the template
TemplateResource challengeActivityTemplateResource = new TemplateResource(); // TemplateResource | The challengeActivity template resource object
try {
    TemplateResource result = apiInstance.updateChallengeActivityTemplate(id, challengeActivityTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#updateChallengeActivityTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **challengeActivityTemplateResource** | [**TemplateResource**](TemplateResource.md)| The challengeActivity template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateChallengeTemplate"></a>
# **updateChallengeTemplate**
> TemplateResource updateChallengeTemplate(id, challengeTemplateResource)

Update a challenge template

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsChallengesApi;

CampaignsChallengesApi apiInstance = new CampaignsChallengesApi();
String id = "id_example"; // String | The id of the template
TemplateResource challengeTemplateResource = new TemplateResource(); // TemplateResource | The challenge template resource object
try {
    TemplateResource result = apiInstance.updateChallengeTemplate(id, challengeTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsChallengesApi#updateChallengeTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **challengeTemplateResource** | [**TemplateResource**](TemplateResource.md)| The challenge template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

