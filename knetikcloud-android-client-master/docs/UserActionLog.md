
# UserActionLog

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**actionDescription** | **String** | A description of the action taken | 
**actionName** | **String** | The name of the action taken | 
**createdDate** | **Long** | The date of the action, unix timestamp in seconds |  [optional]
**details** | **Map&lt;String, String&gt;** | A map of additional details such as the target of the action |  [optional]
**id** | **String** | The id of the log entry |  [optional]
**requestId** | **String** | The id of the api request that spawned the action, if generated internally |  [optional]
**userId** | **Integer** | The id of the user that took the action, if any. Read-only if not posting with LOGS_ADMIN |  [optional]



