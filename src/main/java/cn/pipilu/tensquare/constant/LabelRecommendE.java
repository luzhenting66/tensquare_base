package cn.pipilu.tensquare.constant;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * 标签推荐枚举
 */
public enum LabelRecommendE {
    //0-不推荐、1-推荐
    UNRECOMMEND("0","不推荐"),
    RECOMMEND("1","推荐");
    private static final String defalutLabel="未知";

    public String code;
    public String label;
    LabelRecommendE(String code,String label){
        this.code = code;
        this.label = label;
    }

    public static LabelRecommendE getState(String code){
        if (StringUtils.isBlank(code))
            return null;
        LabelRecommendE[] recommendE = LabelRecommendE.values();
        for (LabelRecommendE recommend : recommendE) {
            if (code.equals(recommend.code)){
                return recommend;
            }
        }
        return null;
    }

    public static String getLabel(String code) {
        LabelRecommendE recommend = getState(code);
        return Objects.isNull(recommend)? defalutLabel : recommend.label;
    }
}
