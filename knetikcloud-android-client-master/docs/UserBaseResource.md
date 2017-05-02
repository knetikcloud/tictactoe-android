
# UserBaseResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**avatarUrl** | **String** | The url of the user&#39;s avatar image |  [optional]
**displayName** | **String** | The chosen display name of the user, defaults to username if not present |  [optional]
**email** | **String** | The user&#39;s email address (private). May be required and/or unique depending on system configuration (both on by default). Must match standard email requirements if provided (RFC 2822) | 
**fullname** | **String** | The user&#39;s full name (private) |  [optional]
**id** | **Integer** | The id of the user |  [optional]
**lastUpdated** | **Long** | The date the user&#39;s info was last updated as a unix timestamp |  [optional]
**memberSince** | **Long** | The user&#39;s date of registration as a unix timestamp |  [optional]
**username** | **String** | The login username for the user (private). May be set to match email if system does not require usernames separately. | 



