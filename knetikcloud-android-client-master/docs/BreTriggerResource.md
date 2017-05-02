
# BreTriggerResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category** | [**CategoryEnum**](#CategoryEnum) | The category this trigger belongs to. See endpoints for related asset information. All new triggers are in category &#39;custom&#39; |  [optional]
**eventName** | **String** | The unique name for the event. This serves as the unique identifier. Cannot be changed after creation | 
**parameters** | [**List&lt;BreTriggerParameterDefinition&gt;**](BreTriggerParameterDefinition.md) | A list af parameters that will be sent with the event when the trigger is fired. These must be included in the event and match the described types |  [optional]
**systemTrigger** | **Boolean** | Where this trigger came from. System triggers cannot be removed or updated |  [optional]
**triggerDescription** | **String** | A description of the trigger | 
**triggerName** | **String** | A human readable name for this trigger | 


<a name="CategoryEnum"></a>
## Enum: CategoryEnum
Name | Value
---- | -----



