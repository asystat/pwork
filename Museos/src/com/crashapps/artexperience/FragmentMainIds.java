package com.crashapps.artexperience;

import java.lang.ref.WeakReference;

import Utils.TypeFaceProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ListView;

import com.crashapps.artexperience.adapters.MuseumAdapter;
import com.crashapps.artexperience.customviews.ButtonIconText;
import com.crashapps.artexperience.customviews.ExtendedView;
import com.crashapps.artexperience.customviews.TextBoxWithTitle;
import com.crashapps.artexperience.interfaces.ActivityListener;
import com.flaviofaria.kenburnsview.KenBurnsView.TransitionListener;
import com.flaviofaria.kenburnsview.Transition;

public class FragmentMainIds extends FragmentMain{


	private static WeakReference<FragmentMain> instance;
    private ListView mList;
    private MuseumAdapter mAdapter;
	
	private FragmentMainIds() {
		instance = new WeakReference<FragmentMain>(this);
	}
	
	public static FragmentMain newInstance(){
		if(instance!=null && instance.get()!=null)
			return instance.get();
		FragmentMainIds fm=new FragmentMainIds();
		return fm;
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_main_ids, container,
				false);
		
		mList=(ListView)rootView.findViewById(R.id.list);
        
		return rootView;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mAdapter=new MuseumAdapter(getActivity());
		mList.setAdapter(mAdapter);
		
	}
    
	
}
