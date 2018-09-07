package me.rivermind.cl.load;

import me.rivermind.cl.load.leak.ILeak;

/**
 * @author river
 * @date 2017/8/11
 */
public interface IExample {

    String message();

    int plusPlus();

    int counter();

    ILeak leak();

    IExample copy(IExample example);

}