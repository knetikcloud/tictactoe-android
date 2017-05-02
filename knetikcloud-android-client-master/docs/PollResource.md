
# PollResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**active** | **Boolean** | Whether the poll is active | 
**additionalProperties** | [**Map&lt;String, Property&gt;**](Property.md) | A map of additional properties, keyed on the property name.  Must match the names and types defined in the template for this item type |  [optional]
**answers** | [**List&lt;PollAnswerResource&gt;**](PollAnswerResource.md) | The answers to the poll | 
**category** | [**NestedCategory**](NestedCategory.md) | The category for the poll | 
**createdDate** | **Long** | The date/time this resource was created in seconds since unix epoch |  [optional]
**id** | **String** | The id of the poll |  [optional]
**tags** | **List&lt;String&gt;** | The tags for the poll |  [optional]
**template** | **String** | A poll template this poll is validated against (private). May be null and no validation of additional_properties will be done |  [optional]
**text** | **String** | The text of the poll | 
**type** | [**TypeEnum**](#TypeEnum) | The media type of the poll | 
**updatedDate** | **Long** | The date/time this resource was last updated in seconds since unix epoch |  [optional]


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----



