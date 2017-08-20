package services;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import dao.CarrelloDao;
import entity.Carrello;

@Path("/CarrelloService")
public class CarrelloService {
	
	@GET
	@Path("/getAllItemsSelected")
	@Produces("application/json")
	public List<Carrello> getAllItemsSelected(@QueryParam("idUser") int idUser){
		return CarrelloDao.getInstance().getAllItemsSelected(idUser);
	}
	
	@GET
	@Path("/getItemSelectedByID")
	@Produces("application/json")
	public Carrello getItemSelectedByID (@QueryParam("idUser") int idUser ,
			@QueryParam("idItem") int idItem){
		return CarrelloDao.getInstance().getItemSelectedByID(idUser,idItem);
	}	
	
	@POST
	@Path("/addSelectedItem")
	@Produces("application/json")
	public void addSelectedItem (@QueryParam("Carrello") Carrello cr){
		CarrelloDao.getInstance().addSelectedItem(cr);
	}
	
	@DELETE
	@Path("/deleteItemSelected")
	@Produces("application/json")
	public void deleteItemSelected (@QueryParam("Carrello") Carrello cr){
		CarrelloDao.getInstance().deleteItemSelected(cr);
	}

}
