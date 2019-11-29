package com.yunus;

import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.InstanceRegistry;

import java.util.concurrent.TimeUnit;

public class TestEurekaContextHolder implements Runnable {

    @Override
    public void run() {
        while (true){
            InstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
            System.out.println(registry.getNumOfRenewsInLastMin()+"====="+registry.getNumOfRenewsPerMinThreshold());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
