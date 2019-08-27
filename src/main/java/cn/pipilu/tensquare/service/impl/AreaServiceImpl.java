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
    public List<AreaEntity> queryAll() {
        return areaMapper.selectAll();
    }

    @Override
    public List<AreaEntity> queryAreaByTerritoryCode(String code) {
        return areaMapper.queryAreaByTerritory(code);
    }
}
