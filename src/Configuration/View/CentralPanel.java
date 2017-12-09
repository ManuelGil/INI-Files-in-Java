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

import Configuration.Controller.Controller;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Clase CentralPanel
 */
public class CentralPanel extends JPanel {

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    private JLabel lblKey;
    private JComboBox cmbKey;
    private JLabel lblValue;
    private JScrollPane sclPanel;
    private JTextArea txtValue;
    private JButton btnExit;

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------
    private final String[] items = {"app.acronym", "app.name.short", "app.name.large",
        "app.description", "app.copyright", "app.version", "app.build",
        "config.appearance", "config.lenguaje", "config.load", "config.web",
        "config.login", "config.password", "web.port", "web.language", "web.name",
        "web.url", "web.urlcapt", "personal.nickname", "personal.age", "personal.sex",
        "personal.country", "personal.city", "personal.avatar", "personal.message"};

    // -----------------------------------------------------------------
    // Relations
    // -----------------------------------------------------------------
    private final Controller controller;

    // -----------------------------------------------------------------
    // Builders
    // -----------------------------------------------------------------
    /**
     * This method summons the start of the components.
     */
    public CentralPanel() {
        controller = new Controller(this);
        initComponents();
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * This method gets a combo box.
     *
     * @return cmbKey - the combo box
     */
    public JComboBox getCmbKey() {
        return cmbKey;
    }

    /**
     * This method gets a text area.
     *
     * @return txtValue - the text area
     */
    public JTextArea getTxtValue() {
        return txtValue;
    }

    /**
     * This method starts the variables and components of the panel.
     */
    private void initComponents() {
        // Gets the components of the central panel
        lblKey = new JLabel("Key");
        cmbKey = new JComboBox(items);
        lblValue = new JLabel("Value");
        txtValue = new JTextArea();
        txtValue.setEditable(false);
        sclPanel = new JScrollPane(txtValue,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        btnExit = new JButton("Exit");

        this.setLayout(null);

        // Adds the components in the panel
        this.add(lblKey);
        this.add(cmbKey);
        this.add(lblValue);
        this.add(sclPanel);
        this.add(btnExit);

        // Position of the controls
        lblKey.setBounds(10, 10, 270, 10);
        cmbKey.setBounds(10, 30, 270, 20);
        lblValue.setBounds(10, 70, 270, 10);
        sclPanel.setBounds(10, 90, 270, 90);
        btnExit.setBounds(10, 200, 270, 30);

        // Adds the controller class to action of the controls
        cmbKey.addActionListener(controller);
        btnExit.addActionListener(controller);

        // Sets the default key
        cmbKey.setSelectedItem("app.description");
    }

}
