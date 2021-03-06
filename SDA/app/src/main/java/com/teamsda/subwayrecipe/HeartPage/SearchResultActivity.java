package com.teamsda.subwayrecipe.HeartPage;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.teamsda.subwayrecipe.Custom.HeartCustomAdapter;
import com.teamsda.subwayrecipe.Custom.IngredientsClass;
import com.teamsda.subwayrecipe.Custom.RecipeClass;
import com.teamsda.subwayrecipe.MainActivity;
import com.teamsda.subwayrecipe.R;

import java.util.ArrayList;

public class SearchResultActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<RecipeClass> mRecipeArr;
    private HeartCustomAdapter mAdapter;
    RecipeClass ForRecipe;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresult);

        Intent search_intent = getIntent();
        String bread = search_intent.getStringExtra("bread");
        String st_veg = search_intent.getStringExtra("veg");
        String st_cheese = search_intent.getStringExtra("cheese");
        String st_sauce = search_intent.getStringExtra("sauce");

        String[] veg = st_veg.split(",");
        String[] cheese = st_cheese.split(",");
        String[] sauce = st_sauce.split(",");

        Button back = (Button)findViewById(R.id.searchresult_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mListView = (ListView) findViewById(R.id.listView_heart);
        mRecipeArr = new ArrayList<RecipeClass>();

        mRecipeArr.clear();
        //테스트용 하드코딩
        Drawable drawable1 = getResources().getDrawable(R.drawable.bread1);
        Drawable drawable2 = getResources().getDrawable(R.drawable.bread2);
        Drawable drawable3 = getResources().getDrawable(R.drawable.bread3);
        Drawable drawable4 = getResources().getDrawable(R.drawable.bread4);

        ArrayList<String> veg1 = new ArrayList<String>();
        veg1.add("토마토");
        veg1.add("피클");
        veg1.add("양상추");
        ArrayList<String> cheese1 = new ArrayList<String>();
        cheese1.add("아메리칸 치즈");
        ArrayList<String> sauce1 = new ArrayList<String>();
        sauce1.add("렌치");

        ArrayList<String> veg2 = new ArrayList<String>();
        veg2.add("할라피뇨");
        veg2.add("오이");
        veg2.add("올리브");
        ArrayList<String> cheese2 = new ArrayList<String>();
        cheese2.add("슈레드 치즈");
        ArrayList<String> sauce2 = new ArrayList<String>();
        sauce2.add("허니 머스타드");

        IngredientsClass ingredientsClass1 = new IngredientsClass("허니오트",veg1,cheese1,sauce1);
        IngredientsClass ingredientsClass2 = new IngredientsClass("허니오트",veg2,cheese2,sauce2);
        IngredientsClass ingredientsClass3 = new IngredientsClass("플랫브래드",veg1,cheese1,sauce1);
        IngredientsClass ingredientsClass4 = new IngredientsClass("플랫브래드",veg2,cheese2,sauce2);

        RecipeClass recipeClass1 = new RecipeClass(drawable1,1,"이탈리안 BMT",ingredientsClass1, "1000");
        RecipeClass recipeClass2 = new RecipeClass(drawable2,2,"이탈리안 BMT",ingredientsClass2, "999");
        RecipeClass recipeClass3 = new RecipeClass(drawable3,3,"이탈리안 BMT",ingredientsClass3, "998");
        RecipeClass recipeClass4 = new RecipeClass(drawable4,4,"이탈리안 BMT",ingredientsClass4, "997");
        RecipeClass recipeClass5 = new RecipeClass(drawable1,5,"이탈리안 BMT",ingredientsClass1, "996");
        RecipeClass recipeClass6 = new RecipeClass(drawable2,6,"이탈리안 BMT",ingredientsClass2, "995");
        RecipeClass recipeClass7 = new RecipeClass(drawable3,7,"이탈리안 BMT",ingredientsClass3, "994");
        RecipeClass recipeClass8 = new RecipeClass(drawable4,8,"이탈리안 BMT",ingredientsClass4, "993");

        mRecipeArr.add(recipeClass1);
        mRecipeArr.add(recipeClass2);
        mRecipeArr.add(recipeClass3);
        mRecipeArr.add(recipeClass4);
        mRecipeArr.add(recipeClass5);
        mRecipeArr.add(recipeClass6);
        mRecipeArr.add(recipeClass7);
        mRecipeArr.add(recipeClass8);

        //라디오 버튼 부분 수정
        //빵
        for(int i=0;i<mRecipeArr.size();i++) {
            if (mRecipeArr.size() == 0)
                break;
            if (!mRecipeArr.get(i).getIngredientsClass().getBread().equals(bread)) {
                if (mRecipeArr.size() == 0)
                    break;
                mRecipeArr.remove(i);
                i = 0;
            }
            for(int j=0;j<veg.length;j++){
                if(mRecipeArr.size()==0)
                    break;
                if (!mRecipeArr.get(i).getIngredientsClass().getVeg().toString().contains(veg[j])) {
                    mRecipeArr.remove(i);
                    i=0;
                }
            }
            for(int j=0;j<cheese.length;j++){
                if(mRecipeArr.size()==0)
                    break;
                if (!mRecipeArr.get(i).getIngredientsClass().getCheese().toString().contains(cheese[j])) {
                    mRecipeArr.remove(i);
                    i=0;
                }
            }
            for(int j=0;j<sauce.length;j++){
                if(mRecipeArr.size()==0)
                    break;
                if (!mRecipeArr.get(i).getIngredientsClass().getSauce().toString().contains(sauce[j])) {
                    mRecipeArr.remove(i);
                    i=0;
                }
            }
        }

        //작업이 빨라서 그런지 꼭 남는 게 생김 그래서 임의로 2번 돌림
        {
            for(int i=0;i<mRecipeArr.size();i++) {
                if (mRecipeArr.size() == 0)
                    break;
                if (!mRecipeArr.get(i).getIngredientsClass().getBread().equals(bread)) {
                    if (mRecipeArr.size() == 0)
                        break;
                    mRecipeArr.remove(i);
                    i = 0;
                }
                for(int j=0;j<veg.length;j++){
                    if(mRecipeArr.size()==0)
                        break;
                    if (!mRecipeArr.get(i).getIngredientsClass().getVeg().toString().contains(veg[j])) {
                        mRecipeArr.remove(i);
                        i=0;
                    }
                }
                for(int j=0;j<cheese.length;j++){
                    if(mRecipeArr.size()==0)
                        break;
                    if (!mRecipeArr.get(i).getIngredientsClass().getCheese().toString().contains(cheese[j])) {
                        mRecipeArr.remove(i);
                        i=0;
                    }
                }
                for(int j=0;j<sauce.length;j++){
                    if(mRecipeArr.size()==0)
                        break;
                    if (!mRecipeArr.get(i).getIngredientsClass().getSauce().toString().contains(sauce[j])) {
                        mRecipeArr.remove(i);
                        i=0;
                    }
                }
            }
        }

        mAdapter = new HeartCustomAdapter(getApplication(), mRecipeArr);
        mListView.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();
        mListView.setSelection(0);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                ForRecipe = mRecipeArr.get(position);

                Intent recipe_intent = new Intent(getApplicationContext(), RecipeActivity.class);
                recipe_intent.putExtra("where","Result");
                recipe_intent.putExtra("mark","♥");
                recipe_intent.putExtra("position",ForRecipe.getPosition());
                recipe_intent.putExtra("title", ForRecipe.getTitle());
                recipe_intent.putExtra("ingredients", ForRecipe.getIngredientsClass().getIngredients());
                recipe_intent.putExtra("score", ForRecipe.getScore());

                startActivity(recipe_intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
