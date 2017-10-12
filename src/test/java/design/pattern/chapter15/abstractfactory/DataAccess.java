package design.pattern.chapter15.abstractfactory;

/**
 * Created by h on 2017/10/13.
 */
public class DataAccess {
    private static String db = "SqlServer";
//    private static String db = "Access";
    public static IUser createUser() {
        IUser user = null;
        switch (db) {
            case "SqlServer":
                user = new SqlServerUser();
                break;
            case "Access":
                user = new AccessUser();
                break;
        }
        return user;
    }
}
