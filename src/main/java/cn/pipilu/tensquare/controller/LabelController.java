package cn.pipilu.tensquare.controller;
import cn.pipilu.plus.common.request.Request;
import cn.pipilu.plus.common.response.Response;
import cn.pipilu.plus.common.util.ResponseUtil;
import cn.pipilu.plus.log.aop.ControllerRespTimeAnno;
import cn.pipilu.tensquare.po.LabelEntity;
import cn.pipilu.tensquare.request.AddLabelReq;
import cn.pipilu.tensquare.response.QueryLabelReq;
import cn.pipilu.tensquare.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tensquare-base/label")
public class LabelController {
    @Autowired
    private LabelService labelService;
    @Autowired
    private ResponseUtil responseUtil;

    @RequestMapping(method = RequestMethod.GET)
    @ControllerRespTimeAnno
    public Response<List<QueryLabelReq>> findAll(){
        Response<List<QueryLabelReq>> response = new Response<>();
        try {
            response.setRespData(labelService.findAll());
            responseUtil.setRespParam(response);
        }catch (Exception e){
            responseUtil.setRespParam(response,e);
        }
        return response;
    }
    @ControllerRespTimeAnno
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Response<QueryLabelReq> findById(@PathVariable String id){
        Response<QueryLabelReq> response = new Response<>();
        try {
            response.setRespData(labelService.findById(id));
            responseUtil.setRespParam(response);
        }catch (Exception e){
            responseUtil.setRespParam(response,e);
        }
        return response;
    }
    @RequestMapping(method = RequestMethod.POST)
    @ControllerRespTimeAnno
    public Response<Void> add(@RequestBody Request<AddLabelReq> reqData){
        Response<Void> response = new Response<>();
        try {
            labelService.add(reqData.getReqData());
            responseUtil.setRespParam(response);
        }catch (Exception e){
            responseUtil.setRespParam(response,e);
        }
        return response;
    }
}
