package in.ccode.sdaschoolbahraich.calendarActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import in.ccode.sdaschoolbahraich.R;
import in.ccode.sdaschoolbahraich.customCalendar.CalendarCustomView;

public class CalendarActivity extends AppCompatActivity {
    LinearLayout layoutCalendar;
    View customView;
    TextView thisWeek;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        setInitializations();
        setCardView();
        setCalenderView();
    }

    private void setInitializations() {
        customView = (View) findViewById(R.id.custom_view_calendar);
        layoutCalendar = (LinearLayout) findViewById(R.id.layoutCalender_calendar);
        thisWeek = (TextView) findViewById(R.id.calendar_this_week);
    }

    private void setCardView() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        String startDate = "", endDate = "";
        startDate = simpleDateFormat.format(calendar.getTime());
        calendar.add(Calendar.DATE, 6);
        endDate = simpleDateFormat.format(calendar.getTime());
        thisWeek.setText(String.format("%s - %s", startDate, endDate));
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
