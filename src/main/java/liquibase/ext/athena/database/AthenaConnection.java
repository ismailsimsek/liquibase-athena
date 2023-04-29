package liquibase.ext.athena.database;

import com.simba.athena.jdbc.jdbc42.S42Connection;
import liquibase.database.jvm.JdbcConnection;

import java.sql.Connection;

/**
 * A Athena specific Delegate that removes the calls to autocommit
 */

public class AthenaConnection extends JdbcConnection {
    private S42Connection con;
    
    public AthenaConnection() {}

    public AthenaConnection(Connection delegate) {
        super(delegate);
        this.con = (S42Connection) delegate;
    }

//    @Override
//    public boolean getAutoCommit() throws DatabaseException {
//        return true;
//    }

//    @Override
//    public void setAutoCommit(boolean autoCommit) throws DatabaseException {
//
//    }
//
//    @Override
//    public String getDatabaseProductVersion() throws DatabaseException {
//        return "1.0";
//    }
//
//    @Override
//    public int getDatabaseMajorVersion() throws DatabaseException {
//        return 1;
//    }
//
//    @Override
//    public int getDatabaseMinorVersion() throws DatabaseException {
//        return 0;
//    }
}
