package midnightrocket.java.singlethread;

import midnightrocket.java.interfaces.LongGenerator;
import midnightrocket.java.exceptions.NotEvenNumberException;

public class PrimeGenerator implements LongGenerator {
    private long position;
    private int step;

    public PrimeGenerator(long start, int step) {
        this.setStart(start);
        this.setStep(step);
    }

    public PrimeGenerator(long start) {
        this(start, 2);
    }

    public PrimeGenerator() {
        this(2);
    }


    private void setStart(long start) {
        if (start <= 2) {
            this.position = 2;
        } else if (start % 2 == 0) {
            // Make start position an uneven number, if start is an even number
            this.position = start - 1;
        } else {
            this.position = start;
        }
    }
    private void setStep(int step) {
        if (step % 2 == 1) {
            throw new NotEvenNumberException("'step' parameter must be an even number!");
        } else if (step < 2) {
            throw new IllegalArgumentException("'step' parameter must be 2 or greater");
        }
        this.step = step;
    }

    @Override
    public Long next() {
        if (this.position <= 2) {
            this.position = 1 + this.step;
            return 2L;
        }
        do {
            this.advancePosition();
        } while (!Prime.isPrime(this.position));
        return this.position;
    }

    @Override
    public boolean isDone() {
        return false; // We are never going to run out of prime numbers
    }

    protected void advancePosition() {
        this.position += this.step;
    }
}