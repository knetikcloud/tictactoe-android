# BRERuleEngineCategoriesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createBRECategoryTemplate**](BRERuleEngineCategoriesApi.md#createBRECategoryTemplate) | **POST** /bre/categories/templates | Create a BRE category template
[**deleteBRECategoryTemplate**](BRERuleEngineCategoriesApi.md#deleteBRECategoryTemplate) | **DELETE** /bre/categories/templates/{id} | Delete a BRE category template
[**getBRECategories**](BRERuleEngineCategoriesApi.md#getBRECategories) | **GET** /bre/categories | List categories
[**getBRECategory**](BRERuleEngineCategoriesApi.md#getBRECategory) | **GET** /bre/categories/{name} | Get a single category
[**getBRECategoryTemplate**](BRERuleEngineCategoriesApi.md#getBRECategoryTemplate) | **GET** /bre/categories/templates/{id} | Get a single BRE category template
[**getBRECategoryTemplates**](BRERuleEngineCategoriesApi.md#getBRECategoryTemplates) | **GET** /bre/categories/templates | List and search BRE category templates
[**updateBRECategory**](BRERuleEngineCategoriesApi.md#updateBRECategory) | **PUT** /bre/categories/{name} | Update a category
[**updateBRECategoryTemplate**](BRERuleEngineCategoriesApi.md#updateBRECategoryTemplate) | **PUT** /bre/categories/templates/{id} | Update a BRE category template


<a name="createBRECategoryTemplate"></a>
# **createBRECategoryTemplate**
> TemplateResource createBRECategoryTemplate(template)

Create a BRE category template

Templates define a type of BRE category and the properties they have

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineCategoriesApi;

BRERuleEngineCategoriesApi apiInstance = new BRERuleEngineCategoriesApi();
TemplateResource template = new TemplateResource(); // TemplateResource | The category template to create
try {
    TemplateResource result = apiInstance.createBRECategoryTemplate(template);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineCategoriesApi#createBRECategoryTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **template** | [**TemplateResource**](TemplateResource.md)| The category template to create | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteBRECategoryTemplate"></a>
# **deleteBRECategoryTemplate**
> deleteBRECategoryTemplate(id, cascade)

Delete a BRE category template

If cascade &#x3D; &#39;detach&#39;, it will force delete the template even if it&#39;s attached to other objects

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineCategoriesApi;

BRERuleEngineCategoriesApi apiInstance = new BRERuleEngineCategoriesApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | The value needed to delete used templates
try {
    apiInstance.deleteBRECategoryTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineCategoriesApi#deleteBRECategoryTemplate");
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

<a name="getBRECategories"></a>
# **getBRECategories**
> PageResourceBreCategoryResource getBRECategories(size, page)

List categories

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineCategoriesApi;

BRERuleEngineCategoriesApi apiInstance = new BRERuleEngineCategoriesApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceBreCategoryResource result = apiInstance.getBRECategories(size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineCategoriesApi#getBRECategories");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceBreCategoryResource**](PageResourceBreCategoryResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getBRECategory"></a>
# **getBRECategory**
> BreCategoryResource getBRECategory(name)

Get a single category

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineCategoriesApi;

BRERuleEngineCategoriesApi apiInstance = new BRERuleEngineCategoriesApi();
String name = "name_example"; // String | The category name
try {
    BreCategoryResource result = apiInstance.getBRECategory(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineCategoriesApi#getBRECategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The category name |

### Return type

[**BreCategoryResource**](BreCategoryResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getBRECategoryTemplate"></a>
# **getBRECategoryTemplate**
> TemplateResource getBRECategoryTemplate(id)

Get a single BRE category template

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineCategoriesApi;

BRERuleEngineCategoriesApi apiInstance = new BRERuleEngineCategoriesApi();
String id = "id_example"; // String | The id of the template
try {
    TemplateResource result = apiInstance.getBRECategoryTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineCategoriesApi#getBRECategoryTemplate");
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

<a name="getBRECategoryTemplates"></a>
# **getBRECategoryTemplates**
> PageResourceTemplateResource getBRECategoryTemplates(size, page, order)

List and search BRE category templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineCategoriesApi;

BRERuleEngineCategoriesApi apiInstance = new BRERuleEngineCategoriesApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceTemplateResource result = apiInstance.getBRECategoryTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineCategoriesApi#getBRECategoryTemplates");
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

<a name="updateBRECategory"></a>
# **updateBRECategory**
> BreCategoryResource updateBRECategory(name, category)

Update a category

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineCategoriesApi;

BRERuleEngineCategoriesApi apiInstance = new BRERuleEngineCategoriesApi();
String name = "name_example"; // String | The category name
BreCategoryResource category = new BreCategoryResource(); // BreCategoryResource | The updated BRE category information
try {
    BreCategoryResource result = apiInstance.updateBRECategory(name, category);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineCategoriesApi#updateBRECategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The category name |
 **category** | [**BreCategoryResource**](BreCategoryResource.md)| The updated BRE category information | [optional]

### Return type

[**BreCategoryResource**](BreCategoryResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateBRECategoryTemplate"></a>
# **updateBRECategoryTemplate**
> TemplateResource updateBRECategoryTemplate(id, template)

Update a BRE category template

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineCategoriesApi;

BRERuleEngineCategoriesApi apiInstance = new BRERuleEngineCategoriesApi();
String id = "id_example"; // String | The id of the template
TemplateResource template = new TemplateResource(); // TemplateResource | The updated category template definition
try {
    TemplateResource result = apiInstance.updateBRECategoryTemplate(id, template);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineCategoriesApi#updateBRECategoryTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **template** | [**TemplateResource**](TemplateResource.md)| The updated category template definition | [optional]

### Return type

[**TemplateResource**](TemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

