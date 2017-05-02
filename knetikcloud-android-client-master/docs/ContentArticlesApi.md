# ContentArticlesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createArticle**](ContentArticlesApi.md#createArticle) | **POST** /content/articles | Create a new article
[**createArticleTemplate**](ContentArticlesApi.md#createArticleTemplate) | **POST** /content/articles/templates | Create an article template
[**deleteArticle**](ContentArticlesApi.md#deleteArticle) | **DELETE** /content/articles/{id} | Delete an existing article
[**deleteArticleTemplate**](ContentArticlesApi.md#deleteArticleTemplate) | **DELETE** /content/articles/templates/{id} | Delete an article template
[**getArticle**](ContentArticlesApi.md#getArticle) | **GET** /content/articles/{id} | Get a single article
[**getArticleTemplate**](ContentArticlesApi.md#getArticleTemplate) | **GET** /content/articles/templates/{id} | Get a single article template
[**getArticleTemplates**](ContentArticlesApi.md#getArticleTemplates) | **GET** /content/articles/templates | List and search article templates
[**getArticles**](ContentArticlesApi.md#getArticles) | **GET** /content/articles | List and search articles
[**updateArticle**](ContentArticlesApi.md#updateArticle) | **PUT** /content/articles/{id} | Update an existing article
[**updateArticleTemplate**](ContentArticlesApi.md#updateArticleTemplate) | **PUT** /content/articles/templates/{id} | Update an article template


<a name="createArticle"></a>
# **createArticle**
> ArticleResource createArticle(articleResource)

Create a new article

Articles are blobs of text with titles, a category and assets. Formatting and display of the text is in the hands of the front end.

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentArticlesApi;

ContentArticlesApi apiInstance = new ContentArticlesApi();
ArticleResource articleResource = new ArticleResource(); // ArticleResource | The new article
try {
    ArticleResource result = apiInstance.createArticle(articleResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentArticlesApi#createArticle");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **articleResource** | [**ArticleResource**](ArticleResource.md)| The new article | [optional]

### Return type

[**ArticleResource**](ArticleResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createArticleTemplate"></a>
# **createArticleTemplate**
> TemplateResource createArticleTemplate(articleTemplateResource)

Create an article template

Article Templates define a type of article and the properties they have

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentArticlesApi;

ContentArticlesApi apiInstance = new ContentArticlesApi();
TemplateResource articleTemplateResource = new TemplateResource(); // TemplateResource | The article template resource object
try {
    TemplateResource result = apiInstance.createArticleTemplate(articleTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentArticlesApi#createArticleTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **articleTemplateResource** | [**TemplateResource**](TemplateResource.md)| The article template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteArticle"></a>
# **deleteArticle**
> deleteArticle(id)

Delete an existing article

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentArticlesApi;

ContentArticlesApi apiInstance = new ContentArticlesApi();
String id = "id_example"; // String | The article id
try {
    apiInstance.deleteArticle(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentArticlesApi#deleteArticle");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The article id |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteArticleTemplate"></a>
# **deleteArticleTemplate**
> deleteArticleTemplate(id, cascade)

Delete an article template

If cascade &#x3D; &#39;detach&#39;, it will force delete the template even if it&#39;s attached to other objects

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentArticlesApi;

ContentArticlesApi apiInstance = new ContentArticlesApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | The value needed to delete used templates
try {
    apiInstance.deleteArticleTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentArticlesApi#deleteArticleTemplate");
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

<a name="getArticle"></a>
# **getArticle**
> ArticleResource getArticle(id)

Get a single article

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentArticlesApi;

ContentArticlesApi apiInstance = new ContentArticlesApi();
String id = "id_example"; // String | The article id
try {
    ArticleResource result = apiInstance.getArticle(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentArticlesApi#getArticle");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The article id |

### Return type

[**ArticleResource**](ArticleResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getArticleTemplate"></a>
# **getArticleTemplate**
> TemplateResource getArticleTemplate(id)

Get a single article template

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentArticlesApi;

ContentArticlesApi apiInstance = new ContentArticlesApi();
String id = "id_example"; // String | The id of the template
try {
    TemplateResource result = apiInstance.getArticleTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentArticlesApi#getArticleTemplate");
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

<a name="getArticleTemplates"></a>
# **getArticleTemplates**
> PageResourceTemplateResource getArticleTemplates(size, page, order)

List and search article templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentArticlesApi;

ContentArticlesApi apiInstance = new ContentArticlesApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceTemplateResource result = apiInstance.getArticleTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentArticlesApi#getArticleTemplates");
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

<a name="getArticles"></a>
# **getArticles**
> PageResourceArticleResource getArticles(filterCategory, filterTagset, filterTitle, size, page, order)

List and search articles

Get a list of articles with optional filtering. Assets will not be filled in on the resources returned. Use &#39;Get a single article&#39; to retrieve the full resource with assets for a given item as needed.

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentArticlesApi;

ContentArticlesApi apiInstance = new ContentArticlesApi();
String filterCategory = "filterCategory_example"; // String | Filter for articles from a specific category by id
String filterTagset = "filterTagset_example"; // String | Filter for articles with specified tags (separated by comma)
String filterTitle = "filterTitle_example"; // String | Filter for articles whose title contains a string
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceArticleResource result = apiInstance.getArticles(filterCategory, filterTagset, filterTitle, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentArticlesApi#getArticles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterCategory** | **String**| Filter for articles from a specific category by id | [optional]
 **filterTagset** | **String**| Filter for articles with specified tags (separated by comma) | [optional]
 **filterTitle** | **String**| Filter for articles whose title contains a string | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceArticleResource**](PageResourceArticleResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateArticle"></a>
# **updateArticle**
> ArticleResource updateArticle(id, articleResource)

Update an existing article

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentArticlesApi;

ContentArticlesApi apiInstance = new ContentArticlesApi();
String id = "id_example"; // String | The article id
ArticleResource articleResource = new ArticleResource(); // ArticleResource | The article object
try {
    ArticleResource result = apiInstance.updateArticle(id, articleResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentArticlesApi#updateArticle");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The article id |
 **articleResource** | [**ArticleResource**](ArticleResource.md)| The article object | [optional]

### Return type

[**ArticleResource**](ArticleResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateArticleTemplate"></a>
# **updateArticleTemplate**
> TemplateResource updateArticleTemplate(id, articleTemplateResource)

Update an article template

### Example
```java
// Import classes:
//import com.knetikcloud.api.ContentArticlesApi;

ContentArticlesApi apiInstance = new ContentArticlesApi();
String id = "id_example"; // String | The id of the template
TemplateResource articleTemplateResource = new TemplateResource(); // TemplateResource | The article template resource object
try {
    TemplateResource result = apiInstance.updateArticleTemplate(id, articleTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentArticlesApi#updateArticleTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **articleTemplateResource** | [**TemplateResource**](TemplateResource.md)| The article template resource object | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

