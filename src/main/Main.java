package main;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cerdas Cermat");
        frame.setLocationRelativeTo(null);
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(10, 20, 20, 20));

        JLabel titleLabel = new JLabel("Registration Form");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("Nama"));
        JTextField fieldNama = new JTextField();
        inputPanel.add(fieldNama);
        inputPanel.add(new JLabel("NIM"));
        JTextField fieldNim = new JTextField();
        inputPanel.add(fieldNim);
        
        ButtonGroup groupDivisi;
        JRadioButton radioAndroid, radioWeb;
        radioAndroid = new JRadioButton("Android Developer");
        radioWeb = new JRadioButton("Web Developer");
        groupDivisi = new ButtonGroup();
        groupDivisi.add(radioAndroid);
        groupDivisi.add(radioWeb);
        
        JButton applyButton = new JButton("Apply");
        applyButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel scorePanel = new JPanel(new GridLayout(3, 2, 5, 5));
        scorePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        scorePanel.add(new JLabel("Writing Score"));
        JTextField writingScore = new JTextField();
        scorePanel.add(writingScore);

        scorePanel.add(new JLabel("Coding Score"));
        JTextField codingScore = new JTextField();
        scorePanel.add(codingScore);

        scorePanel.add(new JLabel("Interview Score"));
        JTextField interviewScore = new JTextField();
        scorePanel.add(interviewScore);

        JButton outButton = new JButton("Keluar");
        outButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        applyButton.addActionListener(e -> {
            try {
                String nama = fieldNama.getText().trim();
                int Nim = Integer.parseInt(fieldNim.getText());
                String divisi = radioAndroid.isSelected() ? "Android Developer" : radioWeb.isSelected() ? "Web Developer" : "";
                double writing = Double.parseDouble(writingScore.getText());
                double coding = Double.parseDouble(codingScore.getText());
                double interview = Double.parseDouble(interviewScore.getText());

// kok ga kebaca ya rata2 di atas 85 nya? pusing saya
                if(radioAndroid.isSelected()){
                    double w = writing * 0.2;
                    double c = coding * 0.5;
                    double i = interview * 0.3;
                    double rata2 = (w + c + i) / 3;
                    if(rata2 >= 85){
                        JOptionPane.showMessageDialog(frame, "DITERIMA! Selamat " + nama + " " + Nim + ", Anda diterima sebagai Android Developer.");
                    } else{
                        JOptionPane.showMessageDialog(frame, "TIDAK DITERIMA! Maaf " + nama + " " + Nim + ", Anda tidak diterima sebagai Android Developer.");
                    }
                }
                if (radioWeb.isSelected()) {
                    double w = writing * 0.4;
                    double c = coding * 0.35;
                    double i = interview * 0.25;
                    double rata2 = (w + c + i) / 3;
                    if(rata2 >= 85){
                        JOptionPane.showMessageDialog(frame, "DITERIMA! Selamat " + nama + " " + Nim + ", Anda diterima sebagai Web Developer.");
                    } else{
                        JOptionPane.showMessageDialog(frame, "TIDAK DITERIMA! Maaf " + nama + " " + Nim + ", Anda tidak diterima sebagai Web Developer.");
                    }
                }

                if (fieldNama.getText().isEmpty() || fieldNim.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Tolong isi field nama dan Nim", "ERROR!", JOptionPane.ERROR_MESSAGE);
                } if (divisi == "") {
                    JOptionPane.showMessageDialog(frame, "Tolong pilih salah satu divisi", "ERROR!", JOptionPane.ERROR_MESSAGE);
                } if (writingScore.getText().isEmpty() || codingScore.getText().isEmpty() || interviewScore.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Tolong isi semua score", "ERROR!", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Semua Kolom Harus Diisi dengan Benar!");
            }
        });

        outButton.addActionListener(e -> frame.dispose());

        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(radioAndroid);
        mainPanel.add(radioWeb);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(scorePanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(applyButton);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(outButton);
        mainPanel.add(Box.createVerticalStrut(10));

        frame.add(mainPanel);
        frame.setVisible(true);
    }
    
}
