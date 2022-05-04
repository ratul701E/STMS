package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import database.DBMan;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SignUpForm extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField mobile;
	private JTextField email;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpForm frame = new SignUpForm();
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
	public SignUpForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUpForm.class.getResource("/vendor/sign_up_title_img.png")));
		setResizable(false);
		setTitle("Sign Up | Stadium Ticket Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Welcome to STMS");
		welcomeLabel.setFont(new Font("Consolas", Font.BOLD, 24));
		welcomeLabel.setBounds(188, 11, 205, 67);
		contentPane.add(welcomeLabel);
		
		JLabel welcome_img = new JLabel("");
		welcome_img.setIcon(new ImageIcon(SignUpForm.class.getResource("/vendor/sign_up_title_img.png")));
		welcome_img.setBounds(253, 67, 59, 53);
		contentPane.add(welcome_img);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(new Font("Consolas", Font.BOLD, 13));
		firstNameLabel.setBounds(50, 170, 82, 14);
		contentPane.add(firstNameLabel);
		
		firstName = new JTextField();
		firstName.setBorder(new LineBorder(new Color(221, 229, 230), 2, true));
		firstName.setFont(new Font("Consolas", Font.PLAIN, 13));
		firstName.setBounds(50, 195, 162, 20);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(new Font("Consolas", Font.BOLD, 13));
		lastNameLabel.setBounds(50, 226, 82, 14);
		contentPane.add(lastNameLabel);
		
		JLabel mobileLabel = new JLabel("Mobile");
		mobileLabel.setFont(new Font("Consolas", Font.BOLD, 13));
		mobileLabel.setBounds(50, 282, 82, 14);
		contentPane.add(mobileLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Consolas", Font.BOLD, 13));
		emailLabel.setBounds(319, 170, 82, 14);
		contentPane.add(emailLabel);
		
		lastName = new JTextField();
		lastName.setFont(new Font("Consolas", Font.PLAIN, 13));
		lastName.setColumns(10);
		lastName.setBorder(new LineBorder(new Color(221, 229, 230), 2, true));
		lastName.setBounds(50, 251, 162, 20);
		contentPane.add(lastName);
		
		mobile = new JTextField();
		mobile.setFont(new Font("Consolas", Font.PLAIN, 13));
		mobile.setColumns(10);
		mobile.setBorder(new LineBorder(new Color(221, 229, 230), 2, true));
		mobile.setBounds(50, 304, 162, 20);
		contentPane.add(mobile);
		
		email = new JTextField();
		email.setFont(new Font("Consolas", Font.PLAIN, 13));
		email.setColumns(10);
		email.setBorder(new LineBorder(new Color(221, 229, 230), 2, true));
		email.setBounds(319, 193, 162, 20);
		contentPane.add(email);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Consolas", Font.BOLD, 13));
		usernameLabel.setBounds(319, 224, 82, 14);
		contentPane.add(usernameLabel);
		
		username = new JTextField();
		username.setFont(new Font("Consolas", Font.PLAIN, 13));
		username.setColumns(10);
		username.setBorder(new LineBorder(new Color(221, 229, 230), 2, true));
		username.setBounds(319, 249, 162, 20);
		contentPane.add(username);
		
		JLabel usernameExistErrorLabel = new JLabel("Username taken");
		usernameExistErrorLabel.setVisible(false);
		usernameExistErrorLabel.setToolTipText("");
		usernameExistErrorLabel.setForeground(Color.RED);
		usernameExistErrorLabel.setFont(new Font("Consolas", Font.ITALIC, 10));
		usernameExistErrorLabel.setBounds(396, 237, 96, 14);
		contentPane.add(usernameExistErrorLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Consolas", Font.BOLD, 13));
		passwordLabel.setBounds(319, 280, 82, 14);
		contentPane.add(passwordLabel);
		
		password = new JPasswordField();
		password.setFont(new Font("Consolas", Font.PLAIN, 13));
		password.setColumns(10);
		password.setBorder(new LineBorder(new Color(221, 229, 230), 2, true));
		password.setBounds(319, 302, 162, 20);
		contentPane.add(password);
		
		JLabel passReq = new JLabel("Password requarements not met!");
		passReq.setVisible(false);
		passReq.setForeground(new Color(255, 0, 0));
		passReq.setFont(new Font("Consolas", Font.ITALIC, 10));
		passReq.setBounds(319, 333, 205, 14);
		contentPane.add(passReq);
		
		JButton check = new JButton("Check");
		check.setHorizontalTextPosition(SwingConstants.CENTER);
		check.setForeground(new Color(0, 0, 0));
		check.setBackground(new Color(153, 153, 204));
		check.setFocusPainted(false);
		check.setBorder(new LineBorder(new Color(153, 153, 255), 2, true));
		check.setFont(new Font("Consolas", Font.BOLD, 14));
		check.setBounds(175, 352, 89, 29);
		contentPane.add(check);
		
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username_, password_, firstName_, lastName_, mobile_, email_;
				username_ = username.getText();
				password_ = new String(password.getPassword());
				firstName_ = firstName.getText();
				lastName_ = lastName.getText();
				mobile_ = mobile.getText();
				email_ = email.getText();
				
				boolean check__ = true;
				
				if(username_.isEmpty()) {
					username.setBorder(new LineBorder(Color.red, 2, true));
					check__ = false;
				}
				else username.setBorder(new LineBorder(new Color(221, 229, 230), 2, true));
				
				if(password_.isEmpty()) {
					password.setBorder(new LineBorder(Color.red, 2, true));
					check__ = false;
				}
				else password.setBorder(new LineBorder(new Color(221, 229, 230), 2, true));
					
				if(firstName_.isEmpty()) {
					firstName.setBorder(new LineBorder(Color.red, 2, true));
					check__ = false;
				}
				else firstName.setBorder(new LineBorder(new Color(221, 229, 230), 2, true));
					
				if(lastName_.isEmpty()) {
					lastName.setBorder(new LineBorder(Color.red, 2, true));
					check__ = false;
				}
				else lastName.setBorder(new LineBorder(new Color(221, 229, 230), 2, true));
				
				if(email_.isEmpty()) {
					email.setBorder(new LineBorder(Color.red, 2, true));
					check__ = false;
				}
				else email.setBorder(new LineBorder(new Color(221, 229, 230), 2, true));
				
				if(mobile_.isEmpty()) {
					mobile.setBorder(new LineBorder(Color.red, 2, true));
					check__ = false;
				}
				else mobile.setBorder(new LineBorder(new Color(221, 229, 230), 2, true));
				
				if(!check__) return;
				
				try {
					ResultSet resultSet = DBMan.stmt.executeQuery("SELECT * FROM user__ WHERE username = '" + username_ + "'");;
					if(resultSet.next()) {
						username.setBorder(new LineBorder(Color.red, 2, true));
						usernameExistErrorLabel.setVisible(true);
						return;
					}
					else usernameExistErrorLabel.setVisible(false);
				} catch (SQLException e2) {
					System.out.println("Failed to connect with database.");
					e2.printStackTrace();
				}
				
				if(!tools.EssentialClass.checkPassword(password_)) {
					password.setBorder(new LineBorder(Color.red, 2, true));
					passReq.setVisible(true);
					//System.out.println("Password error");
					return;
				}
				else passReq.setVisible(false);
				
				
				try {
					DBMan.stmt.execute("INSERT INTO userBasicInfo(username, first_name, last_name, mobile, email) VALUES('" + username_ + "','" + firstName_ + "','" + lastName_ + "','" + mobile_ + "','" + email_ + "')");
					DBMan.stmt.execute("INSERT INTO user__(username, password) VALUES('" + username_ + "', '" + password_ + "')");
					//JOptionPane.showMessageDialog(getContentPane(), "Successful");
					String code = Integer.toString((int) (Math.random()*(999999-111111+1)+111111));
					database.MailSender.sendMail(email_, "Password Reset" , "Your verification code is: " + code);
					EmailVerificationForm.main(null, email_, code);
					if(EmailVerificationForm.success) dispose();
				} catch (SQLException e1) {
					System.out.println("Failed to connect with datbase.");
					e1.printStackTrace();
				}
				
			}
		});
		confirm.setHorizontalTextPosition(SwingConstants.CENTER);
		confirm.setForeground(Color.BLACK);
		confirm.setFont(new Font("Consolas", Font.BOLD, 14));
		confirm.setFocusPainted(false);
		confirm.setBorder(new LineBorder(new Color(51, 204, 51), 2, true));
		confirm.setBackground(new Color(0, 153, 51));
		confirm.setBounds(274, 352, 89, 29);
		contentPane.add(confirm);
		
		JButton login = new JButton("Already have an account? Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginForm.main(null);
			}
		});
		login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		login.setContentAreaFilled(false);
		login.setBorderPainted(false);
		login.setHorizontalTextPosition(SwingConstants.CENTER);
		login.setForeground(new Color(51, 204, 204));
		login.setFont(new Font("Consolas", Font.PLAIN, 11));
		login.setFocusPainted(false);
		login.setBorder(new LineBorder(new Color(153, 153, 255), 2, true));
		login.setBackground(new Color(153, 153, 204));
		login.setBounds(175, 388, 195, 20);
		contentPane.add(login);
		
		JLabel passReqIcon = new JLabel("*password policy");
		passReqIcon.setToolTipText("At least 8 digit long. \r\n*Must contain: One uppercase letter, One lowercase letter, One special character (@, #, $, &, *), One number.");
		passReqIcon.setForeground(new Color(255, 0, 0));
		passReqIcon.setFont(new Font("Consolas", Font.ITALIC, 9));
		passReqIcon.setBounds(491, 305, 81, 14);
		contentPane.add(passReqIcon);
		
		
	}

}
