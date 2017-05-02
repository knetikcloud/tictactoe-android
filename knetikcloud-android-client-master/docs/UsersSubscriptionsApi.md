# UsersSubscriptionsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getUserSubscriptionDetails**](UsersSubscriptionsApi.md#getUserSubscriptionDetails) | **GET** /users/{user_id}/subscriptions/{inventory_id} | Get details about a user&#39;s subscription
[**getUsersSubscriptionDetails**](UsersSubscriptionsApi.md#getUsersSubscriptionDetails) | **GET** /users/{user_id}/subscriptions | Get details about a user&#39;s subscriptions
[**reactivateUserSubscription**](UsersSubscriptionsApi.md#reactivateUserSubscription) | **POST** /users/{user_id}/subscriptions/{inventory_id}/reactivate | Reactivate a subscription and charge fee
[**setSubscriptionBillDate**](UsersSubscriptionsApi.md#setSubscriptionBillDate) | **PUT** /users/{user_id}/subscriptions/{inventory_id}/bill-date | Set a new date to bill a subscription on
[**setSubscriptionPaymentMethod**](UsersSubscriptionsApi.md#setSubscriptionPaymentMethod) | **PUT** /users/{user_id}/subscriptions/{inventory_id}/payment-method | Set the payment method to use for a subscription
[**setSubscriptionStatus**](UsersSubscriptionsApi.md#setSubscriptionStatus) | **PUT** /users/{user_id}/subscriptions/{inventory_id}/status | Set the status of a subscription
[**setUserSubscriptionPlan**](UsersSubscriptionsApi.md#setUserSubscriptionPlan) | **PUT** /users/{user_id}/subscriptions/{inventory_id}/plan | Set a new subscription plan for a user


<a name="getUserSubscriptionDetails"></a>
# **getUserSubscriptionDetails**
> InventorySubscriptionResource getUserSubscriptionDetails(userId, inventoryId)

Get details about a user&#39;s subscription

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersSubscriptionsApi;

UsersSubscriptionsApi apiInstance = new UsersSubscriptionsApi();
Integer userId = 56; // Integer | The id of the user
Integer inventoryId = 56; // Integer | The id of the user's inventory
try {
    InventorySubscriptionResource result = apiInstance.getUserSubscriptionDetails(userId, inventoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersSubscriptionsApi#getUserSubscriptionDetails");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |
 **inventoryId** | **Integer**| The id of the user&#39;s inventory |

### Return type

[**InventorySubscriptionResource**](InventorySubscriptionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUsersSubscriptionDetails"></a>
# **getUsersSubscriptionDetails**
> List&lt;InventorySubscriptionResource&gt; getUsersSubscriptionDetails(userId)

Get details about a user&#39;s subscriptions

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersSubscriptionsApi;

UsersSubscriptionsApi apiInstance = new UsersSubscriptionsApi();
Integer userId = 56; // Integer | The id of the user
try {
    List<InventorySubscriptionResource> result = apiInstance.getUsersSubscriptionDetails(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersSubscriptionsApi#getUsersSubscriptionDetails");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |

### Return type

[**List&lt;InventorySubscriptionResource&gt;**](InventorySubscriptionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="reactivateUserSubscription"></a>
# **reactivateUserSubscription**
> InvoiceResource reactivateUserSubscription(userId, inventoryId, reactivateSubscriptionRequest)

Reactivate a subscription and charge fee

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersSubscriptionsApi;

UsersSubscriptionsApi apiInstance = new UsersSubscriptionsApi();
Integer userId = 56; // Integer | The id of the user
Integer inventoryId = 56; // Integer | The id of the user's inventory
ReactivateSubscriptionRequest reactivateSubscriptionRequest = new ReactivateSubscriptionRequest(); // ReactivateSubscriptionRequest | The reactivate subscription request object inventory
try {
    InvoiceResource result = apiInstance.reactivateUserSubscription(userId, inventoryId, reactivateSubscriptionRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersSubscriptionsApi#reactivateUserSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |
 **inventoryId** | **Integer**| The id of the user&#39;s inventory |
 **reactivateSubscriptionRequest** | [**ReactivateSubscriptionRequest**](ReactivateSubscriptionRequest.md)| The reactivate subscription request object inventory | [optional]

### Return type

[**InvoiceResource**](InvoiceResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setSubscriptionBillDate"></a>
# **setSubscriptionBillDate**
> setSubscriptionBillDate(userId, inventoryId, billDate)

Set a new date to bill a subscription on

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersSubscriptionsApi;

UsersSubscriptionsApi apiInstance = new UsersSubscriptionsApi();
Integer userId = 56; // Integer | The id of the user
Integer inventoryId = 56; // Integer | The id of the user's inventory
Long billDate = 789L; // Long | The new bill date. Unix timestamp in seconds
try {
    apiInstance.setSubscriptionBillDate(userId, inventoryId, billDate);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersSubscriptionsApi#setSubscriptionBillDate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |
 **inventoryId** | **Integer**| The id of the user&#39;s inventory |
 **billDate** | **Long**| The new bill date. Unix timestamp in seconds |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setSubscriptionPaymentMethod"></a>
# **setSubscriptionPaymentMethod**
> setSubscriptionPaymentMethod(userId, inventoryId, paymentMethodId)

Set the payment method to use for a subscription

May send null to use floating default

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersSubscriptionsApi;

UsersSubscriptionsApi apiInstance = new UsersSubscriptionsApi();
Integer userId = 56; // Integer | The id of the user
Integer inventoryId = 56; // Integer | The id of the user's inventory
Integer paymentMethodId = 56; // Integer | The id of the payment method
try {
    apiInstance.setSubscriptionPaymentMethod(userId, inventoryId, paymentMethodId);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersSubscriptionsApi#setSubscriptionPaymentMethod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |
 **inventoryId** | **Integer**| The id of the user&#39;s inventory |
 **paymentMethodId** | **Integer**| The id of the payment method | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setSubscriptionStatus"></a>
# **setSubscriptionStatus**
> setSubscriptionStatus(userId, inventoryId, status)

Set the status of a subscription

The body is a json string (put in quotes) that should match a desired invoice status type. Note that the new status may be blocked if the system is not configured to allow the current status to be changed to the new, to enforce proper flow. The default options for statuses are shown below but may be altered for special use cases

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersSubscriptionsApi;

UsersSubscriptionsApi apiInstance = new UsersSubscriptionsApi();
Integer userId = 56; // Integer | The id of the user
Integer inventoryId = 56; // Integer | The id of the user's inventory
String status = "status_example"; // String | The new status for the subscription. Actual options may differ from the indicated set if the invoice status type data has been altered.  Allowable values: ('current', 'canceled', 'stopped', 'payment_failed', 'suspended')
try {
    apiInstance.setSubscriptionStatus(userId, inventoryId, status);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersSubscriptionsApi#setSubscriptionStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |
 **inventoryId** | **Integer**| The id of the user&#39;s inventory |
 **status** | **String**| The new status for the subscription. Actual options may differ from the indicated set if the invoice status type data has been altered.  Allowable values: (&#39;current&#39;, &#39;canceled&#39;, &#39;stopped&#39;, &#39;payment_failed&#39;, &#39;suspended&#39;) |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setUserSubscriptionPlan"></a>
# **setUserSubscriptionPlan**
> setUserSubscriptionPlan(userId, inventoryId, planId)

Set a new subscription plan for a user

### Example
```java
// Import classes:
//import com.knetikcloud.api.UsersSubscriptionsApi;

UsersSubscriptionsApi apiInstance = new UsersSubscriptionsApi();
Integer userId = 56; // Integer | The id of the user
Integer inventoryId = 56; // Integer | The id of the user's inventory
String planId = "planId_example"; // String | The id of the new plan. Must be from the same subscription
try {
    apiInstance.setUserSubscriptionPlan(userId, inventoryId, planId);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersSubscriptionsApi#setUserSubscriptionPlan");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |
 **inventoryId** | **Integer**| The id of the user&#39;s inventory |
 **planId** | **String**| The id of the new plan. Must be from the same subscription | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

