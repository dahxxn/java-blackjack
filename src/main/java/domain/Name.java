package domain;

public class Name {
    private final String name;

    private Name(String name) {
        validate(name);
        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    private void validate(String name) {
        validateNotNull(name);
        validateNotEmpty(name);
        validateNameLength(name);
    }

    private void validateNotNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name은 null이 올 수 없습니다");
        }
    }

    private void validateNotEmpty(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("name에 공백이 올 수 없습니다");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 10) {
            throw new IllegalArgumentException("name 길이는 1이상 10이하여아 합니다");
        }
    }

    public String name() {
        return name;
    }
}
