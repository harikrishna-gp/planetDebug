package com.planetdebug;
import android.support.v4.app.DialogFragment;
import android.app.Dialog;
//import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class ipDlg extends DialogFragment implements OnEditorActionListener {
//public class ipDlg {
	EditText mEditText;
	public ipDlg(){
	}
	public interface ipDlgListener {
		void onIpGetDialog(String inputText);
	}

//	public ipDlg(Context ctx){
//		final Dialog dialog = new Dialog(ctx);
//		dialog.setContentView(R.layout.node_dlg);
//		dialog.setTitle("Enter IP Address");
//
//		// set the custom dialog components - text, image and button
//		Button okBtn = (Button) dialog.findViewById(R.id.ipOk);
//		Button cnclBtn = (Button) dialog.findViewById(R.id.ipCncl);
//
//		okBtn.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				EditText ipTxt =  (EditText)dialog.findViewById(R.id.ipAddrTxt);
//				if (ipTxt != null){
//					Toast.makeText(v.getContext(), "IP Address:" + ipTxt.getText().toString(), Toast.LENGTH_LONG).show();
//					gblData.getInstance().setNodeIp(ipTxt.getText().toString());
//				}
//				dialog.dismiss();
//			}
//		});
//
//		cnclBtn.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				dialog.dismiss();
//			}
//		});
//		
//		dialog.show();		
//	}

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.node_dlg, container);
        mEditText = (EditText) view.findViewById(R.id.ipAddrTxt);
        getDialog().setTitle("Node IP Address");

        // Show soft keyboard automatically
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        mEditText.setOnEditorActionListener(this);

        return view;
    }

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		// TODO Auto-generated method stub
	     if (EditorInfo.IME_ACTION_DONE == actionId) {
	            // Return input text to activity
	    	 	ipDlgListener activity = (ipDlgListener) getActivity();
	            activity.onIpGetDialog(mEditText.getText().toString());
	            this.dismiss();
	            return true;
	        }
	        return false;
	}

}
