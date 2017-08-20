/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alessio
 */
@Entity
@Table(name = "carrello")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrello.findAll", query = "SELECT c FROM Carrello c")
    , @NamedQuery(name = "Carrello.findByUsersIdusers", query = "SELECT c FROM Carrello c WHERE c.carrelloPK.usersIdusers = :usersIdusers")
    , @NamedQuery(name = "Carrello.findByItemsIditems", query = "SELECT c FROM Carrello c WHERE c.carrelloPK.itemsIditems = :itemsIditems")
    , @NamedQuery(name = "Carrello.findByQnt", query = "SELECT c FROM Carrello c WHERE c.qnt = :qnt")})
public class Carrello implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CarrelloPK carrelloPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qnt")
    private Double qnt;
    @JoinColumn(name = "items_iditems", referencedColumnName = "iditems", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;
    @JoinColumn(name = "users_idusers", referencedColumnName = "idusers", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Carrello() {
    }

    public Carrello(CarrelloPK carrelloPK) {
        this.carrelloPK = carrelloPK;
    }

    public Carrello(int usersIdusers, int itemsIditems) {
        this.carrelloPK = new CarrelloPK(usersIdusers, itemsIditems);
    }

    public CarrelloPK getCarrelloPK() {
        return carrelloPK;
    }

    public void setCarrelloPK(CarrelloPK carrelloPK) {
        this.carrelloPK = carrelloPK;
    }

    public Double getQnt() {
        return qnt;
    }

    public void setQnt(Double qnt) {
        this.qnt = qnt;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carrelloPK != null ? carrelloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrello)) {
            return false;
        }
        Carrello other = (Carrello) object;
        if ((this.carrelloPK == null && other.carrelloPK != null) || (this.carrelloPK != null && !this.carrelloPK.equals(other.carrelloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Carrello[ carrelloPK=" + carrelloPK + " ]";
    }
    
}
