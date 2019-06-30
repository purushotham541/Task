package com.example.task.interfaces;

import android.view.View;
import android.widget.CompoundButton;

public interface OnItemCheckListener
{
    public boolean onItemCheck(CompoundButton compoundButton, int position, Boolean isChecked);
}
