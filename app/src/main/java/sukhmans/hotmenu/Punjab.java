package sukhmans.hotmenu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Punjab extends Activity{
	Button sab,rot,ric,dal;

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pun);
		sab=(Button)findViewById(R.id.Sabji);
		rot=(Button)findViewById(R.id.Roti);
		ric=(Button)findViewById(R.id.Rice);
		dal=(Button)findViewById(R.id.Daal);
		Typeface yogesh= Typeface.createFromAsset(getAssets(), "madness.ttf");
		sab.setTypeface(yogesh);
		Typeface suk= Typeface.createFromAsset(getAssets(), "madness.ttf");
		rot.setTypeface(suk);
		Typeface het=Typeface.createFromAsset(getAssets(), "madness.ttf");
		ric.setTypeface(het);
		Typeface dall=Typeface.createFromAsset(getAssets(), "madness.ttf");
		dal.setTypeface(dall);
		sab.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i= new Intent(Punjab.this,Sabjior.class);
				startActivity(i);
			}
		});
		rot.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i= new Intent(Punjab.this,Roti.class);
				startActivity(i);
			}
		});
		sab.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(Punjab.this,Sabjior.class);
				startActivity(i);
			}
		});
		ric.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(Punjab.this,Rice.class);
				startActivity(i);
			}
		});
		dal.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(Punjab.this,Daal.class);
				startActivity(i);
			}
		});
	}

}
