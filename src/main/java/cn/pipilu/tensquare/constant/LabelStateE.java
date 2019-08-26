package cn.pipilu.tensquare.constant;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * 标签状态枚举
 */
public enum LabelStateE {
    //0-无效、1-有效
    INVALID("0","无效"),
    VALID("1","有效");
    private static final String defalutLabel="未知状态";

    public String code;
    public String label;
    LabelStateE(String code,String label){
        this.code = code;
        this.label = label;
    }

    public static LabelStateE getState(String code){
        if (StringUtils.isBlank(code))
            return null;
        LabelStateE[] labelStateES = LabelStateE.values();
        for (LabelStateE state : labelStateES) {
            if (code.equals(state.code)){
                return state;
            }
        }
        return null;
    }

    public static String getLabel(String code) {
        LabelStateE stateE = getState(code);
        return Objects.isNull(stateE)? defalutLabel : stateE.label;
    }
}
