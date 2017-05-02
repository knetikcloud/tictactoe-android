
# CategoryResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**active** | **Boolean** | Whether the category is currently active. If not, it and its questions will be filtered out. |  [optional]
**additionalProperties** | [**Map&lt;String, Property&gt;**](Property.md) | A map of additional properties, keyed on the property name.  Must match the names and types defined in the template for this item type |  [optional]
**id** | **String** | The unique ID for this category |  [optional]
**name** | **String** | The name of this category. Cannot be blank | 
**template** | **String** | A category template this category is validated against (private). May be null and no validation of additional_properties will be done |  [optional]



