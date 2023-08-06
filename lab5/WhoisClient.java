package lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/*Aarya chaudhary
Roll No : 1*/
public class WhoisClient extends JFrame implements ActionListener {
    private final JTextField domainField;
    private final JTextArea resultArea;

    public WhoisClient() {
        setTitle("WHOIS Client");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel();
        JLabel domainLabel = new JLabel("Enter Domain:");
        domainField = new JTextField(20);
        JButton queryButton = new JButton("Query");
        queryButton.addActionListener(this);

        inputPanel.add(domainLabel);
        inputPanel.add(domainField);
        inputPanel.add(queryButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String domain = domainField.getText().trim();
        if (!domain.isEmpty()) {
            String whoisResult = performWhoisQuery(domain);
            resultArea.setText(whoisResult);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a domain name.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String performWhoisQuery(String domain) {
        StringBuilder result = new StringBuilder();
        try {
            Socket socket = new Socket("whois.internic.net", 43);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(domain);
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line).append("\n");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            result.append("Error occurred during WHOIS query.");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WhoisClient whoisClient = new WhoisClient();
            whoisClient.setVisible(true);
        });
    }
}
