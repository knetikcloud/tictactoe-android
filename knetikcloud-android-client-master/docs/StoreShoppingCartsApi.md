# StoreShoppingCartsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addCustomDiscount**](StoreShoppingCartsApi.md#addCustomDiscount) | **POST** /carts/{id}/custom-discounts | Adds a custom discount to the cart
[**addDiscountToCart**](StoreShoppingCartsApi.md#addDiscountToCart) | **POST** /carts/{id}/discounts | Adds a discount coupon to the cart
[**addItemToCart**](StoreShoppingCartsApi.md#addItemToCart) | **POST** /carts/{id}/items | Add an item to the cart
[**createCart**](StoreShoppingCartsApi.md#createCart) | **POST** /carts | Create a cart
[**getCart**](StoreShoppingCartsApi.md#getCart) | **GET** /carts/{id} | Returns the cart with the given GUID
[**getCarts**](StoreShoppingCartsApi.md#getCarts) | **GET** /carts | Get a list of carts
[**getShippable**](StoreShoppingCartsApi.md#getShippable) | **GET** /carts/{id}/shippable | Returns whether a cart requires shipping
[**getShippingCountries**](StoreShoppingCartsApi.md#getShippingCountries) | **GET** /carts/{id}/countries | Get the list of available shipping countries per vendor
[**removeDiscountFromCart**](StoreShoppingCartsApi.md#removeDiscountFromCart) | **DELETE** /carts/{id}/discounts/{code} | Removes a discount coupon from the cart
[**setCartCurrency**](StoreShoppingCartsApi.md#setCartCurrency) | **PUT** /carts/{id}/currency | Sets the currency to use for the cart
[**setCartOwner**](StoreShoppingCartsApi.md#setCartOwner) | **PUT** /carts/{id}/owner | Sets the owner of a cart if none is set already
[**updateItemInCart**](StoreShoppingCartsApi.md#updateItemInCart) | **PUT** /carts/{id}/items | Changes the quantity of an item already in the cart
[**updateShippingAddress**](StoreShoppingCartsApi.md#updateShippingAddress) | **PUT** /carts/{id}/shipping-address | Modifies or sets the order shipping address


<a name="addCustomDiscount"></a>
# **addCustomDiscount**
> addCustomDiscount(id, customDiscount)

Adds a custom discount to the cart

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShoppingCartsApi;

StoreShoppingCartsApi apiInstance = new StoreShoppingCartsApi();
String id = "id_example"; // String | The id of the cart
CouponDefinition customDiscount = new CouponDefinition(); // CouponDefinition | The details of the discount to add
try {
    apiInstance.addCustomDiscount(id, customDiscount);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShoppingCartsApi#addCustomDiscount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the cart |
 **customDiscount** | [**CouponDefinition**](CouponDefinition.md)| The details of the discount to add | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addDiscountToCart"></a>
# **addDiscountToCart**
> addDiscountToCart(id, skuRequest)

Adds a discount coupon to the cart

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShoppingCartsApi;

StoreShoppingCartsApi apiInstance = new StoreShoppingCartsApi();
String id = "id_example"; // String | The id of the cart
SkuRequest skuRequest = new SkuRequest(); // SkuRequest | The request of the sku
try {
    apiInstance.addDiscountToCart(id, skuRequest);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShoppingCartsApi#addDiscountToCart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the cart |
 **skuRequest** | [**SkuRequest**](SkuRequest.md)| The request of the sku | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addItemToCart"></a>
# **addItemToCart**
> addItemToCart(id, cartItemRequest)

Add an item to the cart

Currently, carts cannot contain virtual and real currency items at the same time. Furthermore, the API only support a single virtual item at the moment

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShoppingCartsApi;

StoreShoppingCartsApi apiInstance = new StoreShoppingCartsApi();
String id = "id_example"; // String | The id of the cart
CartItemRequest cartItemRequest = new CartItemRequest(); // CartItemRequest | The cart item request object
try {
    apiInstance.addItemToCart(id, cartItemRequest);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShoppingCartsApi#addItemToCart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the cart |
 **cartItemRequest** | [**CartItemRequest**](CartItemRequest.md)| The cart item request object | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createCart"></a>
# **createCart**
> String createCart(owner, currencyCode)

Create a cart

You don&#39;t have to have a user to create a cart but the API requires authentication to checkout

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShoppingCartsApi;

StoreShoppingCartsApi apiInstance = new StoreShoppingCartsApi();
Integer owner = 56; // Integer | Set the owner of a cart. If not specified, defaults to the calling user's id. If specified and is not the calling user's id, SHOPPING_CARTS_ADMIN permission is required
String currencyCode = "currencyCode_example"; // String | Set the currency for the cart, by currency code. May be disallowed by site settings.
try {
    String result = apiInstance.createCart(owner, currencyCode);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShoppingCartsApi#createCart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **owner** | **Integer**| Set the owner of a cart. If not specified, defaults to the calling user&#39;s id. If specified and is not the calling user&#39;s id, SHOPPING_CARTS_ADMIN permission is required | [optional]
 **currencyCode** | **String**| Set the currency for the cart, by currency code. May be disallowed by site settings. | [optional]

### Return type

**String**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCart"></a>
# **getCart**
> Cart getCart(id)

Returns the cart with the given GUID

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShoppingCartsApi;

StoreShoppingCartsApi apiInstance = new StoreShoppingCartsApi();
String id = "id_example"; // String | The id of the cart
try {
    Cart result = apiInstance.getCart(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShoppingCartsApi#getCart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the cart |

### Return type

[**Cart**](Cart.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCarts"></a>
# **getCarts**
> PageResourceCartSummary getCarts(filterOwnerId, size, page, order)

Get a list of carts

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShoppingCartsApi;

StoreShoppingCartsApi apiInstance = new StoreShoppingCartsApi();
Integer filterOwnerId = 56; // Integer | Filter by the id of the owner
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceCartSummary result = apiInstance.getCarts(filterOwnerId, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShoppingCartsApi#getCarts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterOwnerId** | **Integer**| Filter by the id of the owner | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceCartSummary**](PageResourceCartSummary.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getShippable"></a>
# **getShippable**
> CartShippableResponse getShippable(id)

Returns whether a cart requires shipping

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShoppingCartsApi;

StoreShoppingCartsApi apiInstance = new StoreShoppingCartsApi();
String id = "id_example"; // String | The id of the cart
try {
    CartShippableResponse result = apiInstance.getShippable(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShoppingCartsApi#getShippable");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the cart |

### Return type

[**CartShippableResponse**](CartShippableResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getShippingCountries"></a>
# **getShippingCountries**
> SampleCountriesResponse getShippingCountries(id)

Get the list of available shipping countries per vendor

Since a cart can have multiple vendors with different shipping options, the countries are broken down by vendors. Please see notes about the response object as the fields are variable.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShoppingCartsApi;

StoreShoppingCartsApi apiInstance = new StoreShoppingCartsApi();
String id = "id_example"; // String | The id of the cart
try {
    SampleCountriesResponse result = apiInstance.getShippingCountries(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShoppingCartsApi#getShippingCountries");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the cart |

### Return type

[**SampleCountriesResponse**](SampleCountriesResponse.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeDiscountFromCart"></a>
# **removeDiscountFromCart**
> removeDiscountFromCart(id, code)

Removes a discount coupon from the cart

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShoppingCartsApi;

StoreShoppingCartsApi apiInstance = new StoreShoppingCartsApi();
String id = "id_example"; // String | The id of the cart
String code = "code_example"; // String | The SKU code of the coupon to remove
try {
    apiInstance.removeDiscountFromCart(id, code);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShoppingCartsApi#removeDiscountFromCart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the cart |
 **code** | **String**| The SKU code of the coupon to remove |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setCartCurrency"></a>
# **setCartCurrency**
> setCartCurrency(id, currencyCode)

Sets the currency to use for the cart

May be disallowed by site settings.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShoppingCartsApi;

StoreShoppingCartsApi apiInstance = new StoreShoppingCartsApi();
String id = "id_example"; // String | The id of the cart
String currencyCode = "currencyCode_example"; // String | The code of the currency
try {
    apiInstance.setCartCurrency(id, currencyCode);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShoppingCartsApi#setCartCurrency");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the cart |
 **currencyCode** | **String**| The code of the currency | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setCartOwner"></a>
# **setCartOwner**
> setCartOwner(id, userId)

Sets the owner of a cart if none is set already

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShoppingCartsApi;

StoreShoppingCartsApi apiInstance = new StoreShoppingCartsApi();
String id = "id_example"; // String | The id of the cart
Integer userId = 56; // Integer | The id of the user
try {
    apiInstance.setCartOwner(id, userId);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShoppingCartsApi#setCartOwner");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the cart |
 **userId** | **Integer**| The id of the user | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateItemInCart"></a>
# **updateItemInCart**
> updateItemInCart(id, cartItemRequest)

Changes the quantity of an item already in the cart

A quantity of zero will remove the item from the cart altogether.

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShoppingCartsApi;

StoreShoppingCartsApi apiInstance = new StoreShoppingCartsApi();
String id = "id_example"; // String | The id of the cart
CartItemRequest cartItemRequest = new CartItemRequest(); // CartItemRequest | The cart item request object
try {
    apiInstance.updateItemInCart(id, cartItemRequest);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShoppingCartsApi#updateItemInCart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the cart |
 **cartItemRequest** | [**CartItemRequest**](CartItemRequest.md)| The cart item request object | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateShippingAddress"></a>
# **updateShippingAddress**
> updateShippingAddress(id, cartShippingAddressRequest)

Modifies or sets the order shipping address

### Example
```java
// Import classes:
//import com.knetikcloud.api.StoreShoppingCartsApi;

StoreShoppingCartsApi apiInstance = new StoreShoppingCartsApi();
String id = "id_example"; // String | The id of the cart
CartShippingAddressRequest cartShippingAddressRequest = new CartShippingAddressRequest(); // CartShippingAddressRequest | The cart shipping address request object
try {
    apiInstance.updateShippingAddress(id, cartShippingAddressRequest);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreShoppingCartsApi#updateShippingAddress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the cart |
 **cartShippingAddressRequest** | [**CartShippingAddressRequest**](CartShippingAddressRequest.md)| The cart shipping address request object | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

