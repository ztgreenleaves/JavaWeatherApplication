package Jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bean.WeatherBean;
import xmlDOM.Operator;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class MainFrame extends JFrame implements ActionListener,IShowWarning{
	
	private JPanel contentPane;
	WeatherBean wb = new WeatherBean();
	final JLabel cityin;
	final JLabel wenduin;
	final JLabel fengliin;
	final JLabel shiduin;
	final JLabel fengxiangin;
	final JLabel sunrisein;
	final JLabel sunsetin;
	final JLabel pm25in;
	final JLabel qualityin;
	final JLabel timein;
	final JLabel timelab;
	final JTextArea suggestin;
	Operator op = new Operator();	
	private JTextField citynamein;
	private Timer timer;
	private JLabel nowtimein;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MainFrame() throws SQLException {
		setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		setTitle("\u5929\u6C14\u67E5\u8BE2\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 857);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setResizable(false); 
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel cityinfo = new JPanel();
		//cityinfo.setVisible(false);
		
		JPanel find = new JPanel();
		
		JPanel action = new JPanel();
		
		final JPanel timepane = new JPanel();
		
		JPanel nowtime = new JPanel();
		//timepane.setVisible(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(nowtime, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
						.addComponent(cityinfo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
						.addComponent(action, GroupLayout.PREFERRED_SIZE, 391, Short.MAX_VALUE)
						.addComponent(find, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
						.addComponent(timepane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(find, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cityinfo, GroupLayout.PREFERRED_SIZE, 534, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(timepane, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nowtime, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(action, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel nowtimelab = new JLabel("\u5F53\u524D\u65F6\u95F4\uFF1A");
		nowtimelab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		nowtimein = new JLabel("");
		nowtimein.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		GroupLayout gl_nowtime = new GroupLayout(nowtime);
		gl_nowtime.setHorizontalGroup(
			gl_nowtime.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_nowtime.createSequentialGroup()
					.addContainerGap()
					.addComponent(nowtimelab)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nowtimein)
					.addContainerGap(217, Short.MAX_VALUE))
		);
		gl_nowtime.setVerticalGroup(
			gl_nowtime.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_nowtime.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_nowtime.createParallelGroup(Alignment.LEADING)
						.addComponent(nowtimein)
						.addComponent(nowtimelab))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		nowtime.setLayout(gl_nowtime);
		
		timelab = new JLabel("");
		timelab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		timein = new JLabel("");
		timein.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		GroupLayout gl_timepane = new GroupLayout(timepane);
		gl_timepane.setHorizontalGroup(
			gl_timepane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_timepane.createSequentialGroup()
					.addContainerGap()
					.addComponent(timelab)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(timein)
					.addContainerGap(201, Short.MAX_VALUE))
		);
		gl_timepane.setVerticalGroup(
			gl_timepane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_timepane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_timepane.createParallelGroup(Alignment.BASELINE)
						.addComponent(timelab)
						.addComponent(timein))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		timepane.setLayout(gl_timepane);
		
		final JButton insert = new JButton("\u63D2\u5165\u65F6\u95F4");
		insert.setEnabled(false);
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		insert.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		final JButton delete = new JButton("\u5220\u9664\u65F6\u95F4");
		delete.setEnabled(false);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		delete.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		final JButton update = new JButton("\u66F4\u65B0\u65F6\u95F4");
		update.setEnabled(false);
		
		update.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		GroupLayout gl_action = new GroupLayout(action);
		gl_action.setHorizontalGroup(
			gl_action.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_action.createSequentialGroup()
					.addComponent(insert)
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(update)
					.addGap(36)
					.addComponent(delete))
		);
		gl_action.setVerticalGroup(
			gl_action.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_action.createSequentialGroup()
					.addGroup(gl_action.createParallelGroup(Alignment.BASELINE)
						.addComponent(insert)
						.addComponent(delete)
						.addComponent(update))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		action.setLayout(gl_action);
		
		JLabel cityname = new JLabel("\u57CE\u5E02\u540D\uFF1A");
		cityname.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JButton search = new JButton("\u67E5\u8BE2");
		
		search.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		citynamein = new JTextField();
		citynamein.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		citynamein.setColumns(4);
		GroupLayout gl_find = new GroupLayout(find);
		gl_find.setHorizontalGroup(
			gl_find.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_find.createSequentialGroup()
					.addContainerGap()
					.addComponent(cityname)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(citynamein, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(search)
					.addContainerGap())
		);
		gl_find.setVerticalGroup(
			gl_find.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_find.createSequentialGroup()
					.addGroup(gl_find.createParallelGroup(Alignment.BASELINE)
						.addComponent(cityname)
						.addComponent(search)
						.addComponent(citynamein, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		find.setLayout(gl_find);
		
		JLabel citylab = new JLabel("\u57CE  \u5E02 \u540D\uFF1A");
		citylab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel wendulab = new JLabel("\u6C14       \u6E29\uFF1A");
		wendulab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel fenglilab = new JLabel("\u98CE       \u529B\uFF1A");
		fenglilab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel shidulab = new JLabel("\u6E7F       \u5EA6\uFF1A");
		shidulab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel fengxianglab = new JLabel("\u98CE       \u5411\uFF1A");
		fengxianglab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel sunriselab = new JLabel("\u65E5       \u5347\uFF1A");
		sunriselab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel sunsetlab = new JLabel("\u65E5       \u843D\uFF1A");
		sunsetlab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel pm25lab = new JLabel("PM   2.5\uFF1A");
		pm25lab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel suggestlab = new JLabel("\u5EFA       \u8BAE\uFF1A");
		suggestlab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel qualitylab = new JLabel("\u7A7A\u6C14\u8D28\u91CF\uFF1A");
		qualitylab.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		cityin = new JLabel(" ");
		cityin.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		wenduin = new JLabel(" ");
		wenduin.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		fengliin = new JLabel(" ");
		fengliin.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		shiduin = new JLabel(" ");
		shiduin.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		fengxiangin = new JLabel(" ");
		fengxiangin.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		sunrisein = new JLabel(" ");
		sunrisein.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		sunsetin = new JLabel(" ");
		sunsetin.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		pm25in = new JLabel(" ");
		pm25in.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		qualityin = new JLabel("");
		qualityin.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		suggestin = new JTextArea();
		suggestin.setEditable(false);
		suggestin.setWrapStyleWord(true);
		suggestin.setLineWrap(true);
		suggestin.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		GroupLayout gl_cityinfo = new GroupLayout(cityinfo);
		gl_cityinfo.setHorizontalGroup(
			gl_cityinfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cityinfo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_cityinfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cityinfo.createSequentialGroup()
							.addComponent(citylab)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cityin))
						.addGroup(gl_cityinfo.createSequentialGroup()
							.addComponent(wendulab)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(wenduin))
						.addGroup(gl_cityinfo.createSequentialGroup()
							.addComponent(fenglilab)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fengliin))
						.addGroup(gl_cityinfo.createSequentialGroup()
							.addComponent(shidulab)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(shiduin))
						.addGroup(gl_cityinfo.createSequentialGroup()
							.addComponent(fengxianglab)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fengxiangin))
						.addGroup(gl_cityinfo.createSequentialGroup()
							.addComponent(sunriselab)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sunrisein))
						.addGroup(gl_cityinfo.createSequentialGroup()
							.addComponent(sunsetlab)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sunsetin))
						.addGroup(gl_cityinfo.createSequentialGroup()
							.addGroup(gl_cityinfo.createParallelGroup(Alignment.LEADING)
								.addComponent(pm25lab)
								.addComponent(suggestlab))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_cityinfo.createParallelGroup(Alignment.LEADING)
								.addComponent(suggestin, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
								.addComponent(pm25in)))
						.addGroup(gl_cityinfo.createSequentialGroup()
							.addComponent(qualitylab)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(qualityin)))
					.addContainerGap())
		);
		gl_cityinfo.setVerticalGroup(
			gl_cityinfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cityinfo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_cityinfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(citylab)
						.addComponent(cityin))
					.addGap(18)
					.addGroup(gl_cityinfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(wendulab)
						.addComponent(wenduin))
					.addGap(18)
					.addGroup(gl_cityinfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(fenglilab)
						.addComponent(fengliin))
					.addGap(18)
					.addGroup(gl_cityinfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(shidulab)
						.addComponent(shiduin))
					.addGap(18)
					.addGroup(gl_cityinfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(fengxianglab)
						.addComponent(fengxiangin))
					.addGap(18)
					.addGroup(gl_cityinfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(sunriselab)
						.addComponent(sunrisein))
					.addGap(18)
					.addGroup(gl_cityinfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(sunsetlab)
						.addComponent(sunsetin))
					.addGap(18)
					.addGroup(gl_cityinfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(pm25lab)
						.addComponent(pm25in))
					.addGap(18)
					.addGroup(gl_cityinfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(suggestlab)
						.addComponent(suggestin, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_cityinfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(qualitylab)
						.addComponent(qualityin))
					.addContainerGap())
		);
		cityinfo.setLayout(gl_cityinfo);
		panel.setLayout(gl_panel);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				String searchname = citynamein.getText().trim();
				if(!searchname.equals("")){
				wb =op.queryXML(searchname,MainFrame.this);
				insert.setEnabled(true);
				update.setEnabled(true);
				delete.setEnabled(true);
				display();
				}else{
					ShowWarnings("³ÇÊÐÃû²»ÄÜÎª¿Õ");
					insert.setEnabled(false);
					update.setEnabled(false);
					delete.setEnabled(false);
				}
				
					
			}
		});
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wb=op.insertXML();
				display();
			}
		});
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wb=op.updateXML();
				display();
			}
		});
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wb=op.deleteXML();
				display();
				timelab.setText("");
				timein.setText("");
			}
		});
		timer=new Timer(500,this);
		timer.start();
	}

   
	public void display(){
		cityin.setText(wb.getCity());
		wenduin.setText(wb.getWendu());
		fengliin.setText(wb.getFengli());
		shiduin.setText(wb.getShidu());
		fengxiangin.setText(wb.getFengxiang());
		sunrisein.setText(wb.getSunrise());
		sunsetin.setText(wb.getSunset());
		pm25in.setText(wb.getPm25());
		suggestin.setText(wb.getSuggest());
		qualityin.setText(wb.getQuality());
		if(wb.getCurrentTime()!=null){
			timelab.setText("\u67E5\u8BE2\u65F6\u95F4\uFF1A");
			timein.setText(wb.getCurrentTime());
		}
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		nowtimein.setText(format.format(date));
	}

	@Override
	public void ShowWarnings(String warnings) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, warnings, "¾¯¸æ",JOptionPane.WARNING_MESSAGE); 
	}
}
