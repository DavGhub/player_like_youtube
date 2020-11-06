package com.inorain.playerlikeyoutubetest;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private DraggablePanel draggablePanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        draggablePanel = findViewById(R.id.draggable_panel);
        draggablePanel.setFragmentManager(getSupportFragmentManager());
        draggablePanel.setTopFragment(One.getInstance());
        draggablePanel.setBottomFragment(Two.getInstance());
        draggablePanel.setTopViewHeight(500);
        draggablePanel.initializeView();

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                draggablePanel.closeToLeft();
            }
        },100);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                draggablePanel.maximize();
            }
        });
    }

    /**
     * Hook DraggableListener to draggableView to pause or resume VideoView.
     */
    private void hookDraggableViewListener() {
        draggablePanel.setDraggableListener(new DraggableListener() {
            @Override public void onMaximized() {
                One.getInstance().startVideo();
            }

            //Empty
            @Override public void onMinimized() {
                //Empty
            }

            @Override public void onClosedToLeft() {
                One.getInstance().pauseVideo();
            }

            @Override public void onClosedToRight() {
                One.getInstance().pauseVideo();
            }
        });
    }
}
