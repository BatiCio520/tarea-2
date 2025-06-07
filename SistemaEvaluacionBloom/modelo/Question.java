package modelo;

public class Question {
    private int id;
    private String prompt;
    private String[] options;
    private int correctIndex;
    private BloomLevel level;
    private QuestionType type;
    private int estimatedTime;
    private int userAnswer = -1;

    public Question(int id, String prompt, String[] options, int correctIndex,
                    BloomLevel level, QuestionType type, int estimatedTime) {
        this.id = id;
        this.prompt = prompt;
        this.options = options;
        this.correctIndex = correctIndex;
        this.level = level;
        this.type = type;
        this.estimatedTime = estimatedTime;
    }

    public boolean isCorrect() {
        return correctIndex == userAnswer;
    }

    public int getUserAnswer() { return userAnswer; }
    public void setUserAnswer(int userAnswer) { this.userAnswer = userAnswer; }
    public String getPrompt() { return prompt; }
    public String[] getOptions() { return options; }
    public BloomLevel getLevel() { return level; }
    public QuestionType getType() { return type; }
}
