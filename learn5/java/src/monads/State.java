package monads;

import java.util.function.Function;

public class State<A> {
    private final A value;

    private State (A value) {
        this.value = value;
    }

    public static <T> State<T> apply (T value) {
        return new State<>(value);
    }

    public <B> State<B> map (Function <A, B> f) {
        return State.apply(f.apply(value));
    }

    @Override
    public String toString() {
        return value.toString(); 
    }
}
