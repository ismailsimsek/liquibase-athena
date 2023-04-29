package liquibase.ext.athena.datatype.core;

import liquibase.change.core.LoadDataChange;
import liquibase.database.Database;
import liquibase.datatype.DataTypeInfo;
import liquibase.datatype.DatabaseDataType;
import liquibase.datatype.LiquibaseDataType;
import liquibase.ext.athena.database.AthenaDatabase;

import static liquibase.ext.athena.database.AthenaDatabase.ATHENA_PRIORITY_DATABASE;


@DataTypeInfo(
        name = "string",
        minParameters = 0,
        maxParameters = 0,
        priority = ATHENA_PRIORITY_DATABASE
)
public class StringDataTypeAthena extends LiquibaseDataType {
    public StringDataTypeAthena() {
    }

    public boolean supports(Database database) {
        return database instanceof AthenaDatabase;
    }

    public DatabaseDataType toDatabaseDataType(Database database) {
        if (database instanceof AthenaDatabase) {

            DatabaseDataType type = new DatabaseDataType("STRING", this.getParameters());
            if (this.getParameters().length == 0) {
                type.setType("STRING");
            } else {
                String firstParameter = String.valueOf(this.getParameters()[0]);
                int stringSize = Integer.parseInt(firstParameter);
                if (stringSize == 65535) {
                    type.setType("STRING");
                }
            }
            return type;
        } else {
            return super.toDatabaseDataType(database);
        }

    }

    public LoadDataChange.LOAD_DATA_TYPE getLoadTypeName() {
        return LoadDataChange.LOAD_DATA_TYPE.STRING;
    }
}
