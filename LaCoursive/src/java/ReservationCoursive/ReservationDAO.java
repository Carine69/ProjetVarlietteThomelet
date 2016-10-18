/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservationCoursive;

import AssociationCursive.Association;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author thomd
 */
@Stateless
public class ReservationDAO {

    @PersistenceContext(unitName = "LaCoursivePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    
    // "Insert Code > Add Business Method")

    public void businessMethod() {
    }
    
     public List<Reservation> getAllReservation(){
        Query query =em.createNamedQuery("Reservation.findAll");
        try{
            return query.getResultList();
        }
        catch ( Exception e){
            System.out.println(e.getMessage()); }
        return null;
    }
    
    public Reservation getOneReservation(int id){
        Query query =em.createNamedQuery("Reservation.findById").setParameter("id",id);
        try{
            return (Reservation)query.getSingleResult();
        }
        catch (Exception e){
            System.err.println("pas de reservation avec cet ID"); 
        }
        return null;
    }
    
    public void saveReservations(Reservation reservation){
        try
        {
                if(reservation.getIdReservation()!=null)
                {
                    em.merge(reservation); /* mise a jour*/
                }
                else
                {
                    em.persist(reservation); /*sauve dans base car nouvezau*/
                }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    
    public void supprimeReservation(Reservation reservation) {
        try
        {
            em.remove(em.merge(reservation));
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());  
        }
    }   
}
