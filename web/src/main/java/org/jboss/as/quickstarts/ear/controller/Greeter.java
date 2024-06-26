/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.ear.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.as.quickstarts.ear.local.GreeterEJBLocal;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * A simple managed bean that is used to invoke the GreeterEJB and store the
 * response. The response is obtained by invoking getMessage().
 *
 * @author paul.robinson@redhat.com, 2011-12-21
 */
@Path("/greeter")
public class Greeter implements Serializable {

    /** Default value included to remove warning. **/
    private static final long serialVersionUID = 1L;

    /**
     * Injected GreeterEJB client
     */
    @EJB
    private GreeterEJBLocal greeterEJB;

    /**
     * Stores the response from the call to greeterEJB.sayHello(...)
     */
    private String message;

    /**
     * Invoke greeterEJB.sayHello(...) and store the message
     *
     * @param name
     *             The name of the person to be greeted
     */
    @GET
    @Path("/sayHello")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "get dummy", description = "Get Dummy", tags = { "dummy" })
    @ApiResponse(responseCode = "200", description = "OK")
    public Response sayHello(@PathParam String name) {
        System.out.println("asdasds");
        message = greeterEJB.sayHello(name);
        return Response.ok(message).build();
    }

    /**
     * Get the greeting message, customized with the name of the person to be
     * greeted.
     *
     * @return message. The greeting message.
     */
    public String getMessage() {
        return message;
    }

}
