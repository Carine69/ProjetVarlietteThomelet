/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservationCoursive;


import AssociationCursive.Association;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Carine
 */
@Named(value = "reservationController")
@ViewScoped
public class ReservationController implements Serializable{

    @EJB
    private ReservationDAO reservationDAO;
    private Reservation saisieReservation;
    
    int id;
    
    public ReservationController() {
         saisieReservation = new Reservation();
    }

    public Reservation getSaisieReservation() {
        return saisieReservation;
    }

    public void setsaisieReservation(Reservation saisieReservation) {
        this.saisieReservation = saisieReservation;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public List<Reservation> getReservations(){
        System.out.println(reservationDAO.getAllReservations().size());
        return reservationDAO.getAllReservations();
    }
    
    public String saveAssociation(){
        reservationDAO.saveReservations(saisieReservation);
        return "NouvelleReservation";
    }
    
    public void lireReservation(ComponentSystemEvent event){
        saisieReservation= reservationDAO.getOneReservation(id);  
    }
 
    
}
