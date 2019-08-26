package cn.pipilu.tensquare.response;

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
@Data
@ToString
public class QueryLabelReq implements Serializable {
    private static final long serialVersionUID = -4592764587175963217L;
    private String            id;
    private int               count;                                  // 使用量
    private int               fans;
    private String label;
    private String stateName;
    private String recommendName;
}
