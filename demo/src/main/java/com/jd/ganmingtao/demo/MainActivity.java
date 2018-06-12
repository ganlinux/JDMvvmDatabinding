package com.jd.ganmingtao.demo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.jd.ganmingtao.demo.floor.ui.FloorDemoActivity;
import com.jd.ganmingtao.demo.activityfragment.ui.FragmentsDemoActivity;
import com.jd.ganmingtao.demo.recyclerview.ui.RecyclerviewDemoActivity;
import com.jd.ganmingtao.demo.databinding.ActivityMainBinding;

/**
 * 主activity
 * @author ganmingtao
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.btnMvvmSample1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FragmentsDemoActivity.class));
            }
        });
        mBinding.btnMvvmSample2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FloorDemoActivity.class));
            }
        });
        mBinding.btnMvvmSample3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerviewDemoActivity.class));
            }
        });
    }
}
