# BRERuleEngineRulesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createBRERule**](BRERuleEngineRulesApi.md#createBRERule) | **POST** /bre/rules | Create a rule
[**deleteBRERule**](BRERuleEngineRulesApi.md#deleteBRERule) | **DELETE** /bre/rules/{id} | Delete a rule
[**getBREExpressionAsString**](BRERuleEngineRulesApi.md#getBREExpressionAsString) | **POST** /bre/rules/expression-as-string | Returns a string representation of the provided expression
[**getBRERule**](BRERuleEngineRulesApi.md#getBRERule) | **GET** /bre/rules/{id} | Get a single rule
[**getBRERules**](BRERuleEngineRulesApi.md#getBRERules) | **GET** /bre/rules | List rules
[**setBRERule**](BRERuleEngineRulesApi.md#setBRERule) | **PUT** /bre/rules/{id}/enabled | Enable or disable a rule
[**updateBRERule**](BRERuleEngineRulesApi.md#updateBRERule) | **PUT** /bre/rules/{id} | Update a rule


<a name="createBRERule"></a>
# **createBRERule**
> BreRule createBRERule(breRule)

Create a rule

Rules define which actions to run when a given event verifies the specified conditions. Conditions and actions are defined by binding event or context parameters to arguments. Conditions also known as Predicates are logical expressions that result in a boolean. Operators are used to describe rules between arguments to form that condition. There are 3 families of operators: Boolean, Math and String. Math and String operators are functions that transform arguments into numbers or strings...&lt;h1&gt;Boolean Operators&lt;/h1&gt;&lt;br /&gt;&lt;br /&gt;1 arg:&lt;br /&gt;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&lt;br /&gt;&lt;br /&gt;&lt;ul&gt; &lt;li&gt;IS_NULL&lt;/li&gt; &lt;li&gt;IS_NOT_NULL&lt;/li&gt; &lt;li&gt;STRING_IS_EMPTY&lt;/li&gt; &lt;li&gt;NOT &lt;/li&gt; &lt;li&gt;MAP_IS_EMPTY&lt;/li&gt;&lt;/ul&gt;&lt;br /&gt;2 args:&lt;br /&gt;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&lt;br /&gt;&lt;br /&gt;&lt;ul&gt; &lt;li&gt;EQ&lt;/li&gt; &lt;li&gt;NE (Not Equals)&lt;/li&gt; &lt;li&gt;GT (Greater Than)&lt;/li&gt; &lt;li&gt;GOE (Greater Or Equals)&lt;/li&gt; &lt;li&gt;LT (Lesser Than)&lt;/li&gt; &lt;li&gt;LOE (Lesser Or Equals)&lt;/li&gt; &lt;li&gt;OR&lt;/li&gt; &lt;li&gt;AND&lt;/li&gt; &lt;li&gt;XNOR&lt;/li&gt; &lt;li&gt;XOR&lt;/li&gt; &lt;li&gt;CONTAINS_KEY (for maps only)&lt;/li&gt; &lt;li&gt;CONTAINS_VALUE (for maps only)&lt;/li&gt; &lt;li&gt;MATCHES (regex)&lt;/li&gt; &lt;li&gt;MATCHES_IC (regex ignore case)&lt;/li&gt; &lt;li&gt;STARTS_WITH&lt;/li&gt; &lt;li&gt;STARTS_WITH_IC&lt;/li&gt; &lt;li&gt;EQ_IGNORE_CASE&lt;/li&gt; &lt;li&gt;ENDS_WITH&lt;/li&gt; &lt;li&gt;ENDS_WITH_IC&lt;/li&gt; &lt;li&gt;STRING_CONTAINS&lt;/li&gt; &lt;li&gt;STRING_CONTAINS_IC&lt;/li&gt; &lt;li&gt;LIKE (SQL like)&lt;/li&gt;&lt;/ul&gt;&lt;br /&gt;3 args exceptions:&lt;br /&gt;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&lt;br /&gt;&lt;br /&gt;&lt;ul&gt; &lt;li&gt;BETWEEN&lt;/li&gt;&lt;/ul&gt;&lt;br /&gt;n args:&lt;br /&gt;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&lt;br /&gt;&lt;br /&gt;&lt;ul&gt; &lt;li&gt;IN&lt;/li&gt; &lt;li&gt;NOT_INT&lt;/li&gt;&lt;/ul&gt;&lt;h1&gt;Math Operators&lt;/h1&gt;1 arg:&lt;br /&gt;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&lt;br /&gt;&lt;br /&gt;&lt;ul&gt; &lt;li&gt;NEGATE&lt;/li&gt; &lt;li&gt;MAP_SIZE&lt;/li&gt; &lt;li&gt;STRING_LENGTH&lt;/li&gt; &lt;li&gt;CEIL&lt;/li&gt; &lt;li&gt;ABS&lt;/li&gt; &lt;li&gt;FLOOR&lt;/li&gt; &lt;li&gt;ROUND&lt;/li&gt; &lt;li&gt;RANDOM (no arg)&lt;/li&gt; &lt;li&gt;RANDOM2 (seed arg)&lt;/li&gt; &lt;li&gt;NUMCAST&lt;/li&gt; &lt;li&gt;HOUR&lt;/li&gt; &lt;li&gt;MINUTE&lt;/li&gt; &lt;li&gt;SECOND&lt;/li&gt; &lt;li&gt;MILLISECOND&lt;/li&gt; &lt;li&gt;YEAR&lt;/li&gt; &lt;li&gt;WEEK&lt;/li&gt; &lt;li&gt;YEAR_MONTH&lt;/li&gt; &lt;li&gt;YEAR_WEEK&lt;/li&gt; &lt;li&gt;DAY_OF_WEEK&lt;/li&gt; &lt;li&gt;DAY_OF_MONTH&lt;/li&gt; &lt;li&gt;DAY_OF_YEAR&lt;/li&gt; &lt;li&gt;WEEK&lt;/li&gt; &lt;li&gt;WEEK&lt;/li&gt; &lt;li&gt;WEEK&lt;/li&gt;&lt;/ul&gt;&lt;br /&gt;&lt;br /&gt;2 args:&lt;br /&gt;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&lt;br /&gt;&lt;br /&gt;&lt;ul&gt; &lt;li&gt;ADD&lt;/li&gt; &lt;li&gt;DIV&lt;/li&gt; &lt;li&gt;MULT&lt;/li&gt; &lt;li&gt;SUB&lt;/li&gt; &lt;li&gt;POWER&lt;/li&gt; &lt;li&gt;MOD&lt;/li&gt; &lt;li&gt;LOCATE (index of (string, char))&lt;/li&gt; &lt;li&gt;DIFF_YEARS&lt;/li&gt; &lt;li&gt;DIFF_MONTHS&lt;/li&gt; &lt;li&gt;DIFF_WEEKS&lt;/li&gt; &lt;li&gt;DIFF_DAYS&lt;/li&gt; &lt;li&gt;DIFF_HOURS&lt;/li&gt; &lt;li&gt;DIFF_MINUTES&lt;/li&gt; &lt;li&gt;DIFF_SECONDS&lt;/li&gt;&lt;/ul&gt;&lt;br /&gt;&lt;br /&gt;2 args:&lt;br /&gt;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&lt;br /&gt;&lt;br /&gt;&lt;ul&gt; &lt;li&gt;MIN&lt;/li&gt; &lt;li&gt;MAX&lt;/li&gt;&lt;/ul&gt;&lt;h1&gt;String Operators&lt;/h1&gt;0 arg:&lt;br /&gt;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&lt;br /&gt;&lt;br /&gt;&lt;ul&gt; &lt;li&gt;CURRENT_TIME&lt;/li&gt;&lt;/ul&gt;&lt;br /&gt;&lt;br /&gt;1 arg:&lt;br /&gt;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&lt;br /&gt;&lt;br /&gt;&lt;ul&gt; &lt;li&gt;CURRENT_TIME&lt;/li&gt; &lt;li&gt;LOWER&lt;/li&gt; &lt;li&gt;UPPER&lt;/li&gt; &lt;li&gt;TRIM&lt;/li&gt; &lt;li&gt;STRING_CAST&lt;/li&gt;&lt;/ul&gt;&lt;br /&gt;&lt;br /&gt;2 args:&lt;br /&gt;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&lt;br /&gt;&lt;br /&gt;&lt;ul&gt; &lt;li&gt;CHAR_AT&lt;/li&gt; &lt;li&gt;SUBSTR_1ARG (substr(string, start))&lt;/li&gt; &lt;li&gt;CONCAT&lt;/li&gt; &lt;li&gt;TRIM&lt;/li&gt; &lt;li&gt;STRING_CAST&lt;/li&gt;&lt;/ul&gt;&lt;br /&gt;&lt;br /&gt;3 args:&lt;br /&gt;&#x3D;&#x3D;&#x3D;&#x3D;&#x3D;&lt;br /&gt;&lt;br /&gt;&lt;ul&gt; &lt;li&gt;SUBSTR_2ARGS (substr(string, start, length))&lt;/li&gt;&lt;/ul&gt;

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineRulesApi;

BRERuleEngineRulesApi apiInstance = new BRERuleEngineRulesApi();
BreRule breRule = new BreRule(); // BreRule | The BRE rule object
try {
    BreRule result = apiInstance.createBRERule(breRule);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineRulesApi#createBRERule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **breRule** | [**BreRule**](BreRule.md)| The BRE rule object | [optional]

### Return type

[**BreRule**](BreRule.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteBRERule"></a>
# **deleteBRERule**
> deleteBRERule(id)

Delete a rule

May fail if there are existing rules against it. Cannot delete core rules

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineRulesApi;

BRERuleEngineRulesApi apiInstance = new BRERuleEngineRulesApi();
String id = "id_example"; // String | The id of the rule
try {
    apiInstance.deleteBRERule(id);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineRulesApi#deleteBRERule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the rule |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getBREExpressionAsString"></a>
# **getBREExpressionAsString**
> String getBREExpressionAsString(expression)

Returns a string representation of the provided expression

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineRulesApi;

BRERuleEngineRulesApi apiInstance = new BRERuleEngineRulesApi();
Expressionobject expression = new Expressionobject(); // Expressionobject | The expression
try {
    String result = apiInstance.getBREExpressionAsString(expression);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineRulesApi#getBREExpressionAsString");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **expression** | [**Expressionobject**](Expressionobject.md)| The expression | [optional]

### Return type

**String**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getBRERule"></a>
# **getBRERule**
> BreRule getBRERule(id)

Get a single rule

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineRulesApi;

BRERuleEngineRulesApi apiInstance = new BRERuleEngineRulesApi();
String id = "id_example"; // String | The id of the rule
try {
    BreRule result = apiInstance.getBRERule(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineRulesApi#getBRERule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the rule |

### Return type

[**BreRule**](BreRule.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getBRERules"></a>
# **getBRERules**
> PageResourceBreRule getBRERules(filterName, filterEnabled, filterSystem, filterTrigger, filterAction, filterCondition, size, page)

List rules

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineRulesApi;

BRERuleEngineRulesApi apiInstance = new BRERuleEngineRulesApi();
String filterName = "filterName_example"; // String | Filter for rules containing the given name
Boolean filterEnabled = null; // Boolean | Filter for rules by active status, null for both
Boolean filterSystem = true; // Boolean | Filter for rules that are system rules when true, or not when false. Leave off for both mixed
String filterTrigger = "filterTrigger_example"; // String | Filter for rules that are for the trigger with the given name
String filterAction = "filterAction_example"; // String | Filter for rules that use the action with the given name
String filterCondition = "filterCondition_example"; // String | Filter for rules that have a condition containing the given string
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
try {
    PageResourceBreRule result = apiInstance.getBRERules(filterName, filterEnabled, filterSystem, filterTrigger, filterAction, filterCondition, size, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineRulesApi#getBRERules");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterName** | **String**| Filter for rules containing the given name | [optional]
 **filterEnabled** | **Boolean**| Filter for rules by active status, null for both | [optional] [default to null]
 **filterSystem** | **Boolean**| Filter for rules that are system rules when true, or not when false. Leave off for both mixed | [optional]
 **filterTrigger** | **String**| Filter for rules that are for the trigger with the given name | [optional]
 **filterAction** | **String**| Filter for rules that use the action with the given name | [optional]
 **filterCondition** | **String**| Filter for rules that have a condition containing the given string | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]

### Return type

[**PageResourceBreRule**](PageResourceBreRule.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setBRERule"></a>
# **setBRERule**
> setBRERule(id, enabled)

Enable or disable a rule

This is helpful for turning off systems rules which cannot be deleted or modified otherwise

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineRulesApi;

BRERuleEngineRulesApi apiInstance = new BRERuleEngineRulesApi();
String id = "id_example"; // String | The id of the rule
BooleanResource enabled = new BooleanResource(); // BooleanResource | The boolean value
try {
    apiInstance.setBRERule(id, enabled);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineRulesApi#setBRERule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the rule |
 **enabled** | [**BooleanResource**](BooleanResource.md)| The boolean value | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateBRERule"></a>
# **updateBRERule**
> BreRule updateBRERule(id, breRule)

Update a rule

Cannot update system rules

### Example
```java
// Import classes:
//import com.knetikcloud.api.BRERuleEngineRulesApi;

BRERuleEngineRulesApi apiInstance = new BRERuleEngineRulesApi();
String id = "id_example"; // String | The id of the rule
BreRule breRule = new BreRule(); // BreRule | The BRE rule object
try {
    BreRule result = apiInstance.updateBRERule(id, breRule);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BRERuleEngineRulesApi#updateBRERule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the rule |
 **breRule** | [**BreRule**](BreRule.md)| The BRE rule object | [optional]

### Return type

[**BreRule**](BreRule.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

