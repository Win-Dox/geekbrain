package monads;

public interface Effect<T> {
    public T run();
}
