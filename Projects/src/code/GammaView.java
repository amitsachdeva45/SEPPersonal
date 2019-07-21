/**
 * 
 */
package code;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;

/**
 * @author Amit Sachdeva
 *
 */
public class GammaView {
	JFrame frame;
	JButton close, start, reset, calculate, refresh;
    JTextField inputField, resultField; 
    JTextArea historyField;
    JLabel historyLabel, resultLabel, headingLabel, commentLabel, instructions1, instructions2, instructions3;
    
    
	GammaView(String name){
		this.frame = new JFrame(name);
		this.frame.setBackground(Color.RED);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void setBasicLayout() {
		this.close = new JButton("Close");
		this.reset = new JButton("Reset");
		this.calculate = new JButton("Calculate");
		this.refresh = new JButton("Refresh");
		
		this.inputField = new JTextField("0.0");
		this.resultField = new JTextField("0.0");
		
		
		this.historyLabel = new JLabel("History");
		this.resultLabel = new JLabel("Result");
		this.headingLabel = new JLabel("Gamma Calculator");
		this.commentLabel = new JLabel("Please enter any real value or complex number in format of a+ib");
		this.instructions1 = new JLabel("RESET:     To clear all history data");
		this.instructions2 = new JLabel("CLOSE:     Close the Application");
		this.instructions3 = new JLabel("REFRESH:    Remove the result part");
		
		this.close.setBounds(5, 5, 100, 30);
		this.headingLabel.setBounds(115, 5, 400, 30);
		this.headingLabel.setFont(new Font("Serif", Font.BOLD, 20));
		this.headingLabel.setForeground(Color.GRAY);
		this.reset.setBounds(425, 5, 100, 30);
		
		this.inputField.setBounds(5, 65, 415, 30);
		this.inputField.addFocusListener(new FocusListener() {
		      public void focusGained(FocusEvent e) {
		        displayInMessage(1,e);
		      }
		      public void focusLost(FocusEvent e) {
		          displayInMessage(2, e);
		      }
		      void displayInMessage(int flag, FocusEvent e) {
		    	  if(flag == 1) {
		    		  JTextField temp = (JTextField)e.getSource();
		    		  temp.setText("");
		    	  }
		      }
		});
		this.calculate.setBounds(425, 65,100,30);
		this.commentLabel.setBounds(10, 100, 400, 15);
		this.commentLabel.setFont(new Font("Serif",Font.ITALIC,12));
		this.commentLabel.setForeground(Color.GRAY);
		
		this.resultLabel.setBounds(5, 125, 100, 30);
		this.resultLabel.setFont(new Font("Serif", Font.BOLD, 20));
		this.resultLabel.setForeground(Color.BLUE);
		this.resultField.setBounds(115, 125, 300, 30);
		this.resultField.setBackground(Color.WHITE);
		this.resultField.setEditable(false);
		this.refresh.setBounds(420, 125, 100, 30);
		
		this.historyLabel.setBounds(5, 185, 100, 30);
		this.historyLabel.setFont(new Font("Serif", Font.BOLD, 20));
		this.historyLabel.setForeground(Color.BLUE);

		this.historyField = new JTextArea();
		this.historyField.setText("*** No history Found ****");
		this.historyField.setBounds(115, 185, 415, 200);
		this.historyField.setEditable(false);
		JScrollPane historyScrollField = new JScrollPane();
		historyScrollField.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		historyScrollField.setBounds(115, 185, 415, 200);
		historyScrollField.getViewport().setBackground(Color.WHITE);
		historyScrollField.getViewport().add(this.historyField);
		
		
		this.instructions1.setBounds(5, 395, 395, 14);
		this.instructions1.setFont(new Font("Serif",Font.BOLD,12));
		this.instructions1.setForeground(Color.GRAY);
		this.instructions2.setBounds(5, 410, 395, 14);
		this.instructions2.setFont(new Font("Serif",Font.BOLD,12));
		this.instructions2.setForeground(Color.GRAY);
		this.instructions3.setBounds(5, 425, 395, 14);
		this.instructions3.setFont(new Font("Serif",Font.BOLD,12));
		this.instructions3.setForeground(Color.GRAY);
		
		this.frame.add(this.close);
		this.frame.add(this.headingLabel);
		this.frame.add(this.reset);
		this.frame.add(this.inputField);
		this.frame.add(this.calculate);
		this.frame.add(this.commentLabel);
		this.frame.add(this.resultLabel);
		this.frame.add(this.resultField);
		this.frame.add(this.refresh);
		this.frame.add(this.historyLabel);
		this.frame.add(historyScrollField);
		this.frame.add(this.instructions1);
		this.frame.add(this.instructions2);
		this.frame.add(this.instructions3);
		
		this.frame.setSize(550,500);
		this.frame.setLayout(null);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
	}
	public JButton getClose() {
		return close;
	}
	public JButton getReset() {
		return reset;
	}
	public JButton getCalculate() {
		return calculate;
	}
	public JButton getRefresh() {
		return refresh;
	}
	public void setRefresh(JButton refresh) {
		this.refresh = refresh;
	}
	public JTextField getInputField() {
		return inputField;
	}
	public JTextField getResultField() {
		return resultField;
	}
	public JTextArea getHistoryField() {
		return historyField;
	}
	public JLabel getResultLabel() {
		return resultLabel;
	}
	public void setAlert(int flag) {
		if(flag == 1) {
			this.getResultField().setBackground(Color.RED);
		}
		else if(flag == 2) {
			this.getResultField().setBackground(Color.GREEN);
		}
		else {
			this.getResultField().setBackground(Color.WHITE);
		}
	}
	public void setHistory(String history) {
		this.getHistoryField().setText(history);
	}
	public void setResult(String result) {
		this.getResultField().setText(result);
	}
}
