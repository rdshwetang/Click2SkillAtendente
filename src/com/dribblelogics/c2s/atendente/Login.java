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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		Button login = (Button)findViewById(R.id.btnlogin);
		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Login.this,HomeScreen.class);
				startActivity(i);
				overridePendingTransition(R.anim.rotate_out,R.anim.rotate_in);
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
    public boolean onOptionsItemSelected(MenuItem item) 
	{
	    switch (item.getItemId())
	    {
		    case  R.id.config:
		    	AlertDialog.Builder alert = new AlertDialog.Builder(Login.this,AlertDialog.THEME_HOLO_LIGHT);
				alert.setTitle("Accesso Restrito");
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
					    	Intent m1 = new Intent(getApplicationContext(), AppConfiguration.class);
							startActivity(m1);
							finish();
						}
						else
						{
							AlertDialog.Builder alert = new AlertDialog.Builder(Login.this,AlertDialog.THEME_HOLO_LIGHT);
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
				break;
	    }
	    return true;
	}
	@Override
	public void onBackPressed()
	{	
		//
	}
}
