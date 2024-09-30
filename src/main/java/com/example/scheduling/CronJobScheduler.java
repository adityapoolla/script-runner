package com.example.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.change.FileChangeDetector;

@Component
public class CronJobScheduler {
	
	@Autowired
	private FileChangeDetector fileChangeDetector;

	@Scheduled(cron = "${schedule.cron.expression}")
    public void scheduledRun() {
        if(fileChangeDetector.isFileModified()) {
        	System.out.println("file Updated");
        	// run any batch script here
//        	ExampleBatchFileRunner.run(null);
        } else 
        {
        	System.out.println("file not updated");
        }
    }
}
