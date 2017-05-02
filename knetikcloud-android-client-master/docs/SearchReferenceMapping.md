
# SearchReferenceMapping

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier for the mapping to protect against duplicates | 
**refIdField** | **String** | The field within the type that contains the id from the refType | 
**refType** | **String** | The index type that the mapping pulls data from | 
**sourceFieldToDestinationField** | **Map&lt;String, String&gt;** | A map whose keys are the field names in the refType and values are the field name in the type | 
**type** | **String** | The index type that the mapping is for | 



