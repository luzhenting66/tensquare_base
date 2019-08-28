package cn.pipilu.tensquare.controller;

import cn.pipilu.plus.log.aop.ControllerRespTimeAnno;
import cn.pipilu.tensquare.po.AreaEntity;
import cn.pipilu.tensquare.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tensquare-base/area")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @RequestMapping(method = RequestMethod.GET)
    @ControllerRespTimeAnno
    public List<AreaEntity> queryAll(){
        return areaService.queryAll("257288911153274880");
    }

}
