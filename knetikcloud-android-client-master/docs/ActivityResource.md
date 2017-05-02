
# ActivityResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**additionalProperties** | [**Map&lt;String, Property&gt;**](Property.md) | A map of additional properties, keyed on the property name.  Must match the names and types defined in the template for this item type |  [optional]
**createdDate** | **Long** | The date/time this resource was created in seconds since unix epoch |  [optional]
**entitlements** | [**List&lt;ActivityEntitlementResource&gt;**](ActivityEntitlementResource.md) | The list of items that can be used for entitlement (wager amounts/etc) |  [optional]
**id** | **Long** | The unique ID for that resource |  [optional]
**launch** | **String** | Details about how to launch the activity |  [optional]
**longDescription** | **String** | The user friendly name of that resource. Defaults to blank string |  [optional]
**name** | **String** | The user friendly name of that resource | 
**rewardSet** | [**RewardSetResource**](RewardSetResource.md) | The rewards to give at the end of each occurence of the activity. When creating/updating only id is used. Reward set must be pre-existing |  [optional]
**settings** | [**List&lt;AvailableSettingResource&gt;**](AvailableSettingResource.md) | The list of settings and their options available for this activity. Not populated when getting listing |  [optional]
**shortDescription** | **String** | The user friendly name of that resource. Defaults to blank string |  [optional]
**template** | **Boolean** | Whether this activity is a template for other activities. Default: false |  [optional]
**templateId** | **String** | An activity template this activity is validated against (private). May be null and no validation of additional_properties will be done |  [optional]
**type** | **String** | The type of the activity | 
**uniqueKey** | **String** | The unique key (for static reference in code) of the activity |  [optional]
**updatedDate** | **Long** | The date/time this resource was last updated in seconds since unix epoch |  [optional]



