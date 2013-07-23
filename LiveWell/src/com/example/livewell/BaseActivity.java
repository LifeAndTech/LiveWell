package com.example.livewell;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class BaseActivity extends Activity 
{
	// Shared Preferences
	public static final String SETTINGS_PREFS = "SETTINGS PREFS";
	public static final String SETTINGS_PREFS_WEIGHT = "CURRENT WEIGHT";
	public static final String SETTINGS_PREFS_GOAL = "GOAL WEIGHT";
	public static final String SETTINGS_PREFS_GENDER = "GENDER";
	public static final String SETTINGS_PREFS_EXERCISE = "TYPICAL EXERCISE";

	public boolean onCreateOptionsMenu(Menu menu)
	{
		super.onCreateOptionsMenu(menu); // ask super to create Option menu
		
		getMenuInflater().inflate(R.menu.main, menu); // use getMenuInflater to inflate the menu items
		
		menu.findItem(R.id.menuitem_home).setIntent(new Intent(this, MainActivity.class)); // find options in menu with Intent to open OptionsActivity
		
		return true;
	}

}
