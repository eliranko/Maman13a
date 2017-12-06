package maman13a;

import java.util.ArrayList;
import java.util.Collections;

public class Exam {
    private ArrayList<ExamQuestion> questions;
    
    /**
     * Empty constructor
     */
    public Exam() {
        this.questions = new ArrayList<>();
    }
    
    /**
     * Constructor
     * @param questions The exam questions
     */
    public Exam(ArrayList<ExamQuestion> questions) {
        this.questions = questions;
    }
    
    /**
     * Get the exam questions
     * @return Array list containing the exam's questions
     */
    public ArrayList<ExamQuestion> getQuestions() {
        return this.questions;
    }
    
    /**
     * Set the exam questions
     * @param questions Array list of questions
     */
    public void setQuestions(ArrayList<ExamQuestion> questions) {
        this.questions = questions;
    }
    
    /**
     * For each question, this method shuffles its available answers randomly 
    */
    public void shuffleQuestionsAnswers() {
        for(ExamQuestion question : this.questions) {
            question.shuffleAnswers();
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Exam)) {
            return false;
        }
        
        // Compare the exam questions
        Exam exam = (Exam) obj;
        ArrayList<ExamQuestion> copy1 = new ArrayList<>(this.questions);
        ArrayList<ExamQuestion> copy2 = new ArrayList<>(exam.getQuestions());
        Collections.sort(copy1);
        Collections.sort(copy2);
        
        return copy1.equals(copy2);
    }
}
