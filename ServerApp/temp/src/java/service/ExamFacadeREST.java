
package service;

import data.Exam;
import java.text.ParseException;
import java.util.Date;
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
@Path("data.exam")
public class ExamFacadeREST extends AbstractFacade<Exam> {

    @PersistenceContext(unitName = "ServerAppPU")
    private EntityManager em;

    public ExamFacadeREST() {
        super(Exam.class);
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON})
    public Response create(JsonArray arr) throws ParseException 
    {           
        JsonObject json=arr.getJsonObject(0);
        Exam entity=new Exam(json);
        try
        {
            //Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //String time = formatter.format(entity.getTime());
            Query query;
            if(entity.getExamDate()!=null)
                query= em.createNativeQuery("insert into Exam(exam_date,e_center_id)" +
                " VALUES(\'"+json.getString("examDate")+"\',"+entity.getECenterId().getECenterId()+")");
            else
                query= em.createNativeQuery("insert into Exam(e_center_id)" +
                " VALUES("+entity.getECenterId().getECenterId()+")");
            query.executeUpdate();

            return Response.status(Response.Status.OK).build();
        } catch(Exception e){
        return Response.status(Response.Status.BAD_REQUEST).build();}
            
    }

    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Exam entity) {
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
    public Exam find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Exam> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Exam> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    
     @GET
    @Path("/max")
    @Produces({ MediaType.APPLICATION_JSON})
    public Integer findMax() {
    try{
            TypedQuery<Integer> query=em.createNamedQuery("Exam.findMax", Integer.class);
            return query.getSingleResult();
        }catch(Exception e)
        {
            return null;
        }
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    private Exam CheckIfDateExists(Date examDate)
    {
        if(examDate==null)
            return null;
        try
        {
            TypedQuery<Exam> query=em.createNamedQuery("Exam.findByExamDate", Exam.class);
            query.setParameter("examDate", examDate);
            return query.getSingleResult();
        }catch(Exception e)
        {
            return null;
        }
    }
    
    @POST
    @Consumes({ MediaType.APPLICATION_JSON}) 
    @Path("/updateexam")
    public Response updateExaminee(JsonArray arr)
    {
     try
        {
            JsonObject json=arr.getJsonObject(0);
            Exam entity=new Exam(json);
            if(json.containsKey("examDate"))
                this.UpdateExam(entity,json.getString("examDate"));
            else
                this.UpdateExam(entity, null);
            return Response.status(Response.Status.OK).build();
        } catch(Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }   
    }
    
    @GET
    @Path("/findbyecenter/{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Exam> findByECenter(@PathParam("id") Integer id) 
    {
        if(id==null)
            return null;
       
            String sql = "SELECT * FROM exam  WHERE  e_center_id="+id;
            Query query = em.createNativeQuery(sql, Exam.class);
            List<Exam> list= query.getResultList();
            return list;
        
    }
    
    
    private Response UpdateExam(Exam exam,String time)
    {
        try
        {
            Query query;
            if(time!=null)
                query= em.createNativeQuery("update exam "+
                    "set exam_date=\'" +time+"\' , e_center_id="+exam.getECenterId().getECenterId()+
                    " where exam_id="+exam.getExamId());
            else
                query= em.createNativeQuery("update exam "+
                    "set e_center_id="+exam.getECenterId().getECenterId()+
                    " where exam_id="+exam.getExamId());
            query.executeUpdate();

            return Response.status(Response.Status.OK).build();
        }catch(Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();               
        }
    }
    
    
}
