/*
*Name:Zalik Barasa Juma
*Reg No: J77-10594-2024
*Description: Program for swing app
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleSwingApp {
    public static void main(String[] args) {
        // Create main frame
        JFrame frame = new JFrame("Simple Swing App");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // ========== MENU BAR ==========
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");
        
        newItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "New clicked"));
        openItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Open clicked"));
        exitItem.addActionListener(e -> System.exit(0));
        
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        
        // ========== MAIN PANEL ==========
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // 1. Name Section
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField(15);
        namePanel.add(nameField);
        JButton submitBtn = new JButton("Submit");
        namePanel.add(submitBtn);
        
        submitBtn.addActionListener(e -> {
            if (!nameField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Hello, " + nameField.getText() + "!");
            }
        });
        
        // 2. Login Section
        JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        loginPanel.add(new JLabel("Username:"));
        JTextField userField = new JTextField(10);
        loginPanel.add(userField);
        JButton loginBtn = new JButton("Login");
        loginPanel.add(loginBtn);
        
        loginBtn.addActionListener(e -> {
            if (!userField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Welcome, " + userField.getText() + "!");
            }
        });
        
        // 3. Checkbox and Radio
        JPanel checkRadioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox termsCheck = new JCheckBox("Accept terms");
        JRadioButton maleRadio = new JRadioButton("Male");
        JRadioButton femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        maleRadio.setSelected(true);
        
        checkRadioPanel.add(termsCheck);
        checkRadioPanel.add(maleRadio);
        checkRadioPanel.add(femaleRadio);
        
        // 4. ComboBox
        JPanel comboPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        comboPanel.add(new JLabel("Language:"));
        String[] languages = {"Java", "Python", "C++"};
        JComboBox<String> langCombo = new JComboBox<>(languages);
        comboPanel.add(langCombo);
        
        // 5. Calculator (Simple grid)
        JPanel calcPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        calcPanel.setBorder(BorderFactory.createTitledBorder("Calculator"));
        
        // Add calculator buttons
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };
        
        JTextField calcDisplay = new JTextField("0");
        calcDisplay.setEditable(false);
        
        for (String text : buttons) {
            JButton btn = new JButton(text);
            calcPanel.add(btn);
        }
        
        // 6. Click Me Button
        JButton clickMeBtn = new JButton("Click Me!");
        clickMeBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Button Clicked!");
        });
        
        // Add all components to main panel
        mainPanel.add(namePanel);
        mainPanel.add(loginPanel);
        mainPanel.add(checkRadioPanel);
        mainPanel.add(comboPanel);
        mainPanel.add(calcPanel);
        mainPanel.add(clickMeBtn);
        
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}