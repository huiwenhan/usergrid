/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.usergrid.rest.test.resource2point0.endpoints.mgmt;


import com.sun.jersey.api.client.WebResource;
import org.apache.usergrid.rest.test.resource2point0.endpoints.NamedResource;
import org.apache.usergrid.rest.test.resource2point0.endpoints.UrlResource;
import org.apache.usergrid.rest.test.resource2point0.model.QueryParameters;
import org.apache.usergrid.rest.test.resource2point0.model.Token;
import org.apache.usergrid.rest.test.resource2point0.state.ClientContext;

import javax.ws.rs.core.MediaType;


/**
 * Called by the ManagementResource. This contains anything token related that comes back to the ManagementResource.
 */
public class TokenResource extends NamedResource {
    public TokenResource(final ClientContext context, final UrlResource parent) {
        super("token", context, parent);
    }


    /**
     * Obtains an access token and sets the token for the context to use in later calls
     *
     * @return
     */
    public Token post() {
        Token token = getResource().type(MediaType.APPLICATION_JSON_TYPE)
            .accept(MediaType.APPLICATION_JSON).post(Token.class);
        this.context.setToken(token);
        return token;
    }

    /**
     * Obtains an access token and sets the token for the context to use in later calls
     *
     * @return
     */
    public Token post(QueryParameters params) {
        WebResource resource = getResource();
        resource = addParametersToResource(resource, params);
        Token token = resource.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON)
            .get(Token.class);

        this.context.setToken(token);
        return token;
    }

    /**
     * Obtains an access token and sets the token for the context to use in later calls
     *
     * @param token
     * @return
     */
    public Token post(Token token) {
        token = getResource().type(MediaType.APPLICATION_JSON_TYPE)
            .accept(MediaType.APPLICATION_JSON).post(Token.class, token);
        this.context.setToken(token);
        return token;
    }


    public TokenResource setToken(Token token) {
        this.context.setToken(token);
        return this;
    }
}
