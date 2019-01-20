package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * 作业1：
 * Logcat在屏幕旋转的时候 #onStop() #onDestroy()会展示出来
 * 但我们的 mLifecycleDisplay 由于生命周期的原因(Tips:执行#onStop()之后，UI界面我们是看不到的)并没有展示
 * 在原有@see Exercises1 基础上如何补全它，让其跟logcat的展示一样?
 * <p>
 * Tips：思考用比Activity的生命周期要长的来存储？  （比如：application、static变量）
 */
public class Exercises1 extends AppCompatActivity {

    public TextView textView;
    public Bundle outState;

    final String TAG = "Exercises1";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises1);
        textView = findViewById(R.id.textView);
        if(savedInstanceState != null)
            textView.append(savedInstanceState.getString(TAG));
        textView.append("onCreate\n");
        Log.i(TAG,"onCreate\n");
    }

    @Override
    protected void onStart() {
        super.onStart();
        textView.append("onStart\n");
        Log.i(TAG,"onStart\n");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        textView.append("onSaveInstanceState\n");
        Log.i(TAG,"onSaveInstanceState\n");;
        outState.putString(TAG,textView.getText().toString());
        this.outState = outState;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textView.append("onDestroy\n");
        Log.i(TAG,"onDestroy\n");
        if(outState!=null)
            outState.putString(TAG,outState.get(TAG)+"onDestroy\n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        textView.append("onStop\n");
        Log.i(TAG,"onStop\n");
        if(outState!=null)
            outState.putString(TAG,outState.get(TAG)+"onStop\n");
    }

    @Override
    protected void onPause() {
        super.onPause();
        textView.append("onPause\n");
        Log.i(TAG,"onPause\n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        textView.append("onResume\n");
        Log.i(TAG,"onResume\n");
    }
}
