package liquibase.ext.athena.database;

import com.simba.athena.athena.Athena;
import liquibase.database.AbstractJdbcDatabase;
import liquibase.database.DatabaseConnection;
import liquibase.exception.DatabaseException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AthenaDatabase extends AbstractJdbcDatabase {

    public static final String PRODUCT_NAME = Athena.SUBPROTOCAL_NAME; // awsathena
    public static final int ATHENA_PRIORITY_DATABASE = 510;
    
    public AthenaDatabase() {
        this.setCurrentDateTimeFunction("CURRENT_DATETIME()");
        super.unmodifiableDataTypes.addAll(Arrays.asList(
                "integer",
                "bool",
                "boolean",
                "int4",
                "int8",
                "float4",
                "float8",
                "numeric",
                "bigserial",
                "serial",
                "bytea",
                "timestamptz"));
        this.unquotedObjectsAreUppercased = false;
        this.addReservedWords(getDefaultReservedWords());
    }

    @Override
    public String getShortName() {
        return "athena";
    }

    @Override
    protected String getDefaultDatabaseProductName() {
        return PRODUCT_NAME;
    }

    @Override
    public Integer getDefaultPort() {
        return 443;
    }

    @Override
    public int getPriority() {
        return ATHENA_PRIORITY_DATABASE;
    }

    @Override
    public String getCurrentDateTimeFunction() {
        return "CURRENT_DATETIME()";
    }

    @Override
    public String getDatabaseProductVersion() {
        // @TODO fix 
        return "Driver.getDatabaseProductVersion()";
    }

    @Override
    public int getDatabaseMajorVersion() {

        // @TODO fix 
        return 3 ; // GEt and Return Athena Engine version
    }

    @Override
    public int getDatabaseMinorVersion() {

        // @TODO fix    // Athnea Engine version;
        return 0;
    }

    @Override
    public boolean supportsInitiallyDeferrableColumns() {
        return false;
    }

    @Override
    public boolean supportsDropTableCascadeConstraints() {
        return false;
    }

    @Override
    public boolean supportsTablespaces() {
        return false;
    }

    @Override
    public boolean isCorrectDatabaseImplementation(DatabaseConnection conn) throws DatabaseException {
        return PRODUCT_NAME.trim().equalsIgnoreCase(conn.getDatabaseProductName().trim());
    }

    @Override
    public String getDefaultDriver(String url) {
        if (url.startsWith("jdbc:awsathena")) {
            return "com.simba.athena.jdbc.Driver";
        }

        return null;
    }

    @Override
    public boolean supportsSequences() {
        return false;
    }

    @Override
    public boolean supportsRestrictForeignKeys() {
        return false;
    }

    @Override
    public boolean supportsPrimaryKeyNames() {
        return false;
    }

    @Override
    public boolean supportsNotNullConstraintNames() {
        return false;
    }

    @Override
    protected String getConnectionSchemaName() {
        // @TODO FIX 
        return" getDefaultDataset()";
    }
    
    @Override
    public void setAutoCommit(final boolean b) throws DatabaseException {
        return;
    }

    @Override
    public boolean supportsDDLInTransaction() {
        return false;
    }

    private Set<String> getDefaultReservedWords() {

        Set<String> reservedWords = new HashSet<>();
        reservedWords.add("ALL");
        reservedWords.add("AND");
        reservedWords.add("ANY");
        reservedWords.add("ARRAY");
        reservedWords.add("AS");
        reservedWords.add("ASC");
        reservedWords.add("ASSERT_ROWS_MODIFIED");
        reservedWords.add("AT");
        reservedWords.add("BETWEEN");
        reservedWords.add("BY");
        reservedWords.add("CASE");
        reservedWords.add("CAST");
        reservedWords.add("COLLATE");
        reservedWords.add("CONTAINS");
        reservedWords.add("CREATE");
        reservedWords.add("CROSS");
        reservedWords.add("CUBE");
        reservedWords.add("CURRENT");
        reservedWords.add("DEFAULT");
        reservedWords.add("DEFINE");
        reservedWords.add("DESC");
        reservedWords.add("DISTINCT");
        reservedWords.add("ELSE");
        reservedWords.add("END");
        reservedWords.add("ENUM");
        reservedWords.add("ESCAPE");
        reservedWords.add("EXCEPT");
        reservedWords.add("EXCLUDE");
        reservedWords.add("EXISTS");
        reservedWords.add("EXTRACT");
        reservedWords.add("FALSE");
        reservedWords.add("FETCH");
        reservedWords.add("FOLLOWING");
        reservedWords.add("FOR");
        reservedWords.add("FROM");
        reservedWords.add("FULL");
        reservedWords.add("GROUP");
        reservedWords.add("GROUPING");
        reservedWords.add("GROUPS");
        reservedWords.add("HASH");
        reservedWords.add("HAVING");
        reservedWords.add("IF");
        reservedWords.add("IGNORE");
        reservedWords.add("IN");
        reservedWords.add("INNER");
        reservedWords.add("INTERSECT");
        reservedWords.add("INTERVAL");
        reservedWords.add("INTO");
        reservedWords.add("IS");
        reservedWords.add("JOIN");
        reservedWords.add("LATERAL");
        reservedWords.add("LEFT");
        reservedWords.add("LIKE");
        reservedWords.add("LIMIT");
        reservedWords.add("LOOKUP");
        reservedWords.add("MERGE");
        reservedWords.add("NATURAL");
        reservedWords.add("NEW");
        reservedWords.add("NO");
        reservedWords.add("NOT");
        reservedWords.add("NULL");
        reservedWords.add("NULLS");
        reservedWords.add("OF");
        reservedWords.add("ON");
        reservedWords.add("OR");
        reservedWords.add("ORDER");
        reservedWords.add("OUTER");
        reservedWords.add("OVER");
        reservedWords.add("PARTITION");
        reservedWords.add("PRECEDING");
        reservedWords.add("PROTO");
        reservedWords.add("RANGE");
        reservedWords.add("RECURSIVE");
        reservedWords.add("RESPECT");
        reservedWords.add("RIGHT");
        reservedWords.add("ROLLUP");
        reservedWords.add("ROWS");
        reservedWords.add("SELECT");
        reservedWords.add("SET");
        reservedWords.add("SOME");
        reservedWords.add("STRUCT");
        reservedWords.add("TABLESAMPLE");
        reservedWords.add("THEN");
        reservedWords.add("TO");
        reservedWords.add("TREAT");
        reservedWords.add("TRUE");
        reservedWords.add("UNBOUNDED");
        reservedWords.add("UNION");
        reservedWords.add("UNNEST");
        reservedWords.add("USING");
        reservedWords.add("WHEN");
        reservedWords.add("WHERE");
        reservedWords.add("WINDOW");
        reservedWords.add("WITH");
        reservedWords.add("WITHIN");

        return reservedWords;
    }


}
