package in.ccode.sdaschoolbahraich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;

import in.ccode.sdaschoolbahraich.calendar.CalendarCustomView;

public class CalendarActivity extends AppCompatActivity {
    LinearLayout layoutCalendar;
    View customView;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        setInitializations();
        setCalenderView();
    }

    private void setInitializations() {
        customView = (View) findViewById(R.id.custom_view_calendar);
        layoutCalendar = (LinearLayout) findViewById(R.id.layoutCalender_calendar);
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
