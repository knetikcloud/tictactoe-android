
# UserInventoryResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**behaviorData** | **Object** | A map of data for behaviors |  [optional]
**createdDate** | **Long** | The date/time this resource was created in seconds since epoch |  [optional]
**expires** | **Long** | The date/time this resource exires in seconds since epoch. Null for no expiration. For subscriptions, this is the end of the &#39;grace period&#39; if left unpaid |  [optional]
**id** | **Integer** | The id of the inventory |  [optional]
**invoiceId** | **Integer** | The id of the invoice that resulted in this inventory, if any |  [optional]
**itemId** | **Integer** | The id of the item |  [optional]
**itemName** | **String** | The name of the item |  [optional]
**itemTypeHint** | **String** | The type hint of the item |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the inventory. Pending inventory is not yet ready for use. Inactive inventory has expired or been used up |  [optional]
**updatedDate** | **Long** | The date/time this resource was last updated in seconds since epoch |  [optional]
**user** | [**SimpleUserResource**](SimpleUserResource.md) | The id of the user this inventory belongs to |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----



