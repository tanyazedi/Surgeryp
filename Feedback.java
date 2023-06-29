import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Feedback extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField nameOfUser;
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JCheckBox check;
    private JComboBox<String> ageBox;
    private JTextField emailOfUser;
    private JLabel descLabel;
    private JTextField putFeed;
    private JButton submitButton;
    private JButton resetButton;
    private JPanel mainPanel;
    private JRadioButton one;
    private JRadioButton two;
    private JRadioButton four;
    private JRadioButton three;
    private JRadioButton five;
    private JLabel ageLabel;
    private JLabel ratingLabel;

    private ButtonGroup rateButton;

    public Feedback() {
        setTitle("FEEDBACK SURVEY");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(700, 600);
        setLayout(null);

        ImageIcon icon = new ImageIcon("icon.png");
        setIconImage(icon.getImage());

        label = new JLabel();
        label.setText("FEEDBACK SURVEY");
        label.setFont(new Font("Arial", Font.BOLD, 36));
        label.setBounds(80, 0, 440, 45);
        add(label);

        nameLabel = new JLabel();
        nameLabel.setText("NAME OF USER");
        nameLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
        nameLabel.setBounds(50, 60, 120, 28);
        add(nameLabel);

        nameOfUser = new JTextField();
        nameOfUser.setFont(new Font("Calibri", Font.PLAIN, 16));
        nameOfUser.setBounds(230, 60, 240, 28);
        add(nameOfUser);

        emailLabel = new JLabel();
        emailLabel.setText("EMAIL");
        emailLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
        emailLabel.setBounds(50, 110, 150, 28);
        add(emailLabel);

        emailOfUser = new JTextField();
        emailOfUser.setFont(new Font("Calibri", Font.PLAIN, 16));
        emailOfUser.setBounds(230, 105, 240, 28);
        add(emailOfUser);

        check = new JCheckBox("Receive Promotional Email");
        check.setFont(new Font("Calibri", Font.PLAIN, 15));
        check.setBounds(230, 135, 240, 20);
        check.setSelected(true);
        add(check);

        ageLabel = new JLabel();
        ageLabel.setText("AGE GROUP");
        ageLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
        ageLabel.setBounds(50, 180, 150, 28);
        add(ageLabel);

        String[] ages = {"Below 18", "18-25", "25-30", "30-40", "40+"};
        ageBox = new JComboBox<>(ages);
        ageBox.setBounds(230, 180, 120, 28);
        add(ageBox);

        ratingLabel = new JLabel();
        ratingLabel.setText("RATING");
        ratingLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
        ratingLabel.setBounds(50, 230, 100, 28);
        add(ratingLabel);

        one = new JRadioButton("1");
        two = new JRadioButton("2");
        three = new JRadioButton("3");
        four = new JRadioButton("4");
        five = new JRadioButton("5");

        one.setBounds(230, 230, 40, 28);
        two.setBounds(280, 230, 40, 28);
        three.setBounds(330, 230, 40, 28);
        four.setBounds(380, 230, 40, 28);
        five.setBounds(430, 230, 40, 28);
        five.setSelected(true);

        rateButton = new ButtonGroup();
        rateButton.add(one);
        rateButton.add(two);
        rateButton.add(three);
        rateButton.add(four);
        rateButton.add(five);

        descLabel = new JLabel();
        descLabel.setText("DESCRIPTION (optional)");
        descLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
        descLabel.setBounds(50, 280, 200, 28);
        add(descLabel);

        putFeed = new JTextField();
        putFeed.setFont(new Font("Calibri", Font.PLAIN, 16));
        putFeed.setBounds(230, 280, 240, 84);
        add(putFeed);

        submitButton = new JButton("SUBMIT");
        submitButton.setFont(new Font("Calibri", Font.PLAIN, 18));
        submitButton.setBounds(165, 410, 100, 28);
        add(submitButton);

        resetButton = new JButton("RESET");
        resetButton.setFont(new Font("Calibri", Font.PLAIN, 18));
        resetButton.setBounds(275, 410, 100, 28);
        add(resetButton);

        submitButton.addActionListener(this);
        resetButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        boolean flag = false;
        String emailValidation = "^[a-zA-Z0-9+_.-]+@(.+)$";
        Pattern p = Pattern.compile(emailValidation);
        Matcher mat = p.matcher(emailOfUser.getText());

        if (e.getSource() == submitButton) {
            if (nameOfUser.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name cannot be empty");
            } else if (emailOfUser.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Email cannot be empty");
            } else if (!mat.matches()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid Email");
            } else {
                flag = true;
            }

            if (flag) {
                String r;
                if (one.isSelected())
                    r = "One star";
                else if (two.isSelected())
                    r = "Two stars";
                else if (three.isSelected())
                    r = "Three stars";
                else if (four.isSelected())
                    r = "Four stars";
                else
                    r = "Five stars";
                String s1 = "Thank you for your valuable Feedback!\n\nYour Responses:-\n";
                String s2 = "Name: " + nameOfUser.getText() + "\nEmail: " + emailOfUser.getText() + "\nAge group: "
                        + ageBox.getSelectedItem() + "\nRating: " + r + "\nFeedback: " + putFeed.getText();
                String disp = s1 + s2;
                JOptionPane.showMessageDialog(this, disp);
            }
        } else if (e.getSource() == resetButton) {
            nameOfUser.setText(null);
            emailOfUser.setText(null);
            putFeed.setText(null);
            ageBox.setSelectedIndex(0);
            one.setSelected(false);
            two.setSelected(false);
            three.setSelected(false);
            four.setSelected(false);
            five.setSelected(true);
        }
    }

    public static void main(String[] args) {
        Feedback cf = new Feedback();
    }
}