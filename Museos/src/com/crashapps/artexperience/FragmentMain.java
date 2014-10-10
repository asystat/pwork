package com.crashapps.artexperience;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentMain extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";
	public static final int SECTION_INDEX=0;
	public static final int SECTION_IDS=1;
	
	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static FragmentMain factory(int sectionNumber) {
		
		
		
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		
		FragmentMain fragment = null;
		switch(sectionNumber){
		case SECTION_INDEX:
			fragment=FragmentMainIndex.newInstance();
			break;
		case SECTION_IDS:
			fragment=FragmentMainIds.newInstance();
			break;
		default:
			fragment=new FragmentMain();
		}
		fragment.setArguments(args);
		return fragment;
	}

	public FragmentMain() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(getArguments().getInt(
				ARG_SECTION_NUMBER));
	}
}