/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssociationCursive;

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
@Named(value = "associationController")
@ViewScoped
public class AssociationController implements Serializable{

    @EJB
    private AssociationDAO associationDAO;
    private Association saisieAssociation;
    
    int id;
    
    public AssociationController() {
         saisieAssociation = new Association();
    }

    public Association getSaisieAssociation() {
        return saisieAssociation;
    }

    public void setSaisieAssociation(Association saisieAssociation) {
        this.saisieAssociation = saisieAssociation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Association> getAssociations(){
        System.out.println(associationDAO.getAllAssociations().size());
        return associationDAO.getAllAssociations();
    }
    
    public String saveAssociation(){
        associationDAO.saveAssociations(saisieAssociation);
        return "NouvelleReservation";
    }
    
    public void lireAssociation(ComponentSystemEvent event){
        saisieAssociation= associationDAO.getOneAssociation(id);  
    }
 
}
