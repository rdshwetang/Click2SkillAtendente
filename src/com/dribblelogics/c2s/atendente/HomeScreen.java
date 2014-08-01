/* 
 * @author Shwetang R.D 
 * Visual Sistemas Electronicos Ltda.
 * Belo Horizonte-Brazil -2014
 */
package com.dribblelogics.c2s.atendente;

import com.dribblelogics.c2s.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_screen);
		
		TextView headerTitle = (TextView)findViewById(R.id.header_text);
		headerTitle.setText("File Resturant Bar");
		
		ImageButton headerMenu =(ImageButton) findViewById(R.id.menu_icon);
		headerMenu.setImageResource(R.drawable.icon_exit);
		headerMenu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builderAtendente = new AlertDialog.Builder(HomeScreen.this,AlertDialog.THEME_HOLO_LIGHT);
				builderAtendente.setTitle("Sair");
				builderAtendente.setMessage("Voc?? tem certeza quiser sair ?");
		        builderAtendente.setNegativeButton("Cancelar",new DialogInterface.OnClickListener() {
		            @Override
		            public void onClick(DialogInterface dialog, int which) {
		                dialog.dismiss();
		            }
		        });
		        builderAtendente.setPositiveButton("Sim",new DialogInterface.OnClickListener() {
		            @Override
		            public void onClick(DialogInterface dialog, int which) {
		            }
		        });
		        builderAtendente.show();
			}
		});
		
		Button buttonOne = (Button)findViewById(R.id.buttonnext);
		buttonOne.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),MainMenu.class);
				startActivity(i);
				overridePendingTransition(R.anim.rotate_out,R.anim.rotate_in);
			}
		});
	}
	@Override
	public void onBackPressed()
	{	
		//
	}
}
