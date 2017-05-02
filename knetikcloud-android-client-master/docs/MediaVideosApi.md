# MediaVideosApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addUserToVideoWhitelist**](MediaVideosApi.md#addUserToVideoWhitelist) | **POST** /media/videos/{id}/whitelist | Adds a user to a video&#39;s whitelist
[**addVideo**](MediaVideosApi.md#addVideo) | **POST** /media/videos | Adds a new video in the system
[**addVideoComment**](MediaVideosApi.md#addVideoComment) | **POST** /media/videos/{video_id}/comments | Add a new video comment
[**addVideoContributor**](MediaVideosApi.md#addVideoContributor) | **POST** /media/videos/{video_id}/contributors | Adds a contributor to a video
[**addVideoFlag**](MediaVideosApi.md#addVideoFlag) | **POST** /media/videos/{video_id}/moderation | Add a new flag
[**addVideoRelationships**](MediaVideosApi.md#addVideoRelationships) | **POST** /media/videos/{video_id}/related | Adds one or more existing videos as related to this one
[**createVideoDisposition**](MediaVideosApi.md#createVideoDisposition) | **POST** /media/videos/{video_id}/dispositions | Create a video disposition
[**deleteVideo**](MediaVideosApi.md#deleteVideo) | **DELETE** /media/videos/{id} | Deletes a video from the system if no resources are attached to it
[**deleteVideoComment**](MediaVideosApi.md#deleteVideoComment) | **DELETE** /media/videos/{video_id}/comments/{id} | Delete a video comment
[**deleteVideoDisposition**](MediaVideosApi.md#deleteVideoDisposition) | **DELETE** /media/videos/{video_id}/dispositions/{disposition_id} | Delete a video disposition
[**deleteVideoFlag**](MediaVideosApi.md#deleteVideoFlag) | **DELETE** /media/videos/{video_id}/moderation | Delete a flag
[**deleteVideoRelationship**](MediaVideosApi.md#deleteVideoRelationship) | **DELETE** /media/videos/{video_id}/related/{id} | Delete a video&#39;s relationship
[**getUserVideos**](MediaVideosApi.md#getUserVideos) | **GET** /users/{user_id}/videos | Get user videos
[**getVideo**](MediaVideosApi.md#getVideo) | **GET** /media/videos/{id} | Loads a specific video details
[**getVideoComments**](MediaVideosApi.md#getVideoComments) | **GET** /media/videos/{video_id}/comments | Returns a page of comments for a video
[**getVideoDispositions**](MediaVideosApi.md#getVideoDispositions) | **GET** /media/videos/{video_id}/dispositions | Returns a page of dispositions for a video
[**getVideoRelationships**](MediaVideosApi.md#getVideoRelationships) | **GET** /media/videos/{video_id}/related | Returns a page of video relationships
[**getVideos**](MediaVideosApi.md#getVideos) | **GET** /media/videos | Search videos using the documented filters
[**removeUserFromVideoWhitelist**](MediaVideosApi.md#removeUserFromVideoWhitelist) | **DELETE** /media/videos/{video_id}/whitelist/{id} | Removes a user from a video&#39;s whitelist
[**removeVideoContributor**](MediaVideosApi.md#removeVideoContributor) | **DELETE** /media/videos/{video_id}/contributors/{id} | Removes a contributor from a video
[**updateVideo**](MediaVideosApi.md#updateVideo) | **PUT** /media/videos/{id} | Modifies a video&#39;s details
[**updateVideoComment**](MediaVideosApi.md#updateVideoComment) | **PUT** /media/videos/{video_id}/comments/{id}/content | Update a video comment
[**updateVideoRelationship**](MediaVideosApi.md#updateVideoRelationship) | **PUT** /media/videos/{video_id}/related/{id}/relationship_details | Update a video&#39;s relationship details
[**viewVideo**](MediaVideosApi.md#viewVideo) | **POST** /media/videos/{id}/views | Increment a video&#39;s view count


<a name="addUserToVideoWhitelist"></a>
# **addUserToVideoWhitelist**
> addUserToVideoWhitelist(id, userId)

Adds a user to a video&#39;s whitelist

Whitelisted users can view video regardless of privacy setting.

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long id = 789L; // Long | The video id
Integer userId = 56; // Integer | The user id
try {
    apiInstance.addUserToVideoWhitelist(id, userId);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#addUserToVideoWhitelist");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The video id |
 **userId** | **Integer**| The user id | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addVideo"></a>
# **addVideo**
> VideoResource addVideo(videoResource)

Adds a new video in the system

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
VideoResource videoResource = new VideoResource(); // VideoResource | The video object
try {
    VideoResource result = apiInstance.addVideo(videoResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#addVideo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **videoResource** | [**VideoResource**](VideoResource.md)| The video object | [optional]

### Return type

[**VideoResource**](VideoResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addVideoComment"></a>
# **addVideoComment**
> CommentResource addVideoComment(videoId, commentResource)

Add a new video comment

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Integer videoId = 56; // Integer | The video id 
CommentResource commentResource = new CommentResource(); // CommentResource | The comment object
try {
    CommentResource result = apiInstance.addVideoComment(videoId, commentResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#addVideoComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **videoId** | **Integer**| The video id  |
 **commentResource** | [**CommentResource**](CommentResource.md)| The comment object | [optional]

### Return type

[**CommentResource**](CommentResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addVideoContributor"></a>
# **addVideoContributor**
> addVideoContributor(videoId, contributionResource)

Adds a contributor to a video

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long videoId = 789L; // Long | The video id
ContributionResource contributionResource = new ContributionResource(); // ContributionResource | The contribution object
try {
    apiInstance.addVideoContributor(videoId, contributionResource);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#addVideoContributor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **videoId** | **Long**| The video id |
 **contributionResource** | [**ContributionResource**](ContributionResource.md)| The contribution object | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addVideoFlag"></a>
# **addVideoFlag**
> FlagResource addVideoFlag(videoId, reason)

Add a new flag

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long videoId = 789L; // Long | The video id
String reason = "reason_example"; // String | The flag reason
try {
    FlagResource result = apiInstance.addVideoFlag(videoId, reason);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#addVideoFlag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **videoId** | **Long**| The video id |
 **reason** | **String**| The flag reason | [optional]

### Return type

[**FlagResource**](FlagResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addVideoRelationships"></a>
# **addVideoRelationships**
> VideoRelationshipResource addVideoRelationships(videoId, videoRelationshipResource)

Adds one or more existing videos as related to this one

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long videoId = 789L; // Long | The video id
VideoRelationshipResource videoRelationshipResource = new VideoRelationshipResource(); // VideoRelationshipResource | The video relationship object 
try {
    VideoRelationshipResource result = apiInstance.addVideoRelationships(videoId, videoRelationshipResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#addVideoRelationships");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **videoId** | **Long**| The video id |
 **videoRelationshipResource** | [**VideoRelationshipResource**](VideoRelationshipResource.md)| The video relationship object  | [optional]

### Return type

[**VideoRelationshipResource**](VideoRelationshipResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createVideoDisposition"></a>
# **createVideoDisposition**
> DispositionResource createVideoDisposition(videoId, dispositionResource)

Create a video disposition

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Integer videoId = 56; // Integer | The video id
DispositionResource dispositionResource = new DispositionResource(); // DispositionResource | The disposition object
try {
    DispositionResource result = apiInstance.createVideoDisposition(videoId, dispositionResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#createVideoDisposition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **videoId** | **Integer**| The video id |
 **dispositionResource** | [**DispositionResource**](DispositionResource.md)| The disposition object | [optional]

### Return type

[**DispositionResource**](DispositionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteVideo"></a>
# **deleteVideo**
> deleteVideo(id)

Deletes a video from the system if no resources are attached to it

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long id = 789L; // Long | The video id
try {
    apiInstance.deleteVideo(id);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#deleteVideo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The video id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteVideoComment"></a>
# **deleteVideoComment**
> deleteVideoComment(videoId, id)

Delete a video comment

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long videoId = 789L; // Long | The video id
Long id = 789L; // Long | The comment id
try {
    apiInstance.deleteVideoComment(videoId, id);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#deleteVideoComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **videoId** | **Long**| The video id |
 **id** | **Long**| The comment id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteVideoDisposition"></a>
# **deleteVideoDisposition**
> deleteVideoDisposition(dispositionId)

Delete a video disposition

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long dispositionId = 789L; // Long | The disposition id
try {
    apiInstance.deleteVideoDisposition(dispositionId);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#deleteVideoDisposition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dispositionId** | **Long**| The disposition id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteVideoFlag"></a>
# **deleteVideoFlag**
> deleteVideoFlag(videoId)

Delete a flag

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long videoId = 789L; // Long | The video id
try {
    apiInstance.deleteVideoFlag(videoId);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#deleteVideoFlag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **videoId** | **Long**| The video id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteVideoRelationship"></a>
# **deleteVideoRelationship**
> deleteVideoRelationship(videoId, id)

Delete a video&#39;s relationship

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long videoId = 789L; // Long | The video id
Long id = 789L; // Long | The relationship id
try {
    apiInstance.deleteVideoRelationship(videoId, id);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#deleteVideoRelationship");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **videoId** | **Long**| The video id |
 **id** | **Long**| The relationship id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserVideos"></a>
# **getUserVideos**
> PageResourceVideoResource getUserVideos(userId, excludeFlagged, size, page)

Get user videos

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Integer userId = 56; // Integer | The user id
Boolean excludeFlagged = true; // Boolean | Skip videos that have been flagged by the current user
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceVideoResource result = apiInstance.getUserVideos(userId, excludeFlagged, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#getUserVideos");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The user id |
 **excludeFlagged** | **Boolean**| Skip videos that have been flagged by the current user | [optional] [default to true]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceVideoResource**](PageResourceVideoResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getVideo"></a>
# **getVideo**
> VideoResource getVideo(id)

Loads a specific video details

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long id = 789L; // Long | The video id
try {
    VideoResource result = apiInstance.getVideo(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#getVideo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The video id |

### Return type

[**VideoResource**](VideoResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getVideoComments"></a>
# **getVideoComments**
> PageResourceCommentResource getVideoComments(videoId, size, page)

Returns a page of comments for a video

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Integer videoId = 56; // Integer | The video id
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceCommentResource result = apiInstance.getVideoComments(videoId, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#getVideoComments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **videoId** | **Integer**| The video id |
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceCommentResource**](PageResourceCommentResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getVideoDispositions"></a>
# **getVideoDispositions**
> PageResourceDispositionResource getVideoDispositions(videoId, size, page)

Returns a page of dispositions for a video

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Integer videoId = 56; // Integer | The video id
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceDispositionResource result = apiInstance.getVideoDispositions(videoId, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#getVideoDispositions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **videoId** | **Integer**| The video id |
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceDispositionResource**](PageResourceDispositionResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getVideoRelationships"></a>
# **getVideoRelationships**
> PageResourceVideoRelationshipResource getVideoRelationships(videoId, size, page)

Returns a page of video relationships

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long videoId = 789L; // Long | The video id
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceVideoRelationshipResource result = apiInstance.getVideoRelationships(videoId, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#getVideoRelationships");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **videoId** | **Long**| The video id |
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceVideoRelationshipResource**](PageResourceVideoRelationshipResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getVideos"></a>
# **getVideos**
> PageResourceVideoResource getVideos(excludeFlagged, filterVideosByUploader, filterCategory, filterTagset, filterVideosByName, filterVideosByContributor, filterVideosByAuthor, filterHasAuthor, filterHasUploader, filterRelatedTo, filterFriends, filterDisposition, size, page, order)

Search videos using the documented filters

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Boolean excludeFlagged = true; // Boolean | Skip videos that have been flagged by the current user
String filterVideosByUploader = "filterVideosByUploader_example"; // String | Filter for videos by uploader id
String filterCategory = "filterCategory_example"; // String | Filter for videos from a specific category by id
String filterTagset = "filterTagset_example"; // String | Filter for videos with specified tags (separated by comma)
String filterVideosByName = "filterVideosByName_example"; // String | Filter for videos which name *STARTS* with the given string
String filterVideosByContributor = "filterVideosByContributor_example"; // String | Filter for videos with contribution from the artist specified by ID
String filterVideosByAuthor = "filterVideosByAuthor_example"; // String | Filter for videos with an artist as author specified by ID
Boolean filterHasAuthor = true; // Boolean | Filter for videos that have an author set if true, or that have no author if false
Boolean filterHasUploader = true; // Boolean | Filter for videos that have an uploader set if true, or that have no uploader if false
String filterRelatedTo = "filterRelatedTo_example"; // String | Filter for videos that have designated a particular video as the TO of a relationship. Pattern should match VIDEO_ID or VIDEO_ID:DETAILS to match with a specific details string as well
Boolean filterFriends = true; // Boolean | Filter for videos uploaded by friends. 'true' for friends of the caller (requires user token) or a user id for a specific user's friends (requires VIDEOS_ADMIN permission)
String filterDisposition = "filterDisposition_example"; // String | Filter for videos a given user has a given disposition towards. USER_ID:DISPOSITION where USER_ID is the id of the user who has this disposition or 'me' for the caller (requires user token for 'me') and DISPOSITION is the name of the disposition. E.G. filter_disposition=123:like or filter_disposition=me:favorite
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "author:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceVideoResource result = apiInstance.getVideos(excludeFlagged, filterVideosByUploader, filterCategory, filterTagset, filterVideosByName, filterVideosByContributor, filterVideosByAuthor, filterHasAuthor, filterHasUploader, filterRelatedTo, filterFriends, filterDisposition, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#getVideos");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **excludeFlagged** | **Boolean**| Skip videos that have been flagged by the current user | [optional] [default to true]
 **filterVideosByUploader** | **String**| Filter for videos by uploader id | [optional]
 **filterCategory** | **String**| Filter for videos from a specific category by id | [optional]
 **filterTagset** | **String**| Filter for videos with specified tags (separated by comma) | [optional]
 **filterVideosByName** | **String**| Filter for videos which name *STARTS* with the given string | [optional]
 **filterVideosByContributor** | **String**| Filter for videos with contribution from the artist specified by ID | [optional]
 **filterVideosByAuthor** | **String**| Filter for videos with an artist as author specified by ID | [optional]
 **filterHasAuthor** | **Boolean**| Filter for videos that have an author set if true, or that have no author if false | [optional]
 **filterHasUploader** | **Boolean**| Filter for videos that have an uploader set if true, or that have no uploader if false | [optional]
 **filterRelatedTo** | **String**| Filter for videos that have designated a particular video as the TO of a relationship. Pattern should match VIDEO_ID or VIDEO_ID:DETAILS to match with a specific details string as well | [optional]
 **filterFriends** | **Boolean**| Filter for videos uploaded by friends. &#39;true&#39; for friends of the caller (requires user token) or a user id for a specific user&#39;s friends (requires VIDEOS_ADMIN permission) | [optional]
 **filterDisposition** | **String**| Filter for videos a given user has a given disposition towards. USER_ID:DISPOSITION where USER_ID is the id of the user who has this disposition or &#39;me&#39; for the caller (requires user token for &#39;me&#39;) and DISPOSITION is the name of the disposition. E.G. filter_disposition&#x3D;123:like or filter_disposition&#x3D;me:favorite | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to author:ASC]

### Return type

[**PageResourceVideoResource**](PageResourceVideoResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeUserFromVideoWhitelist"></a>
# **removeUserFromVideoWhitelist**
> removeUserFromVideoWhitelist(videoId, id)

Removes a user from a video&#39;s whitelist

Remove the user with the id given in the path from the whitelist of users that can view this video regardless of privacy setting.

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long videoId = 789L; // Long | The video id
Integer id = 56; // Integer | The user id
try {
    apiInstance.removeUserFromVideoWhitelist(videoId, id);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#removeUserFromVideoWhitelist");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **videoId** | **Long**| The video id |
 **id** | **Integer**| The user id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeVideoContributor"></a>
# **removeVideoContributor**
> removeVideoContributor(videoId, id)

Removes a contributor from a video

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long videoId = 789L; // Long | The video id
Integer id = 56; // Integer | The contributor id
try {
    apiInstance.removeVideoContributor(videoId, id);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#removeVideoContributor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **videoId** | **Long**| The video id |
 **id** | **Integer**| The contributor id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateVideo"></a>
# **updateVideo**
> updateVideo(id, videoResource)

Modifies a video&#39;s details

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long id = 789L; // Long | The video id
VideoResource videoResource = new VideoResource(); // VideoResource | The video object
try {
    apiInstance.updateVideo(id, videoResource);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#updateVideo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The video id |
 **videoResource** | [**VideoResource**](VideoResource.md)| The video object | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateVideoComment"></a>
# **updateVideoComment**
> updateVideoComment(videoId, id, content)

Update a video comment

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long videoId = 789L; // Long | The video id
Long id = 789L; // Long | The comment id
String content = "content_example"; // String | The comment content
try {
    apiInstance.updateVideoComment(videoId, id, content);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#updateVideoComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **videoId** | **Long**| The video id |
 **id** | **Long**| The comment id |
 **content** | **String**| The comment content | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateVideoRelationship"></a>
# **updateVideoRelationship**
> updateVideoRelationship(videoId, relationshipId, details)

Update a video&#39;s relationship details

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long videoId = 789L; // Long | The video id
Long relationshipId = 789L; // Long | The relationship id
String details = "details_example"; // String | The video relationship details
try {
    apiInstance.updateVideoRelationship(videoId, relationshipId, details);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#updateVideoRelationship");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **videoId** | **Long**| The video id |
 **relationshipId** | **Long**| The relationship id |
 **details** | **String**| The video relationship details | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="viewVideo"></a>
# **viewVideo**
> viewVideo(id)

Increment a video&#39;s view count

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaVideosApi;

MediaVideosApi apiInstance = new MediaVideosApi();
Long id = 789L; // Long | The video id
try {
    apiInstance.viewVideo(id);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaVideosApi#viewVideo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The video id |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

