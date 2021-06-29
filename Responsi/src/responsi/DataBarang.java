package responsi;

import javax.swing.*;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class DataBarang extends JFrame {

    public String nama, massa, harga;
    int jmlData;
    String data[][] = new String[500][4];
    Connector connector = new Connector();
    
    //DEKLARASI KOMPONEN
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID", "Nama", "Massa", "Harga"};

    public DataBarang() {
        setTitle("Data Barang");
        setSize(550, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        try {
            int jmlData = 0;
            String query = "Select * from `barang`";
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            while (resultSet.next()) {
                data[jmlData][0] = resultSet.getString("id");
                data[jmlData][1] = resultSet.getString("nama");
                data[jmlData][2] = resultSet.getString("massa");
                data[jmlData][3] = resultSet.getString("harga");
                jmlData++;
            }
            connector.statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }

        tabel = new JTable(data, namaKolom);
        scrollPane = new JScrollPane(tabel);
        add(scrollPane);

        tabel.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = tabel.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) {
        String selectedData = null;

        int[] selectedRow = tabel.getSelectedRows();
        int[] selectedColumns = tabel.getSelectedColumns();

        for (int i = 0; i < selectedRow.length; i++) {
          for (int j = 0; j < selectedColumns.length; j++) {
            selectedData = (String) tabel.getValueAt(selectedRow[i], selectedColumns[j]);
          }
        }
        
        System.out.println("Selected: " + selectedData);
      }

    });
        
        scrollPane.setBounds(20, 35, 500, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    }
}
