package midnightrocket.java.interfaces;

import java.util.function.LongSupplier;

public interface LongGenerator extends Generator<Long>, LongSupplier {
    @Override
    public default long getAsLong() {
        return this.next();
    }
}