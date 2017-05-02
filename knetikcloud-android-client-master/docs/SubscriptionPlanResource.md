
# SubscriptionPlanResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**additionalProperties** | [**Map&lt;String, Property&gt;**](Property.md) | A map of additional properties, keyed on the property name.  Must match the names and types defined in the template for this subscription |  [optional]
**billingCycleLength** | **Integer** | The length of the billing cycle in number of billing cycle unit | 
**billingCycleUnit** | [**BillingCycleUnitEnum**](#BillingCycleUnitEnum) | The time period unit to apply to the length of billing cycles | 
**consolidated** | **Boolean** | Whether this plan will be renewed on the consolidated billing cycle | 
**currencyCode** | **String** | The ISO3 currency code to use for the fees | 
**endDate** | **Long** | Used to schedule plan availability end date |  [optional]
**firstBillingCycleLength** | **Integer** | Optional override for the length of the first billing cycle before the first recurring billing |  [optional]
**firstBillingCycleUnit** | [**FirstBillingCycleUnitEnum**](#FirstBillingCycleUnitEnum) | The time period unit to apply to the length of the first billing cycle. Required when first_billing_cycle_length is specified |  [optional]
**gracePeriod** | **Integer** | The number of late payment days before a subscription is canceled | 
**id** | **String** | The id of the plan used to generate the SKUs |  [optional]
**initialFee** | **Double** | The fee charged when the subscription is purchased | 
**initialSku** | **String** | The SKU to be used when purchasing the subscription through the cart |  [optional]
**latePaymentFee** | **Double** | The fee to add to the bill when an invoice has gone unpaid passed the grace period | 
**latePaymentSku** | **String** | The SKU that will show on the invoice when the subscription is delinquent |  [optional]
**locked** | **Boolean** | Whether this plan is locked because it has been purchased by at least one user.  When locked, a number of properties can no longer be changed |  [optional]
**maxBillAttempts** | **Integer** | The number of charge attempts before the subscription becomes delinquent | 
**maxCycles** | **Integer** | Maximum number of renewals. If a migration plan is provided, the subscription will automatically switch to it when this limit is reached |  [optional]
**migrateToPlan** | **String** | Automatically migrate to the specified plan when the subscription is first renewed |  [optional]
**minCycles** | **Integer** | The minimum number of renewals to charge for |  [optional]
**name** | **String** | The name of the plan used to generate the SKUs | 
**published** | **Boolean** | Whether this plan is currently available | 
**reactivationFee** | **Double** | The fee to charge when a suspended subscription is to be re-activated | 
**reactivationSku** | **String** | The SKU that will show on the invoice when the subscription is re-activated after a suspension |  [optional]
**recurringFee** | **Double** | The recurring fee to charge for each renewal | 
**recurringSku** | **String** | The SKU that will show on the invoice when the subscription is activated |  [optional]
**startDate** | **Long** | Used to schedule plan availability start date |  [optional]


<a name="BillingCycleUnitEnum"></a>
## Enum: BillingCycleUnitEnum
Name | Value
---- | -----


<a name="FirstBillingCycleUnitEnum"></a>
## Enum: FirstBillingCycleUnitEnum
Name | Value
---- | -----



