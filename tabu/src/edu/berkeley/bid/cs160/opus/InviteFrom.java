package edu.berkeley.bid.cs160.opus;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class InviteFrom extends DialogFragment {
		private Button facebook;
		private Button contacts;
		 
		public static InviteFrom newInstance(String title) {
		        InviteFrom frag = new InviteFrom();
		        Bundle args = new Bundle();
		        args.putString("title", title);
//		        args.putInt("title", title);
		        frag.setArguments(args);
		        return frag;
		    }
		public void showDialogFacebook(View v)
		{
			 getActivity().showDialog(0);//showDialog();
		}
		public void showDialogContacts(View v)
		{
			getActivity().showDialog(1);//showDialog();
		}
		 @Override
		    public Dialog onCreateDialog(Bundle savedInstanceState) {
		        //int title = getArguments().getInt("title");
		        
		        //1
		        final CharSequence[] items = {"Red", "Green", "Blue"};

            	AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            	builder.setTitle("Pick a color");
            	builder.setItems(items, new DialogInterface.OnClickListener() {
            	    public void onClick(DialogInterface dialog, int item) {
            	    	((InviteActivity) getActivity()).doNegativeClick();
            	    }
            	});
            	return builder.create();
            	//return alert;
            	
            	//2
			 /*
		        return new AlertDialog.Builder(getActivity())
		                .setTitle("CHOOSE CONTACTS")
		                .setPositiveButton("FACEBOOK",
		                    new DialogInterface.OnClickListener() {
		                        public void onClick(DialogInterface dialog, int whichButton) {
		                            ((Tabu_160Activity) getActivity()).doPositiveClick();
		                        }
		                    }
		                )
		                .setNegativeButton("CONTACTS",
		                    new DialogInterface.OnClickListener() {
		                        public void onClick(DialogInterface dialog, int whichButton) {
		                            ((Tabu_160Activity) getActivity()).doNegativeClick();
		                        }
		                    }
		                )
		                .create();
		                */
		        //3
		        /*
		        Dialog dialog = new Dialog(getActivity());
		        AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity());
		        builder2.setTitle("Select Color Mode");

		        ListView modeList = new ListView(getActivity());
		        String[] stringArray = new String[] { "Bright Mode", "Normal Mode" };
		        ArrayAdapter<String> modeAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, stringArray);
		        modeList.setAdapter(modeAdapter);

		        builder2.setView(modeList);
		        dialog = builder2.create();
		        //dialog.show();
		        return dialog;
		        */
		    }
		 
	   @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                             Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
		   facebook = (Button) getActivity().findViewById(R.id.facebook);
		   contacts = (Button) getActivity().findViewById(R.id.contacts);
		  /* facebook.setOnClickListener(new OnClickListener() {
	            @Override
	            public void onClick(View v) 
	            {
	 	            }
	          });
		   
		   contacts.setOnClickListener(new OnClickListener() {
	            @Override
	            public void onClick(View v) 
	            {
	            	
	            }
	          });
		   
	       */
		   return inflater.inflate(R.layout.invite_from, container, false);
	    }

}
