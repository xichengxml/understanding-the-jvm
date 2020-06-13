package com.xicheng.jvm.mashibing;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * description 模拟一个风控模型
 * arthas下载: wget https://alibaba.github.io/arthas/arthas-boot.jar
 *
 * @author xichengxml
 * @date 2020-06-07 09:22
 */
public class C15_FullGCProblem {

    private static final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(50,
            new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) throws Exception {
        executor.setMaximumPoolSize(50);

        for (; ; ) {
            modelFit();
            Thread.sleep(200);
        }
    }

    /**
     * 模型匹配
     */
    private static void modelFit() {
        List<CardInfo> allCardInfo = getAllCardInfo();
        allCardInfo.forEach(cardInfo -> {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formatDate = dateFormat.format(new Date());
            System.out.println(formatDate + ": log for " + Thread.currentThread().getName());
            executor.scheduleWithFixedDelay(cardInfo::m, 4, 6, TimeUnit.SECONDS);
        });
    }

    private static List<CardInfo> getAllCardInfo() {
        List<CardInfo> taskList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            CardInfo ci = new CardInfo();
            taskList.add(ci);
        }

        return taskList;
    }


    private static class CardInfo {
        /**
         * 消费额度
         */
        private BigDecimal consumption = BigDecimal.TEN;

        private String name = "xichengxml";

        private int age = 18;

        private Date birthDate = new Date();

        public void m() {

        }
    }
}
