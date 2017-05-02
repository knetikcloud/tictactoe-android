
# RefundRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **Double** | The amount to refund. If left off, will refund the remaining balance of the transaction or specific item balance (if SKU provided), whichever is less. |  [optional]
**notes** | **String** | Notes about or reason for the refund | 
**sku** | **String** | The SKU of a specific item from the invoice to refund. Affects the maximum refund amount (not to exceed the price of this item times quantity on invoice). Transaction must be tied to an invoice if used. |  [optional]



