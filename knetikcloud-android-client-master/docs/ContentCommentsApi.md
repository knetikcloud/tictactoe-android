# ContentCommentsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addComment**](ContentCommentsApi.md#addComment) | **POST** /comments | Add a new comment
[**deleteComment**](ContentCommentsApi.md#deleteComment) | **DELETE** /comments/{id} | Delete a comment
[**getComment**](ContentCommentsApi.md#getComment) | **GET** /comments/{id} | Return a comment
[**getComments**](ContentCommentsApi.md#getComments) | **GET** /comments | Returns a page of comments
[**searchComments**](ContentCommentsApi.md#searchComments) | **POST** /comments/search | Search the comment index
[**updateComment**](ContentCommentsApi.md#updateComment) | **PUT** /comments/{id}/content | Update a comment


<a name="addComment"></a>
# **addComment**
> CommentResource addComment(commentResource)

Add a new comment

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentCommentsApi;

ContentCommentsApi apiInstance = new ContentCommentsApi();
CommentResource commentResource = new CommentResource(); // CommentResource | The comment to be added
try {
    CommentResource result = apiInstance.addComment(commentResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentCommentsApi#addComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **commentResource** | [**CommentResource**](CommentResource.md)| The comment to be added | [optional]

### Return type

[**CommentResource**](CommentResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteComment"></a>
# **deleteComment**
> deleteComment(id)

Delete a comment

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentCommentsApi;

ContentCommentsApi apiInstance = new ContentCommentsApi();
Long id = 789L; // Long | The comment id
try {
    apiInstance.deleteComment(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentCommentsApi#deleteComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The comment id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getComment"></a>
# **getComment**
> CommentResource getComment(id)

Return a comment

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentCommentsApi;

ContentCommentsApi apiInstance = new ContentCommentsApi();
Long id = 789L; // Long | The comment id
try {
    CommentResource result = apiInstance.getComment(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentCommentsApi#getComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The comment id |

### Return type

[**CommentResource**](CommentResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getComments"></a>
# **getComments**
> PageResourceCommentResource getComments(context, contextId, size, page)

Returns a page of comments

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentCommentsApi;

ContentCommentsApi apiInstance = new ContentCommentsApi();
String context = "context_example"; // String | Get comments by context type
Integer contextId = 56; // Integer | Get comments by context id
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceCommentResource result = apiInstance.getComments(context, contextId, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentCommentsApi#getComments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **context** | **String**| Get comments by context type |
 **contextId** | **Integer**| Get comments by context id |
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceCommentResource**](PageResourceCommentResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="searchComments"></a>
# **searchComments**
> CommentSearch searchComments(query, size, page)

Search the comment index

The body is an ElasticSearch query json. Please see their &lt;a href&#x3D;&#39;https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html&#39;&gt;documentation&lt;/a&gt; for details on the format and search options

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentCommentsApi;

ContentCommentsApi apiInstance = new ContentCommentsApi();
Object query = null; // Object | The search query
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    CommentSearch result = apiInstance.searchComments(query, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentCommentsApi#searchComments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **query** | **Object**| The search query | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**CommentSearch**](CommentSearch.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateComment"></a>
# **updateComment**
> updateComment(id, content)

Update a comment

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentCommentsApi;

ContentCommentsApi apiInstance = new ContentCommentsApi();
Long id = 789L; // Long | The comment id
String content = "content_example"; // String | The comment content
try {
    apiInstance.updateComment(id, content);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentCommentsApi#updateComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The comment id |
 **content** | **String**| The comment content | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

