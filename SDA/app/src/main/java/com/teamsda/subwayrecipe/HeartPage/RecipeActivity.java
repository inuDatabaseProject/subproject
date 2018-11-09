package com.teamsda.subwayrecipe.HeartPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.teamsda.subwayrecipe.MainActivity;
import com.teamsda.subwayrecipe.R;

public class RecipeActivity extends AppCompatActivity {

    TextView recipe_title,recipe_ingredients,recipe_score;
    String st_title,st_ingredients,st_score;
    Button recipe_back,recipe_save,recipe_smart,recipe_qr;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recipe_title = (TextView)findViewById(R.id.recipe_title);
        recipe_ingredients = (TextView)findViewById(R.id.recipe_ingredients);
        recipe_score = (TextView)findViewById(R.id.recipe_score);

        Intent recipe_intent = getIntent();
        st_title = recipe_intent.getStringExtra("title");
        st_ingredients = recipe_intent.getStringExtra("ingredients");
        st_score = recipe_intent.getStringExtra("score");

        recipe_title.setText(st_title);
        recipe_ingredients.setText(st_ingredients);
        recipe_score.setText(st_score);

        recipe_back = (Button)findViewById(R.id.recipe_back);
        recipe_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent refresh_intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(refresh_intent);
                finish();
            }
        });
        recipe_save = (Button)findViewById(R.id.recipe_save);
        recipe_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"저장되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });

        recipe_smart = (Button)findViewById(R.id.recipe_smart);
        recipe_smart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"스마트오더.",Toast.LENGTH_SHORT).show();
            }
        });

        recipe_qr = (Button)findViewById(R.id.recipe_qr);
        recipe_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"qr코드 오더.",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent refresh_intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(refresh_intent);
        finish();
    }
}