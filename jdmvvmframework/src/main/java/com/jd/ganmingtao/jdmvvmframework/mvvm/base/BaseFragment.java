package com.jd.ganmingtao.jdmvvmframework.mvvm.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;

/**
 * @author ganmingtao
 */
public abstract class BaseFragment extends Fragment {
    /**
     * 日志tag
     */
    private static final String TAG = BaseFragment.class.getSimpleName();
    /**
     * activity
     */
    public BaseActivity thisActivity;
    /**
     * rootview
     */
    protected View rootView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            thisActivity = (BaseActivity) activity;
        } catch (Exception e) {
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (rootView == null) {
            try {
                rootView = onCreateViews(thisActivity.getLayoutInflater(), savedInstanceState);

            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 只有需要在onStop()时，removie view的界面才覆写此方法提供布局，
     * 否则按正常的写法onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)处提供布局
     * @param inflater
     * @param savedInstanceState
     * @return
     */
    public View onCreateViews(LayoutInflater inflater, Bundle savedInstanceState){
        return null;
    }

    /**
     * 子类如果不需要再onStop()的时候remove view,应按照原生fragmen的写法覆写此方法，提供layout
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
