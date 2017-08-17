package freelifer.sdk.usage;

/**
 * @author kzhu on 2017/8/17.
 */
public class Command {
    private String command;
    private String state;
    private Object action;

    private Command() {
    }

    public static Command create() {
        return new Command();
    }
}
