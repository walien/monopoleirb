package com.gcc.monopoleirb.core.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gcc.monopoleirb.core.domain.Constants;

public class MonopoleirbLogger {

	private static FileHandler _HTML_FILE;
	private static Formatter _HTML_FORMATTER;

	private static Logger _LOGGER;

	public static void setup(Level defaultLevel) throws IOException {
		// Create Logger
		_LOGGER = Logger.getLogger(Constants.SYSTEM_LOG_NAME);
		_LOGGER.setLevel(defaultLevel);
		_LOGGER.setUseParentHandlers(false);

		// Create HTML Formatter
		_HTML_FORMATTER = new LogHTMLFormatter();
		_HTML_FILE = new FileHandler(Constants.LOG_FILE_NAME);
		_HTML_FILE.setFormatter(_HTML_FORMATTER);
		_LOGGER.addHandler(_HTML_FILE);
	}

	public static final void setLoggerLevel(Level newLevel) {
		_LOGGER.setLevel(newLevel);
	}

	public static final Logger getLogger() {
		return _LOGGER;
	}
}
