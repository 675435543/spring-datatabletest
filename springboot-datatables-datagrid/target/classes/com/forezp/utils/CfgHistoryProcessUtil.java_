package com.forezp.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.huawei.rdsearch.biz.CfgOperationHistoryService;
import com.huawei.rdsearch.entity.CfgOperationHistory;

/**
 * 
 *
 */
public class CfgHistoryProcessUtil
{
    protected static final Logger LOG = Logger.getLogger(CfgHistoryProcessUtil.class);

    private static final ExecutorService POOL = Executors.newFixedThreadPool(5);
    
    private CfgOperationHistory cfgOperationHistory;

    CfgHistoryProcessUtil(CfgOperationHistory cfgOperationHistory)
    {
        this.cfgOperationHistory = cfgOperationHistory;
    }

    /**
     * 发送操作 记录
     * @param cfgOperationHistory cfgOperationHistory
     */
    public static void recordHistory(CfgOperationHistory cfgOperationHistory)
    {
        new CfgHistoryProcessUtil(cfgOperationHistory).start();
    }

    private void start()
    {
        CfgHistoryProcessUtil.POOL.execute(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    ((CfgOperationHistoryService) Util.getBeanByName("cfgOperationHistoryServiceImpl"))
                            .add(CfgHistoryProcessUtil.this.cfgOperationHistory);
                }
                catch (Exception e)
                {
                    CfgHistoryProcessUtil.LOG.error("recordHistory error!", e);
                }
            }
        });
    }

}

