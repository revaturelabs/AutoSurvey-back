package com.revature.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.revature.beans.User;
import com.revature.services.UserService;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.example.demo.QcDataReportAppApplication.class)
public class UserControllerTest {

	@MockBean
	UserService serv;

	@Autowired
	MockMvc mvc;
	
	public static Gson gson=new Gson();

	@Test
	void getUser() throws Exception {
		User userTest= new User();
		userTest.setId(1);
		Mockito.when(serv.getUser(1)).thenReturn(userTest);
		Mockito.when(serv.getUser(2)).thenThrow(NoSuchElementException.class);
		mvc.perform(get("/users/1")).andExpect(status().isOk());
		mvc.perform(get("/users/2")).andExpect(status().isOk());
		
	}

	@Test
	void getAllUser() throws Exception {
		User user1 =new User();
		User user2 =new User();
		List<User> allUsers=new ArrayList<>();
		allUsers.add(user1);
		allUsers.add(user2);
		Mockito.when(serv.getAllUsers()).thenReturn(allUsers);
		mvc.perform(get("/users")).andExpect(status().isOk());
	}

	@Test
	void addUser() throws Exception {
		User userTest=new User();
		userTest.setId(1);
		Mockito.when(serv.addUser(userTest)).thenReturn(userTest);
		User user2=serv.addUser(userTest);
		mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(userTest))).andExpect(status().isOk());
		Assertions.assertEquals(gson.toJson(userTest), gson.toJson(user2));
	}

	@Test
	void updateUser() throws Exception {
		User user1 = new User();
		user1.setId(1);
		user1.setFirstName("front1");
		user1.setLastName("last1");
		user1.setEmail("mock1@mockito.com");
		user1.setPassword("password1");
		user1.setAdmin(false);
		User user2 = new User();
		user2.setId(2);
		user2.setFirstName("front2");
		user2.setLastName("last2");
		user2.setEmail("mock2@mockito.com");
		user2.setPassword("password2");
		user2.setAdmin(false);

		Mockito.when(serv.updateUser(user2)).thenReturn(user2);
		mvc.perform(put("/users/1").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(user1))).andExpect(status().isOk());				

	}

	@Test
	void deleteUser() throws Exception {
		User userTest = new User();
		userTest.setId(1);
		Mockito.when(serv.deleteUser(1)).thenReturn(true);
		mvc.perform(delete("/users/1")).andExpect(status().isOk());

	}

}
