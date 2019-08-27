package cn.pipilu.tensquare.service;

import cn.pipilu.tensquare.po.AreaEntity;

import java.util.List;

public interface AreaService {

    List<AreaEntity> queryAll();
    List<AreaEntity> queryAreaByTerritoryCode(String code);
}
