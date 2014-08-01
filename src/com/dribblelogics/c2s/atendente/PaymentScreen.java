/* 
 * @author Shwetang R.D 
 * Visual Sistemas Electronicos Ltda.
 * Belo Horizonte-Brazil -2014
 */
package com.dribblelogics.c2s.atendente;

import com.dribblelogics.c2s.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;

public class PaymentScreen extends Activity {
	ProgressDialog pd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.payment_screen);
		pd = new ProgressDialog(getApplicationContext());
		pd.setTitle("Detecting Payment Options");
		pd.show();
		pd.setCancelable(false);
	}
	@Override
	public void onBackPressed()
	{	
		pd.dismiss();
	}
}
