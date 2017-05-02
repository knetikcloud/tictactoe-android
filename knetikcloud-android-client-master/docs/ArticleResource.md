
# ArticleResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**active** | **Boolean** | Whether the article is active | 
**additionalProperties** | [**Map&lt;String, Property&gt;**](Property.md) | A map of additional properties, keyed on the property name.  Must match the names and types defined in the template for this item type |  [optional]
**body** | **String** | The body of the article | 
**category** | [**NestedCategory**](NestedCategory.md) | The category for the article | 
**createdDate** | **Long** | The date/time this resource was created in seconds since unix epoch |  [optional]
**id** | **String** | The id of the article |  [optional]
**tags** | **List&lt;String&gt;** | The tags for the article |  [optional]
**template** | **String** | An article template this article is validated against (private). May be null and no validation of additional_properties will be done |  [optional]
**title** | **String** | The title of the article | 
**updatedDate** | **Long** | The date/time this resource was last updated in seconds since unix epoch |  [optional]



