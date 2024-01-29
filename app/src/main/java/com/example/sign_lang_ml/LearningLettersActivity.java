package com.example.sign_lang_ml;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Objects;

public class LearningLettersActivity extends AppCompatActivity {

    ImageView letter;
    TextView letter_text;
    VideoView letter_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();


        if (bundle != null) {
            if (bundle.getString("VideoName")!=null){
                setContentView(R.layout.activity_learning_words);
                letter_video=findViewById(R.id.letter_video);
                if (Objects.requireNonNull(bundle.getString("VideoName")).equalsIgnoreCase("付款")) {
                    letter_video.setMediaController(new MediaController(this));
                    letter_video.setVideoURI(Uri.parse("https://media.spreadthesign.com/video/mp4/35/379805.mp4"));
                    letter_video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            // 当视频开始加载时，移除背景
                            letter_video.setBackground(null);
                        }
                    });
                    letter_video.start();

                }
            }
            if(bundle.getString("LetterName")!=null){
                setContentView(R.layout.activity_learning_letters);
                letter = findViewById(R.id.letter_view);
                letter_text=findViewById(R.id.letter_text);
                if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("A")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.a));
                    letter_text.setText("右手伸拇指，指尖朝上，食、中、无名、小指弯曲，指尖抵于掌心，手背向右");
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("B")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.b));
                    letter_text.setText("右手拇指向掌心弯曲，食、中、无名、小指并拢直立，掌心向前偏左。");
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("C")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.c));
                    letter_text.setText("右手拇指向上弯曲，食、中、无名、小指并拢向下弯曲，指尖相对成C形，虎口朝内。");
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("D")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.d));
                    letter_text.setText("右手握拳，拇指搭在中指中节指上，虎口朝后上方。");
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("E")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.e));
                    letter_text.setText("右手拇、食指搭成圆形，中、无名、小指横伸，稍分开，指尖朝左，手背向外。");
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("F")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.f));
                    letter_text.setText("右手食、中指横伸，稍分开，指尖朝左，拇、无名、小指弯曲，拇指搭在无名指远节指上，手背向外。");
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("G")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.g));
                    letter_text.setText("右手食指横伸，指尖朝左，中、无名、小指弯曲，指尖抵于掌心，拇指搭在中指中节指上，手背向外。");
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("H")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.h));
                    letter_text.setText("");
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("I")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.i));
                    letter_text.setText("");
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("J")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.j));
                    letter_text.setText("");
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("K")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.k));
                    letter_text.setText("");
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("L")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.l));
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("M")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.m));
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("N")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.n));
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("O")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.o));
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("P")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.p));
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("Q")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.q));
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("R")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.r));
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("S")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.s));
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("T")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.t));
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("U")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.u));
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("V")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.v));
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("W")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.w));
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("X")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.x));
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("Y")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.y));
                } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("Z")) {
                    letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.z));
                }
            }


        }
        if(bundle.getString("RuleName")!=null){
            setContentView(R.layout.activity_learning_letters);
            letter = findViewById(R.id.letter_view);
            letter_text=findViewById(R.id.letter_text);
            if (Objects.requireNonNull(bundle.getString("RuleName")).equalsIgnoreCase("付款")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.a));
                letter_text.setText("右手伸拇指，指尖朝上，食、中、无名、小指弯曲，指尖抵于掌心，手背向右");
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("B")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.b));
                letter_text.setText("右手拇指向掌心弯曲，食、中、无名、小指并拢直立，掌心向前偏左。");
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("C")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.c));
                letter_text.setText("右手拇指向上弯曲，食、中、无名、小指并拢向下弯曲，指尖相对成C形，虎口朝内。");
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("D")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.d));
                letter_text.setText("右手握拳，拇指搭在中指中节指上，虎口朝后上方。");
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("E")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.e));
                letter_text.setText("右手拇、食指搭成圆形，中、无名、小指横伸，稍分开，指尖朝左，手背向外。");
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("F")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.f));
                letter_text.setText("右手食、中指横伸，稍分开，指尖朝左，拇、无名、小指弯曲，拇指搭在无名指远节指上，手背向外。");
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("G")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.g));
                letter_text.setText("右手食指横伸，指尖朝左，中、无名、小指弯曲，指尖抵于掌心，拇指搭在中指中节指上，手背向外。");
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("H")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.h));
                letter_text.setText("");
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("I")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.i));
                letter_text.setText("");
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("J")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.j));
                letter_text.setText("");
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("K")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.k));
                letter_text.setText("");
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("L")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.l));
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("M")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.m));
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("N")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.n));
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("O")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.o));
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("P")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.p));
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("Q")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.q));
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("R")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.r));
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("S")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.s));
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("T")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.t));
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("U")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.u));
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("V")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.v));
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("W")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.w));
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("X")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.x));
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("Y")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.y));
            } else if (Objects.requireNonNull(bundle.getString("LetterName")).equalsIgnoreCase("Z")) {
                letter.setImageDrawable(ContextCompat.getDrawable(LearningLettersActivity.this, R.drawable.z));
            }
        }


    }

}
