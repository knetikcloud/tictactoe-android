# PaymentsAppleApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**verifyAppleReceipt**](PaymentsAppleApi.md#verifyAppleReceipt) | **POST** /payment/provider/apple/receipt | Pay invoice with Apple receipt


<a name="verifyAppleReceipt"></a>
# **verifyAppleReceipt**
> String verifyAppleReceipt(request)

Pay invoice with Apple receipt

Mark an invoice paid using Apple payment receipt. A receipt will only be accepted once and the details of the transaction must match the invoice, including the product_id matching the sku text of the item in the invoice. Returns the transaction ID if successful.

### Example
```java
// Import classes:
//import com.knetikcloud.api.PaymentsAppleApi;

PaymentsAppleApi apiInstance = new PaymentsAppleApi();
ApplyPaymentRequest request = new ApplyPaymentRequest(); // ApplyPaymentRequest | The request for paying an invoice through an Apple receipt
try {
    String result = apiInstance.verifyAppleReceipt(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsAppleApi#verifyAppleReceipt");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**ApplyPaymentRequest**](ApplyPaymentRequest.md)| The request for paying an invoice through an Apple receipt | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

