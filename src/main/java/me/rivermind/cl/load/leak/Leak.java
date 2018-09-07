package me.rivermind.cl.load.leak;

/**
 * @author river
 * @date 2017/8/11
 */
public class Leak implements ILeak {
    private ILeak leak;

    public Leak(ILeak leak) {
        this.leak = leak;
    }
}