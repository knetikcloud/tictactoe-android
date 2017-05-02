
# RewardCurrencyResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**currencyCode** | **String** | The code of the currency type to give | 
**currencyName** | **String** | The name of the currency reward to give.  Set by currency_code) |  [optional]
**maxRank** | **Integer** | The highest number (worst) rank to give the reward to. Must be greater than or equal to minRank | 
**minRank** | **Integer** | The lowest number (best) rank to give the reward to. Must be greater than zero | 
**percent** | **Boolean** | True if the value is actually a percentage of the intake | 
**value** | **Double** | The amount of currency to give. For percentage values, 0.5 is 50% | 



