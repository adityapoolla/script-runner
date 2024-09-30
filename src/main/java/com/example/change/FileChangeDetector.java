package com.example.change;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileChangeDetector {

	@Value("${test.file.path}")
	private String filePath;
	
	private long fileLastModified;
	
	public boolean isFileModified() {
		try {
			long lastUpdated = this.getLastModifiedTime();
			if(fileLastModified != lastUpdated)
			{
				fileLastModified = lastUpdated;
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private long getLastModifiedTime() throws IOException {
        Path path = Paths.get(filePath);
        FileTime fileTime = Files.getLastModifiedTime(path);
        System.out.println(fileTime.toString());
        return fileTime.toMillis();
    }

}
