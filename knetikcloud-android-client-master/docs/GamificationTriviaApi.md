# GamificationTriviaApi

All URIs are relative to *https://sandbox.knetikcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addQuestionAnswers**](GamificationTriviaApi.md#addQuestionAnswers) | **POST** /trivia/questions/{question_id}/answers | Add an answer to a question
[**addQuestionTag**](GamificationTriviaApi.md#addQuestionTag) | **POST** /trivia/questions/{id}/tags | Add a tag to a question
[**addTagToQuestionsBatch**](GamificationTriviaApi.md#addTagToQuestionsBatch) | **POST** /trivia/questions/tags | Add a tag to a batch of questions
[**createImportJob**](GamificationTriviaApi.md#createImportJob) | **POST** /trivia/import | Create an import job
[**createQuestion**](GamificationTriviaApi.md#createQuestion) | **POST** /trivia/questions | Create a question
[**createQuestionTemplate**](GamificationTriviaApi.md#createQuestionTemplate) | **POST** /trivia/questions/templates | Create a question template
[**deleteImportJob**](GamificationTriviaApi.md#deleteImportJob) | **DELETE** /trivia/import/{id} | Delete an import job
[**deleteQuestion**](GamificationTriviaApi.md#deleteQuestion) | **DELETE** /trivia/questions/{id} | Delete a question
[**deleteQuestionAnswers**](GamificationTriviaApi.md#deleteQuestionAnswers) | **DELETE** /trivia/questions/{question_id}/answers/{id} | Remove an answer from a question
[**deleteQuestionTemplate**](GamificationTriviaApi.md#deleteQuestionTemplate) | **DELETE** /trivia/questions/templates/{id} | Delete a question template
[**getImportJob**](GamificationTriviaApi.md#getImportJob) | **GET** /trivia/import/{id} | Get an import job
[**getImportJobs**](GamificationTriviaApi.md#getImportJobs) | **GET** /trivia/import | Get a list of import job
[**getQuestion**](GamificationTriviaApi.md#getQuestion) | **GET** /trivia/questions/{id} | Get a single question
[**getQuestionAnswer**](GamificationTriviaApi.md#getQuestionAnswer) | **GET** /trivia/questions/{question_id}/answers/{id} | Get an answer for a question
[**getQuestionAnswers**](GamificationTriviaApi.md#getQuestionAnswers) | **GET** /trivia/questions/{question_id}/answers | List the answers available for a question
[**getQuestionDeltas**](GamificationTriviaApi.md#getQuestionDeltas) | **GET** /trivia/questions/delta | List question deltas in ascending order of updated date
[**getQuestionTags**](GamificationTriviaApi.md#getQuestionTags) | **GET** /trivia/questions/{id}/tags | List the tags for a question
[**getQuestionTemplate**](GamificationTriviaApi.md#getQuestionTemplate) | **GET** /trivia/questions/templates/{id} | Get a single question template
[**getQuestionTemplates**](GamificationTriviaApi.md#getQuestionTemplates) | **GET** /trivia/questions/templates | List and search question templates
[**getQuestions**](GamificationTriviaApi.md#getQuestions) | **GET** /trivia/questions | List and search questions
[**getQuestionsCount**](GamificationTriviaApi.md#getQuestionsCount) | **GET** /trivia/questions/count | Count questions based on filters
[**processImportJob**](GamificationTriviaApi.md#processImportJob) | **POST** /trivia/import/{id}/process | Start processing an import job
[**removeQuestionTag**](GamificationTriviaApi.md#removeQuestionTag) | **DELETE** /trivia/questions/{id}/tags/{tag} | Remove a tag from a question
[**removeTagToQuestionsBatch**](GamificationTriviaApi.md#removeTagToQuestionsBatch) | **DELETE** /trivia/questions/tags/{tag} | Remove a tag from a batch of questions
[**searchQuestionTags**](GamificationTriviaApi.md#searchQuestionTags) | **GET** /trivia/tags | List and search tags by the beginning of the string
[**updateImportJob**](GamificationTriviaApi.md#updateImportJob) | **PUT** /trivia/import/{id} | Update an import job
[**updateQuestion**](GamificationTriviaApi.md#updateQuestion) | **PUT** /trivia/questions/{id} | Update a question
[**updateQuestionAnswer**](GamificationTriviaApi.md#updateQuestionAnswer) | **PUT** /trivia/questions/{question_id}/answers/{id} | Update an answer for a question
[**updateQuestionTemplate**](GamificationTriviaApi.md#updateQuestionTemplate) | **PUT** /trivia/questions/templates/{id} | Update a question template
[**updateQuestionsInBulk**](GamificationTriviaApi.md#updateQuestionsInBulk) | **PUT** /trivia/questions | Bulk update questions


<a name="addQuestionAnswers"></a>
# **addQuestionAnswers**
> AnswerResource addQuestionAnswers(questionId, answer)

Add an answer to a question

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String questionId = "questionId_example"; // String | The id of the question
AnswerResource answer = new AnswerResource(); // AnswerResource | The new answer
try {
    AnswerResource result = apiInstance.addQuestionAnswers(questionId, answer);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#addQuestionAnswers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **questionId** | **String**| The id of the question |
 **answer** | [**AnswerResource**](AnswerResource.md)| The new answer | [optional]

### Return type

[**AnswerResource**](AnswerResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addQuestionTag"></a>
# **addQuestionTag**
> addQuestionTag(id, tag)

Add a tag to a question

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String id = "id_example"; // String | The id of the question
String tag = "tag_example"; // String | The new tag
try {
    apiInstance.addQuestionTag(id, tag);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#addQuestionTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the question |
 **tag** | **String**| The new tag | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addTagToQuestionsBatch"></a>
# **addTagToQuestionsBatch**
> Integer addTagToQuestionsBatch(tag, filterSearch, filterIdset, filterCategory, filterTag, filterTagset, filterType, filterPublished, filterImportId)

Add a tag to a batch of questions

All questions that dont&#39;t have the tag and match filters will have it added. The returned number is the number of questions updated.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String tag = "tag_example"; // String | The tag to add
String filterSearch = "filterSearch_example"; // String | Filter for documents whose question, answers or tags contains provided string
String filterIdset = "filterIdset_example"; // String | Filter for documents whose id is in the comma separated list provided
String filterCategory = "filterCategory_example"; // String | Filter for questions with specified category, by id
String filterTag = "filterTag_example"; // String | Filter for questions with specified tag
String filterTagset = "filterTagset_example"; // String | Filter for questions with specified tags (separated by comma)
String filterType = "filterType_example"; // String | Filter for questions with specified type
Boolean filterPublished = true; // Boolean | Filter for questions currenctly published or not
Long filterImportId = 789L; // Long | Filter for questions from a specific import job
try {
    Integer result = apiInstance.addTagToQuestionsBatch(tag, filterSearch, filterIdset, filterCategory, filterTag, filterTagset, filterType, filterPublished, filterImportId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#addTagToQuestionsBatch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tag** | **String**| The tag to add | [optional]
 **filterSearch** | **String**| Filter for documents whose question, answers or tags contains provided string | [optional]
 **filterIdset** | **String**| Filter for documents whose id is in the comma separated list provided | [optional]
 **filterCategory** | **String**| Filter for questions with specified category, by id | [optional]
 **filterTag** | **String**| Filter for questions with specified tag | [optional]
 **filterTagset** | **String**| Filter for questions with specified tags (separated by comma) | [optional]
 **filterType** | **String**| Filter for questions with specified type | [optional] [enum: TEXT, IMAGE, VIDEO, AUDIO]
 **filterPublished** | **Boolean**| Filter for questions currenctly published or not | [optional]
 **filterImportId** | **Long**| Filter for questions from a specific import job | [optional]

### Return type

**Integer**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createImportJob"></a>
# **createImportJob**
> ImportJobResource createImportJob(request)

Create an import job

Set up a job to import a set of trivia questions from a cvs file at a remote url. the file will be validated asynchronously but will not be processed until started manually with the process endpoint.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
ImportJobResource request = new ImportJobResource(); // ImportJobResource | The new import job
try {
    ImportJobResource result = apiInstance.createImportJob(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#createImportJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**ImportJobResource**](ImportJobResource.md)| The new import job | [optional]

### Return type

[**ImportJobResource**](ImportJobResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createQuestion"></a>
# **createQuestion**
> QuestionResource createQuestion(question)

Create a question

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
QuestionResource question = new QuestionResource(); // QuestionResource | The new question
try {
    QuestionResource result = apiInstance.createQuestion(question);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#createQuestion");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **question** | [**QuestionResource**](QuestionResource.md)| The new question | [optional]

### Return type

[**QuestionResource**](QuestionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createQuestionTemplate"></a>
# **createQuestionTemplate**
> QuestionTemplateResource createQuestionTemplate(questionTemplateResource)

Create a question template

Question templates define a type of question and the properties they have

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
QuestionTemplateResource questionTemplateResource = new QuestionTemplateResource(); // QuestionTemplateResource | The question template resource object
try {
    QuestionTemplateResource result = apiInstance.createQuestionTemplate(questionTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#createQuestionTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **questionTemplateResource** | [**QuestionTemplateResource**](QuestionTemplateResource.md)| The question template resource object | [optional]

### Return type

[**QuestionTemplateResource**](QuestionTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteImportJob"></a>
# **deleteImportJob**
> deleteImportJob(id)

Delete an import job

Also deletes all questions that were imported by it

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
Long id = 789L; // Long | The id of the job
try {
    apiInstance.deleteImportJob(id);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#deleteImportJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The id of the job |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteQuestion"></a>
# **deleteQuestion**
> deleteQuestion(id)

Delete a question

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String id = "id_example"; // String | The id of the question
try {
    apiInstance.deleteQuestion(id);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#deleteQuestion");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the question |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteQuestionAnswers"></a>
# **deleteQuestionAnswers**
> deleteQuestionAnswers(questionId, id)

Remove an answer from a question

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String questionId = "questionId_example"; // String | The id of the question
String id = "id_example"; // String | The id of the answer
try {
    apiInstance.deleteQuestionAnswers(questionId, id);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#deleteQuestionAnswers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **questionId** | **String**| The id of the question |
 **id** | **String**| The id of the answer |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteQuestionTemplate"></a>
# **deleteQuestionTemplate**
> deleteQuestionTemplate(id, cascade)

Delete a question template

If cascade &#x3D; &#39;detach&#39;, it will force delete the template even if it&#39;s attached to other objects

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String id = "id_example"; // String | The id of the template
String cascade = "cascade_example"; // String | The value needed to delete used templates
try {
    apiInstance.deleteQuestionTemplate(id, cascade);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#deleteQuestionTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **cascade** | **String**| The value needed to delete used templates | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getImportJob"></a>
# **getImportJob**
> ImportJobResource getImportJob(id)

Get an import job

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
Long id = 789L; // Long | The id of the job
try {
    ImportJobResource result = apiInstance.getImportJob(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#getImportJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The id of the job |

### Return type

[**ImportJobResource**](ImportJobResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getImportJobs"></a>
# **getImportJobs**
> PageResourceImportJobResource getImportJobs(filterVendor, filterCategory, filterName, filterStatus, size, page, order)

Get a list of import job

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String filterVendor = "filterVendor_example"; // String | Filter for jobs by vendor id
String filterCategory = "filterCategory_example"; // String | Filter for jobs by category id
String filterName = "filterName_example"; // String | Filter for jobs which name *STARTS* with the given string
String filterStatus = "filterStatus_example"; // String | Filter for jobs that are in a specific set of statuses (comma separated)
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceImportJobResource result = apiInstance.getImportJobs(filterVendor, filterCategory, filterName, filterStatus, size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#getImportJobs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterVendor** | **String**| Filter for jobs by vendor id | [optional]
 **filterCategory** | **String**| Filter for jobs by category id | [optional]
 **filterName** | **String**| Filter for jobs which name *STARTS* with the given string | [optional]
 **filterStatus** | **String**| Filter for jobs that are in a specific set of statuses (comma separated) | [optional]
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceImportJobResource**](PageResourceImportJobResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getQuestion"></a>
# **getQuestion**
> QuestionResource getQuestion(id)

Get a single question

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String id = "id_example"; // String | The id of the question
try {
    QuestionResource result = apiInstance.getQuestion(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#getQuestion");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the question |

### Return type

[**QuestionResource**](QuestionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getQuestionAnswer"></a>
# **getQuestionAnswer**
> AnswerResource getQuestionAnswer(questionId, id)

Get an answer for a question

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String questionId = "questionId_example"; // String | The id of the question
String id = "id_example"; // String | The id of the answer
try {
    AnswerResource result = apiInstance.getQuestionAnswer(questionId, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#getQuestionAnswer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **questionId** | **String**| The id of the question |
 **id** | **String**| The id of the answer |

### Return type

[**AnswerResource**](AnswerResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getQuestionAnswers"></a>
# **getQuestionAnswers**
> List&lt;AnswerResource&gt; getQuestionAnswers(questionId)

List the answers available for a question

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String questionId = "questionId_example"; // String | The id of the question
try {
    List<AnswerResource> result = apiInstance.getQuestionAnswers(questionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#getQuestionAnswers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **questionId** | **String**| The id of the question |

### Return type

[**List&lt;AnswerResource&gt;**](AnswerResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getQuestionDeltas"></a>
# **getQuestionDeltas**
> List&lt;DeltaResource&gt; getQuestionDeltas(since)

List question deltas in ascending order of updated date

The &#39;since&#39; parameter is important to avoid getting a full list of all questions. Implementors should make sure they pass the updated date of the last resource loaded, not the date of the last request, in order to avoid gaps

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
Long since = 789L; // Long | Timestamp in seconds
try {
    List<DeltaResource> result = apiInstance.getQuestionDeltas(since);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#getQuestionDeltas");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **since** | **Long**| Timestamp in seconds | [optional]

### Return type

[**List&lt;DeltaResource&gt;**](DeltaResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getQuestionTags"></a>
# **getQuestionTags**
> List&lt;String&gt; getQuestionTags(id)

List the tags for a question

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String id = "id_example"; // String | The id of the question
try {
    List<String> result = apiInstance.getQuestionTags(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#getQuestionTags");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the question |

### Return type

**List&lt;String&gt;**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getQuestionTemplate"></a>
# **getQuestionTemplate**
> QuestionTemplateResource getQuestionTemplate(id)

Get a single question template

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String id = "id_example"; // String | The id of the template
try {
    QuestionTemplateResource result = apiInstance.getQuestionTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#getQuestionTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |

### Return type

[**QuestionTemplateResource**](QuestionTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getQuestionTemplates"></a>
# **getQuestionTemplates**
> PageResourceQuestionTemplateResource getQuestionTemplates(size, page, order)

List and search question templates

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
try {
    PageResourceQuestionTemplateResource result = apiInstance.getQuestionTemplates(size, page, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#getQuestionTemplates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]

### Return type

[**PageResourceQuestionTemplateResource**](PageResourceQuestionTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getQuestions"></a>
# **getQuestions**
> PageResourceQuestionResource getQuestions(size, page, order, filterSearch, filterIdset, filterCategory, filterTagset, filterTag, filterType, filterPublished, filterImportId)

List and search questions

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
Integer size = 25; // Integer | The number of objects returned per page
Integer page = 1; // Integer | The number of the page returned, starting with 1
String order = "id:ASC"; // String | A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC]
String filterSearch = "filterSearch_example"; // String | Filter for documents whose question, answers or tags contains provided string
String filterIdset = "filterIdset_example"; // String | Filter for documents whose id is in the comma separated list provided
String filterCategory = "filterCategory_example"; // String | Filter for questions with specified category, by id
String filterTagset = "filterTagset_example"; // String | Filter for questions with specified tags (separated by comma)
String filterTag = "filterTag_example"; // String | Filter for questions with specified tag
String filterType = "filterType_example"; // String | Filter for questions with specified type.  Allowable values: ('TEXT', 'IMAGE', 'VIDEO', 'AUDIO')
Boolean filterPublished = true; // Boolean | Filter for questions currenctly published or not
Long filterImportId = 789L; // Long | Filter for questions from a specific import job
try {
    PageResourceQuestionResource result = apiInstance.getQuestions(size, page, order, filterSearch, filterIdset, filterCategory, filterTagset, filterTag, filterType, filterPublished, filterImportId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#getQuestions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **size** | **Integer**| The number of objects returned per page | [optional] [default to 25]
 **page** | **Integer**| The number of the page returned, starting with 1 | [optional] [default to 1]
 **order** | **String**| A comma separated list of sorting requirements in priority order, each entry matching PROPERTY_NAME:[ASC|DESC] | [optional] [default to id:ASC]
 **filterSearch** | **String**| Filter for documents whose question, answers or tags contains provided string | [optional]
 **filterIdset** | **String**| Filter for documents whose id is in the comma separated list provided | [optional]
 **filterCategory** | **String**| Filter for questions with specified category, by id | [optional]
 **filterTagset** | **String**| Filter for questions with specified tags (separated by comma) | [optional]
 **filterTag** | **String**| Filter for questions with specified tag | [optional]
 **filterType** | **String**| Filter for questions with specified type.  Allowable values: (&#39;TEXT&#39;, &#39;IMAGE&#39;, &#39;VIDEO&#39;, &#39;AUDIO&#39;) | [optional]
 **filterPublished** | **Boolean**| Filter for questions currenctly published or not | [optional]
 **filterImportId** | **Long**| Filter for questions from a specific import job | [optional]

### Return type

[**PageResourceQuestionResource**](PageResourceQuestionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getQuestionsCount"></a>
# **getQuestionsCount**
> Long getQuestionsCount(filterSearch, filterIdset, filterCategory, filterTag, filterTagset, filterType, filterPublished)

Count questions based on filters

This is also provided by the list endpoint so you don&#39;t need to call this for pagination purposes

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String filterSearch = "filterSearch_example"; // String | Filter for documents whose question, answers or tags contains provided string
String filterIdset = "filterIdset_example"; // String | Filter for documents whose id is in the comma separated list provided
String filterCategory = "filterCategory_example"; // String | Filter for questions with specified category, by id
String filterTag = "filterTag_example"; // String | Filter for questions with specified tag
String filterTagset = "filterTagset_example"; // String | Filter for questions with specified tags (separated by comma)
String filterType = "filterType_example"; // String | Filter for questions with specified type.  Allowable values: ('TEXT', 'IMAGE', 'VIDEO', 'AUDIO')
Boolean filterPublished = true; // Boolean | Filter for questions currenctly published or not
try {
    Long result = apiInstance.getQuestionsCount(filterSearch, filterIdset, filterCategory, filterTag, filterTagset, filterType, filterPublished);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#getQuestionsCount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterSearch** | **String**| Filter for documents whose question, answers or tags contains provided string | [optional]
 **filterIdset** | **String**| Filter for documents whose id is in the comma separated list provided | [optional]
 **filterCategory** | **String**| Filter for questions with specified category, by id | [optional]
 **filterTag** | **String**| Filter for questions with specified tag | [optional]
 **filterTagset** | **String**| Filter for questions with specified tags (separated by comma) | [optional]
 **filterType** | **String**| Filter for questions with specified type.  Allowable values: (&#39;TEXT&#39;, &#39;IMAGE&#39;, &#39;VIDEO&#39;, &#39;AUDIO&#39;) | [optional]
 **filterPublished** | **Boolean**| Filter for questions currenctly published or not | [optional]

### Return type

**Long**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="processImportJob"></a>
# **processImportJob**
> ImportJobResource processImportJob(id, publishNow)

Start processing an import job

Will process the CSV file and add new questions asynchronously. The status of the job must be &#39;VALID&#39;.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
Long id = 789L; // Long | The id of the job
Boolean publishNow = true; // Boolean | Whether the new questions should be published live immediately
try {
    ImportJobResource result = apiInstance.processImportJob(id, publishNow);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#processImportJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The id of the job |
 **publishNow** | **Boolean**| Whether the new questions should be published live immediately |

### Return type

[**ImportJobResource**](ImportJobResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeQuestionTag"></a>
# **removeQuestionTag**
> removeQuestionTag(id, tag)

Remove a tag from a question

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String id = "id_example"; // String | The id of the question
String tag = "tag_example"; // String | The tag to remove
try {
    apiInstance.removeQuestionTag(id, tag);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#removeQuestionTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the question |
 **tag** | **String**| The tag to remove |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeTagToQuestionsBatch"></a>
# **removeTagToQuestionsBatch**
> Integer removeTagToQuestionsBatch(tag, filterSearch, filterIdset, filterCategory, filterTag, filterTagset, filterType, filterPublished, filterImportId)

Remove a tag from a batch of questions

ll questions that have the tag and match filters will have it removed. The returned number is the number of questions updated.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String tag = "tag_example"; // String | The tag to remove
String filterSearch = "filterSearch_example"; // String | Filter for documents whose question, answers or tags contains provided string
String filterIdset = "filterIdset_example"; // String | Filter for documents whose id is in the comma separated list provided
String filterCategory = "filterCategory_example"; // String | Filter for questions with specified category, by id
String filterTag = "filterTag_example"; // String | Filter for questions with specified tag
String filterTagset = "filterTagset_example"; // String | Filter for questions with specified tags (separated by comma)
String filterType = "filterType_example"; // String | Filter for questions with specified type.  Allowable values: ('TEXT', 'IMAGE', 'VIDEO', 'AUDIO')
Boolean filterPublished = true; // Boolean | Filter for questions currenctly published or not
Long filterImportId = 789L; // Long | Filter for questions from a specific import job
try {
    Integer result = apiInstance.removeTagToQuestionsBatch(tag, filterSearch, filterIdset, filterCategory, filterTag, filterTagset, filterType, filterPublished, filterImportId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#removeTagToQuestionsBatch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tag** | **String**| The tag to remove |
 **filterSearch** | **String**| Filter for documents whose question, answers or tags contains provided string | [optional]
 **filterIdset** | **String**| Filter for documents whose id is in the comma separated list provided | [optional]
 **filterCategory** | **String**| Filter for questions with specified category, by id | [optional]
 **filterTag** | **String**| Filter for questions with specified tag | [optional]
 **filterTagset** | **String**| Filter for questions with specified tags (separated by comma) | [optional]
 **filterType** | **String**| Filter for questions with specified type.  Allowable values: (&#39;TEXT&#39;, &#39;IMAGE&#39;, &#39;VIDEO&#39;, &#39;AUDIO&#39;) | [optional]
 **filterPublished** | **Boolean**| Filter for questions currenctly published or not | [optional]
 **filterImportId** | **Long**| Filter for questions from a specific import job | [optional]

### Return type

**Integer**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="searchQuestionTags"></a>
# **searchQuestionTags**
> Collectionstring searchQuestionTags(filterSearch, filterCategory, filterImportId)

List and search tags by the beginning of the string

For performance reasons, search &amp; category filters are mutually exclusive. If category is specified, search filter will be ignored in order to do fast matches for typeahead.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String filterSearch = "filterSearch_example"; // String | Filter for tags starting with the given text
String filterCategory = "filterCategory_example"; // String | Filter for tags on questions from a specific category
Long filterImportId = 789L; // Long | Filter for tags on questions from a specific import job
try {
    Collectionstring result = apiInstance.searchQuestionTags(filterSearch, filterCategory, filterImportId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#searchQuestionTags");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filterSearch** | **String**| Filter for tags starting with the given text | [optional]
 **filterCategory** | **String**| Filter for tags on questions from a specific category | [optional]
 **filterImportId** | **Long**| Filter for tags on questions from a specific import job | [optional]

### Return type

[**Collectionstring**](Collectionstring.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateImportJob"></a>
# **updateImportJob**
> ImportJobResource updateImportJob(id, request)

Update an import job

Changes should be made before process is started for there to be any effect.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
Long id = 789L; // Long | The id of the job
ImportJobResource request = new ImportJobResource(); // ImportJobResource | The updated job
try {
    ImportJobResource result = apiInstance.updateImportJob(id, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#updateImportJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The id of the job |
 **request** | [**ImportJobResource**](ImportJobResource.md)| The updated job | [optional]

### Return type

[**ImportJobResource**](ImportJobResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateQuestion"></a>
# **updateQuestion**
> QuestionResource updateQuestion(id, question)

Update a question

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String id = "id_example"; // String | The id of the question
QuestionResource question = new QuestionResource(); // QuestionResource | The updated question
try {
    QuestionResource result = apiInstance.updateQuestion(id, question);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#updateQuestion");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the question |
 **question** | [**QuestionResource**](QuestionResource.md)| The updated question | [optional]

### Return type

[**QuestionResource**](QuestionResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateQuestionAnswer"></a>
# **updateQuestionAnswer**
> updateQuestionAnswer(questionId, id, answer)

Update an answer for a question

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String questionId = "questionId_example"; // String | The id of the question
String id = "id_example"; // String | The id of the answer
AnswerResource answer = new AnswerResource(); // AnswerResource | The updated answer
try {
    apiInstance.updateQuestionAnswer(questionId, id, answer);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#updateQuestionAnswer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **questionId** | **String**| The id of the question |
 **id** | **String**| The id of the answer |
 **answer** | [**AnswerResource**](AnswerResource.md)| The updated answer | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateQuestionTemplate"></a>
# **updateQuestionTemplate**
> QuestionTemplateResource updateQuestionTemplate(id, questionTemplateResource)

Update a question template

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
String id = "id_example"; // String | The id of the template
QuestionTemplateResource questionTemplateResource = new QuestionTemplateResource(); // QuestionTemplateResource | The question template resource object
try {
    QuestionTemplateResource result = apiInstance.updateQuestionTemplate(id, questionTemplateResource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#updateQuestionTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the template |
 **questionTemplateResource** | [**QuestionTemplateResource**](QuestionTemplateResource.md)| The question template resource object | [optional]

### Return type

[**QuestionTemplateResource**](QuestionTemplateResource.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateQuestionsInBulk"></a>
# **updateQuestionsInBulk**
> Integer updateQuestionsInBulk(question, filterSearch, filterIdset, filterCategory, filterTagset, filterType, filterPublished, filterImportId)

Bulk update questions

Will update all questions that match filters used (or all questions in system if no filters used). Body should match a question resource with only those properties you wish to set. Null values will be ignored. Returned number is how many were updated.

### Example
```java
// Import classes:
//import com.knetikcloud.api.GamificationTriviaApi;

GamificationTriviaApi apiInstance = new GamificationTriviaApi();
QuestionResource question = new QuestionResource(); // QuestionResource | New values for a set of question fields
String filterSearch = "filterSearch_example"; // String | Filter for documents whose question, answers or tags contains provided string
String filterIdset = "filterIdset_example"; // String | Filter for documents whose id is in the comma separated list provided
String filterCategory = "filterCategory_example"; // String | Filter for questions with specified category, by id
String filterTagset = "filterTagset_example"; // String | Filter for questions with specified tags (separated by comma)
String filterType = "filterType_example"; // String | Filter for questions with specified type.  Allowable values: ('TEXT', 'IMAGE', 'VIDEO', 'AUDIO')
Boolean filterPublished = true; // Boolean | Filter for questions currenctly published or not
Long filterImportId = 789L; // Long | Filter for questions from a specific import job
try {
    Integer result = apiInstance.updateQuestionsInBulk(question, filterSearch, filterIdset, filterCategory, filterTagset, filterType, filterPublished, filterImportId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GamificationTriviaApi#updateQuestionsInBulk");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **question** | [**QuestionResource**](QuestionResource.md)| New values for a set of question fields | [optional]
 **filterSearch** | **String**| Filter for documents whose question, answers or tags contains provided string | [optional]
 **filterIdset** | **String**| Filter for documents whose id is in the comma separated list provided | [optional]
 **filterCategory** | **String**| Filter for questions with specified category, by id | [optional]
 **filterTagset** | **String**| Filter for questions with specified tags (separated by comma) | [optional]
 **filterType** | **String**| Filter for questions with specified type.  Allowable values: (&#39;TEXT&#39;, &#39;IMAGE&#39;, &#39;VIDEO&#39;, &#39;AUDIO&#39;) | [optional]
 **filterPublished** | **Boolean**| Filter for questions currenctly published or not | [optional]
 **filterImportId** | **Long**| Filter for questions from a specific import job | [optional]

### Return type

**Integer**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

