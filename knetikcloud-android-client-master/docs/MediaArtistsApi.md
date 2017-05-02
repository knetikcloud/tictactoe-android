# MediaArtistsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addArtist**](MediaArtistsApi.md#addArtist) | **POST** /media/artists | Adds a new artist in the system
[**createArtistTemplate**](MediaArtistsApi.md#createArtistTemplate) | **POST** /media/artists/templates | Create an artist template
[**deleteArtist**](MediaArtistsApi.md#deleteArtist) | **DELETE** /media/artists/{id} | Removes an artist from the system IF no resources are attached to it
[**deleteArtistTemplate**](MediaArtistsApi.md#deleteArtistTemplate) | **DELETE** /media/artists/templates/{id} | Delete an artist template
[**getArtist**](MediaArtistsApi.md#getArtist) | **GET** /media/artists/{id} | Loads a specific artist details
[**getArtistTemplate**](MediaArtistsApi.md#getArtistTemplate) | **GET** /media/artists/templates/{id} | Get a single artist template
[**getArtistTemplates**](MediaArtistsApi.md#getArtistTemplates) | **GET** /media/artists/templates | List and search artist templates
[**getArtists**](MediaArtistsApi.md#getArtists) | **GET** /media/artists | Search for artists
[**updateArtist**](MediaArtistsApi.md#updateArtist) | **PUT** /media/artists/{id} | Modifies an artist details
[**updateArtistTemplate**](MediaArtistsApi.md#updateArtistTemplate) | **PUT** /media/artists/templates/{id} | Update an artist template


<a name="addArtist"></a>
# **addArtist**
> ArtistResource addArtist(artistResource)

Adds a new artist in the system

Adds a new artist in the system. Use specific media contributions endpoint to add contributions

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaArtistsApi;

MediaArtistsApi apiInstance = new MediaArtistsApi();
ArtistResource artistResource = new ArtistResource(); // ArtistResource | The new artist
try {
    ArtistResource result = apiInstance.addArtist(artistResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaArtistsApi#addArtist");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **artistResource** | [**ArtistResource**](ArtistResource.md)| The new artist | [optional]

### Return type

[**ArtistResource**](ArtistResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createArtistTemplate"></a>
# **createArtistTemplate**
> TemplateResource createArtistTemplate(artistTemplateResource)

Create an artist template

Artist Templates define a type of artist and the properties they have

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaArtistsApi;

MediaArtistsApi apiInstance = new MediaArtistsApi();
TemplateResource artistTemplateResource = new TemplateResource(); // TemplateResource | The artist template resource object
try {
    TemplateResource result = apiInstance.createArtistTemplate(artistTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaArtistsApi#createArtistTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **artistTemplateResource** | [**TemplateResource**](TemplateResource.md)| The artist template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteArtist"></a>
# **deleteArtist**
> deleteArtist(id)

Removes an artist from the system IF no resources are attached to it

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaArtistsApi;

MediaArtistsApi apiInstance = new MediaArtistsApi();
Long id = 789L; // Long | The artist id
try {
    apiInstance.deleteArtist(id);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaArtistsApi#deleteArtist");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The artist id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteArtistTemplate"></a>
# **deleteArtistTemplate**
> deleteArtistTemplate(id, cascade)

Delete an artist template

If cascade &#x3D; &#39;detach&#39;, it will force delete the template even if it&#39;s attached to other objects

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaArtistsApi;

MediaArtistsApi apiInstance = new MediaArtistsApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | The value needed to delete used templates
try {
    apiInstance.deleteArtistTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaArtistsApi#deleteArtistTemplate");
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

<a name="getArtist"></a>
# **getArtist**
> ArtistResource getArtist(id, showContributions)

Loads a specific artist details

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaArtistsApi;

MediaArtistsApi apiInstance = new MediaArtistsApi();
Long id = 789L; // Long | The artist id
Integer showContributions = 56; // Integer | The number of contributions to show fetch
try {
    ArtistResource result = apiInstance.getArtist(id, showContributions);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaArtistsApi#getArtist");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The artist id |
 **showContributions** | **Integer**| The number of contributions to show fetch | [optional]

### Return type

[**ArtistResource**](ArtistResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getArtistTemplate"></a>
# **getArtistTemplate**
> TemplateResource getArtistTemplate(id)

Get a single artist template

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaArtistsApi;

MediaArtistsApi apiInstance = new MediaArtistsApi();
String id = "id_example"; // String | The id of the template
try {
    TemplateResource result = apiInstance.getArtistTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaArtistsApi#getArtistTemplate");
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

<a name="getArtistTemplates"></a>
# **getArtistTemplates**
> PageResourceTemplateResource getArtistTemplates(size, page, order)

List and search artist templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaArtistsApi;

MediaArtistsApi apiInstance = new MediaArtistsApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceTemplateResource result = apiInstance.getArtistTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaArtistsApi#getArtistTemplates");
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

<a name="getArtists"></a>
# **getArtists**
> PageResourceArtistResource getArtists(filterArtistsByName, size, page, order)

Search for artists

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaArtistsApi;

MediaArtistsApi apiInstance = new MediaArtistsApi();
String filterArtistsByName = "filterArtistsByName_example"; // String | Filter for artists which name *STARTS* with the given string
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceArtistResource result = apiInstance.getArtists(filterArtistsByName, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaArtistsApi#getArtists");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterArtistsByName** | **String**| Filter for artists which name *STARTS* with the given string | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceArtistResource**](PageResourceArtistResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateArtist"></a>
# **updateArtist**
> updateArtist(id, artistResource)

Modifies an artist details

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaArtistsApi;

MediaArtistsApi apiInstance = new MediaArtistsApi();
Long id = 789L; // Long | The artist id
ArtistResource artistResource = new ArtistResource(); // ArtistResource | The new artist
try {
    apiInstance.updateArtist(id, artistResource);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaArtistsApi#updateArtist");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The artist id |
 **artistResource** | [**ArtistResource**](ArtistResource.md)| The new artist | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateArtistTemplate"></a>
# **updateArtistTemplate**
> TemplateResource updateArtistTemplate(id, artistTemplateResource)

Update an artist template

### Example
```java
// Import classes:
//import com.knetikcloud.api.MediaArtistsApi;

MediaArtistsApi apiInstance = new MediaArtistsApi();
String id = "id_example"; // String | The id of the template
TemplateResource artistTemplateResource = new TemplateResource(); // TemplateResource | The artist template resource object
try {
    TemplateResource result = apiInstance.updateArtistTemplate(id, artistTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MediaArtistsApi#updateArtistTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **artistTemplateResource** | [**TemplateResource**](TemplateResource.md)| The artist template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

