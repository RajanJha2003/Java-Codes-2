package ui;

import model.User;
import operationsImp.OperationsImp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateUserForm extends JFrame {

    private JTextField usernameField, emailField, phoneField, genderField, cityField;
    private JButton updateButton;

    public UpdateUserForm(User user, AllUsers parentFrame, int rowIndex) {
        setTitle("Update User");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 20, 100, 25);
        add(usernameLabel);

        usernameField = new JTextField(user.getUsername());
        usernameField.setBounds(130, 20, 120, 25);
        add(usernameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 60, 100, 25);
        add(emailLabel);

        emailField = new JTextField(user.getEmail());
        emailField.setBounds(130, 60, 120, 25);
        add(emailField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 100, 100, 25);
        add(phoneLabel);

        phoneField = new JTextField(user.getPhone());
        phoneField.setBounds(130, 100, 120, 25);
        add(phoneField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 140, 100, 25);
        add(genderLabel);

        genderField = new JTextField(user.getGender());
        genderField.setBounds(130, 140, 120, 25);
        add(genderField);

        JLabel cityLabel = new JLabel("City:");
        cityLabel.setBounds(30, 180, 100, 25);
        add(cityLabel);

        cityField = new JTextField(user.getCity());
        cityField.setBounds(130, 180, 120, 25);
        add(cityField);

        updateButton = new JButton("Update");
        updateButton.setBounds(90, 220, 100, 30);
        add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.setUsername(usernameField.getText());
                user.setEmail(emailField.getText());
                user.setPhone(phoneField.getText());
                user.setGender(genderField.getText());
                user.setCity(cityField.getText());

                OperationsImp imp = new OperationsImp();
                boolean updated = imp.updateUser(user);
                if (updated) {
                    JOptionPane.showMessageDialog(UpdateUserForm.this, "User updated successfully!");
                    
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(UpdateUserForm.this, "Failed to update user.");
                }
            }
        });

        setVisible(true);
    }
}
