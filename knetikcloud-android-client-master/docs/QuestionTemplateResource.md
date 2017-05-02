
# QuestionTemplateResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**answerProperty** | [**PropertyDefinitionResource**](PropertyDefinitionResource.md) | A property definition for all answers. If included each answer must match this definition&#39;s type and be valid |  [optional]
**createdDate** | **Long** | The date/time this resource was created in seconds since unix epoch |  [optional]
**id** | **String** | The id of the template |  [optional]
**name** | **String** | The name of the template | 
**properties** | [**List&lt;PropertyDefinitionResource&gt;**](PropertyDefinitionResource.md) | The customized properties that are present |  [optional]
**questionProperty** | [**PropertyDefinitionResource**](PropertyDefinitionResource.md) | A property definition for the question itself. If included the answer must match this definition&#39;s type and be valid |  [optional]
**updatedDate** | **Long** | The date/time this resource was last updated in seconds since unix epoch |  [optional]



