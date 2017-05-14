package sukhmans.hotmenu;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by admin on 21-03-2015.
 */
public class feedback extends Activity {
    EditText maill,commentt;
    private automail m;
    Button email;
    int flag=0;
    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();
    private static String url = "http://192.168.42.76/new/feedback.php";
    private static final String TAG_SUCCESS = "success";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedbck);

        commentt=(EditText)findViewById(R.id.comm);
          email=(Button)findViewById(R.id.button);
        m=new automail("sukhmansingh18@gmail.com","boeinga380");
     email.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

          final EditText maill=(EditText)findViewById(R.id.mail);
             final String email = maill.getText().toString();
             if (!isValidEmail(email)) {
                 maill.setError("Invalid Email");
             }
             else{
                 new loginAccess();
             }


         }
     });

    }

    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    class loginAccess extends AsyncTask<String,String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(feedback.this);
            pDialog.setMessage("Saving your feedback...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
        @Override
        protected String doInBackground(String... arg0) {
            // TODO Auto-generated method stub
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            //String comment= sab;
            String from=maill.getText().toString();
            String comment=commentt.getText().toString();
            params.add(new BasicNameValuePair("from", from));
            params.add(new BasicNameValuePair("comment", comment));
//            params.add(new BasicNameValuePair("quantity",quantity));

            JSONObject json = jsonParser.makeHttpRequest(url,"POST", params);

            Log.d("Create Response", json.toString());

            try {
                int success = json.getInt(TAG_SUCCESS);
                if (success == 1)
                {
                    flag=0;

                     Intent i = new Intent(getApplicationContext(),Choice.class);
                    // i.putExtra("mobile_number",tableno);
                    //  i.putExtra("password",orderno);
                    startActivity(i);
                    finish();

                }
                else
                {
                    // failed to Sign in

                    flag=1;
                }
            } catch (JSONException e) {
                Log.e("log_tag", "Error in http connection" + e.toString());
                //e.printStackTrace();
            }


            return null;
        }
        protected void onPostExecute(String file_url) {
            pDialog.dismiss();
            if(flag==0)
                Toast.makeText(feedback.this,"Thank you for your feedback", Toast.LENGTH_LONG).show();

        }
    }
    }
