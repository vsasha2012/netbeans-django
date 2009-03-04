
/*
 * PythonPlatformPanel.java
 *
 * Created on Jun 28, 2008, 11:23:04 AM
 */
package org.netbeans.modules.python.platform.panels;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import org.netbeans.modules.python.api.PythonException;
import org.netbeans.modules.python.api.PythonPlatform;
import org.netbeans.modules.python.api.PythonPlatformManager;
import org.netbeans.modules.python.core.ui.models.PathListModel;
import org.netbeans.modules.python.platform.models.PythonPlatformListModel;
import org.netbeans.modules.python.platform.renderers.PlatformListCellRenderer;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.awt.Mnemonics;
import org.openide.util.Exceptions;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;

/**
 * @author Manuel Tijerino
 * @author Allan Davis
 */
public class PythonPlatformPanel extends javax.swing.JPanel {
    boolean ignoreEvents;

    /** Creates new form PythonPlatformPanel */
    public PythonPlatformPanel() {
        manager = PythonPlatformManager.getInstance();
        initComponents();
        try {
            ignoreEvents = true;
            selectDefaultPlatform();
        } finally {
            ignoreEvents = false;
        }

        manager.addVetoableChangeListener(new VetoableChangeListener() {
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                try {
                    ignoreEvents = true;
                    platformListModel.refresh();
                    selectDefaultPlatform();
                } finally {
                    ignoreEvents = false;
                }
            }
        });
    }

    private void selectDefaultPlatform() {
        String defaultName = manager.getDefaultPlatform();
        if (defaultName != null) {
            PythonPlatform defaultPlatform = manager.getPlatform(defaultName);
            if (defaultPlatform != null) {
                platform = defaultPlatform;
                platformList.setSelectedValue(defaultPlatform, true);
                loadPlatform();
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        platformList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        newPlatform = new javax.swing.JButton();
        removePlatform = new javax.swing.JButton();
        autoDetectPlatform = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        platformName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        command = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        console = new javax.swing.JTextField();
        btnConsoleBrowse = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        commandArgs = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pythonPath = new javax.swing.JList();
        addPythonPath = new javax.swing.JButton();
        removePythonPath = new javax.swing.JButton();
        moveUpPythonPath = new javax.swing.JButton();
        moveDownPythonPath = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        javaClasspath = new javax.swing.JList();
        addJavaPath = new javax.swing.JButton();
        removeJavaPath = new javax.swing.JButton();
        moveUpJavaPath = new javax.swing.JButton();
        moveDownJavaPath = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        makePlatformDefault = new javax.swing.JButton();

        jLabel6.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.jLabel6.text")); // NOI18N

        platformList.setModel(platformListModel);
        platformList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        platformList.setCellRenderer(new PlatformListCellRenderer());
        platformList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                platformListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(platformList);

        jLabel1.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.jLabel1.text")); // NOI18N

        newPlatform.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.newPlatform.text")); // NOI18N
        newPlatform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPlatformActionPerformed(evt);
            }
        });

        removePlatform.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.removePlatform.text")); // NOI18N
        removePlatform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlatformActionPerformed(evt);
            }
        });

        autoDetectPlatform.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.autoDetectPlatform.text")); // NOI18N
        autoDetectPlatform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoDetectPlatformActionPerformed(evt);
            }
        });

        jLabel2.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.jLabel2.text")); // NOI18N

        platformName.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.platformName.text")); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.jLabel3.text")); // NOI18N

        command.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.command.text")); // NOI18N

        jLabel4.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.jLabel4.text")); // NOI18N

        console.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.console.text")); // NOI18N

        btnConsoleBrowse.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.btnConsoleBrowse.text")); // NOI18N
        btnConsoleBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsoleBrowseActionPerformed(evt);
            }
        });

        jLabel8.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.jLabel8.text")); // NOI18N

        commandArgs.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.commandArgs.text")); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel8)
                    .add(jLabel4)
                    .add(jLabel3)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(platformName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(console, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnConsoleBrowse))
                    .add(commandArgs, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .add(command, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
                .add(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(platformName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(command, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(console, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnConsoleBrowse))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(commandArgs, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.jPanel1.TabConstraints.tabTitle"), jPanel1); // NOI18N

        jLabel5.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.jLabel5.text")); // NOI18N

        pythonPath.setModel(pythonPathModel);
        pythonPath.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(pythonPath);

        addPythonPath.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.addPythonPath.text")); // NOI18N
        addPythonPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPythonPathActionPerformed(evt);
            }
        });

        removePythonPath.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.removePythonPath.text")); // NOI18N
        removePythonPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePythonPathActionPerformed(evt);
            }
        });

        moveUpPythonPath.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.moveUpPythonPath.text")); // NOI18N
        moveUpPythonPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveUpPythonPathActionPerformed(evt);
            }
        });

        moveDownPythonPath.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.moveDownPythonPath.text")); // NOI18N
        moveDownPythonPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveDownPythonPathActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(moveDownPythonPath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(moveUpPythonPath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .add(removePythonPath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .add(addPythonPath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
                    .add(jLabel5))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jLabel5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
                        .add(addPythonPath)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(removePythonPath)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(moveUpPythonPath)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(moveDownPythonPath))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        javaClasspath.setModel(javaPathModel);
        javaClasspath.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(javaClasspath);

        addJavaPath.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.addJavaPath.text")); // NOI18N
        addJavaPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJavaPathActionPerformed(evt);
            }
        });

        removeJavaPath.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.removeJavaPath.text")); // NOI18N
        removeJavaPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeJavaPathActionPerformed(evt);
            }
        });

        moveUpJavaPath.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.moveUpJavaPath.text")); // NOI18N
        moveUpJavaPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveUpJavaPathActionPerformed(evt);
            }
        });

        moveDownJavaPath.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.moveDownJavaPath.text")); // NOI18N
        moveDownJavaPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveDownJavaPathActionPerformed(evt);
            }
        });

        jLabel7.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.jLabel7.text")); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel7)
                .addContainerGap(456, Short.MAX_VALUE))
            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(moveDownJavaPath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(removeJavaPath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .add(addJavaPath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .add(moveUpJavaPath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                    .add(11, 11, 11)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jLabel7)
                .addContainerGap(278, Short.MAX_VALUE))
            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel3Layout.createSequentialGroup()
                    .add(22, 22, 22)
                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                        .add(jPanel3Layout.createSequentialGroup()
                            .add(addJavaPath)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(removeJavaPath)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(moveUpJavaPath)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(moveDownJavaPath)))
                    .addContainerGap()))
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.jPanel3.TabConstraints.tabTitle"), jPanel3); // NOI18N

        makePlatformDefault.setText(org.openide.util.NbBundle.getMessage(PythonPlatformPanel.class, "PythonPlatformPanel.makePlatformDefault.text")); // NOI18N
        makePlatformDefault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makePlatformDefaultActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, makePlatformDefault, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, autoDetectPlatform, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(newPlatform, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(removePlatform, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel1)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(removePlatform)
                            .add(newPlatform))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(autoDetectPlatform)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(makePlatformDefault))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadPlatform() {
        platformName.setText(platform.getName());
        command.setText(platform.getInterpreterCommand());
        console.setText(platform.getInterpreterConsoleComand());
        commandArgs.setText(platform.getInterpreterArgs());
        // Make copy so we don't muck with the master copy in the platform manager...
        pythonPathModel.setModel(new ArrayList<String>(platform.getPythonPath()));
        javaPathModel.setModel(new ArrayList<String>(platform.getJavaPath()));

    }

    private void clearPlatform() {
        platformName.setText("");
        command.setText("");
        console.setText("");
        commandArgs.setText("");
        pythonPathModel.setModel(new ArrayList<String>());
        javaPathModel.setModel(new ArrayList<String>());

    }

    private void newPlatformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPlatformActionPerformed
        final JFileChooser fc = new JFileChooser();
        fc.setFileHidingEnabled(false);
        fc.addChoosableFileFilter(new ExeFilter());
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                String cmd = fc.getSelectedFile().getAbsolutePath();
                platform = manager.findPlatformProperties(cmd, null);
                loadPlatform();
                platformListModel.refresh();
            } catch (PythonException ex) {
                Exceptions.printStackTrace(ex);
            }
        }


    }//GEN-LAST:event_newPlatformActionPerformed

    private void platformListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_platformListValueChanged
        if (platform != null) {
            updatePlatform();
        }
        int selectedIndex = platformList.getSelectedIndex();
        if (selectedIndex != -1) {
            platform = (PythonPlatform)platformListModel.getElementAt(selectedIndex);
            loadPlatform();
        }
}//GEN-LAST:event_platformListValueChanged

    private void btnConsoleBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsoleBrowseActionPerformed
        final JFileChooser fc = new JFileChooser();
        fc.setFileHidingEnabled(false);
        fc.addChoosableFileFilter(new ExeFilter());
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            console.setText(fc.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_btnConsoleBrowseActionPerformed

    private void removePlatformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlatformActionPerformed
        int selectedIndex = platformList.getSelectedIndex();
        if (selectedIndex != -1) {
            manager.removePlatform(
                    ((PythonPlatform)platformListModel.getElementAt(
                    selectedIndex)).getId());
            platformListModel.refresh();
            platform = null;
            clearPlatform();
        }
    }//GEN-LAST:event_removePlatformActionPerformed

    private void makePlatformDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makePlatformDefaultActionPerformed
        int selectedIndex = platformList.getSelectedIndex();
        if (selectedIndex != -1) {
            manager.setDefaultPlatform(
                    ((PythonPlatform)platformListModel.getElementAt(
                    selectedIndex)).getId());
            platformListModel.refresh();
        }
    }//GEN-LAST:event_makePlatformDefaultActionPerformed

    private void addPythonPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPythonPathActionPerformed
        final JFileChooser fc = new JFileChooser();
        fc.setFileHidingEnabled(false);
        fc.setDialogTitle("Select Python Egg or Python Lib Directory");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.setMultiSelectionEnabled(true);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File files[] = fc.getSelectedFiles();
            for (File file : files) {
                String cmd = file.getAbsolutePath();
                pythonPathModel.add(cmd);
            }
        }
    }//GEN-LAST:event_addPythonPathActionPerformed

    private void removePythonPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePythonPathActionPerformed
        int selectedIndex = pythonPath.getSelectedIndex();
        if (selectedIndex != -1) {
            pythonPathModel.remove(selectedIndex);
        }
    }//GEN-LAST:event_removePythonPathActionPerformed

    private void moveUpPythonPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveUpPythonPathActionPerformed
        int selectedIndex = pythonPath.getSelectedIndex();
        if (selectedIndex != -1) {
            pythonPathModel.moveUp(selectedIndex);
        }
    }//GEN-LAST:event_moveUpPythonPathActionPerformed

    private void moveDownPythonPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveDownPythonPathActionPerformed
        int selectedIndex = pythonPath.getSelectedIndex();
        if (selectedIndex != -1) {
            pythonPathModel.moveDown(selectedIndex);
        }
    }//GEN-LAST:event_moveDownPythonPathActionPerformed

    private void addJavaPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJavaPathActionPerformed
        final JFileChooser fc = new JFileChooser();
        fc.setFileHidingEnabled(false);
        fc.setDialogTitle("Select Jar or Directory");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.setMultiSelectionEnabled(true);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File files[] = fc.getSelectedFiles();
            for (File file : files) {
                String cmd = file.getAbsolutePath();
                javaPathModel.add(cmd);
            }
        }
    }//GEN-LAST:event_addJavaPathActionPerformed

    private void removeJavaPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeJavaPathActionPerformed
        int selectedIndex = javaClasspath.getSelectedIndex();
        if (selectedIndex != -1) {
            javaPathModel.remove(selectedIndex);
        }
    }//GEN-LAST:event_removeJavaPathActionPerformed

    private void moveUpJavaPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveUpJavaPathActionPerformed
        int selectedIndex = javaClasspath.getSelectedIndex();
        if (selectedIndex != -1) {
            javaPathModel.moveUp(selectedIndex);
        }
    }//GEN-LAST:event_moveUpJavaPathActionPerformed

    private void moveDownJavaPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveDownJavaPathActionPerformed
        int selectedIndex = javaClasspath.getSelectedIndex();
        if (selectedIndex != -1) {
            javaPathModel.moveDown(selectedIndex);
        }
    }//GEN-LAST:event_moveDownJavaPathActionPerformed

    private void autoDetectPlatformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoDetectPlatformActionPerformed

        manager.autoDetect();
        platformListModel.refresh();
    }//GEN-LAST:event_autoDetectPlatformActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJavaPath;
    private javax.swing.JButton addPythonPath;
    private javax.swing.JButton autoDetectPlatform;
    private javax.swing.JButton btnConsoleBrowse;
    private javax.swing.JTextField command;
    private javax.swing.JTextField commandArgs;
    private javax.swing.JTextField console;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList javaClasspath;
    private javax.swing.JButton makePlatformDefault;
    private javax.swing.JButton moveDownJavaPath;
    private javax.swing.JButton moveDownPythonPath;
    private javax.swing.JButton moveUpJavaPath;
    private javax.swing.JButton moveUpPythonPath;
    private javax.swing.JButton newPlatform;
    private javax.swing.JList platformList;
    private javax.swing.JTextField platformName;
    private javax.swing.JList pythonPath;
    private javax.swing.JButton removeJavaPath;
    private javax.swing.JButton removePlatform;
    private javax.swing.JButton removePythonPath;
    // End of variables declaration//GEN-END:variables
    private PythonPlatformManager manager;
    private PythonPlatform platform;
    private PathListModel pythonPathModel = new PathListModel();
    private PathListModel javaPathModel = new PathListModel();
    private PythonPlatformListModel platformListModel = new PythonPlatformListModel();

    public static void showPlatformManager() {
        final PythonPlatformPanel customizer = new PythonPlatformPanel();
        JButton closeButton = new JButton();
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                customizer.savePlatform();
            }
        });
        closeButton.getAccessibleContext().setAccessibleDescription(getMessage("PythonPlatformPanel.closeButton.AccessibleContext.accessibleName"));
        Mnemonics.setLocalizedText(closeButton,
                NbBundle.getMessage(PythonPlatformPanel.class, "CTL_Close"));
        DialogDescriptor descriptor = new DialogDescriptor(
                customizer,
                getMessage("CTL_PythonPlatformManager_Title"), // NOI18N
                true,
                new Object[]{closeButton},
                closeButton,
                DialogDescriptor.DEFAULT_ALIGN,
                new HelpCtx(PythonPlatformPanel.class),
                null);
        Dialog dlg = DialogDisplayer.getDefault().createDialog(descriptor);
        dlg.setVisible(true);
        PythonPlatformManager.getInstance().save();
        dlg.dispose();
    }

    private static String getMessage(String key) {
        return NbBundle.getMessage(PythonPlatformPanel.class, key);
    }

    private void updatePlatform() {
        if (ignoreEvents) {
            // We're probably changing the list contents as the result of an asynchronous
            // refresh -- don't use this to store results back into the platform!
            return;
        }

        platform.setInterpreterArgs(commandArgs.getText());
        platform.setName(platformName.getText());
        platform.setInterpreterCommand(command.getText());
        platform.setInterpreterConsoleComand(console.getText());
        platform.setJavaPath(javaPathModel.getModel());
        platform.setPythonPath(pythonPathModel.getModel());

        // This shouldn't be necessary anymore -- the platform's -id- doesn't
        // change even though you may have edited properties in it, such as
        // its name
        //manager.addPlatform(platform);
    }

    public void savePlatform() {
        if (platform != null) {
            updatePlatform();
        }
    }

    class ExeFilter extends FileFilter {
        @Override
        public boolean accept(File file) {
            String ext = getExtention(file);
            if (ext == null) {
                return true;
            } else if (ext.equalsIgnoreCase("bat") || ext.equalsIgnoreCase("com") || ext.equalsIgnoreCase("exe")) { // NOI18N
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String getDescription() {
            return NbBundle.getMessage(PythonPlatformPanel.class, "Executables");
        }

        private String getExtention(File file) {
            String ext = null;
            if (file.isFile()) {
                int pos = file.getName().indexOf(".");
                if (pos > 0) {
                    ext = file.getName().substring(pos + 1);
                }
            }
            return ext;
        }
    }
}
