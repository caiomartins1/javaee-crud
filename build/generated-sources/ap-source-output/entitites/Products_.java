package entitites;

import entitites.ProductTypes;
import entitites.Transactions;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T04:20:53")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile CollectionAttribute<Products, Transactions> transactionsCollection;
    public static volatile SingularAttribute<Products, ProductTypes> typeId;
    public static volatile SingularAttribute<Products, Integer> id;

}