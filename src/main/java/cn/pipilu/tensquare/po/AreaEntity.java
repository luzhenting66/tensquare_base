package cn.pipilu.tensquare.po;

import cn.pipilu.plus.common.base.entity.BusinessEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tb_area")
public class AreaEntity extends BusinessEntity {

    private static final long serialVersionUID = -2014696631516214543L;
//    @Column(name = "area_code")
    private String areaCode;
//    @Column(name = "area_name")
    private String areaName;
//    @Column(name = "parent_area")
    private String parentArea;
//    @Column(name = "territory_code")
    private String territoryCode;
//    @Column(name = "area_type")
    private String areaType;
//    @Column(name = "conn_entity")
    private String connEntity;
//    @Column(name = "standard_addr_code")
    private String standardAddrCode;
//    @Column(name = "detail_add")
    private String detailAdd;
//    @Column(name = "dead_sts")
    private String deadSts;

    private String status;
    private String remark;
}
