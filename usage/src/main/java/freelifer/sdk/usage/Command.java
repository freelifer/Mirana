package freelifer.sdk.usage;

/**
 * @author kzhu on 2017/8/17.
 */
public class Command {
    private final String commandName;
    private final String summary;
    private final Action action;

    private Command(Builder builder) {
        this.commandName = builder.commandName;
        this.summary = builder.summary;
        this.action = builder.action;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public String getCommandName() {
        return commandName;
    }

    public String getSummary() {
        return summary;
    }

    public Action getAction() {
        return action;
    }

    public static class Builder {
        private String commandName;
        private String summary;
        private Action action;

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

        public Builder setAction(Action action) {
            this.action = action;
            return this;
        }

        public Command build() {
            return new Command(this);
        }
    }

}
