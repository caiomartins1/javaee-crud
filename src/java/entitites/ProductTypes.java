/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitites;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author caiomartins
 */
@Entity
@Table(name = "product_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductTypes.findAll", query = "SELECT p FROM ProductTypes p"),
    @NamedQuery(name = "ProductTypes.findById", query = "SELECT p FROM ProductTypes p WHERE p.id = :id"),
    @NamedQuery(name = "ProductTypes.findByTypeName", query = "SELECT p FROM ProductTypes p WHERE p.typeName = :typeName"),
    @NamedQuery(name = "ProductTypes.findByPrice", query = "SELECT p FROM ProductTypes p WHERE p.price = :price"),
    @NamedQuery(name = "ProductTypes.findByStock", query = "SELECT p FROM ProductTypes p WHERE p.stock = :stock"),
    @NamedQuery(name = "ProductTypes.findByMinStock", query = "SELECT p FROM ProductTypes p WHERE p.minStock = :minStock"),
    @NamedQuery(name = "ProductTypes.findByAddedAt", query = "SELECT p FROM ProductTypes p WHERE p.addedAt = :addedAt")})
public class ProductTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "type_name")
    private String typeName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigInteger price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "min_stock")
    private int minStock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "added_at")
    @Temporal(TemporalType.DATE)
    private Date addedAt;
    @OneToMany(mappedBy = "typeId")
    private Collection<Products> productsCollection;

    public ProductTypes() {
    }

    public ProductTypes(Integer id) {
        this.id = id;
    }

    public ProductTypes(Integer id, String typeName, BigInteger price, int stock, int minStock, Date addedAt) {
        this.id = id;
        this.typeName = typeName;
        this.price = price;
        this.stock = stock;
        this.minStock = minStock;
        this.addedAt = addedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }

    @XmlTransient
    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
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
        if (!(object instanceof ProductTypes)) {
            return false;
        }
        ProductTypes other = (ProductTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitites.ProductTypes[ id=" + id + " ]";
    }
    
}
