
# PaymentMethodResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdDate** | **Long** | The date/time this resource was created in seconds since unix epoch |  [optional]
**_default** | **Boolean** |  |  [optional]
**disabled** | **Boolean** | Whether this payment method is disabled or not |  [optional]
**expirationDate** | **Long** | The expiration date for the payment method, expressed as seconds since epoch. Typically used for credit card payment methods |  [optional]
**expirationMonth** | **Integer** | The expiration month (1 - 12) for the payment method. Typically used for credit card payment methods |  [optional]
**expirationYear** | **Integer** | The expiration year for the payment method. Typically used for credit card payment methods |  [optional]
**id** | **Long** | The unique ID for that resource |  [optional]
**last4** | **String** | The last 4 digits of the account number for the payment method. Typically used for credit card payment methods |  [optional]
**longDescription** | **String** | The user friendly name of that resource. Defaults to blank string |  [optional]
**name** | **String** | The user friendly name of that resource | 
**paymentMethodType** | [**PaymentMethodTypeResource**](PaymentMethodTypeResource.md) | The type of payment method. Must be a pre-existing value | 
**paymentType** | [**PaymentTypeEnum**](#PaymentTypeEnum) | The generic payment type. Default is card |  [optional]
**shortDescription** | **String** | The user friendly name of that resource. Defaults to blank string |  [optional]
**sort** | **Integer** | The sort value for the payment method |  [optional]
**token** | **String** | The unique token for the payment method |  [optional]
**uniqueKey** | **String** | An optional unique identifier |  [optional]
**updatedDate** | **Long** | The date/time this resource was last updated in seconds since unix epoch |  [optional]
**userId** | **Integer** | The user&#39;s id. If null, indicates a shared payment method that any user can use (i.e., &#39;wallet&#39;) |  [optional]
**verified** | **Boolean** |  |  [optional]


<a name="PaymentTypeEnum"></a>
## Enum: PaymentTypeEnum
Name | Value
---- | -----



