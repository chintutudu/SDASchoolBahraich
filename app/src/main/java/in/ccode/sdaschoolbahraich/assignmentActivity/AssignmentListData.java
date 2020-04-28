package in.ccode.sdaschoolbahraich.assignmentActivity;

public class AssignmentListData{
    private String subject_id;
    private String assignment_details;
    private String due_date;
    public AssignmentListData() {

    }
    public AssignmentListData(String subject_id, String assignment_details, String due_date) {
        this.subject_id = subject_id;
        this.assignment_details = assignment_details;
        this.due_date = due_date;
    }
    public String getSubject_id() {
        return subject_id;
    }
    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }
    public String getAssignment_details() {
        return assignment_details;
    }
    public void setDescription(String description) {
        this.assignment_details = description;
    }
    public String getDue_date() {
        return due_date;
    }
    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }
}
