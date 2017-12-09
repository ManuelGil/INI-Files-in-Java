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

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Log
 */
public abstract class Log {

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------
    private final static Logger logger = Logger.getLogger(Log.class.getName());

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * This method creates a LOG file and sets the formatter.
     *
     * @param strFile - the file name
     */
    public static void loadLogger(String strFile) {
        try {
            // Loads the file in a handler
            FileHandler handler = new FileHandler(strFile);
            // Sets all error levels
            handler.setLevel(Level.ALL);
            // Sets the format
            handler.setFormatter(new Formatter());

            // Records the handler
            logger.addHandler(handler);
        } catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method sets the level 'info' on the LOG.
     *
     * @param strMessage - the message error
     */
    public static void info(String strMessage) {
        logger.logp(Level.INFO, null, null, strMessage);
    }

    /**
     * This method sets the level 'error' on the LOG.
     *
     * @param level - the error level
     * @param strClass - the class name
     * @param strMethod - the method name
     * @param strMessage - the message error
     * @param thrown - the thrown
     */
    public static void error(Level level, String strClass, String strMethod, String strMessage, Throwable thrown) {
        logger.logp(level, strClass, strMethod, strMessage, thrown);
    }

}
