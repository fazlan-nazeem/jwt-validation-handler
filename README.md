# jwt-validation-handler
Instead of oAuth2 token, use JWT token to validate incoming request

Engage the Handler

Replace default authentication handler in the synapse file with the following

```
<handler class="org.wso2.carbon.apim.custom.JWTValidationHandler">
	<property name="keystorePath" value="/home/fazlann/support/EVAL/CERNERDEV-19/wso2am-2.1.0/repository/resources/security/wso2carbon.jks"/> 
	<property name="keystorePassword" value="wso2carbon"/> 
	<property name="keyAlias" value="wso2carbon"/> 
</handler>
```
