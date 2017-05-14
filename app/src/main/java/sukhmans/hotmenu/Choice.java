package sukhmans.hotmenu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Choice extends Activity {
Button pun,guj,chin,piz;
TextView nhot,nmenu;

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choice);
		pun=(Button)findViewById(R.id.punjab);
		guj=(Button)findViewById(R.id.guj);
		chin=(Button)findViewById(R.id.chino);
		piz=(Button)findViewById(R.id.pizza);
		nhot=(TextView)findViewById(R.id.nHot);
		nmenu=(TextView)findViewById(R.id.nMenu);
		Typeface typo=Typeface.createFromAsset(getAssets(), "madness.ttf");
		pun.setTypeface(typo);
		Typeface typo1=Typeface.createFromAsset(getAssets(), "suk5.TTF");
	guj.setTypeface(typo1);
	Typeface typo2=Typeface.createFromAsset(getAssets(), "g.ttf");
chin.setTypeface(typo2);
Typeface typo3=Typeface.createFromAsset(getAssets(), "Amadeus.ttf");
piz.setTypeface(typo3);
nhot.setTypeface(typo);
nmenu.setTypeface(typo);
nhot.startAnimation((Animation)AnimationUtils.loadAnimation(getApplicationContext(),R.anim.nn));
nmenu.startAnimation((Animation)AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce));
		pun.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Choice.this,Punjab.class);
				startActivity(i);
				
				
			}
		});
		guj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent p = new Intent(Choice.this,Gujarati.class);
				startActivity(p);
			}
		});
		chin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent ch=new Intent(Choice.this,Chinese.class);
				startActivity(ch);
			}
		});
        piz.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent ch=new Intent(Choice.this,americano.class);
                startActivity(ch);
            }
        });
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cv, menu);

        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.feedback:
                Intent In= new Intent(Choice.this,feedback.class);
                startActivity(In);
                return true;

            case R.id.action_help:
                // help action
                return true;
            case R.id.action_check_updates:
                // check for updates action
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
