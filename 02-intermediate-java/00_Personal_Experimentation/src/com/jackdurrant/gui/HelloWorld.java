package com.jackdurrant.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HelloWorld extends JFrame {

	public HelloWorld() {
		super();

		this.setTitle("Hello, World!");
		this.getContentPane().setLayout(null);
		this.setBounds(100, 100, 960, 540);
		this.add(makeButton());
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private JButton makeButton() {
		JButton btn = new JButton();

		btn.setText("DO NOT CLICK");
		btn.setBounds(40, 40, 160, 30);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				JOptionPane.showMessageDialog(null, "Ouch.");
				btn.setText("Ouch.");
			}
		});

		return btn;
	}

	public static void main(String[] args) {
		new HelloWorld();
	}
}
