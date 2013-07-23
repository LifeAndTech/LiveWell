package com.example.livewell;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity 
{
	private Button toCalories, toCalendar, inspiration, toPaleo;
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		addListenerOnButton();
	}
	
	public void addListenerOnButton()
	{
		toCalories = (Button)findViewById(R.id.btn_calories);
		toCalendar = (Button)findViewById(R.id.btn_calendar);
		inspiration = (Button)findViewById(R.id.btn_inspiration);
		toPaleo = (Button)findViewById(R.id.btn_paleo);
		
		toCalories.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				// get button name
				String name = toCalories.getText().toString().trim();
				
				if(name.equals("Calories"))
				{
					startActivity(new Intent(MainActivity.this, Profile.class));
				}
				else
				{
					Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
				}
			}
		}
		);
		
		toCalendar.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				// get button name
				String name = toCalendar.getText().toString().trim();
				
				if(name.equals("Calendar"))
				{
					startActivity(new Intent(MainActivity.this, Calendar.class));
				}
				else
				{
					Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
				}
			}
		}
		);
		
		inspiration.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				// get button name
				String name = inspiration.getText().toString().trim();
				
				if(name.equals("Inspiration"))
				{
					Toast.makeText(MainActivity.this, "Diet is the only game where you win when you lose!",
							Toast.LENGTH_SHORT).show();
					//startActivity(new Intent(MainActivity.this, Profile.class));
				}
				else
				{
					Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
				}
			}
		}
		);
		
		toPaleo.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				// get button name
				String name = toPaleo.getText().toString().trim();
				
				if(name.equals("Paleo Check"))
				{
					Toast.makeText(MainActivity.this, "Paleo Check feature will be available soon.", Toast.LENGTH_SHORT).show();
					//startActivity(new Intent(MainActivity.this, PaleoCheck.class));
				}
				else
				{
					Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
				}
			}
		}
		);
	}
	

}
