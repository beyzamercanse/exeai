package com.example.exeai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.exeai.databinding.ActivityRpsBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final Random random = new Random();
    private ActivityRpsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRpsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonPaper.setOnClickListener(v -> game("보"));
        binding.buttonRock.setOnClickListener(v -> game("바위"));
        binding.buttonScissor.setOnClickListener(v -> game("가위"));
    }

    private void game(String yourChoice) {
        int ai = random.nextInt(3);
        String aiChoice;
        switch (ai) {
            case 0:
                aiChoice = "가위";
                break;
            case 1:
                aiChoice = "바위";
                break;
            default:
                aiChoice = "보";
        }

        binding.textAi.setText("AI가 " + aiChoice + "를 냈습니다.");
        binding.textYou.setText("당신을 " + yourChoice + "를 냈습니다.");

        String result;
        if (aiChoice.equals(yourChoice)) {
            result = "비겼습니다!";
        } else if ((aiChoice.equals("가위") && yourChoice.equals("바위")) ||
                (aiChoice.equals("바위") && yourChoice.equals("보")) ||
                (aiChoice.equals("보") && yourChoice.equals("가위"))) {
            result = "축하합니다!! YOU WON!";
        } else {
            result = "미안합니다... YOU LOST!";
        }
        binding.textResults.setText(result);
    }
}