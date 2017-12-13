package blog.praveendeshmane.co.in.intentserviceexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ResponseReceiver receiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter(ResponseReceiver.ACTION_RESP);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        receiver = new ResponseReceiver();
        registerReceiver(receiver, filter);
    }

    public void click(View view) {

        Toast.makeText(getApplicationContext(),"on click",Toast.LENGTH_SHORT).show();
        EditText input = findViewById(R.id.editText);
        String strInputMsg = input.getText().toString();
        Intent msgIntent = new Intent(this, SimpleService.class);
        msgIntent.putExtra(SimpleService.PARAM_IN_MSG, strInputMsg);
        startService(msgIntent);
    }


    class ResponseReceiver extends BroadcastReceiver {
        public static final String ACTION_RESP =
                "blog.praveendeshmane.co.in.intentserviceexample.MESSAGE_PROCESSED";

        @Override
        public void onReceive(Context context, Intent intent) {
            TextView result = findViewById(R.id.textView);
            String text = intent.getStringExtra(SimpleService.PARAM_OUT_MSG);
            result.setText(text);
            Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
        }
    }
}
