package test_lmy;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.sun.xml.internal.ws.api.server.Container;

public class Control extends JFrame implements ActionListener{
		JButton b1, b2, b3, b4;
		JTable table;
		JTextField  j3;
		String str = JOptionPane.showInputDialog("�������������");
		int N = Integer.parseInt(str);
		String a[][] = new String[N][7];
		String[] name = { "���̺�", "�ύʱ��", "����ʱ��", "��ʼʱ��", "����ʱ��", "��תʱ��", "��Ȩ��תʱ��" };
		StringBuffer priority;
		public Control() {
			super("���̵����㷨");
			java.awt.Container c = getContentPane();
			GridBagLayout f = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();
			c.setLayout(f);

			table = new JTable(a, name);
			JScrollPane p1 = new JScrollPane(table);
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 60;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			f.setConstraints(p1, gbc);
			c.add(p1);
			JLabel label3 = new JLabel("�������ȼ�����:");
			label3.setFont(new Font("����", Font.BOLD, 12));
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			f.setConstraints(label3, gbc);
			c.add(label3);
			gbc.gridheight = 1;

			j3 = new JTextField(1);
			gbc.ipadx = 1;
			gbc.ipady = 1;
			;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			f.setConstraints(j3, gbc);
			j3.setText("" + priority);
			c.add(j3);
	        b1 = new JButton("�����ȷ���");
			b1.setFont(new Font("����", Font.BOLD, 15));
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			f.setConstraints(b1, gbc);
			c.add(b1);

			b2 = new JButton("����ҵ����");
			b2.setFont(new Font("����", Font.BOLD, 15));
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			f.setConstraints(b2, gbc);
			c.add(b2);

			b3 = new JButton("ʱ��Ƭ��ת");
			b3.setFont(new Font("����", Font.BOLD, 15));
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			f.setConstraints(b3, gbc);
			c.add(b3);

			b4 = new JButton("����Ӧ������");
			b4.setFont(new Font("����", Font.BOLD, 15));
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			f.setConstraints(b4, gbc);
			c.add(b4);

			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);

			setSize(500, 580);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			for (int i = 0; i < N; i++)
				for (int j = 0; j < 3; j++) {
					System.out.println(a[i][j]);
				}
		}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(b1))//�����ȷ���
		{
			try {

				String [][] b = new String[N][8];
				priority = new StringBuffer(); 
				FCFS fcfs = new FCFS(N);
				b = fcfs.outCome(a);
				for (int i = 0; i < N; i++) {
					priority.append("-->"+b[i][7]);
					for (int j = 0; j < 7; j++) {
						table.setValueAt("" + b[i][j], i, j);
					}
				}
				j3.setText("" + priority);

			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
		if (e.getSource().equals(b2))//�̽�������
		{
			try {

				String [][] b = new String[N][8];
				priority = new StringBuffer(); 
				SJF sjf = new SJF(N);
				b = sjf.outCome(a);
				for (int i = 0; i < N; i++) {
					priority.append("-->"+b[i][7]);
					for (int j = 0; j < 7; j++) {
						table.setValueAt("" + b[i][j], i, j);
					}
				}
				j3.setText("" + priority);
			}
			 catch (Exception ee) {
				ee.printStackTrace();
			}
		}

		if (e.getSource().equals(b3))//ʱ��Ƭ��ת
		{

			String [][] b = new String[N][7];
			priority = new StringBuffer();
			JTextField txt = new JTextField(5);
			String val = JOptionPane.showInputDialog("������ʱ��Ƭ��");
			txt.setText(val);
			int slice = Integer.parseInt(txt.getText());
			RR  rr = new RR(slice, N);
			b = rr.outCome(a);
			priority.append(rr.getPriority());
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 7; j++) {
					table.repaint();
					table.setValueAt("" + b[i][j], i, j);
				}
			}
			j3.setText("" + priority);

		}
		if (e.getSource().equals(b4))//����Ӧ�����ȵ���
		{
			try {

				String [][] b = new String[N][7];
				priority = new StringBuffer();
				HRRN hrrn = new HRRN(N);
				b = hrrn.outCome(a);
				for (int i = 0; i < N; i++) {
					priority.append("-->"+b[i][7]);
					for (int j = 0; j < 7; j++) {
						table.repaint();
						table.setValueAt("" + b[i][j], i, j);
					}
				}
				j3.setText("" + priority);
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}

	}

	public static void main(String args[]) {
		Control lmy = new Control();

}

}



