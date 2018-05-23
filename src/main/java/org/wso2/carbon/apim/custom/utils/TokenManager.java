/*
* Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.wso2.carbon.apim.custom.utils;

import org.apache.synapse.MessageContext;
import org.apache.synapse.core.axis2.Axis2MessageContext;

import java.util.Map;

public class TokenManager {

    private static final String X_JWT_ASSERTION = "X-JWT-Assertion";

    public static String extractJWTToken(MessageContext messageContext) {

        Map transportHeaders = (Map) ((Axis2MessageContext) messageContext).getAxis2MessageContext().
                getProperty(org.apache.axis2.context.MessageContext.TRANSPORT_HEADERS);

        String jwtToken = null;
        if (transportHeaders != null && transportHeaders.containsKey(X_JWT_ASSERTION)) {
            jwtToken = (String) transportHeaders.get(X_JWT_ASSERTION);
        }

        return jwtToken;
    }

}