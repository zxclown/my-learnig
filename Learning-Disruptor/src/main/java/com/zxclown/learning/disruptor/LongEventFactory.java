package com.zxclown.learning.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * 消息工厂.
 *
 * @author zhangxin 2019-06-06 15:56:12
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
