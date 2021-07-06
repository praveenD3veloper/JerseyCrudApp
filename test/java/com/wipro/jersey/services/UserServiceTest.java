package com.wipro.jersey.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.wipro.jersey.client.UserResourceClient;
import com.wipro.jersey.exception.BadRequestException;
import com.wipro.jersey.model.User;

public class UserServiceTest {

	@Mock
	private static UserService userservice;
	
	
	@Mock
	private static UserResourceClient client;
	
	
	@BeforeClass
	public static void setup() {
		userservice = mock(UserService.class);
		
	}

	@Test
	public void testfetchAllNull() {
		when(userservice.fetchAll()).thenReturn(new ArrayList<User>());
		assertEquals(new ArrayList<User>(), userservice.fetchAll());
	}
	
	@Test
	public void testfetchAllInit() {
		List<User> userList = userservice.fetchAll();
		assertEquals(0, userList.size());
	}
	
	@Test(expected=NullPointerException.class)
	public void testfetchAll() {
		when(client.fetchCountryName(null)).thenReturn(null);
		assertNull(userservice.fetchAll().get(1).getCountryName());
	}
	
	@Test
	public void testfetchByID() {
		UserService obj = new UserService();
		User user = obj.fetchBy(100);
		assertEquals("A", user.getName());
	}
	
	@Test(expected = NotFoundException.class)
	public void testfetchbyIDNull() {
		UserService obj = new UserService();
		User user = obj.fetchBy(100051);
	}
	
	
	@Test(expected = BadRequestException.class)
	public void createUserTest() throws BadRequestException {
		UserService obj = new UserService();
		User user = new User();
		user.setId(100);
		obj.create(user);
	}
	
	@Test
	public void createNewUserTest() throws BadRequestException {
		UserService obj = new UserService();
		User user = new User();
		user.setId(12345);
		obj.create(user);
		assertEquals(obj.fetchBy(12345), user);
	}
	
	@Test(expected = NotFoundException.class)
	public void deleteUserTest() {
		UserService obj = new UserService();
		obj.delete(100);
		obj.fetchBy(100);
	}
}
