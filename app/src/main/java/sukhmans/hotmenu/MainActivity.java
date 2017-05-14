package sukhmans.hotmenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
Button cg;
public static final String filename="Table";
EditText table;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cg=(Button)findViewById(R.id.Done);
		table=(EditText)findViewById(R.id.tableno);
		cg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				 String filename="Table";
		String table1=table.getText().toString();
				FileOutputStream fos;
				try{
				  File myFile = new File("/sdcard/"+filename);
                 myFile.createNewFile();
                  FileOutputStream fOut = new  FileOutputStream(myFile);
                  OutputStreamWriter myOutWriter = new

OutputStreamWriter(fOut);
                  myOutWriter.append(table1);
                  myOutWriter.close();
                  fOut.close();
                  Toast.makeText(getApplicationContext(),filename + "saved",Toast.LENGTH_LONG).show();
			}catch(FileNotFoundException e){e.printStackTrace();}
			catch(IOException e){e.printStackTrace();}
				Intent i= new Intent(MainActivity.this,splash.class);
				startActivity(i);
			}
		});
	}

	

}
