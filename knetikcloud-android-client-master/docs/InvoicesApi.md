# InvoicesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createInvoice**](InvoicesApi.md#createInvoice) | **POST** /invoices | Create an invoice
[**getFulFillmentStatuses**](InvoicesApi.md#getFulFillmentStatuses) | **GET** /invoices/fulfillment-statuses | Lists available fulfillment statuses
[**getInvoice**](InvoicesApi.md#getInvoice) | **GET** /invoices/{id} | Retrieve an invoice
[**getInvoiceLogs**](InvoicesApi.md#getInvoiceLogs) | **GET** /invoices/{id}/logs | List invoice logs
[**getInvoices**](InvoicesApi.md#getInvoices) | **GET** /invoices | Retrieve invoices
[**getPaymentStatuses**](InvoicesApi.md#getPaymentStatuses) | **GET** /invoices/payment-statuses | Lists available payment statuses
[**payInvoice**](InvoicesApi.md#payInvoice) | **POST** /invoices/{id}/payments | Trigger payment of an invoice
[**setExternalRef**](InvoicesApi.md#setExternalRef) | **PUT** /invoices/{id}/external-ref | Set the external reference of an invoice
[**setInvoiceItemFulfillmentStatus**](InvoicesApi.md#setInvoiceItemFulfillmentStatus) | **PUT** /invoices/{id}/items/{sku}/fulfillment-status | Set the fulfillment status of an invoice item
[**setOrderNotes**](InvoicesApi.md#setOrderNotes) | **PUT** /invoices/{id}/order-notes | Set the order notes of an invoice
[**setPaymentStatus**](InvoicesApi.md#setPaymentStatus) | **PUT** /invoices/{id}/payment-status | Set the payment status of an invoice
[**updateBillingInfo**](InvoicesApi.md#updateBillingInfo) | **PUT** /invoices/{id}/billing-address | Set or update billing info


<a name="createInvoice"></a>
# **createInvoice**
> List&lt;InvoiceResource&gt; createInvoice(req)

Create an invoice

Create an invoice(s) by providing a cart GUID. Note that there may be multiple invoices created, one per vendor.

### Example
```java
// Import classes:
//import com.knetikcloud.api.InvoicesApi;

InvoicesApi apiInstance = new InvoicesApi();
InvoiceCreateRequest req = new InvoiceCreateRequest(); // InvoiceCreateRequest | Invoice to be created
try {
    List<InvoiceResource> result = apiInstance.createInvoice(req);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#createInvoice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **req** | [**InvoiceCreateRequest**](InvoiceCreateRequest.md)| Invoice to be created | [optional]

### Return type

[**List&lt;InvoiceResource&gt;**](InvoiceResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFulFillmentStatuses"></a>
# **getFulFillmentStatuses**
> List&lt;String&gt; getFulFillmentStatuses()

Lists available fulfillment statuses

### Example
```java
// Import classes:
//import com.knetikcloud.api.InvoicesApi;

InvoicesApi apiInstance = new InvoicesApi();
try {
    List<String> result = apiInstance.getFulFillmentStatuses();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#getFulFillmentStatuses");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getInvoice"></a>
# **getInvoice**
> InvoiceResource getInvoice(id)

Retrieve an invoice

### Example
```java
// Import classes:
//import com.knetikcloud.api.InvoicesApi;

InvoicesApi apiInstance = new InvoicesApi();
Integer id = 56; // Integer | The id of the invoice
try {
    InvoiceResource result = apiInstance.getInvoice(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#getInvoice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the invoice |

### Return type

[**InvoiceResource**](InvoiceResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getInvoiceLogs"></a>
# **getInvoiceLogs**
> PageResourceInvoiceLogEntry getInvoiceLogs(id, size, page)

List invoice logs

### Example
```java
// Import classes:
//import com.knetikcloud.api.InvoicesApi;

InvoicesApi apiInstance = new InvoicesApi();
Integer id = 56; // Integer | The id of the invoice
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceInvoiceLogEntry result = apiInstance.getInvoiceLogs(id, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#getInvoiceLogs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the invoice |
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceInvoiceLogEntry**](PageResourceInvoiceLogEntry.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getInvoices"></a>
# **getInvoices**
> PageResourceInvoiceResource getInvoices(filterUser, filterEmail, filterFulfillmentStatus, filterPaymentStatus, filterItemName, filterExternalRef, filterCreatedDate, filterVendorIds, filterCurrency, filterShippingStateName, filterShippingCountryName, filterShipping, filterVendorName, filterSku, size, page, order)

Retrieve invoices

Without INVOICES_ADMIN permission the results are automatically filtered for only the logged in user&#39;s invoices. It is recomended however that filter_user be added to avoid issues for admin users accidentally getting additional invoices.

### Example
```java
// Import classes:
//import com.knetikcloud.api.InvoicesApi;

InvoicesApi apiInstance = new InvoicesApi();
Integer filterUser = 56; // Integer | The id of a user to get invoices for. Automtically added if not being called with admin permissions.
String filterEmail = "filterEmail_example"; // String | Filters invoices by customer's email. Admins only.
String filterFulfillmentStatus = "filterFulfillmentStatus_example"; // String | Filters invoices by fulfillment status type. Can be a comma separated list of statuses
String filterPaymentStatus = "filterPaymentStatus_example"; // String | Filters invoices by payment status type. Can be a comma separated list of statuses
String filterItemName = "filterItemName_example"; // String | Filters invoices by item name containing the given string
String filterExternalRef = "filterExternalRef_example"; // String | Filters invoices by external reference.
String filterCreatedDate = "filterCreatedDate_example"; // String | Filters invoices by creation date. Multiple values possible for range search. Format: filter_created_date=OP,ts&... where OP in (GT, LT, GOE, LOE, EQ) and ts is a unix timestamp in seconds. Ex: filter_created_date=GT,1452154258,LT,1554254874
String filterVendorIds = "filterVendorIds_example"; // String | Filters invoices for ones from one of the vendors whose id is in the given comma separated list
String filterCurrency = "filterCurrency_example"; // String | Filters invoices by currency. ISO3 currency code
String filterShippingStateName = "filterShippingStateName_example"; // String | Filters invoices by shipping address: Exact match state name
String filterShippingCountryName = "filterShippingCountryName_example"; // String | Filters invoices by shipping address: Exact match country name
String filterShipping = "filterShipping_example"; // String | Filters invoices by shipping price. Multiple values possible for range search. Format: filter_shipping=OP,ts&... where OP in (GT, LT, GOE, LOE, EQ). Ex: filter_shipping=GT,14.58,LT,15.54
String filterVendorName = "filterVendorName_example"; // String | Filters invoices by vendor name starting with given string
String filterSku = "filterSku_example"; // String | Filters invoices by item sku
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "1"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceInvoiceResource result = apiInstance.getInvoices(filterUser, filterEmail, filterFulfillmentStatus, filterPaymentStatus, filterItemName, filterExternalRef, filterCreatedDate, filterVendorIds, filterCurrency, filterShippingStateName, filterShippingCountryName, filterShipping, filterVendorName, filterSku, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#getInvoices");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterUser** | **Integer**| The id of a user to get invoices for. Automtically added if not being called with admin permissions. | [optional]
 **filterEmail** | **String**| Filters invoices by customer&#39;s email. Admins only. | [optional]
 **filterFulfillmentStatus** | **String**| Filters invoices by fulfillment status type. Can be a comma separated list of statuses | [optional]
 **filterPaymentStatus** | **String**| Filters invoices by payment status type. Can be a comma separated list of statuses | [optional]
 **filterItemName** | **String**| Filters invoices by item name containing the given string | [optional]
 **filterExternalRef** | **String**| Filters invoices by external reference. | [optional]
 **filterCreatedDate** | **String**| Filters invoices by creation date. Multiple values possible for range search. Format: filter_created_date&#x3D;OP,ts&amp;... where OP in (GT, LT, GOE, LOE, EQ) and ts is a unix timestamp in seconds. Ex: filter_created_date&#x3D;GT,1452154258,LT,1554254874 | [optional]
 **filterVendorIds** | **String**| Filters invoices for ones from one of the vendors whose id is in the given comma separated list | [optional]
 **filterCurrency** | **String**| Filters invoices by currency. ISO3 currency code | [optional]
 **filterShippingStateName** | **String**| Filters invoices by shipping address: Exact match state name | [optional]
 **filterShippingCountryName** | **String**| Filters invoices by shipping address: Exact match country name | [optional]
 **filterShipping** | **String**| Filters invoices by shipping price. Multiple values possible for range search. Format: filter_shipping&#x3D;OP,ts&amp;... where OP in (GT, LT, GOE, LOE, EQ). Ex: filter_shipping&#x3D;GT,14.58,LT,15.54 | [optional]
 **filterVendorName** | **String**| Filters invoices by vendor name starting with given string | [optional]
 **filterSku** | **String**| Filters invoices by item sku | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to 1]

### Return type

[**PageResourceInvoiceResource**](PageResourceInvoiceResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getPaymentStatuses"></a>
# **getPaymentStatuses**
> List&lt;String&gt; getPaymentStatuses()

Lists available payment statuses

### Example
```java
// Import classes:
//import com.knetikcloud.api.InvoicesApi;

InvoicesApi apiInstance = new InvoicesApi();
try {
    List<String> result = apiInstance.getPaymentStatuses();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#getPaymentStatuses");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="payInvoice"></a>
# **payInvoice**
> payInvoice(id, request)

Trigger payment of an invoice

### Example
```java
// Import classes:
//import com.knetikcloud.api.InvoicesApi;

InvoicesApi apiInstance = new InvoicesApi();
Integer id = 56; // Integer | The id of the invoice
PayBySavedMethodRequest request = new PayBySavedMethodRequest(); // PayBySavedMethodRequest | Payment info
try {
    apiInstance.payInvoice(id, request);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#payInvoice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the invoice |
 **request** | [**PayBySavedMethodRequest**](PayBySavedMethodRequest.md)| Payment info | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setExternalRef"></a>
# **setExternalRef**
> setExternalRef(id, externalRef)

Set the external reference of an invoice

### Example
```java
// Import classes:
//import com.knetikcloud.api.InvoicesApi;

InvoicesApi apiInstance = new InvoicesApi();
Integer id = 56; // Integer | The id of the invoice
String externalRef = "externalRef_example"; // String | External reference info
try {
    apiInstance.setExternalRef(id, externalRef);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#setExternalRef");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the invoice |
 **externalRef** | **String**| External reference info | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setInvoiceItemFulfillmentStatus"></a>
# **setInvoiceItemFulfillmentStatus**
> setInvoiceItemFulfillmentStatus(id, sku, status)

Set the fulfillment status of an invoice item

This allows external fulfillment systems to report success or failure. Fulfillment status changes are restricted by a specific flow determining which status can lead to which.

### Example
```java
// Import classes:
//import com.knetikcloud.api.InvoicesApi;

InvoicesApi apiInstance = new InvoicesApi();
Integer id = 56; // Integer | The id of the invoice
String sku = "sku_example"; // String | The sku of an item in the invoice
String status = "status_example"; // String | The new fulfillment status for the item. Additional options may be available based on configuration.  Allowable values:  'unfulfilled', 'fulfilled', 'not fulfillable', 'failed', 'processing', 'failed_permanent', 'delayed'
try {
    apiInstance.setInvoiceItemFulfillmentStatus(id, sku, status);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#setInvoiceItemFulfillmentStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the invoice |
 **sku** | **String**| The sku of an item in the invoice |
 **status** | **String**| The new fulfillment status for the item. Additional options may be available based on configuration.  Allowable values:  &#39;unfulfilled&#39;, &#39;fulfilled&#39;, &#39;not fulfillable&#39;, &#39;failed&#39;, &#39;processing&#39;, &#39;failed_permanent&#39;, &#39;delayed&#39; |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setOrderNotes"></a>
# **setOrderNotes**
> setOrderNotes(id, orderNotes)

Set the order notes of an invoice

### Example
```java
// Import classes:
//import com.knetikcloud.api.InvoicesApi;

InvoicesApi apiInstance = new InvoicesApi();
Integer id = 56; // Integer | The id of the invoice
String orderNotes = "orderNotes_example"; // String | Payment status info
try {
    apiInstance.setOrderNotes(id, orderNotes);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#setOrderNotes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the invoice |
 **orderNotes** | **String**| Payment status info | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setPaymentStatus"></a>
# **setPaymentStatus**
> setPaymentStatus(id, request)

Set the payment status of an invoice

This may trigger fulfillment if setting the status to &#39;paid&#39;. This is mainly intended to support external payment systems that cannot be incorporated into the payment method system. Payment status changes are restricted by a specific flow determining which status can lead to which.

### Example
```java
// Import classes:
//import com.knetikcloud.api.InvoicesApi;

InvoicesApi apiInstance = new InvoicesApi();
Integer id = 56; // Integer | The id of the invoice
InvoicePaymentStatusRequest request = new InvoicePaymentStatusRequest(); // InvoicePaymentStatusRequest | Payment status info
try {
    apiInstance.setPaymentStatus(id, request);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#setPaymentStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the invoice |
 **request** | [**InvoicePaymentStatusRequest**](InvoicePaymentStatusRequest.md)| Payment status info | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateBillingInfo"></a>
# **updateBillingInfo**
> updateBillingInfo(id, billingInfoRequest)

Set or update billing info

### Example
```java
// Import classes:
//import com.knetikcloud.api.InvoicesApi;

InvoicesApi apiInstance = new InvoicesApi();
Integer id = 56; // Integer | The id of the invoice
AddressResource billingInfoRequest = new AddressResource(); // AddressResource | Address info
try {
    apiInstance.updateBillingInfo(id, billingInfoRequest);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#updateBillingInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The id of the invoice |
 **billingInfoRequest** | [**AddressResource**](AddressResource.md)| Address info | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

