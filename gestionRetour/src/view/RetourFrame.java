package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class RetourFrame extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JButton calculPenaliteButton;
    private JTextField dateRetourEffectiveField;
    private JLabel penaliteLabel;
    private JButton modifierDateRetourButton;

    public RetourFrame() {
        setTitle("Gestion des Retours");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"ID Emprunt", "Nom du Livre", "ID Utilisateur",
                 "Date Emprunt", "Date Retour Prévue", "Date Retour Effective", "Pénalité"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Date Retour Effective :"));
        dateRetourEffectiveField = new JTextField(10);
        panel.add(dateRetourEffectiveField);

        calculPenaliteButton = new JButton("Calculer Pénalité");
        panel.add(calculPenaliteButton);

        penaliteLabel = new JLabel("Pénalité : ");
        panel.add(penaliteLabel);

        modifierDateRetourButton = new JButton("Modifier Date Retour Effective");
        panel.add(modifierDateRetourButton);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }

    public void addCalculPenaliteListener(ActionListener listener) {
        calculPenaliteButton.addActionListener(listener);
    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public String getDateRetourEffective() {
        return dateRetourEffectiveField.getText();
    }

    public Object getValueAt(int row, int column) {
        return model.getValueAt(row, column);
    }

    public void setValueAt(int row, int column, Object value) {
        model.setValueAt(value, row, column);
    }
    public void addModifierDateRetourListener(ActionListener listener) {
        modifierDateRetourButton.addActionListener(listener);
    }
    public void addCalculPenaliteListener1(ActionListener listener) {
        calculPenaliteButton.addActionListener(listener);
    }
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }
    public void updateTableData(Object[][] data) {
        model.setRowCount(0); // Réinitialise les données
        for (Object[] row : data) {
            model.addRow(row); // Ajoute chaque ligne au tableau
        }
    }
    public JTable getTable() {
        return table;
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
