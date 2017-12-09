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
package Configuration.Model;

import Configuration.Logic.Log;
import Configuration.Logic.Settings;
import java.io.IOException;
import java.util.logging.Level;

/**
 * Clase Configuration
 */
public final class Configuration {

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    private static Configuration prevInstance;

    // -----------------------------------------------------------------
    // Builders
    // -----------------------------------------------------------------
    /**
     * This method is a builder protected for use of the singleton pattern.
     */
    protected Configuration() {
        String file;

        // Sets the LOG file
        file = "." + Values.STR_LOG_EVENT + "%g" + Values.STR_LOG_EXT;
        Log.loadLogger(file);

        try {
            // Sets the INI file
            file = "." + Values.STR_DATA_SETTINGS;
            Settings.loadProperties(file);
        } catch (IOException e) {
            Log.error(Level.SEVERE, this.getClass().getName(), "loadStrings", "", e);
        }
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * This method returns a unique instance of the class.
     *
     * @return instance - a instace of the configuration
     */
    public static Configuration getPrevInstance() {
        if (prevInstance == null) {
            // If instance don't exist create a new instance
            prevInstance = new Configuration();
        }

        // Return the instance
        return prevInstance;
    }

    /**
     * This method sets a key and value in the settings.
     *
     * @param strKey - the unique key
     * @param strValue - the value of the key
     */
    public void setProperty(String strKey, String strValue) {
        Settings.setProperty(strKey, strValue);
    }

    /**
     * This method gets the value of a key.
     *
     * @param strKey - the unique key
     * @return property - the value of the key
     */
    public String getProperty(String strKey) {
        return Settings.getProperty(strKey);
    }

}
