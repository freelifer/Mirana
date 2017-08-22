package freelifer.sdk.usage;

/**
 * @author kzhu on 2017/8/17.
 * @deprecated
 */
class MainTest {
    public static void main(String[] args) {
        System.err.println("args len " + args.length);

        Usage.newBuilder()
                .setCommandName("go")
                .setSummary("Go is a tool for managing Go source code.")
//                .addCommand(Command.newBuilder().setCommandName("build").setSummary("compile packages and dependencies").setAction(new BuildAction()).build())
//                .addCommand(Command.newBuilder().setCommandName("build11111").setSummary("compile packages and dependencies").setAction(new BuildAction()).build())
                .build()
                .run(args);
    }
}
