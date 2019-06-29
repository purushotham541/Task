package com.example.task;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

class ChecklistAdapeter extends RecyclerView.Adapter<ChecklistAdapeter.ViewHolder>
{
    private static final String TAG = "ChecklistAdapeter";
    private Context context;

    private List<Checklist_Model> list;

    public ChecklistAdapeter(Context context, List<Checklist_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ChecklistAdapeter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.checklist_item,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChecklistAdapeter.ViewHolder viewHolder, int i)
    {

        viewHolder.item_name.setText(list.get(i).getName());



        viewHolder.setItemClickListener(new OnItemClickListener()
        {
            @Override
            public View onItemClick(View view, int position)
            {
                //ImageButton imageButton=(ImageButton)view;
                //Log.d(TAG, "onItemClick: ImageButton"+position);
                int id=view.getId();
                ImageButton imageButton = (ImageButton) view;

                switch (id) {
                    case R.id.attach:

                        Log.d(TAG, "onItemClick: ImageButton Attach" + position);
                        break;

                    case R.id.comments:


                        Log.d(TAG, "onItemClick: ImageButton Comments" + position);
                        break;





                }
                return imageButton;


            }
        });
        viewHolder.setItemCheckListner(new OnItemCheckListener() {
            @Override
            public boolean onItemCheck(CompoundButton compoundButton, int position, Boolean isChecked) {
               CheckBox checkBox=(CheckBox) compoundButton;
               if(checkBox.isChecked())
               {
                   Log.d(TAG, "onItemCheck: "+position);
               }
                return true;
            }
        });





    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener ,CompoundButton.OnCheckedChangeListener
    {
        CheckBox check_done;
        ImageButton comments,attach;
        TextView item_name;
        OnItemClickListener itemClickListener;
        OnItemCheckListener onItemCheckListener;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            check_done=itemView.findViewById(R.id.checkbox_done);
            comments=itemView.findViewById(R.id.comments);
            attach=itemView.findViewById(R.id.attach);
            item_name=itemView.findViewById(R.id.tv);

            comments.setOnClickListener(this);
            attach.setOnClickListener(this);
            check_done.setOnCheckedChangeListener(this);
            /*check_done.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                }
            });*/

        }
        public void setItemClickListener(OnItemClickListener itemClickListener)
        {
            this.itemClickListener=itemClickListener;
        }
        public void setItemCheckListner(OnItemCheckListener onitemCheckListner)
        {
            this.onItemCheckListener=onitemCheckListner;
        }

        @Override
        public void onClick(View v)
        {
            itemClickListener.onItemClick(v,getLayoutPosition());



        }


        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            onItemCheckListener.onItemCheck(buttonView,getLayoutPosition(),true);

        }
    }
}
