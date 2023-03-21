package midnightrocket.java.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public interface Generator<T> extends Supplier<T> {
    public static <E> E[] fillArray(Generator<? extends E> generator, E[] arr) {
        for (int i = 0; i < arr.length && !generator.isDone(); i++) {
            arr[i] = generator.next();
        }
        return arr;
    }

    T next();

    boolean isDone();



    @Override
    default T get() {
        return this.next();
    }
}