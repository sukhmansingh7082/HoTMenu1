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
import android.widget.CompoundButton;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
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

import static android.widget.CompoundButton.OnCheckedChangeListener;

/**
 * Created by admin on 30-03-2015.
 */
public class americano extends Activity implements OnCheckedChangeListener{
    ImageView pi,cheese,dbcheese;
     RadioButton lar,med,reg;
   private String tab, val=null;
    JSONParser jsonParser = new JSONParser();
    private static String url = "http://192.168.42.76/new/Product.php";
    EditText input;
    private static final String TAG_SUCCESS = "success";
    final Context context=this;
    int flag=0;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizz);
        pi=(ImageView)findViewById(R.id.pill);
        cheese=(ImageView)findViewById(R.id.cheese);
        dbcheese=(ImageView)findViewById(R.id.dbc);
      pi.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              LayoutInflater layoutInflater = LayoutInflater.from(context);

              View promptView = layoutInflater.inflate(R.layout.pizzoi, null);

              AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

              // set prompts.xml to be the layout file of the alertdialog builder
              alertDialogBuilder.setView(promptView);
              lar=(RadioButton)promptView.findViewById(R.id.large);
             // lar.setOnCheckedChangeListener();
              med=(RadioButton)promptView.findViewById(R.id.medium);
              reg=(RadioButton)promptView.findViewById(R.id.regular);
              input=(EditText)promptView.findViewById(R.id.quan);
             lar.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     lar.setChecked(true);
                     med.setChecked(false);
                     reg.setChecked(false);
                 }
             });
            med.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    med.setChecked(true);
                    lar.setChecked(false);
                    reg.setChecked(false);
                }
            });
          reg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  reg.setChecked(true);
                  med.setChecked(false);
                  lar.setChecked(false);
              }
          });
              alertDialogBuilder.setCancelable(false)
                      .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                          public void onClick(DialogInterface dialog, int id) {
                              // get user input and set it to result
                              String filename="Table";
                              String aDataRow = "";
                              String aBuffer = "";
                              try {
                                  File myFile = new File("/sdcard/"+filename);
                                  FileInputStream fIn = new FileInputStream(myFile);
                                  BufferedReader myReader = new BufferedReader(
                                          new InputStreamReader(fIn));

                                  while ((aDataRow = myReader.readLine()) != null) {
                                      aBuffer += aDataRow + "\n";
                                      tab=aBuffer;
                                  }
                                  myReader.close();

                              } catch (IOException e) {
                                  e.printStackTrace();
                              }
                              if (lar.isChecked()) {
                                  val = "Italian L";
                              } else if (med.isChecked()) {
                                  val = "Italian M";
                              } else {
                                  val = "Italian R";
                              }
                              //	Qua.setText(tabu);
                              AlertDialog.Builder alertDialo = new AlertDialog.Builder(americano.this);

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

                                      if (!isOnline(americano.this)) {
                                          Toast.makeText(americano.this, "No network connection", Toast.LENGTH_LONG).show();
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
cheese.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View promptView = layoutInflater.inflate(R.layout.pizzoi, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set prompts.xml to be the layout file of the alertdialog builder
        alertDialogBuilder.setView(promptView);
        lar=(RadioButton)promptView.findViewById(R.id.large);
        // lar.setOnCheckedChangeListener();
        med=(RadioButton)promptView.findViewById(R.id.medium);
        reg=(RadioButton)promptView.findViewById(R.id.regular);
        input=(EditText)promptView.findViewById(R.id.quan);
        lar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lar.setChecked(true);
                med.setChecked(false);
                reg.setChecked(false);
            }
        });
        med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                med.setChecked(true);
                lar.setChecked(false);
                reg.setChecked(false);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg.setChecked(true);
                med.setChecked(false);
                lar.setChecked(false);
            }
        });
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // get user input and set it to result
                        String filename="Table";
                        String aDataRow = "";
                        String aBuffer = "";
                        try {
                            File myFile = new File("/sdcard/"+filename);
                            FileInputStream fIn = new FileInputStream(myFile);
                            BufferedReader myReader = new BufferedReader(
                                    new InputStreamReader(fIn));

                            while ((aDataRow = myReader.readLine()) != null) {
                                aBuffer += aDataRow + "\n";
                                tab=aBuffer;
                            }
                            myReader.close();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (lar.isChecked()) {
                            val = "Capsicum L";
                        } else if (med.isChecked()) {
                            val = "Capsicum M";
                        } else {
                            val = "Capsicum R";
                        }
                        //	Qua.setText(tabu);
                        AlertDialog.Builder alertDialo = new AlertDialog.Builder(americano.this);

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

                                if (!isOnline(americano.this)) {
                                    Toast.makeText(americano.this, "No network connection", Toast.LENGTH_LONG).show();
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
dbcheese.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View promptView = layoutInflater.inflate(R.layout.pizzoi, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set prompts.xml to be the layout file of the alertdialog builder
        alertDialogBuilder.setView(promptView);
        lar=(RadioButton)promptView.findViewById(R.id.large);
        // lar.setOnCheckedChangeListener();
        med=(RadioButton)promptView.findViewById(R.id.medium);
        reg=(RadioButton)promptView.findViewById(R.id.regular);
        input=(EditText)promptView.findViewById(R.id.quan);
        lar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lar.setChecked(true);
                med.setChecked(false);
                reg.setChecked(false);
            }
        });
        med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                med.setChecked(true);
                lar.setChecked(false);
                reg.setChecked(false);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg.setChecked(true);
                med.setChecked(false);
                lar.setChecked(false);
            }
        });
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // get user input and set it to result
                        String filename="Table";
                        String aDataRow = "";
                        String aBuffer = "";
                        try {
                            File myFile = new File("/sdcard/"+filename);
                            FileInputStream fIn = new FileInputStream(myFile);
                            BufferedReader myReader = new BufferedReader(
                                    new InputStreamReader(fIn));

                            while ((aDataRow = myReader.readLine()) != null) {
                                aBuffer += aDataRow + "\n";
                                tab=aBuffer;
                            }
                            myReader.close();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (lar.isChecked()) {
                            val = "Double Cheese L";
                        } else if (med.isChecked()) {
                            val = "Double Cheese M";
                        } else {
                            val = "Double Cheese R";
                        }
                        //	Qua.setText(tabu);
                        AlertDialog.Builder alertDialo = new AlertDialog.Builder(americano.this);

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

                                if (!isOnline(americano.this)) {
                                    Toast.makeText(americano.this, "No network connection", Toast.LENGTH_LONG).show();
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
            pDialog = new ProgressDialog(americano.this);
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
            String order= val;
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
                Toast.makeText(americano.this,"Order Placed Scuccessfully", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


    }
}
