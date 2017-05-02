# PaymentsPayPalClassicApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPayPalBillingAgreementUrl**](PaymentsPayPalClassicApi.md#createPayPalBillingAgreementUrl) | **POST** /payment/provider/paypal/classic/agreements/start | Create a PayPal Classic billing agreement for the user
[**createPayPalExpressCheckout**](PaymentsPayPalClassicApi.md#createPayPalExpressCheckout) | **POST** /payment/provider/paypal/classic/checkout/start | Create a payment token for PayPal express checkout
[**finalizePayPalBillingAgreement**](PaymentsPayPalClassicApi.md#finalizePayPalBillingAgreement) | **POST** /payment/provider/paypal/classic/agreements/finish | Finalizes a billing agreement after the user has accepted through PayPal
[**finalizePayPalCheckout**](PaymentsPayPalClassicApi.md#finalizePayPalCheckout) | **POST** /payment/provider/paypal/classic/checkout/finish | Finalizes a payment after the user has completed checkout with PayPal


<a name="createPayPalBillingAgreementUrl"></a>
# **createPayPalBillingAgreementUrl**
> String createPayPalBillingAgreementUrl(request)

Create a PayPal Classic billing agreement for the user

Returns the token that should be used to forward the user to PayPal so they can accept the agreement.

### Example
```java
// Import classes:
//import com.knetikcloud.api.PaymentsPayPalClassicApi;

PaymentsPayPalClassicApi apiInstance = new PaymentsPayPalClassicApi();
CreateBillingAgreementRequest request = new CreateBillingAgreementRequest(); // CreateBillingAgreementRequest | The request to create a PayPal billing agreement
try {
    String result = apiInstance.createPayPalBillingAgreementUrl(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsPayPalClassicApi#createPayPalBillingAgreementUrl");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**CreateBillingAgreementRequest**](CreateBillingAgreementRequest.md)| The request to create a PayPal billing agreement | [optional]

### Return type

**String**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createPayPalExpressCheckout"></a>
# **createPayPalExpressCheckout**
> String createPayPalExpressCheckout(request)

Create a payment token for PayPal express checkout

Returns the token that should be used to forward the user to PayPal so they can complete the checkout.

### Example
```java
// Import classes:
//import com.knetikcloud.api.PaymentsPayPalClassicApi;

PaymentsPayPalClassicApi apiInstance = new PaymentsPayPalClassicApi();
CreatePayPalPaymentRequest request = new CreatePayPalPaymentRequest(); // CreatePayPalPaymentRequest | The request to create a PayPal payment token
try {
    String result = apiInstance.createPayPalExpressCheckout(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsPayPalClassicApi#createPayPalExpressCheckout");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**CreatePayPalPaymentRequest**](CreatePayPalPaymentRequest.md)| The request to create a PayPal payment token | [optional]

### Return type

**String**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="finalizePayPalBillingAgreement"></a>
# **finalizePayPalBillingAgreement**
> Integer finalizePayPalBillingAgreement(request)

Finalizes a billing agreement after the user has accepted through PayPal

Returns the ID of the new payment method created for the user for the billing agreement.

### Example
```java
// Import classes:
//import com.knetikcloud.api.PaymentsPayPalClassicApi;

PaymentsPayPalClassicApi apiInstance = new PaymentsPayPalClassicApi();
FinalizeBillingAgreementRequest request = new FinalizeBillingAgreementRequest(); // FinalizeBillingAgreementRequest | The request to finalize a PayPal billing agreement
try {
    Integer result = apiInstance.finalizePayPalBillingAgreement(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsPayPalClassicApi#finalizePayPalBillingAgreement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**FinalizeBillingAgreementRequest**](FinalizeBillingAgreementRequest.md)| The request to finalize a PayPal billing agreement | [optional]

### Return type

**Integer**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="finalizePayPalCheckout"></a>
# **finalizePayPalCheckout**
> finalizePayPalCheckout(request)

Finalizes a payment after the user has completed checkout with PayPal

The invoice will be marked paid/failed by asynchronous IPN callback.

### Example
```java
// Import classes:
//import com.knetikcloud.api.PaymentsPayPalClassicApi;

PaymentsPayPalClassicApi apiInstance = new PaymentsPayPalClassicApi();
FinalizePayPalPaymentRequest request = new FinalizePayPalPaymentRequest(); // FinalizePayPalPaymentRequest | The request to finalize the payment
try {
    apiInstance.finalizePayPalCheckout(request);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsPayPalClassicApi#finalizePayPalCheckout");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**FinalizePayPalPaymentRequest**](FinalizePayPalPaymentRequest.md)| The request to finalize the payment | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

