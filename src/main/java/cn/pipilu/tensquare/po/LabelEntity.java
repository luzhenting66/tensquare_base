package cn.pipilu.tensquare.po;

import javax.persistence.Table;

import cn.pipilu.plus.common.base.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Table(name = "tb_label")
public class LabelEntity extends BaseEntity {
    private static final long serialVersionUID = 8632399699790097087L;
    private String            label;
    private String            state;                                  // '0'-无效、'1'-有效
    private int               count;                                  // 使用量
    private int               fans;                                   // 关注度
    private String            recommend;                              // '0'-不推荐、'1'-推荐
}
