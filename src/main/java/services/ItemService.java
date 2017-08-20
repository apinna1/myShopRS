package services;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import dao.ItemDao;
import entity.Item;

@Path("/ItemService")
public class ItemService {
	
	@GET
	@Path("/getAllitems")
	@Produces("application/json")
	public List<Item> getAllItems(){
		return ItemDao.getInstance().getAllItems();
	}
	
	@GET
	@Path("/getItemById")
	@Produces("application/json")
	public Item getItemById(@QueryParam("id") int id){
		return ItemDao.getInstance().getItemById(id);
	}
	
	@POST
	@Path("/additem")
	@Produces("application/json")
	public void additem(@QueryParam("item") Item us) {
		ItemDao.getInstance().addItem(us);
	}
	
	@POST
	@Path("/updateitem")
	@Produces("application/json")
	public void updateitem(@QueryParam("item") Item us) {
		ItemDao.getInstance().updateItem(us);
	}
	
	@DELETE
	@Path("/deleteitem")
	@Produces("application/json")
	public void deleteitem(@QueryParam("item") Item us) {
		ItemDao.getInstance().deleteItem(us);
	}

}
