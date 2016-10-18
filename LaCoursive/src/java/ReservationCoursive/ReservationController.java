/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservationCoursive;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Carine
 */
@Named(value = "reservationController")
@ViewScoped
public class ReservationController {

    @EJB
    private ReservationDAO reservationDAO;


    public ReservationController() {
    }
    
}
