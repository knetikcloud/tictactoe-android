# ActivitiesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createActivity**](ActivitiesApi.md#createActivity) | **POST** /activities | Create an activity
[**createActivityOccurrence**](ActivitiesApi.md#createActivityOccurrence) | **POST** /activity-occurrences | Create a new activity occurrence
[**createActivityTemplate**](ActivitiesApi.md#createActivityTemplate) | **POST** /activities/templates | Create a activity template
[**deleteActivity**](ActivitiesApi.md#deleteActivity) | **DELETE** /activities/{id} | Delete an activity
[**deleteActivityTemplate**](ActivitiesApi.md#deleteActivityTemplate) | **DELETE** /activities/templates/{id} | Delete a activity template
[**getActivities**](ActivitiesApi.md#getActivities) | **GET** /activities | List activity definitions
[**getActivity**](ActivitiesApi.md#getActivity) | **GET** /activities/{id} | Get a single activity
[**getActivityTemplate**](ActivitiesApi.md#getActivityTemplate) | **GET** /activities/templates/{id} | Get a single activity template
[**getActivityTemplates**](ActivitiesApi.md#getActivityTemplates) | **GET** /activities/templates | List and search activity templates
[**setActivityOccurrenceResults**](ActivitiesApi.md#setActivityOccurrenceResults) | **POST** /activity-occurrences/{activity_occurrence_id}/results | Sets the status of an activity occurrence to FINISHED and logs metrics
[**updateActivity**](ActivitiesApi.md#updateActivity) | **PUT** /activities/{id} | Update an activity
[**updateActivityOccurrence**](ActivitiesApi.md#updateActivityOccurrence) | **PUT** /activity-occurrences/{activity_occurrence_id}/status | Updated the status of an activity occurrence
[**updateActivityTemplate**](ActivitiesApi.md#updateActivityTemplate) | **PUT** /activities/templates/{id} | Update an activity template


<a name="createActivity"></a>
# **createActivity**
> ActivityResource createActivity(activityResource)

Create an activity

### Example
```java
// Import classes:
//import com.knetikcloud.api.ActivitiesApi;

ActivitiesApi apiInstance = new ActivitiesApi();
ActivityResource activityResource = new ActivityResource(); // ActivityResource | The activity resource object
try {
    ActivityResource result = apiInstance.createActivity(activityResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivitiesApi#createActivity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activityResource** | [**ActivityResource**](ActivityResource.md)| The activity resource object | [optional]

### Return type

[**ActivityResource**](ActivityResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createActivityOccurrence"></a>
# **createActivityOccurrence**
> ActivityOccurrenceResource createActivityOccurrence(test, activityOccurrenceResource)

Create a new activity occurrence

Has to enforce extra rules if not used as an admin

### Example
```java
// Import classes:
//import com.knetikcloud.api.ActivitiesApi;

ActivitiesApi apiInstance = new ActivitiesApi();
Boolean test = false; // Boolean | if true, indicates that the occurrence should NOT be created. This can be used to test for eligibility and valid settings
ActivityOccurrenceResource activityOccurrenceResource = new ActivityOccurrenceResource(); // ActivityOccurrenceResource | The activity occurrence object
try {
    ActivityOccurrenceResource result = apiInstance.createActivityOccurrence(test, activityOccurrenceResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivitiesApi#createActivityOccurrence");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **test** | **Boolean**| if true, indicates that the occurrence should NOT be created. This can be used to test for eligibility and valid settings | [optional] [default to false]
 **activityOccurrenceResource** | [**ActivityOccurrenceResource**](ActivityOccurrenceResource.md)| The activity occurrence object | [optional]

### Return type

[**ActivityOccurrenceResource**](ActivityOccurrenceResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createActivityTemplate"></a>
# **createActivityTemplate**
> TemplateResource createActivityTemplate(activityTemplateResource)

Create a activity template

Activity Templates define a type of activity and the properties they have

### Example
```java
// Import classes:
//import com.knetikcloud.api.ActivitiesApi;

ActivitiesApi apiInstance = new ActivitiesApi();
TemplateResource activityTemplateResource = new TemplateResource(); // TemplateResource | The activity template resource object
try {
    TemplateResource result = apiInstance.createActivityTemplate(activityTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivitiesApi#createActivityTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activityTemplateResource** | [**TemplateResource**](TemplateResource.md)| The activity template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteActivity"></a>
# **deleteActivity**
> deleteActivity(id)

Delete an activity

### Example
```java
// Import classes:
//import com.knetikcloud.api.ActivitiesApi;

ActivitiesApi apiInstance = new ActivitiesApi();
Long id = 789L; // Long | The id of the activity
try {
    apiInstance.deleteActivity(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivitiesApi#deleteActivity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The id of the activity |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteActivityTemplate"></a>
# **deleteActivityTemplate**
> deleteActivityTemplate(id, cascade)

Delete a activity template

If cascade &#x3D; &#39;detach&#39;, it will force delete the template even if it&#39;s attached to other objects

### Example
```java
// Import classes:
//import com.knetikcloud.api.ActivitiesApi;

ActivitiesApi apiInstance = new ActivitiesApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | The value needed to delete used templates
try {
    apiInstance.deleteActivityTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivitiesApi#deleteActivityTemplate");
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

<a name="getActivities"></a>
# **getActivities**
> PageResourceBareActivityResource getActivities(filterTemplate, filterName, filterId, size, page, order)

List activity definitions

### Example
```java
// Import classes:
//import com.knetikcloud.api.ActivitiesApi;

ActivitiesApi apiInstance = new ActivitiesApi();
Boolean filterTemplate = true; // Boolean | Filter for activities that are templates, or specifically not if false
String filterName = "filterName_example"; // String | Filter for activities that have a name starting with specified string
String filterId = "filterId_example"; // String | Filter for activities with an id in the given comma separated list of ids
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceBareActivityResource result = apiInstance.getActivities(filterTemplate, filterName, filterId, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivitiesApi#getActivities");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterTemplate** | **Boolean**| Filter for activities that are templates, or specifically not if false | [optional]
 **filterName** | **String**| Filter for activities that have a name starting with specified string | [optional]
 **filterId** | **String**| Filter for activities with an id in the given comma separated list of ids | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceBareActivityResource**](PageResourceBareActivityResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getActivity"></a>
# **getActivity**
> ActivityResource getActivity(id)

Get a single activity

### Example
```java
// Import classes:
//import com.knetikcloud.api.ActivitiesApi;

ActivitiesApi apiInstance = new ActivitiesApi();
Long id = 789L; // Long | The id of the activity
try {
    ActivityResource result = apiInstance.getActivity(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivitiesApi#getActivity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The id of the activity |

### Return type

[**ActivityResource**](ActivityResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getActivityTemplate"></a>
# **getActivityTemplate**
> TemplateResource getActivityTemplate(id)

Get a single activity template

### Example
```java
// Import classes:
//import com.knetikcloud.api.ActivitiesApi;

ActivitiesApi apiInstance = new ActivitiesApi();
String id = "id_example"; // String | The id of the template
try {
    TemplateResource result = apiInstance.getActivityTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivitiesApi#getActivityTemplate");
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

<a name="getActivityTemplates"></a>
# **getActivityTemplates**
> PageResourceTemplateResource getActivityTemplates(size, page, order)

List and search activity templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.ActivitiesApi;

ActivitiesApi apiInstance = new ActivitiesApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceTemplateResource result = apiInstance.getActivityTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivitiesApi#getActivityTemplates");
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

<a name="setActivityOccurrenceResults"></a>
# **setActivityOccurrenceResults**
> ActivityOccurrenceResults setActivityOccurrenceResults(activityOccurrenceId, activityOccurrenceResults)

Sets the status of an activity occurrence to FINISHED and logs metrics

### Example
```java
// Import classes:
//import com.knetikcloud.api.ActivitiesApi;

ActivitiesApi apiInstance = new ActivitiesApi();
Long activityOccurrenceId = 789L; // Long | The id of the activity occurrence
ActivityOccurrenceResults activityOccurrenceResults = new ActivityOccurrenceResults(); // ActivityOccurrenceResults | The activity occurrence object
try {
    ActivityOccurrenceResults result = apiInstance.setActivityOccurrenceResults(activityOccurrenceId, activityOccurrenceResults);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivitiesApi#setActivityOccurrenceResults");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activityOccurrenceId** | **Long**| The id of the activity occurrence |
 **activityOccurrenceResults** | [**ActivityOccurrenceResults**](ActivityOccurrenceResults.md)| The activity occurrence object | [optional]

### Return type

[**ActivityOccurrenceResults**](ActivityOccurrenceResults.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateActivity"></a>
# **updateActivity**
> ActivityResource updateActivity(id, activityResource)

Update an activity

### Example
```java
// Import classes:
//import com.knetikcloud.api.ActivitiesApi;

ActivitiesApi apiInstance = new ActivitiesApi();
Long id = 789L; // Long | The id of the activity
ActivityResource activityResource = new ActivityResource(); // ActivityResource | The activity resource object
try {
    ActivityResource result = apiInstance.updateActivity(id, activityResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivitiesApi#updateActivity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The id of the activity |
 **activityResource** | [**ActivityResource**](ActivityResource.md)| The activity resource object | [optional]

### Return type

[**ActivityResource**](ActivityResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateActivityOccurrence"></a>
# **updateActivityOccurrence**
> updateActivityOccurrence(activityOccurrenceId, activityCccurrenceStatus)

Updated the status of an activity occurrence

If setting to &#39;FINISHED&#39; you must POST to /results instead to record the metrics and get synchronous reward results

### Example
```java
// Import classes:
//import com.knetikcloud.api.ActivitiesApi;

ActivitiesApi apiInstance = new ActivitiesApi();
Long activityOccurrenceId = 789L; // Long | The id of the activity occurrence
String activityCccurrenceStatus = "activityCccurrenceStatus_example"; // String | The activity occurrence status object
try {
    apiInstance.updateActivityOccurrence(activityOccurrenceId, activityCccurrenceStatus);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivitiesApi#updateActivityOccurrence");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activityOccurrenceId** | **Long**| The id of the activity occurrence |
 **activityCccurrenceStatus** | **String**| The activity occurrence status object | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateActivityTemplate"></a>
# **updateActivityTemplate**
> TemplateResource updateActivityTemplate(id, activityTemplateResource)

Update an activity template

### Example
```java
// Import classes:
//import com.knetikcloud.api.ActivitiesApi;

ActivitiesApi apiInstance = new ActivitiesApi();
String id = "id_example"; // String | The id of the template
TemplateResource activityTemplateResource = new TemplateResource(); // TemplateResource | The activity template resource object
try {
    TemplateResource result = apiInstance.updateActivityTemplate(id, activityTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivitiesApi#updateActivityTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **activityTemplateResource** | [**TemplateResource**](TemplateResource.md)| The activity template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

