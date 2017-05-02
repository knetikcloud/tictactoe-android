
# ClientResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accessTokenValiditySeconds** | **Integer** | The expiration time of an initial oauth token in seconds |  [optional]
**clientKey** | **String** | The client_id field of the oauth token request | 
**grantTypes** | **List&lt;String&gt;** | The oauth grant type as in: password (username/password auth), client_credentials (server-to-server, private clients), refresh_token (to allow clients to refresh their initial token), facebook, google, etc) See documentation for a complete list. use dedicated endpoint PUT /grant-types to edit this list |  [optional]
**id** | **Integer** | Generated unique ID for the client |  [optional]
**isPublic** | **Boolean** | Set to true if the client is public i.e the secret key can be secured |  [optional]
**locked** | **Boolean** | Used to flag system clients that are not meant to be tinkered with |  [optional]
**name** | **String** | The friendly name of the client | 
**redirectUris** | **List&lt;String&gt;** | A redirection URL to use when granting access to third-parties (seldomly used) |  [optional]
**refreshTokenValiditySeconds** | **Integer** | The expiration time of a refresh oauth token in seconds |  [optional]
**secret** | **String** | The client-secret field of the oauth request when creating a private client | 



