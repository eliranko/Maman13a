package maman13a;

import java.io.FileNotFoundException;
import javax.swing.JFrame;

public class Maman13a {

    private static final String EXAM_FILE_PATH = "C:\\Users\\elira\\Desktop\\exam.txt";
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 600;
    
    public static void main(String[] args) {
        try {
            Exam exam = ExamInputReader.getExam(EXAM_FILE_PATH);
            exam.shuffleQuestionsAnswers();
            ExamPanel panel = new ExamPanel(exam);
            
            JFrame frame = new JFrame("Maman 13a");
            frame.add(panel);
            frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            frame.setVisible(true);
        }
        catch(FileNotFoundException e) {
            System.out.println("Could not find exam file!");
        }
    }
}
