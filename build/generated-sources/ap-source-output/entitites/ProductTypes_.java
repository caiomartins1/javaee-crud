package entitites;

import entitites.Products;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-03T01:17:04")
@StaticMetamodel(ProductTypes.class)
public class ProductTypes_ { 

    public static volatile SingularAttribute<ProductTypes, Date> addedAt;
    public static volatile CollectionAttribute<ProductTypes, Products> productsCollection;
    public static volatile SingularAttribute<ProductTypes, BigInteger> price;
    public static volatile SingularAttribute<ProductTypes, String> typeName;
    public static volatile SingularAttribute<ProductTypes, Integer> id;
    public static volatile SingularAttribute<ProductTypes, Integer> stock;
    public static volatile SingularAttribute<ProductTypes, Integer> minStock;

}