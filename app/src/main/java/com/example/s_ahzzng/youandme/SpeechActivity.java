package com.example.s_ahzzng.youandme;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public abstract class SpeechActivity extends Activity {
    Intent i = null;
    Context context = null;
    RecognitionListener listener = null;
    SpeechRecognizer mRecognizer = null;
    public void initSpeech(Context context) {
        i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, context.getPackageName());
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        listener = getRecognitionListner();
        mRecognizer = SpeechRecognizer.createSpeechRecognizer(context);
        mRecognizer.setRecognitionListener(listener);
    }

    public void startSpeech() {
        try {
            mRecognizer.startListening(i);
            Log.d("pig", "Start Listen");
        }

        catch (Exception e) {
            e.printStackTrace();
            Log.d("pig", "catch : " + e.toString());
        }
    }

    private RecognitionListener getRecognitionListner() {
        listener = new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {
                Log.d("pig", "onReadyForSpeech");
            }

            @Override
            public void onBeginningOfSpeech() {
                Log.d("pig", "onBeginningOfSpeech");

            }

            @Override
            public void onRmsChanged(float rmsdB) {
                Log.d("pig", "onRmsChanged");

            }

            @Override
            public void onBufferReceived(byte[] buffer) {
                Log.d("pig", "bufferRe");

            }

            @Override
            public void onEndOfSpeech() {
                Log.d("pig", "onEndOfSpeech");
            }

            @Override
            public void onError(int error) {
                Log.d("pig", "onError : " + error);
                if(error == 7) {
                    onSmallVoice();
                }
            }

            @Override
            public void onResults(Bundle results) {
                Log.d("pig", "Get Result");

                Bundle data = results;
                if(data != null) {
                    ArrayList<String> result = data
                            .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                    String words = result.get(0);
                    onSpeech(words);
                }
            }

            @Override
            public void onPartialResults(Bundle partialResults) {
                ArrayList<String> result = partialResults
                        .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                Log.d("pig", "onPartialResults : " + result.get(0));
            }

            @Override
            public void onEvent(int eventType, Bundle params) {
                Log.d("pig", "eventType : " + eventType);
            }
        };

        return listener;
    }

    abstract void onSpeech(String result);
    abstract void onSmallVoice();
}
