package monads;

import java.util.function.Consumer;
import java.util.function.Function;

public class IO<A> {

    private final Effect<A> effect;

    private IO(Effect<A> effect) {
        this.effect = effect;
    }

    public static <T> IO<T> apply(Effect<T> state) {
        return new IO<>(state);
    }

    public A run() {
        return effect.run();
    }

    public <B> IO<B> flatMap( Function< A, IO<B>> function) {
        return IO.apply(() -> function.apply(effect.run()).run());
    }

    public <B> IO<B> map(Function<A, B> function) {
        return this.flatMap(result -> IO.apply(() -> function.apply(result)));
    }

    public IO<Void> mapToVoid(Consumer<A> function) {
        return this.flatMap(result -> IO.apply(() -> {
            function.accept(result);
            return null;
        }));
    }
}
