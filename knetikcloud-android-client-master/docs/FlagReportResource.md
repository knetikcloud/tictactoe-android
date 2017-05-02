
# FlagReportResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**context** | **String** | The context of that resource  |  [optional]
**contextId** | **String** | The context ID of that resource |  [optional]
**createdDate** | **Long** | The date/time this resource was created in seconds since epoch |  [optional]
**id** | **Long** | The unique ID for that resource |  [optional]
**reason** | **String** | The reason of that resource required only in case of active resolution |  [optional]
**resolution** | [**ResolutionEnum**](#ResolutionEnum) | The resolution of that resource | 
**resolved** | **Long** | The date/time this report was resolved in seconds since epoch. Null if not resolved yet |  [optional]
**updatedDate** | **Long** | The date/time this resource was last updated in seconds since epoch |  [optional]


<a name="ResolutionEnum"></a>
## Enum: ResolutionEnum
Name | Value
---- | -----



