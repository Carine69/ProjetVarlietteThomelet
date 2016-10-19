/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservationCoursive;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carine
 */
@Entity
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
    @NamedQuery(name = "Reservation.findByIdReservation", query = "SELECT r FROM Reservation r WHERE r.idReservation = :idReservation"),
    @NamedQuery(name = "Reservation.findByIdAssociation", query = "SELECT r FROM Reservation r WHERE r.idAssociation = :idAssociation"),
    @NamedQuery(name = "Reservation.findByNomSpectacle", query = "SELECT r FROM Reservation r WHERE r.nomSpectacle = :nomSpectacle"),
    @NamedQuery(name = "Reservation.findByValide", query = "SELECT r FROM Reservation r WHERE r.valide = :valide"),
    @NamedQuery(name = "Reservation.findByDateR", query = "SELECT r FROM Reservation r WHERE r.dateR = :dateR")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdReservation")
    private Integer idReservation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdAssociation")
    private int idAssociation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NomSpectacle")
    private String nomSpectacle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Valide")
    private boolean valide;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateR")
    @Temporal(TemporalType.DATE)
    private Date dateR;

    public Reservation() {
    }

    public Reservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Reservation(Integer idReservation, int idAssociation, String nomSpectacle, boolean valide, String description, Date dateR) {
        this.idReservation = idReservation;
        this.idAssociation = idAssociation;
        this.nomSpectacle = nomSpectacle;
        this.valide = valide;
        this.description = description;
        this.dateR = dateR;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdAssociation() {
        return idAssociation;
    }

    public void setIdAssociation(int idAssociation) {
        this.idAssociation = idAssociation;
    }

    public String getNomSpectacle() {
        return nomSpectacle;
    }

    public void setNomSpectacle(String nomSpectacle) {
        this.nomSpectacle = nomSpectacle;
    }

    public boolean getValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateR() {
        return dateR;
    }

    public void setDateR(Date dateR) {
        this.dateR = dateR;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservation != null ? idReservation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.idReservation == null && other.idReservation != null) || (this.idReservation != null && !this.idReservation.equals(other.idReservation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReservationCoursive.Reservation[ idReservation=" + idReservation + " ]";
    }
    
}
