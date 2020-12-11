package com.sample;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class AfterWorkDrink {
	private static JFrame frame = new JFrame();
	private static int l = 0;
    public static final void main(String[] args) {
    	try {
    		frame.getContentPane().setBackground(new Color(238, 232, 170));
            frame.getContentPane().setLayout(null);
            frame.setTitle("After Work Drink");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setSize(600, 600);

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(dim.width / 2 - frame.getWidth() / 2, dim.height / 2 - frame.getHeight() / 2);
            
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    public static String AskQuestion(String question, Object[] answers)
    {	
    	l += 1;
    	int n = JOptionPane.showOptionDialog(frame,
                question,
                "Question number "+ l,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                answers,
                null);
    	if(n==-1)
    	{
    		System.exit(0);
    	}
		return (String) answers[n];
    }
    public static void ShowAnswer(String answer, String description, String ikona)
    {
    	frame.getContentPane().setBackground(new Color(176, 224, 230));
    	JLabel Icon = new JLabel("");
    	Icon.setBounds(0, 0, 300, 540);
        Icon.setIcon(new ImageIcon(ikona));
        frame.add(Icon);
        JLabel Text = new JLabel(answer);
        Text.setVerticalAlignment(SwingConstants.CENTER);
        Text.setFont(new Font("Tahoma", Font.BOLD, 24));
        Text.setHorizontalAlignment(SwingConstants.CENTER);
        Text.setBounds(280, 0, 300, 100);
        frame.add(Text);
        JLabel Text2 = new JLabel(description);
        Text2.setVerticalAlignment(SwingConstants.TOP);
        Text2.setFont(new Font("Tahoma", Font.ITALIC, 14));
        Text2.setHorizontalAlignment(SwingConstants.CENTER);
        Text2.setBounds(280, 100, 300, 300);
        frame.add(Text2);
        frame.repaint();
        frame.revalidate();
    }

}
