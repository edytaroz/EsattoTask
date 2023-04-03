import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public Main() {
        Program program = new Program();
        JFrame frame = new JFrame("Options Page");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));

        JButton button1 = new JButton("Add a Customer");
        JButton button2 = new JButton("Edit Customers List");
        JButton button3 = new JButton("Delete a Customer");
        JButton button4 = new JButton("Show Customers List");

        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);
        button4.setAlignmentX(Component.CENTER_ALIGNMENT);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame,
                        "Please write the name of the customer", null);
                String NIP = JOptionPane.showInputDialog(frame,
                        "Please write the NIP of the customer", null);
                String address = JOptionPane.showInputDialog(frame,
                        "Please write the address of the customer", null);
                long millis=System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                if(name != null && NIP != null && address != null)
                    program.addCustomer(new Customers(name,NIP,date,address));
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] possibilities = {"address", "name"};
                String s = (String)JOptionPane.showInputDialog(
                        frame,
                        "Which property do you want to edit\n",
                        "Customized Dialog",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        possibilities,
                        "address");

                if (s != null) {
                    String NIP = JOptionPane.showInputDialog(frame,
                            "Please write the NIP of the customer you want to edit", null);
                    String value = JOptionPane.showInputDialog(frame,
                            "Please write the edited form", null);
                    if(NIP != null && value != null)
                        program.editCustomer(NIP,s,value,frame);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame,
                        "Please write the NIP of the customer you want to delete", null);
                if(name != null)
                    program.deleteCustomer(name);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                program.listCustomers();
            }
        });

        panel.add(button1);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(button2);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(button3);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(button4);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
