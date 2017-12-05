/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman13a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author elira
 */
public class ExamInputReader {
    private static final int NUM_OF_ANSWER_LINES = 4;
    
    /**
     * Get an exam from the given file path
     * @param examPath Exam file path
     * @return Exam object containing the information from the given input
     * @throws FileNotFoundException Exam file not found
     */
    public static Exam getExam(String examPath) throws FileNotFoundException {
        Scanner in = new Scanner(new File(examPath));
        ArrayList<ExamQuestion> questions = new ArrayList<>();
        
        // Read the file
        while(in.hasNextLine()) {
            questions.add(new ExamQuestion(in.nextLine(), getAnswers(in)));
        }
        in.close();
        
        return new Exam(questions);
    }
    
    private static ArrayList<String> getAnswers(Scanner in) {
        int counter = 0;
        ArrayList<String> answers = new ArrayList<>();
        // Fetch the remaining question's answers
        while(counter++ < NUM_OF_ANSWER_LINES && in.hasNextLine()) {
            answers.add(in.nextLine());
        }
        
        return answers;
    }
}
