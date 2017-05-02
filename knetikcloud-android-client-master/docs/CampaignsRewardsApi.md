# CampaignsRewardsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createRewardSet**](CampaignsRewardsApi.md#createRewardSet) | **POST** /rewards | Create a reward set
[**deleteRewardSet**](CampaignsRewardsApi.md#deleteRewardSet) | **DELETE** /rewards/{id} | Delete a reward set
[**getRewardSet**](CampaignsRewardsApi.md#getRewardSet) | **GET** /rewards/{id} | Get a single reward set
[**getRewardSets**](CampaignsRewardsApi.md#getRewardSets) | **GET** /rewards | List and search reward sets
[**updateRewardSet**](CampaignsRewardsApi.md#updateRewardSet) | **PUT** /rewards/{id} | Update a reward set


<a name="createRewardSet"></a>
# **createRewardSet**
> RewardSetResource createRewardSet(rewardSetResource)

Create a reward set

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsRewardsApi;

CampaignsRewardsApi apiInstance = new CampaignsRewardsApi();
RewardSetResource rewardSetResource = new RewardSetResource(); // RewardSetResource | The reward set resource object
try {
    RewardSetResource result = apiInstance.createRewardSet(rewardSetResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsRewardsApi#createRewardSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rewardSetResource** | [**RewardSetResource**](RewardSetResource.md)| The reward set resource object | [optional]

### Return type

[**RewardSetResource**](RewardSetResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteRewardSet"></a>
# **deleteRewardSet**
> deleteRewardSet(id)

Delete a reward set

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsRewardsApi;

CampaignsRewardsApi apiInstance = new CampaignsRewardsApi();
Integer id = 56; // Integer | The reward id
try {
    apiInstance.deleteRewardSet(id);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsRewardsApi#deleteRewardSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The reward id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getRewardSet"></a>
# **getRewardSet**
> RewardSetResource getRewardSet(id)

Get a single reward set

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsRewardsApi;

CampaignsRewardsApi apiInstance = new CampaignsRewardsApi();
Integer id = 56; // Integer | The reward id
try {
    RewardSetResource result = apiInstance.getRewardSet(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsRewardsApi#getRewardSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The reward id |

### Return type

[**RewardSetResource**](RewardSetResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getRewardSets"></a>
# **getRewardSets**
> PageResourceRewardSetResource getRewardSets(size, page, order)

List and search reward sets

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsRewardsApi;

CampaignsRewardsApi apiInstance = new CampaignsRewardsApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceRewardSetResource result = apiInstance.getRewardSets(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsRewardsApi#getRewardSets");
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

[**PageResourceRewardSetResource**](PageResourceRewardSetResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateRewardSet"></a>
# **updateRewardSet**
> RewardSetResource updateRewardSet(id, rewardSetResource)

Update a reward set

### Example
```java
// Import classes:
//import com.knetikcloud.api.CampaignsRewardsApi;

CampaignsRewardsApi apiInstance = new CampaignsRewardsApi();
Integer id = 56; // Integer | The reward id
RewardSetResource rewardSetResource = new RewardSetResource(); // RewardSetResource | The reward set resource object
try {
    RewardSetResource result = apiInstance.updateRewardSet(id, rewardSetResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignsRewardsApi#updateRewardSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The reward id |
 **rewardSetResource** | [**RewardSetResource**](RewardSetResource.md)| The reward set resource object | [optional]

### Return type

[**RewardSetResource**](RewardSetResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

