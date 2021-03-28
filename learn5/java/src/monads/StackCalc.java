package monads;

import java.util.function.Function;

public class StackCalc<A, B> {
    private final A stack;
    private final B str;

    private StackCalc (A stack, B str) {
        this.stack = stack;
        this.str = str;
    }

    public static <A, B> StackCalc<A, B> apply (A value, B str) {
        return new StackCalc<>(value, str);
    }

    public A get_1() {
        return stack;
    }

    public B get_2 () {
        return str;
    }

    public StackCalc<A, B> modify (Function<A, A> f) {
        return new StackCalc<>(f.apply(stack), str);
    }


//    public <B> StackCalc<B> flatMap (Function <A, StackCalc<B>> f) {
//        return StackCalc.apply(f.apply(stack));
//    }
}
