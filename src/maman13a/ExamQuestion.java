package maman13a;

import java.util.ArrayList;
import java.util.Collections;

public class ExamQuestion implements Comparable<ExamQuestion> {
    private final String correctAnswer;
    
    private String question;
    private ArrayList<String> answers;

    /**
     * Empty constructor
     */
    public ExamQuestion() {
        this.question = this.correctAnswer = "";
        this.answers = new ArrayList<>();
    }
    
    /**
     * Constructor
     * @param question Exam question
     * @param answers Available answers to the question
     */
    public ExamQuestion(String question, ArrayList<String> answers) {
        this.question = question;
        this.answers = answers;
        
        // Assuming the input was valid as requested
        this.correctAnswer = answers.get(0);
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
     * Get the question answer
     * @return String containing the correct answer
     */
    public String getCorrectAnsewr() {
        return this.correctAnswer;
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
    
    /**
     * Shuffle answers location
     */
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
