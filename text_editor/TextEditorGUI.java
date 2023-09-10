

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextEditorGUI extends JFrame implements ActionListener {

    //Variabel yang dibutuhkan oleh GUI
    public static GridBagLayout layout = new GridBagLayout();
    public static Container container;

    private JTextField text;
    private TextEditor editor;
    private JButton redoButton;
    private JButton undoButton;

    //Anda boleh menambahkan variabel ataupun method lainnya

    public TextEditorGUI() {

        //Dapatkan container panel
        container = getContentPane();
        container.setLayout(layout);

        //Gunakan GridBagConstraint untuk definisi layout
        GridBagConstraints c = new GridBagConstraints();

        int x = 0;
        int y = 0;
        text = new JTextField("");
        text.setEnabled(false);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 7;
        c.gridx = x;
        c.gridy = y;
        container.add(text, c);

        //Add Undo and Redo buttons
        y = 1;
        undoButton = new JButton("Undo");
        undoButton.addActionListener(this);
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = x;
        c.gridy = y;
        container.add(undoButton, c);

        x++;
        redoButton = new JButton("Redo");
        redoButton.addActionListener(this);
        c.weightx = 0.5;
        c.gridx = x;
        c.gridy = y;
        container.add(redoButton, c);

        //Add A to Z
        JButton button;
        x = 0;
        y = 2;
        int NUM_CHAR = 7;
        for (char i = 'A'; i <= 'Z'; i++) {
            button = new JButton(String.valueOf(i));
            button.addActionListener(this);
            c.weightx = 0.5;
            c.gridx = x;
            c.gridy = y;
            container.add(button, c);
            x++;
            if ((x % NUM_CHAR) == 0) {
                x = 0;
                y++;
            }
        }

        //Tambahkan spasi
        button = new JButton("Spasi");
        button.addActionListener(this);
        c.weightx = 0.5;
        c.gridwidth = 2;
        c.gridx = x;
        c.gridy = y;
        container.add(button, c);

        editor = new TextEditor();

    }


    public static void main(String[] args) {
        TextEditorGUI gui = new TextEditorGUI(); //Buat papan permainan
        gui.setSize(700, 300);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      //Selesaikan implementasi koding ini
    }
}
