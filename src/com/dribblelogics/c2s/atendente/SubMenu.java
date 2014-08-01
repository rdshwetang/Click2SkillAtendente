/* 
 * @author Shwetang R.D 
 * Visual Sistemas Electronicos Ltda.
 * Belo Horizonte-Brazil -2014
 */
package com.dribblelogics.c2s.atendente;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dribblelogics.c2s.R;
import com.dribblelogics.c2s.adapters.ThreeTextOneImageAdapterItems;
import com.dribblelogics.c2s.adapters.OneTextOneImageAdapterList;
import com.dribblelogics.c2s.adapters.ThreeTextOneImageAdapterItems;
import com.dribblelogics.c2s.adapters.ThreeTextOneImageListAdapter;
import com.dribblelogics.quickactionmenu.ActionItem;
import com.dribblelogics.quickactionmenu.QuickAction;

public class SubMenu extends Activity {
	QuickAction mQuickAction;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sub_menu);
		
		TextView headerTitle = (TextView)findViewById(R.id.header_text);
		headerTitle.setText("Sub Menu");
		
		ImageButton headerMenu =(ImageButton) findViewById(R.id.menu_icon);
		headerMenu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showHeaderMenu();
				mQuickAction.show(v);
				mQuickAction.setAnimStyle(QuickAction.ANIM_GROW_FROM_CENTER);
			}
		});
		ListView subMenuItemList = (ListView)findViewById(R.id.list_sub_menu);
		ThreeTextOneImageAdapterItems menu_list[] = new ThreeTextOneImageAdapterItems[9];
		for(int i=0;i<9;i++)
		{		
				menu_list[i] = new ThreeTextOneImageAdapterItems(R.drawable.food_icon, "Food","10","R$100");
		}
		final ThreeTextOneImageListAdapter adapter = new ThreeTextOneImageListAdapter(this,R.layout.sub_menu_listview_contents, menu_list);   
		subMenuItemList.setAdapter(adapter);
		subMenuItemList.setClickable(true);
		subMenuItemList.setOnItemClickListener(new AdapterView.OnItemClickListener()
	    {	
	    	@Override
		    public void onItemClick(AdapterView<?> parent, final View view,int position, long id)
		    {	
	    		AlertDialog.Builder builderAtendente = new AlertDialog.Builder(SubMenu.this, AlertDialog.THEME_HOLO_LIGHT);
				builderAtendente.setTitle("Confirm Item ? ");
				builderAtendente.setMessage("You item is :");
				builderAtendente.setNegativeButton("Cancelar",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								//
							}
						});
				builderAtendente.setNegativeButton("Ok",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								//
							}
						});
				builderAtendente.show();
		    }
	    });
	}
	
	public void showHeaderMenu(){
			ActionItem addAction = new ActionItem();
			
			addAction.setTitle("Add");
			addAction.setIcon(getResources().getDrawable(R.drawable.ic_add));

			ActionItem accAction = new ActionItem();
			
			accAction.setTitle("Accept");
			accAction.setIcon(getResources().getDrawable(R.drawable.ic_accept));
			
			ActionItem upAction = new ActionItem();
			
			upAction.setTitle("Upload");
			upAction.setIcon(getResources().getDrawable(R.drawable.ic_up));
			
			ActionItem upAction2 = new ActionItem();
			
			upAction2.setTitle("Add again");
			upAction2.setIcon(getResources().getDrawable(R.drawable.ic_up));
			
			mQuickAction 	= new QuickAction(this);
			
			mQuickAction.addActionItem(addAction);
			mQuickAction.addActionItem(accAction);
			mQuickAction.addActionItem(upAction);
			mQuickAction.addActionItem(upAction2);
			
			//setup the action item click listener
			mQuickAction.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {			
				@Override
				public void onItemClick(int pos) {
					
					if (pos == 0) { //Add item selected
						Toast.makeText(SubMenu.this, "Add item selected", Toast.LENGTH_SHORT).show();
					} else if (pos == 1) { //Accept item selected
						Toast.makeText(SubMenu.this, "Accept item selected", Toast.LENGTH_SHORT).show();
					} else if (pos == 2) { //Upload item selected
						Toast.makeText(SubMenu.this, "Upload items selected", Toast.LENGTH_SHORT).show();
					}	
				}
			});
	}
}
