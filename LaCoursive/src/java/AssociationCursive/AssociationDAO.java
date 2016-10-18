/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssociationCursive;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Carine
 */
@Stateless
public class AssociationDAO {

    @PersistenceContext(unitName = "LaCoursivePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public void businessMethod() { 
    }
    
   public List<Association> getAllAssociations(){
        Query query =em.createNamedQuery("Association.findAll");
        try{
            return query.getResultList();
        }
        catch ( Exception e){
            System.out.println(e.getMessage()); }
        return null;
    }
    
    public Association getOneAssociation(int id){
        Query query =em.createNamedQuery("Association.findById").setParameter("id",id);
        try{
            return (Association)query.getSingleResult();
        }
        catch (Exception e){
            System.err.println("pas d'associaiton avec cet ID"); 
        }
        return null;
    }
    
    public void saveAssociations(Association association){
        try
        {
                if(association.getIdAssociation()!=null)
                {
                    em.merge(association); /* mise a jour*/
                }
                else
                {
                    em.persist(association); /*sauve dans base car nouvezau*/
                }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    
    public void supprimeAssociation(Association association) {
        try
        {
            em.remove(em.merge(association));
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());  
        }
    }   
}
