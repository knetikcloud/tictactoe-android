# ReportingChallengesApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getChallengeEventLeaderboard**](ReportingChallengesApi.md#getChallengeEventLeaderboard) | **GET** /reporting/events/leaderboard | Retrieve a challenge event leaderboard details
[**getChallengeEventParticipants**](ReportingChallengesApi.md#getChallengeEventParticipants) | **GET** /reporting/events/participants | Retrieve a challenge event participant details


<a name="getChallengeEventLeaderboard"></a>
# **getChallengeEventLeaderboard**
> PageResourceChallengeEventParticipantResource getChallengeEventLeaderboard(filterEvent)

Retrieve a challenge event leaderboard details

Lists all leaderboard entries with additional user details

### Example
```java
// Import classes:
//import com.knetikcloud.api.ReportingChallengesApi;

ReportingChallengesApi apiInstance = new ReportingChallengesApi();
Long filterEvent = 789L; // Long | A sepecific challenge event id
try {
    PageResourceChallengeEventParticipantResource result = apiInstance.getChallengeEventLeaderboard(filterEvent);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingChallengesApi#getChallengeEventLeaderboard");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterEvent** | **Long**| A sepecific challenge event id | [optional]

### Return type

[**PageResourceChallengeEventParticipantResource**](PageResourceChallengeEventParticipantResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getChallengeEventParticipants"></a>
# **getChallengeEventParticipants**
> PageResourceChallengeEventParticipantResource getChallengeEventParticipants(filterEvent)

Retrieve a challenge event participant details

Lists all user submitted scores sorted by value, including those that do not apear in the leaderboard due to value or aggregation

### Example
```java
// Import classes:
//import com.knetikcloud.api.ReportingChallengesApi;

ReportingChallengesApi apiInstance = new ReportingChallengesApi();
Long filterEvent = 789L; // Long | A sepecific challenge event id
try {
    PageResourceChallengeEventParticipantResource result = apiInstance.getChallengeEventParticipants(filterEvent);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportingChallengesApi#getChallengeEventParticipants");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterEvent** | **Long**| A sepecific challenge event id | [optional]

### Return type

[**PageResourceChallengeEventParticipantResource**](PageResourceChallengeEventParticipantResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

