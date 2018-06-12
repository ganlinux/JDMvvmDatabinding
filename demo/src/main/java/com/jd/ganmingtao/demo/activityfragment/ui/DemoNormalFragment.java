package com.jd.ganmingtao.demo.activityfragment.ui;

import com.jd.ganmingtao.demo.DemoNormalFragmentBinding;
import com.jd.ganmingtao.demo.R;
import com.jd.ganmingtao.demo.activityfragment.viewmodel.DemoNormalFragmentViewModel;
import com.jd.ganmingtao.jdmvvmframework.mvvm.commonview.ui.BaseBindingMvvmFragment;

/**fragment示例
 *
 * @author ganmingtao
 * @date 2017/12/15
 */

public class DemoNormalFragment extends BaseBindingMvvmFragment<DemoNormalFragmentViewModel, DemoNormalFragmentBinding>{

    //normal
    @Override
    protected DemoNormalFragmentViewModel createViewModel() {
        return new DemoNormalFragmentViewModel(getActivity().getApplication());
    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_demo_normalfragment;
    }

}
