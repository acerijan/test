import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.Scanner;
import java.io.*;

class Patient implements Serializable{
    int patientId;
    String patientName;
    int age;
    int priority;
    Patient next;
    Patient(int a,String b,int c,boolean d){
        patientId=a;
        patientName=b;
        age=c;
        priority=(age<60)?1:2;
        if(d)
        {priority=3;}
    }

}
class QueueLogic{
    Patient start=null,end=null,temp,visit,i,j;
    String calledPatient;
    public void swap(Patient i,Patient j)
    {   int t1;String t2;
        t1=i.patientId;
        i.patientId=j.patientId;
        j.patientId=t1;
        t2=i.patientName;
        i.patientName=j.patientName;
        j.patientName=t2;
        t1=i.age;
        i.age=j.age;
        j.age=t1;
        t1=i.priority;
        i.priority=j.priority;
        j.priority=t1;
        
    }
    public void enqueue(Patient visit){
        visit.next=null;
        if(start==null)
        {
            start=visit;
            end=visit;
        }
        else{
            end.next=visit;
            end=visit;
        }
    }
    public void dequeue(){
        if(start==null)
        {
            calledPatient="empty queue";
        }else
        {
            System.out.println("the queue has been updated");
            calledPatient="patient no "+ start.patientId+" please come forward";
            if(start.next==null)
            {
                start=null;end=null;
            }else{
                start=start.next;
            }
        }
    }
    public void sort()
    {   
        for(i=start;i.next!=null;i=i.next)
        {
            for(j=start;j.next!=null;j=j.next){
                if(j.priority<j.next.priority)
                {
                    swap(j,j.next);
                }
            }
        }
    }
    public void display()
    {
        temp=start;
        if(start==null)
        {
            System.out.println("enpty queue");
        }else{
        System.out.println("the orders of patient are");
        while (temp!=null) {
            System.out.println(temp.patientId);
            System.out.println(temp.patientName);
            System.out.println(temp.age+"\n\n");
            temp=temp.next;
        }
    }
    }
    public void search(int p)
    {int pos=1;
        temp=start;
        if(start==null)
        {
            System.out.println("enpty queue");
        }
        System.out.println("your info is");
        while (temp!=null) {
            if(p==temp.patientId){
            System.out.println(temp.patientId);
            System.out.println(temp.patientName);
            System.out.println(temp.age);
            System.out.println("position is "+pos+"\n");
            }
            pos++;
            temp=temp.next;
        }
    }
}
class FileHandler{
    public void writer(Patient s){
        try{
            FileOutputStream fos=new FileOutputStream("patients.txt");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            while(s!=null){
            Patient temp=s;
            oos.writeObject(temp);
            s=s.next;
            }
            oos.close();
            fos.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void reader(QueueLogic q){
        try{   FileInputStream fis=new FileInputStream("patients.txt");
            ObjectInputStream ois=new ObjectInputStream(fis);
            while(fis.available()>0){
            Patient temp=(Patient)ois.readObject();
            temp.next=null;
            q.enqueue(temp);
            }
            ois.close();
            fis.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
public class HospitalQueueManagementSystem {
    static int count;
    QueueLogic q;
    Patient p;
    FileHandler f;
    private JFrame frame;
    private JPanel panel;
    private JButton staffButton,callButton,viewListButton;
    private JLabel callLabel;
    private JButton patientButton;
    private JButton admissionButton;
    private JButton searchButton;
    private JButton backButton;
    private JTextField id;
    private JTextField name,age;
    private JRadioButton r1,r2;
    private ButtonGroup grp;

     public HospitalQueueManagementSystem() {
        q=new QueueLogic();
        f=new FileHandler();
        //idTracker();
        //f.reader(q);
        frame = new JFrame("Hospital Queue Management System");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener( new WindowAdapter()
        {
        public void windowClosing(WindowEvent e)
        {
            //f.writer(q.start);
            //idSetter();
            System.exit(0);
        }
        });
        

        // Create the main panel
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        //adding two buttons in main panel
        staffButton=new JButton("click if staff");
        patientButton=new JButton("click if patient");
        backButton=new JButton("back");
        panel.add(staffButton);
        panel.add(patientButton);
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
    public static void idTracker()
    {
        try(DataInputStream d=new DataInputStream(new FileInputStream("tracker.txt"));){
                count=d.readInt();
                d.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void idSetter()
    {
        try(DataOutputStream d=new DataOutputStream(new FileOutputStream("tracker.txt"));){
            d.writeInt(count);
            d.close();
    }catch(Exception e){
        e.printStackTrace();
    }
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
                    q.display();
                }
            });
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {   panel.removeAll();
                    panel.add(staffButton);
                    panel.add(patientButton);
                }
            });
            frame.revalidate();
        frame.repaint();

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
                    q.dequeue();
                    callLabel.setText(q.calledPatient);
                }
            });
           viewListButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    callLabel.setText("refer command panel");
                    q.display();
                }
            });
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    panel.removeAll();
                    panel.add(staffButton);
                    panel.add(patientButton);
                    
                }
            });
            frame.revalidate();
        frame.repaint();
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
                int id2=Integer.parseInt(id.getText());
                q.search(id2);
                callLabel.setText("refer command panel for details");
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
        frame.revalidate();
        frame.repaint();
     }
     public void setAdmissionInterface(){
        panel.removeAll();
        name=new JTextField("enter name",20);
        age=new JTextField("enter age",10);
        r1=new JRadioButton("critical");
        r2=new JRadioButton("not critical");
        grp=new ButtonGroup();
        grp.add(r1);
        grp.add(r2);
        panel.add(name);
        panel.add(age);
        panel.add(r1);
        panel.add(r2);
        panel.add(admissionButton);
        panel.add(callLabel);
        panel.add(backButton);
        admissionButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {  
                String s1=name.getText();
                int a1=Integer.parseInt(age.getText());
                count++;
                boolean result=r1.isSelected();
                Patient p=new Patient(count,s1,a1,result);
                q.enqueue(p);
                q.sort();
                callLabel.setText("your id is :"+count);
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
        frame.revalidate();
        frame.repaint();
     }
     public static void main(String[] args)
     {
        new HospitalQueueManagementSystem();
     }
}