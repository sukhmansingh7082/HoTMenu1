package sukhmans.hotmenu;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Ordery extends Activity{
private List<cars> mycars= new ArrayList<cars>();
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ordery);
		populatecarlist();
		populateListeView();
	}

	private void populatecarlist() {
		// TODO Auto-generated method stub
		mycars.add(new cars("Holl", 1980, R.drawable.paneerb, "Needing"));
	}
	private void populateListeView() {
		// TODO Auto-generated method stub
		ArrayAdapter<cars> adapter = new MyListAdapter();
		ListView list=(ListView)findViewById(R.id.order);
		list.setAdapter(adapter);
	}
	private class MyListAdapter extends ArrayAdapter<cars>{
		public MyListAdapter(){
			super(Ordery.this,R.layout.rowyy,mycars);
		}

		/* (non-Javadoc)
		 * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View item=convertView;
			if(item==null){
				item=getLayoutInflater().inflate(R.layout.rowyy,parent,false);
			}
				cars currentcar=mycars.get(position);
				
				//Get the Image
				ImageView image =(ImageView)item.findViewById(R.id.icon);
				image.setImageResource(currentcar.getIconid());
				//Get the text
				TextView name=(TextView)item.findViewById(R.id.textnam);
				name.setText(currentcar.getMake());
				
				TextView quantity=(TextView)item.findViewById(R.id.textquant);
				quantity.setText("" +currentcar.getYear());
				
				TextView table=(TextView)item.findViewById(R.id.texttab);
				table.setText(currentcar.getCondition());
				return item;
		}
	}
}