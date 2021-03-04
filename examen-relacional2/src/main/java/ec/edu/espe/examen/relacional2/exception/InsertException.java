
package ec.edu.espe.examen.relacional2.exception;

/**
 *
 * @author cofre
 */
public class InsertException extends Exception {
    private final String tableName;

    public InsertException(String tableName, String message) {
        super(message);
        this.tableName = tableName;
    }

    public InsertException(String tableName, String message, Throwable cause) {
        super(message, cause);
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }
}

