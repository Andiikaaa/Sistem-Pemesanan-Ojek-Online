/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Bab10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class GUI_RiwayatPesanan extends javax.swing.JFrame {

    /**
     * Creates new form GUI_RiwayatPesanan
     */
    public GUI_RiwayatPesanan() {
        initComponents();
        tampil();
    }
    
    private Connection conn;
    
    public void koneksi() throws SQLException {
    try {
        conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/oop_2318005_ojekonline?serverTimezone=UTC",
            "root",
            ""
        );
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(GUI_RiwayatPesanan.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException e) {
        Logger.getLogger(GUI_RiwayatPesanan.class.getName()).log(Level.SEVERE, null, e);
    } catch (Exception es) {
        Logger.getLogger(GUI_RiwayatPesanan.class.getName()).log(Level.SEVERE, null, es);
    }
}
    
    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("Pelanggan");
        tabelhead.addColumn("ID Transaksi");
        tabelhead.addColumn("Tanggal");
        tabelhead.addColumn("Detail");

        try {
            koneksi();
            String sql = "SELECT nama_pelanggan, id_transaksi, tanggal, detail_perjalanan FROM tb_transaksi";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet res = statement.executeQuery();

            while (res.next()) {
                tabelhead.addRow(new Object[]{
                    res.getString("nama_pelanggan"),
                    res.getString("id_transaksi"),
                    res.getString("tanggal"),
                    res.getString("detail_perjalanan")
                });
            }

            jTable2.setModel(tabelhead);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal terhubung ke database!");
        }
    }

    // Method to insert a new transaction
    public void insert() {
        String namaPelanggan = txtPelanggan.getText();
        String idTransaksi = txtTransaksi.getText();
        String tanggal = txtTanggal.getText();
        String detailPerjalanan = txtDetail.getText();

        try {
        koneksi();
        String sql = "INSERT INTO tb_transaksi(nama_pelanggan, id_transaksi, tanggal, detail_perjalanan) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, namaPelanggan);
        statement.setString(2, idTransaksi);
        statement.setString(3, tanggal);
        statement.setString(4, detailPerjalanan);
        statement.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data transaksi berhasil disimpan!");
        refresh(); // Refresh the table and clear input fields
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data!");
    }
}
    
    public void update() {
    String namaPelanggan = txtPelanggan.getText();
    String idTransaksi = txtTransaksi.getText();
    String tanggal = txtTanggal.getText();
    String detailPerjalanan = txtDetail.getText();

    if (namaPelanggan.isEmpty() || idTransaksi.isEmpty() || tanggal.isEmpty() || detailPerjalanan.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
        return;
    }

    try {
        koneksi();
        String sql = "UPDATE tb_transaksi SET nama_pelanggan=?, tanggal=?, detail_perjalanan=? WHERE id_transaksi=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, namaPelanggan);
        statement.setString(2, tanggal);
        statement.setString(3, detailPerjalanan);
        statement.setString(4, idTransaksi);
        statement.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil diperbarui!");
        refresh(); // Refresh the table and clear input fields
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal memperbarui data: " + e.getMessage());
        e.printStackTrace();
    }
}

    // Method to delete a transaction
    public void delete() {
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String idTransaksi = txtTransaksi.getText(); // ✅ Sudah benar

        try {
            koneksi();
            String sql = "DELETE FROM tb_transaksi WHERE id_transaksi=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, idTransaksi);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data transaksi berhasil dihapus!");
            refresh(); // Refresh tabel dan kosongkan form
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghapus data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

    // Method to clear input fields
    public void batal() {
        txtPelanggan.setText("");
        txtTransaksi.setText("");
        txtTanggal.setText("");
        txtDetail.setText("");
    }

    // Method to refresh the table and clear input fields
    public void refresh() {
        tampil(); // Reload transaction history
        batal(); // Clear input fields
    }

    // Method to handle row selection in the JTable
    public void itempilih() {
    int selectedRow = jTable2.getSelectedRow();
    if (selectedRow >= 0) {
        txtPelanggan.setText(jTable2.getValueAt(selectedRow, 0).toString());
        txtTransaksi.setText(jTable2.getValueAt(selectedRow, 1).toString());
        txtTanggal.setText(jTable2.getValueAt(selectedRow, 2).toString());
        txtDetail.setText(jTable2.getValueAt(selectedRow, 3).toString());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPelanggan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTransaksi = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        txtDetail = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Riwayat Pesanan");

        jLabel2.setText("Nama Pelanggan");

        txtPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPelangganActionPerformed(evt);
            }
        });

        jLabel3.setText("ID Transaksi");

        jLabel4.setText("Tanggal");

        jLabel5.setText("Detail Perjalanan");

        txtDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDetailActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Pelanggan", "ID Transaksi", "Tanggal", "Detail"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(txtTransaksi)
                            .addComponent(jLabel1)
                            .addComponent(txtPelanggan)))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnClose)
                    .addComponent(btnBatal)
                    .addComponent(btnHapus)
                    .addComponent(btnUpdate))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPelangganActionPerformed
        // TODO add your handling code here:
        txtPelanggan.requestFocus(); 
    }//GEN-LAST:event_txtPelangganActionPerformed

    private void txtDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDetailActionPerformed
        // TODO add your handling code here:
        txtDetail.requestFocus();
    }//GEN-LAST:event_txtDetailActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        itempilih(); // Memindahkan data dari tabel ke form
    }
});
    }//GEN-LAST:event_jTable2MouseClicked

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
            java.util.logging.Logger.getLogger(GUI_RiwayatPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_RiwayatPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_RiwayatPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_RiwayatPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_RiwayatPesanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtDetail;
    private javax.swing.JTextField txtPelanggan;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtTransaksi;
    // End of variables declaration//GEN-END:variables
}
