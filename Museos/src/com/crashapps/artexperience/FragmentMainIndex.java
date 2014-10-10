package com.crashapps.artexperience;

import java.lang.ref.WeakReference;

import Utils.TypeFaceProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import com.crashapps.artexperience.customviews.ButtonIconText;
import com.crashapps.artexperience.customviews.ExtendedView;
import com.crashapps.artexperience.customviews.TextBoxWithTitle;
import com.crashapps.artexperience.interfaces.ActivityListener;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.KenBurnsView.TransitionListener;
import com.flaviofaria.kenburnsview.Transition;

public class FragmentMainIndex extends FragmentMain implements TransitionListener{

	private ViewSwitcher mViewSwitcher;
    private int mTransitionsCount = 0;
    private static final int TRANSITIONS_TO_SWITCH=1;
    private LinearLayout content;
	private static WeakReference<FragmentMain> instance;
    
	private FragmentMainIndex() {
		instance = new WeakReference<FragmentMain>(this);
	}
	
	public static FragmentMain newInstance(){
		if(instance!=null && instance.get()!=null)
			return instance.get();
		FragmentMainIndex fm=new FragmentMainIndex();
		return fm;
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_main_index, container,
				false);
		
		mViewSwitcher = (ViewSwitcher) rootView.findViewById(R.id.viewSwitcher);

        KenBurnsView img1 = (KenBurnsView) rootView.findViewById(R.id.img1);
        img1.setTransitionListener(this);

        KenBurnsView img2 = (KenBurnsView) rootView.findViewById(R.id.img2);
        img2.setTransitionListener(this);
		
        content=(LinearLayout)rootView.findViewById(R.id.index_views);
        
		return rootView;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		if(System.currentTimeMillis()%2==0)
			mViewSwitcher.showNext();
		
		addContentData();
	}
	
	@Override
    public void onTransitionStart(Transition transition) {

    }


    @Override
    public void onTransitionEnd(Transition transition) {
        mTransitionsCount++;
        if (mTransitionsCount == TRANSITIONS_TO_SWITCH) {
            mViewSwitcher.showNext();
            mTransitionsCount = 0;
        }
    }
    
    private void addContentData(){
    	TextBoxWithTitle tb1=new TextBoxWithTitle(getActivity());
    	tb1.setTitle("Bienvenido al Museo del Prado");
    	tb1.setIcon(R.drawable.ip_museum);
    	tb1.setContent("El edificio que hoy sirve de sede al Museo Nacional del Prado fue diseñado por el arquitecto Juan de Villanueva en 1785, como Gabinete de Ciencias Naturales, por orden de Carlos III.");
    	tb1.setStartAnimationType(ExtendedView.SLIDE_FROM_RIGHT);
    	tb1.setStartAnimationOffset(1000);
    	content.addView(tb1);
    	
    	TextBoxWithTitle tb2=new TextBoxWithTitle(getActivity());    	
    	tb2.setTitle("Acerca del museo");
    	tb2.setIcon(R.drawable.info);
    	tb2.setContent("El Museo celebra el segundo centenario del nacimiento del compositor alemán Richard Wagner con la exposición de las obras que realizó el pintor Rogelio de Egusquiza sobre su ópera Parsifal");
    	tb2.setStartAnimationType(ExtendedView.SLIDE_FROM_RIGHT);
    	tb2.setStartAnimationOffset(1200);    	
    	content.addView(tb2);
    	
    	ButtonIconText bic1=new ButtonIconText(getActivity());
    	bic1.setText("Descubre el museo");
    	bic1.setStartAnimationType(ExtendedView.SLIDE_FROM_RIGHT);
    	bic1.setStartAnimationOffset(1400);   
    	bic1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
						((ActivityListener)getActivity()).openDrawer();	
			}
		});
    	
    	content.addView(bic1);
    	TypeFaceProvider.overrideFonts(getActivity(), content);
    }
	
}
