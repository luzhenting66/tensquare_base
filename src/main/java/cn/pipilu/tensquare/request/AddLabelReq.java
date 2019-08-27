package cn.pipilu.tensquare.request;

import cn.pipilu.plus.common.validate.Validate;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class AddLabelReq implements Serializable {
    private static final long serialVersionUID = -1333507968776366334L;
    @Validate(nullable = false, desc = "标签名称缺失", minLength = 1)
    private String            label;
}
