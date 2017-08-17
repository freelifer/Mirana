package freelifer.sdk.usage;

public final class Usage {
    private final String summary;

    private Usage(Builder builder) {
        this.summary = builder.summary;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static class Builder {

        private String summary;

        private Builder() {
        }

        public Usage build() {
            return new Usage(this);
        }
    }
}
