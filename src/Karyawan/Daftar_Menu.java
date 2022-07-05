/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Karyawan;
import Master.Menu_Karyawan;
import com.toedter.calendar.JDateChooser;
import koneksi.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maulana fiqri
 */
public class Daftar_Menu extends javax.swing.JFrame {
    DefaultTableModel table = new DefaultTableModel();
    /**
     * Creates new form Daftar_Menu
     */
    public Daftar_Menu() {
        initComponents();
                koneksi conn = new koneksi();
        koneksi.getKoneksi();
        
        table_barang.setModel(table);
        table.addColumn("Kode Minuman");
        table.addColumn("Nama Minuman");
        table.addColumn("Harga");
        table.addColumn("Stok");
        table.addColumn("Tanggal Masuk");
            
        tampilData();
        
    }
private void tampilData(){
        //untuk mengahapus baris setelah input
        int row = table_barang.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String query = "SELECT * FROM `tb_databarang` ";
        
        try{
            Connection connect = koneksi.getKoneksi();//memanggil koneksi
            Statement sttmnt = connect.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                   
                    String kode = rslt.getString("kode_minuman");
                    String nama = rslt.getString("nama_minuman");
                    String harga = rslt.getString("harga");
                    String stok = rslt.getString("stok");
                    String tanggal = rslt.getString("tanggal");
                    
                //masukan semua data kedalam array
                String[] data = {kode,nama,harga,stok,tanggal};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                table_barang.setModel(table);
            
        }catch(Exception e){
            System.out.println(e);
        }
       
    }
    private void cari(){
        int row = table_barang.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String cari = txt_search.getText();
        
        String query = "SELECT * FROM `tb_databarang` WHERE `kode_minuman`  LIKE '%"+cari+"%' OR `nama_minuman` LIKE '%"+cari+"%' ";
                
       try{
           Connection connect = koneksi.getKoneksi();//memanggil koneksi
           Statement sttmnt = connect.createStatement();//membuat statement
           ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
           
           while (rslt.next()){
                //menampung data sementara
                   
                    String kode = rslt.getString("kode_minuman");
                    String nama = rslt.getString("nama_minuman");
                    String harga = rslt.getString("harga");
                    String stok = rslt.getString("stok");
                    String tanggal = rslt.getString("tanggal");
                    
                //masukan semua data kedalam array
                String[] data = {kode,nama,harga,stok,tanggal};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                table_barang.setModel(table);
           
        
    }catch(Exception e){
           System.out.println(e);
    }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg961 = new backgoundcoding.bg96();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_barang = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_barang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        table_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_barangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_barang);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambarasset/previous1.png"))); // NOI18N
        jButton3.setText("  BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambarasset/reload.png"))); // NOI18N
        jButton5.setText("  REFRESH");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txt_search.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambarasset/find1.png"))); // NOI18N
        jButton7.setText("  CARI");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU MINUMAN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CAFE VEGAN WAY");

        javax.swing.GroupLayout bg961Layout = new javax.swing.GroupLayout(bg961);
        bg961.setLayout(bg961Layout);
        bg961Layout.setHorizontalGroup(
            bg961Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg961Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(bg961Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bg961Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg961Layout.createSequentialGroup()
                        .addGroup(bg961Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg961Layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addGroup(bg961Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5)
                            .addGroup(bg961Layout.createSequentialGroup()
                                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7)))
                        .addGap(55, 55, 55))))
        );
        bg961Layout.setVerticalGroup(
            bg961Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg961Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addGroup(bg961Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(8, 8, 8)
                .addComponent(jButton3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg961, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg961, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void table_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_barangMouseClicked
       // TODO add your handling code here:
        int row = table_barang.getSelectedRow();
        formtransaksi menu = new formtransaksi();
        
        
        String kode = table.getValueAt(row, 0).toString();
        menu.txt_kodebarang2.setText(kode);
        
        String nama = table.getValueAt(row, 1).toString();
        menu.txt_namabarang2.setText(nama);
        
        String harga = table.getValueAt(row, 2).toString();
        menu.txt_harga2.setText(harga);
        
        menu.setVisible(true);
        menu.pack();
        menu.setDefaultCloseOperation(formtransaksi.DISPOSE_ON_CLOSE);
        dispose();
        
        
    }//GEN-LAST:event_table_barangMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new Menu_Karyawan().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //        table_barang.setModel(table);
        tampilData();

        //        dispose();
        //        new stok_barang().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Daftar_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Daftar_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Daftar_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Daftar_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Daftar_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private backgoundcoding.bg96 bg961;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table_barang;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}