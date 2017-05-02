# PaymentsTransactionsApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getTransaction**](PaymentsTransactionsApi.md#getTransaction) | **GET** /transactions/{id} | Get the details for a single transaction
[**getTransactions**](PaymentsTransactionsApi.md#getTransactions) | **GET** /transactions | List and search transactions
[**refundTransaction**](PaymentsTransactionsApi.md#refundTransaction) | **POST** /transactions/{id}/refunds | Refund a payment transaction, in full or in part


<a name="getTransaction"></a>
# **getTransaction**
> TransactionResource getTransaction(id)

Get the details for a single transaction

### Example
```java
// Import classes:
//import com.knetikcloud.api.PaymentsTransactionsApi;

PaymentsTransactionsApi apiInstance = new PaymentsTransactionsApi();
Integer id = 56; // Integer | id
try {
    TransactionResource result = apiInstance.getTransaction(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsTransactionsApi#getTransaction");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id |

### Return type

[**TransactionResource**](TransactionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTransactions"></a>
# **getTransactions**
> PageResourceTransactionResource getTransactions(filterInvoice, size, page, order)

List and search transactions

### Example
```java
// Import classes:
//import com.knetikcloud.api.PaymentsTransactionsApi;

PaymentsTransactionsApi apiInstance = new PaymentsTransactionsApi();
Integer filterInvoice = 56; // Integer | Filter for transactions from a specific invoice
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceTransactionResource result = apiInstance.getTransactions(filterInvoice, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsTransactionsApi#getTransactions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterInvoice** | **Integer**| Filter for transactions from a specific invoice | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceTransactionResource**](PageResourceTransactionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="refundTransaction"></a>
# **refundTransaction**
> RefundResource refundTransaction(id, request)

Refund a payment transaction, in full or in part

Will not allow for refunding more than the full amount even with multiple partial refunds. Money is refunded to the payment method used to make the original payment. Payment method must support refunds.

### Example
```java
// Import classes:
//import com.knetikcloud.api.PaymentsTransactionsApi;

PaymentsTransactionsApi apiInstance = new PaymentsTransactionsApi();
Integer id = 56; // Integer | The id of the transaction to refund
RefundRequest request = new RefundRequest(); // RefundRequest | Request containing refund details
try {
    RefundResource result = apiInstance.refundTransaction(id, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsTransactionsApi#refundTransaction");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the transaction to refund |
 **request** | [**RefundRequest**](RefundRequest.md)| Request containing refund details | [optional]

### Return type

[**RefundResource**](RefundResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

