package com.planetdebug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
//import android.widget.TextView;
//import android.widget.Toast;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Button;
import android.widget.Toast;

public class fdTab extends Fragment  implements OnClickListener{
	View fdView;
	Button fdBtn;
	fdList fdList;
	fdListAdapter fdAdptr;
	ExpandableListView fdListView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fd_tab,container, false);
		this.fdBtn = (Button)rootView.findViewById(R.id.fdViewBtn);
		this.fdBtn.setOnClickListener(this);
		this.fdView = rootView;
		this.fdList	= new fdList();

		fdListView = (ExpandableListView)rootView.findViewById(R.id.fdsList);
        // Set up our adapter
        ExpandableListAdapter mAdapter = new SimpleExpandableListAdapter(
        		this.getActivity(),
                this.fdList.getDataHdr(),
                android.R.layout.simple_expandable_list_item_1,
                new String[] {this.fdList.fdKey},
                new int[] { android.R.id.text1},
                this.fdList.getData(),
                android.R.layout.simple_expandable_list_item_2,
                new String[] { this.fdList.fdSlotKey , this.fdList.fdDataKey},
                new int[] { android.R.id.text1, android.R.id.text2 }
                );
        fdListView.setAdapter(mAdapter);
		return rootView;
	}
	public void onClick(View view) {
		String currentTxt =  this.fdBtn.getText().toString();
		if (currentTxt.compareToIgnoreCase ("ALL") == 0){
			this.fdBtn.setText("Failed");
		}
		else {
			this.fdBtn.setText("All");
		}	
	}
	
}
