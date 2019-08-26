package cn.pipilu.tensquare.service;


import cn.pipilu.tensquare.po.LabelEntity;
import cn.pipilu.tensquare.request.AddLabelReq;
import cn.pipilu.tensquare.response.QueryLabelReq;

import java.util.List;

/**
 * @author lzt
 * @version $Id: <LabelService>, v <1.0.0> 17:43 2019/8/23 lzt Exp $
 * @description
 */
public interface LabelService {
    List<QueryLabelReq> findAll();

    void add(AddLabelReq reqData);

    QueryLabelReq findById(String id);
}
