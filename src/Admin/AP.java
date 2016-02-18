package Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class AP extends JFrame {


	private DefaultListModel listModel;

	
	
	private JPanel contentPane;

	public AP() {

		setBounds(100, 100, 448, 487);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("                    All Songs");
		lblNewLabel.setBounds(10, 11, 314, 28);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
			

		
		
		

		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 70, 279, 331);
		contentPane.add(scrollPane);
//		final String[] values = names.toArray(new String[names.size()]);

		

		listModel = new DefaultListModel();

//		for (String a : values) {
//
//			if (a == null) {
//			} else {
//				String str = a.substring(0, a.length() - 4);
//				listModel.addElement(str);
//			}
//
//		}

		final JList list = new JList(listModel);
		scrollPane.setViewportView(list);
		
		setVisible(true);
		setLocationRelativeTo(null);
	

		
	
	
	}
}