package com.wipro.jersey.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.mockito.Mockito;

import com.wipro.jersey.model.User;

import junit.framework.Assert;

public class UserResourceClientTest extends Mockito{

	static Client mockClient(Response.Status status, User user) {
		Response mockRes = Mockito.mock(Response.class);
        if (user != null)
            // set expected response
            Mockito.when(mockRes.readEntity(User.class)).thenReturn(user);

        final Builder mockBuilder = Mockito.mock(Builder.class);
        // set returned status code here
        Mockito.when(mockRes.getStatus()).thenReturn(status.getStatusCode());
        Mockito.when(mockBuilder.accept(Mockito.anyString())).thenReturn(mockBuilder);
        // for now set t in all methods
        Mockito.when(mockBuilder.get()).thenReturn(mockRes);
        Mockito.when(mockBuilder.post(Mockito.any())).thenReturn(mockRes);
        Mockito.when(mockBuilder.put(Mockito.any())).thenReturn(mockRes);

        final WebTarget mockTarget = Mockito.mock(WebTarget.class);
        Mockito.when(mockTarget.request(Mockito.anyString())) // if you specify, use MediaType.APPLICATION_JSON
                .thenReturn(mockBuilder);
        Mockito.when(mockTarget.path(Mockito.anyString())).thenReturn(
                mockTarget);

        final Client client = Mockito.mock(Client.class);
        Mockito.when(client.target(Mockito.anyString())).thenReturn(
                mockTarget);
		
		return client;
	}
	
	@Test
    public void testGetUser0_OK() {
        User expected = new User();
        expected.setCountryName("United States of America");
        Client clientMock = mockClient(Response.Status.OK, expected);
        UserResourceClient userclient = new UserResourceClient();
        userclient.fetchCountryName("US");
        Assert.assertEquals(200, userclient.statusCode);
        
    }
	
	
	@Test
    public void testGetUser0_NOT_FOUND() {
        User expected = new User();
        expected.setCountryName("United States of America");
        Client clientMock = mockClient(Response.Status.NOT_FOUND, expected);
        UserResourceClient userclient = new UserResourceClient();
        userclient.fetchCountryName("US");
        Assert.assertEquals(404, userclient.statusCode);
        
    }
	

}
