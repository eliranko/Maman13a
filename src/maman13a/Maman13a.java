/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman13a;

import java.io.FileNotFoundException;
import javax.swing.JFrame;

/**
 *
 * @author elira
 */
public class Maman13a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Exam exam = ExamInputReader.getExam("C:\\Users\\elira\\Desktop\\exam.txt");
            exam.shuffleQuestionsAnswers();
            ExamPanel panel = new ExamPanel(exam);
            
            JFrame frame = new JFrame("Maman 13a");
            frame.add(panel);
            frame.setSize(400, 300);
            frame.setVisible(true);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
