/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman13a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author elira
 */
public class ExamPanel extends JScrollPane implements ActionListener {
    private final String CLEAN_BUTTON_TEXT = "נקה";
    private final String SUBMIT_BUTTON_TEXT = "הגש";
    private final String SUBMIT_BUTTON_DEFAULT_TEXT = "";
    private final String SUBMIT_BUTTON_AFTER_SUBMISSION_TEXT = "תוצאתך היא: ";
    private final ArrayList<ExamQuestionPanel> questionPanels;
    
    private Exam exam;
    private JLabel submissionLabel;
    
    /**
     * Constructor
     * @param exam Exam to be shown on the form
     */
    public ExamPanel(Exam exam) {
        this.exam = exam;
        questionPanels = new ArrayList<>();
        
        // Create exam panel
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        setViewportView(getExamQuestionsPanel());
    }

    /**
     * Get the form's exam object
     * @return Exam object
     */
    public Exam getExam() {
        return this.exam;
    }
    
    /**
     * Set the form's exam
     * @param exam Exam to be shown on the form
     */
    public void setExam(Exam exam) {
        this.exam = exam;
    }
    
    private JPanel getExamQuestionsPanel() {
        JPanel panel = new JPanel();
        // Using box layout to stack components on top of each other
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Add exam questions
        for(ExamQuestion question : exam.getQuestions()) {
            ExamQuestionPanel questionPanel = new ExamQuestionPanel(question);
            panel.add(questionPanel);
            this.questionPanels.add(questionPanel);
        }
        
        // Add form submission buttons
        panel.add(getFormValidationPanel());
        
        return panel;
    }
    
    private JPanel getFormValidationPanel() {
        JPanel panel = new JPanel();
        
        JButton scoreButton = new JButton(SUBMIT_BUTTON_TEXT);
        JButton cleanButton = new JButton(CLEAN_BUTTON_TEXT);
        submissionLabel = new JLabel(SUBMIT_BUTTON_DEFAULT_TEXT);
        
        scoreButton.addActionListener(this);
        cleanButton.addActionListener(this);
        
        panel.add(scoreButton);
        panel.add(cleanButton);
        panel.add(submissionLabel);
        
        return panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        switch(button.getText()) {
            case CLEAN_BUTTON_TEXT: // Clean button clicked
                clickedCleanButton();
                break;
            case SUBMIT_BUTTON_TEXT: // Submit button clicked
                clickedScoreButton();
                break;
        }
    }
    
    private void clickedCleanButton() {
        // Clear questoins & shuffle answers
        for(ExamQuestionPanel panel : this.questionPanels) {
            panel.clearSelection();
            panel.shuffleAnswers();
        }
        
        // Clear label
        submissionLabel.setText(SUBMIT_BUTTON_DEFAULT_TEXT);
    }
    
    private void clickedScoreButton() {
        setSubmissionLabel();
        setQuestionsIcon();
    }
    
    private void setSubmissionLabel() {
        // Count the number of correct answers
        int correctAnswerCounter = 0;
        for(ExamQuestionPanel panel : this.questionPanels) {
            if(panel.answeredCorrectly()) correctAnswerCounter++;
        }
        
        // Set the appropriate label text
        double score = ((double) correctAnswerCounter / (double) this.questionPanels.size()) * 100;
        // Display 2 digits after decimal
        String strScore = String.format("%.2f", score) + "%";
        submissionLabel.setText(SUBMIT_BUTTON_AFTER_SUBMISSION_TEXT + strScore);
    }
    
    private void setQuestionsIcon() {
        for(ExamQuestionPanel panel : this.questionPanels) {
            panel.setIconAccordingToAnswer();
        }
    }
}