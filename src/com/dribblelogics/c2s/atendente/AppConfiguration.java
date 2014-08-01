/* 
 * @author Shwetang R.D 
 * Visual Sistemas Electronicos Ltda.
 * Belo Horizonte-Brazil -2014
 */
package com.dribblelogics.c2s.atendente;

import java.util.ArrayList;
import java.util.List;

import com.dribblelogics.c2s.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AppConfiguration extends Activity {
	
	Spinner spinner;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_configuration);
	
		Button buttonWS = (Button)findViewById(R.id.button_webservice);
		buttonWS.setOnLongClickListener(new View.OnLongClickListener() {
			
		@Override
		public boolean onLongClick(View v) {
			AlertDialog.Builder alert = new AlertDialog.Builder(AppConfiguration.this,AlertDialog.THEME_HOLO_LIGHT);
			alert.setTitle("Are you a technician ?");
			alert.setMessage("Digite a senha para verifica????o");
			final EditText senha = new EditText(getApplicationContext());
			alert.setView(senha);
			alert.setPositiveButton("Ok", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialog, int whichButton) 
				{	
					System.out.println(senha.getText().toString());
					if(senha.getText().toString().equalsIgnoreCase("c2s"))
					{	
						AlertDialog.Builder alert = new AlertDialog.Builder(AppConfiguration.this,AlertDialog.THEME_HOLO_LIGHT);
						alert.setTitle("Web Service URL");
						alert.setMessage("Please enter in the format : http://192.168.2.8:5050/addressofWebservice");
						final EditText senha = new EditText(getApplicationContext());
						alert.setView(senha);
						alert.setPositiveButton("Ok", new DialogInterface.OnClickListener()
						{
							public void onClick(DialogInterface dialog, int whichButton) 
							{	
								//
						   	}
						});
						alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener()
						{
							public void onClick(DialogInterface dialog, int whichButton) 
							{	
								//
						   	}
						});
						AlertDialog a=alert.create();
						a.show();
					}
					else
					{
						AlertDialog.Builder alert = new AlertDialog.Builder(AppConfiguration.this,AlertDialog.THEME_HOLO_LIGHT);
						alert.setTitle("Accesso Restrito");
						alert.setMessage("Accesso N??o Permitado");
						alert.setPositiveButton("Ok", new DialogInterface.OnClickListener()
						{
							public void onClick(DialogInterface dialog, int whichButton) 
							{
								//
							}
						});
						AlertDialog a=alert.create();
						alert.show();
					}
			   	}
			});
			AlertDialog a=alert.create();
			a.show();
			return true;
		}
	});
		
		spinner = (Spinner)findViewById(R.id.spinner1);
		List<String> list = new ArrayList<String>();
		list.add("Add Main Menu");
		list.add("Add Sub Menu");
		list.add("Change Main Menu");
		list.add("Change Sub Menu");
		list.add("Delete Main Menu");
		list.add("Delete Sub Menu");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(dataAdapter);
		spinner.setOnItemSelectedListener(new SpinnerCustomOnItemSelectedListener());
	}
	public class SpinnerCustomOnItemSelectedListener implements OnItemSelectedListener {
		
		  public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
			if(pos == 0){
				
			}else if (pos == 1){
				
			}else if (pos ==2){
				
			}else if (pos ==3){
				
			}else if (pos ==4){
				
			}else if (pos ==5){
			}
		  }
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.app_configuration, menu);
		return true;
	}
    public boolean onOptionsItemSelected(MenuItem item) 
	{
	    switch (item.getItemId())
	    {
		    case  R.id.sair:
		    	Intent intent = new Intent(getApplicationContext(),Login.class);
		    	startActivity(intent);
	    }
	    return true;
	}
	@Override
	public void onBackPressed()
	{	
		//
	}
}
