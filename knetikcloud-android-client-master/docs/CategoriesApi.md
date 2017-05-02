# CategoriesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCategory**](CategoriesApi.md#createCategory) | **POST** /categories | Create a new category
[**createCategoryTemplate**](CategoriesApi.md#createCategoryTemplate) | **POST** /categories/templates | Create a category template
[**deleteCategory**](CategoriesApi.md#deleteCategory) | **DELETE** /categories/{id} | Delete an existing category
[**deleteCategoryTemplate**](CategoriesApi.md#deleteCategoryTemplate) | **DELETE** /categories/templates/{id} | Delete a category template
[**getCategories**](CategoriesApi.md#getCategories) | **GET** /categories | List and search categories with optional filters
[**getCategory**](CategoriesApi.md#getCategory) | **GET** /categories/{id} | Get a single category
[**getCategoryTemplate**](CategoriesApi.md#getCategoryTemplate) | **GET** /categories/templates/{id} | Get a single category template
[**getCategoryTemplates**](CategoriesApi.md#getCategoryTemplates) | **GET** /categories/templates | List and search category templates
[**getTags**](CategoriesApi.md#getTags) | **GET** /tags | List all trivia tags in the system
[**updateCategory**](CategoriesApi.md#updateCategory) | **PUT** /categories/{id} | Update an existing category
[**updateCategoryTemplate**](CategoriesApi.md#updateCategoryTemplate) | **PUT** /categories/templates/{id} | Update a category template


<a name="createCategory"></a>
# **createCategory**
> CategoryResource createCategory(category)

Create a new category

### Example
```java
// Import classes:
//import com.knetikcloud.api.CategoriesApi;

CategoriesApi apiInstance = new CategoriesApi();
CategoryResource category = new CategoryResource(); // CategoryResource | The category to create
try {
    CategoryResource result = apiInstance.createCategory(category);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CategoriesApi#createCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | [**CategoryResource**](CategoryResource.md)| The category to create | [optional]

### Return type

[**CategoryResource**](CategoryResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createCategoryTemplate"></a>
# **createCategoryTemplate**
> TemplateResource createCategoryTemplate(template)

Create a category template

Templates define a type of category and the properties they have

### Example
```java
// Import classes:
//import com.knetikcloud.api.CategoriesApi;

CategoriesApi apiInstance = new CategoriesApi();
TemplateResource template = new TemplateResource(); // TemplateResource | The template to create
try {
    TemplateResource result = apiInstance.createCategoryTemplate(template);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CategoriesApi#createCategoryTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **template** | [**TemplateResource**](TemplateResource.md)| The template to create | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteCategory"></a>
# **deleteCategory**
> deleteCategory(id)

Delete an existing category

### Example
```java
// Import classes:
//import com.knetikcloud.api.CategoriesApi;

CategoriesApi apiInstance = new CategoriesApi();
String id = "id_example"; // String | The id of the category to be deleted
try {
    apiInstance.deleteCategory(id);
} catch (ApiException e) {
    System.err.println("Exception when calling CategoriesApi#deleteCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the category to be deleted |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteCategoryTemplate"></a>
# **deleteCategoryTemplate**
> deleteCategoryTemplate(id, cascade)

Delete a category template

If cascade &#x3D; &#39;detach&#39;, it will force delete the template even if it&#39;s attached to other objects

### Example
```java
// Import classes:
//import com.knetikcloud.api.CategoriesApi;

CategoriesApi apiInstance = new CategoriesApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | The value needed to delete used templates
try {
    apiInstance.deleteCategoryTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling CategoriesApi#deleteCategoryTemplate");
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

<a name="getCategories"></a>
# **getCategories**
> PageResourceCategoryResource getCategories(filterSearch, filterActive, size, page, order)

List and search categories with optional filters

### Example
```java
// Import classes:
//import com.knetikcloud.api.CategoriesApi;

CategoriesApi apiInstance = new CategoriesApi();
String filterSearch = "filterSearch_example"; // String | Filter for categories whose names begin with provided string
Boolean filterActive = true; // Boolean | Filter for categories that are specifically active or inactive
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceCategoryResource result = apiInstance.getCategories(filterSearch, filterActive, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CategoriesApi#getCategories");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterSearch** | **String**| Filter for categories whose names begin with provided string | [optional]
 **filterActive** | **Boolean**| Filter for categories that are specifically active or inactive | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceCategoryResource**](PageResourceCategoryResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCategory"></a>
# **getCategory**
> CategoryResource getCategory(id)

Get a single category

### Example
```java
// Import classes:
//import com.knetikcloud.api.CategoriesApi;

CategoriesApi apiInstance = new CategoriesApi();
String id = "id_example"; // String | The id of the category to retrieve
try {
    CategoryResource result = apiInstance.getCategory(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CategoriesApi#getCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the category to retrieve |

### Return type

[**CategoryResource**](CategoryResource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCategoryTemplate"></a>
# **getCategoryTemplate**
> TemplateResource getCategoryTemplate(id)

Get a single category template

### Example
```java
// Import classes:
//import com.knetikcloud.api.CategoriesApi;

CategoriesApi apiInstance = new CategoriesApi();
String id = "id_example"; // String | The id of the template
try {
    TemplateResource result = apiInstance.getCategoryTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CategoriesApi#getCategoryTemplate");
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

<a name="getCategoryTemplates"></a>
# **getCategoryTemplates**
> PageResourceTemplateResource getCategoryTemplates(size, page, order)

List and search category templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.CategoriesApi;

CategoriesApi apiInstance = new CategoriesApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceTemplateResource result = apiInstance.getCategoryTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CategoriesApi#getCategoryTemplates");
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

<a name="getTags"></a>
# **getTags**
> PageResourcestring getTags(size, page)

List all trivia tags in the system

### Example
```java
// Import classes:
//import com.knetikcloud.api.CategoriesApi;

CategoriesApi apiInstance = new CategoriesApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourcestring result = apiInstance.getTags(size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CategoriesApi#getTags");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourcestring**](PageResourcestring.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateCategory"></a>
# **updateCategory**
> CategoryResource updateCategory(id, category)

Update an existing category

### Example
```java
// Import classes:
//import com.knetikcloud.api.CategoriesApi;

CategoriesApi apiInstance = new CategoriesApi();
String id = "id_example"; // String | The id of the category
CategoryResource category = new CategoryResource(); // CategoryResource | The category to update
try {
    CategoryResource result = apiInstance.updateCategory(id, category);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CategoriesApi#updateCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the category |
 **category** | [**CategoryResource**](CategoryResource.md)| The category to update | [optional]

### Return type

[**CategoryResource**](CategoryResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateCategoryTemplate"></a>
# **updateCategoryTemplate**
> TemplateResource updateCategoryTemplate(id, template)

Update a category template

### Example
```java
// Import classes:
//import com.knetikcloud.api.CategoriesApi;

CategoriesApi apiInstance = new CategoriesApi();
String id = "id_example"; // String | The id of the template
TemplateResource template = new TemplateResource(); // TemplateResource | The updated template information
try {
    TemplateResource result = apiInstance.updateCategoryTemplate(id, template);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CategoriesApi#updateCategoryTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **template** | [**TemplateResource**](TemplateResource.md)| The updated template information | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

