/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Alessio
 */
@Embeddable
public class CarrelloPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "users_idusers")
    private int usersIdusers;
    @Basic(optional = false)
    @Column(name = "items_iditems")
    private int itemsIditems;

    public CarrelloPK() {
    }

    public CarrelloPK(int usersIdusers, int itemsIditems) {
        this.usersIdusers = usersIdusers;
        this.itemsIditems = itemsIditems;
    }

    public int getUsersIdusers() {
        return usersIdusers;
    }

    public void setUsersIdusers(int usersIdusers) {
        this.usersIdusers = usersIdusers;
    }

    public int getItemsIditems() {
        return itemsIditems;
    }

    public void setItemsIditems(int itemsIditems) {
        this.itemsIditems = itemsIditems;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usersIdusers;
        hash += (int) itemsIditems;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarrelloPK)) {
            return false;
        }
        CarrelloPK other = (CarrelloPK) object;
        if (this.usersIdusers != other.usersIdusers) {
            return false;
        }
        if (this.itemsIditems != other.itemsIditems) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.CarrelloPK[ usersIdusers=" + usersIdusers + ", itemsIditems=" + itemsIditems + " ]";
    }
    
}
