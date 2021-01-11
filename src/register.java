import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;



public class register implements ActionListener {

    private static JFrame registerFrame;
    private static JTextField userRegistrationUserName;
    private static JTextField getUserRegistrationEmailAddress;
    private static JTextField userRegistrationPhoneNumber;
    private static JTextField userRegistrationTitle;
    private static JTextField userRegistrationSurname;
    private static JTextField userRegistrationLastName;
    private static JTextField userRegistrationStreet;
    private static JTextField userRegistrationHouseNumber;
    private static JTextField userRegistrationPLZ;
    private static JTextField userRegistrationCity;

    public static void userRegistration() {

        login.loginFrame.setEnabled(false);

        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(null);

        registerFrame = new JFrame();

        registerFrame.setSize(470, 550);
        registerFrame.setLocation(login.dim.width / 2 - registerFrame.getSize().width / 2, login.dim.height / 2 - registerFrame.getSize().height / 2);
        registerFrame.setResizable(false);
        registerFrame.setTitle("Register");
        registerFrame.setIconImage(login.titleIcon.getImage());
        registerFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                login.loginFrame.setEnabled(true);
            }
        });

        JLabel userUserName = new JLabel("Username:");
        userUserName.setBounds(40, 20, 120, 25);
        registerPanel.add(userUserName);
        userRegistrationUserName = new JTextField();
        userRegistrationUserName.setBounds(250, 20, 165, 25);
        registerPanel.add(userRegistrationUserName);

        JLabel userEmailAddress = new JLabel("Email Address:");
        userEmailAddress.setBounds(40, 50, 120, 25);
        registerPanel.add(userEmailAddress);
        getUserRegistrationEmailAddress = new JTextField();
        getUserRegistrationEmailAddress.setBounds(250, 50, 165, 25);
        registerPanel.add(getUserRegistrationEmailAddress);



        JLabel userTitle = new JLabel("Title:");
        userTitle.setBounds(40, 110, 120, 25);
        registerPanel.add(userTitle);
        userRegistrationTitle = new JTextField();
        userRegistrationTitle.setBounds(250, 110, 165, 25);
        registerPanel.add(userRegistrationTitle);

        JLabel userSurName = new JLabel("Name:");
        userSurName.setBounds(40, 140, 120, 25);
        registerPanel.add(userSurName);
        userRegistrationSurname = new JTextField();
        userRegistrationSurname.setBounds(250, 140, 165, 25);
        registerPanel.add(userRegistrationSurname);

        JLabel userLastName = new JLabel("Last name:");
        userLastName.setBounds(40, 170, 120, 25);
        registerPanel.add(userLastName);
        userRegistrationLastName = new JTextField();
        userRegistrationLastName.setBounds(250, 170, 165, 25);
        registerPanel.add(userRegistrationLastName);

        JLabel userPhoneNumber = new JLabel("Phone number:");
        userPhoneNumber.setBounds(40, 200, 120, 25);
        registerPanel.add(userPhoneNumber);
        userRegistrationPhoneNumber = new JTextField();
        userRegistrationPhoneNumber.setBounds(250, 200, 165, 25);
        registerPanel.add(userRegistrationPhoneNumber);

        JLabel userStreet = new JLabel("Street:");
        userStreet.setBounds(40, 230, 120, 25);
        registerPanel.add(userStreet);
        userRegistrationStreet = new JTextField();
        userRegistrationStreet.setBounds(250, 230, 165, 25);
        registerPanel.add(userRegistrationStreet);

        JLabel userHouseNumber = new JLabel("House number:");
        userHouseNumber.setBounds(40, 260, 120, 25);
        registerPanel.add(userHouseNumber);
        userRegistrationHouseNumber = new JTextField();
        userRegistrationHouseNumber.setBounds(250, 260, 165, 25);
        registerPanel.add(userRegistrationHouseNumber);

        JLabel userPLZ = new JLabel("Postal code:");
        userPLZ.setBounds(40, 290, 120, 25);
        registerPanel.add(userPLZ);
        userRegistrationPLZ = new JTextField();
        userRegistrationPLZ.setBounds(250, 290, 165, 25);
        registerPanel.add(userRegistrationPLZ);

        JLabel userCity = new JLabel("City:");
        userCity.setBounds(40, 320, 120, 25);
        registerPanel.add(userCity);
        userRegistrationCity = new JTextField();
        userRegistrationCity.setBounds(250, 320, 165, 25);
        registerPanel.add(userRegistrationCity);

        JLabel userPassword = new JLabel("Password");
        userPassword.setBounds(40, 350, 120, 25);
        registerPanel.add(userPassword);
        JPasswordField userRegistrationPassword1 = new JPasswordField();
        userRegistrationPassword1.setBounds(250, 350, 165, 25);
        registerPanel.add(userRegistrationPassword1);

        JLabel userPasswordValidation = new JLabel("Password again:");
        userPasswordValidation.setBounds(40, 380, 120, 25);
        registerPanel.add(userPasswordValidation);
        JPasswordField userRegistrationPassword2 = new JPasswordField();
        userRegistrationPassword2.setBounds(250, 380, 165, 25);
        registerPanel.add(userRegistrationPassword2);

        JButton acceptRegisterButton = new JButton("Register");
        acceptRegisterButton.setBounds(20, 500, 100, 25);
        acceptRegisterButton.setLocation(registerFrame.getWidth() / 2 - acceptRegisterButton.getWidth() / 2 - 5, registerFrame.getY() + registerFrame.getY() / 2 + 50);
        acceptRegisterButton.addActionListener(new register());


        registerFrame.add(acceptRegisterButton);
        registerFrame.add(registerPanel);
        registerFrame.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if( userRegistrationSurname.getText().equals("") || userRegistrationLastName.getText().equals("") ||
                    userRegistrationUserName.getText().equals("") || userRegistrationStreet.getText().equals("") ||
                    userRegistrationPLZ.getText().equals("") || userRegistrationCity.getText().equals("")) {
                JOptionPane.showMessageDialog(login.loginFrame, "Every field has to be filled out!");
            } else {
                patient patientRegister = new patient(userRegistrationUserName.getText(),
                        getUserRegistrationEmailAddress.getText(), userRegistrationSurname.getText(),
                        userRegistrationLastName.getText(), userRegistrationCity.getText(),
                        userRegistrationStreet.getText(), userRegistrationHouseNumber.getText(),
                        userRegistrationPLZ.getText(), userRegistrationPhoneNumber.getText(),
                        userRegistrationTitle.getText());
                BufferedWriter bw = new BufferedWriter(new FileWriter("userLoginData"));
                final String userUserNameWrite = userRegistrationUserName.getText();
                bw.write(userUserNameWrite + "\n");
                final String userSurnameWrite = userRegistrationSurname.getText();
                bw.write(userSurnameWrite + "\n");
                final String lastNameWrite = userRegistrationLastName.getText();
                bw.write(lastNameWrite + "\n");
                bw.close();
                patientRegister.printAttr();
                JOptionPane.showMessageDialog(registerFrame, "Registration successful!\nYou are now registered");
                registerFrame.dispatchEvent(new WindowEvent(registerFrame, WindowEvent.WINDOW_CLOSING));

            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

}