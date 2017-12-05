package maman13a;

import java.io.FileNotFoundException;
import javax.swing.JFrame;

public class Maman13a {

    public static void main(String[] args) {
        try {
            Exam exam = ExamInputReader.getExam("C:\\Users\\elira\\Desktop\\exam.txt");
            exam.shuffleQuestionsAnswers();
            ExamPanel panel = new ExamPanel(exam);
            
            JFrame frame = new JFrame("Maman 13a");
            frame.add(panel);
            frame.setSize(300, 600);
            frame.setVisible(true);
        }
        catch(FileNotFoundException e) {
            System.out.println("Could not find exam file!");
        }
    }
}
