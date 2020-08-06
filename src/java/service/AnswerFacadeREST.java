
package service;

import data.Answer;
import java.text.ParseException;
import java.util.List;
import javax.ejb.Stateless;
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
import javax.json.JsonArray;
import javax.json.JsonObject;

/**
 *
 * @author User
 */
@Stateless
@Path("data.answer")
public class AnswerFacadeREST extends AbstractFacade<Answer> {

    @PersistenceContext(unitName = "ServerAppPU")
    private EntityManager em;

    public AnswerFacadeREST() {
        super(Answer.class);
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON})
    public Response create(JsonArray arr) throws ParseException 
    {           
        JsonObject json=arr.getJsonObject(0);
        Answer entity=new Answer(json);

        if(CheckIfQuestionHasAsked(entity.getIdQ().getIdQ(),entity.getIdP().getIdP())==null)         
        {
            //Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //String time = formatter.format(entity.getTime());

            Query query = em.createNativeQuery("insert into Answer(answer,correct,time,id_p,id_q)" +
                " VALUES(\'"+entity.getAnswer()+"\',\'"+entity.getCorrect()+"\',\'"+json.getString("time")+"\',"+entity.getIdP().getIdP()+","+entity.getIdQ().getIdQ()+")");

            query.executeUpdate();

            return Response.status(Response.Status.OK).build();
        } 
        return Response.status(Response.Status.BAD_REQUEST).build();
            
    }
   
    
    @GET
    @Path("/findbyexaminee/{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Answer> findByExaminee(@PathParam("id") Integer id) 
    {
        if(id==null)
            return null;
        
            //String sql = "SELECT Answer.* FROM Answer WHERE id_p = ?";

            String sql = "SELECT * FROM Answer  WHERE  id_p="+id;
            Query query = em.createNativeQuery(sql, Answer.class);
            List<Answer> list= query.getResultList();
            return list;
        
    }
    
    @GET
    @Path("/findbyexam/{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Answer> findByExam(@PathParam("id") Integer id) 
    {
        if(id==null)
            return null;
       
            String sql = "SELECT * FROM Answer  WHERE  id_p in (Select id_p from examinee where exam_id="+id+")";
            Query query = em.createNativeQuery(sql, Answer.class);
            List<Answer> list= query.getResultList();
            return list;
        
    }
    
    
    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON})

    public void edit(@PathParam("id") Integer id, Answer entity) {
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
    public Answer find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Answer> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Answer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("/max")
    @Produces({ MediaType.APPLICATION_JSON})
    public Integer findMax() {
    try{
            TypedQuery<Integer> query=em.createNamedQuery("Answer.findMax", Integer.class);
            return query.getSingleResult();
        }catch(Exception e)
        {
            return null;
        }
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
    private Answer CheckIfQuestionHasAsked(Integer idQ,Integer idP)
    {
       try
        {
            Query query = em.createNativeQuery("SELECT * FROM Answer WHERE id_P = "+idP+" and id_Q = "+idQ );
            Answer temp=(Answer)query.getSingleResult();
            System.out.print(temp.toString()); 
            return temp;
        }catch(Exception e)
        {
            return null;
        }
    }
    
}
