/* 
 * @author Shwetang R.D 
 * Visual Sistemas Electronicos Ltda.
 * Belo Horizonte-Brazil -2014
 */
package com.dribblelogics.c2s.atendente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.dribblelogics.c2s.R;
import com.dribblelogics.c2s.adapters.OneTextOneImageAdapterItems;
import com.dribblelogics.c2s.adapters.OneTextOneImageAdapterList;
import com.dribblelogics.quickactionmenu.ActionItem;
import com.dribblelogics.quickactionmenu.QuickAction;

public class MainMenu extends Activity {
	QuickAction mQuickAction;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		
		Button buttonNext =(Button) findViewById(R.id.btnnext);
		buttonNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),SubMenu.class);
				startActivity(i);
				overridePendingTransition(R.anim.rotate_out,R.anim.rotate_in);
			}
		});
		
		ImageButton headerMenu =(ImageButton) findViewById(R.id.menu_icon);
		headerMenu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showHeaderMenu();
				mQuickAction.show(v);
				mQuickAction.setAnimStyle(QuickAction.ANIM_GROW_FROM_CENTER);
			}
		});
		Button backButton =(Button) findViewById(R.id.btnback);
		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),HomeScreen.class);
				startActivity(i);
				overridePendingTransition(R.anim.rotate_out,R.anim.rotate_in);
			}
		});
		
		ListView mainMenuItemList = (ListView)findViewById(R.id.list_main_menu);
		final OneTextOneImageAdapterItems menu_list[] = new OneTextOneImageAdapterItems[9];
		for(int i=0;i<9;i++)
		{		
			if(i == 0){
				menu_list[i] = new OneTextOneImageAdapterItems(R.drawable.food_icon, "Food");
				}
			if(i == 1){
			 		menu_list[i] = new OneTextOneImageAdapterItems(R.drawable.beer_icon, "Beers");
	 				}
			if(i == 2){
	 				menu_list[i] = new OneTextOneImageAdapterItems(R.drawable.snacks_icon, "Snacks");
	 				}
			if(i == 3){
	 				menu_list[i] = new OneTextOneImageAdapterItems(R.drawable.beer_icon, "Whiskey");
	 				}
			if(i == 4){
	 				menu_list[i] = new OneTextOneImageAdapterItems(R.drawable.food_icon, "Special Request1");
	 				}
			if(i == 5){
					menu_list[i] = new OneTextOneImageAdapterItems(R.drawable.food_icon, "Special Request2");
					}
			if(i == 6){
				menu_list[i] = new OneTextOneImageAdapterItems(R.drawable.food_icon, "Special Request3");
				}
			if(i == 7){
				menu_list[i] = new OneTextOneImageAdapterItems(R.drawable.food_icon, "Special Request4");
				}
			if(i == 8){
				menu_list[i] = new OneTextOneImageAdapterItems(R.drawable.food_icon, "Special Request5");
				}
		}
		final OneTextOneImageAdapterList adapter = new OneTextOneImageAdapterList(this,R.layout.main_menu_listview_contents, menu_list);   
		mainMenuItemList.setAdapter(adapter);
		mainMenuItemList.setClickable(true);
		mainMenuItemList.setOnItemClickListener(new AdapterView.OnItemClickListener()
	    {	
	    	@Override
		    public void onItemClick(AdapterView<?> parent, final View view,int position, long id)
		    {		
	        	if(position == 0)
	        	{
	        		Intent intent = new Intent(getApplicationContext(),SubMenu.class);
	        		startActivity(intent);
	        		overridePendingTransition(R.anim.push_left_in_80,R.anim.push_right_out_80);
	        	}
	    		if(position == 1)
	    		{	
	    			Intent intent = new Intent(getApplicationContext(),SubMenu.class);
	        		startActivity(intent);
	    		}
	    		if(position == 2){
	    			Intent intent = new Intent(getApplicationContext(),SubMenu.class);
	        		startActivity(intent);
	    		}
	    		if(position == 3)
	    		{
	    			Intent intent = new Intent(getApplicationContext(),SubMenu.class);
	        		startActivity(intent);
	    		}
	    		if(position == 4){
	    			Intent intent = new Intent(getApplicationContext(),SubMenu.class);
	        		startActivity(intent);
	    		}
	    		if(position == 5){
	    			Intent intent = new Intent(getApplicationContext(),SubMenu.class);
	        		startActivity(intent);
	    		}
	    		if(position == 6){
	    			Intent intent = new Intent(getApplicationContext(),SubMenu.class);
	        		startActivity(intent);
	    		}
	    		if(position == 7){
	    			Intent intent = new Intent(getApplicationContext(),SubMenu.class);
	        		startActivity(intent);
	    		}
	    		if(position == 8){
	    			Intent intent = new Intent(getApplicationContext(),SubMenu.class);
	        		startActivity(intent);
	    		}
		    }
	    });
		
	}
	public void showHeaderMenu(){
		ActionItem addAction = new ActionItem();
		
		addAction.setTitle("See Order");
		addAction.setIcon(getResources().getDrawable(R.drawable.ic_add));

		ActionItem accAction = new ActionItem();
		
		accAction.setTitle("Change Order");
		accAction.setIcon(getResources().getDrawable(R.drawable.ic_accept));
		
		ActionItem upAction = new ActionItem();
		
		upAction.setTitle("Special Order");
		upAction.setIcon(getResources().getDrawable(R.drawable.ic_up));
		
		ActionItem upAction2 = new ActionItem();
		
		upAction2.setTitle("Cancel Order");
		upAction2.setIcon(getResources().getDrawable(R.drawable.ic_up));
		
		ActionItem upAction3 = new ActionItem();
		
		upAction3.setTitle("Payment");
		upAction3.setIcon(getResources().getDrawable(R.drawable.ic_up));
		
		mQuickAction 	= new QuickAction(this);
		
		mQuickAction.addActionItem(addAction);
		mQuickAction.addActionItem(accAction);
		mQuickAction.addActionItem(upAction);
		mQuickAction.addActionItem(upAction2);
		mQuickAction.addActionItem(upAction3);
		
		mQuickAction.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {			
			@Override
			public void onItemClick(int pos) {
				if (pos == 0) { //Add item selected
					Toast.makeText(MainMenu.this, "Add item selected", Toast.LENGTH_SHORT).show();
				} else if (pos == 1) { //Accept item selected
					Toast.makeText(MainMenu.this, "Accept item selected", Toast.LENGTH_SHORT).show();
				} else if (pos == 2) { //Upload item selected
					Toast.makeText(MainMenu.this, "Upload items selected", Toast.LENGTH_SHORT).show();
				}	else if (pos == 3) { //Upload item selected
					Toast.makeText(MainMenu.this, "Upload items selected", Toast.LENGTH_SHORT).show();
				}	else if (pos == 4) { 
					Intent i = new Intent(getApplicationContext(),PaymentScreen.class);
					startActivity(i);
				}	
			}
		});
	}
	@Override
	public void onBackPressed()
	{	
	}
}
