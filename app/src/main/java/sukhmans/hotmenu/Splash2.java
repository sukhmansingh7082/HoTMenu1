package sukhmans.hotmenu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash2 extends Activity{
TextView wel,namoo,main1;
ImageView welo,arr;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash2);
		wel=(TextView)findViewById(R.id.well);
		namoo=(TextView)findViewById(R.id.name);
		welo=(ImageView)findViewById(R.id.welcom);
		arr=(ImageView)findViewById(R.id.arr);
		main1=(TextView)findViewById(R.id.maintitle);
		Typeface main=Typeface.createFromAsset(getAssets(), "suk5.TTF");
		Typeface typo=Typeface.createFromAsset(getAssets(), "madness.ttf");
		wel.setTypeface(typo);
		main1.setTypeface(main);
		namoo.setTypeface(typo);
		Bundle bundle = getIntent().getExtras();
		//Extract thde data�
		String stuff = bundle.getString("Stuff"); 
		namoo.setText(stuff);
		namoo.startAnimation((Animation)AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce));
		welo.startAnimation((Animation) AnimationUtils.loadAnimation(getApplicationContext(), R.animator.clocki));
		arr.startAnimation((Animation)AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce));
		main1.startAnimation((Animation)AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadehoout));
		 Thread background = new Thread() {
	            public void run() {
	                 
	                try {
	                    // Thread will sleep for 5 seconds
	                    sleep(5*1000);
	                     
	                    // After 5 seconds redirect to another intent
	                    Intent i=new Intent(getBaseContext(),Choice.class);
	                    startActivity(i);
	                     
	                    //Remove activity
	                    finish();
	                     
	                } catch (Exception e) {
	                 
	                }
	            }
	        };
	         
	        // start thread
	        background.start();
	}

}
