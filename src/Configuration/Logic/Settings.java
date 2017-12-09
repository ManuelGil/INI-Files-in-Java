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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Clase Settings
 */
public abstract class Settings {

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------
    private final static Properties properties = new Properties();

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * This method loads the INI file.
     *
     * @param strFile - the file name
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void loadProperties(String strFile) throws FileNotFoundException, IOException {
        properties.load(new FileInputStream(strFile));
    }

    /**
     * This method creates a new value in the INI file.
     *
     * @param strKey - the unique key
     * @param strValue - the value to key
     */
    public static void setProperty(String strKey, String strValue) {
        properties.setProperty(strKey, strValue);
    }

    /**
     * This method gets a value in the INI file.
     *
     * @param strKey - the unique key
     * @return property - the value of the key
     */
    public static String getProperty(String strKey) {
        return properties.getProperty(strKey);
    }

}
