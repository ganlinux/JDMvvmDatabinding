package com.jd.ganmingtao.jdmvvmframework.mvvm.commonview.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.jd.ganmingtao.jdmvvmframework.BR;
import com.jd.ganmingtao.jdmvvmframework.mvvm.base.BaseActivity;
import com.jd.ganmingtao.jdmvvmframework.mvvm.base.BaseEvent;
import com.jd.ganmingtao.jdmvvmframework.mvvm.commonview.vm.BaseViewModel;
import de.greenrobot.event.EventBus;


/**带绑定功能的mvvm activity基类
 * @author ganmingtao
 */
public abstract class BaseBindingMvvmActivity<VM extends BaseViewModel, B extends ViewDataBinding> extends BaseActivity{

  /**
   * viewModel对象
   */
  private VM viewModel;
  /**
   * 数据绑定对象
   */
  private B binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initDependency();
  }

  /**获取viewmodel类类型
   * @return
   */
  /*public abstract Class getViewModelClass();*/

  /**设置viewmodel对象
   * @param viewModel viewModel
   */
  public void setViewModel(@NonNull VM viewModel) {
    this.viewModel = viewModel;
  }

  /**获取viewmodel对象
   * @return viewModel
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

  /**
   *初始化数据绑定对象
   */
  public void initBinding(){
    binding = DataBindingUtil.<B>setContentView(this, createLayout());
    binding.setVariable(BR.viewModel, viewModel);
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


  /**获取layout id  子类需实现
   * @return layout id
   */
  protected abstract int createLayout();
  /**
   * 初始化依赖,子类可以初始化依赖注入DI框架
   */
  protected void initDependency() {
    if (viewModel == null) {
      //normal
      viewModel = createViewModel();
      //aac
//      viewModel = ViewModelProviders.of(this, new BaseViewModelFactory(this.getApplication())).get((Class<VM>)getViewModelClass());
    }
    initBinding();
  }

  /**创建ViewModel
   * @return
   */
  protected abstract VM createViewModel();

  @Override
  protected void onStart() {
    super.onStart();
    if (viewModel != null) {
      viewModel.attachUI();
    }
    if (!EventBus.getDefault().isRegistered(this)){
      EventBus.getDefault().register(this);
    }
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    if (viewModel != null) {
      viewModel.detachUI();
    }
  }

  /**事件
   * @param event 事件
   */
  public void onEvent(BaseEvent event) {

  }

  @Override
  public void onTrimMemory(int level) {
    super.onTrimMemory(level);
    if (viewModel != null){
      viewModel.onTrimMemory(level);
    }
  }

  @Override
  protected void onStop() {
    super.onStop();
    if (viewModel != null) {
      viewModel.suspend();
    }
    EventBus.getDefault().unregister(this);
  }

}
