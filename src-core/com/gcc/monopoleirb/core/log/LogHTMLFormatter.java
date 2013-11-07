package com.gcc.monopoleirb.core.log;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class LogHTMLFormatter extends Formatter {

	public static final String WARNING_COLOR = " style=\"color:orange;\"";
	public static final String ERROR_COLOR = " style=\"color:red;\"";

	// This method is called for every log records
	@Override
	public String format(LogRecord rec) {
		StringBuffer buf = new StringBuffer();
		// Bold any levels >= WARNING
		buf.append("<tr>");
		buf.append("\t<td>");

		if (rec.getLevel().intValue() == Level.WARNING.intValue()) {
			buf.append("<b" + WARNING_COLOR + ">");
			buf.append(rec.getLevel());
			buf.append("</b>");
		} else if (rec.getLevel().intValue() == Level.SEVERE.intValue()) {
			buf.append("<b" + ERROR_COLOR + ">");
			buf.append(rec.getLevel());
			buf.append("</b>");
		} else {
			buf.append(rec.getLevel());
		}

		buf.append("\t</td>\n");
		buf.append("\t<td>");
		buf.append(new Date(rec.getMillis()).toString());
		buf.append("\t</td>\n");
		buf.append("\t<td>");
		buf.append(formatMessage(rec));
		buf.append("\t</td>\n");
		buf.append("</tr>\n");
		return buf.toString();
	}

	// This method is called just after the handler using this
	// formatter is created
	@Override
	public String getHead(Handler h) {
		return "<HTML>\n<HEAD><TITLE>Monopoleirb Log</TITLE>"
				+ "<meta http-equiv=\"content-type\" content=\"text/html\" charset=\"utf-8\"/>"
				+ "</HEAD>\n<BODY>\n<PRE>\n" + "<table border>\n  "
				+ "<tr><th>Level</th><th>Time</th><th>Log Message</th></tr>\n";
	}

	// This method is called just after the handler using this
	// formatter is closed
	@Override
	public String getTail(Handler h) {
		return "</table>\n  </PRE></BODY>\n</HTML>\n";
	}
}