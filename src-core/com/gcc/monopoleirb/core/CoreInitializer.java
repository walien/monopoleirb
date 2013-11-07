package com.gcc.monopoleirb.core;

import java.io.IOException;

import com.gcc.monopoleirb.core.domain.Constants;
import com.gcc.monopoleirb.core.log.MonopoleirbLogger;

public class CoreInitializer {

	public static void init() {
		try {
			
			// Init the log system
			MonopoleirbLogger.setup(Constants.DEFAULT_LOG_LEVEL);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
