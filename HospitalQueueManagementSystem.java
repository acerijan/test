import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HospitalQueueManagementSystem {
    private JFrame frame;
    private JPanel panel;
    private JButton staffButton;
    private JButton patientButton;
    private JButton admissionButton;
    private JButton searchButton;
    private JButton deleteButton;
    private JButton viewListButton;
    private JButton removeButton;
    private JTextField idField;
    private JPasswordField passwordField;
    private JTextField patientNameField;
    private JTextField patientAddressField;
    private JTextField patientNameSearchField;

     public HospitalQueueManagementSystem() {
        frame = new JFrame("Hospital Queue Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the background panel with the image
        BackgroundPanel backgroundPanel = new BackgroundPanel("chill.jpg");

        // Create the button panel
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        staffButton = new JButton("Staff");
        staffButton.addActionListener(new StaffButtonListener());
        panel.add(staffButton);

        patientButton = new JButton("Patient");
        patientButton.addActionListener(new PatientButtonListener());
        panel.add(patientButton);

        // Add the button panel to the main panel
        mainPanel.add(panel, BorderLayout.NORTH);

        // Add the background panel to the main panel
        mainPanel.add(backgroundPanel, BorderLayout.CENTER);

        // Add the main panel to the frame
        frame.add(mainPanel);

        frame.pack();
        frame.setVisible(true);
    }
    
    
    ///////--------------------------STAFF button

    private class StaffButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(new AuthenticatePanel());
            frame.revalidate();
            frame.repaint();
        }
    }
    ///////--------------------------patient button
    private class PatientButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(new PatientOptionsPanel());
            frame.revalidate();
            frame.repaint();
        }
    }

    //-----------------------------------STAFF AUTHI
    private class AuthenticatePanel extends JPanel {
        private AuthenticatePanel() {
            setLayout(new FlowLayout());

            JLabel idLabel = new JLabel("ID:");
            add(idLabel);

            idField = new JTextField(10);
            add(idField);

            JLabel passwordLabel = new JLabel("Password:");
            add(passwordLabel);

            passwordField = new JPasswordField(10);
            add(passwordField);

            JButton authenticateButton = new JButton("Authenticate");
            authenticateButton.addActionListener(new AuthenticateButtonListener());
            add(authenticateButton);
        }

        private class AuthenticateButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = new String(passwordField.getPassword());

                // Authenticate the staff
                if (authenticateStaff(id, password)) {
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(new StaffOptionsPanel());
                    frame.revalidate();
                    frame.repaint();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid ID or Password");
                }
            }
        }
         private class BackButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(panel);
                frame.revalidate();
                frame.repaint();
            }
        }

        private boolean authenticateStaff(String id, String password) {
            // Implement staff authentication logic here
            return true;
        }
    }
    //-------------------staff authi panel end
    
    
    //--------------------- patient panel listener

    private class PatientOptionsPanel extends JPanel {
        private PatientOptionsPanel() {
            setLayout(new FlowLayout());

            admissionButton = new JButton("Admission");
            admissionButton.addActionListener(new AdmissionButtonListener());
            add(admissionButton);

            searchButton = new JButton("Search");
            searchButton.addActionListener(new SearchButtonListener());
            add(searchButton);

            deleteButton = new JButton("Delete");
            deleteButton.addActionListener(new DeleteButtonListener());
            add(deleteButton);
        }

        private class AdmissionButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new AdmissionPanel());
                frame.revalidate();
                frame.repaint();
            }
        }

        private class SearchButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new SearchPanel());
                frame.revalidate();
                frame.repaint();
            }
        }

        private class DeleteButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new DeletePanel());
                frame.revalidate();
                frame.repaint();
            }
        }
    }

//-----------------------------pation optin end
//-----------------------------staff options listeneres
    private class StaffOptionsPanel extends JPanel {
        private StaffOptionsPanel() {
            setLayout(new FlowLayout());

            viewListButton = new JButton("View List");
            viewListButton.addActionListener(new ViewListButtonListener());
            add(viewListButton);

            removeButton = new JButton("Remove");
            removeButton.addActionListener(new RemoveButtonListener());
            add(removeButton);
        }

        private class ViewListButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement view list logic here
            }
        }

        private class RemoveButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement remove logic here
            }
        }
    }
    
    //----------------------staf f listenes end
    
    //----------------------patient panel actual

    private class AdmissionPanel extends JPanel {
        private AdmissionPanel() {
            setLayout(new FlowLayout());

            JLabel patientNameLabel = new JLabel("Patient Name:");
            add(patientNameLabel);

            patientNameField = new JTextField(20);
            add(patientNameField);

            JLabel patientAddressLabel = new JLabel("Patient Address:");
            add(patientAddressLabel);

            patientAddressField = new JTextField(20);
            add(patientAddressField);

            JButton admitButton = new JButton("Admit");
            admitButton.addActionListener(new AdmitButtonListener());
            add(admitButton);
        }

        private class AdmitButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientName = patientNameField.getText();
                String patientAddress = patientAddressField.getText();

                // Implement admission logic here
            }
        }
    }

    private class SearchPanel extends JPanel {
        private SearchPanel() {
            setLayout(new FlowLayout());

            JLabel patientNameLabel = new JLabel("Patient Name:");
            add(patientNameLabel);

            patientNameSearchField = new JTextField(20);
            add(patientNameSearchField);

            JButton searchButton = new JButton("Search");
            searchButton.addActionListener(new SearchButtonListener());
            add(searchButton);
        }

        private class SearchButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientName = patientNameSearchField.getText();

                // Implement search logic here
            }
        }
    }

    private class DeletePanel extends JPanel {
        private DeletePanel() {
            setLayout(new FlowLayout());

            JLabel patientNameLabel = new JLabel("Patient Name:");
            add(patientNameLabel);

            patientNameSearchField = new JTextField(20);
            add(patientNameSearchField);

            JButton deleteButton = new JButton("Delete");
            deleteButton.addActionListener(new DeleteButtonListener());
            add(deleteButton);
        }

        private class DeleteButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientName = patientNameSearchField.getText();

                // Implement deletion logic here
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HospitalQueueManagementSystem();
            }
        });
    }
}

