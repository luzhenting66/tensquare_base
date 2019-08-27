package cn.pipilu.tensquare.service.impl;

import cn.pipilu.plus.common.util.IdUtils;
import cn.pipilu.plus.common.util.ValidateUtil;
import cn.pipilu.tensquare.constant.LabelRecommendE;
import cn.pipilu.tensquare.constant.LabelStateE;
import cn.pipilu.tensquare.mapper.LabelMapper;
import cn.pipilu.tensquare.po.LabelEntity;
import cn.pipilu.tensquare.request.AddLabelReq;
import cn.pipilu.tensquare.response.QueryLabelResp;
import cn.pipilu.tensquare.response.QueryLableListResp;
import cn.pipilu.tensquare.service.LabelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Objects;
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
    private LabelMapper  labelMapper;
    @Autowired
    private ValidateUtil validateUtil;
    @Autowired
    private IdUtils      idUtils;

    @Override
    public QueryLableListResp findAll(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<LabelEntity> pageInfo = new PageInfo<>(labelMapper.selectAll());
        QueryLableListResp result = new QueryLableListResp();
        result.setTotal(pageInfo.getTotal());
        result.setPageSize(pageInfo.getPageSize());
        result.setSize(pageInfo.getSize());
        result.setPageNo(pageInfo.getPageNum());
        result.setData(pageInfo.getList().stream().map(label -> changeData(label)).collect(Collectors.toList()));
        return result;
    }

    private QueryLabelResp changeData(LabelEntity label) {
        if (Objects.isNull(label)) {
            return null;
        }
        return new QueryLabelResp() {
            {
                setId(label.getId());
                setCount(label.getCount());
                setStateName(LabelStateE.getLabel(label.getState()));
                setRecommendName(LabelRecommendE.getLabel(label.getRecommend()));
                setFans(label.getFans());
                setLabel(label.getLabel());
            }
        };
    }

    @Override
    public void add(AddLabelReq reqData) {
        validateUtil.validObject(reqData);
        LabelEntity label = new LabelEntity() {
            {
                setLabel(reqData.getLabel());
                setId(idUtils.getIdStr());
                setCount(0);
                setFans(0);
                setRecommend("0");
                setState("0");
            }
        };
        labelMapper.insert(label);
    }

    @Override
    public QueryLabelResp findById(String id) {
        LabelEntity labelEntity = new LabelEntity();
        labelEntity.setId(id);
        return changeData(labelMapper.selectOne(labelEntity));
    }
}
