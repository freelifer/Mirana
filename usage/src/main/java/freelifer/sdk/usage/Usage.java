package freelifer.sdk.usage;

import java.util.ArrayList;
import java.util.List;

public final class Usage {
    private final String summary;
    private final List<Command> commands;

    private Usage(Builder builder) {
        this.summary = builder.summary;
        this.commands = builder.commands;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void exec(String[] args) {
        if (args.length < 1) {
            usage();
            return;
        }

    }

    private void usage() {

    }

    public static class Builder {
        private String summary;
        private List<Command> commands;

        private Builder() {
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
