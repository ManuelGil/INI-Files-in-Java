//    This file is part of Internationalization Project
//    Configuration Free GNU Application
//    Copyright (C) 2017 Manuel Gil.
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.
//
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * <p>
 * Title: Configuration Project</p>
 * <p>
 * Description: Configuration Free GNU Application</p>
 * <p>
 * Copyright: GPL product</p>
 * <p>
 * Company: <a href="https://github.com/ManuelGil">Manuel Gil</a></p>
 *
 * Problem: Configuration Project
 *
 * @author $Author: Manuel Gil $
 * @version $Revisión: 1.0.0.0001 $ $Date: 12/09/2017 $
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package Configuration.Logic;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

/**
 * Clase Formatter
 */
public final class Formatter extends SimpleFormatter {

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------
    private final String LINE_SEPARATOR = System.getProperty("line.separator");

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * This method creates a format of the LOG file.
     *
     * @return format - the format of the LOG file
     */
    @Override
    public String format(LogRecord record) {
        // Sets the format:
        // Date/Time ClassName	MethodName
        // ErrorLevel: Message
        // Thrown
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new Date(record.getMillis()));
        stringBuilder.append("\t");
        stringBuilder.append(record.getSourceClassName());
        stringBuilder.append("\t");
        stringBuilder.append(record.getSourceMethodName());
        stringBuilder.append(LINE_SEPARATOR);
        stringBuilder.append(record.getLevel().getLocalizedName());
        stringBuilder.append(": ");
        stringBuilder.append(formatMessage(record));
        stringBuilder.append(LINE_SEPARATOR);
        if (record.getThrown() != null) {
            StringWriter sw = new StringWriter();
            try (PrintWriter pw = new PrintWriter(sw)) {
                record.getThrown().printStackTrace(pw);
            }
            stringBuilder.append(sw.toString());
        }
        stringBuilder.append(LINE_SEPARATOR);
        return stringBuilder.toString();
    }

}
