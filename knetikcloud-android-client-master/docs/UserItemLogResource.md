
# UserItemLogResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | The log entry id |  [optional]
**info** | **String** | Additional information defined by the type |  [optional]
**item** | [**SimpleReferenceResourceint**](SimpleReferenceResourceint.md) | The item interacted with |  [optional]
**logDate** | **Long** | The date/time this event occurred in seconds since epoch |  [optional]
**type** | **String** | The type of event |  [optional]
**user** | [**SimpleUserResource**](SimpleUserResource.md) | The user making the interaction |  [optional]
**userInventory** | **Integer** | The id of the inventory entry this event is related to, if any |  [optional]



