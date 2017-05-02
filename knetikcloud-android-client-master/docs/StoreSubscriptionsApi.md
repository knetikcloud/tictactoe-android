# StoreSubscriptionsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSubscription**](StoreSubscriptionsApi.md#createSubscription) | **POST** /subscriptions | Creates a subscription item and associated plans
[**createSubscriptionTemplate**](StoreSubscriptionsApi.md#createSubscriptionTemplate) | **POST** /subscriptions/templates | Create a subscription template
[**deleteSubscription**](StoreSubscriptionsApi.md#deleteSubscription) | **DELETE** /subscriptions/{id}/plans/{plan_id} | Delete a subscription plan
[**deleteSubscriptionTemplate**](StoreSubscriptionsApi.md#deleteSubscriptionTemplate) | **DELETE** /subscriptions/templates/{id} | Delete a subscription template
[**getSubscription**](StoreSubscriptionsApi.md#getSubscription) | **GET** /subscriptions/{id} | Retrieve a single subscription item and associated plans
[**getSubscriptionTemplate**](StoreSubscriptionsApi.md#getSubscriptionTemplate) | **GET** /subscriptions/templates/{id} | Get a single subscription template
[**getSubscriptionTemplates**](StoreSubscriptionsApi.md#getSubscriptionTemplates) | **GET** /subscriptions/templates | List and search subscription templates
[**getSubscriptions**](StoreSubscriptionsApi.md#getSubscriptions) | **GET** /subscriptions | List available subscription items and associated plans
[**processSubscriptions**](StoreSubscriptionsApi.md#processSubscriptions) | **POST** /subscriptions/process | Processes subscriptions and charge dues
[**updateSubscription**](StoreSubscriptionsApi.md#updateSubscription) | **PUT** /subscriptions/{id} | Updates a subscription item and associated plans
[**updateSubscriptionTemplate**](StoreSubscriptionsApi.md#updateSubscriptionTemplate) | **PUT** /subscriptions/templates/{id} | Update a subscription template


<a name="createSubscription"></a>
# **createSubscription**
> SubscriptionResource createSubscription(subscriptionResource)

Creates a subscription item and associated plans

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreSubscriptionsApi;

StoreSubscriptionsApi apiInstance = new StoreSubscriptionsApi();
SubscriptionResource subscriptionResource = new SubscriptionResource(); // SubscriptionResource | The subscription to be created
try {
    SubscriptionResource result = apiInstance.createSubscription(subscriptionResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreSubscriptionsApi#createSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionResource** | [**SubscriptionResource**](SubscriptionResource.md)| The subscription to be created | [optional]

### Return type

[**SubscriptionResource**](SubscriptionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createSubscriptionTemplate"></a>
# **createSubscriptionTemplate**
> SubscriptionTemplateResource createSubscriptionTemplate(subscriptionTemplateResource)

Create a subscription template

Subscription Templates define a type of subscription and the properties they have.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreSubscriptionsApi;

StoreSubscriptionsApi apiInstance = new StoreSubscriptionsApi();
SubscriptionTemplateResource subscriptionTemplateResource = new SubscriptionTemplateResource(); // SubscriptionTemplateResource | The new subscription template
try {
    SubscriptionTemplateResource result = apiInstance.createSubscriptionTemplate(subscriptionTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreSubscriptionsApi#createSubscriptionTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionTemplateResource** | [**SubscriptionTemplateResource**](SubscriptionTemplateResource.md)| The new subscription template | [optional]

### Return type

[**SubscriptionTemplateResource**](SubscriptionTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteSubscription"></a>
# **deleteSubscription**
> deleteSubscription(id, planId)

Delete a subscription plan

Must not be locked or a migration target

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreSubscriptionsApi;

StoreSubscriptionsApi apiInstance = new StoreSubscriptionsApi();
Integer id = 56; // Integer | The id of the subscription
String planId = "planId_example"; // String | The id of the plan
try {
    apiInstance.deleteSubscription(id, planId);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreSubscriptionsApi#deleteSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the subscription |
 **planId** | **String**| The id of the plan |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteSubscriptionTemplate"></a>
# **deleteSubscriptionTemplate**
> deleteSubscriptionTemplate(id, cascade)

Delete a subscription template

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreSubscriptionsApi;

StoreSubscriptionsApi apiInstance = new StoreSubscriptionsApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | force deleting the template if it's attached to other objects, cascade = detach
try {
    apiInstance.deleteSubscriptionTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreSubscriptionsApi#deleteSubscriptionTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **cascade** | **String**| force deleting the template if it&#39;s attached to other objects, cascade &#x3D; detach | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSubscription"></a>
# **getSubscription**
> SubscriptionResource getSubscription(id)

Retrieve a single subscription item and associated plans

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreSubscriptionsApi;

StoreSubscriptionsApi apiInstance = new StoreSubscriptionsApi();
Integer id = 56; // Integer | The id of the subscription
try {
    SubscriptionResource result = apiInstance.getSubscription(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreSubscriptionsApi#getSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the subscription |

### Return type

[**SubscriptionResource**](SubscriptionResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSubscriptionTemplate"></a>
# **getSubscriptionTemplate**
> SubscriptionTemplateResource getSubscriptionTemplate(id)

Get a single subscription template

Subscription Templates define a type of subscription and the properties they have.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreSubscriptionsApi;

StoreSubscriptionsApi apiInstance = new StoreSubscriptionsApi();
String id = "id_example"; // String | The id of the template
try {
    SubscriptionTemplateResource result = apiInstance.getSubscriptionTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreSubscriptionsApi#getSubscriptionTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |

### Return type

[**SubscriptionTemplateResource**](SubscriptionTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSubscriptionTemplates"></a>
# **getSubscriptionTemplates**
> PageResourceSubscriptionTemplateResource getSubscriptionTemplates(size, page, order)

List and search subscription templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreSubscriptionsApi;

StoreSubscriptionsApi apiInstance = new StoreSubscriptionsApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceSubscriptionTemplateResource result = apiInstance.getSubscriptionTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreSubscriptionsApi#getSubscriptionTemplates");
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

[**PageResourceSubscriptionTemplateResource**](PageResourceSubscriptionTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSubscriptions"></a>
# **getSubscriptions**
> PageResourceSubscriptionResource getSubscriptions(size, page, order)

List available subscription items and associated plans

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreSubscriptionsApi;

StoreSubscriptionsApi apiInstance = new StoreSubscriptionsApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceSubscriptionResource result = apiInstance.getSubscriptions(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreSubscriptionsApi#getSubscriptions");
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

[**PageResourceSubscriptionResource**](PageResourceSubscriptionResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="processSubscriptions"></a>
# **processSubscriptions**
> processSubscriptions()

Processes subscriptions and charge dues

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreSubscriptionsApi;

StoreSubscriptionsApi apiInstance = new StoreSubscriptionsApi();
try {
    apiInstance.processSubscriptions();
} catch (ApiException e) {
    System.err.println("Exception when calling StoreSubscriptionsApi#processSubscriptions");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateSubscription"></a>
# **updateSubscription**
> updateSubscription(id, subscriptionResource)

Updates a subscription item and associated plans

Will not remove plans left out

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreSubscriptionsApi;

StoreSubscriptionsApi apiInstance = new StoreSubscriptionsApi();
Integer id = 56; // Integer | The id of the subscription
SubscriptionResource subscriptionResource = new SubscriptionResource(); // SubscriptionResource | The subscription resource object
try {
    apiInstance.updateSubscription(id, subscriptionResource);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreSubscriptionsApi#updateSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the subscription |
 **subscriptionResource** | [**SubscriptionResource**](SubscriptionResource.md)| The subscription resource object | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateSubscriptionTemplate"></a>
# **updateSubscriptionTemplate**
> SubscriptionTemplateResource updateSubscriptionTemplate(id, subscriptionTemplateResource)

Update a subscription template

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreSubscriptionsApi;

StoreSubscriptionsApi apiInstance = new StoreSubscriptionsApi();
String id = "id_example"; // String | The id of the template
SubscriptionTemplateResource subscriptionTemplateResource = new SubscriptionTemplateResource(); // SubscriptionTemplateResource | The subscription template resource object
try {
    SubscriptionTemplateResource result = apiInstance.updateSubscriptionTemplate(id, subscriptionTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreSubscriptionsApi#updateSubscriptionTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **subscriptionTemplateResource** | [**SubscriptionTemplateResource**](SubscriptionTemplateResource.md)| The subscription template resource object | [optional]

### Return type

[**SubscriptionTemplateResource**](SubscriptionTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

