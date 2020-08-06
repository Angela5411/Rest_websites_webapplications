
package service;

import data.ECenter;
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
@Path("data.ecenter")
public class ECenterFacadeREST extends AbstractFacade<ECenter> {

    @PersistenceContext(unitName = "ServerAppPU")
    private EntityManager em;

    public ECenterFacadeREST() {
        super(ECenter.class);
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON})
    public Response create(JsonArray arr)
    {           
        JsonObject json=arr.getJsonObject(0);
        ECenter entity=new ECenter(json);
        try{
        Query query = em.createNativeQuery("insert into e_center(e_center_name,e_center_address)" +
                " VALUES(\'"+entity.getECenterName()+"\',\'"+entity.getECenterAddress()+"\'"+")");

            query.executeUpdate();

            return Response.status(Response.Status.OK).build();
        } 
        catch(Exception e)
        {return Response.status(Response.Status.BAD_REQUEST).build();}
    }
    
    @POST
    @Consumes({ MediaType.APPLICATION_JSON}) 
    @Path("/updateecenter")
    public Response updateExaminee(JsonArray arr)
    {
     try
        {
            JsonObject json=arr.getJsonObject(0);
            ECenter entity=new ECenter(json);
            this.UpdateECenter(entity);
            return Response.status(Response.Status.OK).build();
        } catch(Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }   
    }
    
    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, ECenter entity) {
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
    public ECenter find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({ MediaType.APPLICATION_JSON})
    public List<ECenter> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<ECenter> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    private ECenter CheckIfNameExists(String eCenterName)
    {
        if(eCenterName==null)
            return null;
        try
        {
            TypedQuery<ECenter> query=em.createNamedQuery("ECenter.findByECenterName", ECenter.class);
            query.setParameter("eCenterName", eCenterName);
            return query.getSingleResult();
        }catch(Exception e)
        {
            return null;
        }
    }
    
    @GET
    @Path("/ecentername/{name}")
    @Produces({ MediaType.APPLICATION_JSON})
    public ECenter findByUsername(@PathParam("name") String name) {
        return CheckIfNameExists(name);
    }
    
    private Response UpdateECenter(ECenter ecenter)
    {
        try
        {
            Query query = em.createNativeQuery("update e_center "+
                    "set e_center_name=\'" +ecenter.getECenterName()+"\' , e_center_address=\'"+ecenter.getECenterAddress()+
                    "\' where e_center_id="+ecenter.getECenterId());
            query.executeUpdate();

            return Response.status(Response.Status.OK).build();
        }catch(Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();               
        }
    }
}
