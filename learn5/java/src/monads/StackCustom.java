package ru.geekbrains.monads;


public class StackCustom<T> {
    private final T value;

    private StackCustom(T value) {
        this.value = value;
    }

    public static <T> StackCustom<T> create(T value) {
        return new StackCustom<>(value);
    }

    public T get() {
        return create(value).value;
    }
}
