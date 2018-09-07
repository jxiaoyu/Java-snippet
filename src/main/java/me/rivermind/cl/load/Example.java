package me.rivermind.cl.load;

import me.rivermind.cl.load.leak.ILeak;
import me.rivermind.cl.load.leak.Leak;

/**
 * @author rive
 * @date 2017/8/11
 */
public class Example implements IExample {
    private int counter;

    private ILeak leak;

    private static final long[] cache = new long[30000000];

    @Override
    public ILeak leak() {
        return new Leak(leak);
    }

    @Override
    public String message() {
        return "Version 1";
    }

    @Override
    public int plusPlus() {
        return counter++;
    }

    @Override
    public int counter() {
        return counter;
    }

    @Override
    public IExample copy(IExample example) {
        if (example != null) {
            counter = example.counter();
            leak = example.leak();
        }
        return this;
    }
}