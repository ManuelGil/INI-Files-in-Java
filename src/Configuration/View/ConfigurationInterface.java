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
package Configuration.View;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * Clase ConfigurationInterface
 */
public class ConfigurationInterface extends JFrame {

    // -----------------------------------------------------------------
    // Builders
    // -----------------------------------------------------------------
    /**
     * This method summons the start of the components.
     */
    public ConfigurationInterface() {
        initComponents();
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * This method starts the variables and components of the window.
     */
    private void initComponents() {
        // Title of the window
        this.setTitle("Configuration");
        // Size of the window
        this.setSize(300, 280);
        // Position of the window
        this.setLocationRelativeTo(null);
        // Close when leaving
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // No resizable
        this.setResizable(false);

        // Create a Central Panel
        CentralPanel centralPanel = new CentralPanel();
        // Adds the central panel in the window
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(centralPanel, BorderLayout.CENTER);
    }

}
