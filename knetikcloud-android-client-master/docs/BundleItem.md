
# BundleItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**additionalProperties** | [**Map&lt;String, Property&gt;**](Property.md) | A map of additional properties, keyed on the property name.  Must match the names and types defined in the template for this item type, or be an extra not from the template |  [optional]
**behaviors** | [**List&lt;Behavior&gt;**](Behavior.md) | The behaviors linked to the item, describing various options and interactions. May not be included in item lists |  [optional]
**bundledSkus** | [**List&lt;BundledSku&gt;**](BundledSku.md) | The skus of items to be included in this bundle, and how they influence the bundle total price.  Must have at least one SKU | 
**category** | **String** | A category for filtering items |  [optional]
**createdDate** | **Long** | The date the item was created, unix timestamp in seconds |  [optional]
**displayable** | **Boolean** | Whether or not the item is currently displayable.  Default &#x3D; true |  [optional]
**geoCountryList** | **List&lt;String&gt;** | A list of country ID to include in the blacklist/whitelist geo policy |  [optional]
**geoPolicyType** | [**GeoPolicyTypeEnum**](#GeoPolicyTypeEnum) | Whether to use the geo_country_list as a black list or white list for item geographical availability |  [optional]
**id** | **Integer** | The id of the item |  [optional]
**longDescription** | **String** | A long description of the item |  [optional]
**name** | **String** | The name of the item | 
**shippingTier** | **Integer** | Provides the abstract shipping needs if this item is physical and can be shipped.  A value of zero means no shipping needed.  Default &#x3D; 0 |  [optional]
**shortDescription** | **String** | A short description of the item, max 255 chars |  [optional]
**skus** | [**List&lt;Sku&gt;**](Sku.md) | The skus for the item. Each defines a unique configuration for the item to be purchased (Large-Blue, Small-Green, etc). These are what is ultimately selected in the store and added to the cart | 
**sort** | **Integer** | A number to use in sorting items.  Default 500 |  [optional]
**storeEnd** | **Long** | The date the item will leave the store, unix timestamp in seconds.  If set to null, item will never leave the store |  [optional]
**storeStart** | **Long** | The date the item will appear in the store, unix timestamp in seconds.  If set to null, item will appear in store immediately |  [optional]
**tags** | **List&lt;String&gt;** | List of tags used for filtering items |  [optional]
**template** | **String** | An item template this item is validated against.  May be null and no validation of additional_properties will be done.  Default &#x3D; null |  [optional]
**typeHint** | **String** | The type of the item | 
**uniqueKey** | **String** | The unique key for the item |  [optional]
**updatedDate** | **Long** | The date the item was last updated, unix timestamp in seconds |  [optional]
**vendorId** | **Integer** | The vendor who provides the item | 


<a name="GeoPolicyTypeEnum"></a>
## Enum: GeoPolicyTypeEnum
Name | Value
---- | -----



