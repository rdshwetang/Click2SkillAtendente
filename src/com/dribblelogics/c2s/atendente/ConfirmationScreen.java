/* 
 * @author Shwetang R.D 
 * Visual Sistemas Electronicos Ltda.
 * Belo Horizonte-Brazil -2014
 */
package com.dribblelogics.c2s.atendente;

import com.dribblelogics.c2s.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ConfirmationScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.confirmation_screen);
	}
	@Override
	public void onBackPressed()
	{	
		//
	}

}
