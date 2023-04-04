import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;

public class Program {
    HashMap<String, Customers> map;
    public Program(){
        map = new HashMap();
    }
    public void addCustomer(Customers customers){
        map.put(customers.getVATid(), customers);
    }
    public void editCustomer(String VATid, String s, String value, JFrame frame){
        if(!map.containsKey(VATid)){
            JOptionPane.showMessageDialog(frame,
                    "Customer doesn't exist");
        }else {
            if(Objects.equals(s, "address")){
                map.get(VATid).setAddress(value);
            }else{
                map.get(VATid).setName(value);
            }
        }
    }
    public void deleteCustomer(String VATid){
        if(map.containsKey(VATid)) {
            map.remove(VATid);
        }
    }
    public void listCustomers(){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                JFrame frame = new JFrame("List of all customers");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(200,300);
                JPanel panel = new JPanel();
                BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
                panel.setLayout(boxlayout);
                panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
                for(Customers i: map.values()){
                    JLabel label = new JLabel();
                    label.setAlignmentX(Component.CENTER_ALIGNMENT);
                    label.setText("VATid " + i.getVATid() + " address " + i.getAddress() + " name " + i.getName() + " date " + i.getDate() + "\n");
                    panel.add(label);
                    panel.add(Box.createRigidArea(new Dimension(0, 10)));
                }
                frame.getContentPane().add(panel);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
