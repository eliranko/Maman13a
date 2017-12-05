/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman13a;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author elira
 */
public class ExamQuestionPanel extends JPanel implements ActionListener {
    private ExamQuestion examQuestion;
    private ButtonGroup group;
    private String chosenAnswer;
    
    public ExamQuestionPanel(ExamQuestion examQuestion) {
        this.examQuestion = examQuestion;
        chosenAnswer = "";
        
        setLayout(new GridLayout(5, 1, 1, 1));
        
        // Add question
        add(new JLabel(this.examQuestion.getQuestion()));
        
        // Add answers
        this.group = new ButtonGroup();
        ArrayList<JRadioButton> buttons = new ArrayList<>();
        for(String answer : examQuestion.getAnswers()) {
            JRadioButton button = new JRadioButton(answer);
            button.addActionListener(this);
            buttons.add(button);
            this.group.add(button);
        }
        for(JRadioButton button : buttons) {
            add(button);
        }
    }

    public void clearSelection() {
        this.group.clearSelection();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton button = (JRadioButton) e.getSource();
        this.chosenAnswer = button.getText();
    }
}
