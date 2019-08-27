package cn.pipilu.tensquare.mapper;

import cn.pipilu.plus.common.base.mapper.BaseMapper;
import cn.pipilu.tensquare.po.AreaEntity;

import java.util.List;

public interface AreaMapper extends BaseMapper<AreaEntity> {
    List<AreaEntity> queryAreaByTerritoryCode(String code);
    List<AreaEntity> queryAreaByTerritory(String code);
}
