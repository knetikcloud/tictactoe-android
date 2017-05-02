
# PropertyFieldResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | A description of the field |  [optional]
**innerType** | [**InnerTypeEnum**](#InnerTypeEnum) | The type of values within a &#39;list&#39; type field |  [optional]
**innerTypeFields** | [**List&lt;PropertyFieldResource&gt;**](PropertyFieldResource.md) | A description of fields within objects within a &#39;list&#39; type field, when inner_type is &#39;object&#39; |  [optional]
**name** | **String** | The name of the field |  [optional]
**required** | **Boolean** | Whether the field is required |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | The type of the field |  [optional]
**validValues** | **List&lt;String&gt;** | A list of valid values for &#39;enum&#39; type fields |  [optional]


<a name="InnerTypeEnum"></a>
## Enum: InnerTypeEnum
Name | Value
---- | -----


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----



