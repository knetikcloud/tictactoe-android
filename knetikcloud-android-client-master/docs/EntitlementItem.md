
# EntitlementItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**additionalProperties** | [**Map&lt;String, Property&gt;**](Property.md) | A map of additional properties, keyed on the property name.  Must match the names and types defined in the template for this item type, or be an extra not from the template |  [optional]
**behaviors** | [**List&lt;Behavior&gt;**](Behavior.md) | The behaviors linked to the item, describing various options and interactions. May not be included in item lists |  [optional]
**category** | **String** | A category for filtering items |  [optional]
**createdDate** | **Long** | The date the item was created, unix timestamp in seconds |  [optional]
**id** | **Integer** | The id of the item |  [optional]
**longDescription** | **String** | A long description of the item |  [optional]
**name** | **String** | The name of the item | 
**shortDescription** | **String** | A short description of the item, max 255 chars |  [optional]
**sort** | **Integer** | A number to use in sorting items.  Default 500 |  [optional]
**tags** | **List&lt;String&gt;** | List of tags used for filtering items |  [optional]
**template** | **String** | An item template this item is validated against.  May be null and no validation of additional_properties will be done.  Default &#x3D; null |  [optional]
**typeHint** | **String** | The type of the item | 
**uniqueKey** | **String** | The unique key for the item |  [optional]
**updatedDate** | **Long** | The date the item was last updated, unix timestamp in seconds |  [optional]



