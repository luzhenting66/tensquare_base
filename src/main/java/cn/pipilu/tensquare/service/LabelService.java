package cn.pipilu.tensquare.service;

import cn.pipilu.tensquare.request.AddLabelReq;
import cn.pipilu.tensquare.response.QueryLabelResp;
import cn.pipilu.tensquare.response.QueryLableListResp;

/**
 * @author lzt
 * @version $Id: <LabelService>, v <1.0.0> 17:43 2019/8/23 lzt Exp $
 * @description
 */
public interface LabelService {
    QueryLableListResp findAll(int pageNo, int pageSize);

    void add(AddLabelReq reqData);

    QueryLabelResp findById(String id);
}
