
package service;

import data.Administrator;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author User
 */
@Stateless
@Path("data.administrator")
public class AdministratorFacadeREST extends AbstractFacade<Administrator> {

    @PersistenceContext(unitName = "ServerAppPU")
    private EntityManager em;

    public AdministratorFacadeREST() {
        super(Administrator.class);
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON})
    public Response create(JsonArray arr)
    {           
        JsonObject json=arr.getJsonObject(0);
        Administrator entity=new Administrator(json);


            //Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //String time = formatter.format(entity.getTime());
            try{
            Query query = em.createNativeQuery("insert into Administrator(username,password_hash,e_center_id)" +
                " VALUES(\'"+entity.getUsername()+"\',\'"+entity.getPasswordHash()+"\',"+entity.getECenterId().getECenterId()+")");

            query.executeUpdate();

            return Response.status(Response.Status.OK).build();
            }
            catch(Exception e)
            {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }   
    }
    
    @POST
    @Consumes({ MediaType.APPLICATION_JSON}) 
    @Path("/updateadministrator")
    public Response updateAdministrator(JsonArray arr)
    {
     try
        {
            JsonObject json=arr.getJsonObject(0);
            Administrator entity=new Administrator(json);
            this.UpdateAdministrator(entity);
            return Response.status(Response.Status.OK).build();
        } catch(Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }   
    }
    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Administrator entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Administrator find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Administrator> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Administrator> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    private Administrator CheckIfUsernameExists(String username)
    {
        if(username==null)
            return null;
        try
        {
            TypedQuery<Administrator> query=em.createNamedQuery("Administrator.findByUsername", Administrator.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        }catch(Exception e)
        {
            return null;
        }
    }
    
    @GET
    @Path("/username/{username}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Administrator findByUsername(@PathParam("username") String username) {
        return CheckIfUsernameExists(username);
    }  
    
    @GET
    @Path("/findbyecenterid/{eid}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Administrator findByECenter(@PathParam("eid") Integer id) 
    {
        if(id==null)
            return null;
        try
        {
           //"Select * from Administrator "+" where e_center_id="+id
            String sql = "SELECT Administrator.* FROM Administrator WHERE e_center_id = ?";
            Query query = em.createNativeQuery(sql, Administrator.class);
            query.setParameter(1, id);
            return (Administrator) query.getSingleResult();
            
        }catch(Exception e)
        {
            return null;
        }

    }
    
    
    @GET
    @Path("/findbyecentername/{ename}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Administrator findByECenter(@PathParam("ename") String name) 
    {
        if(name.equals(""))
            return null;
        try
        {
            String sql = "SELECT Administrator.* FROM Administrator WHERE e_center_id =(Select E_Center.e_center_id from E_Center where e_center_name= ?)";
            Query query = em.createNativeQuery(sql, Administrator.class);
            query.setParameter(1, name);
            return (Administrator) query.getSingleResult();
            
        }catch(Exception e)
        {
            return null;
        }

    }
    private Response UpdateAdministrator(Administrator admin)
    {
        try
        {
            Query query = em.createNativeQuery("update Administrator "+
                    "set username=\'" +admin.getUsername()+"\' , password_hash=\'"+admin.getPasswordHash()+"\' ,e_center_id="+admin.getECenterId().getECenterId()+
                    " where id_p="+admin.getIdP());
            query.executeUpdate();

            return Response.status(Response.Status.OK).build();
        }catch(Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();               
        }
    }
}
