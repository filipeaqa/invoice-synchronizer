package com.api.challenge.invoicesynchronizer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private Synchronizer synchronizer;

    public ScheduledTasks(Synchronizer synchronizer) {
        this.synchronizer = synchronizer;
    }

    @Scheduled(fixedRate = 30000, initialDelay = 10000)
    public void synchronizeInvoices() {
        synchronizer.synchronize();
    }
}
