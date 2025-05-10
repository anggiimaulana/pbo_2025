package gui;

import java.awt.*;
import javax.swing.*;

public class MenuMakanan extends JFrame {
    private JComboBox<String> menuCombo;
    private JTextField jumlahField;
    private JButton hitungButton, hapusButton;
    private JLabel totalLabel;

    private final String[] makanan = {"Nasi Goreng", "Mie Ayam", "Sate Ayam"};
    private final int[] harga = {15000, 12000, 20000};

    public MenuMakanan() {
        setTitle("Aplikasi Menu Makanan");
        setSize(440, 280);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Tengah layar
        setLayout(new BorderLayout(10, 10));

        // Judul
        JLabel titleLabel = new JLabel("Daftar Menu Makanan", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        // Panel form
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        formPanel.add(new JLabel("Pilih Menu:"));
        String[] menuDenganHarga = new String[makanan.length];
        for (int i = 0; i < makanan.length; i++) {
            menuDenganHarga[i] = makanan[i] + " - Rp " + harga[i];
        }
        menuCombo = new JComboBox<>(menuDenganHarga);
        formPanel.add(menuCombo);

        formPanel.add(new JLabel("Jumlah Pesanan:"));
        jumlahField = new JTextField();
        formPanel.add(jumlahField);

        add(formPanel, BorderLayout.CENTER);

        // Panel bawah (tombol dan total)
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        hitungButton = new JButton("Hitung Total");
        hapusButton = new JButton("Hapus");
        buttonPanel.add(hitungButton);
        buttonPanel.add(hapusButton);

        totalLabel = new JLabel("Total: Rp 0", SwingConstants.CENTER);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 14));

        bottomPanel.add(buttonPanel, BorderLayout.NORTH);
        bottomPanel.add(totalLabel, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        // Listener tombol Hitung
        hitungButton.addActionListener(e -> {
            String input = jumlahField.getText().trim();
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Masukkan jumlah pesanan!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                int index = menuCombo.getSelectedIndex();
                int jumlah = Integer.parseInt(input);
                if (jumlah <= 0) throw new NumberFormatException();
                int total = harga[index] * jumlah;
                totalLabel.setText("Total: Rp " + total);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Jumlah harus angka positif!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Listener tombol Hapus
        hapusButton.addActionListener(e -> {
            jumlahField.setText("");
            totalLabel.setText("Total: Rp 0");
            menuCombo.setSelectedIndex(0);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuMakanan();
    }
}
