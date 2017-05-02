
# InventorySubscriptionResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**billDate** | **Long** | The date the subscription will be billed |  [optional]
**credit** | **Double** | A credit of money already applied to a subscription for the next bill, or a debt if negative |  [optional]
**creditLog** | [**List&lt;SubscriptionCreditResource&gt;**](SubscriptionCreditResource.md) | A record of past and present credit/debt changes |  [optional]
**graceEnd** | **Long** | The date the grace period ends |  [optional]
**inventoryId** | **Integer** | The id of the inventory |  [optional]
**inventoryStatus** | [**InventoryStatusEnum**](#InventoryStatusEnum) | The inventory status object |  [optional]
**itemId** | **Integer** | The id of the item |  [optional]
**paymentMethod** | [**PaymentMethodResource**](PaymentMethodResource.md) | The payment method object |  [optional]
**recurringPrice** | **Double** | The recurring price |  [optional]
**sku** | **String** | The sku of the subscription |  [optional]
**startDate** | **Long** | The date the subscription will start |  [optional]
**subscriptionStatus** | **Integer** | The status of the subscription |  [optional]
**user** | [**SimpleUserResource**](SimpleUserResource.md) | The user |  [optional]


<a name="InventoryStatusEnum"></a>
## Enum: InventoryStatusEnum
Name | Value
---- | -----



