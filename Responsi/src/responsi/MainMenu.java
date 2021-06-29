package responsi;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class MainMenu extends JFrame{
    JLabel lHead = new JLabel("MAIN MENU");
    JButton bTambah = new JButton("Tambah Barang");
    JButton bLihat = new JButton("Lihat Barang");
    
    public MainMenu() {
        setSize(250,250);
        setLayout(null);
        add(lHead);
        add(bTambah);
        add(bLihat);
        
        lHead.setBounds(85, 20, 85, 20);
        bTambah.setBounds(45, 45, 150, 35);
        bLihat.setBounds(45, 75, 150, 35);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        bTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                InputBarang input = new InputBarang();
            }
        });
        
        bLihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                DataBarang input = new DataBarang();
            }
        });
    }
    
}
