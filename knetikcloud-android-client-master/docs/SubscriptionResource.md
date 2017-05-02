
# SubscriptionResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**additionalProperties** | [**Map&lt;String, Property&gt;**](Property.md) | A map of item additional properties, keyed on the property name. Must match the names and types defined in the template for this item type. |  [optional]
**availability** | [**AvailabilityEnum**](#AvailabilityEnum) | Who can purchase this subscription |  [optional]
**category** | **String** | A category for filtering items |  [optional]
**consolidationDayOfMonth** | **Integer** | The day of the month 1..31 this subscription will renew |  [optional]
**createdDate** | **Long** | The date the item was created, unix timestamp in seconds |  [optional]
**geoCountryList** | **List&lt;String&gt;** | A list of country iso3 codes to include in the blacklist/whitelist geo policy |  [optional]
**geoPolicyType** | [**GeoPolicyTypeEnum**](#GeoPolicyTypeEnum) | Whether to use the geo_country_list as a black list or white list for item geographical availability |  [optional]
**id** | **Integer** | The id of the item |  [optional]
**longDescription** | **String** | A long description of the subscription |  [optional]
**name** | **String** | The name of the item | 
**plans** | [**List&lt;SubscriptionPlanResource&gt;**](SubscriptionPlanResource.md) | The billing options for this subscription |  [optional]
**shortDescription** | **String** | A short description of the subscription.  Max 255 characters |  [optional]
**sort** | **Integer** | A number to use in sorting items.  Default 500 |  [optional]
**storeEnd** | **Long** | Used to schedule removal from store.  Null means the subscription will never be removed |  [optional]
**storeStart** | **Long** | Used to schedule appearance in store.  Null means the subscription will appear now |  [optional]
**tags** | **List&lt;String&gt;** | List of tags used for filtering items |  [optional]
**template** | **String** | An item template this item is validated against. May be null and no validation of additional properties will be done. |  [optional]
**uniqueKey** | **String** | The unique key for the item |  [optional]
**updatedDate** | **Long** | The date the item was last updated |  [optional]
**vendorId** | **Integer** | The vendor who provides the item | 


<a name="AvailabilityEnum"></a>
## Enum: AvailabilityEnum
Name | Value
---- | -----


<a name="GeoPolicyTypeEnum"></a>
## Enum: GeoPolicyTypeEnum
Name | Value
---- | -----



