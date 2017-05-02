# SearchApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addSearchIndex**](SearchApi.md#addSearchIndex) | **POST** /search/index/{type}/{id} | Add a new object to an index
[**addSearchMappings**](SearchApi.md#addSearchMappings) | **POST** /search/mappings | Register reference mappings
[**deleteSearchIndex**](SearchApi.md#deleteSearchIndex) | **DELETE** /search/index/{type}/{id} | Delete an object
[**deleteSearchIndexes**](SearchApi.md#deleteSearchIndexes) | **DELETE** /search/index/{type} | Delete all objects in an index
[**searchIndex**](SearchApi.md#searchIndex) | **POST** /search/index/{type} | Search an index


<a name="addSearchIndex"></a>
# **addSearchIndex**
> addSearchIndex(type, id, _object)

Add a new object to an index

Mainly intended for internal use.

### Example
```java
// Import classes:
//import com.knetikcloud.api.SearchApi;

SearchApi apiInstance = new SearchApi();
String type = "type_example"; // String | The index type
String id = "id_example"; // String | The ID of the object
Object _object = null; // Object | The object to add
try {
    apiInstance.addSearchIndex(type, id, _object);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#addSearchIndex");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **String**| The index type |
 **id** | **String**| The ID of the object |
 **_object** | **Object**| The object to add | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addSearchMappings"></a>
# **addSearchMappings**
> addSearchMappings(mappings)

Register reference mappings

Add a new type mapping to connect data from one index to another, or discover an exsting one. Mainly intended for internal use.

### Example
```java
// Import classes:
//import com.knetikcloud.api.SearchApi;

SearchApi apiInstance = new SearchApi();
List<SearchReferenceMapping> mappings = Arrays.asList(new SearchReferenceMapping()); // List<SearchReferenceMapping> | The mappings to add
try {
    apiInstance.addSearchMappings(mappings);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#addSearchMappings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mappings** | [**List&lt;SearchReferenceMapping&gt;**](SearchReferenceMapping.md)| The mappings to add | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteSearchIndex"></a>
# **deleteSearchIndex**
> deleteSearchIndex(type, id)

Delete an object

Mainly intended for internal use. Requires SEARCH_ADMIN.

### Example
```java
// Import classes:
//import com.knetikcloud.api.SearchApi;

SearchApi apiInstance = new SearchApi();
String type = "type_example"; // String | The index type
String id = "id_example"; // String | The ID of the object to delete
try {
    apiInstance.deleteSearchIndex(type, id);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#deleteSearchIndex");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **String**| The index type |
 **id** | **String**| The ID of the object to delete |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteSearchIndexes"></a>
# **deleteSearchIndexes**
> deleteSearchIndexes(type)

Delete all objects in an index

Mainly intended for internal use

### Example
```java
// Import classes:
//import com.knetikcloud.api.SearchApi;

SearchApi apiInstance = new SearchApi();
String type = "type_example"; // String | The index type
try {
    apiInstance.deleteSearchIndexes(type);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#deleteSearchIndexes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **String**| The index type |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="searchIndex"></a>
# **searchIndex**
> PageResourceMapstringobject searchIndex(type, query, size, page)

Search an index

The body is an ElasticSearch query in JSON format. Please see their &lt;a href&#x3D;&#39;https://www.elastic.co/guide/en/elasticsearch/reference/current/query-dsl.html&#39;&gt;documentation&lt;/a&gt; for details on the format and search options. The searchable object&#39;s format depends on on the type. See individual search endpoints on other resources for details on their format.

### Example
```java
// Import classes:
//import com.knetikcloud.api.SearchApi;

SearchApi apiInstance = new SearchApi();
String type = "type_example"; // String | The index type
Object query = null; // Object | The query to be used for the search
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceMapstringobject result = apiInstance.searchIndex(type, query, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#searchIndex");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **String**| The index type |
 **query** | **Object**| The query to be used for the search | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceMapstringobject**](PageResourceMapstringobject.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

