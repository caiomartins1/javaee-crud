package entitites;

import entitites.Products;
import entitites.Users;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-03T23:33:48")
@StaticMetamodel(Transactions.class)
public class Transactions_ { 

    public static volatile SingularAttribute<Transactions, BigInteger> cost;
    public static volatile SingularAttribute<Transactions, Products> productId;
    public static volatile SingularAttribute<Transactions, Date> purchasedAt;
    public static volatile SingularAttribute<Transactions, Integer> id;
    public static volatile SingularAttribute<Transactions, Users> userId;

}