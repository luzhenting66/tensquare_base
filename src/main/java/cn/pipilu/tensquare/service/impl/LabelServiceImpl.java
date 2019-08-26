package cn.pipilu.tensquare.service.impl;

import cn.pipilu.plus.common.util.IdUtils;
import cn.pipilu.plus.common.util.ValidateUtil;
import cn.pipilu.tensquare.constant.LabelRecommendE;
import cn.pipilu.tensquare.constant.LabelStateE;
import cn.pipilu.tensquare.mapper.LabelMapper;
import cn.pipilu.tensquare.po.LabelEntity;
import cn.pipilu.tensquare.request.AddLabelReq;
import cn.pipilu.tensquare.response.QueryLabelReq;
import cn.pipilu.tensquare.service.LabelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Observable;
import java.util.stream.Collectors;

/**
 * @author lzt
 * @version $Id: <LabelServiceImpl>, v <1.0.0> 17:43 2019/8/23 lzt Exp $
 * @description
 */
@Service
public class LabelServiceImpl implements LabelService {
    private final Logger logger = LoggerFactory.getLogger(LabelServiceImpl.class);
    @Autowired
    private LabelMapper labelMapper;
    @Autowired
    private ValidateUtil validateUtil;
    @Autowired
    private IdUtils idUtils;

    @Override
    public List<QueryLabelReq> findAll() {
        System.err.println("============mysql===========");
        return labelMapper.selectAll().stream().map(label -> changeData(label)).collect(Collectors.toList());
    }

    private QueryLabelReq changeData(LabelEntity label) {
        if (Objects.isNull(label)){
            return null;
        }
        return new QueryLabelReq(){{
            setId(label.getId());
            setCount(label.getCount());
            setStateName(LabelStateE.getLabel(label.getState()));
            setRecommendName(LabelRecommendE.getLabel(label.getRecommend()));
            setFans(label.getFans());
            setLabel(label.getLabel());
        }};
    }

    @Override
    public void add(AddLabelReq reqData) {
        validateUtil.validObject(reqData);
        LabelEntity label = new LabelEntity() {{
            setLabel(reqData.getLabel());
            setId(idUtils.getIdStr());
            setCount(0);
            setFans(0);
            setRecommend("0");
            setState("0");
        }};
        labelMapper.insert(label);
    }

    @Override
    public QueryLabelReq findById(String id) {
        System.err.println("============mysql===========");
        return changeData(labelMapper.selectByPrimaryKey(id));
    }
}
