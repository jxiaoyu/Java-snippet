package com.alibaba.division;

import com.taobao.biz.common.division.ChinaDivisionManager;
import com.taobao.biz.common.division.DivisionVO;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author river
 * @date 2018/7/16
 */
public class DivisionManager {

    @Resource
    private ChinaDivisionManager chinaDivisionManager;

    public List<DivisionVO> getDivisionsByNameChain(String[] names) {
        return chinaDivisionManager.getDivisionByInfoNameChain(names);
    }

}
