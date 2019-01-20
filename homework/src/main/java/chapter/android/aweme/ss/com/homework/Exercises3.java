package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import java.io.InputStream;
import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        try{
            InputStream assetInput = getAssets().open("data.xml");
            List<Message> messages = PullParser.pull2xml(assetInput);
            RecyclerView recyclerView = findViewById(R.id.rv_list);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
            MyAdapter myAdapter = new MyAdapter(messages);
            recyclerView.setAdapter(myAdapter);

            MyAdapter.ListItemClickListener listener = new MyAdapter.ListItemClickListener() {
                @Override
                public void onListItemClick(int clickedItemIndex) {
                    Intent intent = new Intent();
                    intent.setClass(Exercises3.this,Chatroom.class);
                    startActivity(intent);
                }
            };
            myAdapter.setListItemClickListener(listener);




        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void ListItemClickListener(){

    }


}
