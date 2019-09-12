package cn.pipilu.tensquare.controller;
import cn.pipilu.plus.common.request.Request;
import cn.pipilu.plus.common.response.Response;
import cn.pipilu.plus.common.util.ResponseUtil;
import cn.pipilu.plus.log.aop.ControllerRespTimeAnno;
import cn.pipilu.tensquare.request.AddLabelReq;
import cn.pipilu.tensquare.response.QueryLabelResp;
import cn.pipilu.tensquare.response.QueryLableListResp;
import cn.pipilu.tensquare.service.LabelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tensquare-base/label")
public class LabelController {
    @Autowired
    private LabelService labelService;


    @RequestMapping(value = "/{pageNo}/{pageSize}",method = RequestMethod.GET)
    @ControllerRespTimeAnno
    public Response<QueryLableListResp> findAll(@PathVariable("pageNo")int pageNo, @PathVariable("pageSize")int pageSize){
        Response<QueryLableListResp> response = new Response<>();
        try {
            response.setRespData(labelService.findAll(pageNo, pageSize));
            ResponseUtil.setRespParam(response);
        }catch (Exception e){
            ResponseUtil.setRespParam(response,e);
        }
        return response;
    }
    @ControllerRespTimeAnno
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Response<QueryLabelResp> findById(@PathVariable String id){
        Response<QueryLabelResp> response = new Response<>();
        try {
            response.setRespData(labelService.findById(id));
            ResponseUtil.setRespParam(response);
        }catch (Exception e){
            ResponseUtil.setRespParam(response,e);
        }
        return response;
    }
    @RequestMapping(method = RequestMethod.POST)
    @ControllerRespTimeAnno
    public Response<Void> add(@RequestBody Request<AddLabelReq> reqData){
        Response<Void> response = new Response<>();
        try {
            labelService.add(reqData.getReqData());
            ResponseUtil.setRespParam(response);
        }catch (Exception e){
            ResponseUtil.setRespParam(response,e);
        }
        return response;
    }
}
