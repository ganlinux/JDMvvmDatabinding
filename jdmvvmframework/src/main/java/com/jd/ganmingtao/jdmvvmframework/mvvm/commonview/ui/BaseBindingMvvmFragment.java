
package com.jd.ganmingtao.jdmvvmframework.mvvm.commonview.ui;

import android.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jd.ganmingtao.jdmvvmframework.BR;
import com.jd.ganmingtao.jdmvvmframework.mvvm.aac.BaseViewModelFactory;
import com.jd.ganmingtao.jdmvvmframework.mvvm.base.BaseEvent;
import com.jd.ganmingtao.jdmvvmframework.mvvm.base.BaseFragment;
import com.jd.ganmingtao.jdmvvmframework.mvvm.commonview.vm.BaseViewModel;
import de.greenrobot.event.EventBus;

/**带绑定功能的mvvm fragment基类
 *
 * @author ganmingtao
 * @date 2017/5/9
 */
public abstract class BaseBindingMvvmFragment<VM extends BaseViewModel, B extends ViewDataBinding> extends BaseFragment{

	/**
	 * viewModel对象
	 */
	private VM viewModel;
	/**
	 * 数据绑定对象
	 */
	private B binding;

	/**获取viewmodel类类型
	 * @return
	 */
	public abstract Class getViewModelClass();

	/**
	 * 初始化引用
	 */
	private void initDependency() {
		if(viewModel==null) {
			//normal
//      viewModel = createViewModel();
			//aac
			viewModel = ViewModelProviders.of(this, new BaseViewModelFactory(getActivity().getApplication())).get((Class<VM>)getViewModelClass());
		}
	}

	//normal
	/**创建viewmodel
	 * @return
	 */
	/*protected abstract VM createViewModel();*/

	/**设置viewmodel
	 * @param viewModel
	 */
	public void setViewModel(@NonNull VM viewModel) {
		this.viewModel = viewModel;
	}

	/**获取设置viewmodel
	 * @return
	 */
	public VM getViewModel() {
		if (viewModel == null) {
			throw new NullPointerException("You should setViewModel first!");
		}
		return viewModel;
	}

	/**设置数据绑定对象
	 * @param binding
	 */
	public void setBinding(@NonNull B binding) {
		this.binding = binding;
	}

	/**获取数据绑定对象
	 * @return
	 */
	public B getBinding() {
		if (binding == null) {
			throw new NullPointerException("You should setBinding first!");
		}
		return binding;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		initDependency();
		binding = DataBindingUtil.<B>inflate(inflater, createLayout(), container, false);
		binding.setVariable(BR.viewModel, viewModel);
		binding.setLifecycleOwner(this);
		return binding.getRoot();
	}

	@Override
	public void onStart() {
		super.onStart();
		if(viewModel != null) {
			viewModel.attachUI();
		}
		if(!EventBus.getDefault().isRegistered(this))
		{
			EventBus.getDefault().register(this);
		}
	}

	public void onEvent(BaseEvent event) {

	}
	@Override
	public void onStop() {
		super.onStop();
		if(viewModel!=null){
			viewModel.suspend();
		}
		EventBus.getDefault().unregister(this);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		if(viewModel!=null) {
			viewModel.detachUI();
			setViewModel(null);//清空
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if(viewModel!=null) {
			viewModel.detachUI();
			setViewModel(null);//清空
		}
	}

	/**获取layout id  子类需实现
	 */
	protected abstract int createLayout();

}
