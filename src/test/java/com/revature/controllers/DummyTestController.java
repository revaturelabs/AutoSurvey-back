package com.revature.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.Cookie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.services.UserService;

/*
 * THIS CLASS DOES NOT WORK ONLY TO BE USED AS A REFERENCE ON HOW TO WRITE
 * OUR MOCKITO TEST WITHIN THE BODY OF OUR TESTS
 */
public class DummyTestController {

	@MockBean
	UserService serv;
	
	@Autowired
	MockMvc mvc;
	
//	@InjectMocks
//	User user; //= new User();
		
	@Test
	void getUserByIDOrUsernameTest() throws Exception {
		int id = 1;
		int badID = 2;
		String username = "TopSpeed";
		String badUname = "Fail";
		User user = new User();
		user.setUserID(1);
		user.setFname("Usain");
		user.setLname("Bolt");
		user.setUsername("TopSpeed");
		user.setPassword("G2Gfast");
		user.setAge(34);
		
		Mockito.when(serv.findUserByID(id)).thenReturn(user);
		Mockito.when(serv.findUserByID(badID)).thenThrow(NoSuchElementException.class);
		Mockito.when(serv.findUserByUsername(username)).thenReturn(user);
		Mockito.when(serv.findUserByUsername(badUname)).thenThrow(IllegalArgumentException.class); //Does not like "Exception.class"
		
		ResultActions ra1 = mvc.perform(get("/users/1"));
		ra1.andExpect(status().isOk());
		ra1.andExpect(jsonPath("$.username", is("TopSpeed")));
		//ra.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
		ra1 = mvc.perform(get("/users/2"));
		ra1.andExpect(status().isOk());
		ra1.andExpect(content().string(""));
		
		
		ResultActions ra2 = mvc.perform(get("/users/search?username=" + username));
		ra2.andExpect(status().isOk());
		ra2.andExpect(jsonPath("$.username", is("TopSpeed")));
		
		String test = ""; //Don't use null, just an empty string
		ResultActions ra3 = mvc.perform(get("/users/search?username=" + badUname));
		ra3.andExpect(status().isOk());
		//ra3.andExpect(jsonPath("$.*", hasSize(0)));
		ra3.andExpect(content().string(test)); //How to check if the returned object is null		
	}
	
	@Test
	void getAllUsersTest() throws Exception {
		Mockito.when(serv.getAllUsers()).thenReturn(Stream.of(new User(), new User(), new User()).collect(Collectors.toList()));
		
		ResultActions ra = mvc.perform(get("/users"));
		//MvcResult res = ra.andReturn();
		
		//System.out.println("Print Result:" + res);
		//res.
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.length()", is(3))); //Works! (Do instead of "Matchers.hasSize(#)" because Matchers is deprecated		
	}
	
	@Test
	void failGetAllUsersTest() throws Exception {
		Mockito.when(serv.getAllUsers()).thenThrow(NoSuchElementException.class);
		ResultActions ra = mvc.perform(get("/users"));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string(""));
	}
	
	@Test
	void getUserLoginTest() throws Exception {
		String badUsername = "FailUname";
		String badPassword = "FailPass";
		User user = new User();
		user.setUserID(1);
		user.setFname("Usain");
		user.setLname("Bolt");
		user.setUsername("TopSpeed");
		user.setPassword("G2Gfast");
		user.setAge(34);
		
		Mockito.when(serv.login(user.getUsername(), user.getPassword())).thenReturn(user);
		Mockito.when(serv.login(badUsername, badPassword)).thenReturn(null);
		
		ResultActions ra = mvc.perform(get("/users/securelogin?username=" + user.getUsername() + "&password=" + user.getPassword()));
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.username", is("TopSpeed")));
		
		ra = mvc.perform(get("/users/securelogin?username=" + badUsername + "&password=" + badPassword));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string(""));
	}
	
	@Test
	void viewUserLoginTest() throws Exception {
		int id = 1;
		User user = new User();
		user.setUserID(1);
		user.setFname("Usain");
		user.setLname("Bolt");
		user.setUsername("TopSpeed");
		user.setPassword("G2Gfast");
		user.setAge(34);
		
		Mockito.when(serv.findUserByID(id)).thenReturn(user);
		Mockito.when(serv.findUserByID(0)).thenThrow(NullPointerException.class);
		Mockito.when(serv.findUserByID(2)).thenThrow(IllegalArgumentException.class);
		
		ResultActions ra = mvc.perform(get("/users/viewLoggedInUser").cookie(new Cookie("id", String.valueOf(id))));
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.username", is("TopSpeed")));
		
		ra = mvc.perform(get("/users/viewLoggedInUser").cookie(new Cookie("id", String.valueOf(0))));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string(""));
		
		ra = mvc.perform(get("/users/viewLoggedInUser").cookie(new Cookie("id", String.valueOf(2))));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string(""));
	}
	
	@Test
	void logoutTest() throws Exception {
		User user = new User();
		user.setUserID(1);
		user.setFname("Usain");
		user.setLname("Bolt");
		
		Assertions.assertEquals("Bolt", user.getLname());
		ResultActions ra = mvc.perform(post("/users/logout"));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string(""));
		
	}
	
	@Test
	void addUserTest() throws Exception {
		User testUser = new User();
		User user = new User();
		System.out.println("In test, before setting: " + user);
		user.setUserID(1);
		user.setFname("Usain");
		user.setLname("Bolt");
		user.setUsername("TopSpeed");
		user.setPassword("G2Gfast");
		user.setEmail("ex@ample.com");
		user.setPhNumber("18005555555");
		user.setGender("Male");
		user.setAge(34);
		user.setWeight(207);
		user.setGoalWeight(208);
		user.setHeight(77);
		user.setTime("Every Day");
		
		ObjectMapper om = new ObjectMapper();
		String jsonRequest = om.writeValueAsString(user);
		//jsonRequest.
		
		Mockito.when(serv.addUser(ArgumentMatchers.eq(user))).thenReturn(user); //Trying with eq() -> Works!
		//Mockito.when(serv.addUser(ArgumentMatchers.any(User.class))).thenReturn(user); //Problem occurred here! -Fixed with any() method
		//For eq() method to work, would need to create/override the .equals() method for user -> DONE
		//Mockito.when(serv.addUser(ArgumentMatchers.eq(user))).
		Mockito.when(serv.addUser(ArgumentMatchers.eq(testUser))).thenThrow(NullPointerException.class);
		
		//ResultActions ra = mvc.perform(post("/users").requestAttr("user", user).contentType(MediaType.APPLICATION_JSON));//400 status code
		ResultActions ra = mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(jsonRequest));
		//ResultActions ra = mvc.perform(post("/users").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE));//415 status code
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.username", is("TopSpeed")));
		/*MvcResult result = ra.andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Response response = om.readValue(resultContent, Response.class);
		System.out.println("Response: " + response);*/
		
		//ra.andExpect(jsonPath("$.username", is("TopSpeed")));
		
//		ra = mvc.perform(post("/users").requestAttr("user", null).contentType(MediaType.APPLICATION_JSON_VALUE));
//		ra.andExpect(status().isOk());
//		ra.andExpect(content().string(""));
		
		jsonRequest = om.writeValueAsString(testUser);
		ra = mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(jsonRequest));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string(""));	
	}
	
	@Test
	void updateUserTest() throws Exception {
		User testUser = new User();
		testUser.setUserID(2);
		User user = new User();
		user.setUserID(2);
		user.setFname("Usain");
		user.setLname("Bolt");
		user.setUsername("TopSpeed");
		user.setPassword("G2Gfast");
		
		ObjectMapper om = new ObjectMapper();
		String jsonRequest = om.writeValueAsString(user);
		Mockito.when(serv.updateUser(ArgumentMatchers.eq(user))).thenReturn(user);
		Mockito.when(serv.updateUser(ArgumentMatchers.eq(testUser))).thenThrow(NullPointerException.class);
		
		ResultActions ra = mvc.perform(put("/users/2").contentType(MediaType.APPLICATION_JSON).content(jsonRequest));
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.username", is("TopSpeed")));	
		
		jsonRequest = om.writeValueAsString(testUser);
		ra = mvc.perform(put("/users/2").contentType(MediaType.APPLICATION_JSON).content(jsonRequest));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string(""));
		
	}
	
	@Test
	void deleteUserTest() throws Exception {
		int id = 1;
		int badID = 2;
		
		Mockito.when(serv.deleteUser(id)).thenReturn(true);
		Mockito.when(serv.deleteUser(badID)).thenThrow(NoSuchElementException.class);
		
		ResultActions ra = mvc.perform(delete("/users/" + id));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string("true"));
		
		ra = mvc.perform(delete("/users/" + badID));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string("false"));
		
		
	}

}
