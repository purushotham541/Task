package com.example.task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    List<Checklist_Model> list;
    ChecklistAdapeter checklistAdapeter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.rcv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        for (int i=0;i<10;i++)
        {
            Checklist_Model checklist_model=new Checklist_Model("Check"+i);
            list.add(checklist_model);
        }
        checklistAdapeter=new ChecklistAdapeter(this,list);
        recyclerView.setAdapter(checklistAdapeter);
    }
}
