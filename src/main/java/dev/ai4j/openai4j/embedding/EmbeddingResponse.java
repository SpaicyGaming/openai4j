package dev.ai4j.openai4j.embedding;

import dev.ai4j.openai4j.shared.Usage;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

public final class EmbeddingResponse {

    private final String model;
    private final List<Embedding> data;
    private final Usage usage;

    private EmbeddingResponse(Builder builder) {
        this.model = builder.model;
        this.data = builder.data;
        this.usage = builder.usage;
    }

    public String model() {
        return model;
    }

    public List<Embedding> data() {
        return data;
    }

    public Usage usage() {
        return usage;
    }

    /**
     * Convenience method to get the embedding from the first data.
     */
    public List<Float> embedding() {
        return data.get(0).embedding();
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof EmbeddingResponse
                && equalTo((EmbeddingResponse) another);
    }

    private boolean equalTo(EmbeddingResponse another) {
        return Objects.equals(model, another.model)
                && Objects.equals(data, another.data)
                && Objects.equals(usage, another.usage);
    }

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + Objects.hashCode(model);
        h += (h << 5) + Objects.hashCode(data);
        h += (h << 5) + Objects.hashCode(usage);
        return h;
    }

    @Override
    public String toString() {
        return "EmbeddingResponse{"
                + "model=" + model
                + ", data=" + data
                + ", usage=" + usage
                + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private String model;
        private List<Embedding> data;
        private Usage usage;

        private Builder() {
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder data(List<Embedding> data) {
            if (data != null) {
                this.data = unmodifiableList(data);
            }
            return this;
        }

        public Builder usage(Usage usage) {
            this.usage = usage;
            return this;
        }

        public EmbeddingResponse build() {
            return new EmbeddingResponse(this);
        }
    }
}
