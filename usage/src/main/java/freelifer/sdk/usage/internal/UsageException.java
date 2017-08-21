package freelifer.sdk.usage.internal;

/**
 * @author kzhu on 2017/8/22.
 */
public class UsageException extends RuntimeException {

    public UsageException(String msg, Object... args) {
        super(String.format(msg, args));
    }
}
