package liquibase.ext.athena.executor;

import liquibase.database.Database;
import liquibase.exception.DatabaseException;
import liquibase.executor.jvm.JdbcExecutor;
import liquibase.ext.athena.database.AthenaDatabase;
import liquibase.sql.visitor.SqlVisitor;
import liquibase.statement.SqlStatement;

import java.util.List;

import static liquibase.ext.athena.database.AthenaDatabase.ATHENA_PRIORITY_DATABASE;

public class AthenaExecutor extends JdbcExecutor {

    @Override
    public int getPriority() {
        return ATHENA_PRIORITY_DATABASE;
    }

    @Override
    public boolean supports(Database database) {
        return database instanceof AthenaDatabase;
    }

    @Override
    public void execute(SqlStatement sql) throws DatabaseException {
       super.execute(sql);
    }

    @Override
    public void execute(SqlStatement sql, List<SqlVisitor> sqlVisitors) throws DatabaseException {
        super.execute(sql, sqlVisitors);
    }
}
