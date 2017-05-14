package sukhmans.hotmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Daal extends Activity{
ImageView Urad,Fry,Chana;
    JSONParser jsonParser = new JSONParser();
    private static String url = "http://192.168.42.76/new/Product.php";
    private static final String TAG_SUCCESS = "success";
    final Context context = this;
    int flag=0;
    private ProgressDialog pDialog;
    private String tab,quant,sab;
    private EditText input,moree;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.urad);
        Urad=(ImageView)findViewById(R.id.Urad);
        Fry=(ImageView)findViewById(R.id.fry);
        Chana=(ImageView)findViewById(R.id.chana);
        Urad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);

                View promptView = layoutInflater.inflate(R.layout.prompts, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                // set prompts.xml to be the layout file of the alertdialog builder
                alertDialogBuilder.setView(promptView);

                input = (EditText) promptView.findViewById(R.id.userInput);
                moree = (EditText) promptView.findViewById(R.id.more);
                // quant= input.getText().toString();

                sab = "Urad Daal";                // setup a dialog window
                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // get user input and set it to result


                                String filename = "Table";
                                String aDataRow = "";
                                String aBuffer = "";
                                try {
                                    File myFile = new File("/sdcard/" + filename);
                                    FileInputStream fIn = new FileInputStream(myFile);
                                    BufferedReader myReader = new BufferedReader(
                                            new InputStreamReader(fIn));

                                    while ((aDataRow = myReader.readLine()) != null) {
                                        aBuffer += aDataRow + "\n";
                                        tab = aBuffer;
                                    }
                                    myReader.close();

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                //	Qua.setText(tabu);
                                AlertDialog.Builder alertDialo = new AlertDialog.Builder(Daal.this);

                                // Setting Dialog Title
                                alertDialo.setTitle("Confirm Your Order...");

                                // Setting Dialog Message
                                alertDialo.setMessage("Please note,Once you place the order you cannot change it. You are sure you want to place this order ?");

                                // Setting Icon to Dialog
                                alertDialo.setIcon(R.drawable.l);

                                // Setting Positive "Yes" Button
                                alertDialo.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {

                                        // Write your code here to invoke YES event
                                        new loginAccess().execute();


                                        if (!isOnline(Daal.this)) {
                                            Toast.makeText(Daal.this, "No network connection", Toast.LENGTH_LONG).show();
                                            return;
                                        }

                                    }

                                    private boolean isOnline(Context mContext) {
                                        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
                                        NetworkInfo netInfo = cm.getActiveNetworkInfo();
                                        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                                            return true;
                                        }
                                        return false;
                                    }

                                });

                                // Setting Negative "NO" Button
                                alertDialo.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Write your code here to invoke NO event

                                        dialog.cancel();
                                    }
                                });

                                // Showing Alert Message
                                alertDialo.show();

                            }

                        })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();

                                    }
                                });

                // create an alert dialog
                AlertDialog alertD = alertDialogBuilder.create();

                alertD.show();

            }
        });
        Chana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);

                View promptView = layoutInflater.inflate(R.layout.prompts, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                // set prompts.xml to be the layout file of the alertdialog builder
                alertDialogBuilder.setView(promptView);

                input = (EditText) promptView.findViewById(R.id.userInput);
                moree = (EditText) promptView.findViewById(R.id.more);
                // quant= input.getText().toString();

                sab = "Chana Dal";                // setup a dialog window
                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // get user input and set it to result


                                String filename = "Table";
                                String aDataRow = "";
                                String aBuffer = "";
                                try {
                                    File myFile = new File("/sdcard/" + filename);
                                    FileInputStream fIn = new FileInputStream(myFile);
                                    BufferedReader myReader = new BufferedReader(
                                            new InputStreamReader(fIn));

                                    while ((aDataRow = myReader.readLine()) != null) {
                                        aBuffer += aDataRow + "\n";
                                        tab = aBuffer;
                                    }
                                    myReader.close();

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                //	Qua.setText(tabu);
                                AlertDialog.Builder alertDialo = new AlertDialog.Builder(Daal.this);

                                // Setting Dialog Title
                                alertDialo.setTitle("Confirm Your Order...");

                                // Setting Dialog Message
                                alertDialo.setMessage("Please note,Once you place the order you cannot change it. You are sure you want to place this order ?");

                                // Setting Icon to Dialog
                                alertDialo.setIcon(R.drawable.l);

                                // Setting Positive "Yes" Button
                                alertDialo.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {

                                        // Write your code here to invoke YES event
                                        new loginAccess().execute();


                                        if (!isOnline(Daal.this)) {
                                            Toast.makeText(Daal.this, "No network connection", Toast.LENGTH_LONG).show();
                                            return;
                                        }

                                    }

                                    private boolean isOnline(Context mContext) {
                                        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
                                        NetworkInfo netInfo = cm.getActiveNetworkInfo();
                                        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                                            return true;
                                        }
                                        return false;
                                    }

                                });

                                // Setting Negative "NO" Button
                                alertDialo.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Write your code here to invoke NO event

                                        dialog.cancel();
                                    }
                                });

                                // Showing Alert Message
                                alertDialo.show();

                            }

                        })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();

                                    }
                                });

                // create an alert dialog
                AlertDialog alertD = alertDialogBuilder.create();

                alertD.show();

            }
        });
        Fry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);

                View promptView = layoutInflater.inflate(R.layout.prompts, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                // set prompts.xml to be the layout file of the alertdialog builder
                alertDialogBuilder.setView(promptView);

                input = (EditText) promptView.findViewById(R.id.userInput);
                moree = (EditText) promptView.findViewById(R.id.more);
                // quant= input.getText().toString();

                sab = "Dal Fry";                // setup a dialog window
                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // get user input and set it to result


                                String filename = "Table";
                                String aDataRow = "";
                                String aBuffer = "";
                                try {
                                    File myFile = new File("/sdcard/" + filename);
                                    FileInputStream fIn = new FileInputStream(myFile);
                                    BufferedReader myReader = new BufferedReader(
                                            new InputStreamReader(fIn));

                                    while ((aDataRow = myReader.readLine()) != null) {
                                        aBuffer += aDataRow + "\n";
                                        tab = aBuffer;
                                    }
                                    myReader.close();

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                //	Qua.setText(tabu);
                                AlertDialog.Builder alertDialo = new AlertDialog.Builder(Daal.this);

                                // Setting Dialog Title
                                alertDialo.setTitle("Confirm Your Order...");

                                // Setting Dialog Message
                                alertDialo.setMessage("Please note,Once you place the order you cannot change it. You are sure you want to place this order ?");

                                // Setting Icon to Dialog
                                alertDialo.setIcon(R.drawable.l);

                                // Setting Positive "Yes" Button
                                alertDialo.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {

                                        // Write your code here to invoke YES event
                                        new loginAccess().execute();


                                        if (!isOnline(Daal.this)) {
                                            Toast.makeText(Daal.this, "No network connection", Toast.LENGTH_LONG).show();
                                            return;
                                        }

                                    }

                                    private boolean isOnline(Context mContext) {
                                        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
                                        NetworkInfo netInfo = cm.getActiveNetworkInfo();
                                        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                                            return true;
                                        }
                                        return false;
                                    }

                                });

                                // Setting Negative "NO" Button
                                alertDialo.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Write your code here to invoke NO event

                                        dialog.cancel();
                                    }
                                });

                                // Showing Alert Message
                                alertDialo.show();

                            }

                        })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();

                                    }
                                });

                // create an alert dialog
                AlertDialog alertD = alertDialogBuilder.create();

                alertD.show();

            }
        });
	}
    class loginAccess extends AsyncTask<String,String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Daal.this);
            pDialog.setMessage("Placing Your Order...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
        @Override
        protected String doInBackground(String... arg0) {
            // TODO Auto-generated method stub
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            String tableno= tab;
            String moor=moree.getText().toString();
            String order= sab + moor;
            String quantity=input.getText().toString();


            params.add(new BasicNameValuePair("tableno", tableno));
            params.add(new BasicNameValuePair("order", order));
            params.add(new BasicNameValuePair("quantity",quantity));

            JSONObject json = jsonParser.makeHttpRequest(url,"POST", params);

            Log.d("Create R esponse", json.toString());

            try {
                int success = json.getInt(TAG_SUCCESS);
                if (success == 1)
                {
                    flag=0;

                    // Intent i = new Intent(getApplicationContext(),Sabjior.class);
                    // i.putExtra("mobile_number",tableno);
                    //  i.putExtra("password",orderno);
                    //startActivity(i);
                    //finish();

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
                Toast.makeText(Daal.this, "Order Placed Scuccessfully", Toast.LENGTH_LONG).show();

        }
    }
}
