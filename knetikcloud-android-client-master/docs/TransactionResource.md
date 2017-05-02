
# TransactionResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createDate** | **Long** | The unix timestamp in seconds of the transaction |  [optional]
**currencyCode** | **String** | The code of the currency for the transaction |  [optional]
**details** | **String** | The specific details of the transaction, such as a message from the admin that created it |  [optional]
**id** | **Integer** | The id of the transaction |  [optional]
**invoiceId** | **Integer** | The id of the invoice that spawned the transaction, if any |  [optional]
**isRefunded** | **Boolean** | Whether the transaction has been refunded |  [optional]
**response** | **String** | The response |  [optional]
**source** | [**SourceEnum**](#SourceEnum) | The root source of the transaction |  [optional]
**successful** | **Boolean** | If the transaction was successful |  [optional]
**transactionId** | **String** | The payment gateway (external) transaction ID |  [optional]
**type** | **String** | The general type of the transaction |  [optional]
**typeHint** | **String** | The table name of the subclass |  [optional]
**value** | **Double** | The amount of the transaction, positive if a gain, negative if an expenditure |  [optional]


<a name="SourceEnum"></a>
## Enum: SourceEnum
Name | Value
---- | -----



