package services;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import dao.UserDao;
import entity.User;


@Path("/UserService")
public class UserService {
	
	@GET
	@Path("/getAllUsers")
	@Produces("application/json")
	public List<User> getAllUsers(){
		return UserDao.getInstance().getAllUsers();
	}
	
	@GET
	@Path("/getUserByID")
	@Produces("application/json")
	public User getUserByID(@QueryParam("id") int id){
		return UserDao.getInstance().getUserById(id);
	}
	
	@GET
	@Path("/getUserByUsername")
	@Produces("application/json")
	public User getUserByUsername(@QueryParam("username") String username){
		return UserDao.getInstance().getUserByUsername(username);
	}
	
	@POST
	@Path("/addUser")
	@Produces("application/json")
	public void addUser(@QueryParam("nomeUtente") String nome,
			@QueryParam("cognomeUtente") String cognome,
			@QueryParam("usernameUtente") String username,
			@QueryParam("passwordUtente") String password,
			@QueryParam("emailUtente") String email) {
		User us = new User();
		us.setNome(nome);
		us.setCognome(cognome);
		us.setUsername(username);
		us.setPassword(password);
		us.setEmail(email);
		UserDao.getInstance().addUser(us);
	}
	
	@POST
	@Path("/updateUser")
	@Produces("application/json")
	public void updateUser(@QueryParam("User") User us) {
		UserDao.getInstance().updateUser(us);
	}
	
	@DELETE
	@Path("/deleteUser")
	@Produces("application/json")
	public void deleteUser(@QueryParam("User") User us) {
		UserDao.getInstance().deleteUser(us);
	}

}
