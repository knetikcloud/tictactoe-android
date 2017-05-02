# PaymentsGoogleApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**handleGooglePayment**](PaymentsGoogleApi.md#handleGooglePayment) | **POST** /payment/provider/google/payments | Mark an invoice paid with Google


<a name="handleGooglePayment"></a>
# **handleGooglePayment**
> Integer handleGooglePayment(request)

Mark an invoice paid with Google

Mark an invoice paid with Google. Verifies signature from Google and treats the developerPayload field inside the json payload as the id of the invoice to pay. Returns the transaction ID if successful.

### Example
```java
// Import classes:
//import com.knetikcloud.api.PaymentsGoogleApi;

PaymentsGoogleApi apiInstance = new PaymentsGoogleApi();
GooglePaymentRequest request = new GooglePaymentRequest(); // GooglePaymentRequest | The request for paying an invoice through a Google in-app payment
try {
    Integer result = apiInstance.handleGooglePayment(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsGoogleApi#handleGooglePayment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**GooglePaymentRequest**](GooglePaymentRequest.md)| The request for paying an invoice through a Google in-app payment | [optional]

### Return type

**Integer**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

