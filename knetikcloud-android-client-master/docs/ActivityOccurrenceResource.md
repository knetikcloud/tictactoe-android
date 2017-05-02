
# ActivityOccurrenceResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**activityId** | **Long** | The id of the activity | 
**challengeActivityId** | **Long** | The id of the challenge activity (as part of the event, required if eventId set) |  [optional]
**createdDate** | **Long** | The date this occurrence was created, unix timestamp in seconds |  [optional]
**entitlement** | [**ActivityEntitlementResource**](ActivityEntitlementResource.md) | The entitlement item required to enter the occurrence. Required if not part of an event. Must come from the set of entitlement items listed in the activity |  [optional]
**eventId** | **Long** | The id of the event |  [optional]
**id** | **Long** | The id of the activity occurrence |  [optional]
**rewardStatus** | [**RewardStatusEnum**](#RewardStatusEnum) | Indicate if the rewards have been given out already |  [optional]
**settings** | [**List&lt;SelectedSettingResource&gt;**](SelectedSettingResource.md) | The list of settings and their options available for this activity. Should be null on create if and only if part of an event. Otherwise, the set must exactly match those of the activity. |  [optional]
**simulated** | **Boolean** | Whether this occurrence will be played as a simulation. |  [optional]
**startDate** | **Long** | The date this occurrence was started, unix timestamp in seconds. null if not yet started |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The current status of the occurrence (default: OPEN) |  [optional]
**updatedDate** | **Long** | The date this occurrence was last updated, unix timestamp in seconds |  [optional]
**users** | [**List&lt;ActivityUserResource&gt;**](ActivityUserResource.md) | The list of users playing in this occurrence. Can only be set directly with ACTIVITIES_ADMIN permission |  [optional]


<a name="RewardStatusEnum"></a>
## Enum: RewardStatusEnum
Name | Value
---- | -----


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----



