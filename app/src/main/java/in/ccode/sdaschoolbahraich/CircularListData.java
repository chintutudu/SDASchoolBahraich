package in.ccode.sdaschoolbahraich;

public class CircularListData {
    private String circularHeading;
    private String circularDescription;

    public CircularListData(String circularHeading, String circularDescription) {
        this.circularHeading = circularHeading;
        this.circularDescription = circularDescription;
    }
    public String getCircularHeading() {
        return circularHeading;
    }
    public void setCircularHeading(String heading) {
        this.circularHeading = heading;
    }
    public String getCircularDescription() {
        return circularDescription;
    }
    public void setCircularDescription(String description) {
        this.circularDescription = description;
    }
}
