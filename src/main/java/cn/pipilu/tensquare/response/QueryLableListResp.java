package cn.pipilu.tensquare.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 查询列表返回实体
 */
@Data
@ToString
public class QueryLableListResp implements Serializable {
    private static final long    serialVersionUID = 1305434620599495645L;
    private long                 total;                                  // 总数量
    private int                  pageSize;                               // 一页显示条数
    private int                  size;                                   // 页面返回条数
    private int                  pageNo;                                 // 页码

    private List<QueryLabelResp> data;                                   // 页面展示的数据
}
