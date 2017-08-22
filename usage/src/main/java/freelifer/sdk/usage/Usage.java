package freelifer.sdk.usage;

import java.util.ArrayList;
import java.util.List;

import freelifer.sdk.usage.internal.Print;
import freelifer.sdk.usage.internal.UsageException;

import static freelifer.sdk.usage.internal.Print.println;
import static freelifer.sdk.usage.internal.Print.printlnBySpace;

public final class Usage {
    private final String commandName;
    private final String summary;
    private final List<Command> commands;

    private Usage(Builder builder) {
        this.commandName = builder.commandName;
        this.summary = builder.summary;
        this.commands = builder.commands;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void run(String[] args) {
        if (args.length < 1) {
            usage();
            return;
        }

        String commandName = args[0];
        if ("help".equals(commandName)) {
            // help...
            usage();
            return;
        }

        Command cmd = findCommandByName(commandName, commands);
        if (cmd == null) {
            usage();
            return;
        }

        // TODO: Run Command Action...
        if (cmd.getAction() == null) {
            throw new UsageException("this command %s's action is null, please setAction(Action)", commandName);
        }
        String[] dst = copyOf(args, 1);
        if (!cmd.getAction().run(dst)) {
            usage();
            return;
        }
    }

    private String[] copyOf(String[] src, int offset) {
        if (src == null || src.length <= offset) {
            return new String[0];
        }
        String[] dst = new String[src.length - offset];
        System.arraycopy(src, offset, dst, 0, src.length - offset);
        return dst;
    }

    private void usage() {
        println(summary);

        println("");
        println("Usage:");
        printlnBySpace("%s command [arguments]", commandName);
        println("");

        // commands args
        println("The commands are:");
        println("");
        if (commands != null) {
            for (Command cmd : commands) {
                printlnBySpace("%s compile packages and dependencies", Print.padWhitespaceRight(cmd.getCommandName(), 10));
            }
        }
        println("");

        // end
        println("Use \"%s help [command]\" for more information about a command.", commandName);
    }

    private Command findCommandByName(String commandName, List<Command> list) {
        if (list == null) {
            return null;
        }
        for (Command cmd : list) {
            if (commandName.equals(cmd.getCommandName())) {
                return cmd;
            }
        }
        return null;
    }

    public static class Builder {
        private String commandName;
        private String summary;
        private List<Command> commands;

        private Builder() {
        }


        public Builder setCommandName(String commandName) {
            this.commandName = commandName;
            return this;
        }

        public Builder setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder addCommand(Command command) {
            if (commands == null) {
                commands = new ArrayList<>();
            }
            commands.add(command);
            return this;
        }

        public Usage build() {
            return new Usage(this);
        }
    }
}
