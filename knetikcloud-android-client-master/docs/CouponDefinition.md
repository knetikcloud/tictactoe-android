
# CouponDefinition

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | **String** | A unique identifier for the discount. Can be used to remove the discount, and uniqueness within the cart will be enforced. | 
**description** | **String** | A description for the discount. |  [optional]
**discountType** | [**DiscountTypeEnum**](#DiscountTypeEnum) | The type of discount in terms of how it deducts price. | 
**exclusive** | **Boolean** | Whether this discount is exclusive and cannot be used in conjunction with other discounts/coupons. default&#x3D;false |  [optional]
**maxDiscount** | **Double** | For coupon_cart, a minimum total price that the cart must meet to be valid. |  [optional]
**maxQuantity** | **Integer** | The maximum number of items to count this discount for (not for cart_coupon). |  [optional]
**minCartTotal** | **Double** | For coupon_cart, a minimum total price that the cart must meet to be valid. |  [optional]
**name** | **String** | A name for the discount. | 
**selfExclusive** | **Boolean** | Whether this coupon is exclusive to itself or not (true means cannot add two of this same coupon to the same cart).  Default &#x3D; false |  [optional]
**targetItemId** | **Integer** | The id of the item this discount applies to, which must be present in the cart. Applies if coupon_type_hint is coupon_single_item or coupon_voucher. |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | The type of discount in terms of what it applies to. coupon_cart applies to the cart as a whole, other types apply to specific items based on different criteria. | 
**uniqueKey** | **String** | A unique identifier string for the discount. | 
**validForTags** | **List&lt;String&gt;** | Which tags this applies for (item must have at least one of them), if coupon_type is coupon_tag. |  [optional]
**value** | **Double** | The amount of the discount. If discount_type is value then this is the raw currency amount to remove. If discount_type is percentage then this will be multiplied by the cart total or item price to get the discount amount (0.5 is half price). | 
**vendorId** | **Integer** | Which vendor this applies for, if coupon_type is coupon_vendor. |  [optional]


<a name="DiscountTypeEnum"></a>
## Enum: DiscountTypeEnum
Name | Value
---- | -----


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----



