package responsi;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class InputBarang extends JFrame {
    public String nama, massa, harga;
    Connector connector = new Connector();
    
    //DEKLARASI KOMPONEN
    JLabel lTitle = new JLabel("Input Barang");

    JLabel lNama = new JLabel("Nama");
    final JTextField tfNama = new JTextField();
    JLabel lMassa = new JLabel("Massa (gr)");
    final JTextField tfMassa = new JTextField();
    JLabel lHarga = new JLabel("Harga Satuan");
    final JTextField tfHarga = new JTextField();

    JButton bSubmit = new JButton("Submit");
    JButton bReset = new JButton("Reset");
    JButton bKembali = new JButton("Kembali");

    public InputBarang() {
        setTitle("Input Barang");
        setSize(400, 300);

        //ADD COMPONENT
        setLayout(null);
        add(lTitle);
        add(lNama);
        add(lMassa);
        add(lHarga);
        add(tfNama);
        add(tfMassa);
        add(tfHarga);
        add(bSubmit);
        add(bReset);
        add(bKembali);

        //LETAK KOMPONEN
        lTitle.setBounds(10, 20, 80, 20);
        lNama.setBounds(10, 45, 80, 20);
        tfNama.setBounds(130, 45, 240, 20);
        lMassa.setBounds(10, 70, 80, 20);
        tfMassa.setBounds(130, 70, 240, 20);
        lHarga.setBounds(10, 95, 80, 20);
        tfHarga.setBounds(130, 95, 240, 20);
        bSubmit.setBounds(70, 155, 145, 30);
        bReset.setBounds(225, 155, 145, 30);
        bKembali.setBounds(10, 200, 360, 30);

        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        
        bSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                   try {
            String query = "INSERT INTO `barang`(`nama`,`massa`,`harga`) VALUES ('"+getNama()+"','"+getMassa()+"','"+getHarga()+"')";
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);

            System.out.println("Insert Berhasil");
            JOptionPane.showMessageDialog(null,"Insert Berhasil !!");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
            }
        });
        
        bReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                tfNama.setText(null);
                tfMassa.setText(null);
                tfHarga.setText(null);
            }
        });
        
        bKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
            }
        });
    }
    
    public String getNama() {
        return tfNama.getText();
    }

    public String getMassa() {
        return tfMassa.getText();
    }

    public String getHarga() {
        return tfHarga.getText();
    }
    
    public void inputDB(){
        
    }
    
}
