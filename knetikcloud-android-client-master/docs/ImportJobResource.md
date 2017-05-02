
# ImportJobResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**categoryId** | **String** | The id of the category to assign all questions in the import to | 
**createdDate** | **Long** | The date the job was created in seconds since unix epoc |  [optional]
**id** | **Long** | The id of the job |  [optional]
**name** | **String** | A name for this import for later reference | 
**output** | [**List&lt;ImportJobOutputResource&gt;**](ImportJobOutputResource.md) | Error information from validation |  [optional]
**recordCount** | **Long** | The number of questions form the CSV file. Filled in after validation |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the job |  [optional]
**updatedDate** | **Long** | The date the job was last updated in seconds since unix epoc |  [optional]
**url** | **String** | The url of a CSV file to pull trivia questions from. Cannot be changed after initial POST | 
**vendor** | **String** | The vendor who supplied this set of questions | 


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----



