# MessagingApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendRawEmail**](MessagingApi.md#sendRawEmail) | **POST** /messaging/raw-email | Send a raw email to one or more users
[**sendRawSMS**](MessagingApi.md#sendRawSMS) | **POST** /messaging/raw-sms | Send a raw SMS
[**sendTemplatedEmail**](MessagingApi.md#sendTemplatedEmail) | **POST** /messaging/templated-email | Send a templated email to one or more users
[**sendTemplatedSMS**](MessagingApi.md#sendTemplatedSMS) | **POST** /messaging/templated-sms | Send a new templated SMS


<a name="sendRawEmail"></a>
# **sendRawEmail**
> sendRawEmail(rawEmailResource)

Send a raw email to one or more users

### Example
```java
// Import classes:
//import com.knetikcloud.api.MessagingApi;

MessagingApi apiInstance = new MessagingApi();
RawEmailResource rawEmailResource = new RawEmailResource(); // RawEmailResource | The new raw email to be sent
try {
    apiInstance.sendRawEmail(rawEmailResource);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagingApi#sendRawEmail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rawEmailResource** | [**RawEmailResource**](RawEmailResource.md)| The new raw email to be sent | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="sendRawSMS"></a>
# **sendRawSMS**
> sendRawSMS(rawSMSResource)

Send a raw SMS

Sends a raw SMS text message to one or more users. User&#39;s without registered mobile numbers will be skipped.

### Example
```java
// Import classes:
//import com.knetikcloud.api.MessagingApi;

MessagingApi apiInstance = new MessagingApi();
RawSMSResource rawSMSResource = new RawSMSResource(); // RawSMSResource | The new raw SMS to be sent
try {
    apiInstance.sendRawSMS(rawSMSResource);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagingApi#sendRawSMS");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rawSMSResource** | [**RawSMSResource**](RawSMSResource.md)| The new raw SMS to be sent | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="sendTemplatedEmail"></a>
# **sendTemplatedEmail**
> sendTemplatedEmail(messageResource)

Send a templated email to one or more users

### Example
```java
// Import classes:
//import com.knetikcloud.api.MessagingApi;

MessagingApi apiInstance = new MessagingApi();
TemplateEmailResource messageResource = new TemplateEmailResource(); // TemplateEmailResource | The new template email to be sent
try {
    apiInstance.sendTemplatedEmail(messageResource);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagingApi#sendTemplatedEmail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **messageResource** | [**TemplateEmailResource**](TemplateEmailResource.md)| The new template email to be sent | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="sendTemplatedSMS"></a>
# **sendTemplatedSMS**
> sendTemplatedSMS(templateSMSResource)

Send a new templated SMS

Sends a templated SMS text message to one or more users. User&#39;s without registered mobile numbers will be skipped.

### Example
```java
// Import classes:
//import com.knetikcloud.api.MessagingApi;

MessagingApi apiInstance = new MessagingApi();
TemplateSMSResource templateSMSResource = new TemplateSMSResource(); // TemplateSMSResource | The new template SMS to be sent
try {
    apiInstance.sendTemplatedSMS(templateSMSResource);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagingApi#sendTemplatedSMS");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **templateSMSResource** | [**TemplateSMSResource**](TemplateSMSResource.md)| The new template SMS to be sent | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

