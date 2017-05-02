# ContentPollsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**answerPoll**](ContentPollsApi.md#answerPoll) | **POST** /media/polls/{id}/response | Add your vote to a poll
[**createPoll**](ContentPollsApi.md#createPoll) | **POST** /media/polls | Create a new poll
[**createPollTemplate**](ContentPollsApi.md#createPollTemplate) | **POST** /media/polls/templates | Create a poll template
[**deletePoll**](ContentPollsApi.md#deletePoll) | **DELETE** /media/polls/{id} | Delete an existing poll
[**deletePollTemplate**](ContentPollsApi.md#deletePollTemplate) | **DELETE** /media/polls/templates/{id} | Delete a poll template
[**getPoll**](ContentPollsApi.md#getPoll) | **GET** /media/polls/{id} | Get a single poll
[**getPollAnswer**](ContentPollsApi.md#getPollAnswer) | **GET** /media/polls/{id}/response | Get poll answer
[**getPollTemplate**](ContentPollsApi.md#getPollTemplate) | **GET** /media/polls/templates/{id} | Get a single poll template
[**getPollTemplates**](ContentPollsApi.md#getPollTemplates) | **GET** /media/polls/templates | List and search poll templates
[**getPolls**](ContentPollsApi.md#getPolls) | **GET** /media/polls | List and search polls
[**updatePoll**](ContentPollsApi.md#updatePoll) | **PUT** /media/polls/{id} | Update an existing poll
[**updatePollTemplate**](ContentPollsApi.md#updatePollTemplate) | **PUT** /media/polls/templates/{id} | Update a poll template


<a name="answerPoll"></a>
# **answerPoll**
> PollResponseResource answerPoll(id, answerKey)

Add your vote to a poll

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentPollsApi;

ContentPollsApi apiInstance = new ContentPollsApi();
String id = "id_example"; // String | The poll id
String answerKey = "answerKey_example"; // String | The answer key
try {
    PollResponseResource result = apiInstance.answerPoll(id, answerKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentPollsApi#answerPoll");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The poll id |
 **answerKey** | **String**| The answer key | [optional]

### Return type

[**PollResponseResource**](PollResponseResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createPoll"></a>
# **createPoll**
> PollResource createPoll(pollResource)

Create a new poll

Polls are blobs of text with titles, a category and assets. Formatting and display of the text is in the hands of the front end.

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentPollsApi;

ContentPollsApi apiInstance = new ContentPollsApi();
PollResource pollResource = new PollResource(); // PollResource | The poll object
try {
    PollResource result = apiInstance.createPoll(pollResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentPollsApi#createPoll");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pollResource** | [**PollResource**](PollResource.md)| The poll object | [optional]

### Return type

[**PollResource**](PollResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createPollTemplate"></a>
# **createPollTemplate**
> TemplateResource createPollTemplate(pollTemplateResource)

Create a poll template

Poll templates define a type of poll and the properties they have

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentPollsApi;

ContentPollsApi apiInstance = new ContentPollsApi();
TemplateResource pollTemplateResource = new TemplateResource(); // TemplateResource | The poll template resource object
try {
    TemplateResource result = apiInstance.createPollTemplate(pollTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentPollsApi#createPollTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pollTemplateResource** | [**TemplateResource**](TemplateResource.md)| The poll template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deletePoll"></a>
# **deletePoll**
> deletePoll(id)

Delete an existing poll

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentPollsApi;

ContentPollsApi apiInstance = new ContentPollsApi();
String id = "id_example"; // String | The poll id
try {
    apiInstance.deletePoll(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentPollsApi#deletePoll");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The poll id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deletePollTemplate"></a>
# **deletePollTemplate**
> deletePollTemplate(id, cascade)

Delete a poll template

If cascade &#x3D; &#39;detach&#39;, it will force delete the template even if it&#39;s attached to other objects

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentPollsApi;

ContentPollsApi apiInstance = new ContentPollsApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | The value needed to delete used templates
try {
    apiInstance.deletePollTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentPollsApi#deletePollTemplate");
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

<a name="getPoll"></a>
# **getPoll**
> PollResource getPoll(id)

Get a single poll

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentPollsApi;

ContentPollsApi apiInstance = new ContentPollsApi();
String id = "id_example"; // String | The poll id
try {
    PollResource result = apiInstance.getPoll(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentPollsApi#getPoll");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The poll id |

### Return type

[**PollResource**](PollResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getPollAnswer"></a>
# **getPollAnswer**
> PollResponseResource getPollAnswer(id)

Get poll answer

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentPollsApi;

ContentPollsApi apiInstance = new ContentPollsApi();
String id = "id_example"; // String | The poll id
try {
    PollResponseResource result = apiInstance.getPollAnswer(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentPollsApi#getPollAnswer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The poll id |

### Return type

[**PollResponseResource**](PollResponseResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getPollTemplate"></a>
# **getPollTemplate**
> TemplateResource getPollTemplate(id)

Get a single poll template

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentPollsApi;

ContentPollsApi apiInstance = new ContentPollsApi();
String id = "id_example"; // String | The id of the template
try {
    TemplateResource result = apiInstance.getPollTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentPollsApi#getPollTemplate");
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

<a name="getPollTemplates"></a>
# **getPollTemplates**
> PageResourceTemplateResource getPollTemplates(size, page, order)

List and search poll templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentPollsApi;

ContentPollsApi apiInstance = new ContentPollsApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceTemplateResource result = apiInstance.getPollTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentPollsApi#getPollTemplates");
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

<a name="getPolls"></a>
# **getPolls**
> PageResourcePollResource getPolls(filterCategory, filterTagset, filterText, size, page, order)

List and search polls

Get a list of polls with optional filtering. Assets will not be filled in on the resources returned. Use &#39;Get a single poll&#39; to retrieve the full resource with assets for a given item as needed.

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentPollsApi;

ContentPollsApi apiInstance = new ContentPollsApi();
String filterCategory = "filterCategory_example"; // String | Filter for polls from a specific category by id
String filterTagset = "filterTagset_example"; // String | Filter for polls with specified tags (separated by comma)
String filterText = "filterText_example"; // String | Filter for polls whose text contains a string
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourcePollResource result = apiInstance.getPolls(filterCategory, filterTagset, filterText, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentPollsApi#getPolls");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterCategory** | **String**| Filter for polls from a specific category by id | [optional]
 **filterTagset** | **String**| Filter for polls with specified tags (separated by comma) | [optional]
 **filterText** | **String**| Filter for polls whose text contains a string | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourcePollResource**](PageResourcePollResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updatePoll"></a>
# **updatePoll**
> PollResource updatePoll(id, pollResource)

Update an existing poll

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentPollsApi;

ContentPollsApi apiInstance = new ContentPollsApi();
String id = "id_example"; // String | The poll id
PollResource pollResource = new PollResource(); // PollResource | The poll object
try {
    PollResource result = apiInstance.updatePoll(id, pollResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentPollsApi#updatePoll");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The poll id |
 **pollResource** | [**PollResource**](PollResource.md)| The poll object | [optional]

### Return type

[**PollResource**](PollResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updatePollTemplate"></a>
# **updatePollTemplate**
> TemplateResource updatePollTemplate(id, pollTemplateResource)

Update a poll template

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentPollsApi;

ContentPollsApi apiInstance = new ContentPollsApi();
String id = "id_example"; // String | The id of the template
TemplateResource pollTemplateResource = new TemplateResource(); // TemplateResource | The poll template resource object
try {
    TemplateResource result = apiInstance.updatePollTemplate(id, pollTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentPollsApi#updatePollTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **pollTemplateResource** | [**TemplateResource**](TemplateResource.md)| The poll template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

