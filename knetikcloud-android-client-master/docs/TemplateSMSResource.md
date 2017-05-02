
# TemplateSMSResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**from** | **String** | The phone number to attribute the outgoing message to. Optional if the config text.out_number is set. |  [optional]
**localizer** | [**Localizer**](Localizer.md) |  |  [optional]
**recipients** | **List&lt;Integer&gt;** | A list of user ids to send the message to. | 
**templateKey** | **String** | The key for the template. | 
**templateVars** | **List&lt;String&gt;** | A list of values to fill in the template. Order matters. |  [optional]



