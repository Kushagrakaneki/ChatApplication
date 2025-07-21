//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.Socket;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//
//public class Client implements ActionListener {
//    JTextField text;
//    static JPanel p2;
//    static Box vertical = Box.createVerticalBox();//creates a vertical stacker box so that messages appear on top of one another
//
//    static JFrame f=new JFrame();
//    static DataOutputStream dout;
//    Client(){
//        f.setLayout(null);//always set layout to null before adding anything
//
//        JPanel p1=new JPanel();//for adding new frame on main frame
//        p1.setBackground(new Color(7,94,84));// use p1. for referencing and using it
//        p1.setBounds(0,0,450,70);
//        f.add(p1);// adds p1 frame on top of main frame
//        p1.setLayout(null);
//
//        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));//for adding arrow icon on top
//        Image i2=i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);//for scaling
//        ImageIcon i3=new ImageIcon(i2);//i2 needs conversion bcz cannot be written inside Jlabel
//        //JLabel is used for displaying text or images
//        JLabel back= new JLabel(i3);//i3 is new i2
//        back.setBounds(5,20,25,25);
//        p1.add(back);
//
//        back.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.exit(0);//or setVisible(false)
//            }
//        });
//
//
//        //profilepic
//        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));//for adding arrow icon on top
//        Image i5=i4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);//for scaling
//        ImageIcon i6=new ImageIcon(i5);//i2 needs conversion bcz cannot be written inside Jlabel
//        JLabel profile= new JLabel(i6);//i3 is new i2
//        profile.setBounds(40,10,50,50);
//        p1.add(profile);
//
//        //videoicon
//        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));//for adding arrow icon on top
//        Image i8=i7.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);//for scaling
//        ImageIcon i9=new ImageIcon(i8);//i2 needs conversion bcz cannot be written inside Jlabel
//        JLabel vid= new JLabel(i9);//i3 is new i2
//        vid.setBounds(300,20,30,30);
//        p1.add(vid);
//
//
//        //callicon
//        ImageIcon i10= new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));//for adding arrow icon on top
//        Image i11=i10.getImage().getScaledInstance(35,30,Image.SCALE_DEFAULT);//for scaling
//        ImageIcon i12=new ImageIcon(i11);//i2 needs conversion bcz cannot be written inside Jlabel
//        JLabel call= new JLabel(i12);//i3 is new i2
//        call.setBounds(360,20,35,30);
//        p1.add(call);
//
//        //three-dots
//        ImageIcon i13= new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));//for adding arrow icon on top
//        Image i14=i13.getImage().getScaledInstance(10,25,Image.SCALE_DEFAULT);//for scaling
//        ImageIcon i15=new ImageIcon(i14);//i2 needs conversion bcz cannot be written inside Jlabel
//        JLabel morevert= new JLabel(i15);//i3 is new i2
//        morevert.setBounds(410,20,10,25);
//        p1.add(morevert);
//
//        JLabel name=new JLabel("Bunty");//use for adding text
//        name.setBounds(110,18,100,18);
//        name.setForeground(Color.WHITE);//for font color
//        name.setFont(new Font("SAN_SERIF",Font.BOLD,24));//for font style
//        p1.add(name);
//
//        JLabel status=new JLabel("Online");
//        status.setBounds(110,40,100,18);
//        status.setForeground(Color.WHITE);
//        status.setFont(new Font("SAN_SERIF",Font.BOLD,14));
//        p1.add(status);
//
//        p2= new JPanel();//third panel for text part
//        p2.setBounds(5,75,440,560);
//
//        f.add(p2);
//
//        text=new JTextField();//adds text box for writing
//        text.setBounds(5,640,300,50);
//        text.setFont(new Font("SAN_SERIF",Font.PLAIN,22));
//
//
//// --- NEW CODE STARTS HERE ---
//        text.getDocument().addDocumentListener(new DocumentListener() {
//            // This flag helps us prevent an accidental endless loop
//            // because changing the text inside the listener would trigger it again!
//            private boolean isUpdating = false;
//
//            // This method will do the actual capitalization
//            private void autoCapitalize() {
//                if (isUpdating) { // If we are already updating, just stop
//                    return;
//                }
//
//                String currentText = text.getText();
//                if (currentText.length() > 0) { // Check if there's any text
//                    char firstChar = currentText.charAt(0); // Get the very first letter
//
//                    // If the first letter is lowercase...
//                    if (Character.isLowerCase(firstChar)) {
//                        isUpdating = true; // Set flag: "I'm about to change the text!"
//
//                        // We use SwingUtilities.invokeLater to make sure the change happens
//                        // after the current typing event is fully processed.
//                        SwingUtilities.invokeLater(() -> {
//                            // Create a new string with the first letter capitalized
//                            String newText = Character.toUpperCase(firstChar) + currentText.substring(1);
//                            text.setText(newText); // Set the text in the box
//                            isUpdating = false; // Clear flag: "Done updating!"
//                        });
//                    }
//                }
//            }
//
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                // This method is called whenever text is added to the document
//                autoCapitalize();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                // This method is called whenever text is removed from the document
//                // We don't need to capitalize here, but it's part of the interface
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                // This method is for changes to attributes, not for plain text
//                // Not used in a plain JTextField
//            }
//        });
//// --- NEW CODE ENDS HERE ---
//        f.add(text);
//
//        JButton send=new JButton("SEND");
//        send.setBounds(320,640,120,50);
//        send.setBackground(new Color(7,94,84));
//        send.setFont(new Font("SAN_SERIF",Font.BOLD,18));
//        send.setForeground(Color.WHITE);
//        send.setFocusPainted(false);//removes the white outline surrounding send text
//
//        send.addActionListener(this);
//        f.add(send);
//
//
//
//        f.setSize(450,700);
//        f.setUndecorated(true);//removes the topmost header with close button and gives more space
//        f.getContentPane().setBackground(Color.WHITE);//from awt package
//        f.setLocation(800,20);
//        f.setVisible(true);//always write in last
//    }
//
//    @Override//need to write this bec it's an abstract method
//    public void actionPerformed(ActionEvent e) {
//
//        String ext=text.getText();
//
//        //JLabel output= new JLabel(ext);
//        //JPanel p3=new JPanel();//This helps us style and position each message individually.
//        JPanel p3=formatLabel(ext);
//        //p3.setBackground(Color.blue);
//
//        //p3.add(output);
//
//        p2.setLayout(new BorderLayout());//BorderLayout lets you place things at the NORTH, SOUTH, EAST, WEST, or CENTER of a container(p2).
//
//        JPanel right= new JPanel(new BorderLayout());//put messages on right
//        //right.setBackground(Color.DARK_GRAY);
//        right.add(p3,BorderLayout.LINE_END);//put messages on right
//        vertical.add(right);//put messages in vertical axis
//        vertical.add(Box.createVerticalStrut(15));//adds gap between messages
//
//        p2.add(vertical,BorderLayout.PAGE_START);
//
//        text.setText("");
//
//        try {
//            dout.writeUTF(ext);
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//
//        f.repaint();//reloads the frame
//        f.invalidate();
//        f.validate();
//
//
//
//
//    }
//
//    public static JPanel formatLabel(String ext){
//        JPanel panel=new JPanel();
//        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
//
//        //JLabel output= new JLabel(ext);
//        JLabel output= new JLabel("<html><p style=\"width:100px\">"+ext+"</p></html>");
//        output.setFont(new Font("Tahoma",Font.PLAIN,18));
//        output.setBackground(new Color(37,211,102));
//        output.setOpaque(true);
//        output.setBorder(new EmptyBorder(15,15,15,50));//need import
//        output.setForeground(Color.BLACK);
//        panel.add(output);
//
//        Calendar cal=Calendar.getInstance();
//        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
//        JLabel time=new JLabel();
//        time.setText(sdf.format(cal.getTime()));
//        panel.add(time);
//
//
//
//
//        return panel;
//
//
//
//    }
//
//    public static void main(String[] args) {
//        new Client();
//
//        try{
//            Socket s=new Socket("127.0.0.1",6001);
//            DataInputStream din=new DataInputStream(s.getInputStream());
//            dout=new DataOutputStream(s.getOutputStream());
//
//            while(true){
//
//                p2.setLayout(new BorderLayout());
//                String msg=din.readUTF();
//                JPanel panel=formatLabel(msg);
//
//                JPanel left=new JPanel(new BorderLayout());
//                left.add(panel,BorderLayout.LINE_START);
//                vertical.add(left);//you have to make this static and validate static
//
//                vertical.add(Box.createVerticalStrut(15));
//                p2.add(vertical,BorderLayout.PAGE_START);
//
//
//
//
//
//                f.validate();//you will make this static by making JFrame static for that you have to create new JFrame object and remove extend JFrame and use that new object
//            }
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//
//
//
//
//}
