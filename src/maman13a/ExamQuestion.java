/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman13a;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author elira
 */
public class ExamQuestion implements Comparable<ExamQuestion> {
    private String question;
    private ArrayList<String> answers;
        
    /**
     * Constructor
     * @param question Exam question
     * @param answers Available answers to the question
     */
    public ExamQuestion(String question, ArrayList<String> answers) {
        this.question = question;
        this.answers = answers;
    }
    
    /**
     * Get the exam question
     * @return String representing the question
     */
    public String getQuestion() {
        return this.question;
    }
    
    /**
     * Get the question answers
     * @return Array list of answers
     */
    public ArrayList<String> getAnswers() {
        return this.answers;
    }
    
    /**
     * Set the exam question
     * @param question String representing the question
     */
    public void setQuestion(String question) {
        this.question = question;
    }
    
    /**
     * Set the question answers
     * @param answers Array list of answers
     */
    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }
    
    public void shuffleAnswers() {
        Collections.shuffle(this.answers);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ExamQuestion)) {
            return false;
        }
        
        ExamQuestion quest = (ExamQuestion) obj;
        // Verify that the questions are equal 
        // and that number of answers are the same
        if(!this.question.equals(quest.question) || 
                this.answers.size() != quest.getAnswers().size()) {
            return false;
        }
        
        // Sort the arrays and verify equality
        ArrayList<String> copy1 = new ArrayList<>(this.answers);
        ArrayList<String> copy2 = new ArrayList<>(quest.getAnswers());
        Collections.sort(copy1);
        Collections.sort(copy2);
        return copy1.equals(copy2);
    }

    @Override
    public int compareTo(ExamQuestion question) {
        return this.question.compareTo(this.question);
    }
}
