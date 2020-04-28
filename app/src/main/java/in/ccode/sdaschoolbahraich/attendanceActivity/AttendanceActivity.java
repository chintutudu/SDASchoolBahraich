package in.ccode.sdaschoolbahraich.attendanceActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import in.ccode.sdaschoolbahraich.R;
import in.ccode.sdaschoolbahraich.customCalendar.CalendarCustomView;

public class AttendanceActivity extends AppCompatActivity {
    LinearLayout layoutCalendar;
    View customView;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM");
    SimpleDateFormat simpleDateFormatDays = new SimpleDateFormat("dd");
    Date date = new Date();
    TextView month, attendanceDaysElapsed, attendancePresent, attendanceAbsent,attendanceMonthlyPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        setInitializations();
        setCardView();
        setCalenderView();
    }

    private void setInitializations() {
        customView = (View) findViewById(R.id.custom_view_attendance);
        layoutCalendar = (LinearLayout) findViewById(R.id.layoutCalender_attendance);
        month = (TextView) findViewById(R.id.attendance_month);
        attendanceDaysElapsed = (TextView) findViewById(R.id.attendance_days_elapsed);
        attendancePresent = (TextView) findViewById(R.id.attendance_present);
        attendanceAbsent = (TextView) findViewById(R.id.attendance_absent);
        attendanceMonthlyPercentage = (TextView) findViewById(R.id.attendance_monthly_percentage);
    }

    private void setCardView() {
        int daysElapsed, present, absent, monthlyPercentage;
        month.setText(simpleDateFormat.format(date));
        attendanceDaysElapsed.setText(simpleDateFormatDays.format(date));

        daysElapsed = Integer.parseInt(simpleDateFormatDays.format(date));
        present = daysElapsed;
        absent = 0;
        monthlyPercentage = (daysElapsed/present) * 100;

        attendancePresent.setText(String.valueOf(present));
        attendanceAbsent.setText(String.valueOf(absent));
        attendanceMonthlyPercentage.setText(String.format("%s %%", String.valueOf(monthlyPercentage)));
    }

    private void setCalenderView() {
        ViewGroup parent = (ViewGroup) customView.getParent();
        parent.removeView(customView);
        layoutCalendar.removeAllViews();
        layoutCalendar.setOrientation(LinearLayout.VERTICAL);

        final CalendarCustomView calendarCustomView = new CalendarCustomView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        calendarCustomView.setLayoutParams(layoutParams);
        layoutCalendar.addView(calendarCustomView);
    }
}
