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
import com.revature.repos.UserRepo;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.example.demo.QcDataReportAppApplication.class)
public class UserServiceTest {

	@MockBean
	UserRepo repo;
	
	@Autowired
	UserService serv;
	
	
	@Test
	void getAllUsers() {
		int userSize=3;
		List<User> allUsers = new ArrayList<User>();
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new User(), new User(), new User()).collect(Collectors.toList()));
		
		allUsers = serv.getAllUsers();
		Assertions.assertEquals(userSize, allUsers.size());
	}
	
	@Test
	void getAllUsersByFirstName() {
		int id=1;
		String firstName="first1";
		
		User user1= new User();
		user1.setId(1);
		user1.setEmail("mock1@mockito.com");
		user1.setFirstName("first1");
		user1.setLastName("last1");
		user1.setPassword("password1");
		user1.setAdmin(false);
		
		User user2= new User();
		user2.setId(2);
		user2.setEmail("mock2@mockito.com");
		user2.setFirstName("first2");
		user2.setLastName("last2");
		user2.setPassword("password2");
		user2.setAdmin(false);
	
		
		
		List<User> allUsers = new ArrayList<User>();
		Mockito.when(repo.findByFirstName("first1")).thenReturn(Stream.of(user1).collect(Collectors.toList()));
		
		allUsers= serv.getUsersByFirstName(firstName);
		Assertions.assertEquals(1, allUsers.size());
		Assertions.assertEquals(id, allUsers.get(0).getId());

	}
	
	@Test
	void getAllUsersByLastName() {
		int id=1;
		String lastName="last1";
		
		User user1= new User();
		user1.setId(1);
		user1.setEmail("mock1@mockito.com");
		user1.setFirstName("first1");
		user1.setLastName("last1");
		user1.setPassword("password1");
		user1.setAdmin(false);
		
		User user2= new User();
		user2.setId(2);
		user2.setEmail("mock2@mockito.com");
		user2.setFirstName("first2");
		user2.setLastName("last2");
		user2.setPassword("password2");
		user2.setAdmin(false);
	
		
		
		List<User> allUsers = new ArrayList<User>();
		Mockito.when(repo.findByLastName("last1")).thenReturn(Stream.of(user1).collect(Collectors.toList()));
		
		allUsers= serv.getUsersByLastName(lastName);
		Assertions.assertEquals(1, allUsers.size());
		Assertions.assertEquals(id, allUsers.get(0).getId());
	}
	
	@Test
	void getAllUsersByAdmin() {
		int id=1;
		boolean admin=false;
		
		User user1= new User();
		user1.setId(1);
		user1.setEmail("mock1@mockito.com");
		user1.setFirstName("first1");
		user1.setLastName("last1");
		user1.setPassword("password1");
		user1.setAdmin(false);
		
		User user2= new User();
		user2.setId(2);
		user2.setEmail("mock2@mockito.com");
		user2.setFirstName("first2");
		user2.setLastName("last2");
		user2.setPassword("password2");
		user2.setAdmin(true);
	
		
		
		List<User> allUsers = new ArrayList<User>();
		Mockito.when(repo.findByAdmin(false)).thenReturn(Stream.of(user1).collect(Collectors.toList()));
		
		allUsers= serv.getUsersByAdmin(admin);
		Assertions.assertEquals(1, allUsers.size());
		Assertions.assertEquals(id, allUsers.get(0).getId());
	}
	
	@Test
	void getUserById() {
		int id=1;
		User user= new User();
		User userTest = new User();
		userTest.setId(1);
		userTest.setEmail("mock@mockito.com");
		userTest.setFirstName("first");
		userTest.setLastName("last");
		userTest.setPassword("password");
		userTest.setAdmin(false);

		Mockito.when(repo.findById(id)).thenReturn(Optional.of(userTest));
		
		user=serv.getUser(id);
		Assertions.assertEquals("first",user.getFirstName());
		Assertions.assertEquals(1, user.getId());
		
		
	}
	
	@Test
	void getUserByEmail() {
		User user= new User();
		String email="mock@mockito.com" ;
		User userTest = new User();
		userTest.setId(1);
		userTest.setEmail("mock@mockito.com");
		userTest.setFirstName("first");
		userTest.setLastName("last");
		userTest.setPassword("password");
		userTest.setAdmin(false);
		
		Mockito.when(repo.findByEmail(email)).thenReturn(userTest);
		
		user=serv.getUserByEmail(email);
		Assertions.assertEquals(email, user.getEmail());
		Assertions.assertEquals(1,user.getId());
	}
	
	@Test
	void addUser() {
		User user = new User();
		User userTest = new User();
		userTest.setId(1);
		userTest.setEmail("mock@mockito.com");
		userTest.setFirstName("first");
		userTest.setLastName("last");
		userTest.setPassword("password");
		userTest.setAdmin(false);
		Mockito.when(repo.save(userTest)).thenReturn(userTest);
		
		user=serv.addUser(userTest);
		Assertions.assertEquals("first", userTest.getFirstName());
	}
	
	@Test
	void updateUser() {
		User userTest=new User();
		userTest.setId(1);
		userTest.setEmail("mock@mockito.com");
		userTest.setFirstName("first");
		userTest.setLastName("last");
		userTest.setPassword("password");
		userTest.setAdmin(false);
		
		Mockito.when(repo.save(userTest)).thenReturn(userTest);
		
		Assertions.assertEquals("first", userTest.getFirstName());		
		userTest.setFirstName("second");
		userTest.setLastName("LAST");
		userTest = serv.updateUser(userTest);
		Assertions.assertEquals("second", userTest.getFirstName());
		Assertions.assertEquals("LAST", userTest.getLastName());
	}
	
	@Test
	void deleteUser() {
		int id=1;
		User userTest = new User();
		userTest.setId(1);
		userTest.setEmail("mock@mockito.com");
		userTest.setFirstName("first");
		userTest.setLastName("last");
		userTest.setPassword("password");
		userTest.setAdmin(false);
		
		Mockito.when(repo.findById(id)).thenReturn(Optional.of(userTest));
		Mockito.when(repo.findById(0)).thenThrow(IllegalArgumentException.class);
		
		Assertions.assertEquals(true, serv.deleteUser(id));
		verify(repo,times(1)).delete(userTest);
		
		Assertions.assertEquals(false, serv.deleteUser(0));
		
		
	}
}
