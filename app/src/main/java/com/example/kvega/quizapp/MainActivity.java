package com.example.kvega.quizapp;

import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.view.View;
import android.widget.TextView;
import android.graphics.Color;
import android.text.Editable;

public class MainActivity extends AppCompatActivity {
    // Create global variable to store quiz score
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Methods which check whether a question is answered correctly
    // If a question is answered correctly, these methods increment score
    // if answer is correct and set question text color GREEN, if incorrect,
    // question text becomes RED.
    public void checkQuestion1() {
        TextView q1 = ((TextView) findViewById(R.id.question1));
        boolean a11 = ((CheckBox) findViewById(R.id.answer11)).isChecked();
        boolean a12 = ((CheckBox) findViewById(R.id.answer12)).isChecked();
        boolean a13 = ((CheckBox) findViewById(R.id.answer13)).isChecked();
        boolean a14 = ((CheckBox) findViewById(R.id.answer14)).isChecked();
        if (!a11 && a12 && a13 && !a14) {
            score = score + 1;
            q1.setTextColor(Color.parseColor("#388E3C"));
        } else {
            q1.setTextColor(Color.RED);
        }
    }
    public void checkQuestion2() {
        TextView q2 = ((TextView) findViewById(R.id.question2));
        boolean a21 = ((CheckBox) findViewById(R.id.answer21)).isChecked();
        boolean a22 = ((CheckBox) findViewById(R.id.answer22)).isChecked();
        boolean a23 = ((CheckBox) findViewById(R.id.answer23)).isChecked();
        boolean a24 = ((CheckBox) findViewById(R.id.answer24)).isChecked();
        if (a21 && a22 && !a23 && a24) {
            score = score + 1;
            q2.setTextColor(Color.parseColor("#388E3C"));
        } else {
            q2.setTextColor(Color.RED);
        }
    }
    public void checkQuestion3() {
        TextView q3 = ((TextView) findViewById(R.id.question3));
        boolean a31 = ((RadioButton) findViewById(R.id.answer31)).isChecked();
        if (a31) {
            score = score + 1;
            q3.setTextColor(Color.parseColor("#388E3C"));
        } else {
            q3.setTextColor(Color.RED);
        }
    }
    public void checkQuestion4() {
        TextView q4 = ((TextView) findViewById(R.id.question4));
        boolean a43 = ((RadioButton) findViewById(R.id.answer43)).isChecked();
        if (a43) {
            score = score + 1;
            q4.setTextColor(Color.parseColor("#388E3C"));
        } else {
            q4.setTextColor(Color.RED);
        }
    }
    public void checkQuestion5() {
        TextView q5 = ((TextView) findViewById(R.id.question5));
        Editable a53Editable = ((EditText) findViewById(R.id.answer5)).getText();
        String a53 = a53Editable.toString().toLowerCase().replaceAll("\\s+","");
        if (a53.equals("neptune")) {
            score = score + 1;
            q5.setTextColor(Color.parseColor("#388E3C"));
        } else {
            q5.setTextColor(Color.RED);
        }
    }
    // This method resets the state of the quiz
    // It unchecks all radio buttons and checkboxes, clears the text field and
    // sets the score = 0
    public void reset(View view) {
        TextView q1 = ((TextView) findViewById(R.id.question1));
        TextView q2 = ((TextView) findViewById(R.id.question2));
        TextView q3 = ((TextView) findViewById(R.id.question3));
        TextView q4 = ((TextView) findViewById(R.id.question4));
        TextView q5 = ((TextView) findViewById(R.id.question5));
        RadioGroup q3radioGroup = (RadioGroup)findViewById(R.id.q3radiogroup);
        RadioGroup q4radioGroup = (RadioGroup)findViewById(R.id.q4radiogroup);
        CheckBox a11checkbox = ((CheckBox) findViewById(R.id.answer11));
        CheckBox a12checkbox = ((CheckBox) findViewById(R.id.answer12));
        CheckBox a13checkbox = ((CheckBox) findViewById(R.id.answer13));
        CheckBox a14checkbox = ((CheckBox) findViewById(R.id.answer14));
        CheckBox a21checkbox = ((CheckBox) findViewById(R.id.answer21));
        CheckBox a22checkbox = ((CheckBox) findViewById(R.id.answer22));
        CheckBox a23checkbox = ((CheckBox) findViewById(R.id.answer23));
        CheckBox a24checkbox = ((CheckBox) findViewById(R.id.answer24));
        EditText a5textField = ((EditText) findViewById(R.id.answer5));
        // Reset question text color
        q1.setTextColor(Color.BLACK);
        q2.setTextColor(Color.BLACK);
        q3.setTextColor(Color.BLACK);
        q4.setTextColor(Color.BLACK);
        q5.setTextColor(Color.BLACK);
        // Uncheck radio buttons
        q3radioGroup.clearCheck();
        q4radioGroup.clearCheck();
        // Uncheck checkboxes
        a11checkbox.setChecked(false);
        a12checkbox.setChecked(false);
        a13checkbox.setChecked(false);
        a14checkbox.setChecked(false);
        a21checkbox.setChecked(false);
        a22checkbox.setChecked(false);
        a23checkbox.setChecked(false);
        a24checkbox.setChecked(false);
        // Clear text field
        a5textField.setText("");
        // Clear score
        score = 0;
    }
    // Runs the checkQuestion methods and displays the score, then sets score = 0.
    // It does not reset responses so as to allow user to see what answers they have
    // already given
    public void submitAnswers(View view) {
        checkQuestion1();
        checkQuestion2();
        checkQuestion3();
        checkQuestion4();
        checkQuestion5();
        Toast.makeText(MainActivity.this, "Your score is: " + score + "/5",
                Toast.LENGTH_LONG).show();
        // Resets score = 0 after answers are submitted to prevent a correct answer to be
        // counted multiple times.
        score = 0;
    }
}
