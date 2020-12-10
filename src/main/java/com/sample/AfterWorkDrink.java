package com.sample;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
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
    public static void ShowAnswer(String answer)
    {
    	JOptionPane.showMessageDialog(frame,answer, "Result", JOptionPane.PLAIN_MESSAGE);
    	System.exit(0);
    }

}
