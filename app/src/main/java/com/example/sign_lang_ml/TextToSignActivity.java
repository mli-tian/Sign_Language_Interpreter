package com.example.sign_lang_ml;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.speech.RecognizerIntent;
import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Collections;

import java.util.HashMap;
import java.util.*;

public class TextToSignActivity extends AppCompatActivity {

    private SpeechRecognizer speechRecognizer;
    private Intent speechRecognizerIntent;
    private boolean isListening = false;
    ArrayList<String> buff_data = new ArrayList<>();
    ArrayList<String> res_data = new ArrayList<>();

    private Handler handler = new Handler();
    private Runnable runnable;

    private String text = "";
    private String img = "space";
    private String ext = ".png";
    private String path = "assets/letters/";
    private String displayText = "Press the button and start speaking...";
    private int state = 0;

    EditText speech_text;
    ImageView webView;
    TextView test;

    HashMap<String, String> Words = new HashMap<String,String>();
    List<Character> letters = new ArrayList<Character>();
    List<String> hello = new ArrayList<String>();
    List<String> you = new ArrayList<String>();


    RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE);
    private static final int RECORD_AUDIO_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_sign);

        speech_text = findViewById(R.id.speechedittext);
        webView = findViewById(R.id.signview);;
        test = findViewById(R.id.text);

        Glide.with(this)
                .load("file:///android_asset/ISL_Gifs/hello.gif")
                .apply(options)
                .into(webView);

        buff_data.add("hello");
        translation(buff_data);

        Words.put("hello", "2640");
        Words.put("you", "3200");
        Words.put("good", "2640");
        Words.put("morning", "3080");
        Collections.addAll(letters,'a','b','c','d','e','f','g','h',
                'i','j','k','l','m','n','o','p','q', 'r','s','t','u','v','w','x','y','z',
                '0','1','2','3','4','5','6','7','8','9');
        Collections.addAll(hello,"hello", "hey", "hi", "hii", "hay");
        Collections.addAll(you,"you", "your", "your's");

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        speech_text.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    buff_data.remove(0);
                    buff_data.add(speech_text.getText().toString());
                    translation1(buff_data);
                    return true;
                }
                return false;
            }

        });

        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {
            }

            @Override
            public void onBeginningOfSpeech() {
            }

            @Override
            public void onRmsChanged(float rmsdB) {
            }

            @Override
            public void onBufferReceived(byte[] buffer) {
            }

            @Override
            public void onEndOfSpeech() {
            }

            @Override
            public void onError(int error) {
            }

            @Override
            public void onResults(Bundle results) {
                ArrayList<String> data =results.getStringArrayList(speechRecognizer.RESULTS_RECOGNITION);
                speech_text.setText(data.get(0));
                translation(data);
            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });
    }

    private ArrayList translation(ArrayList<String> data) {
        String text=data.get(0);

        String speechStr = text.toLowerCase();
        String[] strArray = speechStr.split(" ");
        ArrayList<String> resArray = new ArrayList<>();

        HashMap<String, String> Words = new HashMap<String,String>();
        Words.put("hello", "2640");
        Words.put("you", "3200");
        Words.put("good", "2640");
        Words.put("morning", "3080");

        List<Character> letters = new ArrayList<Character>();
        Collections.addAll(letters,'a','b','c','d','e','f','g','h',
                'i','j','k','l','m','n','o','p','q', 'r','s','t','u','v','w','x','y','z',
                '0','1','2','3','4','5','6','7','8','9');

        List<String> hello = new ArrayList<String>();
        Collections.addAll(hello,"hello", "hey", "hi", "hii", "hay");

        List<String> you = new ArrayList<String>();
        Collections.addAll(you,"you", "your", "your's");

        for (String content : strArray) {
            boolean flag_words = false;
            String word = "";
            Iterator<Map.Entry<String, String>> iterator = Words.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                word = entry.getKey();
                if (word.equals(content)) {
                    flag_words = true;
                    break;
                }
            }
            if (flag_words) {
                resArray.add(content);
            } else {
                if (hello.indexOf(content) != -1) {
                    resArray.add("hello");
                }else if(you.indexOf(content) != -1){
                    resArray.add("you");
                }else{
                    for (int j = 0; j < content.length(); j++) {
                        char letter = content.charAt(j);
                        if (letters.indexOf(letter) != -1) {
                            resArray.add(String.valueOf(letter));
                        } else {
                            resArray.add("space");
                        }
                    }
                }
            }
            resArray.add("space");
        }
        return resArray;
    }

    private void translation1(ArrayList<String> data) {

        String text=data.get(0);

        String displayText = "";
        String speechStr = text.toLowerCase();
        String[] strArray = speechStr.split(" ");

        HashMap<String, String> Words = new HashMap<String,String>();
        Words.put("hello", "2640");
        Words.put("you", "3200");
        Words.put("good", "2640");
        Words.put("morning", "3080");

        List<Character> letters = new ArrayList<Character>();
        Collections.addAll(letters,'a','b','c','d','e','f','g','h',
                'i','j','k','l','m','n','o','p','q', 'r','s','t','u','v','w','x','y','z',
                '0','1','2','3','4','5','6','7','8','9');

        List<String> auxVerbs = new ArrayList<String>();
        Collections.addAll(auxVerbs, "has", "have", "had", "does", "do", "did",
                "is", "are", "be", "am", "was", "were", "being", "been",
                "can", "could", "will", "would", "shall", "should",
                "may", "might", "must");

        List<String> hello = new ArrayList<String>();
        Collections.addAll(hello,"hello", "hey", "hi", "hii", "hay");

        List<String> you = new ArrayList<String>();
        Collections.addAll(you,"you", "your", "your's");

        for (String content : strArray) {

            boolean flag_words = false;
            int duration = 0;
            String word = "";
            Iterator<Map.Entry<String, String>> iterator = Words.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                word = entry.getKey();
                if (word.equals(content)) {
                    flag_words = true;
                    duration = Integer.parseInt(Words.get(word));
                    break;
                }
            }

            String file = content;
            String path = "";
            String ext =".png";

            if (flag_words) {
                displayText += file;
                path = "ISL_Gifs/";
                ext = ".gif";
                setState(file, path, duration, ext);

            } else {
                if (hello.indexOf(file) != -1) {
                    file = "hello";
                    duration = Integer.parseInt(Words.get("hello"));
                    displayText += file;
                    path = "ISL_Gifs/";
                    ext = ".gif";
                    setState(file, path, duration, ext);

                } else if (you.indexOf(file) != -1) {
                    file = "you";
                    duration = Integer.parseInt(Words.get("you"));
                    displayText += file;
                    path = "ISL_Gifs/";
                    ext = ".gif";
                    setState(file, path, duration, ext);

                } else {
                    for (int i = 0; i < content.length(); i++) {
                        char letter = content.charAt(i);
                        if (letters.indexOf(letter) != -1) {
                            path = "letters/";
                            displayText += file;
                            ext = ".png";
                            setState(String.valueOf(letter), path,1500,ext);

                        } else {
                            path = "letters/";
                            setState("space", path,1500,".png");

                        }
                    }
                }
            }


        }
    }

    private void setState(String file, String path, int duration, String ext) {
        String  url = "file:///android_asset/"+path+file+ext;
        Glide.with(this)
                .load(url)
                .apply(options)
                .into(webView);

    }
}