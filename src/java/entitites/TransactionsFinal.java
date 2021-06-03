/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitites;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author caiomartins
 */
@Entity
@Table(name = "transactions_final")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionsFinal.findAll", query = "SELECT t FROM TransactionsFinal t"),
    @NamedQuery(name = "TransactionsFinal.findById", query = "SELECT t FROM TransactionsFinal t WHERE t.id = :id"),
    @NamedQuery(name = "TransactionsFinal.findByProductId", query = "SELECT t FROM TransactionsFinal t WHERE t.productId = :productId"),
    @NamedQuery(name = "TransactionsFinal.findByProductType", query = "SELECT t FROM TransactionsFinal t WHERE t.productType = :productType"),
    @NamedQuery(name = "TransactionsFinal.findByCost", query = "SELECT t FROM TransactionsFinal t WHERE t.cost = :cost"),
    @NamedQuery(name = "TransactionsFinal.findByBoughtAt", query = "SELECT t FROM TransactionsFinal t WHERE t.boughtAt = :boughtAt"),
    @NamedQuery(name = "TransactionsFinal.findByBuyerId", query = "SELECT t FROM TransactionsFinal t WHERE t.buyerId = :buyerId")})
public class TransactionsFinal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "product_type")
    private String productType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private BigInteger cost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bought_at")
    @Temporal(TemporalType.DATE)
    private Date boughtAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "buyer_id")
    private int buyerId;

    public TransactionsFinal() {
    }

    public TransactionsFinal(Integer id) {
        this.id = id;
    }

    public TransactionsFinal(Integer id, int productId, String productType, BigInteger cost, Date boughtAt, int buyerId) {
        this.id = id;
        this.productId = productId;
        this.productType = productType;
        this.cost = cost;
        this.boughtAt = boughtAt;
        this.buyerId = buyerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigInteger getCost() {
        return cost;
    }

    public void setCost(BigInteger cost) {
        this.cost = cost;
    }

    public Date getBoughtAt() {
        return boughtAt;
    }

    public void setBoughtAt(Date boughtAt) {
        this.boughtAt = boughtAt;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionsFinal)) {
            return false;
        }
        TransactionsFinal other = (TransactionsFinal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitites.TransactionsFinal[ id=" + id + " ]";
    }
    
}
