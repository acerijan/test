import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HospitalQueueManagementSystem {
    private JFrame frame;
    private JPanel panel;
    private JButton staffButton,callButton,viewListButton;
    private JLabel callLabel,demolbl;
    private JButton patientButton;
    private JButton admissionButton;
    private JButton searchButton;
    private JButton backButton;
    private JTextField id;
    private JTextField name,age;
    

     public HospitalQueueManagementSystem() {
        frame = new JFrame("Hospital Queue Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        //adding two buttons in main panel
        staffButton=new JButton("click if staff");
        patientButton=new JButton("click if patient");
        backButton=new JButton("back");
        panel.add(staffButton);
        panel.add(patientButton);
        demolbl=new JLabel("res");
        staffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setStaffInterface();
            }
        });
        patientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setPatientInterface();
            }
        });

        frame.add(panel);
        frame.setSize(400,400);
        frame.setVisible(true);

     }
     public void setPatientInterface(){
            panel.removeAll();
            admissionButton=new JButton("admission");
            searchButton =new JButton("search via id");
            viewListButton =new JButton("view entire list");
            callLabel=new JLabel("result of action");
            panel.add(admissionButton);
            panel.add(searchButton);
            panel.add(viewListButton);
            panel.add(callLabel);
            panel.add(backButton);
            admissionButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {  
                    setAdmissionInterface();
                }
            });
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {  
                    setSearchInterface();
                }
            });
           viewListButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    callLabel.setText("refer command panel");
                }
            });
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {   panel.removeAll();
                    panel.add(staffButton);
                    panel.add(patientButton);
                    panel.add(demolbl);
                }
            });


     }
     public void setStaffInterface(){
        panel.removeAll();
            callButton =new JButton("call patient");
            viewListButton =new JButton("view entire list");
            callLabel=new JLabel("result of action");
            panel.add(callButton);
            panel.add(viewListButton);
            panel.add(callLabel);
            panel.add(backButton);
            callButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {  //all details pending
                    callLabel.setText("patient is called");
                }
            });
           viewListButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    callLabel.setText("refer command panel");
                }
            });
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    panel.removeAll();
                    panel.add(staffButton);
                    panel.add(patientButton);
                    panel.add(demolbl);
                    
                    
                }
            });
     }
     public void setSearchInterface(){
        panel.removeAll();
        id=new JTextField(20);
        panel.add(id);
        panel.add(searchButton);
        panel.add(callLabel);
        panel.add(backButton);
        
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {  
                callLabel.setText(id.getText());
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {  
                panel.removeAll();
                setPatientInterface();
            }
        });
     }
     public void setAdmissionInterface(){
        panel.removeAll();
        name=new JTextField("enter name",20);
        age=new JTextField("enter age",10);
        panel.add(name);
        panel.add(age);
        panel.add(admissionButton);
        panel.add(callLabel);
        panel.add(backButton);
        admissionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {  
                callLabel.setText("your id is this");
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {  
                panel.removeAll();
                setPatientInterface();
            }
        });

     }
     public static void main(String[] args)
     {
        HospitalQueueManagementSystem h=new HospitalQueueManagementSystem();
     }
}