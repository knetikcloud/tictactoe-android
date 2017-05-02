# CampaignsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addChallengeToCampaign**](CampaignsApi.md#addChallengeToCampaign) | **POST** /campaigns/{id}/challenges | Add a challenge to a campaign
[**createCampaign**](CampaignsApi.md#createCampaign) | **POST** /campaigns | Create a campaign
[**createCampaignTemplate**](CampaignsApi.md#createCampaignTemplate) | **POST** /campaigns/templates | Create a campaign template
[**deleteCampaign**](CampaignsApi.md#deleteCampaign) | **DELETE** /campaigns/{id} | Delete a campaign
[**deleteCampaignTemplate**](CampaignsApi.md#deleteCampaignTemplate) | **DELETE** /campaigns/templates/{id} | Delete a campaign template
[**getCampaign**](CampaignsApi.md#getCampaign) | **GET** /campaigns/{id} | Returns a single campaign
[**getCampaignChallenges**](CampaignsApi.md#getCampaignChallenges) | **GET** /campaigns/{id}/challenges | List the challenges associated with a campaign
[**getCampaignTemplate**](CampaignsApi.md#getCampaignTemplate) | **GET** /campaigns/templates/{id} | Get a single campaign template
[**getCampaignTemplates**](CampaignsApi.md#getCampaignTemplates) | **GET** /campaigns/templates | List and search campaign templates
[**getCampaigns**](CampaignsApi.md#getCampaigns) | **GET** /campaigns | List and search campaigns
[**removeChallengeFromCampaign**](CampaignsApi.md#removeChallengeFromCampaign) | **DELETE** /campaigns/{campaign_id}/challenges/{id} | Remove a challenge from a campaign
[**updateCampaign**](CampaignsApi.md#updateCampaign) | **PUT** /campaigns/{id} | Update a campaign
[**updateCampaignTemplate**](CampaignsApi.md#updateCampaignTemplate) | **PUT** /campaigns/templates/{id} | Update an campaign template


<a name="addChallengeToCampaign"></a>
# **addChallengeToCampaign**
> addChallengeToCampaign(id, challengeId)

Add a challenge to a campaign

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsApi;

CampaignsApi apiInstance = new CampaignsApi();
Long id = 789L; // Long | The id of the campaign
Long challengeId = 789L; // Long | The id of the challenge
try {
    apiInstance.addChallengeToCampaign(id, challengeId);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsApi#addChallengeToCampaign");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The id of the campaign |
 **challengeId** | **Long**| The id of the challenge | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createCampaign"></a>
# **createCampaign**
> CampaignResource createCampaign(campaignResource)

Create a campaign

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsApi;

CampaignsApi apiInstance = new CampaignsApi();
CampaignResource campaignResource = new CampaignResource(); // CampaignResource | The campaign resource object
try {
    CampaignResource result = apiInstance.createCampaign(campaignResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsApi#createCampaign");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignResource** | [**CampaignResource**](CampaignResource.md)| The campaign resource object | [optional]

### Return type

[**CampaignResource**](CampaignResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createCampaignTemplate"></a>
# **createCampaignTemplate**
> TemplateResource createCampaignTemplate(campaignTemplateResource)

Create a campaign template

Campaign Templates define a type of campaign and the properties they have

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsApi;

CampaignsApi apiInstance = new CampaignsApi();
TemplateResource campaignTemplateResource = new TemplateResource(); // TemplateResource | The campaign template resource object
try {
    TemplateResource result = apiInstance.createCampaignTemplate(campaignTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsApi#createCampaignTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignTemplateResource** | [**TemplateResource**](TemplateResource.md)| The campaign template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteCampaign"></a>
# **deleteCampaign**
> deleteCampaign(id)

Delete a campaign

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsApi;

CampaignsApi apiInstance = new CampaignsApi();
Long id = 789L; // Long | The campaign id
try {
    apiInstance.deleteCampaign(id);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsApi#deleteCampaign");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The campaign id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteCampaignTemplate"></a>
# **deleteCampaignTemplate**
> deleteCampaignTemplate(id, cascade)

Delete a campaign template

If cascade &#x3D; &#39;detach&#39;, it will force delete the template even if it&#39;s attached to other objects

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsApi;

CampaignsApi apiInstance = new CampaignsApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | The value needed to delete used templates
try {
    apiInstance.deleteCampaignTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsApi#deleteCampaignTemplate");
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

<a name="getCampaign"></a>
# **getCampaign**
> CampaignResource getCampaign(id)

Returns a single campaign

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsApi;

CampaignsApi apiInstance = new CampaignsApi();
Long id = 789L; // Long | The campaign id
try {
    CampaignResource result = apiInstance.getCampaign(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsApi#getCampaign");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The campaign id |

### Return type

[**CampaignResource**](CampaignResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCampaignChallenges"></a>
# **getCampaignChallenges**
> PageResourceChallengeResource getCampaignChallenges(id)

List the challenges associated with a campaign

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsApi;

CampaignsApi apiInstance = new CampaignsApi();
Long id = 789L; // Long | The campaign id
try {
    PageResourceChallengeResource result = apiInstance.getCampaignChallenges(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsApi#getCampaignChallenges");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The campaign id |

### Return type

[**PageResourceChallengeResource**](PageResourceChallengeResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCampaignTemplate"></a>
# **getCampaignTemplate**
> TemplateResource getCampaignTemplate(id)

Get a single campaign template

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsApi;

CampaignsApi apiInstance = new CampaignsApi();
String id = "id_example"; // String | The id of the template
try {
    TemplateResource result = apiInstance.getCampaignTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsApi#getCampaignTemplate");
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

<a name="getCampaignTemplates"></a>
# **getCampaignTemplates**
> PageResourceTemplateResource getCampaignTemplates(size, page, order)

List and search campaign templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsApi;

CampaignsApi apiInstance = new CampaignsApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceTemplateResource result = apiInstance.getCampaignTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsApi#getCampaignTemplates");
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

<a name="getCampaigns"></a>
# **getCampaigns**
> PageResourceCampaignResource getCampaigns(filterActive, size, page, order)

List and search campaigns

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsApi;

CampaignsApi apiInstance = new CampaignsApi();
Boolean filterActive = true; // Boolean | Filter for campaigns that are active
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceCampaignResource result = apiInstance.getCampaigns(filterActive, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsApi#getCampaigns");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterActive** | **Boolean**| Filter for campaigns that are active | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceCampaignResource**](PageResourceCampaignResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeChallengeFromCampaign"></a>
# **removeChallengeFromCampaign**
> removeChallengeFromCampaign(campaignId, id)

Remove a challenge from a campaign

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsApi;

CampaignsApi apiInstance = new CampaignsApi();
Long campaignId = 789L; // Long | The campaign id
Long id = 789L; // Long | The challenge id
try {
    apiInstance.removeChallengeFromCampaign(campaignId, id);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsApi#removeChallengeFromCampaign");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **Long**| The campaign id |
 **id** | **Long**| The challenge id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateCampaign"></a>
# **updateCampaign**
> CampaignResource updateCampaign(id, campaignResource)

Update a campaign

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsApi;

CampaignsApi apiInstance = new CampaignsApi();
Long id = 789L; // Long | The campaign id
CampaignResource campaignResource = new CampaignResource(); // CampaignResource | The campaign resource object
try {
    CampaignResource result = apiInstance.updateCampaign(id, campaignResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsApi#updateCampaign");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The campaign id |
 **campaignResource** | [**CampaignResource**](CampaignResource.md)| The campaign resource object | [optional]

### Return type

[**CampaignResource**](CampaignResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateCampaignTemplate"></a>
# **updateCampaignTemplate**
> TemplateResource updateCampaignTemplate(id, campaignTemplateResource)

Update an campaign template

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsApi;

CampaignsApi apiInstance = new CampaignsApi();
String id = "id_example"; // String | The id of the template
TemplateResource campaignTemplateResource = new TemplateResource(); // TemplateResource | The campaign template resource object
try {
    TemplateResource result = apiInstance.updateCampaignTemplate(id, campaignTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsApi#updateCampaignTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **campaignTemplateResource** | [**TemplateResource**](TemplateResource.md)| The campaign template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

