package dev.ai4j.openai4j.chat;

import java.util.Objects;

import static dev.ai4j.openai4j.chat.ToolType.FUNCTION;

public class Tool {

    private final ToolType type = FUNCTION;
    private final Function function;

    public Tool(Function function) {
        this.function = function;
    }

    public ToolType type() {
        return this.type;
    }

    public Function function() {
        return this.function;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof Tool
                && equalTo((Tool) another);
    }

    private boolean equalTo(Tool another) {
        return Objects.equals(type, another.type)
                && Objects.equals(function, another.function);
    }

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + Objects.hashCode(type);
        h += (h << 5) + Objects.hashCode(function);
        return h;
    }

    @Override
    public String toString() {
        return "Tool{"
                + "type=" + type
                + ", function=" + function
                + "}";
    }

    public static Tool from(Function function) {
        return new Tool(function);
    }
}
