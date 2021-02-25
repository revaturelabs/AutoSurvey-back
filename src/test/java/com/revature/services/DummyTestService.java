package com.revature.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.beans.User;
import com.revature.repositories.UserRepo;

/*
 * THIS CLASS DOES NOT WORK ONLY TO BE USED AS A REFERENCE ON HOW TO WRITE
 * OUR MOCKITO TEST WITHIN THE BODY OF OUR TESTS
 */


@AutoConfigureMockMvc
@SpringBootTest(classes = com.example.demo.Project2WorkoutAppApplication.class)
public class DummyTestService {

	@MockBean
	UserRepo repo;
	
	@Autowired
	UserService serv;
	
	@Test
	void addWorkoutTest() {
		User user = new User();
		User testUser = new User();
		testUser.setUserID(1);
		testUser.setFname("Tom");
		testUser.setLname("Platz");
		testUser.setUsername("Quadfather");
		testUser.setPassword("1MoreRep");
		
		Mockito.when(repo.save(user)).thenReturn(testUser);
		
		user = serv.addUser(user);
		Assertions.assertEquals("Platz", user.getLname());
	}
	
	//Testing both get by ID and by name
		@Test
		void getUserByIDOrUsernameTest() {
			int id = 1;
			String username = "Quadfather";
			User user = new User();
			User testUser = new User();
			testUser.setUserID(1);
			testUser.setFname("Tom");
			testUser.setLname("Platz");
			testUser.setUsername("Quadfather");
			testUser.setPassword("1MoreRep");
			
			Mockito.when(repo.findById(id)).thenReturn(Optional.of(testUser));
			Mockito.when(repo.findByUsername(username)).thenReturn(testUser);
			
			user = serv.findUserByID(id);
			Assertions.assertEquals(id, user.getUserID());
			Assertions.assertEquals("Tom", user.getFname());
			
			user = null;//reset object
			user = serv.findUserByUsername(username);
			Assertions.assertEquals(id, user.getUserID());
			Assertions.assertEquals("Quadfather", user.getUsername());
		}
		
		@Test
		void getAllUserTest() {
			List<User> allUsers = new ArrayList<User>();
			Mockito.when(repo.findAll()).thenReturn(Stream.of(new User(), new User(), new User()).collect(Collectors.toList()));
			
			allUsers = serv.getAllUsers();
			Assertions.assertEquals(3, allUsers.size());
		}
		
		@Test
		void updateUserTest() {
			//User user = new User();
			User testUser = new User();
			testUser.setUserID(1);
			testUser.setFname("Tom");
			testUser.setLname("Platz");
			testUser.setUsername("Quadfather");
			testUser.setPassword("1MoreRep");
			Mockito.when(repo.save(testUser)).thenReturn(testUser);
			
			Assertions.assertEquals("Quadfather", testUser.getUsername());		
			testUser.setUsername("GoldenEagle");
			testUser.setAge(65);
			testUser = serv.updateUser(testUser);
			Assertions.assertEquals("GoldenEagle", testUser.getUsername());
			Assertions.assertEquals(65, testUser.getAge());
		}
		
		@Test
		void deleteUserTest() {
			int id = 1;
			User testUser = new User();
			testUser.setUserID(1);
			testUser.setFname("Tom");
			testUser.setLname("Platz");
			testUser.setUsername("Quadfather");
			testUser.setPassword("1MoreRep");
			Mockito.when(repo.findById(id)).thenReturn(Optional.of(testUser));
			Mockito.when(repo.findById(0)).thenThrow(IllegalArgumentException.class);
			
			Assertions.assertEquals(true, serv.deleteUser(id));
			verify(repo, times(1)).delete(testUser);
			
			Assertions.assertEquals(false, serv.deleteUser(0));
		}
		
		@Test
		void registerUserTest() {
			String username = "UnavailableUsername";
			User testUser = new User();
			testUser.setUserID(1);
			testUser.setFname("Tom");
			testUser.setLname("Platz");
			testUser.setUsername("Quadfather");
			testUser.setPassword("1MoreRep");			
			Mockito.when(repo.findByUsername(testUser.getUsername())).thenReturn(null);
			Mockito.when(repo.findByUsername(username)).thenReturn(testUser);
			Mockito.when(repo.save(testUser)).thenReturn(testUser);
			
			testUser = serv.registerUser(testUser);
			Assertions.assertEquals("Platz", testUser.getLname());
			
			testUser.setUsername(username);
			testUser = serv.registerUser(testUser);
			Assertions.assertNull(testUser);
		}
		
		@Test
		void userLoginLogoutTest() {
			String username = "Quadfather";
			String password = "1MoreRep";
			User testUser = new User();
			testUser.setUserID(1);
			testUser.setFname("Tom");
			testUser.setLname("Platz");
			testUser.setUsername("Quadfather");
			testUser.setPassword("1MoreRep");
			Mockito.when(repo.findByUsernameAndPassword(username, password)).thenReturn(testUser);
			
			testUser = serv.login(username, password);
			Assertions.assertEquals("Platz", testUser.getLname());
			
			testUser = serv.logout(testUser);
			Assertions.assertNull(testUser);
		}
}
