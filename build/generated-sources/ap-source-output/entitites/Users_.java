package entitites;

import entitites.Jobs;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T00:06:50")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> id;
    public static volatile SingularAttribute<Users, Jobs> job;
    public static volatile SingularAttribute<Users, String> username;

}