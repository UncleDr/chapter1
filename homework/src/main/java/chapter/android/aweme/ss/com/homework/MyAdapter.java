package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import android.graphics.drawable.Icon;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Message> mData;
    ListItemClickListener listener;

    public MyAdapter(List<Message> data){
        mData=data;
        //mOnClickListener = listener;
        //List<Message> data,
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.im_list_item, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        Message message = mData.get(i);
        MyViewHolder viewHolder= (MyViewHolder) myViewHolder;
        myViewHolder.updateUI(message,i);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onListItemClick(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class  MyViewHolder extends RecyclerView.ViewHolder{
        private final TextView tv_title;
        private final CircleImageView iv_avatar;
        private final TextView tv_description;
        private final ImageView robot_notice;
        private final TextView tv_time;
        Button itemButton;
        View itemView;


        public void updateUI(Message message,int i){
            //更新的是内容

            switch (message.getIcon()){
                case "TYPE_ROBOT":
                    iv_avatar.setImageResource(R.drawable.session_robot);
                    robot_notice.setVisibility(View.VISIBLE);
                    robot_notice.setImageResource(R.drawable.im_icon_notice_official);
                    break;
                case "TYPE_GAME":
                    iv_avatar.setImageResource(R.drawable.icon_micro_game_comment);
                    robot_notice.setVisibility(View.VISIBLE);
                    robot_notice.setImageResource(R.drawable.im_icon_notice_official);
                    break;
                case "TYPE_SYSTEM":
                    iv_avatar.setImageResource(R.drawable.session_system_notice);
                    robot_notice.setVisibility(View.VISIBLE);
                    robot_notice.setImageResource(R.drawable.im_icon_notice_official);
                    break;
                case "TYPE_STRANGER":
                    iv_avatar.setImageResource(R.drawable.session_stranger);
                    robot_notice.setVisibility(View.INVISIBLE);
                    break;
                case "TYPE_USER":
                    iv_avatar.setImageResource(R.drawable.icon_girl);
                    robot_notice.setVisibility(View.INVISIBLE);
                    break;
            }


            tv_title.setText(message.getTitle());
            tv_description.setText(message.getDescription());
            tv_time.setText(message.getTime());

        }
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv_title=itemView.findViewById(R.id.tv_title);
            iv_avatar = itemView.findViewById(R.id.iv_avatar);
            tv_description = itemView.findViewById(R.id.tv_description);
            robot_notice = itemView.findViewById(R.id.robot_notice);
            tv_time = itemView.findViewById(R.id.tv_time);
        }
    }
    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }


    public void setListItemClickListener( MyAdapter.ListItemClickListener listener){
        this.listener = listener;
    }

}
