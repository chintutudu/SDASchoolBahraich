package in.ccode.sdaschoolbahraich;

public class AssignmentListData{
    private String subjectName;
    private String subjectDescription;
    private String subjectDueDate;
    public AssignmentListData(String subjectName, String subjectDescription, String subjectDueDate) {
        this.subjectName = subjectName;
        this.subjectDescription = subjectDescription;
        this.subjectDueDate = subjectDueDate;
    }
    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public String getDescription() {
        return subjectDescription;
    }
    public void setDescription(String description) {
        this.subjectDescription = description;
    }
    public String getSubjectDueDate() {
        return subjectDueDate;
    }
    public void setSubjectDueDate(String subjectDueDate) {
        this.subjectDueDate = subjectDueDate;
    }
}
