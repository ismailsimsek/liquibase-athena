package liquibase.ext.athena.sqlgenerator;

import liquibase.database.Database;
import liquibase.ext.athena.database.AthenaDatabase;
import liquibase.sqlgenerator.core.CreateDatabaseChangeLogTableGenerator;
import liquibase.statement.core.CreateDatabaseChangeLogTableStatement;

public class AthenaCreateDatabaseChangeLogTableGenerator extends CreateDatabaseChangeLogTableGenerator {

    @Override
    public boolean supports(CreateDatabaseChangeLogTableStatement statement, Database database) {
        return !(database instanceof AthenaDatabase);
    }

    @Override
    protected String getCharTypeName(Database database) {
        return database instanceof AthenaDatabase ? "string" : "varchar";
    }

}
