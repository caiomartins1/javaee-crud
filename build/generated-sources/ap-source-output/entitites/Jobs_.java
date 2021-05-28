package entitites;

import entitites.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T00:06:50")
@StaticMetamodel(Jobs.class)
public class Jobs_ { 

    public static volatile SingularAttribute<Jobs, String> id;
    public static volatile CollectionAttribute<Jobs, Users> usersCollection;
    public static volatile SingularAttribute<Jobs, String> jobname;

}