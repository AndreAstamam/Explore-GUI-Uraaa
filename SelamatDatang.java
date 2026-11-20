import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SelamatDatang extends JFrame {

    private static final String NAMA = "Andre Astamam";
    private static final String NIM = "F1D02410103";

    private static final String KARTU_SelamatDatang = "SelamatDatang";
    private static final String KARTU_HAI = "HAI";

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel panelUtama = new JPanel(cardLayout);

    public SelamatDatang() {
        super("Aplikasi SelamatDatang");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panelUtama.add(buatTampilanSelamatDatang(), KARTU_SelamatDatang);
        panelUtama.add(buatTampilanHalo(), KARTU_HAI);
        add(panelUtama);

        setSize(400, 280);
        setLocationRelativeTo(null);
    }

    private JPanel buatTampilanSelamatDatang() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblSelamatDatang = new JLabel("Selamat Datang", SwingConstants.CENTER);
        lblSelamatDatang.setFont(new Font("SansSerif", Font.BOLD, 36));
        panel.add(lblSelamatDatang, BorderLayout.CENTER);

        JButton btnStart = new JButton("Start");
        btnStart.setFont(new Font("SansSerif", Font.PLAIN, 16));
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelTombol.add(btnStart);
        panel.add(panelTombol, BorderLayout.SOUTH);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelUtama, KARTU_HAI);
            }
        });

        btnStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnStart.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnStart.setBackground(UIManager.getColor("Button.background"));
            }
        });

        return panel;
    }

    private JPanel buatTampilanHalo() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel panelData = new JPanel(new GridLayout(3, 1, 0, 8));
        JLabel lblHalo = new JLabel("HAI", SwingConstants.CENTER);
        lblHalo.setFont(new Font("SansSerif", Font.BOLD, 36));
        JLabel lblNama = new JLabel("Nama : " + NAMA, SwingConstants.CENTER);
        lblNama.setFont(new Font("SansSerif", Font.PLAIN, 18));
        JLabel lblNim = new JLabel("NIM : " + NIM, SwingConstants.CENTER);
        lblNim.setFont(new Font("SansSerif", Font.PLAIN, 18));
        panelData.add(lblHalo);
        panelData.add(lblNama);
        panelData.add(lblNim);
        panel.add(panelData, BorderLayout.CENTER);

        JButton btnKembali = new JButton("Kembali");
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelTombol.add(btnKembali);
        panel.add(panelTombol, BorderLayout.SOUTH);

        btnKembali.addActionListener(e -> cardLayout.show(panelUtama, KARTU_SelamatDatang));

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SelamatDatang().setVisible(true));
    }
}