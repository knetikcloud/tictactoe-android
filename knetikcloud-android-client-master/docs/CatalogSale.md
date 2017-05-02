
# CatalogSale

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**currencyCode** | **String** | The iso3 code for the currency for this discountValue.  The sku purchased will have to match for it this sale to apply | 
**discountType** | [**DiscountTypeEnum**](#DiscountTypeEnum) | The way in which the price is reduced. &#39;value&#39; means subtracting directly, &#39;percentage&#39; means subtracting by the price times the discountValue (1.0 &#x3D;&#x3D; 100%) | 
**discountValue** | **Double** | The amount deducted from the price, in the same currencyCode as the item |  [optional]
**id** | **Integer** | The id of the sale |  [optional]
**item** | **Integer** | The id of the item this sale applies to.  Leave null to use other filters |  [optional]
**longDescription** | **String** | The long description of the sale |  [optional]
**name** | **String** | The name of the sale.  Max 40 characters | 
**saleEndDate** | **Long** | The date the sale ends, null for never.  Unix timestamp in seconds |  [optional]
**saleStartDate** | **Long** | The date the sale begins.  Unix timestamp in seconds | 
**shortDescription** | **String** | The short description of the sale.  Max 140 characters |  [optional]
**tag** | **String** | The tag this sale applies to.  Leave null to skip this filter (applies to all tags) |  [optional]
**vendor** | **Integer** | The id of the vendor this sale applies to.  Leave null to skip this filter (applies to all vendors) |  [optional]


<a name="DiscountTypeEnum"></a>
## Enum: DiscountTypeEnum
Name | Value
---- | -----



