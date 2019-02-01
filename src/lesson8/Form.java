package lesson8;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

class Form extends JFrame {
    private static final String TITLE = "Musical Instruments";
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;

    private JLabel imgLabelGuitar;
    private JLabel imgLabelDrum;
    private JLabel imgLabelPiano;
    private JPanel imagePanel;

    private static URL imageURLGuitar = Form.class.getResource("guitar.png");
    private static URL imageURLDrum = Form.class.getResource("drum.png");
    private static URL imageURLPiano = Form.class.getResource("piano.png");
    private static URL imageURLDefault = Form.class.getResource("key.png");
    private URL soundURLGuitar = getClass().getResource("guitar.mid");
    private URL soundURLDrum = getClass().getResource("drum.mid");
    private URL soundURLPiano = getClass().getResource("piano.mid");

    private Sound soundGuitar, soundDrum, soundPiano;

    public Form() throws HeadlessException {
        setTitle(TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, WIDTH, HEIGHT);
        setResizable(false);
        Container container = getContentPane();

        soundGuitar = new Sound(soundURLGuitar);
        soundDrum = new Sound(soundURLDrum);
        soundPiano = new Sound(soundURLPiano);

        imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        imgLabelGuitar = new JLabel(new ImageIcon(imageURLGuitar));
        imgLabelDrum = new JLabel(new ImageIcon(imageURLDrum));
        imgLabelPiano = new JLabel(new ImageIcon(imageURLPiano));
        JLabel imgLabelDefault = new JLabel(new ImageIcon(imageURLDefault));
        imagePanel.add(imgLabelDefault);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton guitar = new JButton("Гитара");
        JButton drum = new JButton("Барабан");
        JButton piano = new JButton("Пианино");
        buttonPanel.add(guitar);
        buttonPanel.add(drum);
        buttonPanel.add(piano);

        container.add(buttonPanel, BorderLayout.SOUTH);
        container.add(imagePanel, BorderLayout.PAGE_START);

        guitar.addActionListener(e -> {
            soundDrum.stop();
            soundPiano.stop();
            action(imgLabelGuitar, soundGuitar);
        });
        drum.addActionListener(e -> {
            soundGuitar.stop();
            soundPiano.stop();
            action(imgLabelDrum, soundDrum);
        });
        piano.addActionListener(e -> {
            soundGuitar.stop();
            soundDrum.stop();
            action(imgLabelPiano, soundPiano);
        });
    }

    private void action(JLabel label, Sound s) {
        imagePanel.removeAll();
        imagePanel.add(label);
        repaint();
        revalidate();
        s.stop();
        s.play(false);
    }
}
