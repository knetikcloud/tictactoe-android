
# FinalizeBillingAgreementRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**invoiceId** | **Integer** | The ID of the invoice being paid along with the creation of this agreement |  [optional]
**newDefault** | **Boolean** | Whether the new payment method created should be the user&#39;s default |  [optional]
**payerId** | **String** | The payer ID from PayPal (passed as a parameter in the return URL). Only required if an invoice ID was included |  [optional]
**token** | **String** | The token from PayPal (passed as a parameter in the return URL) | 
**userId** | **Integer** | The ID of the user. Defaults to the logged in user |  [optional]



