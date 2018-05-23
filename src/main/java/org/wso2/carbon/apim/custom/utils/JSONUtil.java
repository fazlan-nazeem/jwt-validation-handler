package org.wso2.carbon.apim.custom.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.wso2.carbon.apim.custom.dto.JWTAssersion;
import org.wso2.carbon.apim.custom.dto.Token;


public class JSONUtil {
    
    /**
     * Populates Token object using folloing JSON String
     * {
     * "token_type": "bearer",
     * "expires_in": 3600000,
     * "refresh_token": "f43de118a489d56c3b3b7ba77a1549e",
     * "access_token": "269becaec9b8b292906b3f9e69b5a9"
     }
     * @param accessTokenJson
     * @return
     */
    public static Token getAccessToken(String accessTokenJson){
        JSONParser parser = new JSONParser();

        Token token = new Token();
        try {
            Object obj = parser.parse(accessTokenJson);
            JSONObject jsonObject = (JSONObject)obj;
            token.setAccessToken((String)jsonObject.get("access_token"));
            long expiresIn = ((Long)jsonObject.get("expires_in")).intValue();
            token.setExpiresIn(expiresIn);
            token.setRefreshToken((String)jsonObject.get("refresh_token"));
            token.setTokenType((String)jsonObject.get("token_type"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return token;

    }
    
    public static JWTAssersion getAssersion(String assersion){
        JSONParser parser = new JSONParser();

        JWTAssersion jwt = new JWTAssersion();
        try {
            Object obj = parser.parse(assersion);
            JSONObject jsonObject = (JSONObject)obj;
            jwt.setSubscriber((String)jsonObject.get("http://wso2.org/claims/subscriber"));
            jwt.setApplicationId((String)jsonObject.get("http://wso2.org/claims/applicationid"));
            jwt.setApplicationName((String)jsonObject.get( "http://wso2.org/claims/applicationname"));
            jwt.setEnduser((String)jsonObject.get("http://wso2.org/claims/enduser"));
            jwt.setKeyType((String)jsonObject.get("http://wso2.org/claims/keytype"));
            jwt.setTier((String)jsonObject.get("http://wso2.org/claims/tier"));
            jwt.setApplicationTier((String)jsonObject.get("http://wso2.org/claims/applicationtier"));

            //long expiresIn = ((Long)jsonObject.get("expires_in")).intValue();
            //jwt.setExpiresIn(expiresIn);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jwt;

    }
}


