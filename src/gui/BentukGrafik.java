package gui;

import java.awt.*;
import java.awt.event.ItemEvent;
import javax.swing.*;

public class BentukGrafik extends JFrame {
    private PanelGambar panel;
    private JComboBox<String> comboBox;

    public BentukGrafik() {
        setTitle("Visualisasi Bentuk 2D & Simulasi 3D");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Tengah layar
        setLayout(new BorderLayout(10, 10));

        JLabel label = new JLabel("Pilih Bentuk:", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        add(label, BorderLayout.NORTH);

        // ComboBox ganti Choice, tampilkan semua bentuk
        String[] bentuk = {
            "Lingkaran", "Persegi", "Persegi Panjang", "Segitiga",
            "Jajar Genjang", "Trapesium", "Oval", "---",
            "Simulasi Bola", "Simulasi Kubus"
        };

        comboBox = new JComboBox<>(bentuk);
        comboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selected = (String) comboBox.getSelectedItem();
                if (!selected.equals("---")) {
                    panel.setBentuk(selected);
                    panel.repaint();
                }
            }
        });

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(comboBox);
        add(topPanel, BorderLayout.SOUTH);

        panel = new PanelGambar();
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BentukGrafik();
    }
}

class PanelGambar extends JPanel {
    private String bentuk = "Lingkaran";

    public void setBentuk(String bentuk) {
        this.bentuk = bentuk;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        g.setColor(new Color(72, 126, 176)); // biru lembut
        int size = 120;

        switch (bentuk) {
            case "Lingkaran":
                g.fillOval(w / 2 - 60, h / 2 - 60, size, size);
                break;
            case "Persegi":
                g.fillRect(w / 2 - 60, h / 2 - 60, size, size);
                break;
            case "Persegi Panjang":
                g.fillRect(w / 2 - 80, h / 2 - 40, 160, 80);
                break;
            case "Segitiga":
                int[] xSegi = {w / 2, w / 2 - 60, w / 2 + 60};
                int[] ySegi = {h / 2 - 60, h / 2 + 60, h / 2 + 60};
                g.fillPolygon(xSegi, ySegi, 3);
                break;
            case "Jajar Genjang":
                int[] xJJG = {w / 2 - 40, w / 2 + 40, w / 2 + 80, w / 2};
                int[] yJJG = {h / 2 - 40, h / 2 - 40, h / 2 + 40, h / 2 + 40};
                g.fillPolygon(xJJG, yJJG, 4);
                break;
            case "Trapesium":
                int[] xTrap = {w / 2 - 60, w / 2 + 60, w / 2 + 40, w / 2 - 40};
                int[] yTrap = {h / 2 - 40, h / 2 - 40, h / 2 + 40, h / 2 + 40};
                g.fillPolygon(xTrap, yTrap, 4);
                break;
            case "Oval":
                g.fillOval(w / 2 - 80, h / 2 - 50, 160, 100);
                break;

            // Simulasi bentuk 3D
            case "Simulasi Bola":
                g.setColor(new Color(100, 149, 237));
                g.fillOval(w / 2 - 60, h / 2 - 60, size, size);
                g.setColor(new Color(255, 255, 255, 100));
                g.fillOval(w / 2 - 30, h / 2 - 30, 40, 40); // highlight
                break;

            case "Simulasi Kubus":
                int x = w / 2 - 60;
                int y = h / 2 - 60;

                g.setColor(new Color(102, 204, 255));
                g.fillRect(x, y, 100, 100); // depan
                g.setColor(new Color(51, 153, 255));
                g.fillPolygon(new int[]{x, x + 20, x + 120, x + 100}, new int[]{y, y - 20, y - 20, y}, 4); // atas
                g.fillPolygon(new int[]{x + 100, x + 120, x + 120, x + 100}, new int[]{y, y - 20, y + 80, y + 100}, 4); // samping
                break;
        }
    }
}
