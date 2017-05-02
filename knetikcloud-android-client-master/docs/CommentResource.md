
# CommentResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**content** | **String** | The comment content of that resource | 
**context** | **String** | The type of object this comment applies to (ex: video, article, etc). Required when passed to /comments |  [optional]
**contextId** | **Integer** | The id of the object this comment applies to.  Required when passed to /comments |  [optional]
**createdDate** | **Long** | The date/time this resource was created in seconds since epoch |  [optional]
**id** | **Long** | The unique ID for that resource |  [optional]
**summary** | **String** | The summary of that resource |  [optional]
**updatedDate** | **Long** | The date/time this resource was last updated in seconds since epoch |  [optional]
**user** | [**SimpleUserResource**](SimpleUserResource.md) | The user who created the comment |  [optional]



