/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Database.Database;
import Models.Session;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controllers.ValidasiMahasiswa;
import Models.Mahasiswa;

/**
 *
 * @author Rizky Alif - 2KS2
 */
public class MahasiswaFrameModify extends javax.swing.JFrame {

    private String id; // Variabel untuk menyimpan ID mahasiswa
    private boolean validasi = true;

    /**
     * Creates new form MahasiswaFrame
     */
    public MahasiswaFrameModify() {
        initComponents();
        setTitle("Edit Data Mahasiswa - Mavia's");
        errorNim.setVisible(false);
        errorNama.setVisible(false);
        errorNoHp.setVisible(false);
        editButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }

    private void clearForm() {
        nimTextField.setText("");
        namaTextField.setText("");
        jeniskelaminComboBox.setSelectedIndex(-1); // Set ke indeks pertama, atau sesuai default yang Anda inginkan
        noHPTextField.setText("");
        tingkatComboBox.setSelectedIndex(-1); // Set ke indeks pertama, atau sesuai default yang Anda inginkan
    }

    // Method untuk menutup koneksi database setelah digunakan
    private void closeDatabaseResources(ResultSet rs, PreparedStatement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metode untuk memuat data ke form
    public void loadData(Mahasiswa mahasiswa) {
        this.id = mahasiswa.getId(); // Simpan ID mahasiswa
        nimTextField.setText(mahasiswa.getNim());
        namaTextField.setText(mahasiswa.getNama());
        jeniskelaminComboBox.setSelectedItem(mahasiswa.getJenisKelamin());
        noHPTextField.setText(mahasiswa.getNoHp());
        tingkatComboBox.setSelectedItem(mahasiswa.getTingkat());
    }

    // Method untuk menampilkan data mahasiswa berdasarkan NIM dari `TabelMahasiswa.java`
    public void setDataFromTable(String id) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM mahasiswa WHERE id = ?");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                this.id = rs.getString("id");
                nimTextField.setText(rs.getString("Nim"));
                namaTextField.setText(rs.getString("Nama"));
                jeniskelaminComboBox.setSelectedItem(rs.getString("JenisKelamin"));
                noHPTextField.setText(rs.getString("NoHp"));
                tingkatComboBox.setSelectedItem(rs.getString("Tingkat"));
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Boolean ValidasiInput() {
        boolean valid = true;

        String nim = nimTextField.getText().trim();
        if (!ValidasiMahasiswa.cekNim(nim)) {
            errorNim.setVisible(true);
            valid = false;
        } else {
            errorNim.setVisible(false);
        }

        if (!ValidasiMahasiswa.cekNama(namaTextField.getText().trim())) {
            errorNama.setVisible(true);
            valid = false;
        } else {
            errorNama.setVisible(false);
        }

        if (!ValidasiMahasiswa.cekNoHP(noHPTextField.getText().trim())) {
            errorNoHp.setVisible(true);
            valid = false;
        } else {
            errorNoHp.setVisible(false);
        }

        return valid;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        Header = new javax.swing.JLabel();
        NIM = new javax.swing.JLabel();
        NAMA = new javax.swing.JLabel();
        NAMA1 = new javax.swing.JLabel();
        NAMA2 = new javax.swing.JLabel();
        NAMA3 = new javax.swing.JLabel();
        noHPTextField = new javax.swing.JTextField();
        nimTextField = new javax.swing.JTextField();
        namaTextField = new javax.swing.JTextField();
        tingkatComboBox = new javax.swing.JComboBox<>();
        jeniskelaminComboBox = new javax.swing.JComboBox<>();
        backButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        errorNoHp = new javax.swing.JLabel();
        errorNim = new javax.swing.JLabel();
        errorNama = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 520));

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(552, 480));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/header1.png"))); // NOI18N
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 80, 70));

        Header.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        Header.setForeground(new java.awt.Color(255, 255, 255));
        Header.setText("PREVIEW DATA MAHASISWA HIMADA MAVIA'S");
        jPanel1.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        NIM.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        NIM.setForeground(new java.awt.Color(255, 255, 255));
        NIM.setText("NIM");
        jPanel1.add(NIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        NAMA.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        NAMA.setForeground(new java.awt.Color(255, 255, 255));
        NAMA.setText("TINGKAT");
        jPanel1.add(NAMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        NAMA1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        NAMA1.setForeground(new java.awt.Color(255, 255, 255));
        NAMA1.setText("NAMA");
        jPanel1.add(NAMA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        NAMA2.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        NAMA2.setForeground(new java.awt.Color(255, 255, 255));
        NAMA2.setText("JENIS KELAMIN");
        jPanel1.add(NAMA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        NAMA3.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        NAMA3.setForeground(new java.awt.Color(255, 255, 255));
        NAMA3.setText("NO HANDPHONE");
        jPanel1.add(NAMA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        noHPTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noHPTextFieldActionPerformed(evt);
            }
        });
        noHPTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                noHPTextFieldKeyReleased(evt);
            }
        });
        jPanel1.add(noHPTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 260, 30));

        nimTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimTextFieldActionPerformed(evt);
            }
        });
        nimTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nimTextFieldKeyReleased(evt);
            }
        });
        jPanel1.add(nimTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 260, 30));

        namaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaTextFieldActionPerformed(evt);
            }
        });
        namaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                namaTextFieldKeyReleased(evt);
            }
        });
        jPanel1.add(namaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 260, 30));

        tingkatComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MAVIA'S 62", "MAVIA'S 63", "MAVIA'S 64", "MAVIA'S 65" }));
        tingkatComboBox.setSelectedIndex(-1);
        tingkatComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tingkatComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(tingkatComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 120, 30));

        jeniskelaminComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));
        jeniskelaminComboBox.setSelectedIndex(-1);
        jeniskelaminComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jeniskelaminComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(jeniskelaminComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 120, 30));

        backButton.setBackground(new java.awt.Color(255, 0, 0));
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, -1, -1));

        editButton.setBackground(new java.awt.Color(255, 153, 51));
        editButton.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        editButton.setForeground(new java.awt.Color(0, 0, 204));
        editButton.setText("EDIT");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        jPanel1.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, -1, -1));

        deleteButton.setBackground(new java.awt.Color(204, 204, 204));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 0, 0));
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, -1, -1));

        searchButton.setBackground(new java.awt.Color(0, 0, 0));
        searchButton.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("SEARCH");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, -1, -1));

        errorNoHp.setBackground(new java.awt.Color(204, 204, 204));
        errorNoHp.setFont(new java.awt.Font("Arial Black", 2, 10)); // NOI18N
        errorNoHp.setForeground(new java.awt.Color(153, 0, 0));
        errorNoHp.setText("Nomor HP harus berupa angka antara 10-15 digit");
        jPanel1.add(errorNoHp, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 280, -1));

        errorNim.setBackground(new java.awt.Color(204, 204, 204));
        errorNim.setFont(new java.awt.Font("Arial Black", 2, 10)); // NOI18N
        errorNim.setForeground(new java.awt.Color(153, 0, 0));
        errorNim.setText("NIM harus berupa angka dan tidak lebih dari 12 digit!");
        jPanel1.add(errorNim, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 300, -1));

        errorNama.setBackground(new java.awt.Color(204, 204, 204));
        errorNama.setFont(new java.awt.Font("Arial Black", 2, 10)); // NOI18N
        errorNama.setForeground(new java.awt.Color(153, 0, 0));
        errorNama.setText("Nama harus berupa huruf!");
        jPanel1.add(errorNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void noHPTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noHPTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noHPTextFieldActionPerformed

    private void nimTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nimTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nimTextFieldActionPerformed

    private void namaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaTextFieldActionPerformed

    private void tingkatComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tingkatComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tingkatComboBoxActionPerformed

    private void jeniskelaminComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jeniskelaminComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jeniskelaminComboBoxActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        clearForm();

        this.dispose();

        TabelMahasiswa main = new TabelMahasiswa();
        main.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        // Validasi input
        if (!ValidasiInput()) {
            JOptionPane.showMessageDialog(this, "Silakan perbaiki kesalahan input terlebih dahulu.");
            return;
        }

        // Ambil nilai dari form
        String nimBaru = nimTextField.getText().trim();
        String nama = namaTextField.getText().trim();
        String jenisKelamin = jeniskelaminComboBox.getSelectedItem().toString();
        String noHp = noHPTextField.getText().trim();
        String tingkat = tingkatComboBox.getSelectedItem().toString();

        // Tampilkan dialog konfirmasi pengeditan
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin mengedit data ini?", "Konfirmasi Edit Data", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Buat koneksi ke database
                Connection conn = Database.getConnection();

                // Buat query untuk memperbarui data berdasarkan id
                String sql = "UPDATE mahasiswa SET Nim = ?, Nama = ?, JenisKelamin = ?, NoHp = ?, Tingkat = ? WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nimBaru);
                stmt.setString(2, nama);
                stmt.setString(3, jenisKelamin);
                stmt.setString(4, noHp);
                stmt.setString(5, tingkat);
                stmt.setString(6, this.id); // Gunakan ID yang disimpan

                // Eksekusi query
                int rowsUpdated = stmt.executeUpdate();

                // Tampilkan pesan berhasil jika data berhasil diperbarui
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Data berhasil diperbarui.");
                    clearForm(); // Bersihkan form setelah pembaruan berhasil
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal memperbarui data. ID tidak ditemukan.");
                }

                // Tutup statement
                stmt.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memperbarui data.");
            }
            finally {
                Database.closeConnection();
            }
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        // Ambil NIM dari nimTextField
        String nim = nimTextField.getText();

        // Validasi NIM tidak boleh kosong
        if (nim.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silakan pilih data yang akan dihapus terlebih dahulu.");
            return;
        }

        // Tampilkan dialog konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus Data", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Buat koneksi ke database
                Connection conn = Database.getConnection();

                // Buat query untuk menghapus data berdasarkan NIM
                String sql = "DELETE FROM mahasiswa WHERE Nim = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nim);

                // Eksekusi query
                int rowsDeleted = stmt.executeUpdate();

                // Tampilkan pesan berhasil jika data berhasil dihapus
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
                    clearForm(); // Bersihkan form setelah penghapusan berhasil
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal menghapus data. NIM tidak ditemukan.");
                }

                // Tutup statement
                stmt.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data.");
            }
            finally{
                Database.closeConnection();
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        // Ambil NIM dari field nimField
        String nim = nimTextField.getText().trim();

        if (nim.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan NIM untuk mencari data");
            return;
        }

        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM mahasiswa WHERE Nim = ?");
            ps.setString(1, nim);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nama = rs.getString("Nama");
                String jenisKelamin = rs.getString("JenisKelamin");
                String noHP = rs.getString("NoHp");
                String tingkat = rs.getString("Tingkat");

                // Set nilai pada form
                namaTextField.setText(nama);
                jeniskelaminComboBox.setSelectedItem(jenisKelamin);
                noHPTextField.setText(noHP);
                tingkatComboBox.setSelectedItem(tingkat);
            } else {
                JOptionPane.showMessageDialog(this, "Data Mahasiswa dengan NIM " + nim + " tidak ditemukan");
            }
            rs.close();
            ps.close();
            Database.closeConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void nimTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nimTextFieldKeyReleased
        // TODO add your handling code here:
        String nim = nimTextField.getText();
        if (!nim.isEmpty() && !ValidasiMahasiswa.cekNim(nim)) {
            errorNim.setVisible(true);
            validasi = false;
        } else {
            errorNim.setVisible(false);
            validasi = true;
        }
    }//GEN-LAST:event_nimTextFieldKeyReleased

    private void namaTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaTextFieldKeyReleased
        // TODO add your handling code here:
        if (ValidasiMahasiswa.cekNama(namaTextField.getText()) == false) {
            errorNama.setVisible(true);
            validasi = false;
        } else {
            errorNama.setVisible(false);
            validasi = true;
        }
    }//GEN-LAST:event_namaTextFieldKeyReleased

    private void noHPTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noHPTextFieldKeyReleased
        // TODO add your handling code here:
        if (ValidasiMahasiswa.cekNoHP(noHPTextField.getText()) == false) {
            errorNoHp.setVisible(true);
            validasi = false;
        } else {
            errorNoHp.setVisible(false);
            validasi = true;
        }
    }//GEN-LAST:event_noHPTextFieldKeyReleased

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
            java.util.logging.Logger.getLogger(MahasiswaFrameModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrameModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrameModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrameModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        if (!Session.isAuthenticated()) {
            JOptionPane.showMessageDialog(null, "Harap Login Terlebih Dahulu.");
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Login().setVisible(true);
                }
            });
        } else {
            // Jika sudah terautentikasi, lanjutkan ke main menu atau halaman lain
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new MainMenu().setVisible(true);
                }
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Header;
    private javax.swing.JLabel NAMA;
    private javax.swing.JLabel NAMA1;
    private javax.swing.JLabel NAMA2;
    private javax.swing.JLabel NAMA3;
    private javax.swing.JLabel NIM;
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel errorNama;
    private javax.swing.JLabel errorNim;
    private javax.swing.JLabel errorNoHp;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JComboBox<String> jeniskelaminComboBox;
    private javax.swing.JLabel logo;
    public javax.swing.JTextField namaTextField;
    public javax.swing.JTextField nimTextField;
    public javax.swing.JTextField noHPTextField;
    private javax.swing.JButton searchButton;
    public javax.swing.JComboBox<String> tingkatComboBox;
    // End of variables declaration//GEN-END:variables
}
