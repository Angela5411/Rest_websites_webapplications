
package service;

import data.Examinee;
import java.text.ParseException;
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
@Path("data.examinee")
public class ExamineeFacadeREST extends AbstractFacade<Examinee> {

    @PersistenceContext(unitName = "ServerAppPU")
    private EntityManager em;

    public ExamineeFacadeREST() {
        super(Examinee.class);
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON}) 
    public Response create(JsonArray arr) throws ParseException 
    {           
        JsonObject json=arr.getJsonObject(0);
        Examinee entity=new Examinee(json);
        try
        {
            //Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //String time = formatter.format(entity.getTime());
            Query query;
            if(entity.getExamId()==null)
                query = em.createNativeQuery("insert into Examinee(name,username,password_hash)" +
                " VALUES(\'"+entity.getName()+"\',\'"+entity.getUsername()+"\',\'"+entity.getPasswordHash()+"\'"+ ")");

            else
                query = em.createNativeQuery("insert into Examinee(name,username,password_hash,exam_id)" +
                " VALUES(\'"+entity.getName()+"\',\'"+entity.getUsername()+"\',\'"+entity.getPasswordHash()+"\',"+entity.getExamId().getExamId()+ ")");

            query.executeUpdate();

            return Response.status(Response.Status.OK).build();
        } catch(Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }    
    }
    
    @POST
    @Consumes({ MediaType.APPLICATION_JSON}) 
    @Path("/updateexaminee")
    public Response updateExaminee(JsonArray arr)
    {
     try
        {
            JsonObject json=arr.getJsonObject(0);
            Examinee entity=new Examinee(json);
            this.UpdateExaminee(entity);
            return Response.status(Response.Status.OK).build();
        } catch(Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }   
    }


    
    
    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Examinee entity) {
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
    public Examinee find(@PathParam("id") Integer id) {
        return super.find(id);
    }
   

    @GET
    @Override
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Examinee> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Examinee> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    @GET
    @Path("/updateexam/{idP}/{idE}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public Response updateExam(@PathParam("idP") Integer idP,@PathParam("idE") Integer idE) throws ParseException {
        return UpdateExam(idP,idE);
    }

    @GET
    @Path("/findbyexam/{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Examinee> findByExam(@PathParam("id") Integer id) 
    {
        if(id==null)
            return null;
       
            String sql = "SELECT * FROM Examinee  WHERE  exam_id="+id;
            Query query = em.createNativeQuery(sql, Examinee.class);
            List<Examinee> list= query.getResultList();
            return list;
        
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
    
    private Examinee CheckIfUsernameExists(String username)
    {
        if(username==null)
            return null;
        try
        {
            TypedQuery<Examinee> query=em.createNamedQuery("Examinee.findByUsername", Examinee.class);
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
    public Examinee findByUsername(@PathParam("username") String username) {
        return CheckIfUsernameExists(username);
    }

    private Response UpdateExam(Integer idP,Integer idE) throws ParseException 
    {           
        
        try
        {
            Query query = em.createNativeQuery("update Examinee set exam_id=" +
               idE+" where id_p="+idP);
            query.executeUpdate();

            return Response.status(Response.Status.OK).build();
        } catch(Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();}     
    }
    
    private Response UpdateExaminee(Examinee examinee)
    {
        try
        {
            Query query = em.createNativeQuery("update Examinee "+
                    "set name=\'" +examinee.getName()+"\' , username=\'"+examinee.getUsername()+"\' , password_hash=\'"+examinee.getPasswordHash()+
                    "\' where id_p="+examinee.getIdP());
            query.executeUpdate();

            return Response.status(Response.Status.OK).build();
        }catch(Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();               
        }
    }
    
}
