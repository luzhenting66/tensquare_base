package cn.pipilu.tensquare.po;

import cn.pipilu.plus.common.base.entity.BusinessEntity;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "tb_area")
public class AreaEntity extends BusinessEntity {

    private static final long serialVersionUID = -2014696631516214543L;
    private String areaCode;
    private String areaName;
    private String parentArea;
    private String territoryCode;
    private String areaType;
    private String connEntity;
    private String standardAddrCode;
    private String detailAdd;
    private String deadSts;
    private String status;
    private String remark;
    List<AreaEntity> nodes;
}
