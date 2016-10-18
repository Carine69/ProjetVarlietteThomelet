/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssociationCursive;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carine
 */
@Entity
@Table(name = "association")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Association.findAll", query = "SELECT a FROM Association a"),
    @NamedQuery(name = "Association.findByIdAssociation", query = "SELECT a FROM Association a WHERE a.idAssociation = :idAssociation"),
    @NamedQuery(name = "Association.findByNomAssociation", query = "SELECT a FROM Association a WHERE a.nomAssociation = :nomAssociation"),
    @NamedQuery(name = "Association.findByNomContact", query = "SELECT a FROM Association a WHERE a.nomContact = :nomContact"),
    @NamedQuery(name = "Association.findByPrenomContact", query = "SELECT a FROM Association a WHERE a.prenomContact = :prenomContact"),
    @NamedQuery(name = "Association.findByTelephone", query = "SELECT a FROM Association a WHERE a.telephone = :telephone"),
    @NamedQuery(name = "Association.findByTypeAssociation", query = "SELECT a FROM Association a WHERE a.typeAssociation = :typeAssociation")})
public class Association implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdAssociation")
    private Integer idAssociation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NomAssociation")
    private String nomAssociation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NomContact")
    private String nomContact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PrenomContact")
    private String prenomContact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Telephone")
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TypeAssociation")
    private String typeAssociation;

    public Association() {
    }

    public Association(Integer idAssociation) {
        this.idAssociation = idAssociation;
    }

    public Association(Integer idAssociation, String nomAssociation, String nomContact, String prenomContact, String telephone, String typeAssociation) {
        this.idAssociation = idAssociation;
        this.nomAssociation = nomAssociation;
        this.nomContact = nomContact;
        this.prenomContact = prenomContact;
        this.telephone = telephone;
        this.typeAssociation = typeAssociation;
    }

    public Integer getIdAssociation() {
        return idAssociation;
    }

    public void setIdAssociation(Integer idAssociation) {
        this.idAssociation = idAssociation;
    }

    public String getNomAssociation() {
        return nomAssociation;
    }

    public void setNomAssociation(String nomAssociation) {
        this.nomAssociation = nomAssociation;
    }

    public String getNomContact() {
        return nomContact;
    }

    public void setNomContact(String nomContact) {
        this.nomContact = nomContact;
    }

    public String getPrenomContact() {
        return prenomContact;
    }

    public void setPrenomContact(String prenomContact) {
        this.prenomContact = prenomContact;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTypeAssociation() {
        return typeAssociation;
    }

    public void setTypeAssociation(String typeAssociation) {
        this.typeAssociation = typeAssociation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAssociation != null ? idAssociation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Association)) {
            return false;
        }
        Association other = (Association) object;
        if ((this.idAssociation == null && other.idAssociation != null) || (this.idAssociation != null && !this.idAssociation.equals(other.idAssociation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AssociationCursive.Association[ idAssociation=" + idAssociation + " ]";
    }
    
}
