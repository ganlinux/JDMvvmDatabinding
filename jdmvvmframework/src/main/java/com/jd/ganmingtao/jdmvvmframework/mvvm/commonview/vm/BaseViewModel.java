package com.jd.ganmingtao.jdmvvmframework.mvvm.commonview.vm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Intent;

import com.jd.ganmingtao.jdmvvmframework.mvvm.base.BaseEvent;
import de.greenrobot.event.EventBus;

/**BaseViewModel 相当于mvp中的presenter
 * @author ganmingtao
 */
public abstract class BaseViewModel extends AndroidViewModel {

	/**UI是否显示*/
	protected boolean isShow=false;

	/**
	 * 是否在onstop时解绑的标志位,true：onstop解绑，false：ondestroy解绑
	 */
	private boolean isUnregisterInStop = false;


	/**构造函数
	 * @param application 上下文
	 */
	public BaseViewModel(Application application){
		super(application);
		if(!EventBus.getDefault().isRegistered(this)){
			EventBus.getDefault().register(this);
		}
	}

	/**处理UI的Intent*/
	public boolean handleIntent(Intent intent){
		return false;
	}

	/**
	 * 绑定UI,默认在UI布局初始化完成后调用,如activity.onStart(),fragment.onViewCreated()中调用
	 */
	public void attachUI(){
		onAttach();
		if(!isShow){
			if(!EventBus.getDefault().isRegistered(this)){
				EventBus.getDefault().register(this);
			}
			isShow=true;
		}
	}

	/**
	 * UI挂起的时候调用此方法,默认在onStop()中调用
	 */
	public void suspend() {
		if(isShow) {
			isShow = false;
		}
		if(isUnregisterInStop){
			EventBus.getDefault().unregister(this);
		}
		onSuspend();
	}
	/**
	 * UI消亡的时候调用此方法,默认在onDestroy()中调用
	 */
	public synchronized void detachUI() {
		onDetach();
		EventBus.getDefault().unregister(this);
	}

	public void setIsShow(boolean isShow) {
		this.isShow = isShow;
	}


	/**是否需要在Activity onStop时解绑EventBus
	 * @param flag true : onStop时解绑   false：onDestory时解绑
	 */
	public void unregisterEventBusInStop(boolean flag){
		isUnregisterInStop = flag;
	}

	/**
	 * UI是否显示了
	 * @return
	 */
	public boolean isShow(){
		return isShow;
	}

	/**
	 * eventbus事件处理
	 * @param event
	 */
	public abstract void onEvent(BaseEvent event);
	/**
	 *eventbus订阅事件处理：此方法中接收的event均在UI线程操作
	 */
	public abstract void onEventMainThread(BaseEvent event);
	/**
	 * 绑定UI,可做一些数据初始化的工作
	 */
	protected abstract void onAttach();

	/**
	 * 同步UI（support v4 的fragment不可用）的onTrimMemory(int level)方法,
	 * 可以调用interactor或state里的清理方法
	 * 用法参考：2) 当UI隐藏时释放内存 3) 当内存紧张时释放部分内存
	 * http://hukai.me/android-training-course-in-chinese/performance/memory.html
	 *
	 * 你应该根据onTrimMemory传入的几个内存级别释放内存：
	 * TRIM_MEMORY_UI_HIDDEN
	 * 表示应用程序的 所有UI界面 被隐藏了，即用户点击了Home键或者Back键导致应用的UI界面不可见．这时候应该释放一些资源．
	 * @param level
	 */
	public void onTrimMemory(int level){
	}
	/**
	 * UI挂起的回调,数据暂存
	 */
	protected abstract void onSuspend();

	/**
	 * UI消亡的回调,释放资源
	 */
	protected abstract void onDetach();

}
