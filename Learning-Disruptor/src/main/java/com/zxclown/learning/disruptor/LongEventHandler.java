package com.zxclown.learning.disruptor;


import com.lmax.disruptor.EventHandler;

/**
 * 消费者.
 *
 * @author zhangxin 2019-06-06 16:02:49
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("Event: " + longEvent);
    }
}
