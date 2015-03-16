package pl.edu.wat.quzowanie;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class QuestionActivity extends ActionBarActivity {

    TextView qestion;
    RadioGroup answers;
    RadioButton answer1;
    RadioButton answer2;
    RadioButton answer3;
    int qestionNumber;
    int pkt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        qestion = (TextView) findViewById(R.id.qestion);
        answers = (RadioGroup) findViewById(R.id.answers);

        answer1 = (RadioButton) findViewById(R.id.answer1);
        answer2 = (RadioButton) findViewById(R.id.answer2);
        answer3 = (RadioButton) findViewById(R.id.answer3);

         qestionNumber = getIntent().getIntExtra("QESTION_NUMBER", 1);
        pkt = getIntent().getIntExtra("PKT", 0);

        switch (qestionNumber) {
            case 1:
                qestion.setText("Jak ma na imię Kowalski?");
                answer1.setText("Alina");
                answer2.setText("Agata");
                answer3.setText("Jan");
                break;

            case 2:
                qestion.setText("Jakiego koloru jest pomarańcza?");
                answer1.setText("niebieski");
                answer2.setText("różowy");
                answer3.setText("pomarańczowy");
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void start(View view) {
        Intent intent;

        switch (qestionNumber) {
            case 1:
                intent = new Intent(this, QuestionActivity.class);
                intent.putExtra("QESTION_NUMBER", 2);

                pkt = (answers.indexOfChild(findViewById(answers.getCheckedRadioButtonId())) == 2 ) ? 1: 0;

                intent.putExtra("PKT", pkt);

                break;
            case 2:
                intent = new Intent(this, ResultActivity.class);
                pkt += (answers.indexOfChild(findViewById(answers.getCheckedRadioButtonId())) == 2 ) ? 1: 0;
                intent.putExtra("PKT", pkt);
                break;
            default:
                intent = new Intent(this, ResultActivity.class);
                break;
        }


        startActivity(intent);
    }
}
