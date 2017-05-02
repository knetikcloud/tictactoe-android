
# UserActivityResultsResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**currencyRewards** | [**List&lt;RewardCurrencyResource&gt;**](RewardCurrencyResource.md) | Any currency rewarded to this user |  [optional]
**itemRewards** | [**List&lt;RewardItemResource&gt;**](RewardItemResource.md) | Any items rewarded to this user |  [optional]
**rank** | **Long** | The position of the user in the leaderboard. Null means non-compete or disqualification |  [optional]
**score** | **Long** | The raw score in this leaderboard. Null means non-compete or disqualification |  [optional]
**tags** | **List&lt;String&gt;** | Any tags for the metric. Each unique tag will translate into a unique leaderboard. Maximum 5 tags and 50 characters each |  [optional]
**ties** | **Integer** | The number of users tied at this rank, including this user. 1 means no tie |  [optional]
**user** | [**SimpleUserResource**](SimpleUserResource.md) | The player for this entry | 



