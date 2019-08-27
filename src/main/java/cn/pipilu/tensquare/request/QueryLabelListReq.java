package cn.pipilu.tensquare.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class QueryLabelListReq implements Serializable {

    private static final long serialVersionUID = 5057764881075479505L;
    private int               pageNo;
    private int               pageSize;
}
