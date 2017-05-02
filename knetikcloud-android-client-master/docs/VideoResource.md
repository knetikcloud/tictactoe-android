
# VideoResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**active** | **Boolean** | Whether the video is available, based on various factors |  [optional]
**author** | [**SimpleReferenceResourcelong**](SimpleReferenceResourcelong.md) | The original artist of the media |  [optional]
**authored** | **Long** | The date the media was created as a unix timestamp in seconds |  [optional]
**banned** | **Boolean** | Whether the video has been banned or not |  [optional]
**category** | [**SimpleReferenceResourcestring**](SimpleReferenceResourcestring.md) | The category of the video | 
**comments** | [**List&lt;CommentResource&gt;**](CommentResource.md) | The comments of the video |  [optional]
**contributors** | [**List&lt;ContributionResource&gt;**](ContributionResource.md) | Artists that contributed to the creation. See separate endpoint to add to list |  [optional]
**createdDate** | **Long** | The date/time this resource was created in seconds since unix epoch |  [optional]
**embed** | **String** | The country of an embedable version |  [optional]
**extension** | **String** | The file extension of the media file. 1-5 characters | 
**height** | **Integer** | The height of the video in px | 
**id** | **Long** | The unique ID for that resource |  [optional]
**length** | **Integer** | The length of the video in seconds | 
**location** | **String** | The country of the media. Typically a url. Cannot be blank | 
**longDescription** | **String** | The user friendly name of that resource. Defaults to blank string |  [optional]
**mimeType** | **String** | The mime-type of the media |  [optional]
**name** | **String** | The user friendly name of that resource | 
**priority** | **Integer** | The sort order of the video. default: 100 |  [optional]
**privacy** | [**PrivacyEnum**](#PrivacyEnum) | The privacy setting. default: private |  [optional]
**published** | **Boolean** | Whether the video has been made public. Default true |  [optional]
**shortDescription** | **String** | The user friendly name of that resource. Defaults to blank string |  [optional]
**size** | **Long** | The size of the media. Minimum 0 if supplied |  [optional]
**tags** | **List&lt;String&gt;** | The tags for the video |  [optional]
**thumbnail** | **String** | The country of a thumbnail version. Typically a url |  [optional]
**updatedDate** | **Long** | The date/time this resource was last updated in seconds since unix epoch |  [optional]
**uploader** | [**SimpleUserResource**](SimpleUserResource.md) | The user the media was uploaded by. May be null for system uploaded media. May only be set to a user other than the current caller if VIDEOS_ADMIN permission. Null will mean the caller is the uploader unless the caller has VIDEOS_ADMIN permission, in which case it will be set to null |  [optional]
**views** | **Long** | The view count of the video |  [optional]
**width** | **Integer** | The width of the video in px | 


<a name="PrivacyEnum"></a>
## Enum: PrivacyEnum
Name | Value
---- | -----



