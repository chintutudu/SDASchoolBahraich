package in.ccode.sdaschoolbahraich;

public class FeeListData {
    private String feeMonthOf;
    private String feeDatePaid;
    private String feeAmountPaid;
    private String feeBillNo;

    public FeeListData(String feeMonthOf, String feeDatePaid, String feeAmountPaid, String feeBillNo) {
        this.feeMonthOf = feeMonthOf;
        this.feeDatePaid = feeDatePaid;
        this.feeAmountPaid = feeAmountPaid;
        this.feeBillNo = feeBillNo;
    }

    public String getFeeMonthOf() {
        return feeMonthOf;
    }

    public void setFeeMonthOf(String feeMonthOf) {
        this.feeMonthOf = feeMonthOf;
    }

    public String getFeeDatePaid() {
        return feeDatePaid;
    }

    public void setFeeDatePaid(String feeDatePaid) {
        this.feeDatePaid = feeDatePaid;
    }

    public String getFeeAmountPaid() {
        return feeAmountPaid;
    }

    public void setFeeAmountPaid(String feeAmountPaid) {
        this.feeAmountPaid = feeAmountPaid;
    }

    public String getFeeBillNo() {
        return feeBillNo;
    }

    public void setFeeBillNo(String feeBillNo) {
        this.feeBillNo = feeBillNo;
    }
}
