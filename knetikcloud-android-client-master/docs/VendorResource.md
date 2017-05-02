
# VendorResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**active** | **Boolean** | Whether the vendor is active.  Default &#x3D; true |  [optional]
**additionalProperties** | [**Map&lt;String, Property&gt;**](Property.md) | A map of additional properties, keyed on the property name (private). Must match the names and types defined in the template for this user type, or be an extra not from the template |  [optional]
**createDate** | **Long** | The date the vendor was added. Unix timestamp in seconds |  [optional]
**description** | **String** | A description of the vendor |  [optional]
**id** | **Integer** | The id of the vendor |  [optional]
**imageUrl** | **String** | The url of an image for the vendor |  [optional]
**manualApproval** | **Boolean** | Whether the vendor needs to manually approve invoices before they are paid.  A separate checkout flow is required in this case.  Default: false |  [optional]
**name** | **String** | The name of the vendor | 
**primaryContactEmail** | **String** | The primary email address for the vendor |  [optional]
**primaryContactName** | **String** | The name of the primary contact for the vendor |  [optional]
**primaryContactPhone** | **String** | The primary phone number for the vendor |  [optional]
**salesEmail** | **String** | The email address for sale inquiries for the vendor |  [optional]
**supportEmail** | **String** | The email address for support inquiries for the vendor |  [optional]
**template** | **String** | A user template this user is validated against (private). May be null and no validation of properties will be done |  [optional]
**updateDate** | **Long** | The date the vendor was last updated. Unix timestamp in seconds |  [optional]
**url** | **String** | The url for the vendor&#39;s site |  [optional]



