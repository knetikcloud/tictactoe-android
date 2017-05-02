
# QuestionResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**additionalProperties** | [**Map&lt;String, Property&gt;**](Property.md) | A map of additional properties, keyed on the property name.  Must match the names and types defined in the template for this item type |  [optional]
**answers** | [**List&lt;AnswerResource&gt;**](AnswerResource.md) | The list of available answers |  [optional]
**category** | [**NestedCategory**](NestedCategory.md) | The category for the question | 
**createdDate** | **Long** | The date/time this resource was created in seconds since unix epoch |  [optional]
**difficulty** | **Integer** | The difficulty of the question | 
**id** | **String** | The unique ID for that resource |  [optional]
**importId** | **Long** | The id of the import job that created the question, or null if not from an import |  [optional]
**publishedDate** | **Long** | When the question becomes available, null for never, in seconds since epoch |  [optional]
**question** | [**Property**](Property.md) | The question. Different &#39;type&#39; values indicate different structures as the question may be test, image, etc. See information on additional properties for the list and their structures | 
**source1** | **String** | The first source of the question |  [optional]
**source2** | **String** | The second source of the question |  [optional]
**tags** | **List&lt;String&gt;** | The list of tags |  [optional]
**template** | **String** | A question template this question is validated against (private). May be null and no validation of additional_properties will be done |  [optional]
**updatedDate** | **Long** | The date/time this resource was last updated in seconds since unix epoch |  [optional]
**vendor** | **String** | The supplier of the question |  [optional]



