package edu.upc.eseiaat.pma.quiz_marta;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import edu.upc.eseiaat.pma.quiz_marta.R;

public class QuizActivity extends AppCompatActivity {

    private int id_answers[]={
            R.id.answer1,
            R.id.answer2,
            R.id.answer3,
            R.id.answer4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView var_text_question= (TextView) findViewById(R.id.text_question);
        var_text_question.setText(R.string.question_content);

        String[] answers = getResources().getStringArray(R.array.answers);

        for (int i=0; i < id_answers.length; i++){

            RadioButton rb = (RadioButton) findViewById(id_answers[i]);
            rb.setText(answers[i]);
        }
        final int var_correct_answer = getResources().getInteger(R.integer.correct_answer);

        final RadioGroup group = (RadioGroup) findViewById(R.id.Group_answers);


        Button var_btn_check = (Button) findViewById(R.id.btn_check);
        var_btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Log.i("Marta dice que","btn_check ok");
                int id = group.getCheckedRadioButtonId();
                int answer = -1;

                for (int i=0; i<id_answers.length; i++){
                    if (id_answers[i] == id ){
                        answer=i;
                    }
                }
                //   Log.i("Boton", String.format("Id: %d", index));

                if (answer == var_correct_answer){
                    Toast.makeText(QuizActivity.this, getResources().getString(R.string.OK), Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(QuizActivity.this, getResources().getString(R.string.FAIL), Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
