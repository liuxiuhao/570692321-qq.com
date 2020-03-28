package com.liuxh.provider.common;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionUtil {
   public static void handleException(Throwable  e){
       if (e instanceof BlockException){
           BlockException blockException = (BlockException) e;
           log.info(blockException.getRule().toString());
           log.info(blockException.getClass().getCanonicalName());
       }
        e.printStackTrace();
        log.info("Sentinel 拦截住了");
    }
}
