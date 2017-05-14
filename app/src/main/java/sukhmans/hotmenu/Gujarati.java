package sukhmans.hotmenu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Gujarati extends Activity {
    Button open, sab, roti, daal, ric, etc;

    /* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guj);
        open = (Button) findViewById(R.id.Op);
        sab = (Button) findViewById(R.id.shak);
        roti = (Button) findViewById(R.id.Roti);
        daal = (Button) findViewById(R.id.Daal);
        ric = (Button) findViewById(R.id.Rice);
        etc = (Button) findViewById(R.id.etc);
        Typeface typo = Typeface.createFromAsset(getAssets(), "madness.ttf");
        sab.setTypeface(typo);
        roti.setTypeface(typo);
        daal.setTypeface(typo);
        ric.setTypeface(typo);
        etc.setTypeface(typo);


        open.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                try {

                    sab.setVisibility(View.VISIBLE);
                    roti.setVisibility(View.VISIBLE);
                    daal.setVisibility(View.VISIBLE);
                    ric.setVisibility(View.VISIBLE);
                    etc.setVisibility(View.VISIBLE);
                    open.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG).show();

                }
            }
        });
sab.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
Intent io=new Intent(Gujarati.this,gSab.class);
        startActivity(io);
    }
});
        daal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oi=new Intent(Gujarati.this,gDaal.class);
                startActivity(oi);

            }
        });
ric.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent lo= new Intent(Gujarati.this,gRice.class);
        startActivity(lo);
    }
});
        roti.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lol= new Intent(Gujarati.this,Roti.class);
                startActivity(lol);
            }
        });
    }
}