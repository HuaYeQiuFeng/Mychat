package net.cuig.mytalker.push;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.cuig.mytalker.common.Common;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Common();
    }
}