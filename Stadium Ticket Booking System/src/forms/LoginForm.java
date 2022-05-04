package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import database.DBMan;

import javax.swing.UIManager;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JLabel main_img;
	private JLabel username_not_found_label;
	private JLabel password_error_label;
	private JButton newAccountButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/vendor/login_title_img.png")));
		setTitle("Login | Stadium Ticket Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcomeLabel = new JLabel("STMS Login");
		welcomeLabel.setFont(new Font("Consolas", Font.BOLD, 24));
		welcomeLabel.setBounds(10, 11, 139, 38);
		contentPane.add(welcomeLabel);
		
		JLabel loginUsernameLebel = new JLabel("Username");
		loginUsernameLebel.setFont(new Font("Consolas", Font.BOLD, 14));
		loginUsernameLebel.setBounds(63, 54, 84, 14);
		contentPane.add(loginUsernameLebel);
		
		username = new JTextField();
		username.setBorder(new LineBorder(new Color(105, 105, 105), 2, true));
		username.setFont(new Font("Consolas", Font.PLAIN, 13));
		username.setBounds(63, 75, 221, 25);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel loginPasswordLabel = new JLabel("Password");
		loginPasswordLabel.setFont(new Font("Consolas", Font.BOLD, 14));
		loginPasswordLabel.setBounds(63, 106, 84, 14);
		contentPane.add(loginPasswordLabel);
		
		password = new JPasswordField();
		password.setBorder(new LineBorder(new Color(105, 105, 105), 2, true));
		password.setBounds(63, 126, 221, 25);
		contentPane.add(password);
		
		JButton loginButton = new JButton("");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet resultSet = null;
				String username_ = username.getText();
				String password_ = new String(password.getPassword());
				try {
					resultSet = DBMan.stmt.executeQuery("SELECT * FROM user__ WHERE username = '" + username_ + "'");
					if(resultSet.next() == false) {
						username_not_found_label.setVisible(true);
					}
					else {
						username_not_found_label.setVisible(false);
						resultSet.first();
						if(!resultSet.getString(2).equals(password_)){
							password_error_label.setVisible(true);
						}
						else {
							// verification successful
							JOptionPane.showMessageDialog(getContentPane(), "Logged in");
						}
					}
				} catch (SQLException e1) {
					System.out.println("Failed to check username and password. DATABASE ERROR 101");
					e1.printStackTrace();
				}
			}
		});
		loginButton.setBackground(new Color(102, 204, 102));
		loginButton.setBorder(new LineBorder(new Color(0, 153, 0), 2, true));
		loginButton.setIcon(new ImageIcon(LoginForm.class.getResource("/vendor/login_.png")));
		loginButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		loginButton.setFocusPainted(false);
		loginButton.setBounds(63, 162, 64, 25);
		contentPane.add(loginButton);
		
		main_img = new JLabel("");
		main_img.setIcon(new ImageIcon(LoginForm.class.getResource("/vendor/login_title_img.png")));
		main_img.setBounds(313, 75, 70, 76);
		contentPane.add(main_img);
		
		username_not_found_label = new JLabel("username not found");
		username_not_found_label.setVisible(false);
		username_not_found_label.setForeground(Color.RED);
		username_not_found_label.setFont(new Font("Consolas", Font.ITALIC, 10));
		username_not_found_label.setBounds(176, 54, 108, 14);
		contentPane.add(username_not_found_label);
		
		password_error_label = new JLabel("Wrong password");
		password_error_label.setVisible(false);
		password_error_label.setForeground(Color.RED);
		password_error_label.setFont(new Font("Consolas", Font.ITALIC, 10));
		password_error_label.setBounds(191, 106, 93, 14);
		contentPane.add(password_error_label);
		
		newAccountButton = new JButton("New! need an account?");
		newAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SignUpForm.main(null);
			}
		});
		newAccountButton.setForeground(UIManager.getColor("Button.foreground"));
		newAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newAccountButton.setContentAreaFilled(false);
		newAccountButton.setBorderPainted(false);
		newAccountButton.setFocusPainted(false);
		newAccountButton.setFont(new Font("Consolas", Font.ITALIC, 11));
		newAccountButton.setBounds(134, 172, 161, 14);
		contentPane.add(newAccountButton);
	}
}
