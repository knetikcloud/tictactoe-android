# StoreCouponsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCouponItem**](StoreCouponsApi.md#createCouponItem) | **POST** /store/coupons | Create a coupon item
[**createCouponTemplate**](StoreCouponsApi.md#createCouponTemplate) | **POST** /store/coupons/templates | Create a coupon template
[**deleteCouponItem**](StoreCouponsApi.md#deleteCouponItem) | **DELETE** /store/coupons/{id} | Delete a coupon item
[**deleteCouponTemplate**](StoreCouponsApi.md#deleteCouponTemplate) | **DELETE** /store/coupons/templates/{id} | Delete a coupon template
[**getCouponItem**](StoreCouponsApi.md#getCouponItem) | **GET** /store/coupons/{id} | Get a single coupon item
[**getCouponTemplate**](StoreCouponsApi.md#getCouponTemplate) | **GET** /store/coupons/templates/{id} | Get a single coupon template
[**getCouponTemplates**](StoreCouponsApi.md#getCouponTemplates) | **GET** /store/coupons/templates | List and search coupon templates
[**updateCouponItem**](StoreCouponsApi.md#updateCouponItem) | **PUT** /store/coupons/{id} | Update a coupon item
[**updateCouponTemplate**](StoreCouponsApi.md#updateCouponTemplate) | **PUT** /store/coupons/templates/{id} | Update a coupon template


<a name="createCouponItem"></a>
# **createCouponItem**
> CouponItem createCouponItem(cascade, couponItem)

Create a coupon item

SKUs have to be unique in the entire store.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreCouponsApi;

StoreCouponsApi apiInstance = new StoreCouponsApi();
Boolean cascade = false; // Boolean | Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values.
CouponItem couponItem = new CouponItem(); // CouponItem | The coupon item object
try {
    CouponItem result = apiInstance.createCouponItem(cascade, couponItem);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreCouponsApi#createCouponItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cascade** | **Boolean**| Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values. | [optional] [default to false]
 **couponItem** | [**CouponItem**](CouponItem.md)| The coupon item object | [optional]

### Return type

[**CouponItem**](CouponItem.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createCouponTemplate"></a>
# **createCouponTemplate**
> ItemTemplateResource createCouponTemplate(couponTemplateResource)

Create a coupon template

Coupon Templates define a type of coupon and the properties they have.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreCouponsApi;

StoreCouponsApi apiInstance = new StoreCouponsApi();
ItemTemplateResource couponTemplateResource = new ItemTemplateResource(); // ItemTemplateResource | The new coupon template
try {
    ItemTemplateResource result = apiInstance.createCouponTemplate(couponTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreCouponsApi#createCouponTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **couponTemplateResource** | [**ItemTemplateResource**](ItemTemplateResource.md)| The new coupon template | [optional]

### Return type

[**ItemTemplateResource**](ItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteCouponItem"></a>
# **deleteCouponItem**
> deleteCouponItem(id)

Delete a coupon item

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreCouponsApi;

StoreCouponsApi apiInstance = new StoreCouponsApi();
Integer id = 56; // Integer | The id of the coupon
try {
    apiInstance.deleteCouponItem(id);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreCouponsApi#deleteCouponItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the coupon |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteCouponTemplate"></a>
# **deleteCouponTemplate**
> deleteCouponTemplate(id, cascade)

Delete a coupon template

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreCouponsApi;

StoreCouponsApi apiInstance = new StoreCouponsApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | force deleting the template if it's attached to other objects, cascade = detach
try {
    apiInstance.deleteCouponTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreCouponsApi#deleteCouponTemplate");
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

<a name="getCouponItem"></a>
# **getCouponItem**
> CouponItem getCouponItem(id)

Get a single coupon item

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreCouponsApi;

StoreCouponsApi apiInstance = new StoreCouponsApi();
Integer id = 56; // Integer | The id of the coupon
try {
    CouponItem result = apiInstance.getCouponItem(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreCouponsApi#getCouponItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the coupon |

### Return type

[**CouponItem**](CouponItem.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCouponTemplate"></a>
# **getCouponTemplate**
> ItemTemplateResource getCouponTemplate(id)

Get a single coupon template

Coupon Templates define a type of coupon and the properties they have.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreCouponsApi;

StoreCouponsApi apiInstance = new StoreCouponsApi();
String id = "id_example"; // String | The id of the template
try {
    ItemTemplateResource result = apiInstance.getCouponTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreCouponsApi#getCouponTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |

### Return type

[**ItemTemplateResource**](ItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCouponTemplates"></a>
# **getCouponTemplates**
> PageResourceItemTemplateResource getCouponTemplates(size, page, order)

List and search coupon templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreCouponsApi;

StoreCouponsApi apiInstance = new StoreCouponsApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceItemTemplateResource result = apiInstance.getCouponTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreCouponsApi#getCouponTemplates");
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

[**PageResourceItemTemplateResource**](PageResourceItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateCouponItem"></a>
# **updateCouponItem**
> CouponItem updateCouponItem(id, cascade, couponItem)

Update a coupon item

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreCouponsApi;

StoreCouponsApi apiInstance = new StoreCouponsApi();
Integer id = 56; // Integer | The id of the coupon
Boolean cascade = false; // Boolean | Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values.
CouponItem couponItem = new CouponItem(); // CouponItem | The coupon item object
try {
    CouponItem result = apiInstance.updateCouponItem(id, cascade, couponItem);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreCouponsApi#updateCouponItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the coupon |
 **cascade** | **Boolean**| Whether to cascade group changes, such as in the limited gettable behavior. A 400 error will return otherwise if the group is already in use with different values. | [optional] [default to false]
 **couponItem** | [**CouponItem**](CouponItem.md)| The coupon item object | [optional]

### Return type

[**CouponItem**](CouponItem.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateCouponTemplate"></a>
# **updateCouponTemplate**
> ItemTemplateResource updateCouponTemplate(id, couponTemplateResource)

Update a coupon template

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreCouponsApi;

StoreCouponsApi apiInstance = new StoreCouponsApi();
String id = "id_example"; // String | The id of the template
ItemTemplateResource couponTemplateResource = new ItemTemplateResource(); // ItemTemplateResource | The coupon template resource object
try {
    ItemTemplateResource result = apiInstance.updateCouponTemplate(id, couponTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreCouponsApi#updateCouponTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **couponTemplateResource** | [**ItemTemplateResource**](ItemTemplateResource.md)| The coupon template resource object | [optional]

### Return type

[**ItemTemplateResource**](ItemTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

