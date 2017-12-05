/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman13a;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author elira
 */
public class ExamPanel extends JScrollPane implements ActionListener {
    private Exam exam;
    private final String GET_SCORE_BUTTON = "הגש";
    private final String CLEAN_BUTTON = "נקה";
    private ArrayList<ExamQuestionPanel> questionsPanel;
    
    /**
     * Constructor
     * @param exam 
     */
    public ExamPanel(Exam exam) {
        this.exam = exam;
        questionsPanel = new ArrayList<>();
        
        // Create containing panel. the '+1' is the line for the button
        JPanel mainPanel = new JPanel(new GridLayout(exam.getQuestions().size() + 1, 1));
        
        // Add exam questions
        for(ExamQuestion question : exam.getQuestions()) {
            ExamQuestionPanel questionPanel = new ExamQuestionPanel(question);
            mainPanel.add(questionPanel);
            this.questionsPanel.add(questionPanel);
        }
        
        // Set exam buttons
        JPanel buttonsPanel= new JPanel();
        JButton scoreButton = new JButton(GET_SCORE_BUTTON);
        JButton cleanButton = new JButton(CLEAN_BUTTON);
        scoreButton.addActionListener(this);
        cleanButton.addActionListener(this);
        buttonsPanel.add(scoreButton);
        buttonsPanel.add(cleanButton);
        
        mainPanel.add(buttonsPanel);
        
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
        setViewportView(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if(button.getText().equals(CLEAN_BUTTON)) {
            for(ExamQuestionPanel panel : this.questionsPanel) {
                panel.clearSelection();
            }
        }
    }
}