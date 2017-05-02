
# BreGlobalResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | A human readable description for display in admin pages |  [optional]
**id** | **String** | The id of the global definition. Default is a random guid. Cannot be updated |  [optional]
**key** | **String** | The key for the global. Must be unique when combined with scope names. Usually a single descriptive word like &#39;purchases&#39; or &#39;logins&#39; | 
**name** | **String** | A human readable name for display in admin pages |  [optional]
**scopes** | [**List&lt;BreGlobalScopeDefinition&gt;**](BreGlobalScopeDefinition.md) | A list of scoping parameters. Allows the global to have a different value in different context such as a count of purchases for each user (by putting a &#39;user&#39; scope in this list). When using this global in a rule these scopes will need to be mapped with an expression to provide a value, similar to the parameters in an action |  [optional]
**systemGlobal** | **Boolean** | Where this global came from. System globals cannot be removed or updated |  [optional]
**type** | **String** | The variable type the global stores. See the See Bre Variables enpoint for list | 



