package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises2);
        View countview = findViewById(R.id.countview);
        Log.i("myonlylog",getAllChildViewCount(countview)+"");

    }

    public int getAllChildViewCount(View view) {
        //todo 补全你的代码
        if (view instanceof ViewGroup) {
            int cnt = 0;
            for(int i = 0;i<((ViewGroup) view).getChildCount();i++){
                cnt += getAllChildViewCount(((ViewGroup) view).getChildAt(i));
            }
            return cnt;
        }
        else
            return 1;
    }
}
