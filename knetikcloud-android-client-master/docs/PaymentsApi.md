# PaymentsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPaymentMethod**](PaymentsApi.md#createPaymentMethod) | **POST** /users/{user_id}/payment-methods | Create a new payment method for a user
[**deletePaymentMethod**](PaymentsApi.md#deletePaymentMethod) | **DELETE** /users/{user_id}/payment-methods/{id} | Delete an existing payment method for a user
[**getPaymentMethod**](PaymentsApi.md#getPaymentMethod) | **GET** /users/{user_id}/payment-methods/{id} | Get a single payment method for a user
[**getPaymentMethods**](PaymentsApi.md#getPaymentMethods) | **GET** /users/{user_id}/payment-methods | Get all payment methods for a user
[**paymentAuthorization**](PaymentsApi.md#paymentAuthorization) | **POST** /payment/authorizations | Authorize payment of an invoice for later capture
[**paymentCapture**](PaymentsApi.md#paymentCapture) | **POST** /payment/authorizations/{id}/capture | Capture an existing invoice payment authorization
[**updatePaymentMethod**](PaymentsApi.md#updatePaymentMethod) | **PUT** /users/{user_id}/payment-methods/{id} | Update an existing payment method for a user


<a name="createPaymentMethod"></a>
# **createPaymentMethod**
> PaymentMethodResource createPaymentMethod(userId, paymentMethod)

Create a new payment method for a user

### Example
```java
// Import classes:
//import com.knetikcloud.api.PaymentsApi;

PaymentsApi apiInstance = new PaymentsApi();
Integer userId = 56; // Integer | ID of the user for whom the payment method is being created
PaymentMethodResource paymentMethod = new PaymentMethodResource(); // PaymentMethodResource | Payment method being created
try {
    PaymentMethodResource result = apiInstance.createPaymentMethod(userId, paymentMethod);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#createPaymentMethod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| ID of the user for whom the payment method is being created |
 **paymentMethod** | [**PaymentMethodResource**](PaymentMethodResource.md)| Payment method being created | [optional]

### Return type

[**PaymentMethodResource**](PaymentMethodResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deletePaymentMethod"></a>
# **deletePaymentMethod**
> deletePaymentMethod(userId, id)

Delete an existing payment method for a user

### Example
```java
// Import classes:
//import com.knetikcloud.api.PaymentsApi;

PaymentsApi apiInstance = new PaymentsApi();
Integer userId = 56; // Integer | ID of the user for whom the payment method is being updated
Integer id = 56; // Integer | ID of the payment method being deleted
try {
    apiInstance.deletePaymentMethod(userId, id);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#deletePaymentMethod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| ID of the user for whom the payment method is being updated |
 **id** | **Integer**| ID of the payment method being deleted |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getPaymentMethod"></a>
# **getPaymentMethod**
> PaymentMethodResource getPaymentMethod(userId, id)

Get a single payment method for a user

### Example
```java
// Import classes:
//import com.knetikcloud.api.PaymentsApi;

PaymentsApi apiInstance = new PaymentsApi();
Integer userId = 56; // Integer | ID of the user for whom the payment method is being retrieved
Integer id = 56; // Integer | ID of the payment method being retrieved
try {
    PaymentMethodResource result = apiInstance.getPaymentMethod(userId, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#getPaymentMethod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| ID of the user for whom the payment method is being retrieved |
 **id** | **Integer**| ID of the payment method being retrieved |

### Return type

[**PaymentMethodResource**](PaymentMethodResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getPaymentMethods"></a>
# **getPaymentMethods**
> List&lt;PaymentMethodResource&gt; getPaymentMethods(userId, size, page, order)

Get all payment methods for a user

### Example
```java
// Import classes:
//import com.knetikcloud.api.PaymentsApi;

PaymentsApi apiInstance = new PaymentsApi();
Integer userId = 56; // Integer | ID of the user for whom the payment methods are being retrieved
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | a comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    List<PaymentMethodResource> result = apiInstance.getPaymentMethods(userId, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#getPaymentMethods");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| ID of the user for whom the payment methods are being retrieved |
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| a comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**List&lt;PaymentMethodResource&gt;**](PaymentMethodResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="paymentAuthorization"></a>
# **paymentAuthorization**
> PaymentAuthorizationResource paymentAuthorization(request)

Authorize payment of an invoice for later capture

### Example
```java
// Import classes:
//import com.knetikcloud.api.PaymentsApi;

PaymentsApi apiInstance = new PaymentsApi();
PaymentAuthorizationResource request = new PaymentAuthorizationResource(); // PaymentAuthorizationResource | Payment authorization request
try {
    PaymentAuthorizationResource result = apiInstance.paymentAuthorization(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#paymentAuthorization");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**PaymentAuthorizationResource**](PaymentAuthorizationResource.md)| Payment authorization request | [optional]

### Return type

[**PaymentAuthorizationResource**](PaymentAuthorizationResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="paymentCapture"></a>
# **paymentCapture**
> paymentCapture(id)

Capture an existing invoice payment authorization

### Example
```java
// Import classes:
//import com.knetikcloud.api.PaymentsApi;

PaymentsApi apiInstance = new PaymentsApi();
Integer id = 56; // Integer | ID of the payment authorization to capture
try {
    apiInstance.paymentCapture(id);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#paymentCapture");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the payment authorization to capture |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updatePaymentMethod"></a>
# **updatePaymentMethod**
> PaymentMethodResource updatePaymentMethod(userId, id, paymentMethod)

Update an existing payment method for a user

### Example
```java
// Import classes:
//import com.knetikcloud.api.PaymentsApi;

PaymentsApi apiInstance = new PaymentsApi();
Integer userId = 56; // Integer | ID of the user for whom the payment method is being updated
Integer id = 56; // Integer | ID of the payment method being updated
PaymentMethodResource paymentMethod = new PaymentMethodResource(); // PaymentMethodResource | The updated payment method data
try {
    PaymentMethodResource result = apiInstance.updatePaymentMethod(userId, id, paymentMethod);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#updatePaymentMethod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| ID of the user for whom the payment method is being updated |
 **id** | **Integer**| ID of the payment method being updated |
 **paymentMethod** | [**PaymentMethodResource**](PaymentMethodResource.md)| The updated payment method data | [optional]

### Return type

[**PaymentMethodResource**](PaymentMethodResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

