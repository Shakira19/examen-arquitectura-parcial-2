
package ec.edu.espe.examen.relacional.exception;

/**
 *
 * @author cofre
 */
public class UpdateException extends Exception{
    private final String collectionName;

    public UpdateException(String collectionName, String message) {
        super(message);
        this.collectionName = collectionName;
    }

    public UpdateException(String collectionName, String message, Throwable cause) {
        super(message, cause);
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return collectionName;
    }
}
