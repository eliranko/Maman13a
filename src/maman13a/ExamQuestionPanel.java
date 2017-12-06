package maman13a;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ExamQuestionPanel extends JPanel implements ActionListener {
    private final String QUESTION_MARK_ICON_PATH = "C:\\Users\\elira\\Desktop\\QuestionMark.png";
    private final String CHECK_MARK_ICON_PATH = "C:\\Users\\elira\\Desktop\\CheckMark.png";
    private final String X_MARK_ICON_PATH = "C:\\Users\\elira\\Desktop\\RedX.png";
    private final ArrayList<JRadioButton> answerButtons;
    
    private ExamQuestion examQuestion;
    private JLabel questionLabel;
    private ButtonGroup group;
    private String chosenAnswer;

    /**
     * Empty constructor
     */
    public ExamQuestionPanel() {
        this.answerButtons = new ArrayList<>();
        this.examQuestion = new ExamQuestion();
        this.questionLabel = new JLabel();
        this.group = new ButtonGroup();
        this.chosenAnswer = "";
    }
    
    /**
     * Constructor
     * @param examQuestion ExamQuestion object
     */
    public ExamQuestionPanel(ExamQuestion examQuestion) {
        this();
        this.examQuestion = examQuestion;
        
        createExamQuestionPanel();
    }

    public void createExamQuestionPanel() {
        setLayout(new GridLayout(5, 1, 1, 1));
        addQuestionToPanel();
        addAnswersToPanel();
    }
    
    /**
     * Get the question used in this panel
     * @return ExamQuestion object
     */
    public ExamQuestion getExamQuestion() {
        return this.examQuestion;
    }
    
    /**
     * Set the exam question to be used in this panel
     * @param examQuestion ExamQuestion object
     */
    public void setExamQuestion(ExamQuestion examQuestion) {
        this.examQuestion = examQuestion;
    }
    
    /**
     * Shuffle the answers location of the question 
     */
    public void shuffleAnswers() {
        // Shuffle the answers
        this.examQuestion.shuffleAnswers();
        
        // Set the answer in the shuffled location
        int numOfAnswers = this.answerButtons.size();
        ArrayList<String> shuffledAnswers = this.examQuestion.getAnswers();
        for(int i = 0; i < numOfAnswers; i++) {
            this.answerButtons.get(i).setText(shuffledAnswers.get(i));
        }
    }
    
    /**
     * Clear answer selection
     */
    public void clearSelection() {
        this.group.clearSelection();
        setIcon(QUESTION_MARK_ICON_PATH);
        this.chosenAnswer = "";
    }
    
    /**
     * Check if the correct answer was chosen
     * @return true if the correct answer was chosen, false otherwise
     */
    public boolean answeredCorrectly() {
        return this.chosenAnswer.equals(examQuestion.getCorrectAnsewr());
    }
    
    public void setIconAccordingToAnswer() {
        setIcon(answeredCorrectly() ? CHECK_MARK_ICON_PATH : X_MARK_ICON_PATH);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton button = (JRadioButton) e.getSource();
        this.chosenAnswer = button.getText();
    }
    
    private void addQuestionToPanel() {
        this.questionLabel = new JLabel(this.examQuestion.getQuestion());
        setIcon(QUESTION_MARK_ICON_PATH);
        add(this.questionLabel);
    }
    
    private void addAnswersToPanel() {
        this.group = new ButtonGroup();
        for(String answer : this.examQuestion.getAnswers()) {
            JRadioButton button = new JRadioButton(answer);
            // Add event
            button.addActionListener(this);
            answerButtons.add(button);
            this.group.add(button);
            // Add button to panel
            add(button);
        }
    }
    
    private void setIcon(String path) {
        this.questionLabel.setIcon(new ImageIcon(path));
    }
}
