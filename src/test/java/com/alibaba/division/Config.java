package com.alibaba.division;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author river
 * @date 2018/7/17
 */
@Getter
@Setter
public class Config {

    private Map<Long, Set<Long>> lineMap;

    private Set<Long> itemSet;

    public static void main(String[] args) {
        LocalDateTime.now().plusMinutes(1440);
    }

    private static int test(int a) {
        return 1 / a;
    }
}
