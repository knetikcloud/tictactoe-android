
# UserResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**additionalProperties** | [**Map&lt;String, Property&gt;**](Property.md) | A map of additional properties, keyed on the property name (private). Must match the names and types defined in the template for this user type, or be an extra not from the template |  [optional]
**address** | **String** | The first line of the user&#39;s address (private) |  [optional]
**address2** | **String** | The second line of user&#39;s address (private) |  [optional]
**avatarUrl** | **String** | The url of the user&#39;s avatar image |  [optional]
**children** | [**List&lt;UserRelationshipReferenceResource&gt;**](UserRelationshipReferenceResource.md) | Relationships where this user is the parent. Read-Only, manage through separate endpoints |  [optional]
**city** | **String** | The user&#39;s city (private) |  [optional]
**countryCode** | **String** | The ISO3 code for the country from the user&#39;s address (private). Will be filled in based on GeoIP country at registration if not provided. |  [optional]
**currencyCode** | **String** | The code for the user&#39;s real money currency (private) |  [optional]
**dateOfBirth** | **Long** | The user&#39;s date of birth (private) as a unix timestamp |  [optional]
**description** | **String** | The user&#39;s self description (private) |  [optional]
**displayName** | **String** | The chosen display name of the user, defaults to username if not present |  [optional]
**email** | **String** | The user&#39;s email address (private). May be required and/or unique depending on system configuration (both on by default). Must match standard email requirements if provided (RFC 2822) | 
**firstName** | **String** | The user&#39;s first name (private) |  [optional]
**fullname** | **String** | The user&#39;s full name (private) |  [optional]
**gender** | **String** | The user&#39;s gender (private) |  [optional]
**id** | **Integer** | The id of the user |  [optional]
**languageCode** | **String** | The ISO3 code for the user&#39;s currency (private) |  [optional]
**lastName** | **String** | The user&#39;s last name (private) |  [optional]
**lastUpdated** | **Long** | The date the user&#39;s info was last updated as a unix timestamp |  [optional]
**memberSince** | **Long** | The user&#39;s date of registration as a unix timestamp |  [optional]
**mobileNumber** | **String** | The user&#39;s mobile phone number (private) |  [optional]
**parents** | [**List&lt;UserRelationshipReferenceResource&gt;**](UserRelationshipReferenceResource.md) | Relationships where this user is the child. Read-Only, manage through separate endpoints |  [optional]
**password** | **String** | The plain text password for the new user account. Required for registration; ignored on profile update.  Use password specific endpoints for editing |  [optional]
**postalCode** | **String** | The user&#39;s postal code (private) |  [optional]
**state** | **String** | The user&#39;s state (private) |  [optional]
**tags** | **List&lt;String&gt;** | Tags on the user. Can only be set by admin. Max length per tag is 64 characters |  [optional]
**template** | **String** | A user template this user is validated against (private). May be null and no validation of properties will be done |  [optional]
**timezoneCode** | **String** | The code for the user&#39;s timezone (private) |  [optional]
**username** | **String** | The login username for the user (private). May be set to match email if system does not require usernames separately. | 



