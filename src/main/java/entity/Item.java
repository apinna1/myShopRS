/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alessio
 */
@Entity
@Table(name = "items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
    , @NamedQuery(name = "Item.findByIditems", query = "SELECT i FROM Item i WHERE i.iditems = :iditems")
    , @NamedQuery(name = "Item.findByNome", query = "SELECT i FROM Item i WHERE i.nome = :nome")
    , @NamedQuery(name = "Item.findByPrezzo", query = "SELECT i FROM Item i WHERE i.prezzo = :prezzo")
    , @NamedQuery(name = "Item.findByMarket", query = "SELECT i FROM Item i WHERE i.market = :market")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iditems")
    private Integer iditems;
    @Column(name = "nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prezzo")
    private Double prezzo;
    @Column(name = "market")
    private String market;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<Carrello> carrelloCollection;

    public Item() {
    }

    public Item(Integer iditems) {
        this.iditems = iditems;
    }

    public Integer getIditems() {
        return iditems;
    }

    public void setIditems(Integer iditems) {
        this.iditems = iditems;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    @XmlTransient
    public Collection<Carrello> getCarrelloCollection() {
        return carrelloCollection;
    }

    public void setCarrelloCollection(Collection<Carrello> carrelloCollection) {
        this.carrelloCollection = carrelloCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditems != null ? iditems.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.iditems == null && other.iditems != null) || (this.iditems != null && !this.iditems.equals(other.iditems))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Item[ iditems=" + iditems + " ]";
    }
    
}
