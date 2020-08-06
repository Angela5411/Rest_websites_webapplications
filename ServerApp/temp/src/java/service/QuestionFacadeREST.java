package service;

import data.Question;
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
@Path("data.question")
public class QuestionFacadeREST extends AbstractFacade<Question> {

    @PersistenceContext(unitName = "ServerAppPU")
    private EntityManager em;

    public QuestionFacadeREST() {
        super(Question.class);
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON})
    public Response create(JsonArray arr)
    {           
        JsonObject json=arr.getJsonObject(0);
        Question entity=new Question(json);


            //Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //String time = formatter.format(entity.getTime());
            try{
            Query query = em.createNativeQuery("insert into Question(question,a1,a2,a3,a4,correct)" +
                " VALUES(\'"+entity.getQuestion()+"\',\'"+entity.getA1()+"\',\'"+entity.getA2()+"\',\'"+entity.getA3()+"\',\'"+entity.getA4()+"\',"+entity.getCorrect()+")");

            query.executeUpdate();

            return Response.status(Response.Status.OK).build();
            }
            catch(Exception e)
            {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            
    }

    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Question entity) {
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
    public Question find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Question> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Question> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
 
    private Question CheckIfQuestionExists(String question)
    {
        if(question==null)
            return null;
        try
        {
            TypedQuery<Question> query=em.createNamedQuery("Question.findByQuestion", Question.class);
            query.setParameter("question", question);
            return query.getSingleResult();
        }catch(Exception e)
        {
            return null;
        }
    }
}
