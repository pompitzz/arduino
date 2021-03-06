package com.example.windowproject.task;

import com.example.windowproject.MainActivity;
import com.example.windowproject.http.request.WindowStateFindRequest;

import java.util.TimerTask;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WindowStateTask extends TimerTask {

    private MainActivity activity;

    @Override
    public void run() {
        new WindowStateFindRequest(activity).execute();
    }
}
