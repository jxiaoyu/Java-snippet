package me.rivermind;

import com.cainiao.sdp.abtest.TestGroupUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author river
 * @date 2018/8/11
 */
public class SimpleClass {

    private static final Set<Long> buyerIds = Sets.newHashSet(
        3993504029L,
        3993504014L,
        3964414088L,
        3964354051L,
        3964414038L,
        3964414030L,
        3964394049L,
        3964354034L,
        3964354015L,
        3964354005L,
        3964394011L,
        3964334097L,
        3964334086L,
        3964274082L,
        3964364055L,
        3964364038L,
        3964304043L,
        3964314047L,
        3964264041L,
        3964144035L
    );

    public static void main(String[] args) {
        Map<String, String> map = Maps.newHashMap();
        map.put("test", null);
        map.forEach((k, v) -> {
            map.put(k, "river");
        });
        System.out.println(map);
    }
}
