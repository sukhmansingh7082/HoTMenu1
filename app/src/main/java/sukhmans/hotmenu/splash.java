package sukhmans.hotmenu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends Activity{
ImageView l;
TextView lt,tt,mn,name,mob;
EditText nam,mo;
ImageButton menuu;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spash);
		l=(ImageView)findViewById(R.id.cook);
		mn=(TextView)findViewById(R.id.textView2);
		lt=(TextView)findViewById(R.id.textnam);
		menuu=(ImageButton)findViewById(R.id.menu);
		nam=(EditText)findViewById(R.id.namo);
		mo=(EditText)findViewById(R.id.mob);
		mob=(TextView)findViewById(R.id.mobile);
		name=(TextView)findViewById(R.id.name);
		tt=(TextView)findViewById(R.id.t);
		Typeface typeFace = Typeface.createFromAsset(getAssets(), "g.ttf");
		mn.setTypeface(typeFace);
		Typeface typeFace1 = Typeface.createFromAsset(getAssets(), "madness.ttf");
		Typeface typeFace2 = Typeface.createFromAsset(getAssets(), "Amadeus.ttf");
		name.setTypeface(typeFace2);
		
		lt.setTypeface(typeFace1);
		tt.setTypeface(typeFace1);
		mob.setTypeface(typeFace2);
		lt.startAnimation((Animation)AnimationUtils.loadAnimation(getApplicationContext(),R.anim.nn));
		tt.startAnimation((Animation)AnimationUtils.loadAnimation(getApplicationContext(),R.anim.nn));
		Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.clocki);
		rotation.setFillAfter(true);
		l.startAnimation(rotation);
		menuu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				
				
				String namm= nam.getText().toString();
				Intent ii= new Intent(splash.this,Splash2.class);
				Bundle bundle = new Bundle();
				
				bundle.putString("Stuff", namm);
				ii.putExtras(bundle);
										startActivity(ii);
			}
		});
	}

}
