package me.rivermind.lang;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author river
 * @date 2018/9/12
 */
public class PatternTest {

    private static final String TIME_RANGE_PATTERN = "\\d{2}:\\d{2}-\\d{2}:\\d{2}";

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("09:00-24:00",
            "12:00-222:00");
        for (String s : list) {
            if (s.matches(TIME_RANGE_PATTERN)) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
    }
}
