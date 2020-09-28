package com.zxclown.learning.disruptor;

import lombok.Getter;
import lombok.Setter;

/**
 * 消息.
 *
 * @author zhangxin 2019-06-06 15:56:15
 */
public class LongEvent {
    /**
     * The Value.
     */
    private Long value;
    public void set(Long value){
        this.value = value;
    }
}
