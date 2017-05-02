
# CampaignResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**active** | **Boolean** | Whether the campaign is active or not.  Defaults to false |  [optional]
**additionalProperties** | [**Map&lt;String, Property&gt;**](Property.md) | A map of additional properties, keyed on the property name.  Must match the names and types defined in the template for this item type |  [optional]
**createdDate** | **Long** | The date/time this resource was created in seconds since unix epoch |  [optional]
**id** | **Long** | The unique ID for that resource |  [optional]
**leaderboardStrategy** | **String** | The strategy for calculating the leaderboard. Defaults to highest score. Value MUST come from the list of available strategies from the Leaderboard Service |  [optional]
**longDescription** | **String** | The user friendly name of that resource. Defaults to blank string |  [optional]
**name** | **String** | The user friendly name of that resource | 
**nextChallenge** | **String** | The name of the next challenge coming up |  [optional]
**nextChallengeDate** | **Long** | The date/time of the next challenge coming up |  [optional]
**rewardSet** | [**RewardSetResource**](RewardSetResource.md) | The rewards to give at the end of the campaign. When creating/updating only id is used. Reward set must be pre-existing |  [optional]
**rewardStatus** | [**RewardStatusEnum**](#RewardStatusEnum) | Indicate if the rewards have been given out already |  [optional]
**shortDescription** | **String** | The user friendly name of that resource. Defaults to blank string |  [optional]
**template** | **String** | A campaign template this campaign is validated against (private). May be null and no validation of additional_properties will be done |  [optional]
**updatedDate** | **Long** | The date/time this resource was last updated in seconds since unix epoch |  [optional]


<a name="RewardStatusEnum"></a>
## Enum: RewardStatusEnum
Name | Value
---- | -----



