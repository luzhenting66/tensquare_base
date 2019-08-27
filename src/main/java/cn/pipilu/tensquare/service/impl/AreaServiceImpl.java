package cn.pipilu.tensquare.service.impl;

import cn.pipilu.tensquare.mapper.AreaMapper;
import cn.pipilu.tensquare.po.AreaEntity;
import cn.pipilu.tensquare.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
@Autowired
private AreaMapper areaMapper;
    @Override
    public List<AreaEntity> queryAll(String code) {
        List<AreaEntity> list = areaMapper.queryAreaByTerritoryCode("257288911153274880");
        AreaEntity areaEntity = list.get(0);
        String areaName = areaEntity.getAreaName();
        System.err.println(areaName);
        List<AreaEntity> areaEntities = areaMapper.queryAreaByParentCode(areaEntity.getAreaCode());
        return areaEntities;
    }


}
