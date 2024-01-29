package com.example.sign_lang_ml;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Objects;
import androidx.appcompat.app.AppCompatActivity;

public class LearningBounceActivity extends AppCompatActivity {
    ListView listview;
    TextView learning_title;
    TextView learning_textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_bounce);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {

            if (Objects.requireNonNull(bundle.getString("ClassName")).equalsIgnoreCase("汉语手指字母指示")) {

                listview = findViewById(R.id.list_view);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(LearningBounceActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.letters));

                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(LearningBounceActivity.this, LearningLettersActivity.class);
                        intent.putExtra("LetterName", listview.getItemAtPosition(i).toString());
                        startActivity(intent);
                    }
                });
                listview.setAdapter(adapter);
            }
            if (Objects.requireNonNull(bundle.getString("ClassName")).equalsIgnoreCase("常见词汇")) {
                learning_title=findViewById(R.id.learning_title);
                learning_title.setText("手指词汇方案");
                learning_textView=findViewById(R.id.learning_textView);
                learning_textView.setText("点击词汇进行学习");
                listview = findViewById(R.id.list_view);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(LearningBounceActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.words));

                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(LearningBounceActivity.this, LearningLettersActivity.class);
                        intent.putExtra("VideoName", listview.getItemAtPosition(i).toString());
                        startActivity(intent);
                    }
                });
                listview.setAdapter(adapter);
            }
            if (Objects.requireNonNull(bundle.getString("ClassName")).equalsIgnoreCase("使用规则")) {
                listview = findViewById(R.id.list_view);
                learning_title=findViewById(R.id.learning_title);
                learning_title.setText("手指语言规则");
                learning_textView=findViewById(R.id.learning_textView);
                learning_textView.setText("");
                ArrayAdapter<String> adapter = new ArrayAdapter<>(LearningBounceActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.rules));

                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(LearningBounceActivity.this, LearningLettersActivity.class);
                        intent.putExtra("RuleName", listview.getItemAtPosition(i).toString());
                        startActivity(intent);
                    }
                });
                listview.setAdapter(adapter);
            }

        }
    }
}