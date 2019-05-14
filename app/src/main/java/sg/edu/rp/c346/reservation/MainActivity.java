package sg.edu.rp.c346.reservation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_name;
    TextView tv_num;
    TextView tv_pax;
    EditText et_name;
    EditText et_num;
    EditText et_pax;
    CheckBox cb_smoke;
    Button btn_confirm;
    Button btn_reset;
    DatePicker dp;
    TimePicker tp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_name = findViewById(R.id.tvName);
        tv_num = findViewById(R.id.tvNum);
        tv_pax = findViewById(R.id.tvPax);
        et_name = findViewById(R.id.etName);
        et_num = findViewById(R.id.etNum);
        et_pax = findViewById(R.id.etPax);
        cb_smoke = findViewById(R.id.checkBox);
        btn_confirm = findViewById(R.id.btnConfirm);
        btn_reset = findViewById(R.id.btnReset);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);


        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Name : " + et_name.getText().toString() +"\n Number: " +
                        et_num.getText().toString() +"\n Pax: " +  et_pax.getText().toString();
                if(cb_smoke.isChecked()) {
                    text += "\n Smoke : Yes";
                }
                else{
                    text += "\n Smoke : No";
                }
                text += "\n Date : " + dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear();
                text += "\n Time : " + tp.getCurrentHour() + ":" + tp.getCurrentMinute();

                Toast.makeText(getApplicationContext(),text, Toast.LENGTH_LONG).show();

            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_name.setText("");
                et_num.setText("");
                et_pax.setText("");

                cb_smoke.setChecked(false);

                dp.updateDate(2019,5,1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
            }
        });

    }
}
