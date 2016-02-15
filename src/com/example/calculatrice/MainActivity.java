package com.example.calculatrice;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

import com.example.calculatrice.*;
public class MainActivity extends ActionBarActivity implements OnClickListener {
private Button b=null;
private TextView txt=null;
private float v1,v2,rslt=0;
private EditText e1=null,e2=null;
private RadioGroup rg=null;
private RadioButton rb=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      b=(Button)findViewById(R.id.calculer);
      b.setOnClickListener(this);
       
    }
    
    public void onClick(View v)
    {
    		
    	txt=(TextView)findViewById(R.id.resultat);
    	e1=(EditText)findViewById(R.id.valeur1);
    	e2=(EditText)findViewById(R.id.valeur2);
    	
		if(e1.getText().length()>0 && e2.getText().length()>0)
		{
    	v1=Float.valueOf(e1.getText().toString());
		v2=Float.valueOf(e2.getText().toString());
	
    		rg=(RadioGroup)findViewById(R.id.operation);
    		rb=(RadioButton)findViewById(rg.getCheckedRadioButtonId());
    		
    		if(rb.getText().equals("+"))
             rslt=v1+v2;
    		else if(rb.getText().equals("-"))
    		{
    		rslt=(v1>v2)?(v1-v2):(v2-v1);
    		}
    		else if(rb.getText().equals("/"))
    		{
    		rslt=(v2==0)?0:(v1/v2);
    		}
    		else if(rb.getText().equals("x"))
    		{
    		rslt=v1*v2;
    		}
    		
    		txt.setText("Le resultat est :"+rslt);
    		 Toast.makeText(MainActivity.this, "Le resultat est : "+rslt, Toast.LENGTH_SHORT).show();
    		}
    		else 
    			{Toast.makeText(MainActivity.this, "Remplissez les champs svp", Toast.LENGTH_SHORT).show();
		         txt.setText("Entrez les valeurs et cliquez sur -Calculer-");}
    	
    }


    

}
